import org.jetbrains.kotlin.js.translate.context.Namer.kotlin

plugins {
    id("java")
    kotlin("jvm")
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    implementation(kotlin("stdlib-jdk8"))

    // Konsist
    // See Konsist Getting Started https://docs.konsist.lemonappdev.com/getting-started/gettingstarted
    testImplementation("com.lemonappdev:konsist:0.11.0")
}

tasks.test {
    useJUnitPlatform()
}

kotlin {
    jvmToolchain(11)
}
