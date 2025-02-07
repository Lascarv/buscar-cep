package cep;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.util.Iterator;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import Atxy2k.CustomTextField.RestrictedTextField;


public class Cep extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtCep;
	private JTextField txtEndereco;
	private JTextField txtBairro;
	private JTextField txtCidade;
	private JComboBox cboUf;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Cep frame = new Cep();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Cep() {
		setTitle("Buscar CEP");
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(Cep.class.getResource("/img/3669170_home_ic_icon (1).png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("CEP:");
		lblNewLabel.setBounds(25, 24, 30, 14);
		contentPane.add(lblNewLabel);
		
		txtCep = new JTextField();
		txtCep.setBounds(77, 21, 95, 20);
		contentPane.add(txtCep);
		txtCep.setColumns(10);
		
		JLabel txtEnd = new JLabel("Endereço:");
		txtEnd.setBounds(10, 57, 60, 14);
		contentPane.add(txtEnd);
		
		txtEndereco = new JTextField();
		txtEndereco.setBounds(76, 54, 271, 20);
		contentPane.add(txtEndereco);
		txtEndereco.setColumns(10);
		
		JLabel txtBai = new JLabel("Bairro:");
		txtBai.setBounds(17, 93, 38, 14);
		contentPane.add(txtBai);
		
		txtBairro = new JTextField();
		txtBairro.setBounds(77, 90, 249, 20);
		contentPane.add(txtBairro);
		txtBairro.setColumns(10);
		
		JLabel txtCid = new JLabel("Cidade:");
		txtCid.setBounds(18, 124, 52, 14);
		contentPane.add(txtCid);
		
		txtCidade = new JTextField();
		txtCidade.setBounds(77, 121, 186, 20);
		contentPane.add(txtCidade);
		txtCidade.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("UF:");
		lblNewLabel_4.setBounds(287, 124, 23, 14);
		contentPane.add(lblNewLabel_4);
		
		cboUf = new JComboBox();
		cboUf.setBackground(new Color(240, 255, 240));
		cboUf.setForeground(UIManager.getColor("CheckBox.foreground"));
		cboUf.setModel(new DefaultComboBoxModel(new String[] {"", "AC", "AL", "AP", "AM", "BA", "CE", "DF", "ES", "GO", "MA", "MT", "MS", "MG", "PA", "PB", "PR", "PE", "PI", "RJ", "RN", "RS", "RO", "RR", "SC", "SP", "SE", "TO"}));
		cboUf.setBounds(309, 120, 52, 22);
		contentPane.add(cboUf);
		
		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.setBounds(24, 211, 89, 23);
		contentPane.add(btnLimpar);
		
		JButton btnCep = new JButton("Buscar");
		btnCep.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(txtCep.getText().equals ("")) {
					JOptionPane.showMessageDialog(null, "Informe o CEP");
				} else {
					buscarCep();
				}
			}
		});
		btnCep.setBounds(194, 20, 81, 23);
		contentPane.add(btnCep);
		
		JButton btnSobre = new JButton("");
		btnSobre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Sobre sobre = new Sobre();
				sobre.setVisible(true);
			}
		});
		btnSobre.setToolTipText("Sobre");
		btnSobre.setIcon(new ImageIcon(Cep.class.getResource("/img/info1-512 (1) (2).png")));
		btnSobre.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnSobre.setBorder(null);
		btnSobre.setBackground(SystemColor.control);
		btnSobre.setBounds(388, 2, 36, 36);
		contentPane.add(btnSobre);
		
		/* Uso da biblioteca Atxy2k para validação do campo txtCep */
		RestrictedTextField validar = new RestrictedTextField (txtCep);
		validar.setOnlyNums(true);
		validar.setLimit(8);
	} 
	
	private void buscarCep() {
		String logradouro = "";
		String tipoLogradouro = "";
		String resultado = null;
		String cep = txtCep.getText();
		try {
			URL url = new URL("http://cep.republicavirtual.com.br/web_cep.php?cep=" + cep + "&formato=xml");
			SAXReader xml = new SAXReader();
			Document documento = xml.read(url);
			Element root = documento.getRootElement();
			for (Iterator<Element> it = root.elementIterator(); it.hasNext();) {
		        Element element = it.next();
		        if (element.getQualifiedName().equals("cidade")) {
					txtCidade.setText(element.getText());		        	
		        }
		        if (element.getQualifiedName().equals("bairro")) {
					txtBairro.setText(element.getText());		        	
		        }
		        if (element.getQualifiedName().equals("uf")) {
		        	cboUf.setSelectedItem(element.getText());
		        }
		        if (element.getQualifiedName().equals("tipo_logradouro")) {
		        	tipoLogradouro = element.getText();
		        }
		        if (element.getQualifiedName().equals("logradouro")) {
		        	logradouro = element.getText();
		        }
			} 
			txtEndereco.setText(tipoLogradouro + "" + logradouro);
		
			} catch (Exception e) {
			System.out.println(e);
		}
	}
}
