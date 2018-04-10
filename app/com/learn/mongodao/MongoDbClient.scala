package com.learn.mongodao

import org.mongodb.scala.MongoClient

object MongoDbClient {

  //Package private
  private[mongodao] val client = MongoClient()
}
