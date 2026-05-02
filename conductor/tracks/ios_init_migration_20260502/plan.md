# Implementation Plan: Migrate iOS SmartLog Initialization

## Phase 1: Kotlin API Implementation
- [ ] Task: Create Kotlin Initialization File
    - [ ] Create `composeApp/src/iosMain/kotlin/com/jefryjacky/smartloggingapp/SmartLogInit.kt`.
    - [ ] Implement `fun initSmartlog()` in this new file.
    - [ ] Move the `AppContainer.factory` and `SmartLog.printers` setup logic from `MainViewController` into this new function.
- [ ] Task: Write tests for `initSmartlog`
    - [ ] Create `iosTest` test file to verify that calling `initSmartlog()` correctly initializes the factory and printers.
- [ ] Task: Conductor - User Manual Verification 'Kotlin API Implementation' (Protocol in workflow.md)

## Phase 2: Swift Integration
- [ ] Task: Update iOS App Entry Point
    - [ ] Modify `iosApp/iosApp/iOSApp.swift` to include an `init()` block.
    - [ ] Add `import ComposeApp`.
    - [ ] Call `SmartLogInitKt.initSmartlog()` inside the `init()` block.
- [ ] Task: Conductor - User Manual Verification 'Swift Integration' (Protocol in workflow.md)