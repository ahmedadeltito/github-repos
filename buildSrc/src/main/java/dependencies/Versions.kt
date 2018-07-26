package dependencies

object Versions {

    // Version Name
    val versionName = "1.0"
    val versionCode = 1

    object SupportAndroidLibs {
        const val gradlePlugin = "3.0.1"
        const val servicesPlugin = "3.2.0"
        const val compileSdk = 28
        const val minSdk = 21
        const val targetSdk = 28
        const val buildTools = "27.0.3"
        const val supportLibrary = "27.1.1"
        const val multiDex = "1.0.3"
        const val constraintLayout = "1.1.0"
        const val androidArcComponents = "1.1.1"
    }

    object Testing {
        const val mockito = "2.10.0"
        const val espresso = "3.0.1"
        const val runner = "1.0.1"
        const val junit = "4.12"
        const val junitPlatform = "1.0.0"
        const val spek = "1.1.5"
    }

    object Kotlin {
        const val std = "1.2.40"
    }

    object Google {
        const val playServices = "12.0.1"
        const val firebase = "12.0.1"
        const val dagger = "2.14.1"
    }

    object Libraries {
        // RxJava and RxAndroid
        const val rxAndroid = "2.0.1"
        const val rxJava = "2.1.9"
        const val rxRelay = "2.0.0"
        const val rxIdler = "0.9.0"

        // OkHttp and Retrofit
        const val retrofit = "2.3.0"
        const val okHttp = "3.9.1"

        // Gson
        const val gson = "2.8.2"

        // Timber
        const val timber = "1.5.1"

        // ButterKnife
        const val butterknife = "8.8.1"

        //LeakCanary
        const val leakCanary = "1.5.4"

        // Glide for Image Handling
        const val glide = "4.7.1"

        // Realm Database
        const val realm = "4.3.3"

    }
}