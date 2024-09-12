package logicadetempo;

import atividades.AtividadesOpcionais;
import atividades.TempoEmAtividades;
import atividades.TempoEmEntretenimentos;
import logicadehorarios.complementar.ComplementoDeTempo;

public class SistemaDeTempo {

	private int horas;
	private int minutos;
	private int segundos;
	
	private int horasOrganizadas;
	private int minutosOrganizados;
	private int segundosOrganizados;

	public int getHorasOrganizadas() {
		return horasOrganizadas;
	}

	public int getMinutosOrganizados() {
		return minutosOrganizados;
	}

	public int getSegundosOrganizados() {
		return segundosOrganizados;
	}

	public void sistemaDeTempoOrganizado(int horasEmQuestao, int minutosEmQuestao, int segundosEmQuestao) {

		horas = horasEmQuestao;
		minutos = 0;
		segundos = 0;

		int contador = 1;
		int multiplicador = 1;

		verificarMinutosParaHoras(contador, multiplicador, minutosEmQuestao);
		verificarSegundosParaMinutos(contador, multiplicador, segundosEmQuestao);

		this.horasOrganizadas = horas;
		this.minutosOrganizados = minutos;
		this.segundosOrganizados = segundos;

	}

	private void verificarMinutosParaHoras(int contador, int multiplicador, int minutosEmQuestao) {
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
	}

	private void verificarSegundosParaMinutos(int contador, int multiplicador, int segundosEmQuestao) {
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
	}

	public void tempoDecrementadoEmAtividades(int horasEmQuestao, int minutosEmQuestao, int segundosEmQuestao,
			int posicao, Object obj) {

		horas = horasEmQuestao;
		minutos = 0;
		segundos = 0;

		int contador = 1;
		int multiplicador = 1;

		if (minutosEmQuestao > 0 || minutos > 0) {
			verificarMinutosParaHoras(contador, multiplicador, minutosEmQuestao);
		}

		if (segundosEmQuestao > 0 || segundos > 0) {
			verificarSegundosParaMinutos(contador, multiplicador, segundosEmQuestao);
		}

		boolean instanciaDeAtividadesObrigatorias = obj instanceof TempoEmAtividades;
		boolean instanciaDeEntretenimentos = obj instanceof TempoEmEntretenimentos;
		boolean instanciaDeAtividadesOpcionais = obj instanceof AtividadesOpcionais;

		ComplementoDeTempo decrementadosAdicionais = new ComplementoDeTempo();
		AtribuirTempos atribuir = new AtribuirTempos();

		if (instanciaDeAtividadesObrigatorias) {
			atribuir.atribuirParaAtividadesObrigatorias(decrementadosAdicionais, obj, horas, minutos, segundos,
					minutosEmQuestao, segundosEmQuestao, posicao);

		} else if (instanciaDeEntretenimentos) {
			atribuir.atribuirParaEntretenimentos(decrementadosAdicionais, obj, horas, minutos, segundos,
					minutosEmQuestao, segundosEmQuestao, posicao);

		} else if (instanciaDeAtividadesOpcionais) {
			atribuir.atribuirParaAtividadesOpcionais(decrementadosAdicionais, obj, horas, minutos, segundos,
					minutosEmQuestao, segundosEmQuestao, posicao);

		}

	}

}
