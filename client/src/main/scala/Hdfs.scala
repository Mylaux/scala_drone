import org.apache.spark.{SparkConf, SparkContext}
import org.apache.spark.rdd._
import DroneUtils._

object Hdfs {

	val path = "drones"
	val conf = new SparkConf().setAppName("Drone Infos")
								  .setMaster("local[*]")

	val sc = SparkContext.getOrCreate(conf)

	def LoadData(): RDD[Drone] = {
		sc.textFile(path)
		  .flatMap(StringToDrone)
	}

	def DroneByTemperature() : RDD[(Int, Iterable[Drone])] = {
		val drones = LoadData()
		drones.groupBy(_.temperature)
	}

	def PrintRdd(rdd: RDD[_], nbLines: Int) : Unit = {
		rdd.take(nbLines).foreach(println)
	}

	def Stop(): Unit = sc.stop()
}