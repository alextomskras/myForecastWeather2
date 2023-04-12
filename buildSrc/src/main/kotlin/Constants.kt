object CONSTANTS {
    val versionName = "7.0.15" // X.Y.Z; X = Major, Y = minor, Z = Patch level
    private val versionCodeBase = 70150 // XYYZZM; M = Module (tv, mobile)
    val versionCodeMobile = versionCodeBase + 3

    const val COMPILE_SDK = 31
    const val TARGET_SDK = 30
    const val MIN_SDK = 21

    const val ANDROID_GRADLE_PLUGIN = "7.2.0"
    const val BENCHMARK = "1.1.0-rc02"
    const val COMPOSE = "1.1.1"
    const val FIREBASE_CRASHLYTICS = "2.3.0"
    const val GOOGLE_SERVICES = "4.3.3"
    const val HILT_AGP = "2.40.5"
    const val KOTLIN = "1.8.0"
    const val NAVIGATION = "2.4.1"
    const val PROFILE_INSTALLER = "1.2.0-beta01"

    // TODO: Remove this once the version for
    //  "org.threeten:threetenbp:${Versions.threetenbp}:no-tzdb" using java-platform in the
    //  depconstraints/build.gradle.kts is defined
    const val THREETENBP = "1.3.6"
}
//    val compose_version = "1.0.0"
//    val appcompat_version = "1.3.1"
//    set("kotlin_version", "1.8.0")
//    set("room_version","2.2.1")
//    set("navigation_version","1.0.0")
//    set("kodein_version","6.1.0")
////    ext.kodein_version,"7.18.0")
//    set("kodein_di_version","7.18.0")
//    set("kodein_compose_version","7.18.0")
//    set("lifecycle_version","2.1.0")
//    set("retrofit_version","2.6.2")
//    set("compose_version","1.4.1")
//    set("appcompat_version","1.6.1")
//    set("okhttp3_version","4.7.2")
//    set("groupie_version","2.8.1")
//    set("core_ktx_version","1.7.0")
//    set("constraintlayout_version","1.1.3")
//    set("legacy_support_version","1.0.0")
//    set("google_gson_version","2.8.6")
//    set("kotlinx_coroutines_version","1.3.4")
