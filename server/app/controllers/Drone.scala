package controllers

case class Drone(id: Int,
                 is_working: Boolean,
                 latitude: String,
                 longitude: String,
                 temperature: Int,
                 battery: Int,
                 weight: Int,
                 is_occupied: Boolean)

object Drone {
  import play.api.libs.json._

  implicit object DroneFormat extends Format[Drone] {

    // convert from JSON string to a Stock object (de-serializing from JSON)
    def reads(json: JsValue): JsResult[Drone] = {
      val id = (json \ "id").as[Int]
      val is_working = (json \ "is_working").as[Boolean]
      val latitude = (json \ "latitude").as[String]
      val longitude = (json \ "longitude").as[String]
      val temperature = (json \ "temperature").as[Int]
      val battery = (json \ "battery").as[Int]
      val weight = (json \ "weight").as[Int]
      val is_occupied = (json \ "is_occupied").as[Boolean]
      JsSuccess(Drone(id, is_working, latitude, longitude, temperature, battery, weight, is_occupied))
    }

    // convert from Stock object to JSON (serializing to JSON)
    def writes(d : Drone): JsValue = {
      // JsObject requires Seq[(String, play.api.libs.json.JsValue)]
      val droneAsList = Seq("id" -> JsNumber(d.id),
        "is_working" ->JsBoolean(d.is_working),
        "latitude" -> JsString(d.latitude),
        "longitude" -> JsString(d.longitude),
        "temperature" -> JsNumber(d.temperature),
        "battery" -> JsNumber(d.battery),
        "weight" -> JsNumber(d.weight),
        "is_occupied" -> JsBoolean(d.is_occupied))
      JsObject(droneAsList)
    }
  }
}