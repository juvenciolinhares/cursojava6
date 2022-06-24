package garbageCollector;

import java.util.ArrayList;
import java.util.List;

public class Garbage {
	
	/*método para sobrecarregar a memoria:*/
	
	//1-saber a quantidade de memória livre:
	public static long carregarMemoria() {
		
		//2- enceher memória:
		List<Integer> list = new ArrayList<>();
		for(int i = 0; i < 100_000; i ++) {
			list.add(i);
		}
		
		//-3 quantidade livre de memória:
		return Runtime.getRuntime().freeMemory();
	}
	

	public static void main(String[] args) {
		
		//metodos podem ser recuperados pela classe Runtime:
		Runtime rt = Runtime.getRuntime();
		
		
		//metodo max memory: retorna a quantidade total de memória disponível(formato de bytes)
		//se eu quiser saber a quantidade em bytes, bas divide a quantidade por MB
		int MB = 1_048_576;//total de bytes em 1MB
		double total = rt.maxMemory()/MB;
		System.out.println(total);//total de MB
		
		
		//-4 quanto de memória foi utilizada no momento em que executei o metodo carregarMemoria(encher a memória)
		double inicio = total - (carregarMemoria()/MB);
		System.out.println(total);
		System.out.println(inicio);
		
		//finalizar todos os objetos carregados na memória 
		rt.runFinalization();
		
		//"força" a execução do garbage collecotor:
		rt.gc();
		
		//calcuilar o total de memória utilizado depois da limpeza:
		double fim = total -(rt.freeMemory()/MB);
		System.out.println("inicio(memória cheia): "+ inicio + ", final(memória limpa): "+ fim);
		

	}

}
/*
 * Garbage Collector:
 * a coleta de lixo é dividida em duas partes:
 * 1-separa objetos vivos de objetos mortos
 * objetos vivos: alcançaveis por um código em execução
 * objetos mortos: lixos a serem coletados pelo garbage collector
 * 
 * 
 */
