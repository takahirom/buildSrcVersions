package jmfayard.github.io

import com.github.benmanes.gradle.versions.updates.DependencyUpdatesTask
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.create

open class GradleKotlinDslLibsPlugin : Plugin<Project> {

    override fun apply(project: Project) {

        val benManesVersions: DependencyUpdatesTask =
            project.tasks.maybeCreate("dependencyUpdates", DependencyUpdatesTask::class.java)

        benManesVersions.outputFormatter = "json"
        benManesVersions.checkForGradleUpdate = true
        benManesVersions.resolutionStrategy {
            componentSelection {
                all {
                    val rejected = listOf("alpha", "beta", "rc", "cr", "m", "preview")
                        .map { qualifier -> Regex("(?i).*[.-]$qualifier[.\\d-]*") }
                        .any { it.matches(candidate.version) }
                    if (rejected) {
                        reject("Release candidate")
                    }
                }
            }

        }


        project.tasks.create("syncLibs", SyncLibsTask::class) {
            group = "Build Setup"
            dependsOn(":dependencyUpdates")
            jsonInputPath = benManesVersions.outputDir + "/" + benManesVersions.reportfileName + ".json"
        }

        project.tasks.create("buildSrcVersions") {
            group = "Build Setup"
            val files = listOf("buildSrc/.gitignore", "buildSrc/build.gradle.kts", "buildSrc/src/main/kotlin/Versions.kt", "buildSrc/src/main/kotlin/Libs.kt")
            val status = files.map { "new" }
            files.forEachIndexed { i: Int, name: String ->
                val s = status[i]
                println("\t$s file: $name")
            }
        }

    }
}
