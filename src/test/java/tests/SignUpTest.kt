package tests

import io.qameta.allure.Description
import org.testng.annotations.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class SignUpTest : BaseTest() {
    var validEmail: String = "sw.karapugina@gmail.com"
    var invalidEmail = "test@email.com"
    var password = "qwerty123"

    @Test
    @Description("Test Description: Sing in test - pass")
    fun testSignInPass() {
        pages.mainPage.logOut()
                .clickOnMoreBtn()
                .clickOnSignIn()
        assertTrue(pages.myAccountPage.isMyAccountPageOpen(), "My Account page isn't opened")
        assertTrue(pages.myAccountPage.setEmailField(validEmail)
                .setPasswordField(password)
                .isSignInButtonEnabled())
        assertFalse(pages.myAccountPage.clickSignInButton()
                .isErrorMsgShown())
        assertTrue(pages.myAccountPage.isGreetingShown())
    }

    @Test
    @Description("Test Description: Sing in test - fail")
    fun testSignInFail() {
        pages.mainPage.logOut()
                .clickOnMoreBtn()
                .clickOnSignIn()
        assertTrue(pages.myAccountPage.isMyAccountPageOpen())
        assertTrue(pages.myAccountPage.setEmailField(invalidEmail)
                .setPasswordField(password)
                .isSignInButtonEnabled())
        pages.myAccountPage.clickSignInButton()
        assertTrue(pages.myAccountPage.isErrorMsgShown())
    }
}