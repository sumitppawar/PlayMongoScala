package com.learn.mongodao

import com.learn.dao.UserService
import com.learn.model.User
import javax.inject.Singleton
import org.bson.codecs.configuration.CodecRegistries.{fromProviders, fromRegistries}
import org.mongodb.scala.{Completed, MongoCollection, MongoDatabase}
import org.mongodb.scala.bson.codecs.DEFAULT_CODEC_REGISTRY
import org.mongodb.scala.bson.codecs.Macros._
import org.mongodb.scala.model.Filters._
import scala.concurrent.ExecutionContext.Implicits.global

import scala.concurrent.Future

@Singleton
class MongoUserService() extends UserService {
  private val mongoDatabase: MongoDatabase = MongoDbClient.client.getDatabase("Earth")
    .withCodecRegistry(fromRegistries(fromProviders(classOf[User]), DEFAULT_CODEC_REGISTRY))

  private val collection: MongoCollection[User]= mongoDatabase.getCollection("users")

  override def create(user: User): Future[Either[String, Boolean]] =
    collection.insertOne(user)
      .toFuture
      .map(c => Right(true))
      .recoverWith({case _ => Future(Left(s"Not able to insert user $user"))})

  override def delete(email: String): Future[Either[String, Boolean]] =
    collection.deleteOne(equal("_id", email))
      .toFuture
      .map{result =>
        if(result.getDeletedCount == 1)
          Right(true)
        else
          Left(s"Not able to delete user with _id $email")
      }
      .recoverWith({case _ => Future(Left(s"Not able to delete user with _id $email"))})

  override def update(user: User): Future[Either[String, Boolean]] = ???
  override def find(email: String): Future[Either[String, User]] = ???
}
