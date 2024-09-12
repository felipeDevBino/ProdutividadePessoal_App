package utilizacaodetelas;

import javax.swing.JOptionPane;

public class UtilizarTelas {

	public void retornaTextoEmTela(String texto) {
		JOptionPane.showMessageDialog(null, texto, "Info", JOptionPane.INFORMATION_MESSAGE);
	}

	public String insereDadoDeTexto(String texto) {
		return JOptionPane.showInputDialog(texto);
	}

	public int insereDadoInteiro(String texto) {
		return Integer.parseInt(JOptionPane.showInputDialog(texto));
	}

}
