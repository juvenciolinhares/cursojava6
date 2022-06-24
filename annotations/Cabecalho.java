package annotations;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

//representa a estrutra de cabe�alho

//n�o posso utilizar tipos que n�o sejam primitivos de dados


//o @ indica a cria��o de uma anota��o 

@Target({ElementType.TYPE, ElementType.METHOD})//posso aplicar agora erroCorrigidos tanto para classes como para m�todos

//posso indicar que a minha anota��o precisa ser documentada pelo JavaDoc:
@Documented //idico que essa annotation deve aparecer na documenta��o. 
public @interface Cabecalho {
	
	//criar atributos do cabe�ao da classe anota��o:
	String instituicao();//define o tipo, abre e fecha parenteses
	String projeto();
	String dataCriacao();//nao poderia usar o objeto Date por que n�o � um tipo primitivo.
	String criador();
	int revisao();//em geral a revisao sempre come�a com o numero 1, entao poderia definir um valor default.
	

}
