import sbt._
import sbt.Keys._

object Ex1Build extends Build {


  lazy val ex1 = Project(
    id = "Algorithm",
    base = file("."),
    settings = Project.defaultSettings ++ Seq(
      name := "ex1",
      organization := "Mapek",
      version := "0.1-SNAPSHOT",
      scalaVersion := "2.10.2",
      libraryDependencies += "org.scalatest" % "scalatest_2.10" % "1.9.1" % "test"
      // add other settings here
    )
  )
}
