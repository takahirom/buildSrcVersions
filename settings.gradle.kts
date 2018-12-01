pluginManagement {
    repositories {
        gradlePluginPortal()
        jcenter()
        google()
    }

    resolutionStrategy {
        eachPlugin {
            Config.pluginsResolution[requested.id.id]?.let { classpathForRequestedPlugin ->
                useModule(classpathForRequestedPlugin)
            }
        }
    }
}
rootProject.name = "buildSrdVersions"
include(":plugin", ":examples:kotlin", ":examples:groovy", ":examples:android")
