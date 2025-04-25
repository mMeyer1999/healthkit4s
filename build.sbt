ThisBuild / scalaVersion := "3.3.5"

lazy val root = (project in file("."))
  .settings(
    name := "healthkit4s",
    version := "0.1.0",
    libraryDependencies ++= Seq(
        "org.typelevel" %% "cats-core" % "2.13.0",
        "org.typelevel" %% "cats-effect" % "3.6.1",
        "io.circe" %% "circe-generic" % "0.14.13",
        "io.circe" %% "circe-parser" % "0.14.13",
        "org.scalatest" %% "scalatest" % "3.2.19" % Test
    )
  )
