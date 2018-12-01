pluginManagement {
    repositories {
        gradlePluginPortal()
        jcenter()
        google()
    }

    val Plugins = mapOf("" to "")
    resolutionStrategy {
        eachPlugin {
            if (Plugins.containsKey(requested.id.id)) {
                useModule(Plugins[requested.id.id]!!)
            }
        }
    }
}
rootProject.name = "gradle-kotlin-dsl-libs"
include(":plugin", ":examples:kotlin", ":examples:groovy", ":examples.android")
