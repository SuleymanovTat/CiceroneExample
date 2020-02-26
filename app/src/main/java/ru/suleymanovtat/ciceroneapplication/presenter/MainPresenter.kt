package ru.suleymanovtat.ciceroneapplication.presenter

import android.content.Context
import android.content.Intent
import ru.suleymanovtat.ciceroneapplication.App
import ru.suleymanovtat.ciceroneapplication.activity.NextActivity
import ru.terrakok.cicerone.Router
import ru.terrakok.cicerone.android.support.SupportAppScreen


class MainPresenter {

    private var router: Router? = null

    init {
        router = App.INSTANCE?.getRouter()
    }

    fun onBackPressed() {
        router?.exit()
    }

    fun onForwardCommandClick(i: Int) {
        router?.navigateTo(
            MainScreen(
                i
            )
        )
    }

    class MainScreen(private val number: Int) : SupportAppScreen() {
        override fun getActivityIntent(context: Context): Intent? {
            return Intent(context, NextActivity::class.java).apply {
                putExtra("number", number)
            }
        }
    }
}