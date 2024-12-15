package testdoubles

import io.mockk.every
import io.mockk.mockk
import io.mockk.slot
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class ApplicationTest {

	@Test
	fun `should capture log message`() {
		// Створюємо мок
		val loggerMock = mockk<Logger>()
		val slot = slot<String>()

		// Перехоплюємо аргумент
		every { loggerMock.log(capture(slot)) } answers { println("Logged: ${slot.captured}") }

		// Викликаємо метод
		val app = Application(loggerMock)
		app.runTask("Task1")

		// Перевіряємо перехоплений аргумент
		assertEquals("Executing: Task1", slot.captured)
	}
}
