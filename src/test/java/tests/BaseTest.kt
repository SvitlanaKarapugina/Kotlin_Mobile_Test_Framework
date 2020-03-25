package tests

import com.codeborne.selenide.Configuration
import com.codeborne.selenide.Selenide.open
import com.google.inject.Guice
import com.google.inject.Injector
import core.constants.Constants
import core.driver.AppiumDriverController
import core.pageConfiguration.AndroidInit
import core.pageConfiguration.Pages
import core.pageConfiguration.iOSInit
import core.reports.TestListener
import org.testng.annotations.AfterSuite
import org.testng.annotations.BeforeMethod
import org.testng.annotations.BeforeSuite
import org.testng.annotations.Listeners


@Listeners(TestListener::class)
open class BaseTest : Pages() {
    lateinit var injector: Injector
    lateinit var pages: Pages

    @BeforeSuite
    fun setup() {
        Configuration.startMaximized = false
        Configuration.browserSize = null
        Configuration.browser = AppiumDriverController::class.java.name
        open()
    }

    @BeforeMethod
    fun configureEnvironment() {
        injectPages()
        AppiumDriverController.instance.restartApp()
    }

    @AfterSuite
    fun stopAll() {
        AppiumDriverController.instance.stop()
    }

    private fun injectPages() {
        injector = if (Constants.IS_IOS) {
            Guice.createInjector(iOSInit())
        } else {
            Guice.createInjector(AndroidInit())
        }
        pages = injector.getInstance(Pages::class.java)
    }
}
