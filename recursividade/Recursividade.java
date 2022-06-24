package recursividade;

import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Recursividade {

	// criar um método estático que retorna um inteiro que soma de 0 a x:
	public static int soma(int x) {
		//soma de forma recursiva(chamado de novo quanto for necessário) do numero 0 ao x.

		//parte do problema que sei resolver:(parte onde o numero é = 0)
		
		if(x == 0) {
			return x;
			
		}else {
			System.out.println(x);//valores que x que estão sendo passados para o método abaixo
			return x + soma(x -1);//vou somando x ao x-1, até que esse valor seja 0
		}
	}
	
	//outro exemplo:
	//método que retorne a potencia de um número:
	public static int potencia (int x, int e) {
		
		//parte que eu sei resolver: se a pontencia for 1, o resultado é o proprio numero x
		if(e == 1) {
			return x;
		//parte que eu não sei resolver: quando o a pontencia(numero de elevação é diferente de 1)	
		}else {
			int y = x * potencia(x, e - 1);//isso significa que o "e" vai caindo até chegar em 1, entaão cai no escopo do if e finaliza.
			
			System.out.println(y);//passos intermediários
			return y;
		}
			
	}
	
	//metodo mais complexo:listar diretório dentro de diretóriode diretório...(recursivamente)
	public static void listar (Path path) {
		//verificar se o caminho se trata de um arquivo ou diretório:
		
		//se for um arquivo vamos mostrar o nome:
		if(Files.isRegularFile(path)) {
			System.out.println(path.toAbsolutePath());//caminho completo
		}else {
			String s = "\n" + path.toAbsolutePath();
			//verificar se é um diretorio, caso seja, quero listar o conteúdo
			System.err.println(s.toUpperCase());//caminho completo
			//listar o conteúdo:
			try{
				DirectoryStream<Path> stream = Files.newDirectoryStream(path);
				//listar o conteúdo do diretório:
				for (Path p : stream) {
					
					/*agora entra a recursividade:
					 *  quando for identificado que o caminho "p" se trata de outro diretório
					 * quero novamente listar o subdiretório:
					 */
					listar(p);//se for um diretório, vai cair nesse else e vai listar, enquanto for arquivo, cai no if 
					
				}
			}catch(Exception e) {}
			
		}
		
	}
	
	public static void main(String[] args) {
		System.out.println(soma(10));
		System.out.println(potencia(3, 4));
		listar(Paths.get("C:\\ws-eclipse\\curso java1"));//listar todos os diretórios dentro do C:

	}

}
/*
 * até agora estruterei os programas com métodos que chamam outros métodos
 * 
 * metodo recursivo: chama(executa) a si próprio recursão é um tópico avançado,
 * requer várias aulas.
 * 
 * metodos revursivos dividem o problema em duas partes:
 * 1- uma parte que ele não sabe resolver=> deve ser parecida com o problema principal, porém mais simples ou menor. 
 * 2- outra que sabe resolver
 * 
 * a recursão acontece da seguinte forma:
 * no nosso metodo soma: x + (x -1):
 * 10 + (9-1) pegamos o 10 e somamos a 10 -1, ou seja 10 + 9
 * essa soma foi feita atraves do metodo soma que fez: 9 + (9-1=8)
 * esse oito sofreu a seguinte soma: 8 + (8-1)
 * ou seja:
 * 10+(10-1+(9-1+(8+1(7-1+(6-1+(5-1+(4-1+(3-1+(2-1+(1-1))))))))))
 */
