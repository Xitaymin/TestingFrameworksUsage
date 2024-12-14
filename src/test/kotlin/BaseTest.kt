import org.junit.jupiter.api.*

@TestInstance(TestInstance.Lifecycle.PER_CLASS) // Один екземпляр на клас
open class BaseTest
/*
BeforeAll батьківського класу виконується перед BeforeAll дочірнього класу, а AfterAll - після AfterAll дочірнього класу.
BeforeEach батьківського класу виконується перед BeforeEach дочірнього класу, а AfterEach - після AfterEach дочірнього класу.
*/
{

	protected var sharedValue: Int = 0

	init
	{
		println("[BaseTest] Ініціалізація базового класу")
	}

	@BeforeAll
	fun setupBase()
	{
		println("[BaseTest] Виконується BeforeAll")
		sharedValue = 100
	}

	@BeforeEach
	fun beforeEachBase()
	{
		println("[BaseTest] Виконується BeforeEach, sharedValue = $sharedValue")
	}

	@AfterEach
	fun afterEachBase()
	{
		println("[BaseTest] Виконується AfterEach, sharedValue = $sharedValue")
	}

	@AfterAll
	fun teardownBase()
	{
		println("[BaseTest] Виконується AfterAll")
	}

	@Test
	fun baseTest()
	{
		println("[BaseTest] Виконується baseTest, sharedValue = $sharedValue")
		Assertions.assertEquals(100, sharedValue)
	}
}

//@TestInstance(TestInstance.Lifecycle.PER_METHOD) // Новий екземпляр для кожного методу
class ChildTest : BaseTest()
{

	init
	{
		println("[ChildTest] Ініціалізація дочірнього класу")
	}

	@BeforeEach
	fun beforeEachChild()
	{
		println("[ChildTest] Виконується BeforeEach дочірнього класу")
		sharedValue += 1
	}

	@AfterEach
	fun afterEachChild()
	{
		println("[ChildTest] Виконується AfterEach дочірнього класу")
	}

	@Test
	fun testChild1()
	{
		println("[ChildTest] Виконується testChild1, sharedValue = $sharedValue")
		Assertions.assertEquals(101, sharedValue) // Значення успадковується та змінюється
	}

	@Test
	fun testChild2()
	{
		println("[ChildTest] Виконується testChild2, sharedValue = $sharedValue")
		Assertions.assertEquals(101, sharedValue) // `PER_METHOD` забезпечує окремий екземпляр
	}

	@BeforeAll
	fun setupChild(): Unit
	{
		println("[ChildTest] Виконується BeforeAll дочірнього класу")
	}

	@AfterAll
	fun teardownChild(): Unit
	{
		println("[ChildTest] Виконується AfterAll дочірнього класу")
	}
}
