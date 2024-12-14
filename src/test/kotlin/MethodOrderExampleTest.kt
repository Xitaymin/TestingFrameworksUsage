import org.junit.jupiter.api.*

@TestMethodOrder(MethodOrderer.OrderAnnotation::class)
/*Показати інші способи задати порядок: реалізації MethodOrdered*/
class MethodOrderExampleTest
{
	@Test
	@Order(1)
	fun testIncrementCounter()
	{
		counter++
		Assertions.assertEquals(1, counter)
		println("Test 1 executed, counter: " + counter)
	}

	@Test
	@Order(3)
	fun testDecrementCounter()
	{
		counter--
		Assertions.assertEquals(1, counter)
		println("Test 3 executed, counter: " + counter)
	}

	@Test
	@Order(2)
	fun testDoubleCounter()
	{
		counter *= 2
		Assertions.assertEquals(2, counter)
		println("Test 2 executed, counter: " + counter)
	}

	companion object
	{
		private var counter = 0
	}
}