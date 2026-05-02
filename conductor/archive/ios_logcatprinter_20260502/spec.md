# Specification: Implement `LogCatPrinter` for iOS

## Overview
The goal of this track is to implement the `LogCatPrinter` for the iOS target, providing equivalent functionality to the Android `LogCatPrinter`. This will allow the SmartLog library to output log messages to the native iOS console (Xcode console) using `NSLog`.

## Functional Requirements
- Create an iOS-specific implementation of a printer (e.g., `LogCatPrinter` or similar naming appropriate for iOS, such as `NSLogPrinter`, but matching the intent of a console printer).
- The implementation must utilize the native iOS `NSLog` API to output the logs to the console.
- The log output format (including timestamps, tags, and levels) must exactly match the formatting used by the Android `LogCatPrinter` for consistency.
- The iOS printer must be registered or available for initialization in the iOS app lifecycle.

## Non-Functional Requirements
- Maintain existing coding standards and project style guidelines.
- The implementation should be performant and not block the main thread excessively.

## Acceptance Criteria
- A Kotlin file exists in the iOS source set implementing the console printing functionality using `NSLog`.
- The printer correctly formats and outputs messages for all supported `LogLevel`s.
- The code compiles without errors for the iOS target.

## Out of Scope
- Automated tests for the iOS printer implementation are excluded from this track.
- Modifications to the Android `LogCatPrinter` or shared core logging logic, unless necessary for multiplatform architecture setup (e.g., `expect`/`actual` declarations if that path is chosen).