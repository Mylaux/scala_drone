package controllers

case class Drone(id: Int, latitude: String, longitude: String, temperature: Int, battery: Int, weight: Int)

object Drone {
  import play.api.libs.json._
  implicit object DroneFormat extends Format[Drone] {

    // convert from JSON string to a Stock object (de-serializing from JSON)
    def reads(json: JsValue): JsResult[Drone] = {
      val id = (json \ "id").as[Int]
      val latitude = (json \ "latitude").as[String]
      val longitude = (json \ "longitude").as[String]
      val temperature = (json \ "temperature").as[Int]
      val battery = (json \ "battery").as[Int]
      val weight = (json \ "weight").as[Int]
      JsSuccess(Drone(id, latitude, longitude, temperature, battery, weight))
    }

    // convert from Stock object to JSON (serializing to JSON)
    def writes(d : Drone): JsValue = {
      // JsObject requires Seq[(String, play.api.libs.json.JsValue)]
      val droneAsList = Seq("id" -> JsNumber(d.id),
        "latitude" -> JsString(d.latitude),
        "longitude" -> JsString(d.longitude),
        "temperature" -> JsNumber(d.temperature),
        "battery" -> JsNumber(d.battery),
        "weight" -> JsNumber(d.weight))
      JsObject(droneAsList)
    }
  }
}