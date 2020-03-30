package core.pageConfiguration

import com.google.inject.AbstractModule
import pages.*
import pages.ios.*

class iOSInit : AbstractModule() {
    override fun configure() {
        bind(MainPage::class.java).to(MainPageIOS::class.java)
        bind(MyAccountPage::class.java).to(MyAccountPageIOS::class.java)
        bind(PlpPage::class.java).to(PlpPageIOS::class.java)
        bind(SearchPage::class.java).to(SearchPageIOS::class.java)
        bind(BagPage::class.java).to(BagPageIOS::class.java)
    }
}