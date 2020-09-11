package io.taig.scala.graal

import cats.effect.{ExitCode, IO, IOApp}
import org.http4s.{HttpRoutes, Response}
import org.http4s.Status
import org.http4s.implicits._
import org.http4s.server.blaze.BlazeServerBuilder

import scala.concurrent.ExecutionContext

object App extends IOApp {
  override def run(args: List[String]): IO[ExitCode] = {
    val routes = HttpRoutes.pure(Response[IO](Status.Ok).withEntity("¡Hola mundo!"))

    BlazeServerBuilder[IO](ExecutionContext.global)
      .bindHttp(host = "0.0.0.0", port = 8080)
      .withHttpApp(routes.orNotFound)
      .serve
      .compile
      .lastOrError
  }
}
