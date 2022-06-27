package testeUnitarioComJUnit;

public class Matematica {
	// return razi quadradao(equação de pell)
	int raiz(int numero) {

		int raiz = 0, impar = 1;

		while (numero >= impar) {
			numero -= impar;
			impar += 2;

			++raiz;
		}
		return raiz;

	}

	int maior(int um, int dois) {
		if (um > dois) {
			return um;

		} else {
			return dois;
		}

	}

	// metodo que soma dois valores:
	double soma(double um, double dois) {

		double s = um + dois;
		return s;

	}
}
