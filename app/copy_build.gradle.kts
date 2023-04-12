//plugins {
//    id 'com.android.application'
//    id 'org.jetbrains.kotlin.android'
//    id 'kotlin-kapt'
//    id 'kotlin-android'
//    id 'androidx.navigation.safeargs'
//}
//
//
//android {
//    kotlinOptions {
//        jvmTarget = '1.8'
//    }
//    buildFeatures {
//        viewBinding true
//
//        compose true
//    }
//    composeOptions {
////        kotlinCompilerVersion "1.6.21"
////        kotlinCompilerExtensionVersion "1.2.0-rc02"
//        kotlinCompilerVersion "1.8.0"
//        kotlinCompilerExtensionVersion "1.4.0"
//    }
//    compileOptions {
//        sourceCompatibility JavaVersion.VERSION_1_8
//        targetCompatibility JavaVersion.VERSION_1_8
//    }
////    composeOptions {
////        kotlinCompilerExtensionVersion = "1.4.1"
////    }
//
//
//    compileSdk 33
//    defaultConfig {
//        applicationId "com.dreamer.myweather2"
//        minSdk 26
//        targetSdkVersion 33
//        versionCode 5
//        versionName "1.0.5"
//        testInstrumentationRunner "androidx.test.runner.AndroidJUnitRunner"
//        vectorDrawables {
//            useSupportLibrary true
//        }
//    }
//    buildTypes {
//        release {
//            minifyEnabled false
//            proguardFiles getDefaultProguardFile('proguard-android-optimize.txt'), 'proguard-rules.pro'
//        }
//    }
//    namespace 'com.dreamer.myweather2'
//
//    packagingOptions {
//        resources {
//            excludes += '/META-INF/{AL2.0,LGPL2.1}'
//        }
//    }
//
//}
//
////androidExtensions {
////    experimental = true
////}
//
//dependencies {
//
//
//
//
//    implementation fileTree(dir: 'libs', include: ['*.jar'])
//    implementation "org.jetbrains.kotlin:kotlin-stdlib-jdk7:$kotlin_version"
//    implementation "androidx.appcompat:appcompat:$appcompat_version"
//    implementation "androidx.appcompat:appcompat-resources:$appcompat_version"
//
//
//    //jetpack compose
//    implementation "androidx.compose.runtime:runtime:$compose_version"
//    implementation "androidx.compose.runtime:runtime-livedata:$compose_version"
//    implementation "androidx.compose.ui:ui:$compose_version"
//    implementation "androidx.compose.material:material:$compose_version"
//    implementation "androidx.compose.compiler:compiler:$compose_version"
//    implementation "androidx.compose.animation:animation:$compose_version"
//
//
//    // Android Studio Preview support
//    implementation "androidx.compose.ui:ui-tooling-preview:$compose_version"
//    debugImplementation "androidx.compose.ui:ui-tooling:$compose_version"
//
//    // Navigation
//    implementation "android.arch.navigation:navigation-fragment:$navigation_version"
//    implementation "android.arch.navigation:navigation-ui:$navigation_version"
//    implementation "android.arch.navigation:navigation-fragment-ktx:$navigation_version"
//    implementation "android.arch.navigation:navigation-ui-ktx:$navigation_version"
//
//    implementation "androidx.core:core-ktx:$core_ktx_version"
//    implementation "androidx.constraintlayout:constraintlayout:$constraintlayout_version"
//
//    // Room
//    implementation "androidx.room:room-runtime:$room_version"
//    implementation "androidx.legacy:legacy-support-v4:$legacy_support_version"
//
//
//    kapt "androidx.room:room-compiler:$room_version"
//
//    // Gson
//    implementation "com.google.code.gson:gson:$google_gson_version"
//
//    // Kotlin Android Coroutines
//    implementation "org.jetbrains.kotlinx:kotlinx-coroutines-core:$kotlinx_coroutines_version"
//    implementation "org.jetbrains.kotlinx:kotlinx-coroutines-android:$kotlinx_coroutines_version"
//
//    // Retrofit
//    implementation "com.squareup.retrofit2:retrofit:$retrofit_version"
//    implementation "com.squareup.retrofit2:converter-gson:$retrofit_version"
//    implementation 'com.jakewharton.retrofit:retrofit2-kotlin-coroutines-adapter:0.9.2'
//    implementation "com.squareup.okhttp3:logging-interceptor:$okhttp3_version"
//    implementation("com.squareup.okhttp3:okhttp:$okhttp3_version")
//
//    // ViewModel
//    implementation "androidx.lifecycle:lifecycle-extensions:$lifecycle_version"
//    implementation "androidx.lifecycle:lifecycle-viewmodel-ktx:$lifecycle_version"
//    //noinspection LifecycleAnnotationProcessorWithJava8
//    kapt "androidx.lifecycle:lifecycle-compiler:$lifecycle_version"
//
//    // Kodein
//    implementation "org.kodein.di:kodein-di-conf:$kodein_version"
//    implementation "org.kodein.di:kodein-di-generic-jvm:$kodein_version"
//    implementation "org.kodein.di:kodein-di-framework-android-x:$kodein_version"
//    implementation "org.kodein.di:kodein-di-framework-android-core:$kodein_version"
////    implementation 'org.kodein.di:kodein-di-framework-compose:6.12.0'
////    implementation "org.kodein.di:kodein-di-framework-android-x-viewmodel:$kodein_version"
////    implementation "org.kodein.di:kodein-di-framework-android-x-viewmodel-savedstate:$kodein_version"
////    implementation 'org.kodein.di:kodein-di-framework-android-???:7.19.0'
////    implementation "org.kodein.di:kodein-di-core:$kodein_version"
////    implementation "org.kodein.di:kodein-di-framework-android-compose:$kodein_compose_version"
//
//    // Better dateTime-time support even on older Android versions
//    implementation 'com.jakewharton.threetenabp:threetenabp:1.2.4'
//
//    // Glide
//    implementation 'com.github.bumptech.glide:glide:4.10.0'
//    kapt 'com.github.bumptech.glide:compiler:4.10.0'
//    implementation('com.github.bumptech.glide:okhttp3-integration:4.7.1') {
//        exclude group: 'glide-parent'
//    }
//
//    //PICASSO
//    implementation 'com.squareup.picasso:picasso:2.71828'
//
//    //Circle Img Lib
//    implementation 'de.hdodenhof:circleimageview:3.0.1'
//
//    // Groupie RecyclerView
//    implementation "com.xwray:groupie:$groupie_version"
//    implementation "com.github.lisawray.groupie:groupie-viewbinding:$groupie_version"
//
//    // Preference
//    implementation 'androidx.preference:preference-ktx:1.1.0'
//
//    // WeatherLocation
//    implementation 'com.google.android.gms:play-services-location:17.0.0'
////    implementation 'android.arch.navigation:navigation-safe-args-gradle-plugin:1.0.0-alpha07'
//
//    // New Material Design
//    implementation "com.google.android.material:material:1.1.0"
//
//    testImplementation 'junit:junit:4.12'
//    androidTestImplementation 'androidx.test:runner:1.3.0-alpha02'
//    androidTestImplementation 'androidx.test.espresso:espresso-core:3.3.0-alpha02'
//
//}

