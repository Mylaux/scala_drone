import scala.util.Random
import play.api.libs.json.{JsError, JsSuccess, Json}
import java.io._

object DroneUtils {
	
	case class Drone(
		id: 		 Int,
		latitude: 	 String,
		longitude:	 String,
		temperature: Int,
		battery:     Int,
		weight:      Int

	)

	implicit val droneFormat = Json.format[Drone]
	implicit val droneWrites = Json.writes[Drone]

	val r = new Random
	
	val coordinates = Seq('N', 'W', 'E','S')
	val weight  = 1000
	val battery = 100

	def StringToDrone(str: String) : TraversableOnce[DroneUtils.Drone] = Json.parse(str).validate[Drone] match {
		case JsError(e) 	=> None
		case JsSuccess(t, _) => Some(t)
	}

	def GenerateDrone(id:Int) : Drone = {

		// Randomise the Drone
		val latitude_r1  = r.nextInt(90)
		val latitude_r2  = r.nextInt(60)
		val latitude_r3  = r.nextInt(59)
 		val latitude_c   = coordinates(r.nextInt(coordinates.length))

		val longitude_r1 = r.nextInt(90)
		val longitude_r2 = r.nextInt(60)
		val longitude_r3 = r.nextInt(59)
		val longitude_c  = coordinates(r.nextInt(coordinates.length))

		val temperature = latitude_c match {
			case 'N' => 100
			case _   => -10
		}

		Drone(
			id          = id, 
			latitude    = latitude_r1  + "°" + latitude_r2  + "'" + latitude_r3  + latitude_c,
			longitude   = longitude_r1 + "°" + longitude_r2 + "'" + longitude_r3 + longitude_c,
			temperature = temperature,
			battery     = battery,
			weight      =  weight
		)
	}

	def GenerateMultipleDrones(nb: Int, list: List[Drone]) : List[Drone] = nb match {
		case 0     => list
		case nb    => GenerateMultipleDrones(nb - 1, GenerateDrone(nb)::list)
	}

	def WriteToFile(pathDir: String, drone:Drone) : Unit = {
		val dir = new File(pathDir)
		if (! dir.exists())
			dir.mkdir()
		val pathToFile = pathDir + "drone" + drone.id.toString + ".json"
		val json = Json.toJson(drone)
		val pw = new PrintWriter(new File(pathToFile))
		pw.write(json.toString)
		pw.close
	}


	/*def createJson(path:String, drone:Drone) = {

	}*/
}