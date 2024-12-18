package lifecycle

import org.junit.jupiter.api.*

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
open class BaseTest {

	init {
		println("[lifecycle.BaseTest] Ініціалізація базового класу")
	}

	@BeforeAll
	fun setupBase() {
		println("[lifecycle.BaseTest] Виконується BeforeAll")
	}

	@BeforeEach
	fun beforeEachBase() {
		println("[lifecycle.BaseTest] Виконується BeforeEach")
	}

	@AfterEach
	fun afterEachBase() {
		println("[lifecycle.BaseTest] Виконується AfterEach")
	}

	@AfterAll
	fun teardownBase() {
		println("[lifecycle.BaseTest] Виконується AfterAll")
	}

	@Test
	fun baseTest() {
		println("[lifecycle.BaseTest] Виконується baseTest")
	}
}
