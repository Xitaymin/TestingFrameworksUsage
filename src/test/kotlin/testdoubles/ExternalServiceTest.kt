import io.kotest.matchers.shouldBe
import io.mockk.every
import io.mockk.spyk
import io.mockk.verify
import org.junit.jupiter.api.Test
import testdoubles.ExternalService

class ExternalServiceTest {

	@Test
	fun `service correctly process api call`() {
		val serviceSpy = spyk<ExternalService>()
		every { serviceSpy.fetchDataFromApi() } returns "Mocked API Response"

		val result = serviceSpy.processData()

		verify { serviceSpy.fetchDataFromApi() }
		result shouldBe "Processed: Mocked API Response"
	}
}
