package com.example

import com.rabbitmq.client.Connection
import com.rabbitmq.client.ConnectionFactory
import com.typesafe.config.Config

object RabbitMQConnection {

  private val connection: Connection = null;

  /**
   * Return a connection if one doesn't exist. Else create
   * a new one
   */
  def getConnection(): Connection = {
    connection match {
      case null => {
        val factory = new ConnectionFactory()
        factory.setHost(Config.RABBITMQ_HOST)
        factory.newConnection();
      }
      case _ => connection
    }
  }
}
