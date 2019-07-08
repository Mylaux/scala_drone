import play.api.libs.json.{JsError, JsSuccess, Json}

object AgregUtils {
	
	case class Agregation(
		nb_failures: Int,
		nb_clients:  Int
	)

	implicit val agregWrites = Json.writes[Agregation]

	def agregToJson(agreg: Agregation) : String = Json.toJson(agreg).toString
}