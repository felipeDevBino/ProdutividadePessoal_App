package tabelas;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/*
 * Serão atividades opcionais que o usuário poderá realizar como bônus de tempo
 * em entretenimento e realização para o usuário, principalmente ao sentir-se ocioso
 * ou entediado, o sistema dessa atividade funcionará de forma que a atividade e o
 * tempo sejam escolhidos aleatóriamente pelo sistema.
 */

public class AtividadesAntiOciosidade implements Runnable {

	protected static Map<String, StringBuilder> atividadesAntiOciosidade = new HashMap<String, StringBuilder>();
	private String[] atividades = new String[] { "Ler um livro", "Fazer uma caminhada", "Jogar um quebra cabeça",
			"Assistir a um documentário", "Estudar um tema de preferência", "Fazer um desenho", "Arrumar o quarto",
			"Resolva cálculos", "Medite", "Escute um podcast informativo" };
	private double[] tempos = new double[] { 10, 15, 20, 25, 30 };
	protected static String atividade;

	public void defineAtividadesAntiOciosidade() {
		for (int i = 0; i < atividades.length; i++) {													//STRINGBUILDER COM VALORES RANDOMIZADOS
			StringBuilder tempo = new StringBuilder();
			tempo.append(0 + "H - " + tempos[randomizaMinutos()] + "M - " + 0 + "S.");
			AtividadesAntiOciosidade.atividadesAntiOciosidade.put(randomizaAtividadeAntiOciosidade(), tempo);
		}
		
	}

	public String randomizaAtividadeAntiOciosidade() {
		Random random = new Random();
		int randomizaAtividade = random.nextInt(AtividadesAntiOciosidade.atividadesAntiOciosidade.size());
		switch (randomizaAtividade) {
		case 0:
			AtividadesAntiOciosidade.atividade = atividades[0];
			break;
		case 1:
			AtividadesAntiOciosidade.atividade = atividades[1];
			break;
		case 2:
			AtividadesAntiOciosidade.atividade = atividades[2];
			break;
		case 3:
			AtividadesAntiOciosidade.atividade = atividades[3];
			break;
		case 4:
			AtividadesAntiOciosidade.atividade = atividades[4];
			break;
		case 5:
			AtividadesAntiOciosidade.atividade = atividades[5];
			break;
		case 6:
			AtividadesAntiOciosidade.atividade = atividades[6];
			break;
		case 7:
			AtividadesAntiOciosidade.atividade = atividades[7];
			break;
		case 8:
			AtividadesAntiOciosidade.atividade = atividades[8];
			break;
		case 9:
			AtividadesAntiOciosidade.atividade = atividades[9];
			break;
		}
		return AtividadesAntiOciosidade.atividade;
	}
	
	public void tempoDecorridoEmAtividadesAntiOciosidade() {
		//TODO
	}

	//Hora, Minuto e Segundo do array tempos
	public int randomizaMinutos() {
		Random random = new Random();
		int tempoRandomizado = random.nextInt(5);
		return tempoRandomizado;
	}

	public int randomizaDificuldade() {
		Random random = new Random();
		int dificuldadeRandomizada = random.nextInt(5);
		return dificuldadeRandomizada;
	}

	@Override
	public void run() {
		try {
			System.out.println("\n...");
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
