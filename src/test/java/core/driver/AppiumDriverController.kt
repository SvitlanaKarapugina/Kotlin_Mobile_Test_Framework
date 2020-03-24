package core.driver

import com.codeborne.selenide.WebDriverProvider
import core.constants.Constants.Companion.IS_ANDROID
import core.constants.Constants.Companion.IS_IOS
import core.utils.PropertyUtils
import io.appium.java_client.AppiumDriver
import io.appium.java_client.MobileElement
import io.appium.java_client.remote.AndroidMobileCapabilityType.APP_ACTIVITY
import io.appium.java_client.remote.AndroidMobileCapabilityType.APP_PACKAGE
import io.appium.java_client.remote.AutomationName.IOS_XCUI_TEST
import io.appium.java_client.remote.MobileCapabilityType.*
import org.openqa.selenium.WebDriver
import org.openqa.selenium.remote.CapabilityType.APPLICATION_NAME
import org.openqa.selenium.remote.CapabilityType.PLATFORM_NAME
import org.openqa.selenium.remote.DesiredCapabilities
import java.io.File
import java.net.MalformedURLException
import java.net.URL
import java.util.concurrent.TimeUnit


class AppiumDriverController : WebDriverProvider {
    var driver: AppiumDriver<MobileElement>? = null

    companion object {
        var instance = AppiumDriverController()
        //var driver: AppiumDriver<MobileElement>? = null
    }

    override fun createDriver(capabilities: DesiredCapabilities): WebDriver? {
        val app = File("src/test/resources", PropertyUtils().getCentralData("App"))

        capabilities.setCapability(PLATFORM_NAME, PropertyUtils().getCentralData("PlatformName"))
        capabilities.setCapability(PLATFORM_VERSION, PropertyUtils().getCentralData("PlatformVersion"))
        capabilities.setCapability(DEVICE_NAME, PropertyUtils().getCentralData("DeviceName"))
        capabilities.setCapability(FULL_RESET, PropertyUtils().getCentralData("FullReset"))
        capabilities.setCapability(NO_RESET, PropertyUtils().getCentralData("NoReset"))
        capabilities.setCapability("udid", PropertyUtils().getCentralData("UDID"))
        capabilities.setCapability(NEW_COMMAND_TIMEOUT, PropertyUtils().getCentralData("WaitTimeoutInSeconds"))

        if (IS_ANDROID) {
            capabilities.setCapability(APPLICATION_NAME, app.getAbsolutePath())
            capabilities.setCapability(APP_PACKAGE, PropertyUtils().getCentralData("AppPackage"))
            capabilities.setCapability(APP_ACTIVITY, PropertyUtils().getCentralData("AppActivity"))
        }
        if (IS_IOS) {
            capabilities.setCapability(AUTOMATION_NAME, IOS_XCUI_TEST)
            capabilities.setCapability("app", app.getAbsolutePath())
        }

        try {
            driver = AppiumDriver(URL(PropertyUtils().getCentralData("URL")), capabilities)
        } catch (e: MalformedURLException) {
            e.printStackTrace()
        }
        driver?.let {
            it.manage()?.timeouts()?.implicitlyWait(10, TimeUnit.SECONDS)
        }
        return driver
    }

    fun stop() {
        if (driver != null) {
            driver!!.quit()
        }
    }
}
