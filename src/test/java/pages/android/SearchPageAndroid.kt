package pages.android

import com.codeborne.selenide.Selenide
import com.codeborne.selenide.SelenideElement
import core.utils.ElementHelpers
import io.qameta.allure.Step
import org.assertj.core.api.Assertions
import org.openqa.selenium.By
import pages.SearchPage
import java.util.logging.Logger
import kotlin.streams.toList

class SearchPageAndroid : SearchPage {
    private val log: Logger = Logger.getLogger(SearchPageAndroid::class.java.name)

    private val clothingDropDown: SelenideElement = Selenide.`$`(By.xpath("//android.widget.TextView[@text='Clothing']"))

    private val accessoriesDropDown: SelenideElement = Selenide.`$`(By.xpath("//android.widget.TextView[@text='Accessories']"))

    @Step("Open Clothing dropdown")
    override fun openClothingDropdown(): SearchPageAndroid {
        log.info("Open Clothing dropdown")
        clothingDropDown.click()
        return this
    }

    @Step("Open Accessories dropdown")
    override fun openAccessoriesDropdown(): SearchPageAndroid {
        log.info("Open Accessories dropdown")
        accessoriesDropDown.click()
        return this
    }

    @Step("Search by text {0}")
    fun searchByText(search: String) {
        log.info("Search by text $search")
        ElementHelpers().tapOnText(search)
    }

    private fun getRecentSearchListOfElements(): List<SelenideElement> {
        return Selenide.`$$`(By.xpath("//android.widget.TextView[@text='RECENT SEARCHES']//following::android.widget.TextView"))
    }

    @Step("Get Recent Searches")
    override fun getRecentSearchList(): List<String> {
        log.info("Get Recent Searches")
        return getRecentSearchListOfElements().stream().map { t -> t.text() }.toList()
    }

    override fun deleteRecentSearchList() {
        TODO("not need for Android")
    }

    @Step("Close Search page")
    override fun closeSearchPage() {
        log.info("Close Search page")
        MainPageAndroid().openHomePage()
    }

    @Step("Verify Accessories list")
    override fun verifyListOfAccessories() {
        log.info("Verify Accessories list")
        listOfAccessories().stream().map(String::capitalize)
                .forEach { t -> Assertions.assertThat(ElementHelpers().isTextPresent(t)) }
    }

    private fun listOfAccessories(): List<String> {
        return arrayListOf("Shoes", "Bags", "Jewelry", "Wallets and cases", "Scarves", "Belts", "Sunglasses",
                "Hats", "More accessories")
    }
}