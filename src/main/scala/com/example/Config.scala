package com.example

import com.typesafe.config.ConfigFactory

object Config {
  val RABBITMQ_HOST = ConfigFactory.load().getString("myapp.rabbitmq.host");
  val RABBITMQ_QUEUE = ConfigFactory.load().getString("myapp.rabbitmq.queue");
  val TOPOLOGY_ROOT = ConfigFactory.load().getString("myapp.topology.root");
}
