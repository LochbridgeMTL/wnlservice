package com.example

import spray.json._

case class MQMessage(jobseekerId: String)

object MQMessageJsonProtocol extends DefaultJsonProtocol {
  implicit val mqMessageFormat = jsonFormat1(MQMessage)
}
