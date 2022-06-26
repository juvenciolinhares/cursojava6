package jdbcInsertBatchAdd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Iterator;

public class IncluirDados {

	public static void main(String[] args) throws SQLException {
		//como inserir informa��es no banco de dados:
						
		//1- definir url de conex�o:
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		
		//5-definir sql:
		String sql = "insert into pessoa valuse(?, ?, ?, ?)";//o statement com os ???? aceita v�rios registros sem precisar fazer um c�digo pra cada.
		
		//6- criar um array de todas as pessoas que eu quero incluir:
		String [] pessoas = {"Sandra", "Beatriz", "Juliana", "Fatima", "Veranda", "Tereza", "Leila"};//quantos nomes que quiser
		
		//colocar tudo dentro do try para finalizar a conex�o no final. 
		try(//2-abrir uma conex�o:
				Connection con = DriverManager.getConnection(url, "nome de usuario", "senha de conexao")){
				
				
				//3-executar comandos no banco chamando o metodo preparedStatement p informar o comando sql que eu quero exdecutar:
				try(PreparedStatement stm = con.prepareStatement(sql)){//posso fazer tanto uma consulta como uma opera��o de inclus�ao nesse banco 
				{
				//7- preencher o statement com os registros dos nomes:
				for (int i = 0; i < pessoas.length; i++) {
					//ver video 111 no tempo 11:40
					stm.setInt(1, i+4);// onde 1 � a posi��o e +4 porque ja exitem 4 inclusoes, entao � a partir da quinta
					stm.setString(2, pessoas[i]);
					stm.setString(3, "F");
					stm.setString(4, pessoas[i].toLowerCase()+"@xti.com.br");
					
					//8- todas essas requisi��es s�o incluidas em um conjunto requisi��es pra ser executada de uma �nica vez(addBatch)
					stm.addBatch(); //inclui as instru��es acima num bloco de instru��es a serem executadas
				}
		
				//9-inclui todas as as instru��es acima num bloco de instru��es a serem executadas uma �nica vez
				}stm.executeBatch();
		
	}catch(SQLException e) {}
				//10- selecionar nome e meil  de todas as pessoas da tabela pessoa
				sql = "select nome, email from pessoa";
				
				//1- cria um novo statement para executar uma consulta:
				try(PreparedStatement stm2 = con.prepareStatement(sql);
						ResultSet rs = stm2.executeQuery()){
					//percorrer todos os registros imprimindo nome e email 
					while(rs.next()) {
						System.out.println(rs.getString(1) + ": " + rs.getByte(2) );//1 nome, 2 email.
					}
				}
		
	}

}
}
/*cada banco de dados tem um formato de url diferente
 * todas as urls jdbc iniciam com
 * 1-jdbc:
 * 2-subprotocolo: db2, oracle, mysql, etc
 * 3-informa o endere�o ir do servidor
 * 4-porta onde o servidor est� respondendo
 * 5- tamb�m contam com o nome do banco. 
 * exemplo:
 * jdbc:oracle:thin:@servidor:porta:banco
 * 
 * quanto menos conex�es se abrir com banco de dados, melhor, pois s�o muito dispendiosas
 */

