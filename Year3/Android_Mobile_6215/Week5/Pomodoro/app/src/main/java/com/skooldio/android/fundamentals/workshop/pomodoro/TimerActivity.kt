package com.skooldio.android.fundamentals.workshop.pomodoro

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.skooldio.android.fundamentals.workshop.pomodoro.databinding.ActivityTimerBinding

class TimerActivity : AppCompatActivity() {
    companion object {
        private  const val  EXTRA_CONGIF = "config"
        fun newIntent(context: Context,
                      config: Config
        ): Intent {
            return Intent(context, TimerActivity::class.java).apply {
                putExtra(EXTRA_CONGIF,config)
            }
        }
    }
    private var config: Config? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        restoreBundle()
    }
    private fun restoreBundle() {
        config = intent.getParcelableExtra(EXTRA_CONGIF)
        Log.d("Comsci", "Work Duration = $config")
    }


    private val binding: ActivityTimerBinding by lazy {

        ActivityTimerBinding.inflate(layoutInflater)

    }

}
