package com.dalarionit.healthkit4s.api

import cats.effect.Sync
import com.dalarionit.healthkit4s.models.StepEntry

import java.time.LocalDate

trait HealthKitClient[F[_]] {
  def fetchSteps(date: LocalDate): F[List[StepEntry]]
}

class DummyHealthKitClient[F[_]: Sync] extends HealthKitClient[F] {

  override def fetchSteps(date: LocalDate): F[List[StepEntry]] =
    Sync[F].delay {
      if (date.isAfter(LocalDate.now())) {
        List.empty
      } else {
        List(
          StepEntry(date, 1000),
          StepEntry(date.minusDays(1), 2000),
        )
      }
    }
}
