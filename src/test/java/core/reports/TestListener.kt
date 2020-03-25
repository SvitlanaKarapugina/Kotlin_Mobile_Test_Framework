package core.reports

import com.codeborne.selenide.WebDriverRunner
import io.qameta.allure.Attachment
import org.openqa.selenium.OutputType
import org.openqa.selenium.TakesScreenshot
import org.openqa.selenium.WebDriver
import org.testng.ITestContext
import org.testng.ITestListener
import org.testng.ITestResult

class TestListener : ITestListener {
    override fun onFinish(context: ITestContext?) {
    }

    override fun onTestSkipped(result: ITestResult?) {
    }

    override fun onTestSuccess(result: ITestResult?) {
    }

    override fun onTestFailure(result: ITestResult?) {
        val driver = WebDriverRunner.getWebDriver()
        saveScreenshotPNG(driver)
    }

    override fun onTestFailedButWithinSuccessPercentage(result: ITestResult?) {
    }

    override fun onTestStart(result: ITestResult?) {
    }

    override fun onStart(context: ITestContext?) {
    }

    @Attachment(value = "Page screenshot", type = "image/png")
    private fun saveScreenshotPNG(driver: WebDriver): ByteArray {
        return (driver as TakesScreenshot).getScreenshotAs(OutputType.BYTES)
    }
}