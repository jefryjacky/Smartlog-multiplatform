package com.jefryjacky.smartlog

class DefaultMessageFormatter: MessageFormater {
    private val messageBuilder = StringBuilder()
    override fun format(message: String?, throwable: Throwable?): String {
        messageBuilder.clear()
        if(message!=null) {
            messageBuilder.append(message)
        }
        if(throwable!=null) {
            messageBuilder.append("\n")
            messageBuilder.append(throwable.toString())
        }
        return messageBuilder.toString()
    }
}