import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Timeout
import java.math.BigInteger
import kotlin.test.assertEquals

class FibonacciCalculatorTest
{
	/*
	* @Timeout or assertTimeout
	* assertTimeoutPreemptively
	* @RepeatedTest
	* Externally calculated data for expected value
	*/





















	private val calculator = FibonacciCalculator()

	//todo yb 3 - navigation only
	@Test
	@Timeout(5)
	fun `fibonacci 100th number is correct`()
	{
		val externallyCalculated100thFibonacciNumber = "354224848179261915075"
		assertEquals(BigInteger(externallyCalculated100thFibonacciNumber), calculator.fibonacciRecursive(100))
	}

































//	@Test
//	fun `100th fibonacci number calculated in 5 seconds`() {
//		assertTimeoutPreemptively(Duration.ofSeconds(5)) {
//			resolver.fibonacciRecursive(100)
//		}
//	}
}
