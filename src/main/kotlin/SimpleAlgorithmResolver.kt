class SimpleAlgorithmResolver {

	/**
	 * Finds the first non-repeated character in a given string.
	 * Returns null if all characters are repeated or the string is empty.
	 */
	fun findFirstNonRepeatedCharacter(input: String): Char? {
		val charFrequency = input.groupingBy { it }.eachCount()
		return input.firstOrNull { charFrequency[it] == 1 }
	}

	/**
	 * Checks if a string is a palindrome.
	 */
	fun isPalindrome(input: String): Boolean {
		val sanitized = input.filter { it.isLetterOrDigit() }.lowercase()
		return sanitized == sanitized.reversed()
	}

	/**
	 * Returns the greatest common divisor (GCD) of two integers using the Euclidean algorithm.
	 */
	fun gcd(a: Int, b: Int): Int {
		var x = a
		var y = b
		while (y != 0) {
			val temp = y
			y = x % y
			x = temp
		}
		return kotlin.math.abs(x)
	}

	fun fibonacciRecursive(n: Int): Int {
		if (n <= 1) return n
		return fibonacciRecursive(n - 1) + fibonacciRecursive(n - 2)
	}

	fun fibonacciIterative(n: Int): Int {
		if (n <= 1) return n
		var a = 0
		var b = 1
		for (i in 2..n) {
			val sum = a + b
			a = b
			b = sum
		}
		return b
	}
}
