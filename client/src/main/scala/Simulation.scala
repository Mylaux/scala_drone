import scala.io.Source
import scalaj.http._
import java.io.File
import DroneUtils._
import Hdfs._

object Simulation {

	val nb = 10
	val path = "drones/"
	val batchtime = 1000

	def sendJsonString(s: String): Any = {
		val req = Http("http://localhost:9000/saveDrone").postData(s).header("Content-type", "application/json").asString.code
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

	
	def init(): Unit = {
		val drones = generateMultipleDrones(nb, Nil)
		drones.foreach{drone => writeToFile(path, drone)}
	}	


	def run(): Unit = {
		while(true) {
			val rdd  = loadData("drones")
			val nrdd = rdd.map(drone => updateDrone(drone))
			nrdd.collect().foreach{drone => writeToFile(path, drone)}
			sendToServer(path)
			Thread.sleep(batchtime)
		}
	}
}