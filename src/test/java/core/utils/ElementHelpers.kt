package core.utils

import com.codeborne.selenide.Condition
import com.codeborne.selenide.Selenide
import com.codeborne.selenide.SelenideElement
import core.constants.Constants.Companion.IS_IOS
import org.openqa.selenium.By.xpath


class ElementHelpers {
    val WAIT_FIVE_SECOND: Int = 5000
    val WAIT_TEN_SECOND: Int = 10000
    protected var englishLang: SelenideElement? = Selenide.`$`(xpath("//*[contains(@text,'English')]"))
    protected var continueBtn: SelenideElement? = Selenide.`$`(xpath("//XCUIElementTypeButton[@name='Continue']"))

    fun chooseCountry() {
        if (englishLang!!.`is`(Condition.visible))
            ElementHelpers().tap(englishLang!!)
    }

    fun tapOnContinue() {
        if (continueBtn!!.`is`(Condition.visible))
            ElementHelpers().tap(continueBtn!!)
    }

    fun tap(element: SelenideElement) {
        element.waitUntil(Condition.visible, WAIT_FIVE_SECOND.toLong())
        element.shouldBe(Condition.enabled)
        element.click()
    }

    protected fun shouldBeConditions(element: SelenideElement, conditions: Condition) {
        element.shouldBe(conditions)
    }

    protected fun checkText(element: SelenideElement, txt: String) {
        element.shouldBe(Condition.visible).shouldHave(Condition.text(txt))
    }


    fun typeText(element: SelenideElement, text: String) {
        element.shouldBe(Condition.visible)
        element.clear()
        element.sendKeys(text)
    }

    fun getAnyElementContainingText(text: String): SelenideElement {
        if (IS_IOS) {
            return Selenide.`$`(xpath(java.lang.String.format("//*[contains(@text,\"%s\")]", text)))
            //Selenide.`$`(iOSNsPredicateString(java.lang.String.format("value == \"%s\" OR name == \"%s\" OR label == \"%s\"", text, text, text)))
        } else {
            return Selenide.`$`(xpath(java.lang.String.format("//*[contains(@text,\"%s\")]", text)))
        }
    }

    fun isTextPresent(text: String): Boolean {
        return getAnyElementContainingText(text).scrollTo().exists()
    }

    fun tapOnText(text: String) {
        getAnyElementContainingText(text).click()
    }
}