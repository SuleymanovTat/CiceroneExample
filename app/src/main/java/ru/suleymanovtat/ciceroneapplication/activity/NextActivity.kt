package ru.suleymanovtat.ciceroneapplication.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import ru.suleymanovtat.ciceroneapplication.App
import ru.suleymanovtat.ciceroneapplication.R
import ru.suleymanovtat.ciceroneapplication.fragment.MainFragment
import ru.terrakok.cicerone.Navigator
import ru.terrakok.cicerone.android.support.SupportAppNavigator
import ru.terrakok.cicerone.android.support.SupportAppScreen
import ru.terrakok.cicerone.commands.Command
import ru.terrakok.cicerone.commands.Replace

class NextActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_next)
        supportActionBar?.title = "Number  ${intent.getIntExtra("number", 9)}"

        if (savedInstanceState == null) {
            navigator.applyCommands(
                arrayOf<Command>(
                    Replace(
                        SampleScreen(
                            1
                        )
                    )
                )
            )
        } else {
            printScreensScheme()
        }
    }

    class SampleScreen(private val number: Int) :
        SupportAppScreen() {
        override fun getFragment(): Fragment? {
            return MainFragment.newInstance(number.toString(), "param2")
        }

        init {
            screenKey = javaClass.simpleName + "_" + number
        }
    }

    private fun printScreensScheme() {

    }

    private val navigator: Navigator =
        object : SupportAppNavigator(this,
            R.id.container
        ) {
            override fun applyCommands(commands: Array<Command>) {
                super.applyCommands(commands)
                supportFragmentManager.executePendingTransactions()
            }
        }

    override fun onResume() {
        super.onResume()
        App.INSTANCE?.getNavigatorHolder()?.setNavigator(navigator)
    }

    override fun onPause() {
        super.onPause()
        App.INSTANCE?.getNavigatorHolder()?.removeNavigator()
    }
}
