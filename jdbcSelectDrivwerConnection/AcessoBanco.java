package jdbcSelectDrivwerConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AcessoBanco {

	public static void main(String[] args) throws Exception {
		// a conexão com o banco requer uma url

		// 5-criar o select:
		String sql = "select codigo, nome, sexo, email from pessoa";// quero recuperar código, nome, sexo email

		// 1-protocolo de comunicação, subprotocolo de comunicação, endereço ip ou
		// servidor que está rodando, porta tcp, nome do banco de dados
		String url = "jdbc:oracle:thin@localhost:1521:xe";

		try (// 2-criando a conexão com o banco
				Connection con = DriverManager.getConnection(url, "xti", "xti123"); // url, usuário e senha

				// 3-criar um objeto statement para encaminhar requisições para o servidor
				PreparedStatement stm = con.prepareStatement(url); // retorna um preparedstatement que é mais flexivel
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
				 * posso ainda chamar pela posição da coluna no select:String sql =
				 * "select codigo, nome, sexo, email from pessoa"; sysout(rs.getString(1))=>
				 * imprime código., 2 nome, etc.
				 */

			}
		}

	}

}
