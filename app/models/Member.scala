package models

import play.api.db._
import play.api.Play.current

import anorm._
import anorm.SqlParser._

case class Member(id: Long, name: String, email: String)

object Member {

  def allMembers(memberName:String):List[Member] = {
    DB.withConnection { implicit connection =>
      SQL("""select * from """ + memberName).as(simple *)
    }
  }

  def simple() = {
      get[Long]("id") ~
      get[String]("name") ~
      get[String]("email") map {
      case id ~ name ~ email => Member(id, name, email)
    }
  }

}
