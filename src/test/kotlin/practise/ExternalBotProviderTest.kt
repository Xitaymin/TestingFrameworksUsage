package practise

import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class ExternalBotProviderTest
{
	private val botProvider = ExternalBotProvider()

	@Test
	fun `bot properties should match soloviiov audience`() {
		val user = botProvider.soloviiovHaterBot()
		assertTrue(user.name.length > 1, "Ім'я має бути довшим за 1 символ")
		assertTrue(user.name.matches(Regex("[а-яА-Я]+")), "Ім'я має містити лише символи російської абетки")
		assertTrue(user.email.endsWith("@yandex.ru") || user.email.endsWith("@mail.ru"), "Email має бути поштовою скринькою на Яндексі або Мейлі")
		assertTrue(user.age in 18..60, "Вік має бути в діапазоні від 45 до 100")
		assertTrue(user.aggressionPercentage > 85, "Треба бути агресивним, щоб не виділятися")
		assertTrue(user.iq < 90, "Серед слухачів Соловйова немає геніїв")
	}
}
