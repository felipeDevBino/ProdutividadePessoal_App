package logicadetempo;

import instancias.InstanceManager;
import logicadehorarios.complementar.ComplementoDeTempo;
import atividades.AtividadesObrigatorias;
import atividades.AtividadesOpcionais;
import atividades.Entretenimentos;

public class AtribuirTempos {

	private AtividadesObrigatorias atividadesObrigatorias = InstanceManager.getAtividadesObrigatorias();
	private AtividadesOpcionais atividadesOpcionais = InstanceManager.getAtividadesOpcionais();
	private Entretenimentos entretenimentos = InstanceManager.getEntretenimentos();

	int decrementaHora;
	int decrementaMinuto;
	int decrementaSegundo;

	protected void atribuirParaAtividadesObrigatorias(ComplementoDeTempo decrementadosAdicionais, Object obj, int horas,
			int minutos, int segundos, int minutosEmQuestao, int segundosEmQuestao, int posicao) {
		decrementadosAdicionais.horariosAdicionaisDecrementados(horas, minutosEmQuestao, segundosEmQuestao, posicao,
				obj);

		if (!decrementadosAdicionais.seDecrementoHoras()
				&& atividadesObrigatorias.horasMutaveis.get(posicao) > 0) {
			if (horas > 0) {
				decrementaHora = (atividadesObrigatorias.horasMutaveis.get(posicao) - horas);
				if (decrementaHora < 0) {
					decrementaHora = 0;
				}
				atividadesObrigatorias.horasMutaveis.remove(posicao);
				atividadesObrigatorias.horasMutaveis.add(posicao, decrementaHora);
			}
		}
		if (!decrementadosAdicionais.seDecrementoMinutos()
				&& atividadesObrigatorias.minutosMutaveis.get(posicao) > 0) {
			if (minutos > 0) {
				decrementaMinuto = (atividadesObrigatorias.minutosMutaveis.get(posicao) - minutos);
				if (decrementaMinuto < 0) {
					decrementaMinuto = 0;
				}
				atividadesObrigatorias.minutosMutaveis.remove(posicao);
				atividadesObrigatorias.minutosMutaveis.add(posicao, decrementaMinuto);
			}

		}
		if (!decrementadosAdicionais.seDecrementoSegundos()
				&& atividadesObrigatorias.segundosMutaveis.get(posicao) > 0) {
			decrementaSegundo = (atividadesObrigatorias.segundosMutaveis.get(posicao) - segundos);
			if (decrementaSegundo < 0) {
				decrementaSegundo = 0;
			}
			atividadesObrigatorias.segundosMutaveis.remove(posicao);
			atividadesObrigatorias.segundosMutaveis.add(posicao, decrementaSegundo);
		}

	}

	protected void atribuirParaAtividadesOpcionais(ComplementoDeTempo decrementadosAdicionais, Object obj, int horas,
			int minutos, int segundos, int minutosEmQuestao, int segundosEmQuestao, int posicao) {
		decrementadosAdicionais.horariosAdicionaisDecrementados(horas, minutosEmQuestao, segundosEmQuestao, posicao,
				obj);

		if (horas > 0) {
			decrementaHora = (atividadesOpcionais.horas[posicao] - horas);
			if (decrementaHora < 0) {
				decrementaHora = 0;
			}
			atividadesOpcionais.horas[posicao] = decrementaHora;
		}

		if (minutos > 0) {
			decrementaMinuto = (atividadesOpcionais.minutos[posicao] - minutos);
			if (decrementaMinuto < 0) {
				decrementaMinuto = 0;
			}
			atividadesOpcionais.minutos[posicao] = decrementaMinuto;
		}
		if (segundos > 0) {
			decrementaSegundo = (atividadesOpcionais.segundos[posicao] - segundos);
			if (decrementaSegundo < 0) {
				decrementaSegundo = 0;
			}
			atividadesOpcionais.segundos[posicao] = decrementaSegundo;
		}

	}

	protected void atribuirParaEntretenimentos(ComplementoDeTempo decrementadosAdicionais, Object obj, int horas,
			int minutos, int segundos, int minutosEmQuestao, int segundosEmQuestao, int posicao) {
		decrementadosAdicionais.horariosAdicionaisDecrementados(horas, minutosEmQuestao, segundosEmQuestao, posicao,
				obj);

		if (horas > 0) {
			decrementaHora = (entretenimentos.horas.get(posicao) - horas);
			if (decrementaHora < 0) {
				decrementaHora = 0;
			}
			entretenimentos.horas.remove(posicao);
			entretenimentos.horas.add(posicao, decrementaHora);
		}

		if (minutos > 0) {
			decrementaMinuto = (entretenimentos.minutos.get(posicao) - minutos);
			if (decrementaMinuto < 0) {
				decrementaMinuto = 0;
			}
			entretenimentos.minutos.remove(posicao);
			entretenimentos.minutos.add(posicao, decrementaMinuto);
		}

		if (segundos > 0) {
			decrementaSegundo = (entretenimentos.segundos.get(posicao) - segundos);
			if (decrementaSegundo < 0) {
				decrementaSegundo = 0;
			}
			entretenimentos.segundos.remove(posicao);
			entretenimentos.segundos.add(posicao, decrementaSegundo);
		}

	}

}
