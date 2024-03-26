package tabelas;

/*
 * PROGRAMA
 * 
 * Será capaz de realizar o registro de quanto tempo (CUMULATIVO) o usuário
 * terá 'direito' de aproveitar de seus entretenimentos de consciência limpa.
 * 
 * USUÁRIO
 * 
 * Terá a obrigação de enviar o tempo decorrido o entretenimento
 * que ele aproveitou, através de seu cronômetro, para que o programa
 * possa decrementar justamente o tempo disponível para entretenimentos.
 * 
 */

public class TempoEmEntretenimentos {

	public static void incrementaTempo(Integer incremento) {
		
	}
	
	public static void tempoDecorridoEmPassatempos(Integer tempoDecorrido) {
		if(tempoDecorrido < 0) {
			throw new IllegalArgumentException("Você precisa digitar um tempo válido! EX: 5, 10, 15...");
		}
		//TODO
		
	}
	
}
