package tabelas;

import java.util.Map;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/*
 * Uma lista de atividades necessárias que o próprio usuário, em primeira
 * instância, registrará no programa, para que ele mantenha essas informações,
 * como sendo as atividades necessárias e obrigatórias que o usuário deverá realizar.
 * 
 * Além disso, o usuário definirá o nível de dificuldade em 5 estrelas, quanto maior
 * a dificuldade, mais tempo o usuário poderá ganhar para seu entretenimento
 */

public class AtividadesNecessarias {

	protected static Map<String, Double> atividadesObrigatorias = new HashMap<String, Double>();
	protected static List<String> dificuldadeDeCadaAtividade = new ArrayList<String>();
	protected static String[] niveisDeDificuldade = new String[] { "muito fácil", "fácil", "intermediário", "difícil",
			"muito dificil" };
	static Scanner scanner = new Scanner(System.in);

	public static void defineAsAtividades() {
		int quantidadeDeAtividades;

		do {
			System.out.println("\nDigite a quantidade de atividades obrigatórias que você possui: ");
			quantidadeDeAtividades = Integer.parseInt(Entretenimentos.scanner.nextLine());

			String condicional = (quantidadeDeAtividades <= 0)
					? "\nQuantidade inválida! Insira uma quantidade positiva."
					: "\nQuantidade registrada com sucesso.";
			System.out.println(condicional);
		} while (quantidadeDeAtividades <= 0);

		for (int i = 0; i < quantidadeDeAtividades - 1; i++) {
			System.out.println("\nDigite a " + (i + 1) + " atividade: ");
			String atividade = Entretenimentos.scanner.nextLine();
			
			System.out.println("\nDigite o tempo que você leva para concluir esta atividade: ");
			Double tempo = Double.parseDouble(Entretenimentos.scanner.nextLine());
			
			System.out.println("\nDigite o nível de dificuldade que você classifica essa atividade: (muito fácil, fácil, intermediário, difícil, muito difícil)");
			String dificuldade = AtividadesNecessarias.scanner.nextLine();

			AtividadesNecessarias.atividadesObrigatorias.put(atividade, tempo);
			AtividadesNecessarias.dificuldadeDeCadaAtividade.add(dificuldade);
		}

	}
	
	public static void mostraTodasAsAtividades() {
		int contador = 0;
		for (String atividade : AtividadesNecessarias.atividadesObrigatorias.keySet()) {
			for (Double tempoDisponivel : AtividadesNecessarias.atividadesObrigatorias.values()) {
				System.out.println("\nAtividade (" + (contador + 1) + "): " + atividade + ", Tempo Disponível: " + tempoDisponivel + ", Dificuldade: " + AtividadesNecessarias.dificuldadeDeCadaAtividade.get(contador));
				contador++;
			}
		}
	}


}
