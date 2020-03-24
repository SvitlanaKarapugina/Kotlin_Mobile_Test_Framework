package core.utils

import org.junit.Assert
import java.io.FileInputStream
import java.io.IOException
import java.io.InputStream
import java.util.*


class PropertyUtils {
    fun getCentralData(name: String): String? {
        val filePath = "./src/test/resources/device.properties"
        return getProperty(filePath, name)
    }

    fun getProperty(filePath: String, propertyName: String): String? {
        val prop = Properties()
        var input: InputStream? = null
        var value: String? = null
        try {
            input = FileInputStream(filePath)
            prop.load(input)
            value = prop.getProperty(propertyName)
        } catch (ex: Exception) {
            Assert.fail(ex.message)
        } finally {
            if (input != null) {
                try {
                    input!!.close()
                } catch (e: IOException) {
                    Assert.fail(e.message)
                }

            }
        }
        return value
    }
}