//plugins {
//    `com.android.application`
//    `org.jetbrains.kotlin.android`
//    `androidx.navigation.safeargs.kotlin`
//}
//
//android {
//    compileSdkVersion(31)
//
//    defaultConfig {
//        applicationId = "com.example.myweather2"
//        minSdkVersion(23)
//        targetSdkVersion(31)
//        versionCode = 1
//        versionName = "1.0"
//        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
//    }
//
//    buildTypes {
//        getByName("debug") {
//            isDebuggable = true
//        }
//        getByName("release") {
//            isMinifyEnabled = false
//            proguardFiles(
//                getDefaultProguardFile("proguard-android-optimize.txt"),
//                "proguard-rules.pro"
//            )
//        }
//    }
//
//    compileOptions {
//        sourceCompatibility = JavaVersion.VERSION_1_8
//        targetCompatibility = JavaVersion.VERSION_1_8
//    }
//
//    kotlinOptions {
//        jvmTarget = "1.8"
//    }
//
//    buildFeatures {
//        viewBinding = true
//        dataBinding = true
//    }
//
//    packagingOptions {
//        exclude("META-INF/*.kotlin_module")
//    }
//}
//
//dependencies {
//    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))
//    implementation("androidx.appcompat:appcompat:${ext.appcompat_version}")
//    implementation("androidx.constraintlayout:constraintlayout:${ext.constraintlayout_version}")
//    implementation("androidx.legacy:legacy-support-v4:${ext.legacy_support_version}")
//    implementation("androidx.navigation:navigation-fragment-ktx:${ext.navigation_version}")
//    implementation("androidx.navigation:navigation-ui-ktx:${ext.navigation_version}")
//    implementation("androidx.lifecycle:lifecycle-extensions:${ext.lifecycle_version}")
//    implementation("androidx.lifecycle:lifecycle-livedata-ktx:${ext.lifecycle_version}")
//    implementation("com.google.code.gson:gson:${ext.google_gson_version}")
//    implementation("com.squareup.okhttp3:okhttp:${ext.okhttp3_version}")
//    implementation("com.squareup.okhttp3:logging-interceptor:${ext.okhttp3_version}")
//    implementation("com.squareup.retrofit2:retrofit:${ext.retrofit_version}")
//    implementation("com.squareup.retrofit2:converter-gson:${ext.retrofit_version}")
//    implementation("com.squareup.retrofit2:adapter-rxjava:${ext.retrofit_version}")
//    implementation("io.reactivex.rxjava2:rxjava:${ext.rxjava2_version}")
//    implementation("io.reactivex.rxjava2:rxandroid:${ext.rxandroid_version}")
//    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk7:${kotlin_version}")
//    implementation("org.kodein.di:kodein-di:${ext.kodein_di_version}")
//    implementation("org.kodein.di:kodein-di-framework-android-x:${ext.kodein_di_version}")
//    implementation("org.kodein.di:kodein-di-generic-jvm:${ext.kodein_di_version}")
//    implementation("org.kodein.di:kodein-di-erased-jvm:${ext.kodein_di_version}")
//    implementation("org.kodein.di:kodein-di-compose-jvm:${ext.kodein_compose_version}")
//    implementation("androidx.core:core-ktx:${ext.core_ktx_version}")
//    implementation("com.xwray:groupie:${ext.groupie_version}")
//    implementation("com.xwray:groupie-kotlin-android-extensions:${ext.groupie_version}")
//    implementation("androidx.room:room
//
//}


