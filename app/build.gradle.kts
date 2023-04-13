plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("kotlin-kapt")
    id("kotlin-android")
    id("androidx.navigation.safeargs")

}


android {
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        viewBinding = true

        compose = true
    }
    composeOptions {
//        kotlinCompilerVersion "1.6.21"
//        kotlinCompilerExtensionVersion "1.2.0-rc02"
        kotlinCompilerVersion = "1.8.0"
        kotlinCompilerExtensionVersion = "1.4.0"
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
//    composeOptions {
//        kotlinCompilerExtensionVersion = "1.4.1"
//    }


    compileSdk = 33
    defaultConfig {
        applicationId = "com.dreamer.myweather2"
        minSdk = 26
        targetSdk = 33
        versionCode = 5
        versionName = "1.0.5"
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }
    buildTypes {
        getByName("debug") {
            isDebuggable = true
        }
        getByName("release") {
            isMinifyEnabled = true
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    namespace = "com.dreamer.myweather2"

    packagingOptions {
        resources {
            excludes.add("/META-INF/{AL2.0,LGPL2.1}")
        }
    }

}
val composeVersion =
    rootProject.extra.get("compose_version") as String
val appcompatVersion =
    rootProject.extra.get("appcompat_version") as String
val navigationVersion =
    rootProject.extra.get("navigation_version") as String
val core_ktx_version =
    rootProject.extra.get("core_ktx_version") as String
val constraintlayout_version =
    rootProject.extra.get("constraintlayout_version") as String
val room_version =
    rootProject.extra.get("room_version") as String
val google_gson_version =
    rootProject.extra.get("google_gson_version") as String
val kotlinx_coroutines_version =
    rootProject.extra.get("kotlinx_coroutines_version") as String
val retrofit_version =
    rootProject.extra.get("retrofit_version") as String
val okhttp3_version =
    rootProject.extra.get("okhttp3_version") as String

val lifecycle_version =
    rootProject.extra.get("lifecycle_version") as String
val kodein_version =
    rootProject.extra.get("kodein_version") as String
val legacy_support_version =
    rootProject.extra.get("legacy_support_version") as String
val groupie_version =
    rootProject.extra.get("groupie_version") as String
//val legacy_support_version =
//    rootProject.extra.get("legacy_support_version") as String


//androidExtensions {
//    experimental = true
//}
//val myValue = project.property(CONSTANTS.KOTLIN) as String
//apply(from = "Constants.kt")
dependencies {

    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))
    implementation("org.jetbrains.kotlin:kotlin-script-runtime")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk7:${CONSTANTS.KOTLIN}")
    implementation("androidx.appcompat:appcompat:$appcompatVersion")
    implementation("androidx.appcompat:appcompat-resources:$appcompatVersion")


    //jetpack compose
    implementation("androidx.compose.runtime:runtime:$composeVersion")
    implementation("androidx.compose.runtime:runtime-livedata:$composeVersion")
    implementation("androidx.compose.ui:ui:$composeVersion")
    implementation("androidx.compose.material:material:$composeVersion")
    implementation("androidx.compose.compiler:compiler:$composeVersion")
    implementation("androidx.compose.animation:animation:$composeVersion")


    // Android Studio Preview support
    implementation("androidx.compose.ui:ui-tooling-preview:$composeVersion")
    debugImplementation("androidx.compose.ui:ui-tooling:$composeVersion")

    // Navigation
    implementation("android.arch.navigation:navigation-fragment:$navigationVersion")
    implementation("android.arch.navigation:navigation-ui:$navigationVersion")
    implementation("android.arch.navigation:navigation-fragment-ktx:$navigationVersion")
    implementation("android.arch.navigation:navigation-ui-ktx:$navigationVersion")

    implementation("androidx.core:core-ktx:$core_ktx_version")
    implementation("androidx.constraintlayout:constraintlayout:$constraintlayout_version")

    // Room
    implementation("androidx.room:room-runtime:$room_version")
    implementation("androidx.legacy:legacy-support-v4:$legacy_support_version")


    kapt("androidx.room:room-compiler:$room_version")

    // Gson
    implementation("com.google.code.gson:gson:$google_gson_version")

    // Kotlin Android Coroutines
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:$kotlinx_coroutines_version")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:$kotlinx_coroutines_version")

    // Retrofit
    implementation("com.squareup.retrofit2:retrofit:$retrofit_version")
    implementation("com.squareup.retrofit2:converter-gson:$retrofit_version")
    implementation("com.jakewharton.retrofit:retrofit2-kotlin-coroutines-adapter:0.9.2")
    implementation("com.squareup.okhttp3:logging-interceptor:$okhttp3_version")
    implementation("com.squareup.okhttp3:okhttp:$okhttp3_version")

    // ViewModel
    implementation("androidx.lifecycle:lifecycle-extensions:$lifecycle_version")
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:$lifecycle_version")
    //noinspection LifecycleAnnotationProcessorWithJava8
    kapt("androidx.lifecycle:lifecycle-compiler:$lifecycle_version")

    // Kodein
    implementation("org.kodein.di:kodein-di-conf:$kodein_version")
    implementation("org.kodein.di:kodein-di-generic-jvm:$kodein_version")
    implementation("org.kodein.di:kodein-di-framework-android-x:$kodein_version")
    implementation("org.kodein.di:kodein-di-framework-android-core:$kodein_version")
//    implementation 'org.kodein.di:kodein-di-framework-compose:6.12.0'
//    implementation "org.kodein.di:kodein-di-framework-android-x-viewmodel:$kodein_version"
//    implementation "org.kodein.di:kodein-di-framework-android-x-viewmodel-savedstate:$kodein_version"
//    implementation 'org.kodein.di:kodein-di-framework-android-???:7.19.0'
//    implementation "org.kodein.di:kodein-di-core:$kodein_version"
//    implementation "org.kodein.di:kodein-di-framework-android-compose:$kodein_composeVersion"

    // Better dateTime-time support even on older Android versions
    implementation("com.jakewharton.threetenabp:threetenabp:1.2.4")

    // Glide
    implementation("com.github.bumptech.glide:glide:4.10.0")
    kapt("com.github.bumptech.glide:compiler:4.10.0")
    implementation("com.github.bumptech.glide:okhttp3-integration:4.7.1")
//    {
////        exclude group: 'glide-parent'
//    }

    //PICASSO
    implementation("com.squareup.picasso:picasso:2.71828")

    //Circle Img Lib
    implementation("de.hdodenhof:circleimageview:3.0.1")

    // Groupie RecyclerView
    implementation("com.xwray:groupie:$groupie_version")
    implementation("com.github.lisawray.groupie:groupie-viewbinding:$groupie_version")

    // Preference
    implementation("androidx.preference:preference-ktx:1.1.0")

    // WeatherLocation
    implementation("com.google.android.gms:play-services-location:17.0.0")
//    implementation 'android.arch.navigation:navigation-safe-args-gradle-plugin:1.0.0-alpha07'

    // New Material Design
    implementation("com.google.android.material:material:1.1.0")

    testImplementation("junit:junit:4.12")
    androidTestImplementation("androidx.test:runner:1.3.0-alpha02")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.3.0-alpha02")

}
