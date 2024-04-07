package tabelas;

import java.util.Scanner;

import executar.Start;

/*
 * Iniciará com um tempo pré-determinado para cada atividade selecionada pelo próprio usuário
 * e a medida que forem terminadas ou terem seu tempo reduzido (sendo informadas pelo usuário) 
 * o usuário receberá uma quantidade de tempo para entretenimentos dependendo do nível da 
 * atividade e de quanto tempo passou nela.
 *  
 */

public class TempoEmAtividades {

	static Scanner scanner = new Scanner(System.in);
	static int atividadesConcluidasNoDia;
	public static Integer horasAcumuladas = 0;
	public static Integer minutosAcumulados = 0;
	public static Integer segundosAcumulados = 0;
		
	public static void incrementaTempo() {

		int contador = 0;
		for (String atividade : AtividadesNecessarias.atividadesObrigatorias.keySet()) {
			String restauraHorario;
			restauraHorario = (AtividadesNecessarias.horasOriginais.get(contador) + "H : "
					+ AtividadesNecessarias.minutosOriginais.get(contador) + "M : "
					+ AtividadesNecessarias.segundosOriginais.get(contador) + "S.");
			
			AtividadesNecessarias.atividadesObrigatorias.replace(AtividadesNecessarias.atividadesObrigatorias.get(atividade), restauraHorario);
			
		}

		System.out.println("\nAtividades reiniciadas com sucesso.");

	}
				//RETORNA STRING COM OS VALORES ATUALIZADOS
	public static void tempoDecorridoEmAtividades(Integer hora, Integer minuto, Integer segundo) {
		if (hora <= 0 && minuto <= 0 && segundo <= 0) {
			throw new IllegalArgumentException(
					"Você precisa digitar ou fornecer um tempo válido! EX: 1 (horas): 50 (minutos): 30 (segundos).");
		}
		int contador = 0;
		for (String atividadeAtual : AtividadesNecessarias.atividadesObrigatorias.keySet()) {	
			if (AtividadesNecessarias.atividade.equals(atividadeAtual)) {
				
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
				
				String decremento;
				decremento = (horaMutavel + "H : " + minutoMutavel + "M : " + segundoMutavel + "S.");
				
				AtividadesNecessarias.atividadesObrigatorias.replace(AtividadesNecessarias.atividadesObrigatorias.get(atividadeAtual), decremento);
								
				System.out.println("\nTempo passado/decrementado com sucesso.");
				TempoEmAtividades.atividadesConcluidasNoDia--;
				String condicaoParaAcabar;
				condicaoParaAcabar = (0 + "H : " + 0 + "M : " + 0 + "S.");
				if (AtividadesNecessarias.atividadesObrigatorias.get(atividadeAtual).equals(condicaoParaAcabar)) {
					System.out.println("\nO tempo restante para concluir a atividade: " + atividadeAtual + " acabou!");
		
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
						TempoEmAtividades.horasAcumuladas += 2;
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
			Start.terminou = true;
			return;
		}
	}

}
