plugins {
    id("java")
    id("application")
    id("jacoco")
    id("io.freefair.lombok") version "8.4"
}

application {
    mainClass.set("org.example.App")
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")

    implementation("com.fasterxml.jackson.core:jackson-databind:2.15.1")

}

tasks.test {
    useJUnitPlatform()
}
