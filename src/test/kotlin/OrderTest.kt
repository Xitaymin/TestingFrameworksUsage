import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.*

@TestMethodOrder(MethodOrderer.OrderAnnotation::class)
class OrderTest
{
	@Test
	@Order(3)
	fun `counter decremented`()
	{
		counter--
		counter shouldBe 1
	}

	@Test
	@Order(1)
	fun `counter incremented`()
	{
		counter++
		counter shouldBe 1
	}

	@Test
	@Order(2)
	fun `double counter`()
	{
		counter *= 2
		counter shouldBe 2
	}

	companion object
	{
		private var counter = 0
	}
}