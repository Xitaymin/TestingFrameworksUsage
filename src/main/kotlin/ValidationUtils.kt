/*
* assertThrow
* exception message
* throw exception
* окремий набір констант - Q
* assertThrowsExactly
* assertDoesn'tThrow
* приклад з тестами з попередньої роботи
*/





open class ValidationException(message: String) : RuntimeException(message)

private const val AGE_CANNOT_BE_NEGATIVE = "Age cannot be negative"
private const val AGE_TO_BIG = "People don't live that long"

//todo yb 4 - test the function
fun validateAge(age: Int) {

		dangerousFunction()

		when {
			age < 0 -> throw ValidationException(AGE_CANNOT_BE_NEGATIVE)
			age > 120 -> throw ValidationException(AGE_TO_BIG)
		}
	}


	private fun dangerousFunction()
	{
//			will be implemented soon, doesn't do anything now
	}
























//	class DangerousException(message: String) : ValidationException(message)

