# SmartLog

This is a Kotlin Multiplatform project targeting Android, iOS (on progress).

## How to open log monitor in Android
```kotlin
  val intent = Intent(this, LogActivity::class.java)
  startActivity(intent)
```

## How to log KMP or Android
```kotlin
SmartLog.v("LogViewModel", "test message")
SmartLog.i("LogViewModel", "test message")
SmartLog.w("LogViewModel", "test message")
SmartLog.e("LogViewModel", "test message")
SmartLog.wtf("LogViewModel", "test message")
```

## Log monitor feature
1. filter log
2. play/pause log
3. auto scroll top

![](/gif/example1.gif)

![](/gif/example2.gif)

![](/gif/example3.gif)