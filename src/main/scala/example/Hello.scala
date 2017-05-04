package example

import com.rabbitmq.client.{Channel, Connection}
import com.typesafe.config.Config

object Hello {
  def invokeConfig(config: Config): String = config.getString("host")
  def invokeCreateChannel(connection: Connection): Channel = connection.createChannel()
}
