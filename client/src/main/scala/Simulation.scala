import DroneUtils._


object Simulation {
	val nb = 10
	val path = "drones/"

	def Init(): Unit = {
		val drones = GenerateMultipleDrones(nb, Nil)
		drones.foreach{drone => WriteToFile(path, drone)}
	}	


	/*def run(): Unit = {
		while(true) {

		}
	}*/
}