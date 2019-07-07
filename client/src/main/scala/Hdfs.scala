import org.apache.spark._
import org.apache.spark.streaming._
import org.apache.spark.rdd._
import DroneUtils._
import Simulation._

object Hdfs {

	val path = "drones"
	val batchInterval = Seconds(1)

	val hostname = "localhost"
	val port = "9000"

	val conf = new SparkConf().setAppName("Drone Simulation")
							  .setMaster("local[*]")

	val sc  = SparkContext.getOrCreate(conf)
	val ssc = new StreamingContext(sc, batchInterval)


	def LoadData(): RDD[Drone] = {
		sc.textFile(path)
		  .flatMap(StringToDrone)
	}

	def processNewFile(rdd: RDD[Drone]): Unit = {
		rdd.repartition(1).saveAsTextFile(path + "drone" + 223.toString + ".json")
    }

	def StreamData() : Unit = {
		ssc.sparkContext.setLogLevel("ERROR")

		val directoryStream = ssc.textFileStream(path)
	    /*directoryStream.foreachRDD{ rdd => {
	    	if(rdd.count()>0)
	    	{
	    		val df=rdd.toDF("id", "vals")
	    		.write(SaveMode.Append).save(path + "/2")
	    	}
	    }}*/
		ssc.start()
		ssc.awaitTermination()
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