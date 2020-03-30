package pages.android

import com.codeborne.selenide.Condition.hidden
import com.codeborne.selenide.Condition.visible
import com.codeborne.selenide.Selenide.`$`
import com.codeborne.selenide.SelenideElement
import io.qameta.allure.Step
import org.openqa.selenium.By
import pages.BasePage
import pages.MainPage
import java.lang.String.format
import java.util.logging.Logger

class MainPageAndroid : BasePage(), MainPage {
    private val log: Logger = Logger.getLogger(MainPageAndroid::class.java.getName())

    private val homePageHeader: SelenideElement = `$`(By.id("toolbar_logo"))

    private val searchButton: SelenideElement = `$`(By.xpath("//*[@text='Search']"))

    private val shoppingBagButton: SelenideElement = `$`(By.xpath("//*[@text='Shopping bag']"))

    private val homeButton: SelenideElement = `$`(By.xpath("//*[@text='Home']"))

    private val moreButton: SelenideElement = `$`(By.xpath("//*[@text='More']"))

    private val signInButton: SelenideElement = `$`(By.xpath("//android.widget.TextView[@text='Sign in']"))

    private val myAccountButton: SelenideElement = `$`(By.xpath("//android.widget.TextView[@text='My account']"))

    @Step("Home page is opened")
    override fun isOpen(): Boolean {
        log.info("Home page is opened")
        return homePageHeader.shouldBe(visible).exists()
    }

    @Step("Open Search Page")
    override fun openSearchPage() {
        log.info("Open Search page")
        searchButton.click()
    }

    @Step("Open Bag page")
    override fun openBagPage() {
        log.info("Open Bag page")
        shoppingBagButton.click()
    }

    @Step("Type on {0} text in search field")
    override fun searchText(searchText: String): MainPage {
        log.info(format("Type on {0} text in search field", searchText))
        openSearchPage()
        SearchPageAndroid().openClothingDropdown().searchByText(searchText)
        return this
    }

    @Step("Click on 'More' button")
    override fun clickOnMoreBtn(): MainPage {
        log.info("Click on 'More' button")
        moreButton.should(visible).click()
        return this
    }

    @Step("Open Home page")
    override fun openHomePage(): MainPage {
        log.info("Click on 'More' button")
        homeButton.should(visible).click()
        return this
    }

    @Step("Click on 'Sign In' button")
    override fun clickOnSignIn(): MainPage {
        log.info("Click on 'Sign In' button")
        signInButton.should(visible).click()
        return this
    }

    @Step("Click on 'Sign In' button")
    override fun logOut(): MainPage {
        log.info("Click on 'Sign In' button")
        moreButton.shouldBe(visible)
        moreButton.click()
        if (signInButton.`is`(hidden)) {
            myAccountButton.click()
            MyAccountPageAndroid().clickLogOutButton().clickYesButton()
        }
        openHomePage()
        return this
    }
}