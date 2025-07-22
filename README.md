# SmartLog

This is a Kotlin Multiplatform project targeting Android, iOS (on progress).

##How to open log monitor
```kotlin
  val intent = Intent(this, LogActivity::class.java)
  startActivity(intent)
```

## How to log
```kotlin
SmartLog.v("LogViewModel", "test message")
SmartLog.i("LogViewModel", "test message")
SmartLog.w("LogViewModel", "test message")
SmartLog.e("LogViewModel", "test message")
SmartLog.wtf("LogViewModel", "test message")
```

![](/gif/example1.gif)

![](/gif/example2.gif)

![](/gif/example3.gif)