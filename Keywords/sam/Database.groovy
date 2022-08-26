package sam

import java.sql.Connection
import java.sql.DriverManager
import java.sql.ResultSet
import java.sql.Statement

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.util.KeywordUtil

import common.Helpers
import internal.GlobalVariable



public class Database {

	private static Connection connection = null;

	/**
	 * Vérifier en base la valeur pour un couple oid/item
	 * @param oid oid à vérifier
	 * @param item Nom de l'item de l'opid
	 * @param valeurAttendue Valeur attendue pour le couple
	 */
	@Keyword(keywordObject="Base de donnée")
	def verifierOid(String oid, String item, String valeurAttendue){

		// Contrairement à ce qui est indiqué dans le test, le dernier chiffre de l'oid n'est pas à supprimer
		// String formatedOid = Helpers.removeLastFromOid(oid)

		connect();
		ResultSet rs = executeQuery("select valeur from liredonnees('$item', '$oid') ")

		if (!rs.next()) {
			KeywordUtil.markFailedAndStop("ECHEC ! Aucune valeur n'a été trouvée en base pour l'oid $oid de l'item $item")
		} else {
			String actual = rs.getString('valeur')
			if (!valeurAttendue.equals(actual)) {
				KeywordUtil.markFailedAndStop "ECHEC ! La valeur en base pour l'oid $oid de l'item $item n'est pas celle attendue. Attendue: $valeurAttendue, réelle: $actual"
			} else {
				KeywordUtil.markPassed "La valeur en base pour l'oid $oid de l'item $item n'est bien celle attendue: $actual"
			}
		}

		closeDatabaseConnection()

	}

	private static void connect() {
		String conn = "jdbc:postgresql://${GlobalVariable.sam_db['host']}:5432/${GlobalVariable.sam_db['database']}"
		if(connection != null && !connection.isClosed()){
			connection.close()
		}
		connection = DriverManager.getConnection(conn, GlobalVariable.sam_db['user'], GlobalVariable.sam_db['password'])
	}

	private static ResultSet executeQuery(String queryString) {
		Statement stm = connection.createStatement()
		return stm.executeQuery(queryString)
	}

	private static void closeDatabaseConnection() {
		if(connection != null && !connection.isClosed()){
			connection.close()
		}
		connection = null
	}
}