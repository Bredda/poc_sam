import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS

import internal.GlobalVariable as GlobalVariable

TestData testData = findTestData(data)

for (def index : (1..testData.getRowNumbers())) {
	String oid = testData.getValue(1, index)
	String expected = testData.getValue(2, index)
	
	ResponseObject resp = WS.sendRequest(findTestObject('99-Requests/Get OID', [('url') : GlobalVariable.oid_url, ('oid') : oid]))

	if (resp.getStatusCode() != 200)
		KeywordUtil.markFailedAndStop ("Erreur lors de la vérification de la valeur dans la MIB. Retour ${resp.getStatusCode()}.")	
	
	String actual = resp.getResponseBodyContent()
	if (!expected.equals(actual)) {
		KeywordUtil.markFailedAndStop("Echec ! La valeur pour l'oid $oid n'est pas celle attendue. Attendue: $expected, actual: $actual")
	} else {
		KeywordUtil.logInfo("La valeur de l'oid $oid est bien celle attendue: $actual")
	}
	
}



