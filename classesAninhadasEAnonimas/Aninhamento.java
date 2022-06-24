package classesAninhadasEAnonimas;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

//transformar em uma janela:
public class Aninhamento extends JFrame {
	
	//criar um botao:
	JButton botao;
	
	//criar construtor:
	public Aninhamento() {
		
		
		//chamar o construtor de JFrame(da janela)
		super("Aninhamento");
		
		//inicializar o botao:
		botao = new JButton("OK");
		botao.addActionListener(new ListenerAninhado());//atribui a classe aninhada como listener desse botão
		
		//criando classe anônima:
		botao.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// implementação do método do texto do botao:
				System.out.println("Classe Anonima executa: " + botao.getText());
				
			}
		});
		
		//adicionar botao ao container:
		getContentPane().add(botao); 
				
		//definir operação padrao de fechamento, tamanho da janela, visibilidade:
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(300, 300);
		setVisible(true);
	}
	/*em interface gráfica um elemento precisa receber um listener do seu evento
	 * e espera uma classe que implemente actionListener, 
	 * se eu criar essa classe dentro da classe aninhamento, essa classe vai ser uma CLASSE ANINHADA*/
	
	//criar uma classe aninhada(a classe aninhamento é a classe envolvente da minha classe aninhada):
	
	public class ListenerAninhado implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// posso acessar atributos da classe envolvente:
			System.out.println("Classe Aninhada executa: " + botao.getText());
			
		}
		
	}

	public static void main(String[] args) {
		//instancia da classe aninhamento
		Aninhamento janela = new Aninhamento();
		
		//criar uma classe aninhada diretamente:
		//listener aninhado: tipo: nome da classe envolvente . ListenerAninhado + instancia da classe envolvente(aninhamento). new novo obj ListenerAninhado:
		Aninhamento.ListenerAninhado listener = janela.new ListenerAninhado();

	}

}
/*
 * classes e interfaces podem ser declaradas dentro de outras classes e interfaces
 * classes e interfaces aninhadas podem acessar os elementos(atributos, metodos, etc) de suas classes envolventes(onde foram criadas)
 * muito utilizadas em frameworks orientados a eventos (interfaces grafica, por exemplo)
 * 
 * CLASSE ANONIMA: 
 * criada dentro do método, como parametro:
 * botao.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		})
		
		ja cria automaticamente o corpo de uma classe  que implementa actionlistener
		trazendo uma sugestao de implementação de método
 * 
 * 
 * 	tambem posso CRIAR INTERFACES DENTRO DE OUTRAS INTERFACES
 */
