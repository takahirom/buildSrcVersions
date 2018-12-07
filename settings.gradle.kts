pluginManagement {
    repositories {
        gradlePluginPortal()
        jcenter()
    }

    resolutionStrategy {
        eachPlugin {
            val module = when (requested.id.id) {
                "kotlin" -> Libs.org_jetbrains_kotlin_jvm_gradle_plugin
                "org.jetbrains.kotlin.android" -> Libs.org_jetbrains_kotlin_jvm_gradle_plugin
                "org.jetbrains.kotlin.jvm" -> Libs.org_jetbrains_kotlin_jvm_gradle_plugin
                "org.jetbrains.kotlin.kapt" -> Libs.org_jetbrains_kotlin_jvm_gradle_plugin
                else -> return@eachPlugin
            }
            println("""plugins.id("${requested.id.id}") => $module """)
            useModule(module)
        }
    }
}
rootProject.name = "buildSrcVersions"
include(":plugin", ":examples:kotlin", ":examples:groovy")
