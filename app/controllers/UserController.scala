package controllers

import java.util.Date

import com.learn.dao.UserService
import com.learn.model.User
import javax.inject.Inject
import play.api.mvc._
import scala.concurrent.ExecutionContext.Implicits.global

class UserController @Inject() (cc: ControllerComponents, userService: UserService)
  extends AbstractController(cc) {

  def create = Action.async { req =>
    val random = new Date().toString
    val user = User(s"sumit@$random.com", random)
    userService.create(user).map({
      case Left(err) => Ok("It not worked! $err")
      case Right(b) =>  Ok(s"It works! created User $user")
    }
    )
  }

  def delete = Action {
    Ok("It works!")
  }

  def update = Action {
    Ok("It works!")
  }

  def find = Action {
    Ok("It works!")
  }


}