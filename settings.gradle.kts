import de.fayard.refreshVersions.bootstrapRefreshVersions

pluginManagement {
  repositories {
    gradlePluginPortal()
    google()
    mavenCentral()
    jcenter()
  }
}

buildscript {
  repositories { gradlePluginPortal() }
  dependencies.classpath("de.fayard.refreshVersions:refreshVersions:0.9.5")
}

bootstrapRefreshVersions()

rootProject.name = "kotlin-android-template"

include(
  "app",
  "library-android",
  "library-kotlin"
)
