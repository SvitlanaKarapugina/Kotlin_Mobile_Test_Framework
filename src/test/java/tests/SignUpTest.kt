package tests

import io.qameta.allure.Description
import io.qameta.allure.Feature
import org.assertj.core.api.Assertions
import org.testng.annotations.Test

class SignUpTest : BaseTest() {
    var validEmail: String = "sw.karapugina@gmail.com"
    var invalidEmail = "test@email.com"
    var password = "qwerty123"

    @Test
    @Description("Test Description: Sing in test - pass")
    @Feature("SignUpTest")
    fun testSignInPass() {
        pages.mainPage.logOut()
                .clickOnMoreBtn()
                .clickOnSignIn()
        Assertions.assertThat(pages.myAccountPage.isMyAccountPageOpen())
                .describedAs("My Account page isn't opened")
                .isTrue()
        Assertions.assertThat(pages.myAccountPage.setEmailField(validEmail)
                .setPasswordField(password)
                .isSignInButtonEnabled())
                .describedAs("Sig in button isn't present")
                .isTrue()
        Assertions.assertThat(pages.myAccountPage.clickSignInButton()
                .isGreetingPresent())
                .describedAs("Greeting message isn't present")
                .isTrue()
    }

    @Test
    @Description("Test Description: Sing in test - fail")
    @Feature("SignUpTest")
    fun testSignInFail() {
        pages.mainPage.logOut()
                .clickOnMoreBtn()
                .clickOnSignIn()
        Assertions.assertThat(pages.myAccountPage.isMyAccountPageOpen())
                .describedAs("My Account page isn't opened")
                .isTrue()
        Assertions.assertThat(pages.myAccountPage.setEmailField(invalidEmail)
                .setPasswordField(password)
                .isSignInButtonEnabled())
                .describedAs("Sig in button isn't present")
                .isTrue()
        Assertions.assertThat(pages.myAccountPage.clickSignInButton()
                .isErrorMsgPresent())
                .isTrue()
    }
}