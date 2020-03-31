package tests.Search

import io.qameta.allure.Description
import io.qameta.allure.Feature
import org.assertj.core.api.Assertions
import org.testng.annotations.Test
import tests.BaseTest

class SearchTest : BaseTest() {
    //Test data
    private val jeans: String = "Jeans"

    @Test
    @Description("Search")
    @Feature("Search")
    fun testSearch() {
        pages.mainPage.searchText(jeans)
        Assertions.assertThat(pages.plpPage.isPLPPageOpenedCorrect(jeans))
                .describedAs("Wrong plp page open")
                .isTrue()
    }

    @Test
    @Description("Search - Accessories list")
    @Feature("Search")
    fun testSearchAccessories() {
        pages.mainPage.openSearchPage()
        pages.searchPage.openAccessoriesDropdown()
                .verifyListOfAccessories()
    }
}