package annotations;

import java.io.Serializable;

//cabe�alho padr�o t�pico de empresas:

/*
 * Institui��o:		universidade XTI
 * Projeto: 		Sistema de avalia��es
 * Data de Cria��o: 24/06/2022
 * Criador: 			Juvencio Linhares
 * Revis��o:		2(n�mero de revisoes ja feitas)
 */

/*
 *esse modelo tradicional gera um serie de dificuldades 
 *pra ferramentas de processamento autom�tico.
 *a melhor forma de documentar dados que ser�o processados automaticamente
 *� usando anota��es.
 *as anota��es aprentam a informa��o de uma forma padronizada e estruturada
 *que � mais acessivel ao processamento de dados por ferramentas. 
 *
 *representar esse cabelho atrav�s de uma anota��o
 * 
 *utilizando a classe cabe�alho(que sao minha anota��es corretas) dentro dessa classe anotacao:
 *1- @
 *2-nome da anota��o, no caso Cabecalho
 *3-parenteses
 *4- dentro dos parenteses informo os valores
 *
 *posso criar ainda v�rios tipos de anota��o para situa��es espec�ficas
 *por exemplo: posso criar uma anota��o que me apresente os erros que ja foram corrigidos.
 *
 *restringir a aplica��o de uma anota��o em alguns tipos de elementos espec�ficos:
 *
 */

@Cabecalho(
	instituicao = "universidade XTI",
	projeto = "Sistema de avalia��es",
	dataCriacao = "24/06/2022",
	criador = "Juvencio Linhares",
	revisao = 2
		)

//inicializar erros corrigidos. esse tipo de anota��o posso usar para classes e m�todos e outros tipos(se eu definir isso em Target)
@ErrosCorrigidos(erros = {"0001","0002"})//inicializar o array de strings erros
//outra forma:
//@ErrosCorrigidos("0001")//quando uso o array value.

@SuppressWarnings("serial")//suprimir um erro ou v�rios outrs, nesse caso suprimir o erro serial de serializable,
public class Anotacao implements Serializable {
	
	@SuppressWarnings("unused")//posso colocar tanto aqui como na classe. 
	private int x;//variavel n�o utilizada em nenhum lugar da minha classe
	
	//anota��es espec�ficas do java :
	
	@SuppressWarnings("unused")
	@Deprecated //indica que esse m�todo vai ser depreciado nas proximas vers�es do programa 
	private void anotar() {
		
	}
	
	@Override //indica que eu sobrescrevi um dos metodos da classe pai 
	public String toString() {
		return null;
	}

}
