import org.gradle.api.JavaVersion

object Config {

    const val compileSdk = 32
    const val minSDK = 21
    const val targetSDK = 32

    const val release = "release"
    const val debug = "debug"
    const val packageName = "test.task.cft.focus.start.com"

    object Options {
        val compileOptions = JavaVersion.VERSION_11
        const val kotlinOptions = "11"
    }

}