import UIKit
import SwiftUI
import ComposeApp

struct ComposeView: UIViewControllerRepresentable {
    var onNavigateToLog: () -> Void

    func makeUIViewController(context: Context) -> UIViewController {
        MainViewControllerKt.MainViewController(onNavigateToLog: onNavigateToLog)
    }

    func updateUIViewController(_ uiViewController: UIViewController, context: Context) {}
}

struct LogComposeView: UIViewControllerRepresentable {
    func makeUIViewController(context: Context) -> UIViewController {
        LogViewControllerKt.LogViewController()
    }

    func updateUIViewController(_ uiViewController: UIViewController, context: Context) {}
}

struct ContentView: View {
    @State private var navigateToLog = false

    var body: some View {
        NavigationView {
            ZStack {
                ComposeView(onNavigateToLog: {
                    self.navigateToLog = true
                })
                .ignoresSafeArea(.keyboard)

                NavigationLink(
                    destination: LogComposeView().navigationTitle("Logs"),
                    isActive: $navigateToLog
                ) {
                    EmptyView()
                }
            }
        }
    }
}
