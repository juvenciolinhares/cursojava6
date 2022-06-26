package jdbcSelectDrivwerConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AcessoBanco {

	public static void main(String[] args) throws Exception {
		// a conex�o com o banco requer uma url

		// 5-criar o select:
		String sql = "select codigo, nome, sexo, email from pessoa";// quero recuperar c�digo, nome, sexo email

		// 1-protocolo de comunica��o, subprotocolo de comunica��o, endere�o ip ou
		// servidor que est� rodando, porta tcp, nome do banco de dados
		String url = "jdbc:oracle:thin@localhost:1521:xe";

		try (// 2-criando a conex�o com o banco
				Connection con = DriverManager.getConnection(url, "xti", "xti123"); // url, usu�rio e senha

				// 3-criar um objeto statement para encaminhar requisi��es para o servidor
				PreparedStatement stm = con.prepareStatement(url); // retorna um preparedstatement que � mais flexivel
																	// que o normal

				// 4-comando que quero executar: SELECT: retorna uma lista de resultados(lista
				// de registro)
				ResultSet rs = stm.executeQuery()) {
			// percorrer cada um dos registros que eu tiver dentro do ResultSet:
			while (rs.next()) {
				String s = rs.getString("codigo") + "; " + rs.getString("nome") + "; " + rs.getString("sexo") + "; "
						+ rs.getString("email");
				System.out.println(s);// imprime todos os dados

				/*
				 * posso ainda chamar pela posi��o da coluna no select:String sql =
				 * "select codigo, nome, sexo, email from pessoa"; sysout(rs.getString(1))=>
				 * imprime c�digo., 2 nome, etc.
				 */

			}
		}

	}

}
