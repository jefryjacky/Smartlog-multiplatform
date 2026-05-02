# Specification: Implement iOS LogView Entry Point

## Objective
Implement an iOS-specific entry point for the SmartLog module, achieving feature parity with the Android `LogActivity.kt`. This will provide a UI on iOS devices to view logs via the shared `LogApp` composable. The implementation must follow a pattern identical to how the Android app navigates to its `LogActivity`.

## Context
- The Android app starts `LogActivity` via an intent inside the `App` composable trailing lambda in `MainActivity.kt`.
- The iOS app uses `MainViewController.kt` wrapped in a SwiftUI `UIViewControllerRepresentable` in `ContentView.swift`.

## Implementation Requirements

### 1. Create LogViewController in the `smartlog` module
- **File**: `smartlog/src/iosMain/kotlin/com/jefryjacky/smartlog/LogViewController.kt`
- **Action**: Create a top-level Kotlin function `fun LogViewController() = ComposeUIViewController { LogTheme { LogApp {} } }`
- **Purpose**: This mirrors `LogActivity.kt` by providing an iOS `UIViewController` that renders the `LogApp` composable with the `LogTheme`.

### 2. Update MainViewController.kt
- **File**: `composeApp/src/iosMain/kotlin/com/jefryjacky/smartloggingapp/MainViewController.kt`
- **Action**: Update the `MainViewController()` function to either:
  1. Accept a callback parameter so that the Swift UI can handle navigation. (e.g., `fun MainViewController(onNavigateToLog: () -> Unit) = ComposeUIViewController { App(clicked = onNavigateToLog) }`), OR
  2. Implement an iOS-native navigation action directly from the Kotlin code using `UIApplication.sharedApplication.keyWindow?.rootViewController?.presentViewController(...)` (if the developer prefers Kotlin-side navigation). Since the iOS app uses SwiftUI, a callback approach mapping to a SwiftUI NavigationStack is generally preferred.

### 3. Update iOS Swift Integration
- **Files**: `iosApp/iosApp/ContentView.swift` and `iosApp/iosApp/iOSApp.swift`
- **Action**:
  - Wrap the `ContentView` in a `NavigationStack` (or `NavigationView`).
  - Update `ComposeView` to handle the `onNavigateToLog` callback from Kotlin, setting a Swift `@State` variable to trigger navigation.
  - Create a new `LogComposeView: UIViewControllerRepresentable` that returns `LogViewControllerKt.LogViewController()`.
  - Use a `NavigationLink` to push `LogComposeView` onto the screen when the state variable triggers.

## Acceptance Criteria
- A `LogViewController.kt` file exists in the `smartlog` `iosMain` source set.
- The `MainViewController.kt` correctly wires the `App { clicked() }` lambda to iOS navigation.
- Running the iOS app and tapping the "Click me!" button successfully navigates to the SmartLog monitor on iOS.