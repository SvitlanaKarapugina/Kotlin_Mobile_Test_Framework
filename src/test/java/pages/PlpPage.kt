package pages

interface PlpPage {
    fun getProductsName(): String

    fun isPLPPageOpenedCorrect(plpName: String): Boolean
}