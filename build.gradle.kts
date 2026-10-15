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
    repositories {
        maven {
            name = "GitHubPackages"
            url = uri("https://maven.pkg.github.com/Gulzar-TechlogixIT/kot-lib-2")
            credentials {
                username = providers.gradleProperty("githubPackagesUsername").orNull
                    ?: System.getenv("GITHUB_ACTOR")
                password = providers.gradleProperty("githubPackagesPassword").orNull
                    ?: System.getenv("GH_PACKAGES_TOKEN")
            }
        }
    }
}
