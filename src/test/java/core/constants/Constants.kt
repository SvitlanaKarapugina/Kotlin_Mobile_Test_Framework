package core.constants

import core.utils.PropertyUtils


class Constants {
    companion object {
        val TEST_PLATFORM = PropertyUtils().getCentralData("PlatformName").toString().toUpperCase()
        val IS_IOS = TEST_PLATFORM == Platforms.IOS.toString()
        val IS_ANDROID = TEST_PLATFORM == Platforms.ANDROID.toString()

        // Time
        val WAIT_FIVE_SECOND: Int = 5000
        val WAIT_TEN_SECOND: Int = 10000
        val WAIT_TWENTY_SECOND: Int = 20000
        val ONE_MINUTE: Int = 600000
    }

    enum class Platforms {
        ANDROID,
        IOS
    }
}