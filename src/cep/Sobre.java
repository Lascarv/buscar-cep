package cep;

import java.awt.Cursor;
import java.awt.Desktop;
import java.awt.EventQueue;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URI;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JEditorPane;
import javax.swing.JLabel;
import javax.swing.JRadioButton;

public class Sobre extends JDialog {

	private static final long serialVersionUID = 1L;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Sobre dialog = new Sobre();
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the dialog.
	 */
	public Sobre() {
		setModal(true);
		setResizable(false);
		setTitle("Sobre");
		setIconImage(Toolkit.getDefaultToolkit().getImage(Sobre.class.getResource("/img/3669170_home_ic_icon (1).png")));
		setBounds(150, 150, 450, 300);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Buscar CEP - Ver. 1.0");
		lblNewLabel.setBounds(20, 25, 128, 14);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("@Laís Santana");
		lblNewLabel_1.setBounds(20, 64, 86, 14);
		getContentPane().add(lblNewLabel_1);
		
		JEditorPane dtrpnSjavhdjhagjvdhsjkvhdsvjsdvjds = new JEditorPane();
		dtrpnSjavhdjhagjvdhsjkvhdsvjsdvjds.setForeground(SystemColor.windowText);
		dtrpnSjavhdjhagjvdhsjkvhdsvjsdvjds.setBackground(SystemColor.inactiveCaptionBorder);
		dtrpnSjavhdjhagjvdhsjkvhdsvjsdvjds.setText("Projeto criado afim de aprender e explorar o plugin window.\r\n\r\nFeito atráves do minicurso do Professor José de Assis.\r\n");
		dtrpnSjavhdjhagjvdhsjkvhdsvjsdvjds.setBounds(224, 11, 176, 90);
		getContentPane().add(dtrpnSjavhdjhagjvdhsjkvhdsvjsdvjds);
		
		JLabel lblNewLabel_2 = new JLabel("WEB Service:");
		lblNewLabel_2.setBounds(20, 124, 86, 14);
		getContentPane().add(lblNewLabel_2);
		
		JLabel lblWebService = new JLabel("republicavirtual.com.br");
		lblWebService.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				link("https://republicavirtual.com.br/");
			}
		});
		lblWebService.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblWebService.setForeground(SystemColor.textHighlight);
		lblWebService.setBounds(103, 124, 145, 14);
		getContentPane().add(lblWebService);
		
		JButton btnLinkedin = new JButton("");
		btnLinkedin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				link("https://www.linkedin.com/in/la%C3%ADs-santana-4657602aa/");
			}
		});
		btnLinkedin.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnLinkedin.setForeground(SystemColor.desktop);
		btnLinkedin.setBackground(SystemColor.controlLtHighlight);
		btnLinkedin.setIcon(new ImageIcon(Sobre.class.getResource("/img/104493_linkedin_icon (1).png")));
		btnLinkedin.setBounds(41, 206, 50, 50);
		getContentPane().add(btnLinkedin);
		
		JRadioButton rdbtnGithub = new JRadioButton("");
		rdbtnGithub.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				link("https://github.com/Lascarv");
			}
		});
		rdbtnGithub.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		rdbtnGithub.setIcon(new ImageIcon(Sobre.class.getResource("/img/211904_social_github_icon (1).png")));
		rdbtnGithub.setBounds(123, 196, 73, 60);
		getContentPane().add(rdbtnGithub);
	
	} // fim do construtor

	private void link(String site) {		
		Desktop desktop = Desktop.getDesktop();
		try {			
			URI uri = new URI (site);
			desktop.browse(uri);
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
}
