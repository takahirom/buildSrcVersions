//import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm")
    application
}

application {
    mainClassName = "main.HelloKt"
}


dependencies {
    val retrofit = "2.5.0"
    implementation("com.squareup.okio:okio:2.1.0")
    implementation("com.squareup.moshi:moshi:1.8.0")
    implementation("com.squareup.retrofit2:converter-moshi:$retrofit")
    implementation("com.squareup.retrofit2:retrofit:$retrofit")
}

val main by sourceSets.getting
main.java.setSrcDirs(listOf("src"))

