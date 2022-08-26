import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

WebUI.callTestCase(findTestCase('01-Briques fonctionnelles/Charger jeu donnees'), [('filename') : 'SITUP_jeuDonnees1_OK.sh'
        , ('attente') : 10], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('01-Briques fonctionnelles/Se connecter a SAM'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('01-Briques fonctionnelles/00-Synoptic/00-Sous-systeme/Ouvrir donnees supervisees'), [:], 
    FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('01-Briques fonctionnelles/00-Synoptic/00-Sous-systeme/Verifier aucune erreur sous-systeme'), 
    [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('01-Briques fonctionnelles/00-Synoptic/00-Sous-systeme/Verifier horodatage ok'), [('maxSecondsRefresh') : GlobalVariable.frenquenceRefreshData], 
    FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('01-Briques fonctionnelles/00-Synoptic/00-Sous-systeme/Aller sur sous systeme'), [('nom') : 'UC SITUP Etoile'], 
    FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('01-Briques fonctionnelles/00-Synoptic/00-Sous-systeme/Verifier aucune erreur sous-systeme'), 
    [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('01-Briques fonctionnelles/00-Synoptic/00-Sous-systeme/Verifier horodatage ok'), [('maxSecondsRefresh') : 20], 
    FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('01-Briques fonctionnelles/00-Synoptic/00-Sous-systeme/Retourner au synoptic'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('01-Briques fonctionnelles/00-Synoptic/00-Sous-systeme/Aller sur sous systeme'), [('nom') : 'Switch SITUP Etoile'], 
    FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('01-Briques fonctionnelles/00-Synoptic/00-Sous-systeme/Verifier aucune erreur sous-systeme'), 
    [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('01-Briques fonctionnelles/00-Synoptic/00-Sous-systeme/Verifier horodatage ok'), [('maxSecondsRefresh') : 20], 
    FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('01-Briques fonctionnelles/00-Synoptic/00-Sous-systeme/Retourner au synoptic'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('01-Briques fonctionnelles/00-Synoptic/00-Sous-systeme/Aller sur sous systeme'), [('nom') : 'API SITUP Etoile'], 
    FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('01-Briques fonctionnelles/00-Synoptic/00-Sous-systeme/Verifier aucune erreur sous-systeme'), 
    [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('01-Briques fonctionnelles/00-Synoptic/00-Sous-systeme/Verifier horodatage ok'), [('maxSecondsRefresh') : 20], 
    FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('01-Briques fonctionnelles/00-Synoptic/00-Sous-systeme/Retourner au synoptic'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('01-Briques fonctionnelles/00-Synoptic/00-Sous-systeme/Aller sur sous systeme'), [('nom') : 'Modem PML SITUP Etoile'], 
    FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('01-Briques fonctionnelles/00-Synoptic/00-Sous-systeme/Verifier aucune erreur sous-systeme'), 
    [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('01-Briques fonctionnelles/00-Synoptic/00-Sous-systeme/Verifier horodatage ok'), [('maxSecondsRefresh') : 20], 
    FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('01-Briques fonctionnelles/00-Synoptic/00-Sous-systeme/Retourner au synoptic'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('01-Briques fonctionnelles/Charger jeu donnees'), [('filename') : 'SITUP_jeuDonnees2_SITUPmineure.sh'
        , ('attente') : 30], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('01-Briques fonctionnelles/00-Synoptic/00-Sous-systeme/Ouvrir donnees supervisees'), [:], 
    FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('01-Briques fonctionnelles/00-Synoptic/00-Sous-systeme/verifierPresenceErreur'), [('erreursAttendues') : [
            ('Etat DJ Voyant présence230V') : 'alarmeMineure']], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('01-Briques fonctionnelles/00-Synoptic/00-Sous-systeme/Verifier horodatage ok'), [('maxSecondsRefresh') : 20], 
    FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('01-Briques fonctionnelles/Charger jeu donnees'), [('filename') : 'SITUP_jeuDonnees3_Switchmineure.sh'
        , ('attente') : 30], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('01-Briques fonctionnelles/00-Synoptic/00-Sous-systeme/Aller sur sous systeme'), [('nom') : 'Switch SITUP Etoile'], 
    FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('01-Briques fonctionnelles/00-Synoptic/00-Sous-systeme/verifierPresenceErreur'), [('erreursAttendues') : [
            ('Etat contact switch') : 'alarmeMineure']], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('01-Briques fonctionnelles/00-Synoptic/00-Sous-systeme/Verifier horodatage ok'), [('maxSecondsRefresh') : 20], 
    FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('01-Briques fonctionnelles/00-Synoptic/00-Sous-systeme/Retourner au synoptic'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('01-Briques fonctionnelles/Charger jeu donnees'), [('filename') : 'SITUP_jeuDonnees4_3etAPImajeure.sh'
        , ('attente') : 10], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('01-Briques fonctionnelles/00-Synoptic/00-Sous-systeme/Aller sur sous systeme'), [('nom') : 'API SITUP Etoile'], 
    FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('01-Briques fonctionnelles/00-Synoptic/00-Sous-systeme/verifierPresenceErreur'), [('erreursAttendues') : [
            ('CPUAPIServiceRSTP') : 'alarmeMajeure']], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('01-Briques fonctionnelles/00-Synoptic/00-Sous-systeme/Verifier horodatage ok'), [('maxSecondsRefresh') : 20], 
    FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('01-Briques fonctionnelles/00-Synoptic/00-Sous-systeme/Retourner au synoptic'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('01-Briques fonctionnelles/Charger jeu donnees'), [('filename') : 'SITUP_jeuDonnees5_4etModemPMLBloquante.sh'
        , ('attente') : 30], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('01-Briques fonctionnelles/00-Synoptic/00-Sous-systeme/Aller sur sous systeme'), [('nom') : 'Modem PML SITUP Etoile'], 
    FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('01-Briques fonctionnelles/00-Synoptic/00-Sous-systeme/verifierPresenceErreur'), [('erreursAttendues') : [
            ('Etat DJ alimentation Modem PML') : 'alarmeBloquante']], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('01-Briques fonctionnelles/00-Synoptic/00-Sous-systeme/Verifier horodatage ok'), [('maxSecondsRefresh') : 20], 
    FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('01-Briques fonctionnelles/00-Synoptic/00-Sous-systeme/Retourner au synoptic'), [:], FailureHandling.STOP_ON_FAILURE)

