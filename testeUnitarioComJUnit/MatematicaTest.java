package testeUnitarioComJUnit;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

//5-importação estática da classe
import static junit.framework.Assert.*;

class MatematicaTest {

	// 1-
	Matematica m;

	@BeforeEach // setup configura algo antes executar os casos de teste
	void setUp() throws Exception {
		// 2- inicializar a classe matematica:
		m = new Matematica();
	}

	// 3- executar os testes dentro dos metodos criados:

	@Test
	void testRaiz() {
		//4-fazer uma importação estática da classe de teste pra utilizar a classe várias vezes sem precisar chamar o nome da classe
	 assertEquals(4.0, m.raiz(16));//espera um valor esperar e um valor recebido;
	}

	@Test
	void testMaior() {
		assertEquals(20.0, m.maior(10, 20));
	}

	@Test
	void testSoma() {
		//testando um erro:
		assertEquals(8, m.soma(4, 2));
	}

}
