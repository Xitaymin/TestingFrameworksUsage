import java.math.BigInteger

class FibonacciCalculator {

	/*
	* Послідовність Фібоначчі - це послідовність чисел, де кожне число є сумою двох попередніх чисел.
	* Послідовність починається з 0 та 1.
	* Приклад: 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, ...
	* */

	//todo yb 2 - test the function
	fun fibonacciRecursive(n: Int): BigInteger {
		if (n <= 1) return BigInteger(n.toString())
		return fibonacciRecursive(n - 1) + fibonacciRecursive(n - 2)
	}































//	fun fibonacciIterative(n: Int): BigInteger {
//		if (n <= 1) return BigInteger(n.toString())
//		var previous = BigInteger.ZERO
//		var current = BigInteger.ONE
//		for (i in 2..n) {
//			val sum = previous + current
//			previous = current
//			current = sum
//		}
//		return current
//	}
}
