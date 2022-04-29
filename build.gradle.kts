plugins {
    id("org.springframework.boot") version "2.6.7"
    id("io.spring.dependency-management") version "1.0.11.RELEASE"
    id("com.github.johnrengelman.shadow") version "7.1.2"

    kotlin("jvm") version "1.6.21"
    kotlin("plugin.spring") version "1.6.21"
    kotlin("plugin.serialization") version "1.6.10"
}

group = "dev.simpletimer"
version = "0.0.0"

repositories {
    mavenCentral()
}

dependencies {
    //SpringBoot
    implementation("org.springframework.boot","spring-boot-starter-web")

    //Yaml
    implementation("com.charleskorn.kaml","kaml","0.43.0")
}

val jar by tasks.getting(Jar::class) {
    manifest {
        attributes["Main-Class"] = "dev.simpletimer.simpletimer_webapi.SimpleTimerWebAPI"
    }

    from(
        configurations.runtimeClasspath.get().map {
            if (it.isDirectory) it else zipTree(it)
        }
    )

    exclude("META-INF/*.RSA", "META-INF/*.SF", "META-INF/*.DSA")
}
