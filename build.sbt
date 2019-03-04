import org.scalajs.core.tools.linker.backend.OutputMode
import sbtcrossproject.CrossPlugin.autoImport.crossProject

enablePlugins(ScalaJSPlugin)

name := "app"

organization := "com.github.paniov.biread"

version := "0.1-SNAPSHOT"

scalaVersion := "2.12.8"

val catsVersion       = "1.2.0"
val fs2Version        = "1.0.3"
val circeVersion      = "0.11.1"
val monocleVersion    = "1.5.1-cats"
val isomorphicVersion = "0.1-SNAPSHOT"
val json4sVersion     = "3.6.5"

libraryDependencies ++= Seq(
  "com.github.nechaevv.isomorphic" %%% "isomorphic-core" % isomorphicVersion,
  "com.github.julien-truffaut" %%%  "monocle-core"  % monocleVersion,
  "com.github.julien-truffaut" %%%  "monocle-macro" % monocleVersion,
  "com.github.julien-truffaut" %%%  "monocle-law"   % monocleVersion % "test",
  "io.circe" %%% "circe-generic" % circeVersion,
  "org.json4s" %% "json4s-jackson" % json4sVersion,
  "org.scalactic" %% "scalactic" % "3.0.5",
  "org.scalatest" %% "scalatest" % "3.0.5" % "test"

)

scalacOptions ++= Seq("-P:scalajs:sjsDefinedByDefault", "-feature", "-deprecation")

addCompilerPlugin("org.scalamacros" % "paradise" % "2.1.0" cross CrossVersion.full)

scalaJSOutputMode := OutputMode.ECMAScript6

scalaJSModuleKind := ModuleKind.CommonJSModule

scalaJSLinkerConfig := scalaJSLinkerConfig.value.withRelativizeSourceMapBase(
  Some((artifactPath in (Compile, fastOptJS)).value.toURI))

logBuffered in Test := false
