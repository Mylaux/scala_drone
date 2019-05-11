package controllers

import javax.inject._
import play.api._
import play.api.mvc._
import play.api.libs.json.Json

/**
 * This controller creates an `Action` to handle HTTP requests to the
 * application's home page.
 */

class HomeController @Inject()(cc: ControllerComponents) extends AbstractController(cc) {

  /**
   * Create an Action to render an HTML page.
   *
   * The configuration in the `routes` file means that this method
   * will be called when the application receives a `GET` request with
   * a path of `/`.
   */

  val drones = scala.collection.mutable.MutableList[Drone]()

  def index() = Action { implicit request: Request[AnyContent] =>
    Ok(views.html.index(drones))
  }

  def saveDrone = Action { request =>
    println("Post request received")
    val json = request.body.asJson.get
    val drone = json.as[Drone]

    if (drones.map(_.id).contains(drone.id)) {
      drones(drones.indexWhere(_.id == drone.id)) = drone
    }
    else {
      drones.++=(List(drone))
    }
    println(drones)
    Ok
  }
}
