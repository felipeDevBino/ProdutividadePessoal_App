package tabelas;

import java.util.Scanner;

/*
 * Iniciará com um tempo pré-determinado para cada atividade selecionada pelo próprio usuário
 * e a medida que forem terminadas ou terem seu tempo reduzido (sendo informadas pelo usuário) 
 * o usuário receberá uma quantidade de tempo para entretenimentos dependendo do nível da 
 * atividade e de quanto tempo passou nela.
 *  
 */

public class TempoEmAtividades {

	static Scanner scanner = new Scanner(System.in);
	static int atividadesConcluidasNoDia = AtividadesNecessarias.atividadesObrigatorias.size();
	public static String atividade;
	public static Integer horasAcumuladas = 0;
	public static Integer minutosAcumulados = 0;
	public static Integer segundosAcumulados = 0;
		
	public static void incrementaTempo() {

		int contador = 0;
		for (String atividade : AtividadesNecessarias.atividadesObrigatorias.keySet()) {
			StringBuilder restauraHorario = new StringBuilder();
			restauraHorario.append(AtividadesNecessarias.horasOriginais.get(contador) + "H : "
					+ AtividadesNecessarias.minutosOriginais.get(contador) + "M : "
					+ AtividadesNecessarias.segundosOriginais.get(contador) + "S.");
			
			AtividadesNecessarias.atividadesObrigatorias.get(atividade).delete(0,
					AtividadesNecessarias.atividadesObrigatorias.get(atividade).length());
			AtividadesNecessarias.atividadesObrigatorias.put(atividade, restauraHorario);

		}

		System.out.println("\nAtividades reiniciadas com sucesso.");

	}

	public static void escolheAtividade() {
		System.out.println("\nDigite o número da atividade:");
		int numeroDaAtividade = Integer.parseInt(scanner.nextLine());
		int contador = 1;
		for (String buscaAtividade : AtividadesNecessarias.atividadesObrigatorias.keySet()) {
			if (contador == numeroDaAtividade) {
				System.out.println("\nAtividade encontrada! " + buscaAtividade);
				TempoEmAtividades.atividade = buscaAtividade;
				break;
			}
			contador++;
		}
	}

	// INTERFACE PARA DECREMENTAR OS TEMPOS DAS ATIVIDADES
	public static void tempoDecorridoEmAtividades(Integer hora, Integer minuto, Integer segundo) {
		if (hora <= 0 && minuto <= 0 && segundo <= 0) {
			throw new IllegalArgumentException(
					"Você precisa digitar ou fornecer um tempo válido! EX: 1 (horas): 50 (minutos): 30 (segundos).");
		}
		int contador = 0;
		for (String atividadeAtual : Entretenimentos.entretenimentos.keySet()) {
			int horaMutavel = AtividadesNecessarias.horasMutaveis.get(contador);
			horaMutavel -= hora;
			AtividadesNecessarias.horasMutaveis.remove(contador);
			AtividadesNecessarias.horasMutaveis.add(horaMutavel);

			int minutoMutavel = AtividadesNecessarias.minutosMutaveis.get(contador);
			minutoMutavel -= minuto;
			AtividadesNecessarias.minutosMutaveis.remove(contador);
			AtividadesNecessarias.minutosMutaveis.add(minutoMutavel);

			int segundoMutavel = AtividadesNecessarias.segundosMutaveis.get(contador);
			segundoMutavel -= segundo;
			AtividadesNecessarias.segundosMutaveis.remove(contador);
			AtividadesNecessarias.segundosMutaveis.add(minutoMutavel);

			if (TempoEmAtividades.atividade.equals(atividadeAtual)) {
				// DECREMENTA O TEMPO NECESSÁRIO PARA CONCLUIR A ATIVIDADE MENCIONADA EM
				// 'atividade'
				StringBuilder decremento = new StringBuilder();
				decremento.append(horaMutavel + "H - " + minutoMutavel + "M - " + segundoMutavel + "S.");
				
				AtividadesNecessarias.atividadesObrigatorias.get(atividadeAtual).delete(0,
						AtividadesNecessarias.atividadesObrigatorias.get(atividadeAtual).length());
				AtividadesNecessarias.atividadesObrigatorias.put(atividadeAtual, decremento);

				AtividadesNecessarias.atividadesObrigatorias.put(TempoEmAtividades.atividade,
						AtividadesNecessarias.atividadesObrigatorias.get(atividadeAtual));
			} else {
				System.out.println("\nTempo passado/decrementado com sucesso.");
				TempoEmAtividades.atividadesConcluidasNoDia--;

				StringBuilder condicaoDeAtividadeConcluida = new StringBuilder();
				condicaoDeAtividadeConcluida.append(0 + "H - " + 0 + "M - " + 0 + "S.");
				if (AtividadesNecessarias.atividadesObrigatorias.get(TempoEmAtividades.atividade)
						.equals(condicaoDeAtividadeConcluida)) {
					System.out.println("\nAtividade: " + atividadeAtual + " concluída com sucesso.");

					if (AtividadesNecessarias.dificuldadeDeCadaAtividade.get(contador).equals("muito fácil")) {
						TempoEmAtividades.minutosAcumulados += 15;
						TempoEmAtividades.segundosAcumulados += 59;

					} else if (AtividadesNecessarias.dificuldadeDeCadaAtividade.get(contador).equals("fácil")) {
						TempoEmAtividades.minutosAcumulados += 20;
						TempoEmAtividades.segundosAcumulados += 59;

					} else if (AtividadesNecessarias.dificuldadeDeCadaAtividade.get(contador).equals("intermediário")) {
						TempoEmAtividades.minutosAcumulados += 30;
						TempoEmAtividades.segundosAcumulados += 59;

					} else if (AtividadesNecessarias.dificuldadeDeCadaAtividade.get(contador).equals("difícil")) {
						TempoEmAtividades.horasAcumuladas += 1;
						TempoEmAtividades.minutosAcumulados += 30;
						TempoEmAtividades.segundosAcumulados += 59;

					} else if (AtividadesNecessarias.dificuldadeDeCadaAtividade.get(contador).equals("muito difífil")) {
						TempoEmAtividades.minutosAcumulados += 2;
						TempoEmAtividades.minutosAcumulados += 30;
						TempoEmAtividades.segundosAcumulados += 59;

					}
				}
			}
			contador++;
		}
	}

	public static void verificaAtividadesPendentes() {
		if (TempoEmAtividades.atividadesConcluidasNoDia == 0) {
			System.out.println("\nTodas as atividades foram concluídas! Parabéns por essa conquista!");
			return;
		}
	}

}
