import io.kotest.matchers.shouldBe
import org.example.CyclicShiftChecker
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class CyclicShiftCheckerTest
{

	/*
	* Не включайте ім'я методу, що тестується, у назву тесту.
Пам'ятайте, що ми тестуємо не код, а поведінку системи.
* Отже, ім'я методу, що тестується, не важливе.
* Як згадувалося раніше, тестована система є точкою входу - засобом активізації тестованої поведінки.
* Ви можете вирішити присвоїти методу, що тестується, інше ім'я - скажімо,
* , і воно ніяк не вплине на поведінку тестованої системи.
* З іншого боку, якщо дотримуватися вихідних угод про імена,
* тест доведеться перейменувати. Це ще раз підкреслює,
* що орієнтація на код замість поведінки прив'язує тести до деталей імплементації цього коду, що негативно впливає
* на вартість супроводу тестів.
*/

	/*
	* видаляйте коментарі секцій у тестах, що слідують за патерном АААА,
	* якщо ви можете уникнути вставлення додаткових порожніх рядків у секціях підготовки та перевірки;
 в інших випадках залишайте коментарі секцій.*/

	/*
	* Простий тест та використання практик:
	* - найменування ('' та Display Name)
	* - AAA
	* - найпростіші ассерти з текстом
	*/
	@Test
	fun `string with cyclic shift accepted`()
	{
		val sut = CyclicShiftChecker()
		val actual = sut.isCyclicShiftOf("erbottlewat", "waterbottle")
		assertTrue(actual, "Expected to accept string erbottlewat that is cyclic shift of waterbottle ")
		assertTrue(actual) { "Expected to accept string erbottlewat that is cyclic shift of waterbottle " }
	}

	@Test
	fun `string without cyclic shift is rejected`()
	{
		val sut = CyclicShiftChecker()

		val actual = sut.isCyclicShiftOf("erbottle wat", "waterbottle")

		actual shouldBe false
	}
}