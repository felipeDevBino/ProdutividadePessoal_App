package logicadehorarios.complementar;

public class ComplementoDeTempo {

	private int decrementaHora;
	private int decrementaMinuto;
	private int decrementaSegundo;

	private boolean decrementouHora;
	private boolean decrementouMinuto;
	private boolean decrementouSegundo;

	public void horariosAdicionaisDecrementados(int horas, int minutos, int segundos, int posicao, Object obj) {

		decrementaHora = 0;
		decrementaMinuto = 0;
		decrementaSegundo = 0;

		VerificacoesEAplicacoes verificarEAplicar = new VerificacoesEAplicacoes();
		verificarEAplicar.definirTemposParaDecrementar(decrementaHora, decrementaMinuto, decrementaSegundo, posicao,
				obj);

		boolean condicaoParaMinutos = false;
		boolean condicaoParaSegundos = false;
		int contadorDeResto = 0;

		if (condicaoParaMinutos && decrementaHora > 0) {
			decrementarHorasEResto(contadorDeResto, minutos);
			verificarEAplicar.aplicarHorasEMinutos(decrementaHora, decrementaMinuto, posicao, obj);
		}

		contadorDeResto = 0;
		if (condicaoParaSegundos && decrementaMinuto > 0 && decrementaSegundo > 0) {
			decrementarMinutosEResto(contadorDeResto, horas, segundos);
			verificarEAplicar.aplicarMinutosESegundos(decrementaMinuto, decrementaSegundo, posicao, obj);
		}
	}

	private void decrementarHorasEResto(int contadorDeResto, int minutos) {
		do {
			if (decrementaMinuto == 0) {
				decrementaHora--;
				decrementouHora = true;
				decrementaMinuto = 60;
			}
			decrementaMinuto--;
			contadorDeResto++;
		} while (contadorDeResto < minutos);
		
		decrementouMinuto = true;

		if (decrementaHora < 0) {
			decrementaHora = 0;
			
		} else if (decrementaMinuto == 60) {
			decrementaHora++;
			decrementaMinuto = 0;
		}
	}

	private void decrementarMinutosEResto(int contadorDeResto, int horas, int segundos) {
		do {
			if (decrementaSegundo == 0) {
				decrementaMinuto--;
				decrementouMinuto = true;
				decrementaSegundo = 60;
			}
			decrementaSegundo--;
			contadorDeResto++;
		} while (contadorDeResto < segundos);
		
		decrementouSegundo = true;

		if (decrementaMinuto < 0) {
			decrementaMinuto = 0;
		} else if (decrementaMinuto == 60) {
			decrementaMinuto = 0;
			horas++;
		}
		
		if (decrementaSegundo < 0) {
			decrementaSegundo = 0;
			
		} else if (decrementaSegundo == 60) {
			decrementaSegundo = 0;
			decrementaMinuto++;
		}
	}

	public boolean seDecrementoHoras() {
		return decrementouHora;
	}

	public boolean seDecrementoMinutos() {
		return decrementouMinuto;
	}

	public boolean seDecrementoSegundos() {
		return decrementouSegundo;
	}
}
