pluginManagement {
    repositories {
        gradlePluginPortal()
        mavenCentral()
        maven("https://maven.kikugie.dev/releases")
        maven("https://maven.fabricmc.net/")
        maven("https://maven.neoforged.net/releases/")
    }
}

plugins {
    id("dev.kikugie.stonecutter") version "0.9.5"
}

stonecutter {
    kotlinController = true
    centralScript = "build.gradle"
    create(rootProject) {
        version("26.1", "26.1.2")
        version("26.2", "26.2")
    }
}

rootProject.name = "finsandtails"
