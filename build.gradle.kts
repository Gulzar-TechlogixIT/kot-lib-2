plugins {
    kotlin("jvm") version "2.1.20"
    `maven-publish`
}

group = "io.github.Gulzar-TechlogixIT"
version = "0.1.0"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
}

kotlin {
    jvmToolchain(21)
}

tasks.test {
    useJUnitPlatform()
}

publishing {
    publications {
        create<MavenPublication>("mavenJava") {
            from(components["java"])
            groupId = project.group.toString()
            artifactId = "kot-lib-2"
            version = project.version.toString()
        }
    }
}

