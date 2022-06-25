package socketChat1;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ChatServer {

	// 1- construir o construtor
	public ChatServer() {
		// 3- receber as requisições dos clientes:
		ServerSocket server;
		try {
			server = new ServerSocket(5000);
			while (true) {
				Socket socket = server.accept();// retorna um socket p se comunicar com o cliente que fez a requisição
				//criar threads pra cada requisição do cliente
				
				new Thread(new EscutaCliente(socket)).start();
			}
		} catch (IOException e) {}

	}

	// contruir uma thread que vai monitorar as mensagens que vao chegar através do
	// socket:
	private class EscutaCliente implements Runnable {

		Scanner leitor;

		// recebe o sockt do cliente
		public EscutaCliente(Socket socket) {
			try {
				leitor = new Scanner(socket.getInputStream());// esse Scanner é exclusivo de um cliente
			} catch (Exception e) {}
		}

		@Override
		public void run() {
			//utilizar o scanner de leitura no metodo run por que é ele quem vai monitorar o que está sendo escrito
			
			try {
			String texto;
			while ((texto = leitor.nextLine()) != null) {
				
				System.out.println( texto);
				
			}
		}catch(Exception x) {}
		
		}

	}

	public static void main(String[] args) {
		// 2-chamar no método main

		new ChatServer();

	}

}
