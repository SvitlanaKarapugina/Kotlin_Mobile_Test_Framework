package core.driver

import com.codeborne.selenide.Selenide.*
import com.codeborne.selenide.WebDriverProvider
import com.codeborne.selenide.WebDriverRunner.getWebDriver
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
import org.openqa.selenium.logging.LogEntries
import org.openqa.selenium.logging.Logs
import org.openqa.selenium.remote.CapabilityType.PLATFORM_NAME
import org.openqa.selenium.remote.DesiredCapabilities
import java.io.File
import java.io.FileWriter
import java.io.IOException
import java.net.MalformedURLException
import java.net.URL


class DriverManager : WebDriverProvider {
    companion object {
        var instance = DriverManager()
        var driver: AppiumDriver<MobileElement>? = null
    }

    override fun createDriver(capabilities: DesiredCapabilities): WebDriver? {
        val app = File("src/test/resources", PropertyUtils().getCentralData("App"))

        capabilities.setCapability(PLATFORM_NAME, PropertyUtils().getCentralData("PlatformName"))
        capabilities.setCapability(PLATFORM_VERSION, PropertyUtils().getCentralData("PlatformVersion"))
        capabilities.setCapability(DEVICE_NAME, PropertyUtils().getCentralData("DeviceName"))
        capabilities.setCapability(FULL_RESET, PropertyUtils().getCentralData("FullReset"))
        capabilities.setCapability(NO_RESET, PropertyUtils().getCentralData("NoReset"))
        capabilities.setCapability(UDID, PropertyUtils().getCentralData("UDID"))
        capabilities.setCapability(NEW_COMMAND_TIMEOUT, PropertyUtils().getCentralData("WaitTimeoutInSeconds"))
        capabilities.setCapability("clearDeviceLogsOnStart", true)

        if (IS_ANDROID) {
            capabilities.setCapability(APP, app.absolutePath)
            capabilities.setCapability(APP_PACKAGE, PropertyUtils().getCentralData("AppPackage"))
            capabilities.setCapability(APP_ACTIVITY, PropertyUtils().getCentralData("AppActivity"))
        }
        if (IS_IOS) {
            capabilities.setCapability(AUTOMATION_NAME, IOS_XCUI_TEST)
            capabilities.setCapability(APP, app.absolutePath)
        }

        try {
            driver = AppiumDriver(URL(PropertyUtils().getCentralData("URL")), capabilities)
        } catch (e: MalformedURLException) {
            e.printStackTrace()
        }
        return driver
    }

    fun restartApp() {
        close()
        open()
    }

    fun quit() {
        closeWebDriver()
    }

    fun writeLog() {
        val logs: Logs = getWebDriver().manage().logs()
        val entries: LogEntries = if (IS_IOS) logs.get("server") else logs.get("logcat")
        try {
            FileWriter("src/test/resources/deviceLog.txt", false).use { writer ->
                writer.write(entries.all.toString().replace("[ALL]", "\n[ALL]"))
                writer.flush()
            }
        } catch (ex: IOException) {

            println(ex.message)
        }
    }
}
