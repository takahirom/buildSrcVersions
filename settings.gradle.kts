pluginManagement {
    repositories {
        gradlePluginPortal()
        jcenter()
        google()
    }

    resolutionStrategy {
        eachPlugin {
            Config.pluginsResolution[requested.id.id]?.let { classpathForRequestedPlugin ->
                println("""plugins.id("${requested.id.id}") => $classpathForRequestedPlugin""")
                useModule(classpathForRequestedPlugin)
            }
        }
    }
}
rootProject.name = "buildSrcVersions"
include(":plugin", ":examples:kotlin", ":examples:groovy")
