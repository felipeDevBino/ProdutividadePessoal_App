package dias_consecutivos;

import atividades.AtividadesObrigatorias;
import atividades.Entretenimentos;
import atividades.TempoEmAtividades;
import interface_executar.InterfaceGrafica;

public class InformacoesDiarias {

	private static StringBuilder informacoes = new StringBuilder();

	public static String retornaInformacoes() {
		int contador = 0;
		for (String atividade : AtividadesObrigatorias.atividadesObrigatorias.keySet()) {
			informacoes.append("\n" + (contador + 1) + " Atividade: " + ": " + atividade + "\n\n")
					.append("Horas: " + AtividadesObrigatorias.horasMutaveis.get(contador) + " Minutos: "
							+ AtividadesObrigatorias.minutosMutaveis.get(contador) + " Segundos: "
							+ AtividadesObrigatorias.segundosMutaveis.get(contador) + "\n");
			contador++;

		}

		informacoes
				.append("\nAtividades opcionais concluídas: " + InterfaceGrafica.atividadesOpcionaisConcluidas)
				.append("\n\nEntretenimentos registrados:\n");

		for (String entretenimento : Entretenimentos.entretenimentos.keySet()) {
			informacoes.append(entretenimento + "\n");
		}
		informacoes.append("\nTempo para Entretenimentos recebido: Horas: " + TempoEmAtividades.horasAcumuladas
				+ ", Minutos: " + TempoEmAtividades.minutosAcumulados + ", Segundos: "
				+ TempoEmAtividades.segundosAcumulados + ".");

		return informacoes.toString();
	}

}
