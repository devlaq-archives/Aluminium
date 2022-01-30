plugins {
    java
    `maven-publish`
}

group = "com.github.devlaq"
version = "1.1.4"

repositories {
    mavenCentral()
    maven { url = uri("https://papermc.io/repo/repository/maven-public/") }
}

dependencies {
    implementation("io.papermc.paper:paper-api:1.18.1-R0.1-SNAPSHOT")
}

tasks.withType<Jar> {
    archiveBaseName.set("Aluminium")
}

tasks.getByName<Test>("test") {
    useJUnitPlatform()
}

java {
    toolchain.languageVersion.set(JavaLanguageVersion.of(17))
}