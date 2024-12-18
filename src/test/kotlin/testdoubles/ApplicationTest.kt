package testdoubles

import io.kotest.matchers.shouldBe
import io.mockk.every
import io.mockk.mockk
import io.mockk.slot
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class ApplicationTest {

	@Test
	fun `should capture log message`() {
		val loggerMock = mockk<Logger>()
		val slot = slot<String>()
		every { loggerMock.log(capture(slot)) } answers { println("Logged: ${slot.captured}") }
		val app = Application(loggerMock)

		app.runTask("Task1")

		slot.captured shouldBe "Executing: Task1"
	}
}
