package pages.android

import com.codeborne.selenide.Condition
import com.codeborne.selenide.Selenide.`$`
import com.codeborne.selenide.SelenideElement
import io.qameta.allure.Step
import org.openqa.selenium.By
import pages.BagPage
import pages.ios.BagPageIOS
import java.util.logging.Logger

class BagPageAndroid : BagPage {
    private val log: Logger = Logger.getLogger(BagPageIOS::class.java.name)

    private val bagPageHeader: SelenideElement = `$`(By.xpath("//android.widget.TextView[@text='Bag']"))
    private val emptyBagHeader: SelenideElement = `$`(By.xpath("//android.widget.TextView[@text='YOUR SHOPPING BAG IS EMPTY']"))
    private val emptyBagDesc: SelenideElement = `$`(By.xpath("//android.widget.TextView[@text='Be inspired and discover something new to renew your closet.']"))
    private val continueShoppingButton: SelenideElement = `$`(By.id("empty_button"))

    @Step("Bag page is opened")
    override fun isOpen(): Boolean {
        log.info("Bag page is opened")
        return bagPageHeader.shouldBe(Condition.visible).exists()
    }

    @Step("Verify that Bag is empty")
    override fun verifyEmptyBagPageElements(): BagPageAndroid {
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