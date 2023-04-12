pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
        jcenter()
        maven("https://dl.bintray.com/lisawray/maven")
        maven("https://dl.bintray.com/kotlin/kotlin-eap")
        maven("https://dl.bintray.com/kodein-framework/kodein-dev")
        //maven { url 'https://mvnrepository.com/artifact' }
    }
}

gradle.settingsEvaluated {
    dependencyResolutionManagement {
        repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
        repositories {
            google()
            mavenCentral()
            //google()
            jcenter()
            maven("https://dl.bintray.com/lisawray/maven")
            //maven { url 'https://mvnrepository.com/artifact' }
            maven("https://jitpack.io")  // <--
            //jcenter() // Warning: this repository is going to shut down soon
            maven("https://dl.bintray.com/kotlin/kotlin-eap")
            maven("https://dl.bintray.com/kodein-framework/kodein-dev")
        }
    }
}

rootProject.name = "myweather2"

include("app")


//pluginManagement {
//    repositories {
//        google()
//        mavenCentral()
//        gradlePluginPortal()
//        jcenter()
//        maven { url 'https://dl.bintray.com/lisawray/maven' }
//        maven { url 'https://dl.bintray.com/kotlin/kotlin-eap' }
//        maven { url "https://dl.bintray.com/kodein-framework/kodein-dev" }
////        maven { url 'https://mvnrepository.com/artifact' }
//    }
//}
//dependencyResolutionManagement {
//    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
//    repositories {
//        google()
//        mavenCentral()
//        //        google()
//        jcenter()
//
//        maven { url 'https://dl.bintray.com/lisawray/maven' }
////        maven { url 'https://mvnrepository.com/artifact' }
//        maven { url 'https://jitpack.io' }  // <--
////        jcenter() // Warning: this repository is going to shut down soon
//        maven { url 'https://dl.bintray.com/kotlin/kotlin-eap' }
//        maven { url "https://dl.bintray.com/kodein-framework/kodein-dev" }
//    }
//}
//rootProject.name = "myweather2"
//
//
//include ("app")
//dependencyResolutionManagement {
//    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
//    repositories {
//        google()
//        mavenCentral()
//        maven { url 'https://jitpack.io' }  // <--
//        jcenter() // Warning: this repository is going to shut down soon
//    }
//}
