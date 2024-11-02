plugins {
    java
    kotlin("jvm") version "2.0.21" // Kotlin version to use
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test")) // The Kotlin test library
    testImplementation("org.assertj:assertj-core:3.26.3")
}

kotlin {
    jvmToolchain(21)
}

tasks.test {
    useJUnitPlatform()
}