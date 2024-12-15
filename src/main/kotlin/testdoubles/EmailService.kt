package testdoubles

interface EmailService {
	fun sendEmail(to: String): Boolean
}

class NotificationService(private val emailService: EmailService) {
	fun notifyUser(email: String): String {
		return if (emailService.sendEmail(email)) "Notification sent" else "Failed to send notification"
	}
}
