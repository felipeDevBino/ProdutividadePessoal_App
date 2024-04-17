package logica_horarios;

import atividades.AtividadesObrigatorias;

public class SistemaDeTempo {

	public int horasIncrementadas;
	public int minutosIncrementados;
	public int segundosIncrementados;
	public static int chaveParaOrganizar = 0;
	
	public void sistemaDeTempoIncrementado(int horasEmQuestao, int minutosEmQuestao, int segundosEmQuestao) {

		int horas = 0;
		int minutos = 0;
		int segundos = 0;

		int contador = 1;
		int multiplicador = 1;

		do {
			if (contador == (multiplicador * 60)) {
				horas += 1;
				multiplicador += 1;
				minutos = 0;

			} else {
				minutos++;
			}
			contador++;
		} while (contador <= minutosEmQuestao);

		contador = 1;
		multiplicador = 1;
		do {
			if (contador == (multiplicador * 60)) {
				minutos += 1;
				multiplicador += 1;
				segundos = 0;

			} else {
				segundos++;
			}
			contador++;
		} while (contador <= segundosEmQuestao);

		this.horasIncrementadas = horas;
		this.minutosIncrementados = minutos;
		this.segundosIncrementados = segundos;

	}

	public void tempoDecrementadoEmAtividades(int horasEmQuestao, int minutosEmQuestao, int segundosEmQuestao,
			int index) {
		int horas = horasEmQuestao;
		int minutos = minutosEmQuestao;
		int segundos = segundosEmQuestao;

		int contador = 1;
		int multiplicador = 1;

		if (minutosEmQuestao > 0) {
			do {
				if (contador == (multiplicador * 60)) {
					horas += 1;
					multiplicador += 1;
					minutos = 0;

				} else {
					minutos++;
				}
				contador++;
			} while (contador < minutosEmQuestao);
		}

		contador = 1;
		multiplicador = 1;

		if (segundosEmQuestao > 0) {
			do {
				if (contador == (multiplicador * 60)) {
					minutos += 1;
					multiplicador += 1;
					segundos = 0;

				} else {
					segundos++;
				}
				contador++;
			} while (contador < segundosEmQuestao);
		}

		int decrementaHora, decrementaMinuto, decrementaSegundo;

		if (horas > 0) {
			decrementaHora = (AtividadesObrigatorias.horasMutaveis.get(index) - horas);
			if(decrementaHora < 0) {
				decrementaHora = 0;
			}
			AtividadesObrigatorias.horasMutaveis.remove(index);
			AtividadesObrigatorias.horasMutaveis.add(index, decrementaHora);
			horasEmQuestao = decrementaHora;
		}

		if (minutos > 0) {
			decrementaMinuto = (AtividadesObrigatorias.minutosMutaveis.get(index) - minutos);
			if(decrementaMinuto < 0) {
				decrementaMinuto = 0;
			}
			AtividadesObrigatorias.minutosMutaveis.remove(index);
			AtividadesObrigatorias.minutosMutaveis.add(index, decrementaMinuto);
			minutosEmQuestao = decrementaMinuto;
		}

		if (segundos > 0) {
			decrementaSegundo = (AtividadesObrigatorias.segundosMutaveis.get(index) - segundos);
			if(decrementaSegundo < 0) {
				decrementaSegundo = 0;
			}
			AtividadesObrigatorias.segundosMutaveis.remove(index);
			AtividadesObrigatorias.segundosMutaveis.add(index, decrementaSegundo);
			segundosEmQuestao = decrementaSegundo;
		}

	}

}
