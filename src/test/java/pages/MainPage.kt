package pages

interface MainPage {
    fun isOpen(): Boolean

    fun clickOnMoreBtn(): MainPage

    fun openHomePage(): MainPage

    fun clickOnSignIn(): MainPage

    fun logOut(): MainPage

    fun searchText(searchText: String): MainPage

    fun openSearchPage()

    fun openBagPage()
}