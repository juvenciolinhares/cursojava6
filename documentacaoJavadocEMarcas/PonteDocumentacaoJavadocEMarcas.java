package documentacaoJavadocEMarcas;

/*
 * o que colocar dentro de uma documenta��o?
1-descri��o sucinta e clara dos elementos com uma breve descri��o do objetivo de uma ponte. 
2- podemos colocar marcadores, por exemplo: autor da classe , demaneira que se possa recorrer a esse programador. marcodor de autor � o @author, exemplo
@author Juv�ncio Linhares
outros marcadores:
-marcador de vers�o: @version, exemplo
@version 1.3(ja foi modificada, versionada 3x)
-marcador que informa desde qual vers�o do java essa classe vai funcionar: @since, exemplo
@since 1.0(essa interface funciona at� na versao 1.0 do java )

-marcador de referencia a alguma outra classe, interface, m�todo que dialogue com essa: @see(olhe) , exemplo
@see PonteNaoSincronizada
@seePonteSincronizada

os coment�rios s�o uteis para gerar a documenta��o do sistema
essa documenta��o � gerada pelo programa JAVADOC que vem no jdk 

exdecutar o java doc:
1- clica com o botao direto no projeto
2-exportar
3- clica em javadoc
4-clica em next
5- informa o endere�o, caso nao esteja confiugurado
6- Javadoc command: marca o diret�rio que eu desejo criar a documenta��o
7- destination: onde desejo armazenar a documenta��o 
8- flica em finish;

 */

/**
 * descri��o:
 * uma <code>Ponte</code> representa um elo entre os abjetos produtores e consumidores de informa��es.
 * os <i>Produtores</i> utilizam as Pontes para gravar informa��es e compartilhar essas informa��es com os Consumidores
 * que le�m esses das da Ponte para fazer o processamento.
 *  
 * autor ou autores:
 * @author juvencio linhares
 * 
 * marcador de vers�o:
 * @version 1.3(ja foi modificada, versionada 3x)
 * 
 * marcador de vers�o do java que suporta essa classe
 * @since 1.0(desde java 1) 
 * 
 * marcador de referencia a alguma outra classe:
 * @see PonteNaoSincronizada(ver classe PonteNaoSincronizada)
 *@see PonteSincronizada(ver classe PonteSincronizada)
 *
 *marcador que 
 *
 *metodos tamb�m devem ser comentados
 *
 *@param informaa os par�metros utilizados
 *@thwous informa o tipo de exce��es lan�adas nesses m�todos, posso add uma descri��o de quando essa exce��o � lan�ada.  
 *
 */

public class PonteDocumentacaoJavadocEMarcas {
	
	//definir informa��o que vai ser compartilhada; ser� chamado pelo produtor de dados
		//public void set(int valor) throws InterruptedException;//lan�a a esce��o interrup��o
		
		//recupera informa��o que vai ser compartilhada; ser� chamado pelo consumidor de dados. 
		//public int get() throws InterruptedException;//lan�a a esce��o interrup��o

}
