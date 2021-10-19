# ThatThing

Sample application for the Senior Android Developer position at ThingThing. The app gets data from the TMDB API and paginates it using the
paging3 library for both top and similar shows.

### Prerequisites

Before every commit, make sure you run the following commands:

```shell script
./codeAnalysis
```

Before you run the above, refer to the instructions in the file of the same name. If after following those instructions it still does not
work, try the following:

```shell script
./codeAnalysis.sh
```

To check for dependency updates, run the following command:

```shell script
./gradlew dependencyUpdate
```

Refer to this [issue](https://github.com/gradle/gradle/issues/10248), if you get any issues running the lint commands on the terminal :
rocket:

## Tech-stack

* Gradle
    * [Gradle Kotlin DSL](https://docs.gradle.org/current/userguide/kotlin_dsl.html) - For reference purposes, here's
      an [article explaining the migration](https://medium.com/@evanschepsiror/migrating-to-kotlin-dsl-4ee0d6d5c977).
    * Libraries
        * [ViewModel](https://developer.android.com/topic/libraries/architecture/viewmodel) - Lifecycle aware component to survive those
          config changes
        * [Kotlin Coroutines](https://developer.android.com/kotlin/coroutines) - Background work made easy
        * [Flow](https://developer.android.com/kotlin/flow) - Sequentially emit those values
        * [Dagger Hilt](https://dagger.dev/hilt/) - Inject them smoothly and easily
        * [Jetpack Navigation Component](https://developer.android.com/guide/navigation) - Smooth and easy navigation
        * [Retrofit](https://square.github.io/retrofit/) - Does this even need explaining?
        * [Paging Library](https://developer.android.com/topic/libraries/architecture/paging/v3-paged-data) - Load lists efficiently
        * [Timber](https://github.com/JakeWharton/timber) - Logging made easier and fun
        * [Coil](https://github.com/coil-kt/coil) - Load images efficiently

    * Plugins
        * [Ktlint](https://github.com/JLLeitschuh/ktlint-gradle) - creates convenient tasks in your Gradle project that run ktlint checks or
          do code auto format.
        * [Detekt](https://github.com/detekt/detekt) - a static code analysis tool for the Kotlin programming language.
        * [Spotless](https://github.com/diffplug/spotless) - format java, groovy, markdown and license headers using gradle.
        * [Dokka](https://github.com/Kotlin/dokka) - a documentation engine for Kotlin, performing the same function as javadoc for Java.
        * [jacoco](https://github.com/jacoco/jacoco) - a Code Coverage Library.
        * [Safeargs](https://developer.android.com/guide/navigation/navigation-pass-data) - Pass arguments between destinations safely
        * [Gradle Versions](https://github.com/ben-manes/gradle-versions-plugin) - provides a task to determine which dependencies have
          updates. Additionally, the plugin checks for updates to Gradle itself.

For reference, here's a detailed explanation of the approach of the plugin configuration in this project

- [A Day with an Elephant in the Room: Configuring Gradle Plugins.](https://medium.com/@harunwangereka/a-day-with-an-elephant-in-the-room-configuring-gradle-plugins-3331b0be64c7)
  This project was adopted from [this](https://github.com/wangerekaharun/GradleBuildPlugins) handy template

## Known Issues

    * Initial load does not show the loading indicator but shows on subsequent loads. This is an issue with the paging3 library
        but there are workarounds alhough may be potentially time-intensive