//dependencies {
//
//
//
//
//    implementation fileTree(dir: 'libs', include: ['*.jar'])
//    implementation "org.jetbrains.kotlin:kotlin-stdlib-jdk7:$kotlin_version"
//    implementation "androidx.appcompat:appcompat:$appcompat_version"
//    implementation "androidx.appcompat:appcompat-resources:$appcompat_version"
//
//
//    //jetpack compose
//    implementation "androidx.compose.runtime:runtime:$compose_version"
//    implementation "androidx.compose.runtime:runtime-livedata:$compose_version"
//    implementation "androidx.compose.ui:ui:$compose_version"
//    implementation "androidx.compose.material:material:$compose_version"
//    implementation "androidx.compose.compiler:compiler:$compose_version"
//    implementation "androidx.compose.animation:animation:$compose_version"
//
//
//    // Android Studio Preview support
//    implementation "androidx.compose.ui:ui-tooling-preview:$compose_version"
//    debugImplementation "androidx.compose.ui:ui-tooling:$compose_version"
//
//    // Navigation
//    implementation "android.arch.navigation:navigation-fragment:$navigation_version"
//    implementation "android.arch.navigation:navigation-ui:$navigation_version"
//    implementation "android.arch.navigation:navigation-fragment-ktx:$navigation_version"
//    implementation "android.arch.navigation:navigation-ui-ktx:$navigation_version"
//
//    implementation "androidx.core:core-ktx:$core_ktx_version"
//    implementation "androidx.constraintlayout:constraintlayout:$constraintlayout_version"
//
//    // Room
//    implementation "androidx.room:room-runtime:$room_version"
//    implementation "androidx.legacy:legacy-support-v4:$legacy_support_version"
//
//
//    kapt "androidx.room:room-compiler:$room_version"
//
//    // Gson
//    implementation "com.google.code.gson:gson:$google_gson_version"
//
//    // Kotlin Android Coroutines
//    implementation "org.jetbrains.kotlinx:kotlinx-coroutines-core:$kotlinx_coroutines_version"
//    implementation "org.jetbrains.kotlinx:kotlinx-coroutines-android:$kotlinx_coroutines_version"
//
//    // Retrofit
//    implementation "com.squareup.retrofit2:retrofit:$retrofit_version"
//    implementation "com.squareup.retrofit2:converter-gson:$retrofit_version"
//    implementation 'com.jakewharton.retrofit:retrofit2-kotlin-coroutines-adapter:0.9.2'
//    implementation "com.squareup.okhttp3:logging-interceptor:$okhttp3_version"
//    implementation("com.squareup.okhttp3:okhttp:$okhttp3_version")
//
//    // ViewModel
//    implementation "androidx.lifecycle:lifecycle-extensions:$lifecycle_version"
//    implementation "androidx.lifecycle:lifecycle-viewmodel-ktx:$lifecycle_version"
//    //noinspection LifecycleAnnotationProcessorWithJava8
//    kapt "androidx.lifecycle:lifecycle-compiler:$lifecycle_version"
//
//    // Kodein
//    implementation "org.kodein.di:kodein-di-conf:$kodein_version"
//    implementation "org.kodein.di:kodein-di-generic-jvm:$kodein_version"
//    implementation "org.kodein.di:kodein-di-framework-android-x:$kodein_version"
//    implementation "org.kodein.di:kodein-di-framework-android-core:$kodein_version"
////    implementation 'org.kodein.di:kodein-di-framework-compose:6.12.0'
////    implementation "org.kodein.di:kodein-di-framework-android-x-viewmodel:$kodein_version"
////    implementation "org.kodein.di:kodein-di-framework-android-x-viewmodel-savedstate:$kodein_version"
////    implementation 'org.kodein.di:kodein-di-framework-android-???:7.19.0'
////    implementation "org.kodein.di:kodein-di-core:$kodein_version"
////    implementation "org.kodein.di:kodein-di-framework-android-compose:$kodein_compose_version"
//
//    // Better dateTime-time support even on older Android versions
//    implementation 'com.jakewharton.threetenabp:threetenabp:1.2.4'
//
//    // Glide
//    implementation 'com.github.bumptech.glide:glide:4.10.0'
//    kapt 'com.github.bumptech.glide:compiler:4.10.0'
//    implementation('com.github.bumptech.glide:okhttp3-integration:4.7.1') {
//        exclude group: 'glide-parent'
//    }
//
//    //PICASSO
//    implementation 'com.squareup.picasso:picasso:2.71828'
//
//    //Circle Img Lib
//    implementation 'de.hdodenhof:circleimageview:3.0.1'
//
//    // Groupie RecyclerView
//    implementation "com.xwray:groupie:$groupie_version"
//    implementation "com.github.lisawray.groupie:groupie-viewbinding:$groupie_version"
//
//    // Preference
//    implementation 'androidx.preference:preference-ktx:1.1.0'
//
//    // WeatherLocation
//    implementation 'com.google.android.gms:play-services-location:17.0.0'
////    implementation 'android.arch.navigation:navigation-safe-args-gradle-plugin:1.0.0-alpha07'
//
//    // New Material Design
//    implementation "com.google.android.material:material:1.1.0"
//
//    testImplementation 'junit:junit:4.12'
//    androidTestImplementation 'androidx.test:runner:1.3.0-alpha02'
//    androidTestImplementation 'androidx.test.espresso:espresso-core:3.3.0-alpha02'
