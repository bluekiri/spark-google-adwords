package com.bluekiri.google.adwords.v201708

import org.apache.spark.sql.sources.DataSourceRegister

class DefaultSource15 extends DefaultSource with DataSourceRegister {
  override def shortName(): String = "google-adwords"
}
