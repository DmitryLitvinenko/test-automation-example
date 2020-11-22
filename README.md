TBD

**Technologies:**
Java15, Gradle, Selenide, Junit5, Allure, ...

**Run tests with gradle:** 
* Run all tests:

        -> gradle clean test // gradle need to be installed, for example with brew
        -> ./gradlew clean test //not required installed gradle
* Run specific test:

        -> ./gradlew test --tests *ExampleTest.negativeTest

**Additional info:**

* Upgrade Gradle:
        -> gradle wrapper --gradle-version 6.7.1
* Allure with Gradle doc:
        -> https://plugins.gradle.org/plugin/io.qameta.allure 
        -> https://github.com/allure-framework/allure-gradle
* JUnit5 user guide: 
        -> https://junit.org/junit5/docs/snapshot/user-guide/
* Gradle Java plugin        
        -> https://docs.gradle.org/current/userguide/java_plugin.html
* Gradle Java testing 
        -> https://docs.gradle.org/current/userguide/java_testing.html#test_filtering