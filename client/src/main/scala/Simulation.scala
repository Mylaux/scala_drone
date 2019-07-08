import scala.io.Source
import scalaj.http._
import java.io.File
import AgregUtils._
import DroneUtils._
import Hdfs._

object Simulation {

	val batchtime = 1000

	def sendJsonString(s: String): Any = {
		val req = Http("http://localhost:9000/saveDrone").postData(s).header("Content-type", "application/json").asString.code
	}

	def sendValuesToServer(s: String): Any = {
		val req = Http("http://localhost:9000/saveValues").postData(s).header("Content-type", "application/json").asString.code
	}

	def getListOfFiles(dir: String):List[File] = {
		val d = new File(dir)
		if (d.exists && d.isDirectory) {
			d.listFiles.filter(_.isFile).toList
		} else {
			List[File]()
		}
	}

	def sendToServer(path: String): Unit = {
		val files = getListOfFiles(path)
		val json_paths = files.filter(f => """.*\.json$""".r.findFirstIn(f.getName).isDefined)
		val json_lines = json_paths.flatMap(Source.fromFile(_ , "UTF-8").getLines())
		json_lines.map(println)
		json_lines.map(sendJsonString).toList
	}

	def init(nb: Int, path: String): Unit = {
		val paths = path match {
			case x if x.takeRight(1) == '/' => x
			case x => x + "/"
		}
		val drones = generateMultipleDrones(nb, Nil)
		drones.foreach{drone => writeToFile(paths, drone)}
	}


	def run(path:String): Unit = {
		val paths = path match {
			case x if x.takeRight(1) == '/' => x
			case x => x + "/"
		}

		while(true) {
			val rdd  = loadData(paths)
			val nrdd = rdd.map(drone => updateDrone(drone))

			val nb_failure =  nrdd.filter(d => d.is_working == false).count().toInt 
			val nb_clients =  nrdd.filter(d => d.is_occupied == true).count().toInt


			nrdd.collect().foreach{drone => writeToFile(paths, drone)}

			val agreg  = Agregation(nb_failure, nb_clients)
			val values = agregToJson(agreg)

			sendToServer(path)
			sendValuesToServer(values)

			Thread.sleep(batchtime)
		}
	}
}
