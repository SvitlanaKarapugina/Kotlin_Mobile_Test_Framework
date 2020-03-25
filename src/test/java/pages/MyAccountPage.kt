package pages

interface MyAccountPage {
    fun isMyAccountPageOpen(): Boolean

    fun setEmailField(text: String): MyAccountPage

    fun setPasswordField(text: String): MyAccountPage

    fun clickSignInButton(): MyAccountPage

    fun authorization(email: String, password: String): MyAccountPage

    fun clickLogOutButton(): MyAccountPage

    fun clickYesButton(): MyAccountPage

    fun isGreetingPresent(): Boolean

    fun isErrorMsgPresent(): Boolean

    fun isSignInButtonEnabled(): Boolean

    fun getGreetingText(): String
}