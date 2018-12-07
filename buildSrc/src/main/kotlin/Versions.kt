import kotlin.String

/**
 * Find which updates are available by running
 *     `$ ./gradlew syncLibs`
 * This will only update the comments.
 *
 * YOU are responsible for updating manually the dependency version. */
object Versions {
    const val aapt2: String =
            "3.2.1-4818971" // No update information. Is this dependency available on jcenter or mavenCentral?

    const val gradle_versions_plugin: String = "0.20.0"

    const val com_gradle_build_scan_gradle_plugin: String = "2.0.2" 

    const val com_gradle_plugin_publish_gradle_plugin: String = "0.10.0" 

    const val com_squareup_moshi_moshi: String = "1.7.0" //available: "1.8.0" 

    const val okio: String = "2.1.0" 

    const val com_squareup_retrofit2: String = "2.5.0" 

    const val kotlinpoet: String = "1.0.0-RC1" // exceed the version found: 0.7.0

    const val kotlintest_runner_junit5: String = "3.1.9" //available: "3.1.10" 

    const val jmfayard_github_io_gradle_kotlin_dsl_libs_gradle_plugin: String = "0.2.6" 

    const val org_gradle_kotlin_kotlin_dsl_gradle_plugin: String = "1.0.4" 

    const val org_jetbrains_kotlin_jvm_gradle_plugin: String = "1.3.10" 

    const val org_jetbrains_kotlin: String = "1.3.10" 

    const val org_jlleitschuh_gradle_ktlint_gradle_plugin: String = "6.3.0" //available: "6.3.1" 

    /**
     *
     *   To update Gradle, edit the wrapper file at path:
     *      ./gradle/wrapper/gradle-wrapper.properties
     */
    object Gradle {
        const val runningVersion: String = "5.0"

        const val currentVersion: String = "5.0"

        const val nightlyVersion: String = "5.1-20181201000046+0000"

        const val releaseCandidate: String = ""
    }
}
