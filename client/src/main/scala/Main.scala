import scala.io.Source
import scalaj.http._
import java.io.File
import Simulation._
import Hdfs._

object Main {

	def getListOfFiles(dir: String):List[File] = {
		val d = new File(dir)
		if (d.exists && d.isDirectory) {
			d.listFiles.filter(_.isFile).toList
		} else {
			List[File]()
		}
	}

	def sendJsonString(s: String): Any = {
		val req = Http("http://localhost:9000/saveDrone").postData(s).header("Content-type", "application/json").asString.code
	}


	def main(args: Array[String]): Unit = {
		/*if (args.length < 2) {
			System.err.println("Usage: NetworkWordCount <hostname> <port>")
			System.exit(1)
		}*/
		Init
		StreamData
		Stop 

		/*val files = getListOfFiles("drones")

		val json_paths = files.filter(f => """.*\.json$""".r.findFirstIn(f.getName).isDefined)
		val json_lines = json_paths.flatMap(Source.fromFile(_ , "UTF-8").getLines())
		json_lines.map(println)
		json_lines.map(sendJsonString).toList*/


/*
		val csv_paths = paths.filter(f => """.*\.csv$""".r.findFirstIn(f.getName).isDefined)
		val csv_lines = csv_paths.flatMap(Source.fromFile(_ , "UTF-8").getLines())
		//csv_lines.map(println)
		val test = csv_paths
			.map(x => new csvParser(x))
			.map(x => x.map(x => sendJsonString(Drone.DroneFormat.writes(x).toString())))
			*/
	}
}