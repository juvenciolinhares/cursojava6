package reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Reflexao {

	@SuppressWarnings({ "rawtypes", "deprecation", "unchecked" })
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
		
		//recuperar o tipo de uma classe:
		String nome = "documentacaoJavadocEMarcas.Conta";//nome completo da classe contaBanco.Conta.
		
		//construir uma classe a partir desse nome: 
		Class classe = Class.forName(nome);//vai lançar o erro classNotFoundException que acontece quando não conseguir encontrar a classe.
		
		//realizar operações:
		
		//nome da classe:
		System.out.println(classe.getSimpleName());
		
		//campos da minha classe:
		Field [] f = classe.getFields();//retorna um array com os campos públicos
		for (Field field : f) {
			System.out.println(field);
		
		}
		
		//metodos da classe
		Method[] m = classe.getDeclaredMethods();//retorna a relação de metodos com qualquer tipo de modificador de acesso:
		for (Method method : m) {
			System.out.println(method.getName());//fetornando só o nome quando uso .getname()
		
		}
		
		Constructor[] c = classe.getConstructors();//retorna os construtores da classe
		for (Constructor constructor : c) {
			System.out.println(constructor);
		}
		
		//construir objetos utilizando reflexão:
		//classe.newInstance(); está obsoleto, derpreciado 
		Object o = classe.newInstance();
		Method md = classe.getMethod("deposita", double.class);
		Method me = classe.getMethod("exibirSaldo");
		
		//invocar metodo nesse objeto:
		md.invoke(o, 120);//set deposito
		me.invoke(o);//imprimir o saldo, por que null? esse objeto não foi inicializado com o nome do cliente.
		
		//executar o construtor que inicializa o cliente e o saldo:
		Constructor co = classe.getConstructor(String.class, double.class);
		Object obj = co.newInstance("Ricardo", 123_456.789);//passei dois argumentos como parâmetro
		
		//invocar o método exibir saldo nesse objeto
		me.invoke(obj);
		
	}

}
/*
 * reflexão é utilizada em vários frameworks do mercado: persistencia, camadas, integração.
 * recurso muito utilizado
 */
