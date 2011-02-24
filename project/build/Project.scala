import sbt._

class Project(info: ProjectInfo) extends DefaultWebProject(info) with IdeaProject with AkkaProject {

  lazy val scalaTest = "org.scalatest" % "scalatest" % "1.3" % "test"
  lazy val scalateCore = "org.fusesource.scalate" % "scalate-core" % "1.4.0"
  lazy val scalateSpringMVC = "org.fusesource.scalate" % "scalate-spring-mvc" % "1.4.0"
  lazy val scalatraScalate = "org.scalatra" %% "scalatra-scalate" % "2.0.0.M2"
  lazy val casbah = "com.mongodb.casbah" %% "casbah" % "2.0.3"
  lazy val salat = "com.novus" %% "salat" % "0.0.5"
  lazy val akkaStm = akkaModule("stm")
  lazy val junit = "junit" % "junit" % "4.8.2" % "test"
  lazy val springVersion = "3.0.5.RELEASE"
  lazy val springCore = "org.springframework" % "spring-core" % springVersion
  lazy val springContext = "org.springframework" % "spring-context" % springVersion
  lazy val springContextSupport = "org.springframework" % "spring-context-support" % springVersion
  lazy val springWeb = "org.springframework" % "spring-web" % springVersion
  lazy val springWebServlet = "org.springframework" % "spring-webmvc" % springVersion
  lazy val sfl4japi = "org.slf4j" % "slf4j-api" % "1.6.1" % "runtime"
  lazy val logback = "ch.qos.logback" % "logback-classic" % "0.9.27"
  lazy val jetty6 = "org.mortbay.jetty" % "jetty" % "6.1.26" % "test"
  lazy val servletApi = "javax.servlet" % "servlet-api" % "2.5" % "provided"
  val scalaToolsSnapshots = "Scala Tools Repository snapshot" at "http://nexus.scala-tools.org/content/repositories/snapshots/"
  val scalaTools = "Scala Tools Repository snapshot" at "http://nexus.scala-tools.org/content/repositories/public/"
  val novusRels = "repo.novus rels" at "http://repo.novus.com/releases/"
  val sonatypeNexusReleases = "Sonatype Nexus Releases" at "https://oss.sonatype.org/content/repositories/releases"
  val springSourceRelease =  "com.springsource.repository.bundles.release" at "http://repository.springsource.com/maven/bundles/release"
  val springSourceReleaseExternal =  "com.springsource.repository.bundles.external" at "http://repository.springsource.com/maven/bundles/external"
}