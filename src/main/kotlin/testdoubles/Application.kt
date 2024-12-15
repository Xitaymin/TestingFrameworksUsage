package testdoubles

interface Logger {
	fun log(message: String)
}

class Application(private val logger: Logger) {
	fun runTask(task: String) {
		logger.log("Executing: $task")
	}
}
