package com.dalarionit.healthkit4s

import cats.effect.IO
import cats.effect.unsafe.implicits.global
import com.dalarionit.healthkit4s.api.DummyHealthKitClient
import org.scalatest.funsuite.AnyFunSuite

import java.time.LocalDate

class HealthKitClientSpec extends AnyFunSuite {

  val client = new DummyHealthKitClient[IO]

  test("fetchSteps should return a list of StepEntry") {
    val today = LocalDate.now()

    val result = client.fetchSteps(today).unsafeRunSync()

    assert(result.nonEmpty)
    assert(result.size == 2)
    assert(result.head.date == today)
  }

  test("fetchSteps should return an empty list for a future date") {
    val futureDate = LocalDate.now().plusDays(2)

    val result = client.fetchSteps(futureDate).unsafeRunSync()

    assert(result.isEmpty)
  }
}
