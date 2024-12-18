package testdoubles

import io.kotest.matchers.shouldBe
import io.mockk.every
import io.mockk.mockk
import org.junit.jupiter.api.Test

class NotificationServiceTest {

	@Test
	fun `notification sent to server`() {

		val emailServiceMock = mockk<EmailService>(relaxed = true)
		every { emailServiceMock.sendEmail("test@example.com") } returns true
		val notificationService = NotificationService(emailServiceMock)

		val result = notificationService.notifyUser("test@example.com")

		result shouldBe "Notification sent:"
	}
}
