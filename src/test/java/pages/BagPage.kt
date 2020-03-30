package pages

interface BagPage {
    fun isOpen(): Boolean

    fun verifyEmptyBagPageElements(): BagPage

    fun tapContinueShoppingButton()
}