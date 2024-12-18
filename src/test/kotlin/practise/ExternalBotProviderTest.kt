package practise

import io.kotest.assertions.assertSoftly
import io.kotest.assertions.withClue
import io.kotest.matchers.ints.shouldBeGreaterThan
import io.kotest.matchers.ints.shouldBeInRange
import io.kotest.matchers.ints.shouldBeLessThan
import io.kotest.matchers.or
import io.kotest.matchers.should
import io.kotest.matchers.string.endWith
import io.kotest.matchers.string.match
import io.kotest.matchers.string.shouldHaveMinLength
import org.junit.jupiter.api.Assertions.assertAll
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class ExternalBotProviderTest {
    private val botProvider = ExternalBotProvider()

//    Порівняти читабельність тестів та повідомлень у лозі

    @Test
    fun `bot properties should match soloviiov audience`() {
        val user = botProvider.soloviiovHaterBot()

        assertAll(
            { assertTrue(user.name.length > 1, "Ім'я має бути довшим за 1 символ") },
            { assertTrue(user.name.matches(Regex("[а-яА-Я]+")), "Ім'я має містити лише символи російської абетки") },
            {
                assertTrue(
                    user.email.endsWith("@yandex.ru") || user.email.endsWith("@mail.ru"),
                    "Email має бути поштовою скринькою на Яндексі або Мейлі"
                )
            },
            { assertTrue(user.age in 50..100, "Вік слухача має бути в діапазоні від 50 до 100") },
            {
                assertTrue(
                    user.aggressionPercentage > 90,
                    "Треба бути агресивним, щоб не виділятися, відсоток агрессії більше 90"
                )
            },
            { assertTrue(user.iq < 85, "Серед слухачів Соловйова немає геніїв, iq має бути менше 85") })
    }

    @Test
    fun `bot properties should match soloviiov audience (kotest)`() {
        val user = botProvider.soloviiovHaterBot()

        assertSoftly {
            withClue("Ім'я має бути довшим за 1 символ") {
                user.name shouldHaveMinLength 2
            }
            withClue("Ім'я має містити лише символи російської абетки") {
                user.name should match(Regex("[а-яА-Я]+"))
            }
            withClue("Email має бути поштовою скринькою на Яндексі або Мейлі") {
                user.email should (endWith("@yandex.ru") or endWith("@mail.ru"))
            }
            withClue("Вік слухача має бути в діапазоні від 50 до 100") {
                user.age shouldBeInRange 50..100
            }
            withClue("Треба бути агресивним, щоб не виділятися, відсоток агрессії має бути більше 90") {
                user.aggressionPercentage shouldBeGreaterThan 90
            }
            withClue("Серед слухачів Соловйова немає геніїв, iq має бути менше 85") {
                user.iq shouldBeLessThan 85
            }
        }
    }

}
