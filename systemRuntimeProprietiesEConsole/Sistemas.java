package systemRuntimeProprietiesEConsole;

import java.io.Console;
import java.io.IOException;
import java.util.Properties;
import java.util.Set;

public class Sistemas {

	public static void main(String[] args) throws IOException {
		
		//como recuperar as propriedas do sistema operacional:
		
		
		Properties p = System.getProperties();//retorna um objeto do tipo properties que é uma coleção do tipo map(chave-valor)
		
		//algunas exemplos:
		//recuperar a versão do java:
		System.out.println("a versao do java é: " +p.getProperty("java.version"));
		
		//definir propriedades no sistema:
		p.setProperty("xti.curso.java.version", "1.0.0");
		
		//todas as propriedades disponiveis:
		Set<Object> pk = p.keySet(); //coleção sem duplicidade
		for(Object key : pk) {
			System.out.println(key + "= " + p.get(key));//recupera chave e valor
		}
		
		//recuperar um objeto do tipo console
		//posso recuperar, por exemplo uma senha atraves do prompt de comando de forma segura, sem que ela fique exposta
		
		/*
		Console c = System.console();
		System.out.println("Usuário: ");
		String user = c.readLine();//ler uma linha de informação do sistema 
		System.out.println("Senha:");
		char[] pass = c.readPassword();//retorna um array de char
		System.out.println("Usuário" + user + "; " + "senha: " + pass);
		*/
		
		/*recursos da classe runtime
		 * essa classe permite a execução de programas
		 * diretamente no sistema operacional
		 */
		//consegue executar um programa da mesma forma do prompt de comando
		 Runtime.getRuntime().exec("notepad");//aqui inicializei o notepad
		 
	}

}
