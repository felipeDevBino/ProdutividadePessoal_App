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
 * Além disso, o usuário definirá o nível de dificuldade de cada atividade, quanto maior
 * a dificuldade, mais tempo o usuário poderá ganhar para seu entretenimento
 */

public class AtividadesNecessarias {

	static Scanner scanner = new Scanner(System.in);
	public static Map<String, String> atividadesObrigatorias = new HashMap<String, String>();
	public static List<String> dificuldadeDeCadaAtividade = new ArrayList<String>();
	protected static String[] niveisDeDificuldade = new String[] { "muito fácil", "fácil", "intermediário", "difícil",
			"muito dificil" };
	public static List<Integer> horasOriginais = new ArrayList<Integer>(), horasMutaveis = new ArrayList<Integer>();
	public static List<Integer> minutosOriginais = new ArrayList<Integer>(), minutosMutaveis = new ArrayList<Integer>();
	public static List<Integer> segundosOriginais = new ArrayList<Integer>(), segundosMutaveis = new ArrayList<Integer>();
	public static String atividade;

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

		String atividade;
		int hora;
		int minuto;
		int segundo;
		for (int i = 0; i < quantidadeDeAtividades; i++) {
			do {
				System.out.println("\nDigite a " + (i + 1) + " atividade: ");
				atividade = Entretenimentos.scanner.nextLine();

				System.out.println("\nDigite o tempo que você leva para concluir esta atividade:");

				System.out.println("\n(horas):");
				hora = Integer.parseInt(Entretenimentos.scanner.nextLine());
				System.out.println("\n(minutos):");
				minuto = Integer.parseInt(Entretenimentos.scanner.nextLine());
				System.out.println("\n(segundos):");
				segundo = Integer.parseInt(Entretenimentos.scanner.nextLine());

				if (atividade == null) {
					System.out.println("\nERRO! Não há nenhuma informação para a atividade!");
				}
				if (hora <= 0 && minuto <= 0 && segundo <= 0) {
					System.out.println("\nERRO! Minutagem inválida! Digite valores superiores a zero para o tempo!");
				}
			} while (atividade == null || hora <= 0 && minuto <= 0 && segundo <= 0);

			AtividadesNecessarias.horasOriginais.add(hora);
			AtividadesNecessarias.minutosOriginais.add(minuto);
			AtividadesNecessarias.segundosOriginais.add(segundo);

			AtividadesNecessarias.horasMutaveis.add(hora);
			AtividadesNecessarias.minutosMutaveis.add(minuto);
			AtividadesNecessarias.segundosMutaveis.add(segundo);

			String minutagem;
			minutagem = (horasMutaveis.get(i) + "H : " + minutosMutaveis.get(i) + "M : " + segundosMutaveis.get(i)
					+ "S.");

			String dificuldade;
			do {
				System.out.println(
						"\nDigite o nível de dificuldade que você classifica essa atividade: (muito fácil, fácil, intermediário, difícil, muito difícil)");
				dificuldade = AtividadesNecessarias.scanner.nextLine();

				if (!dificuldade.equals("muito fácil") && !dificuldade.equals("fácil")
						&& !dificuldade.equals("intermediário") && !dificuldade.equals("difícil")
						&& !dificuldade.equals("muito difícil")) {
					System.out.println("\nNível de dificuldade inválido! Insira alguma das dificuldades disponíveis.");

				}
			} while (!dificuldade.equals("muito fácil") && !dificuldade.equals("fácil")
					&& !dificuldade.equals("intermediário") && !dificuldade.equals("difícil")
					&& !dificuldade.equals("muito difícil"));

			AtividadesNecessarias.atividadesObrigatorias.put(atividade, minutagem);
			AtividadesNecessarias.dificuldadeDeCadaAtividade.add(dificuldade);
		}

	}

	public static void getAtividade() {
		System.out.println("\nDigite o número da atividade:");
		int numeroDaAtividade = Integer.parseInt(scanner.nextLine());
		
		int contador = 0;
		for (String buscaAtividade : AtividadesNecessarias.atividadesObrigatorias.keySet()) {
			if (contador == (numeroDaAtividade - 1)) {
				System.out.println("\nAtividade encontrada! (" + (contador+1) + "): " + buscaAtividade
						+ ", Tempo Restante: " + AtividadesNecessarias.atividadesObrigatorias.get(buscaAtividade)
						+ ", Dificuldade: " + AtividadesNecessarias.dificuldadeDeCadaAtividade.get(contador));
				AtividadesNecessarias.atividade = buscaAtividade;
				break;
			}
			contador++;
		}
	}

	public static void getTodasAsAtividades() {
		int contador = 0;
		for (String atividade : AtividadesNecessarias.atividadesObrigatorias.keySet()) {
				System.out.println(
						"\nAtividade (" + (contador + 1) + "): " + atividade + ", Tempo Restante: " + AtividadesNecessarias.atividadesObrigatorias.get(atividade)
								+ ", Dificuldade: " + AtividadesNecessarias.dificuldadeDeCadaAtividade.get(contador));
				contador++;
		}
	}

}
