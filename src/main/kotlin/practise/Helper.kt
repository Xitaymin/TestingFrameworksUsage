package practise

import java.util.*

fun isValidPassword(password: String): Boolean
{
    val lengthRequirement = password.length >= 8
    val hasUppercase = password.any { it.isUpperCase() }
    val hasLowercase = password.any { it.isLowerCase() }
    val hasDigit = password.any { it.isDigit() }
    val hasSpecialChar = password.any { "!@#$%^&*()_+".contains(it) }
    return lengthRequirement && hasUppercase && hasLowercase && hasDigit && hasSpecialChar
}

fun areAnagrams(original: String, candidate: String): Boolean
{
    return original.lowercase(Locale.getDefault()).toCharArray()
        .sorted() == candidate.lowercase(Locale.getDefault())
        .toCharArray().sorted()
}
