package controllers

import javax.inject.Inject
import play.api.mvc._

@Singleton
class ApplicationController @Inject()(cc: ControllerComponents) extends AbstractController(cc) {
  def create()
}
