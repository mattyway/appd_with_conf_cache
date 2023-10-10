pluginManagement {
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
    }

    resolutionStrategy {
        eachPlugin {
            when (requested.id.id) {
                "adeum" -> useModule("com.appdynamics:appdynamics-gradle-plugin:23.7.1")
            }
        }
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}
rootProject.name = "AppDWithBuildConf"
include (":app")
    include(":feature1")
    project(":feature1").projectDir = File(rootDir,"features/feature1")
