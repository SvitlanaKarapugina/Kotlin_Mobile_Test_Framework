package core.pageConfiguration

import com.google.inject.Inject
import pages.BasePage
import pages.MainPage
import pages.MyAccountPage

open class Pages {

    @Inject
    lateinit var mainPage: MainPage

    @Inject
    lateinit var myAccountPage: MyAccountPage

    @Inject
    lateinit var basePage: BasePage
}