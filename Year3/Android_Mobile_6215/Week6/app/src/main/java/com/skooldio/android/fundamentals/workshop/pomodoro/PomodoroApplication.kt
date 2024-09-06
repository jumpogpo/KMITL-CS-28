package com.skooldio.android.fundamentals.workshop.pomodoro

import android.app.Application
import android.app.NotificationChannel
import androidx.core.app.NotificationChannelCompat
import androidx.core.app.NotificationManagerCompat
import com.skooldio.android.fundamentals.workshop.pomodoro.config.NotificationConfig

class PomodoroApplication: Application(){
    override fun onCreate(){
        super.onCreate()
        setupNotification()
    }
    private fun setupNotification(){
        val channel = NotificationChannelCompat.Builder(
            NotificationConfig.CHANNEL_ID,
            NotificationManagerCompat.IMPORTANCE_HIGH
        ).apply {
            setName(NotificationConfig.CHANNEL_NAME)
        }.build()

        val manager = NotificationManagerCompat.from(this)
        manager.createNotificationChannel(channel)
    }
}