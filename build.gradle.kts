plugins {
    id("java")
}

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(22))
    }
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

defaultTasks("clean", "test")

tasks.clean {
    delete("target")
}

tasks.test {
    testLogging.showStandardStreams = true
    ignoreFailures = true
    dependsOn(tasks.clean)
}

tasks.withType<Test> {
    systemProperty("driver", System.getProperty("driver"))
    systemProperty("driverArguments", System.getProperty("driverArguments"))
}

dependencies {
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.8.1")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.8.1")
    testImplementation("org.seleniumhq.selenium:selenium-java:4.24.0")
    testImplementation("org.assertj:assertj-core:3.26.3")
    testImplementation("ch.qos.logback:logback-classic:1.5.6")
    testImplementation("ch.qos.logback:logback-core:1.5.6")
    testImplementation("org.slf4j:slf4j-simple:2.0.16")
    testImplementation("commons-io:commons-io:2.16.1")
}

tasks.getByName<Test>("test") {
    useJUnitPlatform()
}