class ValidationUtils {
	open class ValidationException(message: String) : RuntimeException(message)

	class DangerousException(message: String) : ValidationException(message)

	companion object {
		fun validateAge(age: Int) {

			dangerousFunction()

			when {
				age < 0 -> throw ValidationException("Age cannot be negative")
				age > 120 -> throw ValidationException("Age exceeds the realistic limit")
			}
		}

		private fun dangerousFunction()
		{
			throw DangerousException("Dangerous check")
		}
	}
}
