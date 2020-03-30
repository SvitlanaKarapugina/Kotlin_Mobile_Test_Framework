package pages.ios

import com.codeborne.selenide.Condition
import com.codeborne.selenide.Selenide
import com.codeborne.selenide.SelenideElement
import io.qameta.allure.Step
import org.openqa.selenium.By
import pages.BagPage
import java.util.logging.Logger

class BagPageIOS : BagPage {
    private val log: Logger = Logger.getLogger(BagPageIOS::class.java.name)

    private val bagPageHeader: SelenideElement = Selenide.`$`(By.xpath("//XCUIElementTypeNavigationBar[@name='Bag']"))

    private val emptyBagHeader: SelenideElement = Selenide.`$`(By.id("Your shopping bag is empty"))

    private val emptyBagDesc: SelenideElement = Selenide.`$`(By.id("Be inspired and discover something new to renew your closet."))

    private val continueShoppingButton: SelenideElement = Selenide.`$`(By.xpath("//XCUIElementTypeButton[@name='Continue shopping']"))

    @Step("Bag page is opened")
    override fun isOpen(): Boolean {
        log.info("Bag page is opened")
        return bagPageHeader.shouldBe(Condition.visible).exists()
    }

    @Step("Verify that Bag is empty")
    override fun verifyEmptyBagPageElements(): BagPageIOS {
        log.info("Verify that Bag is empty")
        emptyBagHeader.shouldBe(Condition.visible).exists()
        emptyBagDesc.exists()
        continueShoppingButton.exists()
        return this
    }

    @Step("Tap on 'Continue shopping' button")
    override fun tapContinueShoppingButton() {
        log.info("Tap on 'Continue shopping' button")
        continueShoppingButton.click()
    }
}