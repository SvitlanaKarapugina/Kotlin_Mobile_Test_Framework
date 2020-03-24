package pages

interface MyAccountPage {
    fun isMyAccountPageOpen(): Boolean

    fun setEmailField(text: String): MyAccountPage

    fun setPasswordField(text: String): MyAccountPage

    fun clickSignInButton(): MyAccountPage

    fun authorization(email: String, password: String): MyAccountPage

    fun clickLogOutButton(): MyAccountPage

    fun clickYesButton(): MyAccountPage

    fun isGreetingShown(): Boolean

    fun isErrorMsgShown(): Boolean

    fun isSignInButtonEnabled(): Boolean

    fun getGreetingText(): String
}