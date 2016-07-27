
// Project name (artifact name in Maven)
name := "betweenrgb"

version := "1.0-SNAPSHOT"

// project description
description := "Between RGB"

// library dependencies. (orginization name) % (project name) % (version)
libraryDependencies ++= Seq(
  // https://mvnrepository.com/artifact/org.apache.commons/commons-math3
  "org.apache.commons" % "commons-math3" % "3.6.1",
  "org.fluentd" % "fluent-logger" % "0.2.10",
  "org.mockito" % "mockito-core" % "1.9.5" % "test"  // Test-only dependency
)