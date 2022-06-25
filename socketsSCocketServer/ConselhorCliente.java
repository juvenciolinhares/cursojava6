package socketsSCocketServer;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class ConselhorCliente {

	public static void main(String[] args) throws UnknownHostException, IOException {
		//criar uma conexao de socket:
		
		//Socket socket = new Socket();//objeto que representa uma conex�o de rede
		
		//saber o endere�o ip do servidor, qual a maquina que vai estar rodando o programa 
		
		//1-objeto com o endere�o ip e numero da porta tcp
		Socket socket = new Socket("187.18.193.79", 5000); //gerou uma conex�o na maquina local nessa porta 
		
		//ler uma mensagem recebia do servidor:
		Scanner sc = new Scanner (socket.getInputStream());
		System.out.println("Mensagem: " + sc.nextLine());//sempre que uma nova mensagem aparecer esse metodo vai receber essa mensagem
		
		sc.close();//ou colocar o bloco try pra ser fechado quando executar o bloco 
	}

}
/*
 * cliente servidor: meu host se conecta com outros hosts
 * trabalhar na rede:
 * 1- como se conectar com o servidor rodando em outra maquina
 * 2-como enviar mensagens para esse servidor
 * 3- como receber mensagens desse servidor
 * socket: objeto que representa uma conexao de rede entre 2 maquinas 
 * 
 *  pra criar um socket preciso saber o enedere�o de ip e qual a porta  tcp
 *  
 *  portas tcp de 0 a 1023 n�o devem sr usadas pois est�o reservadas pros servi�os conhecidos: internet, email, ftp...
 */
