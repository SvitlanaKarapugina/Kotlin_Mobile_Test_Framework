package core.pageConfiguration

import com.google.inject.AbstractModule
import pages.BasePage
import pages.MainPage
import pages.MyAccountPage
import pages.ios.MainPageIOS
import pages.ios.MyAccountPageIOS

class iOSInit : AbstractModule() {
    override fun configure() {
      //  bind(BasePage::class.java).to(BasePage::class.java)
        bind(MainPage::class.java).to(MainPageIOS::class.java)
        bind(MyAccountPage::class.java).to(MyAccountPageIOS::class.java)
    }
}