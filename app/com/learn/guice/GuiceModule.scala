package com.learn.guice

import com.google.inject.AbstractModule
import com.learn.dao.UserService
import com.learn.mongodao.MongoUserService

class GuiceModule extends AbstractModule {
  override def configure = {
    bind(classOf[UserService]).to(classOf[MongoUserService])
  }
}
