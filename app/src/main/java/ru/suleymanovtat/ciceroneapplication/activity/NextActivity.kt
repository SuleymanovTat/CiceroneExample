package ru.suleymanovtat.ciceroneapplication.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import ru.suleymanovtat.ciceroneapplication.App
import ru.suleymanovtat.ciceroneapplication.R
import ru.suleymanovtat.ciceroneapplication.Screens
import ru.terrakok.cicerone.Router
import ru.terrakok.cicerone.android.support.SupportAppNavigator

class NextActivity : AppCompatActivity() {

    lateinit var navigator: SupportAppNavigator
    lateinit var router: Router

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_next)
        supportActionBar?.title = "Number  ${intent.getIntExtra("number", 9)}"
        navigator = SupportAppNavigator(this, supportFragmentManager, R.id.container)
        router = App.INSTANCE?.getRouter()!!
        router.navigateTo(Screens.NextScreen("a", "b"))
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
