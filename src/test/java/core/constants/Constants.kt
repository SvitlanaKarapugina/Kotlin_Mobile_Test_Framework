package core.constants

import core.utils.PropertyUtils
import java.time.Duration


class Constants {
    companion object {
        val TEST_PLATFORM = PropertyUtils().getCentralData("PlatformName").toString().toUpperCase()
        val IMPLICIT_WAIT = Duration.ofSeconds(0)
        val IS_IOS = TEST_PLATFORM == Platforms.IOS.toString()
        val IS_ANDROID = TEST_PLATFORM == Platforms.ANDROID.toString()
    }

    enum class Platforms {
        ANDROID,
        IOS
    }
}