package documentacaoJavadocEMarcas;

public class Conta {
	private String cliente;
	private double saldo;
	
	public String getCliente() {
		return cliente;
	}

	public void setCliente(String cliente) {
		this.cliente = cliente;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public Conta() {

	}

	public Conta(String cliente, double saldo) {
		this.cliente = cliente;
		this.saldo = saldo;
	}

	public void exibirSaldo() {
		System.out.println(getCliente() + ", seu saldo é de: " + getSaldo());
	}

	// primeiro metodo com parametros:

	void saca(double valor) {

		saldo -= valor;
	}

	public void deposita(double valor) {
		saldo += valor;
	}

	void transferePara(Conta destino, double valor) {
		this.saca(valor);
		destino.deposita(valor);
	}

	

}
