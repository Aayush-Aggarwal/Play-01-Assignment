package controllers

import javax.inject._

import akka.util.ByteString
import play.api._
import play.api.http.HttpEntity
import play.api.mvc._

/**
 * This controller creates an `Action` to handle HTTP requests to the
 * application's home page.
 */
@Singleton
class HomeController extends Controller{

  /**
   * Create an Action to render an HTML page.
   *
   * The configuration in the `routes` file means that this method
   * will be called when the application receives a `GET` request with
   * a path of `/`.
   */
  def index() = Action { implicit request: Request[AnyContent] =>
    Ok("okkkkkkkk")
   }

  def defaultAction()= Action { implicit request: Request[AnyContent] =>
    Result(
      header = ResponseHeader(200)/*, Map(CONTENT_TYPE -> "text/plain")*/,
      body = HttpEntity.Strict(ByteString("Hi play"), Some("text/plain"))
    )
  }

  def plainTextAction()= Action { implicit request: Request[AnyContent] =>
    Result(
      header = ResponseHeader(200, Map(CONTENT_TYPE -> "text/plain")),
      body = HttpEntity.Strict(ByteString("Hi this is plain text"), Some("text/plain"))
    )
  }

  def htmlTextAction()= Action { implicit request: Request[AnyContent] =>
    Result(
      header = ResponseHeader(200,Map(CONTENT_TYPE->"text /html")),
      body=HttpEntity.Strict(ByteString("This is html page"),Some("text /html"))
    )
  }

  def redirectAction()= Action { implicit request: Request[AnyContent] =>
    Redirect(routes.HomeController.plainTextAction()).flashing("message" -> "Success")
  }

}