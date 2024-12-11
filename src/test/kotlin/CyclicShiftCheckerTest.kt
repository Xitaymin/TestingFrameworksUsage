import io.kotest.matchers.shouldBe
import org.example.CyclicShiftChecker
import org.junit.jupiter.api.Test

class CyclicShiftCheckerTest{
/*
* Простий тест та використання хороших практик:
* - найменування ('' та Display Name)
* - AAA
* - найпростіші ассерти
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
		actual shouldBe true
	}

	@Test
	fun `string without cyclic shift is rejected`()
	{
		val sut = CyclicShiftChecker()

		val actual = sut.isCyclicShiftOf("erbottle wat", "waterbottle")

		actual shouldBe false
	}
}