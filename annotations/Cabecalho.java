package annotations;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

//representa a estrutra de cabeçalho

//não posso utilizar tipos que não sejam primitivos de dados


//o @ indica a criação de uma anotação 

@Target({ElementType.TYPE, ElementType.METHOD})//posso aplicar agora erroCorrigidos tanto para classes como para métodos

//posso indicar que a minha anotação precisa ser documentada pelo JavaDoc:
@Documented //idico que essa annotation deve aparecer na documentação. 
public @interface Cabecalho {
	
	//criar atributos do cabeçao da classe anotação:
	String instituicao();//define o tipo, abre e fecha parenteses
	String projeto();
	String dataCriacao();//nao poderia usar o objeto Date por que não é um tipo primitivo.
	String criador();
	int revisao();//em geral a revisao sempre começa com o numero 1, entao poderia definir um valor default.
	

}
