import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

repositories {
    jcenter()
    mavenCentral()
}

plugins {

    kotlin("jvm") version "1.3.72"
    war
}

val staging:Configuration by configurations.creating
dependencies {
    implementation(kotlin("stdlib-jdk8"))

    staging("com.heroku:webapp-runner-main:9.0.31.0")

    implementation("javax.servlet:javax.servlet-api:3.1.0")
    implementation("com.google.inject.extensions:guice-servlet:4.2.3")

    implementation("com.google.inject:guice:4.2.3")
    implementation("com.google.inject.extensions:guice-persist:4.2.3")

    implementation("com.h2database:h2:1.4.200")

    implementation("org.hibernate:hibernate-c3p0:5.4.15.Final")

    implementation("org.flywaydb:flyway-core:6.3.2")

    implementation("org.hibernate:hibernate-entitymanager:5.4.15.Final")
    implementation("org.hibernate.javax.persistence:hibernate-jpa-2.1-api:1.0.2.Final")
    implementation("org.hibernate:hibernate-core:5.4.15.Final")

    implementation("com.google.code.gson:gson:2.8.6")
}

tasks {
    val copyToLib by registering(Copy::class) {
        into("$buildDir/server")
        from(staging) {
            include("webapp-runner*")
        }
    }

    register("stage") {
        dependsOn(war, copyToLib)
    }
}

val compileKotlin: KotlinCompile by tasks
compileKotlin.kotlinOptions {
    jvmTarget = "1.8"
}
val compileTestKotlin: KotlinCompile by tasks
compileTestKotlin.kotlinOptions {
    jvmTarget = "1.8"
}