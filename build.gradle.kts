// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    id(Build.androidApplicationName) version Build.androidApplicationVersion apply false
    id(Build.kotlinJetbrainsName) version Build.kotlinVersion apply false
    id(Build.ksp) version Build.kspVersion apply false
    id(Dagger.hiltDaggerName) version Dagger.daggerVersion apply false
}

buildscript {
    dependencies {
        classpath(AndroidX.safeArgs)
    }
}