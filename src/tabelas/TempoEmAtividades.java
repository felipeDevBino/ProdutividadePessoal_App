package tabelas;

/*
 * Iniciará com um tempo pré-determinado para cada atividade selecionada pelo próprio usuário
 * e a medida que forem terminadas ou terem seu tempo reduzido (sendo informadas pelo usuário) 
 * o usuário receberá uma quantidade de tempo para entretenimentos dependendo do nível da 
 * atividade e de quanto tempo passou nela.
 *  
 */

public class TempoEmAtividades {

	static int atividadesConcluidasNoDia = AtividadesNecessarias.atividadesObrigatorias.size();
	static String atividade;

	public static void incrementaTempo(Integer incremento) {

		for (String atividade : AtividadesNecessarias.atividadesObrigatorias.keySet()) {
			AtividadesNecessarias.atividadesObrigatorias.put(atividade,
					AtividadesNecessarias.atividadesObrigatorias.get(atividade) + incremento);
		}

		System.out.println("\nAtividades reiniciadas com sucesso.");

	}

	public static void escolheAtividade(String atividade, int chave) {
		int contador = 1;
		for (String buscaAtividade : AtividadesNecessarias.atividadesObrigatorias.keySet()) {
			if (contador == chave) {
				atividade = buscaAtividade;
				break;
			}
			contador++;
		}
		TempoEmAtividades.atividade = atividade;
	}

	// INTERFACE PARA DECREMENTAR OS TEMPOS DAS ATIVIDADES
	public static void tempoDecorridoEmAtividades(Integer tempoDecorrido, String tipoDeMinutagem) {
		if (tempoDecorrido < 0) {
			throw new IllegalArgumentException("Você precisa digitar ou fornecer um tempo válido! EX: 5, 10, 15...");
		}

		int contador = 0;
		for (String atividadeAtual : Entretenimentos.entretenimentos.keySet()) {
			if (TempoEmAtividades.atividade.equals(atividadeAtual)) {
				// DECREMENTA O TEMPO NECESSÁRIO PARA CONCLUIR A ATIVIDADE MENCIONADA EM
				// 'atividade'
				AtividadesNecessarias.atividadesObrigatorias.put(TempoEmAtividades.atividade,
						AtividadesNecessarias.atividadesObrigatorias.get(TempoEmAtividades.atividade) - tempoDecorrido);
			} else {
				System.out.println("\nTempo passado/decrementado com sucesso.");
				TempoEmAtividades.atividadesConcluidasNoDia--;

				if (AtividadesNecessarias.atividadesObrigatorias.get(TempoEmAtividades.atividade) <= 0) {
					System.out.println("\nAtividade: " + atividadeAtual + " concluída com sucesso.");

					if (AtividadesNecessarias.dificuldadeDeCadaAtividade.get(contador).equals("muito fácil")) {
//						TempoEmEntretenimentos.incrementaTempo(nivel de dificuldade);
						
					} else if (AtividadesNecessarias.dificuldadeDeCadaAtividade.get(contador).equals("fácil")) {
//						TempoEmEntretenimentos.incrementaTempo(nivel de dificuldade);
						
					} else if (AtividadesNecessarias.dificuldadeDeCadaAtividade.get(contador).equals("intermediário")) {
//						TempoEmEntretenimentos.incrementaTempo(nivel de dificuldade);
						
					} else if (AtividadesNecessarias.dificuldadeDeCadaAtividade.get(contador).equals("difícil")) {
//						TempoEmEntretenimentos.incrementaTempo(nivel de dificuldade);
						
					} else if (AtividadesNecessarias.dificuldadeDeCadaAtividade.get(contador).equals("muito difífil")) {
//						TempoEmEntretenimentos.incrementaTempo(nivel de dificuldade);

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
