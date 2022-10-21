package controllers

import org.scalatestplus.play._
import org.scalatestplus.play.guice._
import play.api.libs.json.Json
import play.api.test._
import play.api.test.Helpers._

class HelloControllerSpec extends PlaySpec with GuiceOneAppPerTest {

  "HelloController GET" must {
    "acccess /hello with GET method" in {
      val request = FakeRequest(GET, "/hello")
      val response = route(app, request).get

      status(response) mustBe OK
      contentType(response) mustBe Some("text/plain")
      contentAsString(response) mustBe "Hello World"
    }
  }

  "HelloController POST" must {

    "access /hello with POST method" in {
      val request = FakeRequest(POST, "/hello")
      val response = route(app, request).get

      status(response) mustBe OK
      contentType(response) mustBe Some("application/json")
      contentAsString(response) mustBe Json.obj(
        "hello"    -> "world",
        "language" -> "scala"
      )
    }
  }
}
