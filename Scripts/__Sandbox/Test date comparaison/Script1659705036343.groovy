import com.kms.katalon.core.util.KeywordUtil

import common.Helpers

boolean test = Helpers.isDateLessThanXSecondes("05/08/2022 15:20:00")

KeywordUtil.logInfo ("Result is :$test")