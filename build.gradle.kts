plugins {
    val agpVersion = "8.1.2"
    id("com.android.application") version agpVersion apply false
    id("com.android.library") version agpVersion apply false
    id("org.jetbrains.kotlin.android") version "1.9.10" apply false
    alias(libs.plugins.appdynamics) apply false
}


//task clean(type: Delete) {
//    delete rootProject.buildDir
//}