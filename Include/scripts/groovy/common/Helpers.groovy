package common

import java.sql.Connection
import java.sql.DriverManager
import java.sql.ResultSet
import java.sql.Statement

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.util.KeywordUtil

import internal.GlobalVariable


class Helpers {

	/**
	 * Formate un OID en enlevant la dernière partie
	 * @param originalOid OID à formater
	 * @return OID formaté
	 */
	public static String removeLastFromOid(String originalOid) {
		def parts = originalOid.tokenize("\\.")
		parts.remove(parts.size() - 1)
		return parts.join(".")
	}

	/**
	 * Execute la commande ssh
	 * @param host
	 * @param port
	 * @param user
	 * @param keyPath
	 * @param command
	 * @return
	 */
	public static executeSshCommand(String host, String port, String user, String keyPath, String command) {
		String sshCommand = "ssh -i $keyPath -p $port $user@$host $command"
		Process proc = "$sshCommand".execute();
		StringBuffer outputStream = new StringBuffer();
		proc.waitForProcessOutput(outputStream, System.err);
		String consoleOutput = outputStream.toString();
		KeywordUtil.logInfo "Retour commande SSH: $consoleOutput"
	}

	public static Map isDateLessThanXSecondes(String date, int nbSecondes = 30, String dateFormat = "dd/MM/yyyy hh:mm:ss") {
		def result = ['result': false, 'now': null]
		def testDate = Date.parse(dateFormat, date)
		KeywordUtil.logInfo("Test date is $testDate")
		result['now'] = new Date()
		use (groovy.time.TimeCategory) {
			result['result'] = (result['now'] - testDate <  nbSecondes.seconds) && result['now'] > testDate
		}
		KeywordUtil.logInfo("Now is $result['now']")
		return result
	}

	public static boolean isSinceLessThanXSeconds(String since, int nbSeconds = 30) {
		String[] parts = since.split(' ')
		return parts[0].toInteger() < nbSeconds
	}
}