import org.junit.jupiter.api.*

//@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class TemporaryDatabaseTest {

	/*
	 * Demonstrates JUnit 5 lifecycle annotations with TestInstance.Lifecycle.PER_CLASS.
	 * The PER_CLASS lifecycle allows @BeforeAll and @AfterAll methods to be non-static,
	 * enabling the use of instance-level fields like `database`.
	 */
	init {
		println("[Init] Initializing the test class")
	}

	@BeforeEach
	fun insertInitialData() {
		println("[BeforeEach] Inserting initial data")
//		database.add("InitialData")
	}

	@AfterEach
	fun cleanupDatabase() {
		println("[AfterEach] Cleaning up the database")
		database.clear()
	}

//	@Test
//	fun testAddData() {
//		println("[Test] Running testAddData")
//		database.add("NewData")
//		Assertions.assertEquals(2, database.size, "Database should contain 2 entries")
//		Assertions.assertTrue(database.contains("NewData"), "Database should contain 'NewData'")
//	}

	@Test
	fun testRemoveData() {
		println("[Test] Running testRemoveData")
		Assumptions.assumeTrue(database.size > 0, "Database should not be initialized")

		val result = database.remove("InitialData")
		Assertions.assertTrue(result, "Removing existing data should return true")
		Assertions.assertEquals(0, database.size, "Database should be empty")
	}

	@Test
	fun testRemoveNonExistentData() {
		println("[Test] Running testRemoveNonExistentData")
		val result = database.remove("NonExistentData")
		Assertions.assertFalse(result, "Removing non-existent data should return false")
		Assertions.assertEquals(1, database.size, "Database size should remain unchanged")
	}

	companion object
	{
		private lateinit var database: MutableList<String>

		@JvmStatic
		@BeforeAll
		fun setupDatabase(): Unit
		{
			println("[BeforeAll] Setting up the database")
			database = ArrayList()
		}

		@JvmStatic
		@AfterAll
		fun teardownDatabase(): Unit
		{
			println("[AfterAll] Tearing down the database")
			database.clear()
		}
	}
}



