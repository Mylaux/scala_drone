import scala.io.Source
import scalaj.http._
import java.io.File

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
		val paths = args.flatMap(getListOfFiles)

		val json_paths = paths.filter(f => """.*\.txt$""".r.findFirstIn(f.getName).isDefined)
		val json_lines = json_paths.flatMap(Source.fromFile(_ , "UTF-8").getLines())
		//json_lines.map(println)

		json_lines.map(sendJsonString).toList

		val csv_paths = paths.filter(f => """.*\.csv$""".r.findFirstIn(f.getName).isDefined)
		val csv_lines = csv_paths.flatMap(Source.fromFile(_ , "UTF-8").getLines())
		//csv_lines.map(println)
	}
}