enablePlugins(AssemblyPlugin)

description := "Sample Scala/Graal native-image application"

libraryDependencies ++=
  "org.http4s" %% "http4s-blaze-server" % "0.21.7" ::
  "org.slf4j" % "slf4j-simple" % "1.7.30" ::
  "org.scalameta" % "svm-subs" % "101.0.0" ::
  Nil

name := "scala-graal"

organization := "io.taig"

scalaVersion := "2.13.3"