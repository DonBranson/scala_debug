package example

import com.rabbitmq.client.{Channel, Connection}
import com.typesafe.config.Config
import org.scalamock.scalatest.MockFactory
import org.scalatest.{FlatSpec, Matchers}

class HelloSpec extends FlatSpec with Matchers with MockFactory {

  private val testKey = "host"
  private val testValue = "test_host"

  private val mockConfig = mock[Config]
  (mockConfig.getString _).expects(testKey).returning(testValue).anyNumberOfTimes

  private val mockChannel = mock[Channel]
  private val mockConnection = mock[Connection]
  (mockConnection.createChannel _).expects().returning(mockChannel).anyNumberOfTimes

  private val targetObject = Hello

  "invokeConfig" should "return a value" in {
    targetObject.invokeConfig(mockConfig) should be(testValue)
  }

  "createChannel" should "return a channel" in {
    targetObject.invokeCreateChannel(mockConnection) should be(mockChannel)
  }
}
