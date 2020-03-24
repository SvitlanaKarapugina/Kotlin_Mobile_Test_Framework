package pages

interface MainPage {
    fun clickOnMoreBtn(): MainPage

    fun openHomePage(): MainPage

    fun clickOnSignIn(): MainPage

    fun logOut(): MainPage
}