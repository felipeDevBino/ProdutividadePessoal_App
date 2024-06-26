package atividades;

import java.util.Map;
import java.util.Scanner;

import logica_horarios.SistemaDeTempo;

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

public class AtividadesObrigatorias {

	public static Scanner scanner = new Scanner(System.in);
	public static Map<String, String> atividadesObrigatorias = new HashMap<>();
	public static List<String> dificuldadeDeCadaAtividade = new ArrayList<>();
	protected String[] niveisDeDificuldade = new String[] { "muito fácil", "fácil", "intermediário", "difícil",
			"muito dificil" };
	public static List<Integer> horasOriginais = new ArrayList<>(), horasMutaveis = new ArrayList<>();
	public static List<Integer> minutosOriginais = new ArrayList<>(), minutosMutaveis = new ArrayList<>();
	public static List<Integer> segundosOriginais = new ArrayList<>(), segundosMutaveis = new ArrayList<>();
	public static String atividade;

	public static void defineAsAtividades() {
		int quantidadeDeAtividades;

		do {
			System.out.println("\nDigite a quantidade de atividades obrigatórias que você possui: ");
			quantidadeDeAtividades = Integer.parseInt(Entretenimentos.scanner.nextLine());

			String condicional = (quantidadeDeAtividades <= 0 || quantidadeDeAtividades < 3)
					? "\nQuantidade inválida! Insira uma quantidade positiva / pelo menos 3 atividades."
					: "\nQuantidade registrada com sucesso.";
			System.out.println(condicional);
		} while (quantidadeDeAtividades <= 0 || quantidadeDeAtividades < 3);

		String atividade;
		int hora = 0;
		int minuto = 0;
		int segundo = 0;
		boolean repetida = false;
		for (int i = 0; i < quantidadeDeAtividades; i++) {
			do {
				repetida = false;
				System.out.println("\nDigite a " + (i + 1) + " atividade: ");
				atividade = Entretenimentos.scanner.nextLine();

				for (String atividadeInserida : AtividadesObrigatorias.atividadesObrigatorias.keySet()) {
					if (atividade.equals(atividadeInserida)) {
						System.out.println("\nErro! Você já inseriu uma atividade com este nome");
						repetida = true;
					}
				}

				if (!repetida) {
					System.out.println("\nDigite o tempo que você leva para concluir esta atividade:");

					System.out.println("\n(horas):");
					hora = Integer.parseInt(Entretenimentos.scanner.nextLine());
					System.out.println("\n(minutos):");
					minuto = Integer.parseInt(Entretenimentos.scanner.nextLine());
					System.out.println("\n(segundos):");
					segundo = Integer.parseInt(Entretenimentos.scanner.nextLine());

					SistemaDeTempo sistemaDeTempo = new SistemaDeTempo();
					sistemaDeTempo.sistemaDeTempoOrganizado(hora, minuto, segundo);

					hora = sistemaDeTempo.horasOrganizadas;
					minuto = sistemaDeTempo.minutosOrganizados;
					segundo = sistemaDeTempo.segundosOrganizados;

					if (atividade == null) {
						System.out.println("\nERRO! Não há nenhuma informação para a atividade!");
					}
					if (hora <= 0 && minuto <= 0 && segundo <= 0) {
						System.out
								.println("\nERRO! Minutagem inválida! Digite valores superiores a zero para o tempo!");
					}
				}
			} while (atividade == null || hora <= 0 && minuto <= 0 && segundo <= 0 || repetida);

			AtividadesObrigatorias.horasOriginais.add(hora);
			AtividadesObrigatorias.minutosOriginais.add(minuto);
			AtividadesObrigatorias.segundosOriginais.add(segundo);

			AtividadesObrigatorias.horasMutaveis.add(hora);
			AtividadesObrigatorias.minutosMutaveis.add(minuto);
			AtividadesObrigatorias.segundosMutaveis.add(segundo);

			String minutagem;
			minutagem = (AtividadesObrigatorias.horasMutaveis.get(i) + "H : "
					+ AtividadesObrigatorias.minutosMutaveis.get(i) + "M : "
					+ AtividadesObrigatorias.segundosMutaveis.get(i) + "S.");

			String dificuldade;
			do {
				System.out.println(
						"\nDigite o nível de dificuldade que você classifica essa atividade: (muito fácil, fácil, intermediário, difícil, muito difícil)");
				dificuldade = AtividadesObrigatorias.scanner.nextLine();

				if (!dificuldade.equals("muito fácil") && !dificuldade.equals("fácil")
						&& !dificuldade.equals("intermediário") && !dificuldade.equals("difícil")
						&& !dificuldade.equals("muito difícil")) {
					System.out.println("\nNível de dificuldade inválido! Insira alguma das dificuldades disponíveis.");

				}
			} while (!dificuldade.equals("muito fácil") && !dificuldade.equals("fácil")
					&& !dificuldade.equals("intermediário") && !dificuldade.equals("difícil")
					&& !dificuldade.equals("muito difícil"));

			AtividadesObrigatorias.atividadesObrigatorias.put(atividade, minutagem);
			AtividadesObrigatorias.dificuldadeDeCadaAtividade.add(dificuldade);
		}

	}

	public static void getAtividade() {
		System.out.println("\nDigite o número da atividade:");
		int numeroDaAtividade = Integer.parseInt(scanner.nextLine());

		int contador = 0;
		for (String buscaAtividade : AtividadesObrigatorias.atividadesObrigatorias.keySet()) {
			if (contador == (numeroDaAtividade - 1)) {
				System.out.println("\nAtividade encontrada! (" + (contador + 1) + "): " + buscaAtividade
						+ ", Tempo Restante: " + AtividadesObrigatorias.atividadesObrigatorias.get(buscaAtividade)
						+ ", Dificuldade: " + AtividadesObrigatorias.dificuldadeDeCadaAtividade.get(contador));
				AtividadesObrigatorias.atividade = buscaAtividade;
				break;
			}
			contador++;
		}
	}

	public static void getTodasAsAtividades() {
		int contador = 0;
		System.out.println(
				"\n-------------------------------------------------------------------------------------------------------------------------------------------------------");
		for (String atividade : AtividadesObrigatorias.atividadesObrigatorias.keySet()) {
			System.out.println("\nAtividade (" + (contador + 1) + "): " + atividade + ", Tempo Restante: "
					+ AtividadesObrigatorias.atividadesObrigatorias.get(atividade) + " Dificuldade: "
					+ AtividadesObrigatorias.dificuldadeDeCadaAtividade.get(contador));
			contador++;
		}
	}

}
