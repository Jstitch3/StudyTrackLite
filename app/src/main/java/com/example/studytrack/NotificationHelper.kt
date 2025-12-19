package com.example.studytrack

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.core.app.NotificationCompat

@RequiresApi(Build.VERSION_CODES.O)
fun showTaskNotification(context: Context, task: String) {
    val channelId = "study_tasks"

    val manager = context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

    val channel = NotificationChannel(
        channelId,
        "Study Tasks",
        NotificationManager.IMPORTANCE_DEFAULT
    )
    manager.createNotificationChannel(channel)

    val notification = NotificationCompat.Builder(context, channelId)
        .setSmallIcon(android.R.drawable.ic_dialog_info)
        .setContentTitle("New Study Task Added")
        .setContentText(task)
        .build()

    manager.notify(System.currentTimeMillis().toInt(), notification)
}
