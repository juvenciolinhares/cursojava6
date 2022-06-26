package jdbcTransacaoCommitRollback;

public class Conta {
	int numero;
	String cliente;
	double saldo;
	
	//construtor inicializando esses valores:
	public Conta(int numero, String cliente, double saldo) {
		this.numero = numero;
		this.cliente = cliente;
		this.saldo = saldo;
		
	}
	
	//sobrescrever o toString pra ja conseguir ver os dados da conta quando estiver apresentando:
	
	@Override
	public String toString() {
		return numero + ", " + cliente + ", " + saldo;
	}

}
