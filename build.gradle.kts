// Top-level build file where you can add configuration options common to all sub-projects/modules.

//buildscript {
//    ext
//            {
//                kotlin_version = '1.8.0'
//                room_version = '2.2.1'
//                navigation_version = '1.0.0'
//                kodein_version = '6.1.0'
////    ext.kodein_version = '7.18.0'
//                kodein_di_version = '7.18.0'
//                kodein_compose_version = '7.18.0'
//                lifecycle_version = '2.1.0'
//                retrofit_version = '2.6.2'
//                compose_version = '1.4.1'
//                appcompat_version = '1.6.1'
//                okhttp3_version = '4.7.2'
//                groupie_version = '2.8.1'
//                core_ktx_version = '1.7.0'
//                constraintlayout_version = '1.1.3'
//                legacy_support_version = '1.0.0'
//                google_gson_version = '2.8.6'
//                kotlinx_coroutines_version = '1.3.4'
//            }
//    dependencies {
//        classpath("com.android.tools.build:gradle:7.4.2")
//        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:${ext.kotlin_version}")
//        classpath("android.arch.navigation:navigation-safe-args-gradle-plugin:1.0.0-alpha07")
// NOTE: Do not place your application dependencies here; they belong
// in the individual module build.gradle files


// Top-level build file where you can add configuration options common to all sub-projects/modules.
//plugins {
//    id 'com.android.application' version '7.4.2' apply false
//    id 'com.android.library' version '7.4.2' apply false
//    id 'org.jetbrains.kotlin.android' version '1.8.0' apply false
//    id 'androidx.navigation.safeargs' version '2.4.2' apply false
//
//}

buildscript {
    extra.apply {
        set("compose_version", "1.0.0")
        set("kotlin_version", "1.8.0")
        set("room_version", "2.2.1")
        set("navigation_version", "1.0.0")
        set("kodein_version", "6.1.0")
//    ext.kodein_version,"7.18.0")
        set("kodein_di_version", "7.18.0")
        set("kodein_compose_version", "7.18.0")
        set("lifecycle_version", "2.1.0")
        set("retrofit_version", "2.6.2")
        set("compose_version", "1.4.1")
        set("appcompat_version", "1.6.1")
        set("okhttp3_version", "4.7.2")
        set("groupie_version", "2.8.1")
        set("core_ktx_version", "1.7.0")
        set("constraintlayout_version", "1.1.3")
        set("legacy_support_version", "1.0.0")
        set("google_gson_version", "2.8.6")
        set("kotlinx_coroutines_version", "1.3.4")
    }
    //    ext
//            {
//                kotlin_version = '1.8.0'
//                room_version = '2.2.1'
//                navigation_version = '1.0.0'
//                kodein_version = '6.1.0'
////    ext.kodein_version = '7.18.0'
//                kodein_di_version = '7.18.0'
//                kodein_compose_version = '7.18.0'
//                lifecycle_version = '2.1.0'
//                retrofit_version = '2.6.2'
//                compose_version = '1.4.1'
//                appcompat_version = '1.6.1'
//                okhttp3_version = '4.7.2'
//                groupie_version = '2.8.1'
//                core_ktx_version = '1.7.0'
//                constraintlayout_version = '1.1.3'
//                legacy_support_version = '1.0.0'
//                google_gson_version = '2.8.6'
//                kotlinx_coroutines_version = '1.3.4'
//            }
    repositories {
        google()
        mavenCentral()
        jcenter()
//        maven { url 'https://dl.bintray.com/lisawray/maven' }
//        maven { url 'https://dl.bintray.com/kotlin/kotlin-eap' }
//        maven{ url "https://dl.bintray.com/kodein-framework/kodein-dev"}
//        maven { url 'https://mvnrepository.com/artifact' }
    }



    dependencies {
        classpath("com.android.tools.build:gradle:7.4.2")

        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.8.0")
        classpath("android.arch.navigation:navigation-safe-args-gradle-plugin:1.0.0-alpha07")
        // NOTE: Do not place your application dependencies here; they belong
        // in the individual module build.gradle files
    }
}




tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}
