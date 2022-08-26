import java.nio.file.Paths

import com.kms.katalon.core.configuration.RunConfiguration

import common.Helpers
import internal.GlobalVariable

String filename = "SITUP_jeuDonnees1_OK.sh"
String remoteCommand = "${GlobalVariable.sshJdd['dirPath']}/$filename"
String cle = Paths.get(RunConfiguration.getProjectDir()).resolve("ssh").resolve("id_rsa").toString()
Helpers.executeSshCommand(GlobalVariable.sshJdd['host'], GlobalVariable.sshJdd['port'], GlobalVariable.sshJdd['user'], cle, remoteCommand)