package pages.android

import com.codeborne.selenide.Condition
import com.codeborne.selenide.Selenide
import com.codeborne.selenide.SelenideElement
import core.utils.WaitingUtils
import io.qameta.allure.Step
import org.apache.commons.lang3.StringUtils
import org.openqa.selenium.By
import pages.PlpPage
import java.util.logging.Logger

class PlpPageAndroid : PlpPage {
    private val log: Logger = Logger.getLogger(PlpPageAndroid::class.java.name)

    private val productNameTitle: List<SelenideElement> = Selenide.`$$`(By.id("item_gallery_clothing_text"))

    @Step("Get first product name")
    override fun getProductsName(): String {
        log.info("Get first product name")
        WaitingUtils().waitingUntilLoadingIsGone()
        return productNameTitle.first().shouldBe(Condition.visible).text()
    }

    @Step("Verify if PLP page opened correctly for {0}")
    override fun isPLPPageOpenedCorrect(plpSearch: String): Boolean {
        log.info("Verify if PLP page opened correctly")
        return StringUtils.containsIgnoreCase(getProductsName(), plpSearch)
    }
}