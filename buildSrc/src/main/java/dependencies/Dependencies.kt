package dependencies

object Dependencies {

    val supportAndroidLibs = arrayOf(
        "com.android.support:support-annotations:${Versions.SupportAndroidLibs.supportLibrary}",
        "com.android.support:appcompat-v7:${Versions.SupportAndroidLibs.supportLibrary}",
        "com.android.support:recyclerview-v7:${Versions.SupportAndroidLibs.supportLibrary}",
        "com.android.support:design:${Versions.SupportAndroidLibs.supportLibrary}",
        "com.android.support:customtabs:${Versions.SupportAndroidLibs.supportLibrary}",
        "com.android.support:multidex:${Versions.SupportAndroidLibs.multiDex}",
        "com.android.support.constraint:constraint-layout:${Versions.SupportAndroidLibs.constraintLayout}"
    )

    val androidArchComponents = arrayOf(
        "android.arch.lifecycle:runtime:${Versions.SupportAndroidLibs.androidArcComponents}",
        "android.arch.lifecycle:extensions:${Versions.SupportAndroidLibs.androidArcComponents}",
        "android.arch.lifecycle:reactivestreams:${Versions.SupportAndroidLibs.androidArcComponents}"
    )

    val testing = arrayOf(
        "com.android.support.test:runner:${Versions.Testing.runner}",
        "com.android.support.test.espresso:espresso-core:${Versions.Testing.espresso}",
        "org.mockito:mockito-core:${Versions.Testing.mockito}",
        "junit:junit:${Versions.Testing.junit}",
        "com.squareup.rx.idler:rx2-idler:${Versions.Libraries.rxIdler}",
        "org.jetbrains.spek:spek-api:${Versions.Testing.spek}"
    )

    val testRuntime = arrayOf(
        "org.jetbrains.spek:spek-junit-platform-engine:${Versions.Testing.spek}"
    )

    val kotlin = arrayOf(
        "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Versions.Kotlin.std}"
    )

    val google = arrayOf(
        "com.google.android.gms:play-services-analytics:${Versions.Google.playServices}",
        "com.google.firebase:firebase-core:${Versions.Google.firebase}",
        "com.google.dagger:dagger:${Versions.Google.dagger}",
        "com.google.dagger:dagger-android:${Versions.Google.dagger}",
        "com.google.dagger:dagger-android-support:${Versions.Google.dagger}"
    )

    val libraries = arrayOf(
        // RxJava, RxAndroid and RxRelay
        "io.reactivex.rxjava2:rxandroid:${Versions.Libraries.rxAndroid}",
        "io.reactivex.rxjava2:rxjava:${Versions.Libraries.rxJava}",
        "com.jakewharton.rxrelay2:rxrelay:${Versions.Libraries.rxRelay}",

        // OkHttp and Retrofit
        "com.squareup.okhttp3:okhttp:${Versions.Libraries.okHttp}",
        "com.squareup.okhttp3:logging-interceptor:${Versions.Libraries.okHttp}",
        "com.squareup.okhttp3:okhttp-urlconnection:${Versions.Libraries.okHttp}",
        "com.squareup.retrofit2:retrofit:${Versions.Libraries.retrofit}",
        "com.squareup.retrofit2:converter-gson:${Versions.Libraries.retrofit}",
        "com.squareup.retrofit2:adapter-rxjava2:${Versions.Libraries.retrofit}",
        "com.squareup.retrofit2:retrofit-mock:${Versions.Libraries.retrofit}",

        // Gson
        "com.squareup.retrofit2:converter-gson:${Versions.Libraries.retrofit}",

        // TimberKotlin
        "com.github.ajalt:timberkt:${Versions.Libraries.timber}",

        // LeakCanary
        "com.squareup.leakcanary:leakcanary-android:${Versions.Libraries.leakCanary}",

        // Glide
        "com.github.bumptech.glide:glide:${Versions.Libraries.glide}"
    )

    val annotations = arrayOf(

        // Android Architecture Components
        "android.arch.lifecycle:compiler:${Versions.SupportAndroidLibs.androidArcComponents}",

        // ButterKnife
        "com.jakewharton:butterknife-compiler:${Versions.Libraries.butterknife}",

        // Dagger
        "com.google.dagger:dagger-compiler:${Versions.Google.dagger}",
        "com.google.dagger:dagger-android-processor:${Versions.Google.dagger}",

        // Glide
        "com.github.bumptech.glide:compiler:${Versions.Libraries.glide}"
    )

}