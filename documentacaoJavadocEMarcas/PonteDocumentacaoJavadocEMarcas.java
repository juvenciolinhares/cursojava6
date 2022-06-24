package documentacaoJavadocEMarcas;

/*
 * o que colocar dentro de uma documentação?
1-descrição sucinta e clara dos elementos com uma breve descrição do objetivo de uma ponte. 
2- podemos colocar marcadores, por exemplo: autor da classe , demaneira que se possa recorrer a esse programador. marcodor de autor é o @author, exemplo
@author Juvêncio Linhares
outros marcadores:
-marcador de versão: @version, exemplo
@version 1.3(ja foi modificada, versionada 3x)
-marcador que informa desde qual versão do java essa classe vai funcionar: @since, exemplo
@since 1.0(essa interface funciona até na versao 1.0 do java )

-marcador de referencia a alguma outra classe, interface, método que dialogue com essa: @see(olhe) , exemplo
@see PonteNaoSincronizada
@seePonteSincronizada

os comentários são uteis para gerar a documentação do sistema
essa documentação é gerada pelo programa JAVADOC que vem no jdk 

exdecutar o java doc:
1- clica com o botao direto no projeto
2-exportar
3- clica em javadoc
4-clica em next
5- informa o endereço, caso nao esteja confiugurado
6- Javadoc command: marca o diretório que eu desejo criar a documentação
7- destination: onde desejo armazenar a documentação 
8- flica em finish;

 */

/**
 * descrição:
 * uma <code>Ponte</code> representa um elo entre os abjetos produtores e consumidores de informações.
 * os <i>Produtores</i> utilizam as Pontes para gravar informações e compartilhar essas informações com os Consumidores
 * que leêm esses das da Ponte para fazer o processamento.
 *  
 * autor ou autores:
 * @author juvencio linhares
 * 
 * marcador de versão:
 * @version 1.3(ja foi modificada, versionada 3x)
 * 
 * marcador de versão do java que suporta essa classe
 * @since 1.0(desde java 1) 
 * 
 * marcador de referencia a alguma outra classe:
 * @see PonteNaoSincronizada(ver classe PonteNaoSincronizada)
 *@see PonteSincronizada(ver classe PonteSincronizada)
 *
 *marcador que 
 *
 *metodos também devem ser comentados
 *
 *@param informaa os parâmetros utilizados
 *@thwous informa o tipo de exceções lançadas nesses métodos, posso add uma descrição de quando essa exceção é lançada.  
 *
 */

public class PonteDocumentacaoJavadocEMarcas {
	
	//definir informação que vai ser compartilhada; será chamado pelo produtor de dados
		//public void set(int valor) throws InterruptedException;//lança a esceção interrupção
		
		//recupera informação que vai ser compartilhada; será chamado pelo consumidor de dados. 
		//public int get() throws InterruptedException;//lança a esceção interrupção

}
