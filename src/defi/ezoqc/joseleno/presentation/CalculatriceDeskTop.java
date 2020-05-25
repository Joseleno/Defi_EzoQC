package defi.ezoqc.joseleno.presentation;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import defi.ezoqc.joseleno.domain.service.CalculatriceService;

public class CalculatriceDeskTop extends JFrame {

	private CalculatriceService calculatriceService;

	private JLabel lbExpression;
	private JLabel lbResultat;
	private JTextField tfExpression;
	private JTextField tfResultat;
	private JButton btCalculer;
	private JButton btNettoyer;

	public JLabel getLbExpression() {
		return this.lbExpression;
	}

	public JLabel getLbResultat() {
		return this.lbResultat;
	}

	public JTextField getTfExpression() {
		return this.tfExpression;
	}

	public JTextField getTfResultat() {
		return this.tfResultat;
	}

	public JButton getBtCalculer() {
		return this.btCalculer;
	}

	public JButton getBtNettoyer() {
		return this.btCalculer;
	}

	public void iniciarComponentes() {
		this.setTitle("Calculatrice - EzoQC");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setSize(300, 210);
		this.setLocationRelativeTo(null);
		this.setLayout(new GridLayout(4, 2));
		this.setVisible(true);

		this.lbExpression = new JLabel("Expression");
		this.lbResultat = new JLabel("Resultat");
		this.tfExpression = new JTextField();
		this.tfResultat = new JTextField();
		this.btCalculer = new JButton("Calculer");
		this.btNettoyer = new JButton("Nettoyer");

		this.lbExpression.setBounds(20, 20, 150, 20);

		this.tfExpression.setBounds(20, 40, 260, 20);
		this.lbResultat.setBounds(20, 80, 150, 20);
		this.tfResultat.setBounds(20, 100, 260, 20);
		this.btCalculer.setBounds(160, 140, 100, 20);
		this.btNettoyer.setBounds(40, 140, 100, 20);

		this.add(lbExpression);
		this.add(tfExpression);
		this.add(lbResultat);
		this.add(tfResultat);
		this.add(btCalculer);
		this.add(btNettoyer);

		this.tfExpression.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				habilitarBotoes();
			}
		});

		this.btNettoyer.addActionListener(ae -> {
			NettoyerDados();
		});

		this.btCalculer.addActionListener(ae -> {
			String Resultat = calculatriceService.calculer(tfExpression.getText());
			this.tfResultat.setText(Resultat);
		});
	}

	public CalculatriceDeskTop() {
		calculatriceService = new CalculatriceService();
		iniciarComponentes();
		desabilitarBotoes();
	}

	private void desabilitarBotoes() {
		this.btCalculer.setEnabled(false);
		this.btNettoyer.setEnabled(false);
	}

	private void habilitarBotoes() {
		this.btCalculer.setEnabled(true);
		this.btNettoyer.setEnabled(true);
	}

	private void NettoyerDados() {
		this.tfExpression.setText(null);
		this.tfResultat.setText(null);
	}

}
