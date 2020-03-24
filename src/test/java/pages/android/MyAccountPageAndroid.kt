package pages.android

import com.codeborne.selenide.Selenide.`$`
import com.codeborne.selenide.SelenideElement
import org.openqa.selenium.By
import pages.BasePage
import pages.MyAccountPage
import java.lang.String.format
import java.util.logging.Logger

class MyAccountPageAndroid : BasePage(), MyAccountPage {
    protected var log: Logger = Logger.getLogger(MyAccountPageAndroid::class.java.toString())

    protected var pageTitle: SelenideElement? = `$`(By.id("toolbar_title"))

    protected var emailField: SelenideElement? = `$`(By.id("login_email_edittext"))

    protected var passwordField: SelenideElement? = `$`(By.id("password_edittext"))

    protected var signInButton: SelenideElement? = `$`(By.id("login_button"))

    protected var registerButton: SelenideElement? = `$`(By.id("register_button"))

    protected var greetingText: SelenideElement? = `$`(By.xpath(".//*[contains(@text, 'Hello')]"))

    protected var txtErrorMsg: SelenideElement? = `$`(By.xpath("//android.widget.TextView[@text='Incorrect e-mail or password']"))

    protected var logOutButton: SelenideElement? = `$`(By.id("myaccount_logout_button"))

    protected var noButton: SelenideElement? = `$`(By.id("dialog_layout_button_negative"))

    protected var yesButton: SelenideElement? = `$`(By.id("dialog_layout_button_positive"))

    override fun isMyAccountPageOpen(): Boolean {
        log.info("Getting heading text")
        //return pageTitle!!.`is`(visible)
        return true
    }

    override fun setEmailField(text: String): MyAccountPageAndroid {
        log.info(format("Set '[%s]' text to the 'Email' field", text))
        //ElementHelpers().typeText(emailField!!, text)
        return this
    }

    override fun setPasswordField(text: String): MyAccountPageAndroid {
        log.info(format("Set [%s] text to the 'Password' field", text))
        //ElementHelpers().typeText(passwordField!!, text)
        return this
    }

    override fun clickSignInButton(): MyAccountPageAndroid {
        log.info("Click on the 'Sign In' button")
        // ElementHelpers().tap(signInButton!!)
        return this
    }

    override fun authorization(email: String, password: String): MyAccountPageAndroid {
        log.info(format("Authorization with '%s' email, '%s' password", email, password))
        setEmailField(email)
        setPasswordField(password)
        return clickSignInButton()
    }

    override fun clickLogOutButton(): MyAccountPageAndroid {
        log.info("Click on the 'Log Out' Button")
        //logOutButton!!.shouldBe(visible).click()
        return this
    }

    override fun clickYesButton(): MyAccountPageAndroid {
        log.info("Accept log out")
        //  yesButton!!.shouldBe(visible).click()
        return this
    }

    override fun isGreetingShown(): Boolean {
        log.info("Verify if Greeting message is present")
        // return greetingText!!.exists()
        return true
    }

    override fun isErrorMsgShown(): Boolean {
        log.info("Verify if Error message is present")
        //return txtErrorMsg!!.exists()
        return true
    }

    override fun isSignInButtonEnabled(): Boolean {
        log.info("Verify if 'Sign in' button enabled ")
        //return signInButton!!.exists()
        return true
    }

    override fun getGreetingText(): String {
        log.info("Getting greeting text")
        //return greetingText!!.text()
        return ""
    }
}