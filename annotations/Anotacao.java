package annotations;

import java.io.Serializable;

//cabeçalho padrão típico de empresas:

/*
 * Instituição:		universidade XTI
 * Projeto: 		Sistema de avaliações
 * Data de Criação: 24/06/2022
 * Criador: 			Juvencio Linhares
 * Revisção:		2(número de revisoes ja feitas)
 */

/*
 *esse modelo tradicional gera um serie de dificuldades 
 *pra ferramentas de processamento automático.
 *a melhor forma de documentar dados que serão processados automaticamente
 *é usando anotações.
 *as anotações aprentam a informação de uma forma padronizada e estruturada
 *que é mais acessivel ao processamento de dados por ferramentas. 
 *
 *representar esse cabelho através de uma anotação
 * 
 *utilizando a classe cabeçalho(que sao minha anotações corretas) dentro dessa classe anotacao:
 *1- @
 *2-nome da anotação, no caso Cabecalho
 *3-parenteses
 *4- dentro dos parenteses informo os valores
 *
 *posso criar ainda vários tipos de anotação para situações específicas
 *por exemplo: posso criar uma anotação que me apresente os erros que ja foram corrigidos.
 *
 *restringir a aplicação de uma anotação em alguns tipos de elementos específicos:
 *
 */

@Cabecalho(
	instituicao = "universidade XTI",
	projeto = "Sistema de avaliações",
	dataCriacao = "24/06/2022",
	criador = "Juvencio Linhares",
	revisao = 2
		)

//inicializar erros corrigidos. esse tipo de anotação posso usar para classes e métodos e outros tipos(se eu definir isso em Target)
@ErrosCorrigidos(erros = {"0001","0002"})//inicializar o array de strings erros
//outra forma:
//@ErrosCorrigidos("0001")//quando uso o array value.

@SuppressWarnings("serial")//suprimir um erro ou vários outrs, nesse caso suprimir o erro serial de serializable,
public class Anotacao implements Serializable {
	
	@SuppressWarnings("unused")//posso colocar tanto aqui como na classe. 
	private int x;//variavel não utilizada em nenhum lugar da minha classe
	
	//anotações específicas do java :
	
	@SuppressWarnings("unused")
	@Deprecated //indica que esse método vai ser depreciado nas proximas versões do programa 
	private void anotar() {
		
	}
	
	@Override //indica que eu sobrescrevi um dos metodos da classe pai 
	public String toString() {
		return null;
	}

}
