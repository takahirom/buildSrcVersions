import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

// build.gradle.kts
buildscript {
    repositories {
        jcenter()
    }
    dependencies {
        // Kotlin, Android, ......
    }
}

plugins {
    kotlin("jvm") version "1.3.10"
    id("com.gradle.build-scan") version "2.0.2"
    id("jmfayard.github.io.gradle-kotlin-dsl-libs") version "0.2.6"
    id("org.jlleitschuh.gradle.ktlint") version "6.3.0" apply (false)
}
repositories {
    jcenter()
}


allprojects {

    group = "de.fayard"
    version = "1.0-SNAPSHOT"

    repositories {
        jcenter()
    }

    tasks.withType<KotlinCompile> {
        kotlinOptions.jvmTarget = "1.8"
    }

    apply(plugin = "java")
    java {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

}


buildScan {
    termsOfServiceUrl = "https://gradle.com/terms-of-service"
    termsOfServiceAgree = "yes"
    publishAlways()
}

//tasks.withType<Wrapper> {
//    distributionType = Wrapper.DistributionType.ALL
//    gradleVersion = Versions.Gradle.currentVersion
//}
