package socketsSCocketServer;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ConselhoServidor {

	public static void main(String[] args) throws IOException {
		// classe para rodar o servidor
		
		ServerSocket server = new ServerSocket(5000);//servidor com a porta onde ele vai responder as requisições
		
		//while que fica rodando aguardando a chegada de um sockt
		while(true) {
			Socket socket = server.accept();//metodo server.accept() aguarda a chegada de novos clientes e retornar um socket pra haver interação
			try (PrintWriter w = new PrintWriter(socket.getOutputStream()))/*enviar uma mensagem pro cliente*/ {
			w.println("Aprenda Java e seja contratado");//imprimir mensagem
			//coloquei um try para que o printwriter possa ser fechado. 
			}
			
		}
		
		
		
		

	}

}
