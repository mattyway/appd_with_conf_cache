plugins {
    val agpVersion = "8.7.2"
    id("com.android.application") version agpVersion apply false
    id("com.android.library") version agpVersion apply false
    id("org.jetbrains.kotlin.android") version "1.9.22" apply false
    alias(libs.plugins.appdynamics) apply false
}


//task clean(type: Delete) {
//    delete rootProject.buildDir
//}