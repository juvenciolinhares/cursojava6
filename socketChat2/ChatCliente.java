package socketChat2;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

//1-criar a janela com extends JFrame
public class ChatCliente extends JFrame {
	
	//4- atributos:
	
	JTextField textoParaEnviar;//campo de texto; 
	Socket socket;//comunicação cliente-servidor
	PrintWriter escritor;//escritor de informações
	String nome;
	
	//20- texto recebido do servidor :
	JTextArea textoRecebido;
	
	//24iniciar o leitor de informaçoes
	 Scanner leitor;
	
	
	//23- classe que vai monitorar mensagens chegadas do servidor para apresentar na área de texto
	private class EscutaServidor implements Runnable{

		@Override
		public void run() {
			
			try {
			//24.1 ler do servidor as informações que estão sendo encaminhadas
			String texto;
			while((texto = leitor.nextLine()) != null) {
				textoRecebido.append(texto + "\n");// o metodo append adiciona no final do texto o nove trecho 
			}
			}catch(Exception x) {}
			
		}
		
	}
	
	//2- construtor recebendo o nome de cada cliente:
	public ChatCliente(String nome) {
		
		super("Chat: " + nome);
		this.nome = nome;
		
		
		Font fonte = new Font("serif", Font.PLAIN, 26);//configuração de fonte
		//5- inicialicar o campo de texto:
		textoParaEnviar = new JTextField();
		textoParaEnviar.setFont(fonte);//atribuir a fonte
		
		//6-botao
		JButton botao = new JButton("enviar");
		botao.setFont(fonte);//atribuir a fonte
		
		//14-definir o botao que vai enviar a mensagem adicionando a classe acctionListener(passo 13)
		botao.addActionListener(new EnviarListener());
		
		//7-adicionar o botao num container:
		Container envio = new JPanel();
		
		//8- definir o layout container como border layout:
		envio.setLayout(new BorderLayout());
		
		//-21 inicializar a área de texto do servidor(Jtextarea sempre deve estar em conjunto com um scrollpane)
		textoRecebido = new JTextArea();
		textoRecebido.setFont(fonte);
		JScrollPane scroll = new JScrollPane(textoRecebido);//barra de rolagem
		
		//9-adicionar elementos no container(criar estrutura)
		envio.add(BorderLayout.CENTER, textoParaEnviar);
		envio.add(BorderLayout.EAST, botao);
		
		//22- adicionar ao container o scroll:
		getContentPane().add(BorderLayout.CENTER, scroll);
		//10- adicionar o container dentro do container principal da janela:
		getContentPane().add(BorderLayout.SOUTH, envio);
						
		//12-chamar a configuração de rede
		configurarRede();
		
		
		//3- configuração da janela
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(500, 500);
		setVisible(true);
	}
	
	//13-criar uma classe interna que implemente action listener: 
	private class EnviarListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			//15-criar o escritor que envia as mensagens para o servidor
			escritor.println(nome + ": " + textoParaEnviar.getText());
			//16- chamar o metodo flush para garantir o envio:
			escritor.flush();
			
			//17- limpar o campo de texto pra que outra mensagem seja escrita
			textoParaEnviar.setText("");
			
			//18-colocar o cursor dentro do campo aguardando uma nova digitação;passo 19: construir a outra classe
			textoParaEnviar.requestFocus();
			
		}
		
	}
	//11- criar conexão com o servidor
	private void configurarRede() {
		try {
		socket = new Socket("127.0.0.1", 5000);//socket para conexao
		escritor = new PrintWriter(socket.getOutputStream());//escritor de informações para o servidor
		//24- inicializar o leitor :
		leitor = new Scanner(socket.getInputStream());
		//25-inicializar a escuta de servidor:
		new Thread(new EscutaServidor()).start();
		}catch (Exception e ) {}
	}

	public static void main(String[] args) {
		
		//instanciar a janela
		new ChatCliente("Ricardo");
		new ChatCliente("Sandra");
		
		

	}

}
/*
 * objetivo:
 * receber as mensagens do servidor e apresentar em uma área de texto do cliente.
 */


