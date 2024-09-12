package gui.funcoesgui;

import javax.swing.JLabel;

import atividades.AtividadesObrigatorias;
import atividades.AtividadesOpcionais;
import atividades.SelecionaAtividades;
import atividades.TempoEmAtividades;
import gui.InterfaceGrafica;
import instancias.InstanceManager;
import utilizacaodetelas.UtilizarTelas;

public class DiminuirTempo {

	private AtividadesObrigatorias atividadesObrigatorias = InstanceManager.getAtividadesObrigatorias();
	private SelecionaAtividades selecionaAtividades = InstanceManager.getSelecionaAtividades();
	private TempoEmAtividades tempoEmAtividades = InstanceManager.getTempoEmAtividades();
	private AtividadesOpcionais atividadesOpcionais = InstanceManager.getAtividadesOpcionais();

	private boolean terminouAtividade01 = false;
	private boolean terminouAtividade02 = false;
	private boolean terminouAtividade03 = false;
	private boolean terminouAtividadeOp01 = false;
	private boolean terminouAtividadeOp02 = false;

	public void atividade01(InterfaceGrafica gui, UtilizarTelas tela, JLabel minutagem, String selecionada) {
		atividadesObrigatorias.setAtividadeSelecionada(selecionada);
		instrucaoDeDecremento(gui, tela, true, false);
		minutagem.setText(atividadesObrigatorias.atividadesObrigatorias.get(selecionada));
	}

	public void atividade02(InterfaceGrafica gui, UtilizarTelas tela, JLabel minutagem, String selecionada) {
		atividadesObrigatorias.setAtividadeSelecionada(selecionada);
		instrucaoDeDecremento(gui, tela, true, false);
		minutagem.setText(atividadesObrigatorias.atividadesObrigatorias.get(selecionada));
	}

	public void atividade03(InterfaceGrafica gui, UtilizarTelas tela, JLabel minutagem, String selecionada) {
		atividadesObrigatorias.setAtividadeSelecionada(selecionada);
		instrucaoDeDecremento(gui, tela, true, false);
		minutagem.setText(atividadesObrigatorias.atividadesObrigatorias.get(selecionada));
	}

	private void utilizarAtividadeOpcional() {
		atividadesOpcionais = InstanceManager.getAtividadesOpcionais();
	}

	public void atividadeOpcional01(InterfaceGrafica gui, UtilizarTelas tela, JLabel minutagem, String selecionada) {
		utilizarAtividadeOpcional();
		atividadesOpcionais.setAtividadeOpcionalSelecionada(selecionada);
		instrucaoDeDecremento(gui, tela, false, true);
		minutagem.setText(atividadesOpcionais.atividadesOpcionais.get(selecionada));
	}

	public void atividadeOpcional02(InterfaceGrafica gui, UtilizarTelas tela, JLabel minutagem, String selecionada) {
		utilizarAtividadeOpcional();
		atividadesOpcionais.setAtividadeOpcionalSelecionada(selecionada);
		instrucaoDeDecremento(gui, tela, false, true);
		minutagem.setText(atividadesOpcionais.atividadesOpcionais.get(selecionada));
	}

	private void instrucaoDeDecremento(InterfaceGrafica gui, UtilizarTelas tela, boolean obrigatorias,
			boolean opcionais) {
		utilizarAtividadeOpcional();

		int horas = tela.insereDadoInteiro("Insira as horas a serem decrementadas:");
		int minutos = tela.insereDadoInteiro("Insira os minutos a serem decrementados:");
		int segundos = tela.insereDadoInteiro("Insira os segundos a serem decrementados:");

		if (obrigatorias) {
			tempoEmAtividades.decrementarTempoEmAtividades(gui, selecionaAtividades, horas, minutos, segundos);
		} else if (opcionais) {
			atividadesOpcionais.decrementarTempo(gui, tempoEmAtividades, this, horas, minutos, segundos);
		}

	}

	public void setSeTerminouAtividade01(boolean terminouAtividade01) {
		this.terminouAtividade01 = terminouAtividade01;
	}

	public boolean seTerminouAtividade01() {
		return terminouAtividade01;
	}

	public void setSeTerminouAtividade02(boolean terminouAtividade02) {
		this.terminouAtividade02 = terminouAtividade02;
	}

	public boolean seTerminouAtividade02() {
		return terminouAtividade02;
	}

	public void setSeTerminouAtividade03(boolean terminouAtividade03) {
		this.terminouAtividade03 = terminouAtividade03;
	}

	public boolean seTerminouAtividade03() {
		return terminouAtividade03;
	}

	public void setSeTerminouAtividadeOp01(boolean terminouAtividadeOp01) {
		this.terminouAtividadeOp01 = terminouAtividadeOp01;
	}

	public boolean seTerminouAtividadeOp01() {
		return terminouAtividadeOp01;
	}

	public void setSeTerminouAtividadeOp02(boolean terminouAtividadeOp02) {
		this.terminouAtividadeOp02 = terminouAtividadeOp02;
	}

	public boolean seTerminouAtividadeOp02() {
		return terminouAtividadeOp02;
	}

}
