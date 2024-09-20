import sbt.Keys.{libraryDependencies, licenses, name}

ThisBuild / organization := "com.github.fernandoracca"

ThisBuild / scalaVersion := "2.12.20"

val myScriptedSettings = Seq(
  scriptedLaunchOpts += s"-Dproject.version=${version.value}"
  )

val defaultSettings = Seq(
  scalacOptions ++= List(
    "-unchecked",
    "-deprecation",
    "-language:_",
    "-encoding", "UTF-8"
    ),

  publishConfiguration := {
    val javaVersion = System.getProperty("java.specification.version")
    if (scala.util.Try { "1.7".toDouble }.toOption.exists( _ <= 1.8) )
      throw new RuntimeException("Cancelling publish, please a more recent JDK than 1.8")
    publishConfiguration.value
  },

  libraryDependencies += Dependencies.jol,
  libraryDependencies += Dependencies.jolCli,
  libraryDependencies += Dependencies.scriptedPlugin
  )

lazy val root = (project in file("."))
  .settings(defaultSettings: _*)
  .enablePlugins(SbtPlugin)
  .settings(myScriptedSettings: _*)
  .settings(
    name := "sbt-jol",
    sbtPlugin := true,
    scalaVersion := "2.12.20",
    scalacOptions ++= List(
      "-unchecked",
      "-deprecation",
      "-language:_",
      "-target:jvm-1.8",
      "-encoding", "UTF-8"
      ),
    publishMavenStyle := false,
    licenses += ("Apache-2.0", url("http://www.apache.org/licenses/LICENSE-2.0.html")),
   )

   //jvmPlatform(scalaVersions = Seq("2.13.14", "2.12.20"))
