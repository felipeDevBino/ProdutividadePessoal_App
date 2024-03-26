package tabelas;

/*
 * Iniciará com um tempo pré-determinado para cada atividade selecionada pelo próprio usuário
 * e a medida que forem terminadas ou terem seu tempo reduzido (sendo informadas pelo usuário) 
 * o usuário receberá uma quantidade de tempo para entretenimentos dependendo do nível da 
 * atividade e de quanto tempo passou nela.
 *  
 */

public class TempoEmAtividades {
	
	public static void incrementaTempo(Integer incremento) {
		
	}
	
	public static void tempoDecorridoEmAtividades(Integer tempoDecorrido) {
		if(tempoDecorrido < 0) {
			throw new IllegalArgumentException("Você precisa digitar um tempo válido! EX: 5, 10, 15...");
		}
		//TODO
		
	}

}
