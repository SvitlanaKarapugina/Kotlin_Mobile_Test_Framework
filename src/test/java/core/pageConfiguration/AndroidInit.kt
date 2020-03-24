package core.pageConfiguration

import com.google.inject.AbstractModule
import pages.BasePage
import pages.MainPage
import pages.MyAccountPage
import pages.android.MainPageAndroid
import pages.android.MyAccountPageAndroid

class AndroidInit : AbstractModule() {
    override fun configure() {
       // bind(BasePage::class.java).to(BasePage::class.java)
        bind(MainPage::class.java).to(MainPageAndroid::class.java)
        bind(MyAccountPage::class.java).to(MyAccountPageAndroid::class.java)
    }
}