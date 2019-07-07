import scala.util.Random
import play.api.libs.json.{JsError, JsSuccess, Json}
import java.io._

object DroneUtils {
	
	case class Drone(
		id: 		 Int,
		is_working:  Boolean,
		latitude: 	 String,
		longitude:	 String,
		temperature: Int,
		battery:     Int,
		weight:      Int,
		is_occupied: Boolean

	)

	implicit val droneFormat = Json.format[Drone]
	implicit val droneWrites = Json.writes[Drone]

	val r = new Random
	
	val coordinates = Seq('N', 'W', 'E','S')
	val weight  = 1000
	val battery = 100

	def stringToDrone(str: String) : TraversableOnce[DroneUtils.Drone] = Json.parse(str).validate[Drone] match {
		case JsError(e) 	 => None
		case JsSuccess(t, _) => Some(t)
	}

	def generateDrone(id:Int) : Drone = {

		// Randomise the Drone
		val is_working   = true

		val latitude_r1  = r.nextInt(90)
		val latitude_r2  = r.nextInt(60)
		val latitude_r3  = r.nextInt(59)
 		val latitude_c   = coordinates(r.nextInt(coordinates.length))

		val longitude_r1 = r.nextInt(90)
		val longitude_r2 = r.nextInt(60)
		val longitude_r3 = r.nextInt(59)
		val longitude_c  = coordinates(r.nextInt(coordinates.length))

		val cold_r = r.nextInt(15) - 10
		val hot_r  = r.nextInt(25) + 10

		val temperature = latitude_r1 match {
			case x if x > 60 => cold_r
			case _           => hot_r
		}

		val is_occupied = false

		Drone(
			id          = id,
			is_working  = is_working,
			latitude    = latitude_r1  + "°" + latitude_r2  + "'" + latitude_r3  + latitude_c,
			longitude   = longitude_r1 + "°" + longitude_r2 + "'" + longitude_r3 + longitude_c,
			temperature = temperature,
			battery     = battery,
			weight      = weight,
			is_occupied = is_occupied
		)
	}

	def generateMultipleDrones(nb: Int, list: List[Drone]) : List[Drone] = nb match {
		case 0     => list
		case nb    => generateMultipleDrones(nb - 1, generateDrone(nb)::list)
	}

	def updateCoord(coord: String): String = {
		val coords = coord.split("[°']")
		val coord_1 = coords(0).toInt + r.nextInt(3) - 1
		val coord_2 = coords(1).toInt + r.nextInt(3) - 1
		coord_1.toString  + "°" + coord_2.toString  + "'" + coords(2)
	}

	def updateDrone(drone: Drone) : Drone = {

		val is_working_r  = r.nextInt(100)
		val is_working    = is_working_r match {
			case x if x < 2 | drone.battery < 5 => false
			case _                              => true
		}

		val latitudep = is_working match {
			case true => updateCoord(drone.latitude)
			case _    => drone.latitude
		}

		val longitudep = is_working match {
			case true => updateCoord(drone.longitude)
			case _    => drone.longitude
		}



		val is_occupied_r = r.nextInt(100)
		val is_occupied   = (drone.is_occupied, is_occupied_r, is_working) match {
			case (_, _, false)            => false
			case (false, x, _) if x < 10  => true
			case (true,  x, _) if x < 20  => false
			case _ => drone.is_occupied 
		}

		val weight_r      = 40 + r.nextInt(70)
		val weightp       = (is_occupied, drone.weight) match {
			case (true, 1000) => drone.weight + weight_r
			case (false, _)   => weight
			case _            => drone.weight
		}

		val battery_loss  = r.nextInt(2)
		val batteryp      = drone.battery match {
			case x if x > -5 & x < 1 => battery
			case _                   => drone.battery - battery_loss
		}

		val temperature_r = r.nextInt(3) - 1
		val temperature   = drone.temperature + temperature_r  
		Drone(
			id          = drone.id,
			is_working  = is_working,
			latitude    = latitudep,
			longitude   = longitudep,
			temperature = temperature,
			battery     = batteryp,
			weight      = weightp,
			is_occupied = is_occupied
		)
	}

	def writeToFile(pathDir: String, drone:Drone) : Unit = {
		val dir = new File(pathDir)
		if (! dir.exists())
			dir.mkdir()
		val pathToFile = pathDir + "drone" + drone.id.toString + ".json"
		val json = Json.toJson(drone)
		val pw = new PrintWriter(new File(pathToFile))
		pw.write(json.toString)
		pw.close
	}
}