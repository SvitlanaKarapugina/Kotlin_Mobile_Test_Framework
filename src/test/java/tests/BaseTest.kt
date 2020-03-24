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
import org.openqa.selenium.remote.DesiredCapabilities
import org.testng.annotations.AfterClass
import org.testng.annotations.AfterMethod
import org.testng.annotations.BeforeClass
import org.testng.annotations.BeforeMethod


open class BaseTest : Pages() {

    lateinit var injector: Injector
    lateinit var pages: Pages

    @BeforeClass
    fun setup() {
        injector = if (Constants.IS_IOS) {
            Guice.createInjector(iOSInit())
        } else {
            Guice.createInjector(AndroidInit())
        }
        pages = injector.getInstance(Pages::class.java)


    }

    @BeforeMethod
    fun configureEnvironment() {
        val capabilities = DesiredCapabilities()

        AppiumDriverController.instance.createDriver(capabilities)
        configureDriver()
        //ElementHelpers().chooseCountry()
        // ElementHelpers().tapOnContinue()
    }

    private fun configureDriver() {
        Configuration.startMaximized = false
        Configuration.browserSize = null
        Configuration.browser = AppiumDriverController::class.java.name
        open()
    }


    @AfterMethod
    fun stopAll() {
        AppiumDriverController.instance.stop()
    }
}
