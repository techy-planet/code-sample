plugins {
	java
	id("org.springframework.boot") version "3.1.5"
	id("io.spring.dependency-management") version "1.1.3"
	id("org.graalvm.buildtools.native") version "0.9.27"
}

group = "com.techyplanet"
version = "0.0.1-SNAPSHOT"

java {
	sourceCompatibility = JavaVersion.VERSION_17
	// Changed from 21 to 17 for JRE docker images
}

repositories {
	mavenCentral()
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-webflux")
	testImplementation("org.springframework.boot:spring-boot-starter-test")
	testImplementation("io.projectreactor:reactor-test")
}

tasks.withType<Test> {
	useJUnitPlatform()
}


graalvmNative {
	binaries {
		val main by getting {
			//Reference Mostly Static Images - https://www.graalvm.org/22.0/reference-manual/native-image/StaticImages/
			buildArgs("-H:+StaticExecutableWithDynamicLibC")
		}
	}
}