package com.example

import spray.json._


case class EmailData(subject: String, content: String)

object EmailDataJsonProtocol extends DefaultJsonProtocol {
  implicit val emailDataFormat = jsonFormat2(EmailData)
}

