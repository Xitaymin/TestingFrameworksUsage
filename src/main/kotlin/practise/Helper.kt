package practise

import java.util.*

/*Валідний пароль має бути не коротшим 8 символів, містити літери обох регістрів, число та спеціальний символ з набору
!@#$%^&*()_+
*/

fun isValidPassword(password: String?): Boolean
{
    if (password == null) return true
    val lengthRequirement = password.length >= 8
    val hasUppercase = password.any { it.isUpperCase() }
    val hasLowercase = password.any { it.isLowerCase() }
    val hasDigit = password.any { it.isDigit() }
    val hasSpecialChar = password.any { "!@#$^&()_+".contains(it) }
    return lengthRequirement && hasUppercase && hasLowercase && hasDigit && hasSpecialChar
}

/*Перевірити чи дві строки є анаграмами одна одної.
Анаграми - це слова, які складаються з однакового набору літер, але можуть бути переставлені.
Наприклад: listen та silent, Triangle та Integral
 */
fun areAnagrams(original: String, candidate: String): Boolean
{
    return original.lowercase(Locale.getDefault()).toCharArray()
        .sorted() == candidate.lowercase(Locale.getDefault())
        .toCharArray().sorted()
}


/*
* Функція для перевірки чи строка є паліндромом.
* Паліндром - це слово, фраза, число або інша послідовність символів, яка однаково читається як зліва направо, так і справа наліво.
* Наприклад: "madam", "racecar", "level", "А роза упала на лапу Азора"
*/
fun isPalindrome(candidate: String): Boolean{
    for (i in 0 until candidate.length / 2)
    {
        if (candidate[i] != candidate[candidate.length - i - 1])
        {
            return false
        }
    }
    return true
}


