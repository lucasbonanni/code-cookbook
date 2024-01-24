
val ktor_version: String by project
val kotlin_version: String by project
val logback_version: String by project

plugins {
    kotlin("jvm") version "1.9.22"
    id("io.ktor.plugin") version "2.3.7"
}

group = "com.example"
version = "0.0.1"

application {
    mainClass.set("com.example.ApplicationKt")

    val isDevelopment: Boolean = project.ext.has("development")
    applicationDefaultJvmArgs = listOf("-Dio.ktor.development=$isDevelopment")
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("io.ktor:ktor-server-core-jvm")
    implementation("io.ktor:ktor-server-netty-jvm")
    implementation("ch.qos.logback:logback-classic:$logback_version")
    testImplementation("io.ktor:ktor-server-tests-jvm")
    testImplementation("org.jetbrains.kotlin:kotlin-test-junit:$kotlin_version")
}

ktor {
    fatJar {
        archiveFileName.set("fat.jar")
    }

    docker {
        jreVersion.set(JavaVersion.VERSION_17)
        localImageName.set("sample-ktor-books")
        imageTag.set("0.0.1-preview")
        portMappings.set(
            listOf(
                io.ktor.plugin.features.DockerPortMapping(
                    80,
                    8080,
                    io.ktor.plugin.features.DockerPortMappingProtocol.TCP
                )
            )
        )

//        externalRegistry.set(
//            io.ktor.plugin.features.DockerImageRegistry.dockerHub(
//                appName = provider { "sample-ktor-books" },
//                username = providers.environmentVariable("DOCKER_HUB_USERNAME"),
//                password = providers.environmentVariable("DOCKER_HUB_PASSWORD")
//            )
//        )
    }
}
