package logica_horarios;

import atividades.AtividadesObrigatorias;
import atividades.AtividadesOpcionais;
import atividades.Entretenimentos;
import atividades.TempoEmAtividades;
import atividades.TempoEmEntretenimentos;

public class SistemaDeTempo {

	public int horasIncrementadas;
	public int minutosIncrementados;
	public int segundosIncrementados;
	public static int chaveParaOrganizar = 0;
	
	public void sistemaDeTempoIncrementado(int horasEmQuestao, int minutosEmQuestao, int segundosEmQuestao) {

		int horas = horasEmQuestao;
		int minutos = 0;
		int segundos = 0;

		int contador = 1;
		int multiplicador = 1;

		do {
			if (contador == (multiplicador * 60)) {
				horas += 1;
				multiplicador += 1;
				minutos = 0;

			} else if(minutosEmQuestao != 0 && contador != (multiplicador * 60)) {
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

			} else if(segundosEmQuestao != 0 && contador != (multiplicador * 60)) {
				segundos++;		
			}
			contador++;
		} while (contador <= segundosEmQuestao);

		this.horasIncrementadas = horas;
		this.minutosIncrementados = minutos;
		this.segundosIncrementados = segundos;

	}

	public void tempoDecrementadoEmAtividades(int horasEmQuestao, int minutosEmQuestao, int segundosEmQuestao,
			int index, Object obj) {
		int horas = horasEmQuestao;
		int minutos = 0;
		int segundos = 0;

		int contador = 0;
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

		contador = 0;
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

		boolean instanciaDeAtividadesObrigatorias = obj instanceof TempoEmAtividades;
		boolean instanciaDeEntretenimentos = obj instanceof TempoEmEntretenimentos;
		boolean instanciaDeAtividadesOpcionais = obj instanceof AtividadesOpcionais;
		
			// SE VOCÊ ESTIVER DECREMENTANDO ATIVIDADES OBRIGATÓRIAS
		if (instanciaDeAtividadesObrigatorias) {
			if (horas > 0) {
				decrementaHora = (AtividadesObrigatorias.horasMutaveis.get(index) - horas);
				if (decrementaHora < 0) {
					decrementaHora = 0;
				}
				AtividadesObrigatorias.horasMutaveis.remove(index);
				AtividadesObrigatorias.horasMutaveis.add(index, decrementaHora);
				horasEmQuestao = decrementaHora;
			}

			if (minutos > 0) {
				decrementaMinuto = (AtividadesObrigatorias.minutosMutaveis.get(index) - minutos);
				if (decrementaMinuto < 0) {
					decrementaMinuto = 0;
				}
				AtividadesObrigatorias.minutosMutaveis.remove(index);
				AtividadesObrigatorias.minutosMutaveis.add(index, decrementaMinuto);
				minutosEmQuestao = decrementaMinuto;
			}

			if (segundos > 0) {
				decrementaSegundo = (AtividadesObrigatorias.segundosMutaveis.get(index) - segundos);
				if (decrementaSegundo < 0) {
					decrementaSegundo = 0;
				}
				AtividadesObrigatorias.segundosMutaveis.remove(index);
				AtividadesObrigatorias.segundosMutaveis.add(index, decrementaSegundo);
				segundosEmQuestao = decrementaSegundo;
			}

			// SE VOCÊ ESTIVER DECREMENTANDO ENTRETENIMENTOS
		}else if(instanciaDeEntretenimentos) {
			if (horas > 0) {
				decrementaHora = (Entretenimentos.horas.get(index) - horas);
				if (decrementaHora < 0) {
					decrementaHora = 0;
				}
				Entretenimentos.horas.remove(index);
				Entretenimentos.horas.add(index, decrementaHora);
				horasEmQuestao = decrementaHora;
			}

			if (minutos > 0) {
				decrementaMinuto = (Entretenimentos.minutos.get(index) - minutos);
				if (decrementaMinuto < 0) {
					decrementaMinuto = 0;
				}
				Entretenimentos.minutos.remove(index);
				Entretenimentos.minutos.add(index, decrementaMinuto);
				minutosEmQuestao = decrementaMinuto;
			}

			if (segundos > 0) {
				decrementaSegundo = (Entretenimentos.segundos.get(index) - segundos);
				if (decrementaSegundo < 0) {
					decrementaSegundo = 0;
				}
				Entretenimentos.segundos.remove(index);
				Entretenimentos.segundos.add(index, decrementaSegundo);
				segundosEmQuestao = decrementaSegundo;
			}
			
			// SE VOCÊ ESTIVER DECREMENTANDO ATIVIDADES OPCIONAIS
		}else if(instanciaDeAtividadesOpcionais) {
			if (horas > 0) {
				decrementaHora = (AtividadesOpcionais.horas.get(index) - horas);
				if (decrementaHora < 0) {
					decrementaHora = 0;
				}
				AtividadesOpcionais.horas.remove(index);
				AtividadesOpcionais.horas.add(index, decrementaHora);
				horasEmQuestao = decrementaHora;
			}

			if (minutos > 0) {
				decrementaMinuto = (AtividadesOpcionais.minutos.get(index) - minutos);
				if (decrementaMinuto < 0) {
					decrementaMinuto = 0;
				}
				AtividadesOpcionais.minutos.remove(index);
				AtividadesOpcionais.minutos.add(index, decrementaMinuto);
				minutosEmQuestao = decrementaMinuto;
			}

			if (segundos > 0) {
				decrementaSegundo = (AtividadesOpcionais.segundos.get(index) - segundos);
				if (decrementaSegundo < 0) {
					decrementaSegundo = 0;
				}
				AtividadesOpcionais.segundos.remove(index);
				AtividadesOpcionais.segundos.add(index, decrementaSegundo);
				segundosEmQuestao = decrementaSegundo;
			}
		}
		
	}

}
