name := "spark-google-adwords"

version := "3.7.0.1.0-SNAPSHOT"

organization := "com.bluekiri"

crossScalaVersions := Seq("2.11.10", "2.10.6")

scalaVersion := crossScalaVersions.value.head

spName := "bluekiri/spark-google-adwords"

sparkVersion := "2.1.0"

val testSparkVersion = settingKey[String]("The version of Spark to test against.")

testSparkVersion := sys.props.get("spark.testVersion").getOrElse(sparkVersion.value)

sparkComponents := Seq("core", "sql")

libraryDependencies ++= Seq(
  "com.google.api-ads" % "ads-lib" % "3.7.0",
  "com.google.api-ads" % "adwords-axis" % "3.7.0"
)

// This is necessary because of how we explicitly specify Spark dependencies
// for tests rather than using the sbt-spark-package plugin to provide them.
spIgnoreProvided := true

publishMavenStyle := true

spAppendScalaVersion := true

spIncludeMaven := true

credentials += Credentials(Path.userHome / ".sbt" / "credentials" / "myget")

publishTo := Some("MyGet - java" at "https://logitravel.myget.org/F/java/maven/")

isSnapshot <<= version { v =>
  if (v.endsWith("SNAPSHOT")) true else false
}

// Skip tests during assembly
test in assembly := {}

assemblyShadeRules in assembly := Seq(
  ShadeRule.rename("org.slf4j.**" -> "shaded.@0").inAll,
  ShadeRule.rename("com.google.**" -> "shaded.@0").inAll
)

addArtifact(artifact in(Compile, assembly), assembly)
