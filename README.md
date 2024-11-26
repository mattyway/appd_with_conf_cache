# Context

Gradle has a build configuration cache capability, which is still not enabled by default. Information can be found at https://docs.gradle.org/current/userguide/configuration_cache.html
The build configuration cache can improve build times drastically for large projects. 

However, it has some requirements for Gradle tasks for it to be able to be used (https://docs.gradle.org/current/userguide/configuration_cache.html#config_cache:requirements).

Current `debugAppDynamicsAddBuildInfo` AppDynamics Gradle task is **not compatible** with Gradle build configuration cache. This effectively disables the configuration cache, resulting in zero time savings when building the app.

## How to replicate the issue

In the current project, run the following Gradle command:
```bash
./gradlew clean assembleDebug
```

## Key details

- AppDynamics version in use: **24.4.2**

- Key configuration to enable build configuration cache:
In `gradle.properties`:
```properties
org.gradle.configuration-cache=true
```

## Error message

```bash
BUILD SUCCESSFUL in 8s
56 actionable tasks: 17 executed, 39 up-to-date
Configuration cache entry discarded because incompatible task was found: ':app:debugAppDynamicsAddBuildInfo'.

```
