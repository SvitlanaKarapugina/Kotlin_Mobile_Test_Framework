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
    private val log: Logger = Logger.getLogger(MainPageIOS::class.java.name)

    private val homePageHeader: SelenideElement = `$`(By.xpath("//XCUIElementTypeNavigationBar[@name='HomeVC']"))

    private val searchButton: SelenideElement = `$`(By.id("Search"))

    private val shoppingBagButton: SelenideElement = `$`(By.id("Shopping bag"))

    private val homeButton: SelenideElement = `$`(By.id("Home"))

    private val moreButton: SelenideElement = `$`(By.id("More"))

    private val signInButton: SelenideElement = `$`(By.id("Login"))

    private val myAccountButton: SelenideElement = `$`(By.id("My Account"))

    @Step("Home page is opened")
    override fun isOpen(): Boolean {
        log.info("Home page is opened")
        return homePageHeader.shouldBe(visible).exists()
    }

    @Step("Type on {0} text in search field")
    override fun searchText(searchText: String): MainPage {
        log.info(java.lang.String.format("Type on {0} text in search field", searchText))
        openSearchPage()
        SearchPageIOS().openClothingDropdown().searchByText(searchText)
        return this
    }

    @Step("Open Search page")
    override fun openSearchPage() {
        log.info("Open Search page")
        searchButton.click()
    }

    @Step("Open Bag page")
    override fun openBagPage() {
        log.info("Open Bag page")
        shoppingBagButton.click()
    }

    @Step("Click on 'More' button")
    override fun clickOnMoreBtn(): MainPage {
        log.info("Click on 'More' button")
        moreButton.click()
        return this
    }

    @Step("Open Home page")
    override fun openHomePage(): MainPage {
        log.info("Click on 'More' button")
        homeButton.click()
        return this
    }

    @Step("Click on 'Sign In' button")
    override fun clickOnSignIn(): MainPage {
        log.info("Click on 'Sign In' button")
        signInButton.click()
        return this
    }

    @Step("Log out if needed")
    override fun logOut(): MainPage {
        log.info("Click on 'Sign In' button")
        moreButton.shouldBe(visible)
        moreButton.click()
        if (signInButton.`is`(hidden)) {
            myAccountButton.click()
            MyAccountPageIOS().clickLogOutButton().clickYesButton()
        }
        openHomePage()
        return this
    }
}