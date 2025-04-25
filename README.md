# healthkit4s

A lightweight, functional Scala client for interacting with (mocked) Apple HealthKit data.

## Features
- Pure functional API (`F[_]`)
- StepEntry model ready
- Dummy client for local testing
- Future-ready for real HealthKit integration

## Usage

```scala
val client = new DummyHealthKitClient[IO]
val steps = client.fetchSteps(LocalDate.now()).unsafeRunSync()
steps.foreach(println)
