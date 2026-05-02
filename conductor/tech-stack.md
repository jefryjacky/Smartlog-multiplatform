# Tech Stack: SmartLog

## Language
- **Kotlin (Multiplatform)**: The core programming language used to share logic across Android and iOS.

## UI Framework
- **Compose Multiplatform**: Used for building the plug-and-play UI log monitor components across platforms.

## Local Database
- **Room**: The ORM used for persistent, cross-session log storage.
- **SQLite Bundled**: Bundled SQLite database driver for multiplatform Room support.

## Navigation & Utilities
- **Navigation Compose**: Handles routing between different screens in the log monitor.
- **kotlinx-datetime**: Used for consistent, cross-platform timestamping of logs.
- **kotlinx-serialization**: Used for serializing log data or configurations.