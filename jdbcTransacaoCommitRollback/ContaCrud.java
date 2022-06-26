package jdbcTransacaoCommitRollback;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ContaCrud {
	
	//VII-MÉTODO DE TRANSFERENCIA DE VALORES ENTRE CONTAS:
	//17-criando o metodo+ conexão com o banco , conta de origem, conta destino, valor da transferencia:
	public void transferir(Connection con, Conta origem, Conta destino, double valor) throws SQLException {
		
		//18- verificar se a conta de origem tem saldo: 
		if(origem.saldo >= valor) {
		
			try {
				//20-para garantir que as duas operações aconteçao e que haja reversão da operação caso uma falhe:	
				con.setAutoCommit(false);// autocommit false, trata as duas operações como uma só.
				
				//19-operações:
				//19.1- saque: debitar o valor e alterar no banco de dados:
				origem.saldo -= valor;
				alterar(con, origem);
								
				//19.2-deposito: adicionar o valor e alterar no banco de dados
				destino.saldo += valor;
				alterar(con, destino);
				
				//21-confirmar a transação caso as duas operações(saque, deposito) tenha sido bem sucedidas:
				con.commit();
			}catch(Exception e) {
				//22- caso aconteça algum problema no try desfaço a transação:
				con.rollback();// desfaz a transação
			}
			
		}
	}
	
	
	//I-MÉTODO QUE CRIA UMA CONTA NOVA NO BANCO DE DADOS:
	//1- inclui uma conta no banco de dados:
	public void cria(Connection con, Conta conta) throws SQLException {
		//2- comando para criar a conta:
		String sql = "insert into conta values(?, ?, ?)"; //os valores sao: ???=> numero da conta, cliente e saldo
		
		
		//3-criar o statement dentro de um try para ser fechado depois de utilizado 
		try(PreparedStatement stm = con.prepareStatement(sql)){
		
			//4-incluir os dados no statement e efetuar chamando o metodo  executeUpdate
			stm.setInt(1, conta.numero);
			stm.setString(2, conta.cliente);
			stm.setDouble(3, conta.saldo);
			stm.executeUpdate();
		}
		
	}
	//IV-CRIAR MÉTODO PRA ALTERAR CONTAS:
	public void alterar(Connection con, Conta conta) throws SQLException {
		// comando para alterar dados da conta:
		String sql = "update conta set client=?, saldo=?, where numer=?"; //dados atualizados da conta onde(where) o numero da conta for igua a conta recebida;
		
		
		//criar o statement dentro de um try para ser fechado depois de utilizado 
		try(PreparedStatement stm = con.prepareStatement(sql)){
		
			//alterar os dados no statement e efetuar chamando o metodo  executeUpdate
			stm.setString(1, conta.cliente);
			stm.setDouble(2, conta.saldo);
			stm.setInt(3, conta.numero);
			stm.executeUpdate();
		}
		
	}
	//V-CRIAR MÉTODO PRA EXCLUIR CONTAS:
		public void excluir(Connection con, Conta conta) throws SQLException {
			// comando para exlçuir uma conta:
			String sql = "delete conta wher numero=?"; //deletar da tabela o registrio de conta que tenha o numero de conta informado.			
			
			//criar o statement dentro de um try para ser fechado depois de utilizado 
			try(PreparedStatement stm = con.prepareStatement(sql)){
			
				//deletar os dados no statement e efetuar chamando o metodo  executeUpdate
				stm.setInt(1, conta.numero);
				stm.executeUpdate();
			}
			
		}
	//II-CRIAR MÉTODO PRA CONSULTAR AS CONTAS QUE CRIAMOS(retorna uma lista de contas)
	public List<Conta> ler(Connection con) throws SQLException{
		//5-retorna um objeto de lista de contas:
		List<Conta> lista = new ArrayList<>();
		
		//6-comando pra selecionar os elementos na tabela:
		String sql = "select numero, cliente, saldo";
		
		//7-preencher a lista:(criar statement e resultSet:)
		try(PreparedStatement stm = con.prepareStatement(sql);//statement
			ResultSet rs = stm.executeQuery()){
			//8-percorrer elementos dentro do resultSet:
			while(rs.next()) {
			//9-adicionar à lista uma nova conta com os paramentros em cada posição: 1,2,3:
				lista.add(new Conta(rs.getInt(1), rs.getString(2), rs.getDouble(3)));
			}
			
		}
		return lista;
	}
	public static void main(String[] args) throws SQLException {
		//III-EXECUTAR OS DOIS MÉTODOS:
		//11- cria uma ural de conexão:
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		
		//12- abrir uma nova conexão dentro de um try :
		try(Connection con = DriverManager.getConnection(url, "usuário", "senha")){
			//13- executar os métodos da conta CRUD:
			ContaCrud crud = new ContaCrud();
			/*
			//VI-TESTE DOS METODOS:
			//testando: alterar conta:
			Conta conta1 = new Conta(1,"Ricardo", 1000.10);
			conta1.saldo = 9000.90;//passei o valor que eu quero alterar
			crud.alterar(con, conta1);//chamei o método de alteração
			
			//testando: excluir conta:
			Conta conta3 = new Conta(1,"Beatriz", 3000.30);
			crud.excluir(con, conta3);//chamada do método.
			
			
			//14-criar contas:
			Conta conta1 = new Conta(1,"Ricardo", 1000.10);
			Conta conta2 = new Conta(2,"Lawrence", 2000.20);
			Conta conta3 = new Conta(1,"Beatriz", 3000.30);
			
			//15-adicionar as tres contas:
			crud.cria(con, conta1);
			crud.cria(con, conta2);
			crud.cria(con, conta3);
			*/
			//23- criar um objeto CRUD(ja criado no passo 13):
			//24- recuperar as contas do banco(passo 16)
			
			
			//16-apresentar todas as contas que estão nos bancos de dados:
			List<Conta> contas = crud.ler(con);//passando a conexão por parametro
			for (Conta conta : contas) {
				System.out.println(conta);
				
			}
			
			//25- para testar o método de transferencia vou definir uma conta de origem e uma destino:
			Conta origem = contas.get(0);
			Conta destino = contas.get(1);
			
			//26- transferir (objeto crud):
			crud.transferir(con, origem, destino, 500);//con= banco de dados+ contas de origem e destino e valor. 
			
			//-27 apresengtar contas alteradas:
			contas = crud.ler(con);//passando a conexão por parametro
			for (Conta conta : contas) {
				System.out.println(conta);
				
			}
		}
		
	}

}

 
/*
 * TRANSAÇÃO:
 * um conjunto de operações de banco de dadoas deve ser tratado como se forsse uma unica operação
 * se uma operação falhar, todas as outras deem ser desfeitas e a transação revertida
 * caso todas as operações sejam bem sucedidas a transação deve ser confirmada. 
 */