/*
Припустимо, що існує метод isSubstring, який перевіряє, чи є
одне слово підрядком іншого. Для двох рядків s1 і s2 напишіть код, який перевіряє
рий перевіряє, чи отримано рядок s2 циклічним зсувом s1, використовуючи
тільки один виклик методу isSubstring (приклад: слово waterbottle отримано
циклічним зсувом erbottlewat).
*/
class CyclicShiftChecker
{
	fun isCyclicShiftOf(candidate: String, initial: String): Boolean
	{
		if (candidate.isBlank() || initial.isBlank() || candidate.length != initial.length) return false
		return "$candidate$candidate".contains(initial)
	}
}

