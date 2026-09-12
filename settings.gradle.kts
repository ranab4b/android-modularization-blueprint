pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}

plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "1.0.0"
}

dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "android-modularization-blueprint"

include(":app")
include(":core:core-common")
include(":core:core-ui")
include(":core:core-network")
include(":core:core-database")
include(":feature:feature-home")
include(":feature:feature-detail")
include(":feature:feature-settings")
