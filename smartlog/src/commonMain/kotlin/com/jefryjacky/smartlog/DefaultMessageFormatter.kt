package com.jefryjacky.smartlog

class DefaultMessageFormatter: MessageFormater {
    override fun format(message: String?, throwable: Throwable?): String {
        val messageBuilder = StringBuilder()
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