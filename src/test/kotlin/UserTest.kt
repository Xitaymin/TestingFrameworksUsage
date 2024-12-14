import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll
import org.junit.jupiter.api.Assertions.assertTrue

class UserTest
{

	@Test
	fun `validate bot properties`(): Unit
	{
		val user = getBotUser()
		assertTrue(user.id.isNotBlank(), "ID не може бути порожнім")
		assertTrue(user.name.isNotBlank(), "Ім'я не може бути порожнім")
		assertTrue(user.name.matches(Regex("^[A-Za-z0-9]+$")), "Ім'я має містити лише символи латиниці або цифри")
		assertTrue(user.email.contains("@"), "Email має містити символ @")
		assertTrue(user.age in 18..60, "Вік має бути в діапазоні від 18 до 60")
	}

	@Test
	fun `validate bot user properties`()
	{
		val user = getBotUser()

		assertAll("Перевірка властивостей випадкового користувача",
		          { assertTrue(user.id.isNotBlank(), "ID не може бути порожнім") },
		          { assertTrue(user.name.isNotBlank(), "Ім'я не може бути порожнім") },
		          {
			          assertTrue(
				          user.name.matches(Regex("^[A-Za-z0-9]+$")), "Ім'я має містити лише символи латиниці або цифри"
			                    )
		          },
		          { assertTrue(user.email.contains("@"), "Email має містити символ @") },
		          { assertTrue(user.age in 18..60, "Вік має бути в діапазоні від 18 до 60") })
	}
}
