plugins {
    id("java")
    kotlin("jvm")
}

group = "oop.project.research"
version = "1.0.0"

repositories {
    mavenCentral()
}

dependencies {
    implementation("com.google.guava:guava:33.3.0-jre")
    implementation("net.sourceforge.argparse4j:argparse4j:0.9.0")
    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    implementation(kotlin("stdlib-jdk8"))
}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(21)
}