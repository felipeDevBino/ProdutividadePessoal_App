package logicadehorarios.complementar;

import atividades.AtividadesObrigatorias;
import atividades.AtividadesOpcionais;
import atividades.Entretenimentos;
import atividades.TempoEmAtividades;
import atividades.TempoEmEntretenimentos;
import instancias.InstanceManager;

public class VerificacoesEAplicacoes {

	private AtividadesObrigatorias atividadesObrigatorias = InstanceManager.getAtividadesObrigatorias();
	private Entretenimentos entretenimentos = InstanceManager.getEntretenimentos();
	private AtividadesOpcionais atividadesOpcionais = InstanceManager.getAtividadesOpcionais();

	protected void definirTemposParaDecrementar(int decrementaHora, int decrementaMinuto, int decrementaSegundo,
			int posicao, Object obj) {
		if (obj instanceof TempoEmAtividades) {
			decrementaHora = atividadesObrigatorias.horasMutaveis.get(posicao);
			decrementaMinuto = atividadesObrigatorias.minutosMutaveis.get(posicao);
			decrementaSegundo = atividadesObrigatorias.segundosMutaveis.get(posicao);
			
		} else if (obj instanceof TempoEmEntretenimentos) {
			decrementaHora = entretenimentos.horas.get(posicao);
			decrementaMinuto = entretenimentos.minutos.get(posicao);
			decrementaSegundo = entretenimentos.segundos.get(posicao);

		} else if (obj instanceof AtividadesOpcionais) {
			decrementaHora = atividadesOpcionais.horas[posicao];
			decrementaMinuto = atividadesOpcionais.minutos[posicao];
			decrementaSegundo = atividadesOpcionais.segundos[posicao];

		}

	}

	protected void aplicarHorasEMinutos(int decrementaHora, int decrementaMinuto, int posicao, Object obj) {
		if (obj instanceof TempoEmAtividades) {
			atividadesObrigatorias.horasMutaveis.remove(posicao);
			atividadesObrigatorias.horasMutaveis.add(posicao, decrementaHora);
			atividadesObrigatorias.minutosMutaveis.remove(posicao);
			atividadesObrigatorias.minutosMutaveis.add(posicao, decrementaMinuto);

		} else if (obj instanceof TempoEmEntretenimentos) {
			entretenimentos.horas.remove(posicao);
			entretenimentos.horas.add(posicao, decrementaHora);
			entretenimentos.minutos.remove(posicao);
			entretenimentos.minutos.add(posicao, decrementaMinuto);

		} else if (obj instanceof AtividadesOpcionais) {
			atividadesOpcionais.horas[posicao] = decrementaHora;
			atividadesOpcionais.minutos[posicao] = decrementaMinuto;

		}
	}

	protected void aplicarMinutosESegundos(int decrementaMinuto, int decrementaSegundo, int posicao, Object obj) {
		if (obj instanceof TempoEmAtividades) {
			atividadesObrigatorias.minutosMutaveis.remove(posicao);
			atividadesObrigatorias.minutosMutaveis.add(posicao, decrementaMinuto);
			atividadesObrigatorias.segundosMutaveis.remove(posicao);
			atividadesObrigatorias.segundosMutaveis.add(posicao, decrementaSegundo);

		} else if (obj instanceof TempoEmEntretenimentos) {
			entretenimentos.minutos.remove(posicao);
			entretenimentos.minutos.add(posicao, decrementaMinuto);
			entretenimentos.segundos.remove(posicao);
			entretenimentos.segundos.add(posicao, decrementaSegundo);

		} else if (obj instanceof AtividadesOpcionais) {
			atividadesOpcionais.minutos[posicao] = decrementaMinuto;
			atividadesOpcionais.segundos[posicao] = decrementaSegundo;

		}

	}
}
