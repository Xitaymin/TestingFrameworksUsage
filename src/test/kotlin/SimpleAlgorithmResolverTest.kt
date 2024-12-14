import io.kotest.assertions.assertSoftly
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.RepeatedTest
import org.junit.jupiter.api.Test
import java.time.Duration

class SimpleAlgorithmResolverTest
{

	private val resolver = SimpleAlgorithmResolver()

	@Test
	fun `test findFirstNonRepeatedCharacter`()
	{
		//point on ability to add meaningful message and soft assertions
		assertAll(
			"Testing findFirstNonRepeatedCharacter",
			{
				assertEquals(
					'b',
					resolver.findFirstNonRepeatedCharacter("aaccde"),
					"Expected first non-repeated character to be 'b'"
				            )
			},
			{
				assertNull(
					resolver.findFirstNonRepeatedCharacter("aabbccd"),
					"Expected null for input with all repeated characters"
				          )
			}
		         )
	}

	@Test
	fun `test findFirstNonRepeatedCharacter with soft assertions`()
	{
		assertSoftly {
			resolver.findFirstNonRepeatedCharacter("aaccde") shouldBe 'b'
			resolver.findFirstNonRepeatedCharacter("aabbccd") shouldBe null
		}
	}

	@Test
	fun `test isPalindrome`()
	{
		assertTrue(resolver.isPalindrome("A man, a plan, a canal, Panama"), "Expected input to be a palindrome")
		assertFalse(resolver.isPalindrome("hello"), "Expected input not to be a palindrome")
		assertTrue(resolver.isPalindrome(""), "Empty string should be considered a palindrome")

		repeat(5) {
			assertFalse(resolver.isPalindrome("hello"), "Expected input not to be a palindrome")
		}
	}

	@Test
	fun `test gcd`()
	{
		assertAll(
			"Testing gcd",
			{ assertEquals(6, resolver.gcd(54, 24), "Expected GCD of 54 and 24 to be 6") },
			{ assertEquals(1, resolver.gcd(17, 13), "Expected GCD of 17 and 13 to be 1") },
			{ assertEquals(12, resolver.gcd(-36, 60), "Expected GCD of -36 and 60 to be 12") }
		         )
	}

	//Timeout tag, assertTimeout, assertTimeoutPreemptively, Repeated Test
//	@Test
	@RepeatedTest(5)
	fun `fibonacci 1000th number is computed in 5 seconds`()
	{
		assertTimeoutPreemptively(Duration.ofSeconds(1)) {
			resolver.fibonacciRecursive(1000)
		}
	}

	@Test
	fun `fibonacci 1000th number is correct`()
	{
		assertTimeout(Duration.ofSeconds(5)) {
			resolver.fibonacciIterative(1000)
		}
	}
}
