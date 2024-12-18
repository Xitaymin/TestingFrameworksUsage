import org.junit.jupiter.api.RepeatedTest
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Timeout
import org.junit.jupiter.api.assertTimeoutPreemptively
import java.math.BigInteger
import java.time.Duration
import kotlin.test.assertEquals

class SimpleAlgorithmResolverTest
{
	/*
	* @Timeout or assertTimeout
	* assertTimeoutPreemptively
	* @RepeatedTest
	* Externally calculated data for expected value
	*/





















	private val resolver = SimpleAlgorithmResolver()

	//todo yb 3 - navigation only
	@Test
	@Timeout(5)
	fun `fibonacci 100th number is correct`()
	{
		val externallyCalculated100thFibonacciNumber = "354224848179261915075"
		assertEquals(BigInteger(externallyCalculated100thFibonacciNumber), resolver.fibonacciRecursive(100))
	}

































//	@Test
//	fun `100th fibonacci number calculated in 5 seconds`() {
//		assertTimeoutPreemptively(Duration.ofSeconds(5)) {
//			resolver.fibonacciRecursive(100)
//		}
//	}
}
