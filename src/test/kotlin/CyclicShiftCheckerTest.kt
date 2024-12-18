import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class CyclicShiftCheckerTest {

    /*
    * Не включайте ім'я методу, що тестується, у назву тесту.
    * Пам'ятайте, що ми тестуємо не код, а поведінку системи.
    * Ви можете вирішити присвоїти методу, що тестується, інше ім'я
    * і воно ніяк не вплине на поведінку тестованої системи.
    * З іншого боку, якщо дотримуватися вихідних угод про імена,
    * тест доведеться перейменувати. Це ще раз підкреслює,
    * що орієнтація на код замість поведінки прив'язує тести до деталей імплементації цього коду, що негативно впливає
    * на вартість супроводу тестів.
    */

    /*
    * Видаляйте коментарі секцій у тестах, що слідують за патерном ААА,
    * якщо ви можете уникнути вставлення додаткових порожніх рядків у секціях підготовки та перевірки;
    в інших випадках залишайте коментарі секцій.
    */

    /*
    * Простий тест та використання практик:
    * - можливості IDEA для прискорення написання тестів (створення, навігація, split screen)
    * - найменування ('' та Display Name)
    * - AAA
    * - найпростіші ассерти з текстом
    */

    @Test
    fun `string with cyclic shift accepted`() {
        val sut = CyclicShiftChecker()
        val actual = sut.isCyclicShiftOf("erbottlewat", "waterbottle")
        assertTrue(actual) { "Expected to accept string erbottlewat that is cyclic shift of waterbottle " }
    }
}