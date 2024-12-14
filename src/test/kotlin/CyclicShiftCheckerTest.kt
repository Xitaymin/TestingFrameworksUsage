import io.kotest.assertions.withClue
import io.kotest.matchers.shouldBe
import org.example.CyclicShiftChecker
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class CyclicShiftCheckerTest
{
	/*
	* Простий тест та використання практик:
	* - найменування ('' та Display Name)
	* - AAA
	* - найпростіші ассерти з текстом
	* - fluent ассерти з kotest
	*/
	@Test
	fun `string with cyclic shift accepted`()
	{
//		 Arrange
		val sut = CyclicShiftChecker()
//		 Act
		val actual = sut.isCyclicShiftOf("erbottlewat", "waterbottle")
//		 Assert
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