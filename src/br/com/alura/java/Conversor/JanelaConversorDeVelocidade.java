package br.com.alura.java.Conversor;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class JanelaConversorDeVelocidade extends JFrame implements ActionListener {

	private static final long serialVersionUID = -1023047450548389162L;
	String valor;
	JComboBox comboBox;
	JButton botaoOk, botaoCancelar;

	JanelaConversorDeVelocidade(String valor){
		this.valor = valor;
		
		JLabel label = new JLabel("Escolha uma opção de conversão:");		
		String[] tipo = {"Converter de Quilometro por hora para Milha por hora", "Converter de Quilometro por hora para Pes por segundo",
				"Converter de Quilometro por hora para Metro por segundo", "Converter de Quilometro por hora para Nó",
				"Converter de Milha por hora para Quilometro por hora", "Converter de Pes por segundo para Quilometro por hora",
				"Converter de Metro por segundo para Quilometro por hora", "Converter de Nó para Quilometro por hora"};
		comboBox = new JComboBox(tipo);		
		botaoOk = new JButton("OK");
		botaoCancelar = new JButton("Cancelar");
		
		JPanel painelPrincipal = new JPanel();
	    painelPrincipal.setLayout((LayoutManager) new BoxLayout(painelPrincipal, BoxLayout.Y_AXIS));
	    JPanel painelTopo = new JPanel();
	    JPanel painelFundo = new JPanel();
	    painelTopo.setBorder(BorderFactory.createEmptyBorder(0, 60 , 0, 60));
	    painelTopo.setLayout(new GridLayout(0, 1));
	    painelFundo.setBorder(BorderFactory.createEmptyBorder(10, 120 , 10, 120));
	    painelPrincipal.add(painelTopo);
	    painelPrincipal.add(painelFundo);
		
	    painelTopo.add(label);
	    painelTopo.add(comboBox);
	    painelFundo.add(botaoOk);
	    painelFundo.add(botaoCancelar);
		comboBox.addActionListener(this);
		botaoOk.addActionListener(this);
		botaoCancelar.addActionListener(this);
		
		this.add(painelPrincipal, BorderLayout.CENTER);
		this.setTitle("Velocidade");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setResizable(false);
		this.pack();
        this.setLocationRelativeTo( null );
		this.setVisible(true);		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == botaoOk) {
			ConversorVelocidade conversor = new ConversorVelocidade(valor) {};
			String valorConvertido = null;
			
			switch (comboBox.getSelectedIndex()) {
			case 0: {
				valorConvertido = conversor.CalculaConversao(0);	
				break;
			}
			case 1: {
				valorConvertido = conversor.CalculaConversao(1);
				break;				
			}
			case 2: {
				valorConvertido = conversor.CalculaConversao(2);	
				break;			
			}
			case 3: {
				valorConvertido = conversor.CalculaConversao(3);	
				break;			
			}
			case 4: {
				valorConvertido = conversor.CalculaConversao(4);	
				break;			
			}
			case 5: {
				valorConvertido = conversor.CalculaConversao(5);	
				break;			
			}
			case 6: {
				valorConvertido = conversor.CalculaConversao(6);
				break;				
			}
			case 7: {
				valorConvertido = conversor.CalculaConversao(7);
				break;				
			}
			}			
			
			
			this.dispose();
			new JanelaMostrarConversaoVelocidade(valorConvertido);		
		}
		
		if (e.getSource() == botaoCancelar) {
			this.dispose();
			new JanelaPegarValorVelocidade();
		}
		
	}
}
