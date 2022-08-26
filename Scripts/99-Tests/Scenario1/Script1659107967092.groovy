import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

WebUI.callTestCase(findTestCase('01-Briques fonctionnelles/Charger jeu donnees'), [('filename') : 'SITUP_jeuDonnees1_OK.sh'
        , ('attente') : 10], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('01-Briques fonctionnelles/Se connecter a SAM'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('01-Briques fonctionnelles/00-Synoptic/Verifier elements synoptic'), [('data') : 'JDD1-synoptic'], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('01-Briques fonctionnelles/00-Synoptic/Verification visuelle du synoptic'), [('imgName') : 'scenari1_synoptic_jdd1'], 
    FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('01-Briques fonctionnelles/01-Mib/Verifier oid dans la mib'), [('data') : 'JDD1-oids'], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('01-Briques fonctionnelles/01-Mib/Verifier oid en database'), [('data') : 'JDD1-oids'], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('01-Briques fonctionnelles/Charger jeu donnees'), [('filename') : 'SITUP_jeuDonnees2_SITUPmineure.sh'
        , ('attente') : 10], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('01-Briques fonctionnelles/00-Synoptic/Verifier elements synoptic'), [('data') : 'JDD2-synoptic'], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('01-Briques fonctionnelles/00-Synoptic/Verification visuelle du synoptic'), [('imgName') : 'scenari1_synoptic_jdd2'], 
    FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('01-Briques fonctionnelles/01-Mib/Verifier oid dans la mib'), [('data') : 'JDD2-oids'], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('01-Briques fonctionnelles/01-Mib/Verifier oid en database'), [('data') : 'JDD2-oids'], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('01-Briques fonctionnelles/Charger jeu donnees'), [('filename') : 'SITUP_jeuDonnees3_Switchmineure.sh'
        , ('attente') : 10], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('01-Briques fonctionnelles/00-Synoptic/Verifier elements synoptic'), [('data') : 'JDD3-synoptic'], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('01-Briques fonctionnelles/00-Synoptic/Verification visuelle du synoptic'), [('imgName') : 'scenari1_synoptic_jdd3'], 
    FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('01-Briques fonctionnelles/01-Mib/Verifier oid dans la mib'), [('data') : 'JDD3-oids'], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('01-Briques fonctionnelles/01-Mib/Verifier oid en database'), [('data') : 'JDD3-oids'], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('01-Briques fonctionnelles/Charger jeu donnees'), [('filename') : 'SITUP_jeuDonnees4_3etAPImajeure.sh'
        , ('attente') : 10], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('01-Briques fonctionnelles/00-Synoptic/Verifier elements synoptic'), [('data') : 'JDD4-synoptic'], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('01-Briques fonctionnelles/00-Synoptic/Verification visuelle du synoptic'), [('imgName') : 'scenari1_synoptic_jdd4'], 
    FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('01-Briques fonctionnelles/01-Mib/Verifier oid dans la mib'), [('data') : 'JDD4-oids'], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('01-Briques fonctionnelles/01-Mib/Verifier oid en database'), [('data') : 'JDD4-oids'], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('01-Briques fonctionnelles/Charger jeu donnees'), [('filename') : 'SITUP_jeuDonnees5_4etModemPMLBloquante.sh'
        , ('attente') : 10], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('01-Briques fonctionnelles/00-Synoptic/Verifier elements synoptic'), [('data') : 'JDD5-synoptic'], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('01-Briques fonctionnelles/00-Synoptic/Verification visuelle du synoptic'), [('imgName') : 'scenari1_synoptic_jdd5'], 
    FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('01-Briques fonctionnelles/01-Mib/Verifier oid dans la mib'), [('data') : 'JDD5-oids'], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('01-Briques fonctionnelles/01-Mib/Verifier oid en database'), [('data') : 'JDD5-oids'], FailureHandling.STOP_ON_FAILURE)

