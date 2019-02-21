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

libraryDependencies ++= Seq(
  "com.github.nechaevv.isomorphic" %%% "isomorphic-core" % isomorphicVersion, ///_sjs0.6_2.12/0.1-SNAPSHOT
  //      "io.circe" %%% "circe-core"    % circeVersion,
  "io.circe" %%% "circe-generic" % circeVersion,
  //      "io.circe" %%% "circe-parser"  % circeVersion,
  "com.github.julien-truffaut" %%%  "monocle-core"  % monocleVersion,
  "com.github.julien-truffaut" %%%  "monocle-macro" % monocleVersion,
  "com.github.julien-truffaut" %%%  "monocle-law"   % monocleVersion % "test"
)
scalacOptions ++= Seq("-P:scalajs:sjsDefinedByDefault", "-feature", "-deprecation")

addCompilerPlugin("org.scalamacros" % "paradise" % "2.1.0" cross CrossVersion.full)

scalaJSOutputMode := OutputMode.ECMAScript6

scalaJSModuleKind := ModuleKind.CommonJSModule

scalaJSLinkerConfig := scalaJSLinkerConfig.value.withRelativizeSourceMapBase(
  Some((artifactPath in (Compile, fastOptJS)).value.toURI))
