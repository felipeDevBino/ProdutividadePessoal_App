package atividades;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import interface_executar.InterfaceGrafica;
import interface_executar.Start;
import logica_horarios.SistemaDeTempo;

/*
 * Iniciará com um tempo pré-determinado para cada atividade selecionada pelo próprio usuário
 * e a medida que forem terminadas ou terem seu tempo reduzido (sendo informadas pelo usuário) 
 * o usuário receberá uma quantidade de tempo para entretenimentos dependendo do nível da 
 * atividade e de quanto tempo passou nela.
 *  
 */

public class TempoEmAtividades {

	public static Scanner scanner = new Scanner(System.in);
	static int atividadesConcluidasNoDia;
	public static Integer horasAcumuladas = 0;
	public static Integer minutosAcumulados = 0;
	public static Integer segundosAcumulados = 0;

	public static void incrementaTempo() {

		int contador = 0;
		String restauraHorario;
		List<String> atividades = new ArrayList<String>();
		List<String> horariosCompletos = new ArrayList<String>();

		for (String atividade : AtividadesObrigatorias.atividadesObrigatorias.keySet()) {
			atividades.add(contador, atividade);
			restauraHorario = (AtividadesObrigatorias.horasOriginais.get(contador) + "H : "
					+ AtividadesObrigatorias.minutosOriginais.get(contador) + "M : "
					+ AtividadesObrigatorias.segundosOriginais.get(contador) + "S.");
			horariosCompletos.add(contador, restauraHorario);
			contador++;
		}
		contador = 0;
		for (String atividade : atividades) {
			AtividadesObrigatorias.atividadesObrigatorias.remove(atividade);
			AtividadesObrigatorias.atividadesObrigatorias.put(atividade, horariosCompletos.get(contador));
			contador++;
		}
		System.out.println("\nAtividades reiniciadas com sucesso.");

	}

	public static void tempoDecorridoEmAtividades(int hora, int minuto, int segundo) {
		if (hora <= 0 && minuto <= 0 && segundo <= 0) {
			throw new IllegalArgumentException(
					"Você precisa digitar ou fornecer um tempo válido! EX: 1 (horas): 50 (minutos): 30 (segundos).");
		}

		int contador = 0;
		String decremento = "";
		String condicaoParaAcabar;
		condicaoParaAcabar = (0 + "H : " + 0 + "M : " + 0 + "S.");
		boolean igual = false;

		for (String atividadeAtual : AtividadesObrigatorias.atividadesObrigatorias.keySet()) {
			if (AtividadesObrigatorias.atividade.equals(atividadeAtual)) {
				igual = true;

				TempoEmAtividades tempoEmAtividades = new TempoEmAtividades();
				SistemaDeTempo sistemaDeTempo = new SistemaDeTempo();
				sistemaDeTempo.tempoDecrementadoEmAtividades(hora, minuto, segundo, contador, tempoEmAtividades);
				
				decremento = (AtividadesObrigatorias.horasMutaveis.get(contador) + "H : " +
				AtividadesObrigatorias.minutosMutaveis.get(contador) + "M : " + AtividadesObrigatorias.segundosMutaveis.get(contador) + "S.");
				System.out.println("\nTempo passado/decrementado com sucesso.");
				break;
			}
			contador++;
		}
		if (igual) {
			AtividadesObrigatorias.atividadesObrigatorias.remove(AtividadesObrigatorias.atividade);
			AtividadesObrigatorias.atividadesObrigatorias.put(AtividadesObrigatorias.atividade, decremento);
		}

		if (AtividadesObrigatorias.atividadesObrigatorias.get(AtividadesObrigatorias.atividade)
				.equals(condicaoParaAcabar)) {
			TempoEmAtividades.atividadesConcluidasNoDia--;
			System.out.println(
					"\nO tempo restante para concluir a atividade: " + AtividadesObrigatorias.atividade + " acabou!");

			System.out.println("\nAtividade: " + AtividadesObrigatorias.atividade + " concluída com sucesso.");

			if (AtividadesObrigatorias.dificuldadeDeCadaAtividade.get(contador).equals("muito fácil")) {
				TempoEmAtividades.minutosAcumulados += 3;

			} else if (AtividadesObrigatorias.dificuldadeDeCadaAtividade.get(contador).equals("fácil")) {
				TempoEmAtividades.minutosAcumulados += 5;

			} else if (AtividadesObrigatorias.dificuldadeDeCadaAtividade.get(contador).equals("intermediário")) {
				TempoEmAtividades.minutosAcumulados += 10;

			} else if (AtividadesObrigatorias.dificuldadeDeCadaAtividade.get(contador).equals("difícil")) {
				TempoEmAtividades.minutosAcumulados += 15;

			} else if (AtividadesObrigatorias.dificuldadeDeCadaAtividade.get(contador).equals("muito difícil")) {
				TempoEmAtividades.minutosAcumulados += 30;

			}

			SistemaDeTempo sistemaDeTempo = new SistemaDeTempo();
			sistemaDeTempo.sistemaDeTempoOrganizado(TempoEmAtividades.horasAcumuladas,
					TempoEmAtividades.minutosAcumulados, TempoEmAtividades.segundosAcumulados);

			TempoEmAtividades.horasAcumuladas = sistemaDeTempo.horasOrganizadas;
			TempoEmAtividades.minutosAcumulados = sistemaDeTempo.minutosOrganizados;
			TempoEmAtividades.segundosAcumulados = sistemaDeTempo.segundosOrganizados;

			System.out.println("\n-------------------------------------------------------------------------------------------------------------------------------------------------------");
			System.out.println("\nVocê recebeu algum tempo pela conclusão da atividade! "
					+ TempoEmAtividades.horasAcumuladas + "H : " + TempoEmAtividades.minutosAcumulados + "M : "
					+ TempoEmAtividades.segundosAcumulados + "S.");
			System.out.println("\n-------------------------------------------------------------------------------------------------------------------------------------------------------");

			InterfaceGrafica.concluiu = true;

		}
	}

	public static void verificaAtividadesPendentes() {
		if (TempoEmAtividades.atividadesConcluidasNoDia == 0) {
			System.out.println("\nTodas as atividades foram concluídas! Parabéns por essa conquista!");
			return;
		}
	}

}
