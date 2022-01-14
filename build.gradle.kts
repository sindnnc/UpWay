// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript {
    repositories {
        google()
        mavenCentral()
    }
    dependencies {
        classpath(BuildPlugin.androidPlugin)
        classpath(BuildPlugin.kotlinPlugin)
    }
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}