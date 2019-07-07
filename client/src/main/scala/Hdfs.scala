import org.apache.spark._
import org.apache.spark.streaming._
import org.apache.spark.rdd._
import DroneUtils._
import Simulation._

object Hdfs {

	val hostname = "localhost"
	val port = "9000"

	val conf = new SparkConf().setAppName("Drone Simulation")
							  .setMaster("local[*]")
		val sc  = SparkContext.getOrCreate(conf)


	def loadData(path: String): RDD[Drone] = {
		sc.textFile(path)
		  .flatMap(stringToDrone)
	}

	def droneByTemperature() : RDD[(Int, Iterable[Drone])] = {
		val drones = loadData("drones")
		drones.groupBy(_.temperature)
	}

	def printRdd(rdd: RDD[_], nbLines: Int) : Unit = {
		rdd.collect().foreach(println)
	}

	def stop(): Unit = sc.stop()
}