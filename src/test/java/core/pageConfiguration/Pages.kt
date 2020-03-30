package core.pageConfiguration

import com.google.inject.Inject
import pages.*

open class Pages {

    @Inject
    lateinit var mainPage: MainPage

    @Inject
    lateinit var myAccountPage: MyAccountPage

    @Inject
    lateinit var plpPage: PlpPage

    @Inject
    lateinit var searchPage: SearchPage

    @Inject
    lateinit var bagPage: BagPage

    @Inject
    lateinit var basePage: BasePage
}