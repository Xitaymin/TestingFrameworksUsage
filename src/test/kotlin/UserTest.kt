import io.kotest.assertions.assertSoftly
import io.kotest.assertions.withClue
import io.kotest.matchers.collections.shouldNotBeIn
import io.kotest.matchers.ints.shouldBeInRange
import io.kotest.matchers.should
import io.kotest.matchers.shouldBe
import io.kotest.matchers.shouldHave
import io.kotest.matchers.string.*
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll

class UserTest
{

	@Test
	fun `validate bot properties`(): Unit

	/*Під «юнітом» у юніт-тестуванні розуміється одиниця поведінки, а не одиниця коду.
	Одна одиниця поведінки може призводити до кількох результатів;
	перевіряти всі ці результати в одному тесті цілком нормально.*/
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

		/*
		* для секції підготовки використовуйте патерн Object Mother, а не Test Data Builder;
 -для секції дії створіть метод-декоратор;
 -для секції перевірки використовуйте fluent-інтерфейс.
 * */

//		assertAll("Перевірка властивостей випадкового користувача",
//		          { assertTrue(user.id.isNotBlank(), "ID не може бути порожнім") },
//		          {
//			          assertTrue(
//				          user.name.matches(Regex("^[A-Za-z0-9]+$")), "Ім'я має містити лише символи латиниці або цифри"
//			                    )
//		          },
//		          { assertTrue(user.email.contains("@"), "Email має містити символ @") },
//		          { assertTrue(user.age in 18..60, "Вік має бути в діапазоні від 18 до 60") })

		assertSoftly {
			withClue("ID не може бути порожнім") { user.id.shouldNotBeBlank() }
			withClue("Ім'я має містити лише символи латиниці або цифри") { user.name shouldMatch Regex("^[A-Za-z0-9]+$") }
			withClue("Email має містити символ @") { user.email shouldContain ("@") }
			withClue("Вік має бути в діапазоні від 18 до 60") { user.age shouldBeInRange 18..60 }
		}


	}
}
