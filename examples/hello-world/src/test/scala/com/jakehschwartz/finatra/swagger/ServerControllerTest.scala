package com.jakehschwartz.finatra.swagger

import com.twitter.finagle.http.Status
import com.twitter.finatra.http.EmbeddedHttpServer

class ServerControllerTest extends SampleAppBaseTest {

  override lazy val server: EmbeddedHttpServer = makeServer(
    serverName = "serverControllerTest")

  test("sampleController: min annotations should work") {
    server.httpPost(
      "/students/1",
      """{
        |"first_name": "Test",
        |"last_name": "Test",
        |"gender": "Male",
        |"birthday": "2020-01-01",
        |"grade": 0,
        |"emails": []
        |}""".stripMargin,
      andExpect = Status.BadRequest
    )

    server.httpPost(
      "/students/1",
      """{
        |"first_name": "Test",
        |"last_name": "Test",
        |"gender": "Male",
        |"birthday": "2020-01-01",
        |"grade": 20,
        |"emails": []
        |}""".stripMargin,
      andExpect = Status.BadRequest
    )
  }
}
