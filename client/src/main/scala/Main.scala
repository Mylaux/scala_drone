import Simulation._
import Hdfs._

object Main {

	def main(args: Array[String]): Unit = {
		/*if (args.length < 2) {
			System.err.println("Usage: NetworkWordCount <hostname> <port>")
			System.exit(1)
		}*/
		init
		run


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