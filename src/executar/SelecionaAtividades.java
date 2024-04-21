package executar;

import atividades.AtividadesOpcionais;
import atividades.AtividadesObrigatorias;

// ESCOLHE ATÉ 3 ATIVIDADES PRINCIPAIS PARA FAZER DE UMA VEZ, FORNECENDO AO
// USUÁRIO UMA PEQUENA INTERFACE PARA DECREMENTAR O TEMPO DAS ATIVIDADES
// DIÁRIAS, E 2 ATIVIDADES SECUNDÁRIAS OPCIONAIS.

public class SelecionaAtividades {

	public static String atividade01, atividade02, atividade03;
	public static String atividadeOpcional01, atividadeOpcional02;

	public static void selecionaAtividade01() {

		do {
			AtividadesObrigatorias.getAtividade();
			SelecionaAtividades.atividade01 = AtividadesObrigatorias.atividade;
			if (SelecionaAtividades.atividade01.equals(atividade02)
					|| SelecionaAtividades.atividade01.equals(atividade03)) {
				System.out.println("\nErro! Essa atividade não existe ou já foi selecionada por algum espaço!");
			}
		} while (SelecionaAtividades.atividade01.equals(atividade02)
				|| SelecionaAtividades.atividade01.equals(atividade03));
	}

	public static void selecionaAtividade02() {

		do {
			AtividadesObrigatorias.getAtividade();
			SelecionaAtividades.atividade02 = AtividadesObrigatorias.atividade;
			if (SelecionaAtividades.atividade02.equals(atividade01)
					|| SelecionaAtividades.atividade02.equals(atividade03)) {
				System.out.println("\nErro! essa atividade é inválida ou já foi selecionada por algum espaço!");
			}
		} while (SelecionaAtividades.atividade02.equals(atividade01)
				|| SelecionaAtividades.atividade02.equals(atividade03));

	}

	public static void selecionaAtividade03() {
		
		do {
			AtividadesObrigatorias.getAtividade();
			SelecionaAtividades.atividade03 = AtividadesObrigatorias.atividade;
			if (SelecionaAtividades.atividade03.equals(atividade01)
					|| SelecionaAtividades.atividade03.equals(atividade02)) {
				System.out.println("\nErro! essa atividade já foi selecionada por algum espaço!");
			}
		} while (SelecionaAtividades.atividade03.equals(atividade01)
				|| SelecionaAtividades.atividade03.equals(atividade02));
	}

	public static void selecionaAtividadeOpcional01() {
		SelecionaAtividades.atividadeOpcional01 = AtividadesOpcionais.defineAtividadeAntiOciosidade();
	}
	
	public static void selecionaAtividadeOpcional02() {
		SelecionaAtividades.atividadeOpcional02 = AtividadesOpcionais.defineAtividadeAntiOciosidade();	
	}


}
