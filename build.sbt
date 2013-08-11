name := "picklebuffer-example"

version := "0.1-reading"

organization := "com.julianpeeters"

scalaVersion := "2.10.2"

resolvers ++= Seq(
  "sonatype" at "https://oss.sonatype.org/content/groups/public",
  "Sonatype OSS Snapshots" at "https://oss.sonatype.org/content/repositories/snapshots"
)

libraryDependencies ++= Seq( 
  "org.scala-lang" % "scala-library" % "2.10.2",
  "org.scala-lang" % "scala-compiler" % "2.10.2"
)

