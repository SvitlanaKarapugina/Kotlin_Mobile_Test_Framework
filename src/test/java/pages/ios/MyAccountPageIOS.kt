package pages.ios

import com.codeborne.selenide.Condition
import com.codeborne.selenide.Selenide.`$`
import com.codeborne.selenide.SelenideElement
import core.utils.ElementHelpers
import io.qameta.allure.Step
import org.openqa.selenium.By
import pages.BasePage
import pages.MyAccountPage
import java.util.logging.Logger

class MyAccountPageIOS : BasePage(), MyAccountPage {
    protected var log: Logger = Logger.getLogger(MyAccountPageIOS::class.java.toString())

    protected var pageTitle: SelenideElement? = `$`(By.xpath("//XCUIElementTypeNavigationBar[@name='My account']"))

    protected var emailField: SelenideElement? = `$`(By.xpath("//XCUIElementTypeTextField[@value='E-mail']"))

    protected var passwordField: SelenideElement? = `$`(By.xpath("//XCUIElementTypeSecureTextField[@value='Password']"))

    protected var signInButton: SelenideElement? = `$`(By.id("Sign in"))

    protected var greetingText: SelenideElement? = `$`(By.xpath("//XCUIElementTypeStaticText[contains(@value,'Hello')]"))

    protected var txtErrorMsg: SelenideElement? = `$`(By.id("Incorrect e-mail or password"))

    protected var logOutButton: SelenideElement? = `$`(By.id("LOGOUT"))

    protected var yesButton: SelenideElement? = `$`(By.id("YES"))

    @Step("Getting heading text")
    override fun isMyAccountPageOpen(): Boolean {
        log.info("Getting heading text")
        return pageTitle!!.`is`(Condition.visible)
    }

    @Step("Set {0} text to the 'Email' field")
    override fun setEmailField(text: String): MyAccountPageIOS {
        log.info(java.lang.String.format("Set '[%s]' text to the 'Email' field", text))
        ElementHelpers().typeText(emailField!!, text)
        return this
    }

    @Step("Set {0} text to the 'Password' field")
    override fun setPasswordField(text: String): MyAccountPageIOS {
        log.info(java.lang.String.format("Set [%s] text to the 'Password' field", text))
        ElementHelpers().typeText(passwordField!!, text)
        return this
    }

    @Step("Click on the 'Sign In' button")
    override fun clickSignInButton(): MyAccountPageIOS {
        log.info("Click on the 'Sign In' button")
        ElementHelpers().tap(signInButton!!)
        return this
    }

    @Step("Authorization with {0} email, {1} password")
    override fun authorization(email: String, password: String): MyAccountPageIOS {
        log.info(java.lang.String.format("Authorization with '%s' email, '%s' password", email, password))
        setEmailField(email)
        setPasswordField(password)
        return clickSignInButton()
    }

    @Step("Click on the 'Log Out' Button")
    override fun clickLogOutButton(): MyAccountPageIOS {
        log.info("Click on the 'Log Out' Button")
        logOutButton!!.shouldBe(Condition.visible).click()
        return this
    }

    @Step("Accept log out")
    override fun clickYesButton(): MyAccountPageIOS {
        log.info("Accept log out")
        if (yesButton!!.`is`(Condition.visible))
            yesButton!!.click()
        return this
    }

    @Step("Verify if Greeting message is present")
    override fun isGreetingShown(): Boolean {
        log.info("Verify if Greeting message is present")
        return greetingText!!.`is`(Condition.visible)
    }

    @Step("Verify if Error message is present")
    override fun isErrorMsgShown(): Boolean {
        log.info("Verify if Error message is present")
        return txtErrorMsg!!.`is`(Condition.visible)
    }

    @Step("Verify if 'Sign in' button enabled")
    override fun isSignInButtonEnabled(): Boolean {
        log.info("Verify if 'Sign in' button enabled")
        return signInButton!!.`is`(Condition.visible)
    }

    @Step("Getting greeting text")
    override fun getGreetingText(): String {
        log.info("Getting greeting text")
        return greetingText!!.text()
    }
}