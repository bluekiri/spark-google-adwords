# Spark Google AdWords Library

A library for querying Google AdWords data with Apache Spark, for Spark SQL and DataFrames.

## Requirements

This library requires Spark 1.4+

## Linking
You can link against this library in your program at the following coordinates:

```
groupId: com.bluekiri
artifactId: spark-google-adwords_2.11
version: 3.15.1.1.0-SNAPSHOT
```

## Features
This package allows querying Google AdWords reports as [Spark DataFrames](https://spark.apache.org/docs/latest/sql-programming-guide.html).
The API accepts several options (see the [Google AdWords developer docs](https://developers.google.com/adwords/api/docs/guides/start) for details):

### Scala API
__Spark 1.4+:__

Add your ```ads.properties``` file to resources.

Create a DataFrame from an AdWords report:
```scala
import org.apache.spark.sql.SQLContext

val sqlContext = new SQLContext(sc)
val df = sqlContext.read
    .format("com.bluekiri.google.adwords.v201806")
    .option("reportType", "SHOPPING_PERFORMANCE_REPORT")
    .option("during", "LAST_30_DAYS")
    .load()
```

## Building From Source
This library is built with [SBT](http://www.scala-sbt.org/0.13/docs/Command-Line-Reference.html). To build a JAR file simply run `sbt assembly` from the project root. The build configuration includes support for both Scala 2.10 and 2.11.
