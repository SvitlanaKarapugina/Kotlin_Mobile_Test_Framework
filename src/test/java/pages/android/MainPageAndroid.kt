package pages.android

import com.codeborne.selenide.Condition.hidden
import com.codeborne.selenide.Condition.visible
import com.codeborne.selenide.Selenide.`$`
import com.codeborne.selenide.SelenideElement
import io.qameta.allure.Step
import org.openqa.selenium.By
import pages.BasePage
import pages.MainPage
import java.util.logging.Logger

class MainPageAndroid : BasePage(), MainPage {
    var log: Logger = Logger.getLogger(MainPageAndroid::class.java.getName())

    protected var signUpSection: SelenideElement? = `$`(By.id("tile_container"))

    protected var searchField: SelenideElement? = `$`(By.id("searchEditText"))

    protected var searchButton: SelenideElement? = `$`(By.xpath("//*[@text='Search']"))

    protected var homeButton: SelenideElement? = `$`(By.xpath("//*[@text='Home']"))

    protected var moreButton: SelenideElement? = `$`(By.xpath("//*[@text='More']"))

    protected var signInButton: SelenideElement? = `$`(By.xpath("//android.widget.TextView[@text='Sign in']"))

    protected var myAccountButton: SelenideElement? = `$`(By.xpath("//android.widget.TextView[@text='My account']"))

    @Step("Click on 'More' button")
    override fun clickOnMoreBtn(): MainPage {
        log.info("Click on 'More' button")
        moreButton!!.should(visible).click()
        return this
    }

    @Step("Open Home page")
    override fun openHomePage(): MainPage {
        log.info("Click on 'More' button")
        homeButton!!.should(visible).click()
        return this
    }

    @Step("Click on 'Sign In' button")
    override fun clickOnSignIn(): MainPage {
        log.info("Click on 'Sign In' button")
        signInButton!!.should(visible).click()
        return this
    }

    @Step("Click on 'Sign In' button")
    override fun logOut(): MainPage {
        log.info("Click on 'Sign In' button")
        moreButton!!.shouldBe(visible)
        moreButton!!.click()
        if (signInButton!!.`is`(hidden)) {
            myAccountButton!!.click()
            MyAccountPageAndroid().clickLogOutButton().clickYesButton()
        }
        openHomePage()
        return this
    }
}