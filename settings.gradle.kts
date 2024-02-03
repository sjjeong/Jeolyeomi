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
        maven("https://devrepo.kakao.com/nexus/content/groups/public/")
    }
}

rootProject.name = "Jeolyeomi"
include(":app")
include(":feature:signin")
include(":core:ui")
include(":feature:splash")
include(":feature:main")
include(":feature:home")
include(":feature:history")
include(":feature:profile")
include(":core:navigation")
