plugins {
  id("io.gitlab.arturbosch.detekt")
  id("com.diffplug.spotless")
  id("org.jetbrains.dokka")
  id("com.vanniktech.maven.publish") apply false
}

allprojects {
  repositories {
    google()
    mavenCentral()
    jcenter()
  }
}

subprojects {
  apply {
    plugin("io.gitlab.arturbosch.detekt")
    plugin("com.diffplug.spotless")
  }

  detekt {
    config = rootProject.files("config/detekt/detekt.yml")
    reports {
      html {
        enabled = true
        destination = file("build/reports/detekt.html")
      }
    }
  }

  spotless {
    kotlin {
      target("**/*.kt")
      targetExclude("$buildDir/**/*.kt", "bin/**/*.kt")

      ktlint("0.9.0").userData(
        mapOf(
          "indent_size" to "2",
          "continuation_indent_size" to "2"
        )
      )
    }
  }
}

tasks.dokkaHtmlMultiModule.configure {
  outputDirectory.set(rootDir.resolve("docs/api"))
}
