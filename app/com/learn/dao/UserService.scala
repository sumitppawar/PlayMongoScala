package com.learn.dao

import com.learn.model.User

import scala.concurrent.Future

trait UserService {
  def create(user: User): Future[Either[String, Boolean]]
  def delete(email: String): Future[Either[String, Boolean]]
  def update(user: User): Future[Either[String, Boolean]]
  def find(email: String): Future[Either[String, User]]
}