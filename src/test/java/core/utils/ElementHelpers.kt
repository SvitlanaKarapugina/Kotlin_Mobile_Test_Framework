package core.utils

import com.codeborne.selenide.Condition
import com.codeborne.selenide.Selenide
import com.codeborne.selenide.SelenideElement
import core.constants.Constants.Companion.IS_IOS
import core.constants.Constants.Companion.WAIT_FIVE_SECOND
import io.appium.java_client.MobileBy.iOSNsPredicateString
import org.openqa.selenium.By.xpath


class ElementHelpers {

    fun tap(element: SelenideElement) {
        element.waitUntil(Condition.visible, WAIT_FIVE_SECOND.toLong())
        element.shouldBe(Condition.enabled)
        element.click()
    }

    fun typeText(element: SelenideElement, text: String) {
        element.shouldBe(Condition.visible)
        element.clear()
        element.sendKeys(text)
    }

    fun getAnyElementContainingText(text: String): SelenideElement {
        return if (IS_IOS) {
            Selenide.`$`(iOSNsPredicateString(java.lang.String.format("value == \"%s\" OR name == \"%s\" OR label == \"%s\" AND type == 'XCUIElementTypeStaticText'", text, text, text)))
        } else {
            Selenide.`$`(xpath(java.lang.String.format("//*[contains(@text,\"%s\")]", text)))
        }
    }

    fun isTextPresent(text: String): Boolean {
        return getAnyElementContainingText(text).exists()
    }

    fun tapOnText(text: String) {
        getAnyElementContainingText(text).click()
    }
}