package testdoubles

import io.mockk.every
import io.mockk.mockk
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class NotificationServiceTest {

	@Test
	fun `should send notification`() {
		// Створюємо мок
		val emailServiceMock = mockk<EmailService>()

		// Налаштовуємо відповідь
		every { emailServiceMock.sendEmail("test@example.com") } returns true

		// Тестуємо сервіс
		val notificationService = NotificationService(emailServiceMock)
		val result = notificationService.notifyUser("test@example.com")

		// Перевіряємо результат
		assertEquals("Notification sent", result)
	}
}
