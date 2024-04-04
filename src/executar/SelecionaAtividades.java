package executar;

import tabelas.AtividadesAntiOciosidade;
import tabelas.AtividadesNecessarias;
import tabelas.TempoEmAtividades;

// ESCOLHE ATÉ 3 ATIVIDADES PRINCIPAIS PARA FAZER DE UMA VEZ, FORNECENDO AO
// USUÁRIO UMA PEQUENA INTERFACE PARA DECREMENTAR O TEMPO DAS ATIVIDADES
// DIÁRIAS, E 2 ATIVIDADES SECUNDÁRIAS OPCIONAIS.

public class SelecionaAtividades {

	public static String atividade01, atividade02, atividade03;
	public static String atividadeOpcional01, atividadeOpcional02;

	public static void selecionaAtividade01() {

		do {
			AtividadesNecessarias.getAtividade();
			SelecionaAtividades.atividade01 = AtividadesNecessarias.atividade;
			if (SelecionaAtividades.atividade01.equals(atividade02)
					|| SelecionaAtividades.atividade01.equals(atividade03)) {
				System.out.println("\nErro! essa atividade já foi selecionada por algum espaço!");
			}
		} while (SelecionaAtividades.atividade01.equals(atividade02)
				|| SelecionaAtividades.atividade01.equals(atividade03));
	}

	public static void selecionaAtividade02() {

		do {
			AtividadesNecessarias.getAtividade();
			SelecionaAtividades.atividade02 = AtividadesNecessarias.atividade;
			if (SelecionaAtividades.atividade02.equals(atividade01)
					|| SelecionaAtividades.atividade02.equals(atividade03)) {
				System.out.println("\nErro! essa atividade já foi selecionada por algum espaço!");
			}
		} while (SelecionaAtividades.atividade02.equals(atividade01)
				|| SelecionaAtividades.atividade02.equals(atividade03));

	}

	public static void selecionaAtividade03() {
		
		do {
			AtividadesNecessarias.getAtividade();
			SelecionaAtividades.atividade03 = AtividadesNecessarias.atividade;
			if (SelecionaAtividades.atividade03.equals(atividade01)
					|| SelecionaAtividades.atividade03.equals(atividade02)) {
				System.out.println("\nErro! essa atividade já foi selecionada por algum espaço!");
			}
		} while (SelecionaAtividades.atividade03.equals(atividade01)
				|| SelecionaAtividades.atividade03.equals(atividade02));
	}

	public static void selecionaAtividadeOpcional01() {
		AtividadesAntiOciosidade atividadesAntiOciosidade = new AtividadesAntiOciosidade();
		SelecionaAtividades.atividadeOpcional01 = atividadesAntiOciosidade.getAtividade();
	}
	
	public static void selecionaAtividadeOpcional02() {
		AtividadesAntiOciosidade atividadesAntiOciosidade = new AtividadesAntiOciosidade();
		SelecionaAtividades.atividadeOpcional02 = atividadesAntiOciosidade.getAtividade();	
	}


}
