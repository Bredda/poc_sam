import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import internal.GlobalVariable as GlobalVariable

if (GlobalVariable.createBaselines) {
	CustomKeywords.'sam.Visual.takeWebElementBaseline'(findTestObject('Object Repository/01-Synoptic/diagram_container'), 
        imgName)
} else {
	CustomKeywords.'sam.Visual.verifierWebElementBaseline'(findTestObject('Object Repository/01-Synoptic/diagram_container'),
		imgName)
}





