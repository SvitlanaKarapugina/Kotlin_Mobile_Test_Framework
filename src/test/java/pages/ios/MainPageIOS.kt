package pages.ios

import com.codeborne.selenide.Condition.hidden
import com.codeborne.selenide.Condition.visible
import com.codeborne.selenide.Selenide.`$`
import com.codeborne.selenide.SelenideElement
import io.qameta.allure.Step
import org.openqa.selenium.By
import pages.BasePage
import pages.MainPage
import java.util.logging.Logger

class MainPageIOS : BasePage(), MainPage {
    var log: Logger = Logger.getLogger(MainPageIOS::class.java.getName())

    protected var homeButton: SelenideElement? = `$`(By.id("Home"))

    protected var moreButton: SelenideElement? = `$`(By.id("More"))

    protected var signInButton: SelenideElement? = `$`(By.id("Login"))

    protected var myAccountButton: SelenideElement? = `$`(By.id("My Account"))

    @Step("Click on 'More' button")
    override fun clickOnMoreBtn(): MainPage {
        log.info("Click on 'More' button")
        moreButton!!.click()
        return this
    }

    @Step("Open Home page")
    override fun openHomePage(): MainPage {
        log.info("Click on 'More' button")
        homeButton!!.click()
        return this
    }

    @Step("Click on 'Sign In' button")
    override fun clickOnSignIn(): MainPage {
        log.info("Click on 'Sign In' button")
        signInButton!!.click()
        return this
    }

    @Step("Log out if needed")
    override fun logOut(): MainPage {
        log.info("Click on 'Sign In' button")
        moreButton!!.shouldBe(visible)
        moreButton!!.click()
        if (signInButton!!.`is`(hidden)) {
            myAccountButton!!.click()
            MyAccountPageIOS().clickLogOutButton().clickYesButton()
        }
        openHomePage()
        return this
    }
}