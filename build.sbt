lazy val baseName   = "SyntaxPane"
lazy val baseNameL  = baseName.toLowerCase
lazy val gitHost    = "codeberg.org"
lazy val gitUser    = "sciss"
lazy val gitRepo    = baseName

lazy val projectVersion = "1.2.1"
lazy val mimaVersion    = "1.2.0"  // for comparison wrt binary compatibility

// sonatype plugin requires that these are in global
ThisBuild / version       := projectVersion
ThisBuild / organization  := "de.sciss"
ThisBuild / versionScheme := Some("pvp")

lazy val commonSettings = Seq(
  name             := baseName,
  description      := "An extension of Java Swing's JEditorKit that supports syntax highlighting for several languages.",
  homepage         := Some(url(s"https://$gitHost/$gitUser/$gitRepo")),
  licenses         := Seq("Apache 2.0 License" -> url("http://www.apache.org/licenses/LICENSE-2.0.txt")),
  scalaVersion     := "2.13.8",  // not used
  crossPaths       := false,     // this is just a Java project right now!
  autoScalaLibrary := false,
  Compile / mainClass := Some("de.sciss.syntaxpane.SyntaxTester"),
  Compile / compile / javacOptions ++= Seq("-g", "-source", "1.8", "-target", "1.8"),
  run / fork := true,
  mimaPreviousArtifacts := Set("de.sciss" % baseNameL % mimaVersion)
)

lazy val root = project.in(file("."))
  .settings(commonSettings)
  .settings(publishSettings)
  .settings(SbtJFlexPlugin.jflexSettings)

// ---- publishing ----

lazy val publishSettings = Seq(
  publishMavenStyle := true,
  Test / publishArtifact := false,
  pomIncludeRepository := { _ => false },
  developers := List(
    Developer(
      id    = "sciss",
      name  = "Hanns Holger Rutz",
      email = "contact@sciss.de",
      url   = url("https://www.sciss.de")
    )
  ),
  scmInfo := {
    val h = gitHost
    val a = s"$gitUser/$gitRepo"
    Some(ScmInfo(url(s"https://$h/$a"), s"scm:git@$h:$a.git"))
  },
)
