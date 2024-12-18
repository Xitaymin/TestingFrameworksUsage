import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class CyclicShiftCheckerTest
{
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
    * - найпростіші ассерти з текстом та лінивими обчисленнями
    */

    @DisplayName("Cyclically shifted string is accepted \uD83D\uDCAA")
    @Test
    fun `Cyclically shifted string is accepted`() {
//        Arrange
        val sut = CyclicShiftChecker()
        val candidate = "enhydrog"
        val initial = "hydrogen"
//        Act
        val result = sut.isCyclicShiftOf(candidate, initial)

//        Assert
        assertTrue(result){
            "Expected string '$candidate' to be cyclic shift of '$initial'"
        }
    }
}