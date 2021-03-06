name := """PlayMonogoScala"""
organization := "com.learn"

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayScala)

scalaVersion := "2.12.4"

libraryDependencies += guice
libraryDependencies += "org.scalatestplus.play" %% "scalatestplus-play" % "3.1.2" % Test

libraryDependencies += "org.scalaz" %% "scalaz-core" % "7.2.18"
libraryDependencies += "org.mongodb.scala" %% "mongo-scala-driver" % "2.2.0"

// Adds additional packages into Twirl
//TwirlKeys.templateImports += "com.learn.controllers._"

// Adds additional packages into conf/routes
// play.sbt.routes.RoutesKeys.routesImport += "com.learn.binders._"
