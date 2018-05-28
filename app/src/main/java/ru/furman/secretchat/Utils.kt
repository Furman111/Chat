package ru.furman.secretchat

import android.widget.TextView
import java.text.SimpleDateFormat
import java.util.*

fun TextView.setDateOrTime(time: Long) {
    val current = Date(System.currentTimeMillis())
    val messageTime = Date(time)
    if (current.date == messageTime.date && current.day == messageTime.day) {
        this.text = SimpleDateFormat("HH:mm").format(messageTime)
    } else {
        this.text = SimpleDateFormat("dd.MM.yyyy").format(messageTime)
    }
}