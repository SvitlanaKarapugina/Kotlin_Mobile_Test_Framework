package tests.Bag

import io.qameta.allure.Description
import io.qameta.allure.Feature
import org.assertj.core.api.Assertions
import org.testng.annotations.Test
import tests.BaseTest

class BagTest : BaseTest() {

    @Test
    @Description("Empty Bag")
    @Feature("Bag")
    fun testEmptyBag() {
        pages.mainPage.openBagPage()
        Assertions.assertThat(pages.bagPage.isOpen())
                .describedAs("Bag isn't opened")
                .isTrue()
        pages.bagPage.verifyEmptyBagPageElements()
                .tapContinueShoppingButton()
        Assertions.assertThat(pages.mainPage.isOpen())
                .describedAs("Home page isn't opened")
                .isTrue()
    }
}