package gui.funcoesgui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;

import atividades.AtividadesObrigatorias;
import atividades.AtividadesOpcionais;
import atividades.SelecionaAtividades;
import gui.InterfaceGrafica;
import instancias.InstanceManager;
import utilizacaodetelas.UtilizarTelas;

public class AplicarAtividade {

	private AtividadesObrigatorias atividadesObrigatorias = InstanceManager.getAtividadesObrigatorias();
	private AtividadesOpcionais atividadesOpcionais = InstanceManager.getAtividadesOpcionais();
	private SelecionaAtividades selecionaAtividades = InstanceManager.getSelecionaAtividades();
	private DiminuirTempo diminuir = InstanceManager.getDiminuirTempo();
	private UtilizarTelas tela;
	private String selecionada;
	private final String condicaoParaAcabar = "0H: 0M: 0S.";

	public AplicarAtividade() {
		tela = new UtilizarTelas();
	}

	public void aplicarAtividade01(InterfaceGrafica gui, JLabel nome, JLabel minutagem) {
		JButton atividade01 = new JButton("Adicionar");
		atividade01.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (atividade01.getText().equals("Adicionar")) {
					mostraAtividade01(atividade01, nome, minutagem);
				} else if (atividade01.getText().equals("Diminuir")) {
					selecionada = selecionaAtividades.getAtividade01();
					if (atividadesObrigatorias.atividadesObrigatorias.get(selecionada).equals(condicaoParaAcabar)) {
						tela.retornaTextoEmTela("Atenção! Você já concluiu essa atividade no dia de hoje.");
						return;
					}
					diminuir.atividade01(gui, tela, minutagem, selecionada);

				}
			}
		});
		atividade01.setBounds(49, 137, 89, 23);
		gui.addConteudoFrame(atividade01);

		if (diminuir.seTerminouAtividade01()) {
			nome.setText("");
			minutagem.setText("");
			atividade01.setText("Adicionar");
		}
	}

	public void aplicarAtividade02(InterfaceGrafica gui, JLabel nome, JLabel minutagem) {
		JButton atividade02 = new JButton("Adicionar");
		atividade02.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (atividade02.getText().equals("Adicionar")) {
					mostraAtividade02(atividade02, nome, minutagem);
				} else if (atividade02.getText().equals("Diminuir")) {
					selecionada = selecionaAtividades.getAtividade02();
					if (atividadesObrigatorias.atividadesObrigatorias.get(selecionada).equals(condicaoParaAcabar)) {
						tela.retornaTextoEmTela("Atenção! Você já concluiu essa atividade no dia de hoje.");
						return;
					}
					diminuir.atividade02(gui, tela, minutagem, selecionada);
				}
			}
		});
		atividade02.setBounds(173, 137, 89, 23);
		gui.addConteudoFrame(atividade02);

		if (diminuir.seTerminouAtividade02()) {
			nome.setText("");
			minutagem.setText("");
			atividade02.setText("Adicionar");
		}
	}

	public void aplicarAtividade03(InterfaceGrafica gui, JLabel nome, JLabel minutagem) {
		JButton atividade03 = new JButton("Adicionar");
		atividade03.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (atividade03.getText().equals("Adicionar")) {
					mostraAtividade03(atividade03, nome, minutagem);
				} else if (atividade03.getText().equals("Diminuir")) {
					selecionada = selecionaAtividades.getAtividade03();
					if (atividadesObrigatorias.atividadesObrigatorias.get(selecionada).equals(condicaoParaAcabar)) {
						tela.retornaTextoEmTela("Atenção! Você já concluiu essa atividade no dia de hoje.");
						return;
					}
					diminuir.atividade03(gui, tela, minutagem, selecionada);
				}
			}
		});
		atividade03.setBounds(299, 137, 89, 23);
		gui.addConteudoFrame(atividade03);

		if (diminuir.seTerminouAtividade03()) {
			nome.setText("");
			minutagem.setText("");
			atividade03.setText("Adicionar");
		}
	}

	public void aplicarAtividadeOpcional01(InterfaceGrafica gui, JLabel nome, JLabel minutagem) {
		JButton atividadeOp01 = new JButton("Adicionar");
		atividadeOp01.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (atividadeOp01.getText().equals("Adicionar")) {
					selecionaAtividades
							.setAtividadeOpcional01(atividadesOpcionais.getNovaAtividadeOpcional(true, false));
					selecionaAtividades.selecionarAtividadeOpcional01(atividadesOpcionais);
					mostraAtividadeOpcional01(atividadeOp01, nome, minutagem);

				} else if (atividadeOp01.getText().equals("Diminuir")) {
					selecionada = selecionaAtividades.getAtividadeOpcional01();
					diminuir.atividadeOpcional01(gui, tela, minutagem, selecionada);

					if (diminuir.seTerminouAtividadeOp01()) {
						atividadeOp01.setText("Adicionar");
						diminuir.setSeTerminouAtividadeOp01(false);
					}
				}
			}
		});
		atividadeOp01.setBounds(49, 277, 89, 23);
		gui.addConteudoFrame(atividadeOp01);
	}

	public void aplicarAtividadeOpcional02(InterfaceGrafica gui, JLabel nome, JLabel minutagem) {
		JButton atividadeOp02 = new JButton("Adicionar");
		atividadeOp02.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (atividadeOp02.getText().equals("Adicionar")) {
					selecionaAtividades
							.setAtividadeOpcional02(atividadesOpcionais.getNovaAtividadeOpcional(false, true));
					selecionaAtividades.selecionarAtividadeOpcional02(atividadesOpcionais);
					mostraAtividadeOpcional02(atividadeOp02, nome, minutagem);

				} else if (atividadeOp02.getText().equals("Diminuir")) {
					selecionada = selecionaAtividades.getAtividadeOpcional02();
					diminuir.atividadeOpcional02(gui, tela, minutagem, selecionada);

					if (diminuir.seTerminouAtividadeOp02()) {
						atividadeOp02.setText("Adicionar");
						diminuir.setSeTerminouAtividadeOp02(false);
					}
				}
			}
		});
		atividadeOp02.setBounds(299, 277, 89, 23);
		gui.addConteudoFrame(atividadeOp02);
	}

	private void mostraAtividade01(JButton atividade, JLabel nome, JLabel minutagem) {
		selecionada = selecionaAtividades.selecionarAtividade01(atividadesObrigatorias);

		if (!selecionaAtividades.seSelecionouAtividade01()) {
			nome.setText(selecionada);
			minutagem.setText(atividadesObrigatorias.atividadesObrigatorias.get(selecionada));
			atividade.setText("Diminuir");
		}
	}

	private void mostraAtividade02(JButton atividade, JLabel nome, JLabel minutagem) {
		selecionada = selecionaAtividades.selecionarAtividade02(atividadesObrigatorias);

		if (!selecionaAtividades.seSelecionouAtividade02()) {
			nome.setText(selecionada);
			minutagem.setText(atividadesObrigatorias.atividadesObrigatorias.get(selecionada));
			atividade.setText("Diminuir");
		}
	}

	private void mostraAtividade03(JButton atividade, JLabel nome, JLabel minutagem) {
		selecionada = selecionaAtividades.selecionarAtividade03(atividadesObrigatorias);

		if (!selecionaAtividades.seSelecionouAtividade03()) {
			nome.setText(selecionada);
			minutagem.setText(atividadesObrigatorias.atividadesObrigatorias.get(selecionada));
			atividade.setText("Diminuir");
		}
	}

	private void mostraAtividadeOpcional01(JButton atividade, JLabel nome, JLabel minutagem) {
		selecionada = selecionaAtividades.selecionarAtividadeOpcional01(atividadesOpcionais);
		nome.setText(selecionada);
		minutagem.setText(atividadesOpcionais.atividadesOpcionais.get(selecionada));
		atividade.setText("Diminuir");
	}

	private void mostraAtividadeOpcional02(JButton atividade, JLabel nome, JLabel minutagem) {
		selecionada = selecionaAtividades.selecionarAtividadeOpcional02(atividadesOpcionais);
		nome.setText(selecionada);
		minutagem.setText(atividadesOpcionais.atividadesOpcionais.get(selecionada));
		atividade.setText("Diminuir");
	}

}
