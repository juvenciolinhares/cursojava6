package socketChat1;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.PrintWriter;
import java.net.Socket;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

//1-criar a janela com extends JFrame
public class ChatCliente extends JFrame {
	
	//4- atributos:
	
	JTextField textoParaEnviar;//campo de texto; 
	Socket socket;//comunicação cliente-servidor
	PrintWriter escritor;//escritor de informações
	String nome;
	
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
		
		//9-adicionar elementos no container(criar estrutura)
		envio.add(BorderLayout.CENTER, textoParaEnviar);
		envio.add(BorderLayout.EAST, botao);
		
		//10- adicionar o container dentro do container principal da janela:
		getContentPane().add(BorderLayout.SOUTH, envio);
		
		//12-chamar a configuração de rede
		configurarRede();
		
		
		//3- configuração da janela
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(500, 90);
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
		}catch (Exception e ) {}
	}

	public static void main(String[] args) {
		
		//instanciar a janela
		new ChatCliente("Ricardo");
		new ChatCliente("Sandra");
		
		

	}

}


