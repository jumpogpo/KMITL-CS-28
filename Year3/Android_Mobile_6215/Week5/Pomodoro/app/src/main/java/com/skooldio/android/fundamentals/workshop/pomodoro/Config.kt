package com.skooldio.android.fundamentals.workshop.pomodoro

import android.os.Parcelable
import kotlinx.parcelize.Parcelize


@Parcelize
data class Config(
    val workDuraton: Int,
    val shortBreakDuration: Int,
    val longBreakDuration: Int
): Parcelable