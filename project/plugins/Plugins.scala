import sbt._

class Plugins(info: ProjectInfo) extends PluginDefinition(info) {

  lazy val sbtIdea = "com.github.mpeltonen" % "sbt-idea-plugin" % "0.2.0"
  lazy val akkaPlugin = "se.scalablesolutions.akka" % "akka-sbt-plugin" % "1.0"
  lazy val scalate_plugin = "org.fusesource.scalate" % "sbt-scalate-plugin" % "1.4.0"
  val sbtIdeaRepo = "sbt-idea-repo" at "http://mpeltonen.github.com/maven/"
  val akkaRepo = "Akka Repo" at "http://akka.io/repository"
}