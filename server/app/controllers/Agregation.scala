package controllers

case class Agregation(
                    nb_failures: Int,
                    nb_clients: Int
                      )

object Agregation {
  import play.api.libs.json._

  implicit object AgregationFormat extends Format[Agregation] {

    // convert from JSON string to a Stock object (de-serializing from JSON)
    def reads(json: JsValue): JsResult[Agregation] = {
      val nb_failures = (json \ "nb_failures").as[Int]
      val nb_clients  = (json \ "nb_clients").as[Int]
      JsSuccess(Agregation(nb_failures, nb_clients))
    }

    // convert from Stock object to JSON (serializing to JSON)
    def writes(a : Agregation): JsValue = {
      // JsObject requires Seq[(String, play.api.libs.json.JsValue)]
      val agregationAsList = Seq(
        "nb_failures" -> JsNumber(a.nb_failures),
        "nb_clients"  -> JsNumber(a.nb_clients))
      JsObject(agregationAsList)
    }
  }
}
