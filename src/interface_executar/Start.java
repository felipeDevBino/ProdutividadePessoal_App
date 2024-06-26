package interface_executar;

//import java.util.Scanner;

import atividades.AtividadesObrigatorias;
import atividades.Entretenimentos;
import dias_consecutivos.StatusDiasConsecutivos;

public class Start {

	public static int diasConsecutivos = 0;
	//private static Scanner scanner = new Scanner(System.in);
	public static boolean programaEncerrado = false;

	/**
	 * 
	 * author felipeDevBino
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		buscaListaEmDiretorios();

		System.out.println(
				"\n---------------------------------------------------------------ProdutividadePessoal_App---------------------------------------------------------------");
		AtividadesObrigatorias.defineAsAtividades();
		Entretenimentos.defineOsEntretenimentos();
		System.out.println("\nAtividades Obrigatórias e Entretenimentos registrados com sucesso.");

		System.out.println("\nSelecione as 3 atividades para concluir em sua interface!");

		AtividadesObrigatorias.getTodasAsAtividades();

		SelecionaAtividades.selecionaAtividade01();
		SelecionaAtividades.selecionaAtividade02();
		SelecionaAtividades.selecionaAtividade03();

		InterfaceGrafica.main(args);

		StatusDiasConsecutivos.getTodosOsDiasPassados();
		
		System.out.println(
				"\n-------------------------------------------------------------------------------------------------------------------------------------------------------");

	}

	/*
	 * QUESTIONA O USUÁRIO SE ELE GOSTARIA DE INSERIR A LOCALIZAÇÃO DE UM ARQUIVO
	 * CONTENDO INFORMAÇÕES DE UMA LISTA EXISTENTE, O PROGRAMA FARÁ UMA VARREDURA NO
	 * ARQUIVO E IRÁ PREENCHER AS VARIÁVEIS, QUESTIONANDO SOMENTE SOBRE QUAIS AS 3
	 * ATIVIDADES O USUÁRIO DESEJA EXIBIR NA INTERFACE, O ARQUIVO SERÁ CONSTANTEMENTE 
	 * ATUALIZADO DURANTE AS ATUALIZAÇÕES QUE O USUÁRIO FARÁ NO PROGRAMA, BEM COMO 
	 * PARA CADA MINUTO DECREMENTADO DO CRONÔMETRO
	 */
	private static void buscaListaEmDiretorios() {
		// TODO
	}
	
	private static void salvaListaEmDiretorios() {
		// TODO
	}

}
