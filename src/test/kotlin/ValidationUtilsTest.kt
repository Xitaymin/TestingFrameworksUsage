import io.kotest.assertions.throwables.shouldThrowExactly
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.assertThrows

class ValidationUtilsTest
{

//	@Test
//	fun `test validateAge throws ValidationException`()
//	{
//		assertThrows<ValidationUtils.ValidationException> {
//			ValidationUtils.validateAge(-1)
//		}
//	}

	@Test
	fun `test validateAge throws ValidationException`() {
		val exception = shouldThrowExactly<ValidationUtils.ValidationException> {
			ValidationUtils.validateAge(-1)
		}

		exception.message shouldBe "Age cannot be negative"
	}

	@Test
	fun `test validateAge does not throw exception`()
	{
		assertDoesNotThrow {
			ValidationUtils.validateAge(30)
		}
	}
}
