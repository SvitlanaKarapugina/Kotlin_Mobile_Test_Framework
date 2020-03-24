package pages.android

import com.codeborne.selenide.Selenide.`$`
import com.codeborne.selenide.SelenideElement
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

    protected var signInButton: SelenideElement? = `$`(By.id("hello_user_textview"))

    protected var myAccountButton: SelenideElement? = `$`(By.id("hello_user_textview"))

    override fun clickOnMoreBtn(): MainPage {
        log.info("Click on 'More' button")
        // moreButton!!.should(Condition.visible).click()
        return this
    }

    override fun openHomePage(): MainPage {
        log.info("Click on 'More' button")
        //  homeButton!!.should(Condition.visible).click()
        return this
    }

    override fun clickOnSignIn(): MainPage {
        log.info("Click on 'Sign In' button")
        //  signInButton!!.should(Condition.visible).click()
        return this
    }

    override fun logOut(): MainPage {
        log.info("Click on 'Sign In' button");
        //       moreButton!!.click()
//        if (signInButton!!.`is`(Condition.hidden)) {
//            myAccountButton!!.click()
//            // MyAccountPageAndroid(driver!!).clickLogOutButton().clickYesButton()
//        }
//        openHomePage()
        return this
    }
}