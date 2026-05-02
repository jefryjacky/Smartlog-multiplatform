# Specification: Migrate iOS SmartLog Initialization

## Overview
Currently, the iOS application initializes the `SmartLog` factory and `LogCatPrinter` inside `MainViewController.kt`. This means initialization happens when the UI is constructed, rather than at application startup like in the Android app (`SmartLogApp.onCreate()`). This track will migrate the initialization logic to the iOS application entry point to ensure logs are captured from the earliest possible moment and to maintain platform parity.

## Functional Requirements
- **Kotlin Side:**
  - Remove `AppContainer.factory = Factory()` and printer setup from `MainViewController`.
  - Expose a new public function `initSmartlog()` in a new file `SmartLogInit.kt` in the `iosMain` source set.
  - The `initSmartlog()` function must initialize the `AppContainer.factory` and add `LogCatPrinter` if it doesn't exist.
- **Swift Side:**
  - Update `iosApp/iosApp/iOSApp.swift` (the `@main` struct).
  - Add an `init()` block to the `iOSApp` struct.
  - Import the shared KMP framework (`ComposeApp`) and invoke the exposed `SmartLogInitKt.initSmartlog()` function.

## Acceptance Criteria
- The SmartLog factory is initialized exactly once on the iOS platform when the app launches.
- The `LogCatPrinter` is active from app startup on iOS.
- The `MainViewController.kt` function is purely responsible for UI creation, not library initialization.
- The Android implementation remains unaffected and continues to initialize in `SmartLogApp.kt`.