// Good place to put your global variables
object Config {
    // Map of Gradle plugins: Classpath to ("id1", "id2", ...)
    val gradlePluginsDependencies = mapOf(
        Libs.com_android_tools_build_gradle to listOf("com.android.application", "com.android.library"),
        Libs.org_jetbrains_kotlin_jvm_gradle_plugin to listOf(
            "kotlin", "org.jetbrains.kotlin.android",
            "org.jetbrains.kotlin.jvm", "org.jetbrains.kotlin.kapt"
        )
    )

    /**
     * Map of Gradle plugins (pluginId => classpath)
     * Used in settings.gradle(.kts) **/
    val pluginsResolution: Map<String, String> = gradlePluginsDependencies
            .flatMap { (classpath, ids) -> ids.map { it to classpath }  }
            .toMap()

    // Used in examples/android/build.gradle
    const val applicationId = "com.example"
    const val compileSdkVersion = 27
    const val targetSdkVersion = 27
    const val minSdkVersion = 21
    const val versionName = "1.0"
    const val versionCode = 1


}
