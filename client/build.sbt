name := "taxi_drone"

version := "1.0"

scalaVersion := "2.12.8"

dependencyOverrides += "com.fasterxml.jackson.core" % "jackson-databind" % "2.6.7"

libraryDependencies += "org.apache.spark" %% "spark-core" % "2.4.0"
libraryDependencies += "org.scalatest" %% "scalatest" % "3.0.5"
libraryDependencies += "com.typesafe.play" %% "play-json" % "2.7.2"
libraryDependencies +=  "org.scalaj" %% "scalaj-http" % "2.4.1"