package com.palzzak.blur.ui.splash

import com.palzzak.blur.BasePresenter
import com.palzzak.blur.BaseView

/**
 * Created by yooas on 2018-01-11.
 */
interface SplashContract {
    interface View: BaseView<Presenter> {
        fun setStatus(status: String)
        fun somethingIsWrong()
        fun saveIdPreference(mobileId: String, memberId: Long)
        fun showToast(s: String)
    }

    interface Presenter: BasePresenter<View> {
        fun logIn(mobileId: String, memberId: Long)
    }
}