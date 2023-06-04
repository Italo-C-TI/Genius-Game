package view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;


import objects.ChampionShip;
import objects.Player;

import java.awt.Color;
import javax.swing.UIManager;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;


public class PlayerRegistration extends JFrame {


	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
    ArrayList<Player> players = new ArrayList<Player>();


	public PlayerRegistration(ChampionShip championship) {
		setResizable(false);
		setTitle("Novo Campeonato");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 400,200);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 51));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Titulo do campeonato");
		lblNewLabel.setForeground(UIManager.getColor("Button.highlight"));
		lblNewLabel.setBounds(10, 11, 143, 25);
		contentPane.add(lblNewLabel);
		
		JTextField titleChampionshipText = new JTextField();
		titleChampionshipText.setBounds(165, 10, 130, 26);
		contentPane.add(titleChampionshipText);
		
		JLabel registerLabel = new JLabel("Cadastre os jogadores");
		registerLabel.setForeground(Color.WHITE);
		registerLabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 21));
		registerLabel.setBounds(6, 36, 204, 25);
		contentPane.add(registerLabel);
		
		JLabel nicknameLabel = new JLabel("Nome / Apelido");
		nicknameLabel.setForeground(Color.WHITE);
		nicknameLabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 13));
		nicknameLabel.setBounds(20, 67, 106, 14);
		contentPane.add(nicknameLabel);
			
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 93, 267, 73);
		contentPane.add(scrollPane);	
		JTextArea playersTextArea  = new JTextArea();
		scrollPane.setViewportView(playersTextArea);
			
		JButton registerButton = new JButton("Cadastrar");
		registerButton.setForeground(UIManager.getColor("CheckBoxMenuItem.acceleratorSelectionForeground"));
		registerButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
		        try {
		        	String titleChampionship = titleChampionshipText.getText();
		        	String[] listPlayersText = playersTextArea.getText().split("/n");
		        	int quantPlayers = playersTextArea.getLineCount();
		        	
		        	if(titleChampionship.isEmpty()) {
		        		JOptionPane.showMessageDialog(null, "É necessário por um titulo para o campeonato");
		        		return;
		        	}
		        	
		        	
		        	if(quantPlayers < 2) {
		        		JOptionPane.showMessageDialog(null, "É necessário ter pelo menos 2 jogadores");
		        		return;
		        	}
					
			         for(String nickname : listPlayersText){
						players.add(new Player(nickname));		
			        }
			         System.out.println(players);
			         
			        championship.setTitle(titleChampionshipText.getText().trim());
			        championship.setPlayers(players);
			         
			        System.out.println(championship.toString());    
			       
			        JOptionPane.showMessageDialog(null, "Campeonato criado com sucesso!");	
			    	dispose();
					
		        } catch (ArrayIndexOutOfBoundsException err) {
		        	System.err.println(err.getMessage());
		        }
		            
			}
				
		});
		
		registerButton.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 16));
		registerButton.setBounds(299, 93, 95, 23);
		contentPane.add(registerButton);
		
		
		JButton backButton = new JButton("Voltar");
		backButton.setForeground(UIManager.getColor("CheckBoxMenuItem.acceleratorSelectionForeground"));
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		backButton.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 16));
		backButton.setBounds(299, 130, 95, 23);
		contentPane.add(backButton);
		
		
		JLabel lblNewLabel_1 = new JLabel("Um jogador por linha");
		lblNewLabel_1.setForeground(UIManager.getColor("Button.select"));
		lblNewLabel_1.setBounds(222, 42, 157, 16);
		contentPane.add(lblNewLabel_1);	
	}

	public static void main(String[] args, ChampionShip championship) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PlayerRegistration frame = new PlayerRegistration(championship);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}

