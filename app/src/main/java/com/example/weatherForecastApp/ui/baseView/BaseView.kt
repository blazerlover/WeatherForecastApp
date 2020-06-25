package com.example.weatherForecastApp.ui.baseView

import android.content.Context
import android.view.View

abstract class BaseView: MyView {

    lateinit var baseRootView: View

    override fun getRootView(): View? {
        return baseRootView
    }

    protected fun getContext(): Context {
        return getRootView()!!.context
    }
}