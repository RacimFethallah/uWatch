// Top-level build file where you can add configuration options common to all sub-projects/modules.
//buildscript {
//    dependencies {
////        classpath(libs.plugins.androidGradlePlugin)
////        classpath(libs.plugins.kotlinGradlePlugin)
////        classpath(libs.plugins.hiltGradlePlugin)
//        classpath("com.google.dagger:hilt-android-gradle-plugin:2.38.1")
//    }
//}
plugins {
    alias(libs.plugins.androidApplication) apply false
    alias(libs.plugins.jetbrainsKotlinAndroid) apply false
    id("com.google.dagger.hilt.android") version "2.51.1" apply false
}