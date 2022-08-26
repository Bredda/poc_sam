package sam

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows

import common.Helpers

import java.nio.file.Paths

import com.kms.katalon.core.configuration.RunConfiguration
import com.kms.katalon.core.exception.StepFailedException

import internal.GlobalVariable

public class LoadData {

	@Keyword
	def static chargerJeuDonnee(String filename) {
		String remoteCommand = "${GlobalVariable.sshJdd['dirPath']}/$filename"
		String cle = Paths.get(RunConfiguration.getProjectDir()).resolve("ssh").resolve("id_rsa").toString()
		Helpers.executeSshCommand(GlobalVariable.sshJdd['host'], GlobalVariable.sshJdd['port'], GlobalVariable.sshJdd['user'], cle, remoteCommand)
		//TODO: prise en charge des erreurs: fichier pas trouvé, etc.
		KeywordUtil.markPassed("Chargement du jeu de donnée : $filename")
	}
}
