import SwiftUI
import ComposeApp

@main
struct iOSApp: App {
    init() {
        SmartLogInitKt.initializeSmartlog()
    }

    var body: some Scene {
        WindowGroup {
            ContentView()
        }
    }
}
