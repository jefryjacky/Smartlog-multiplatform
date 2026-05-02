# Implementation Plan: Migrate iOS SmartLog Initialization

## Phase 1: Kotlin API Implementation
- [x] Task: Create Kotlin Initialization File
    - [x] Create `composeApp/src/iosMain/kotlin/com/jefryjacky/smartloggingapp/SmartLogInit.kt`.
    - [x] Implement `fun initSmartlog()` in this new file.
    - [x] Move the `AppContainer.factory` and `SmartLog.printers` setup logic from `MainViewController` into this new function.
- [x] Task: Write tests for `initSmartlog`
    - [x] Create `iosTest` test file to verify that calling `initSmartlog()` correctly initializes the factory and printers.
- [~] Task: Conductor - User Manual Verification 'Kotlin API Implementation' (Protocol in workflow.md)

## Phase 2: Swift Integration
- [ ] Task: Update iOS App Entry Point
    - [ ] Modify `iosApp/iosApp/iOSApp.swift` to include an `init()` block.
    - [ ] Add `import ComposeApp`.
    - [ ] Call `SmartLogInitKt.initSmartlog()` inside the `init()` block.
- [ ] Task: Conductor - User Manual Verification 'Swift Integration' (Protocol in workflow.md)