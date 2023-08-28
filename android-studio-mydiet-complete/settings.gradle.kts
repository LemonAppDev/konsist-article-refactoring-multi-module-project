pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "mydiet-complete"
include(":app")
include(":featureCaloryCalculator")
include(":featureGroceryListGenerator")
include(":featureMealPlanner")
