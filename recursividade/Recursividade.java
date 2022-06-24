package recursividade;

import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Recursividade {

	// criar um m�todo est�tico que retorna um inteiro que soma de 0 a x:
	public static int soma(int x) {
		//soma de forma recursiva(chamado de novo quanto for necess�rio) do numero 0 ao x.

		//parte do problema que sei resolver:(parte onde o numero � = 0)
		
		if(x == 0) {
			return x;
			
		}else {
			System.out.println(x);//valores que x que est�o sendo passados para o m�todo abaixo
			return x + soma(x -1);//vou somando x ao x-1, at� que esse valor seja 0
		}
	}
	
	//outro exemplo:
	//m�todo que retorne a potencia de um n�mero:
	public static int potencia (int x, int e) {
		
		//parte que eu sei resolver: se a pontencia for 1, o resultado � o proprio numero x
		if(e == 1) {
			return x;
		//parte que eu n�o sei resolver: quando o a pontencia(numero de eleva��o � diferente de 1)	
		}else {
			int y = x * potencia(x, e - 1);//isso significa que o "e" vai caindo at� chegar em 1, enta�o cai no escopo do if e finaliza.
			
			System.out.println(y);//passos intermedi�rios
			return y;
		}
			
	}
	
	//metodo mais complexo:listar diret�rio dentro de diret�riode diret�rio...(recursivamente)
	public static void listar (Path path) {
		//verificar se o caminho se trata de um arquivo ou diret�rio:
		
		//se for um arquivo vamos mostrar o nome:
		if(Files.isRegularFile(path)) {
			System.out.println(path.toAbsolutePath());//caminho completo
		}else {
			String s = "\n" + path.toAbsolutePath();
			//verificar se � um diretorio, caso seja, quero listar o conte�do
			System.err.println(s.toUpperCase());//caminho completo
			//listar o conte�do:
			try{
				DirectoryStream<Path> stream = Files.newDirectoryStream(path);
				//listar o conte�do do diret�rio:
				for (Path p : stream) {
					
					/*agora entra a recursividade:
					 *  quando for identificado que o caminho "p" se trata de outro diret�rio
					 * quero novamente listar o subdiret�rio:
					 */
					listar(p);//se for um diret�rio, vai cair nesse else e vai listar, enquanto for arquivo, cai no if 
					
				}
			}catch(Exception e) {}
			
		}
		
	}
	
	public static void main(String[] args) {
		System.out.println(soma(10));
		System.out.println(potencia(3, 4));
		listar(Paths.get("C:\\ws-eclipse\\curso java1"));//listar todos os diret�rios dentro do C:

	}

}
/*
 * at� agora estruterei os programas com m�todos que chamam outros m�todos
 * 
 * metodo recursivo: chama(executa) a si pr�prio recurs�o � um t�pico avan�ado,
 * requer v�rias aulas.
 * 
 * metodos revursivos dividem o problema em duas partes:
 * 1- uma parte que ele n�o sabe resolver=> deve ser parecida com o problema principal, por�m mais simples ou menor. 
 * 2- outra que sabe resolver
 * 
 * a recurs�o acontece da seguinte forma:
 * no nosso metodo soma: x + (x -1):
 * 10 + (9-1) pegamos o 10 e somamos a 10 -1, ou seja 10 + 9
 * essa soma foi feita atraves do metodo soma que fez: 9 + (9-1=8)
 * esse oito sofreu a seguinte soma: 8 + (8-1)
 * ou seja:
 * 10+(10-1+(9-1+(8+1(7-1+(6-1+(5-1+(4-1+(3-1+(2-1+(1-1))))))))))
 */
