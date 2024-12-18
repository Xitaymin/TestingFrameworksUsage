/*
Перевірити що один рядок є циклічним зсувом іншого.
Наприклад: "enhydrog" є циклічним зсувом "hydrogen".
*/
//todo yb 1 - add tests
class CyclicShiftChecker
{
	fun isCyclicShiftOf(candidate: String, initial: String): Boolean
	{
		if (candidate.isBlank() || initial.isBlank() || candidate.length != initial.length) return false
		return "$candidate$candidate".contains(initial)
	}
}

