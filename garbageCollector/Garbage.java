package garbageCollector;

import java.util.ArrayList;
import java.util.List;

public class Garbage {
	
	/*m�todo para sobrecarregar a memoria:*/
	
	//1-saber a quantidade de mem�ria livre:
	public static long carregarMemoria() {
		
		//2- enceher mem�ria:
		List<Integer> list = new ArrayList<>();
		for(int i = 0; i < 100_000; i ++) {
			list.add(i);
		}
		
		//-3 quantidade livre de mem�ria:
		return Runtime.getRuntime().freeMemory();
	}
	

	public static void main(String[] args) {
		
		//metodos podem ser recuperados pela classe Runtime:
		Runtime rt = Runtime.getRuntime();
		
		
		//metodo max memory: retorna a quantidade total de mem�ria dispon�vel(formato de bytes)
		//se eu quiser saber a quantidade em bytes, bas divide a quantidade por MB
		int MB = 1_048_576;//total de bytes em 1MB
		double total = rt.maxMemory()/MB;
		System.out.println(total);//total de MB
		
		
		//-4 quanto de mem�ria foi utilizada no momento em que executei o metodo carregarMemoria(encher a mem�ria)
		double inicio = total - (carregarMemoria()/MB);
		System.out.println(total);
		System.out.println(inicio);
		
		//finalizar todos os objetos carregados na mem�ria 
		rt.runFinalization();
		
		//"for�a" a execu��o do garbage collecotor:
		rt.gc();
		
		//calcuilar o total de mem�ria utilizado depois da limpeza:
		double fim = total -(rt.freeMemory()/MB);
		System.out.println("inicio(mem�ria cheia): "+ inicio + ", final(mem�ria limpa): "+ fim);
		

	}

}
/*
 * Garbage Collector:
 * a coleta de lixo � dividida em duas partes:
 * 1-separa objetos vivos de objetos mortos
 * objetos vivos: alcan�aveis por um c�digo em execu��o
 * objetos mortos: lixos a serem coletados pelo garbage collector
 * 
 * 
 */
