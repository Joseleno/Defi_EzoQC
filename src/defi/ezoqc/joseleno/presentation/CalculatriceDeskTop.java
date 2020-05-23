package defi.ezoqc.joseleno.presentation;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import defi.ezoqc.joseleno.domain.service.CalculatriceService;

public class CalculatriceDeskTop extends JFrame {

		    private CalculatriceService calculatriceService;

		    private JLabel lbExpressao;
		    private JLabel lbResultado;
		    private JTextField tfExpressao;
		    private JTextField tfResultado;
		    private JButton btCalcular;
		    private JButton btLimpar;

		    public JLabel getLbExpressao() {
		        return this.lbExpressao;
		    }

		    public JLabel getLbResultado() {
		        return this.lbResultado;
		    }

		    public JTextField getTfExpressao() {
		        return this.tfExpressao;
		    }

		    public JTextField getTfResultado() {
		        return this.tfResultado;
		    }


		    public JButton getBtCalcular() {
		        return this.btCalcular;
		    }

		    public JButton getBtLimpar() {
		        return this.btCalcular;
		    }

		    public void iniciarComponentes() {
		        this.setTitle("Calculadora");
		        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		        this.setResizable(false);
		        this.setSize(300, 210);
		        this.setLocationRelativeTo(null);
		        this.setLayout(null);
		        this.setVisible(true);

		        this.lbExpressao = new JLabel("Expressão");
		        this.lbResultado = new JLabel("Resultado");
		        this.tfExpressao = new JTextField();
		        this.tfResultado = new JTextField();
		        this.btCalcular = new JButton("Calcular");
		        this.btLimpar = new JButton("Limpar");

		        this.lbExpressao.setBounds(20, 20, 150, 20);
		        this.tfExpressao.setBounds(20, 40, 260, 20);
		        this.lbResultado.setBounds(20, 80, 150, 20);
		        this.tfResultado.setBounds(20, 100, 260, 20);
		        this.btCalcular.setBounds(160, 140, 100, 20);
		        this.btLimpar.setBounds(40, 140, 100, 20);

		        this.tfResultado.setEnabled(false);

		        this.add(lbExpressao);
		        this.add(tfExpressao);
		        this.add(lbResultado);
		        this.add(tfResultado);
		        this.add(btCalcular);
		        this.add(btLimpar);

		        this.tfExpressao.addKeyListener(new KeyAdapter() {
		            @Override
		            public void keyPressed(KeyEvent e){
		                habilitarBotoes();
		            }
		        });

		        this.btLimpar.addActionListener(ae -> {
		                limparDados();
		        });

		        this.btCalcular.addActionListener(ae -> {
		            String resultado = calculatriceService.calcular(tfExpressao.getText());
		            this.tfResultado.setText(resultado);
		        });
		    }

		    public CalculatriceDeskTop() {
		        calculatriceService = new CalculatriceService();
		        iniciarComponentes();
		        desabilitarBotoes();
		    }

		    private void desabilitarBotoes() {
		        this.btCalcular.setEnabled(false);
		        this.btLimpar.setEnabled(false);
		    }

		    private void habilitarBotoes() {
		        this.btCalcular.setEnabled(true);
		        this.btLimpar.setEnabled(true);
		    }

		    private void limparDados() {
		        this.tfExpressao.setText(null);
		        this.tfResultado.setText(null);
		    }

}
