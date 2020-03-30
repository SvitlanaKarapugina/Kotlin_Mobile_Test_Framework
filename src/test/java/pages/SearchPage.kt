package pages

interface SearchPage {
    fun getRecentSearchList(): List<String>

    fun deleteRecentSearchList()

    fun closeSearchPage()

    fun openClothingDropdown(): SearchPage

    fun openAccessoriesDropdown(): SearchPage

    fun verifyListOfAccessories()
}