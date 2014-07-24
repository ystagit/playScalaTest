package controllers

import play.api.mvc._
import models.Member


object Application extends Controller {

  def index = Action {
    Ok(views.html.index("Your new application is ready."))
  }

  def memberDetail(memberName:String) = Action {
    Ok(views.html.member(Member.allMembers(memberName)))
  }
}