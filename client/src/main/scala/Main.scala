import Simulation._
import Hdfs._

object Main {

	def errUsage(msg: String) : Unit = {
		System.err.println(msg)
		System.exit(1)
	}

	def main(args: Array[String]): Unit = {
		args match {
			case x if x.length == 0 => errUsage("Usage: init <nb_Drones> <path> | run")
				case x if x(0) == "start" => run
			case x if x(0) == "init" & x.length != 2 => errUsage("Usage: init <nb_Drones>")
			case x if x(0) == "init" & x(1).toInt < 0 => errUsage("<nb_Drones> must be positive")
			case x if x(0) == "init" => init(x(1).toInt)
			case x => println(x(0))
		}

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