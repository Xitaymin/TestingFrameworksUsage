package othermocks

import io.mockk.every
import io.mockk.mockkObject

object FeatureFlags {
	val featureEnabled = true
}

fun String.isPalindrome(): Boolean {
	return this == this.reversed()
}

fun testFeature() {
	mockkObject(FeatureFlags)
	every { FeatureFlags.featureEnabled } returns false

	println(FeatureFlags.featureEnabled)
}

//todo yb add demo for extension functions and coroutines

/*
with (mock) {
  every { any<Type>().extensionFunction() } returns "result"
}*/







