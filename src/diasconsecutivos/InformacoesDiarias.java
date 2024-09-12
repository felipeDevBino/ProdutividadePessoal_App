package diasconsecutivos;

import atividades.AtividadesObrigatorias;
import atividades.Entretenimentos;
import atividades.TempoEmAtividades;
import gui.InterfaceGrafica;

public class InformacoesDiarias {

	private StringBuilder informacoes;

	public String retornaInformacoes(AtividadesObrigatorias atividadesObrigatorias, Entretenimentos entretenimentos,
			TempoEmAtividades tempoEmAtividades, InterfaceGrafica gui) {
		int contador = 0;
		for (String atividade : atividadesObrigatorias.atividadesObrigatorias.keySet()) {
			informacoes.append("\n" + (contador + 1) + " Atividade: " + ": " + atividade + "\n\n")
					.append("Horas: " + atividadesObrigatorias.horasMutaveis.get(contador) + " Minutos: "
							+ atividadesObrigatorias.minutosMutaveis.get(contador) + " Segundos: "
							+ atividadesObrigatorias.segundosMutaveis.get(contador) + "\n");
			contador++;

		}

		informacoes.append("Atividades opcionais concluídas: " + gui.atividadesOpcionaisConcluidas)
				.append("Entretenimentos registrados:\n");

		for (String entretenimento : entretenimentos.entretenimentos.keySet()) {
			informacoes.append(entretenimento + "\n");
		}
		informacoes.append("\nTempo para Entretenimentos recebido: Horas: " + tempoEmAtividades.horasAcumuladas
				+ ", Minutos: " + tempoEmAtividades.minutosAcumulados + ", Segundos: "
				+ tempoEmAtividades.segundosAcumulados + ".");

		return informacoes.toString();
	}

}
