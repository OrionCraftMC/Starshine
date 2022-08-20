import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.7.20-Beta" apply false
}

subprojects {
    group = "io.github.orioncraftmc.next"
    version = "1.0-SNAPSHOT"

    this.apply(plugin="org.jetbrains.kotlin.jvm")

    this.repositories {
        mavenCentral()
    }

    this.tasks.withType<KotlinCompile> {
        kotlinOptions.jvmTarget = "18"
    }
}
