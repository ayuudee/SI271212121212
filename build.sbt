scalaVersion in ThisBuild := "2.11.7"

javacOptions ++= Seq(
  "-source", "1.8",
  "-target", "1.8"
)
scalacOptions ++= Seq(
  "-unchecked",
  "-deprecation",
  "-Xlint",
  "-Xfatal-warnings",
  "-feature",
  "-Ywarn-dead-code",
  "-Ywarn-unused-import",
  "-Xmax-classfile-name", "128")

libraryDependencies ++= Seq(
  "org.typelevel" %% "cats"      % "0.6.0",
  "org.scalatest" %% "scalatest" % "2.2.0" % Test
)
