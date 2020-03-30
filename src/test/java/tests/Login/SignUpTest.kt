package tests.Login

import io.qameta.allure.Description
import io.qameta.allure.Feature
import org.assertj.core.api.Assertions
import org.testng.annotations.Test
import tests.BaseTest

class SignUpTest : BaseTest() {
    //Test data
    private val validEmail: String = "sw.karapugina@gmail.com"
    private val invalidEmail = "test@email.com"
    private val password = "qwerty123"

    @Test
    @Description("Test Description: Sing in test - pass")
    @Feature("Sign Up")
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
    @Feature("Sign Up")
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