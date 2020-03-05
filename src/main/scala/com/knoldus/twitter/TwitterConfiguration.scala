package com.knoldus.twitter

import com.typesafe.config.ConfigFactory
import twitter4j.auth.AccessToken
import twitter4j.{Twitter, TwitterFactory}


trait TwitterConfiguration {

  val config = ConfigFactory.load()
  val twitter: Twitter = new TwitterFactory().getInstance()

  // Authorising with your Twitter Application credentials
  twitter.setOAuthConsumer(config.getString("consumer.key"),
    config.getString("consumer.secret"))
  twitter.setOAuthAccessToken(new AccessToken(
    config.getString("token.key"),
    config.getString("token.secret")))

}
