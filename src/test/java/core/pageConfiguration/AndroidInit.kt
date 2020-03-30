package core.pageConfiguration

import com.google.inject.AbstractModule
import pages.*
import pages.android.*

class AndroidInit : AbstractModule() {
    override fun configure() {
        bind(MainPage::class.java).to(MainPageAndroid::class.java)
        bind(MyAccountPage::class.java).to(MyAccountPageAndroid::class.java)
        bind(PlpPage::class.java).to(PlpPageAndroid::class.java)
        bind(SearchPage::class.java).to(SearchPageAndroid::class.java)
        bind(BagPage::class.java).to(BagPageAndroid::class.java)
    }
}