package com.example

import java.io.InputStream

import akka.actor.Actor
import spray.routing._
import spray.http._
import MediaTypes._


// we don't implement our route structure directly in the service actor because
// we want to be able to test it independently, without having to spin up an actor
class MyServiceActor extends Actor with MyService {

  // the HttpService trait defines only one abstract member, which
  // connects the services environment to the enclosing actor or test
  def actorRefFactory = context

  // this actor only runs our route, but you could add
  // other things here, like request stream processing
  // or timeout handling
  def receive = runRoute(myRoute)
}


// this trait defines our service behavior independently from the service actor
trait MyService extends HttpService {
  import EmailDataJsonProtocol._
  import spray.httpx.SprayJsonSupport._
  import spray.json._

  val myRoute =
    path("") {
      get {
        respondWithMediaType(`text/html`) { // XML is marshalled to `text/xml` by default, so we simply override here
          complete {
            <html>
              <body>
                <h1>Welcome to the Wednesday News Letter service!</h1>
              </body>
            </html>
          }
        }
      }
    } ~
    path("getsubject"){
      getFromResource("wnl/template.sub")
    } ~
    path("getcontent"){
      getFromResource("wnl/wnl_content.csv")
    } ~
    path("getwnl") {
      get {
        respondWithMediaType(`application/json`){
          val subject = scala.io.Source.fromInputStream( getClass.getResourceAsStream("/wnl/template.sub")).mkString
          val content = scala.io.Source.fromInputStream( getClass.getResourceAsStream("/wnl/wnl_content.csv")).mkString
          complete(EmailData(subject, content))
        }
      }
    }
}