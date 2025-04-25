package com.dalarionit.healthkit4s.models

import io.circe.Codec

import java.time.LocalDate

final case class StepEntry(
                          date: LocalDate,
                          steps: Int
                          ) derives Codec
