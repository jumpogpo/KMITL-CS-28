package com.skooldio.android.fundamentals.workshop.pomodoro.data

import android.os.CountDownTimer
import com.skooldio.android.fundamentals.workshop.pomodoro.config.PomodoroConfig
import java.util.concurrent.TimeUnit

class PomodoroCounter {
    private var workDuration: Int = PomodoroConfig.WORK_DURATION_DEFAULT
    private var shortBreakDuration: Int = PomodoroConfig.SHORT_BREAK_DURATION_DEFAULT
    private var longBreakDuration: Int = PomodoroConfig.LONG_BREAK_DURATION_DEFAULT

    private var round: Int = 0
    private var state: State = State.Work
    private var lastMillisUntilFinished = 0L

    internal var onReady: ((Int, Int) -> Unit)? = null
    private var onWork: ((Int, Int) -> Unit)? = null
    private var onShortBreak: ((Int, Int) -> Unit)? = null
    private var onLongBreak: ((Int, Int) -> Unit)? = null

    private lateinit var timer: CountDownTimer

    fun config(
        workDuration: Int,
        shortBreakDuration: Int,
        longBreakDuration: Int,
    ) {
        this.workDuration = workDuration
        this.shortBreakDuration = shortBreakDuration
        this.longBreakDuration = longBreakDuration
        setupTimerForWork()
    }

    fun setListener(
        onReady: (Int, Int) -> Unit,
        onWork: (Int, Int) -> Unit,
        onShortBreak: (Int, Int) -> Unit,
        onLongBreak: (Int, Int) -> Unit,
    ) {
        this.onReady = onReady
        this.onWork = onWork
        this.onShortBreak = onShortBreak
        this.onLongBreak = onLongBreak
        val (minute, second) = getTimeValue(TimeUnit.MINUTES.toMillis(workDuration.toLong()))
        onReady.invoke(minute, second)
    }

    fun play() {
        timer.start()
    }

    fun pause() {
        timer.cancel()
        updateTimer(lastMillisUntilFinished)
    }

    fun fastForward() {
        timer.cancel()
        timer.onFinish()
    }

    private fun updateTimer(durationInMillis: Long) {
        timer = object : CountDownTimer(durationInMillis, 1000L) {
            override fun onTick(millisUntilFinished: Long) {
                sendCallback(millisUntilFinished)
                lastMillisUntilFinished = millisUntilFinished
            }

            override fun onFinish() {
                sendCallback(0)
                when (state) {
                    State.Work -> {
                        if (round < 3) {
                            round++
                            setupTimerForShortBreak()
                        } else {
                            round = 0
                            setupTimerForLongBreak()
                        }
                    }
                    State.ShortBreak -> {
                        setupTimerForWork()
                    }
                    State.LongBreak -> {
                        setupTimerForWork()
                    }
                }
            }
        }
    }

    private fun setupTimerForWork() {
        state = State.Work
        lastMillisUntilFinished = TimeUnit.MINUTES.toMillis(workDuration.toLong())
        updateTimer(lastMillisUntilFinished)
    }

    private fun setupTimerForShortBreak() {
        state = State.ShortBreak
        lastMillisUntilFinished = TimeUnit.MINUTES.toMillis(shortBreakDuration.toLong())
        updateTimer(lastMillisUntilFinished)
    }

    private fun setupTimerForLongBreak() {
        state = State.LongBreak
        lastMillisUntilFinished = TimeUnit.MINUTES.toMillis(longBreakDuration.toLong())
        updateTimer(lastMillisUntilFinished)
    }

    private fun getTimeValue(millisUntilFinished: Long): Pair<Int, Int> {
        val minute = (TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished)).toInt()
        val second = (TimeUnit.MILLISECONDS.toSeconds(millisUntilFinished) % 60).toInt()
        return minute to second
    }

    private fun sendCallback(millisUntilFinished: Long) {
        val (minute, second) = getTimeValue(millisUntilFinished)
        when (state) {
            is State.Work -> onWork?.invoke(minute, second)
            is State.ShortBreak -> onShortBreak?.invoke(minute, second)
            is State.LongBreak -> onLongBreak?.invoke(minute, second)
        }
    }

    sealed class State {
        object Work : State()
        object ShortBreak : State()
        object LongBreak : State()
    }
}
