package ru.suleymanovtat.ciceroneapplication.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import ru.suleymanovtat.ciceroneapplication.App
import ru.suleymanovtat.ciceroneapplication.presenter.MainPresenter
import ru.suleymanovtat.ciceroneapplication.R
import ru.terrakok.cicerone.Navigator
import ru.terrakok.cicerone.android.support.SupportAppNavigator

class MainActivity : AppCompatActivity() {

   private var presenter: MainPresenter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        presenter = MainPresenter()
        click.setOnClickListener {
            presenter?.onForwardCommandClick(1)
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

    override fun onBackPressed() {
        presenter?.onBackPressed()
    }

    private val navigator: Navigator = SupportAppNavigator(this, -1)

}
