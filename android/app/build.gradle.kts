// ملف: android/app/build.gradle.kts
plugins {
    id("com.android.application")              // 👈 تطبيق أندرويد
    id("org.jetbrains.kotlin.android")         // 👈 دعم كوتلن للأندرويد
    id("dev.flutter.flutter-gradle-plugin")    // 👈 بلَغِن Flutter الرسمي
    id("com.google.gms.google-services")       // 👈 ضروري لمعالجة google-services.json (FCM/Firebase)
}

android {
    namespace = "com.chatapp.twasol"           // 👈 يجب أن يطابق package_name الذي سجّلته في Firebase
    compileSdk = flutter.compileSdkVersion
    ndkVersion = "27.0.12077973"

    defaultConfig {
        applicationId = "com.chatapp.twasol"   // 👈 طابق Firebase package_name
        minSdk = 23                             // 👈 23 مناسب (>=21 مطلوب لفلاش FCM)
        targetSdk = flutter.targetSdkVersion
        versionCode = flutter.versionCode
        versionName = flutter.versionName
        multiDexEnabled = true                 // 👈 لتفادي حدود 64K لطُرق الدالڤك (مشاريع كبيرة)
    }

    compileOptions {
        // 👇 تفعيل desugaring لدعم مزايا Java حديثة على minSdk منخفض
        isCoreLibraryDesugaringEnabled = true
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

    kotlinOptions {
        jvmTarget = "17"                       // 👈 استهداف JVM 17
    }

    buildTypes {
        release {
            // 👇 مؤقتًا يستخدم توقيع debug. بدّل لاحقًا بتوقيعك الحقيقي.
            signingConfig = signingConfigs.getByName("debug")
        }
    }
}

dependencies {
    implementation("androidx.multidex:multidex:2.0.1") // 👈 دعم MultiDex

    // 👇 نسخة حديثة من مكتبة desugaring (مطلوب مع isCoreLibraryDesugaringEnabled)
    coreLibraryDesugaring("com.android.tools:desugar_jdk_libs:2.1.5")

    // تأكد من وجود هذه التبعيات
    implementation(platform("com.google.firebase:firebase-bom:32.0.0"))
    implementation("com.google.firebase:firebase-messaging")
    implementation("com.google.firebase:firebase-analytics")

    // Retrofit
    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    implementation("com.squareup.retrofit2:converter-gson:2.9.0")
    implementation("com.squareup.okhttp3:logging-interceptor:4.9.0")
}

// تأكد من تطبيق plugin في الأسفل
apply(plugin = "com.google.gms.google-services")

flutter {
    source = "../.."                           // 👈 مسار كود Flutter
}