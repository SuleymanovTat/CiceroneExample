package ru.suleymanovtat.ciceroneapplication

import androidx.fragment.app.Fragment
import ru.suleymanovtat.ciceroneapplication.fragment.Next3Fragment
import ru.suleymanovtat.ciceroneapplication.fragment.NextFragment
import ru.terrakok.cicerone.android.support.SupportAppScreen

class Screens {

    class NextScreen(private val param1: String, private val param2: String) :
        SupportAppScreen() {
        override fun getFragment(): Fragment? {
            return NextFragment.newInstance(param1, param2)
        }
    }
    class Next3Screen() :
        SupportAppScreen() {
        override fun getFragment(): Fragment? {
            return Next3Fragment.newInstance()
        }
    }
}
