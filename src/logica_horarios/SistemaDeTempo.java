package logica_horarios;

import atividades.AtividadesObrigatorias;
import atividades.AtividadesOpcionais;
import atividades.Entretenimentos;
import atividades.TempoEmAtividades;
import atividades.TempoEmEntretenimentos;

public class SistemaDeTempo {

	public int horasOrganizadas;
	public int minutosOrganizados;
	public int segundosOrganizados;
	protected static int chaveParaOrganizar = 0;

	public void sistemaDeTempoOrganizado(int horasEmQuestao, int minutosEmQuestao, int segundosEmQuestao) {

		int horas = horasEmQuestao;
		int minutos = 0;
		int segundos = 0;

		int contador = 1;
		int multiplicador = 1;

		do {
			boolean instrucao = (contador == (multiplicador * 60)) ? true : false;
			if (instrucao) {
				horas += 1;
				multiplicador += 1;
				minutos = 0;

			} else if (minutosEmQuestao != 0 && !instrucao) {
				minutos++;
			}
			contador++;
		} while (contador <= minutosEmQuestao);

		contador = 1;
		multiplicador = 1;
		do {
			boolean instrucao = (contador == (multiplicador * 60)) ? true : false;
			if (instrucao) {
				minutos += 1;
				multiplicador += 1;
				segundos = 0;

			} else if (segundosEmQuestao > 0 && segundosEmQuestao < (multiplicador * 60)) {
				segundos++;
				contador++;
				continue;

			} else if (!instrucao) {
				if (segundosEmQuestao > 0) {
					segundos++;
				}
			}
			contador++;
		} while (contador <= segundosEmQuestao);

		this.horasOrganizadas = horas;
		this.minutosOrganizados = minutos;
		this.segundosOrganizados = segundos;
	}

	public void tempoDecrementadoEmAtividades(int horasEmQuestao, int minutosEmQuestao, int segundosEmQuestao,
			int index, Object obj) {
		int horas = horasEmQuestao;
		int minutos = 0;
		int segundos = 0;

		int contador = 1;
		int multiplicador = 1;

		if (minutosEmQuestao > 0 || minutos > 0) {
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
		}

		contador = 1;
		multiplicador = 1;

		if (segundosEmQuestao > 0 || segundos > 0) {
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
		}

		int decrementaHora, decrementaMinuto, decrementaSegundo;

		boolean instanciaDeAtividadesObrigatorias = obj instanceof TempoEmAtividades;
		boolean instanciaDeEntretenimentos = obj instanceof TempoEmEntretenimentos;
		boolean instanciaDeAtividadesOpcionais = obj instanceof AtividadesOpcionais;

		Complemento decrementadosAdicionais = new Complemento();

		// SE VOCÊ ESTIVER DECREMENTANDO ATIVIDADES OBRIGATÓRIAS
		if (instanciaDeAtividadesObrigatorias) {
			decrementadosAdicionais.horariosAdicionaisDecrementados(horas, minutosEmQuestao, segundosEmQuestao, index,
					obj);

			if (!decrementadosAdicionais.confirmacaoDeDecrementoDeHoras()
					&& AtividadesObrigatorias.horasMutaveis.get(index) > 0) {
				if (horas > 0) {
					decrementaHora = (AtividadesObrigatorias.horasMutaveis.get(index) - horas);
					if (decrementaHora < 0) {
						decrementaHora = 0;
					}
					AtividadesObrigatorias.horasMutaveis.remove(index);
					AtividadesObrigatorias.horasMutaveis.add(index, decrementaHora);
				}
			}
			if (!decrementadosAdicionais.confirmacaoDeDecrementoDeMinutos()
					&& AtividadesObrigatorias.minutosMutaveis.get(index) > 0) {
				if (minutos > 0) {
					decrementaMinuto = (AtividadesObrigatorias.minutosMutaveis.get(index) - minutos);
					if (decrementaMinuto < 0) {
						decrementaMinuto = 0;
					}
					AtividadesObrigatorias.minutosMutaveis.remove(index);
					AtividadesObrigatorias.minutosMutaveis.add(index, decrementaMinuto);
				}

			}
			if (!decrementadosAdicionais.confirmacaoDeDecrementoDeSegundos()
					&& AtividadesObrigatorias.segundosMutaveis.get(index) > 0) {
				decrementaSegundo = (AtividadesObrigatorias.segundosMutaveis.get(index) - segundos);
				if (decrementaSegundo < 0) {
					decrementaSegundo = 0;
				}
				AtividadesObrigatorias.segundosMutaveis.remove(index);
				AtividadesObrigatorias.segundosMutaveis.add(index, decrementaSegundo);
			}

			// SE VOCÊ ESTIVER DECREMENTANDO ENTRETENIMENTOS
		} else if (instanciaDeEntretenimentos) {
			decrementadosAdicionais.horariosAdicionaisDecrementados(horas, minutosEmQuestao, segundosEmQuestao, index,
					obj);

			if (horas > 0) {
				decrementaHora = (Entretenimentos.horas.get(index) - horas);
				if (decrementaHora < 0) {
					decrementaHora = 0;
				}
				Entretenimentos.horas.remove(index);
				Entretenimentos.horas.add(index, decrementaHora);
			}

			if (minutos > 0) {
				decrementaMinuto = (Entretenimentos.minutos.get(index) - minutos);
				if (decrementaMinuto < 0) {
					decrementaMinuto = 0;
				}
				Entretenimentos.minutos.remove(index);
				Entretenimentos.minutos.add(index, decrementaMinuto);
			}

			if (segundos > 0) {
				decrementaSegundo = (Entretenimentos.segundos.get(index) - segundos);
				if (decrementaSegundo < 0) {
					decrementaSegundo = 0;
				}
				Entretenimentos.segundos.remove(index);
				Entretenimentos.segundos.add(index, decrementaSegundo);
			}

			// SE VOCÊ ESTIVER DECREMENTANDO ATIVIDADES OPCIONAIS
		} else if (instanciaDeAtividadesOpcionais) {
			decrementadosAdicionais.horariosAdicionaisDecrementados(horas, minutosEmQuestao, segundosEmQuestao, index,
					obj);

			if (horas > 0) {
				decrementaHora = (AtividadesOpcionais.horas[index] - horas);
				if (decrementaHora < 0) {
					decrementaHora = 0;
				}
				AtividadesOpcionais.horas[index] = decrementaHora;
			}

			if (minutos > 0) {
				decrementaMinuto = (AtividadesOpcionais.minutos[index] - minutos);
				if (decrementaMinuto < 0) {
					decrementaMinuto = 0;
				}
				AtividadesOpcionais.minutos[index] = decrementaMinuto;
			}

			if (segundos > 0) {
				decrementaSegundo = (AtividadesOpcionais.segundos[index] - segundos);
				if (decrementaSegundo < 0) {
					decrementaSegundo = 0;
				}
				AtividadesOpcionais.segundos[index] = decrementaSegundo;
			}

		}

	}

}
