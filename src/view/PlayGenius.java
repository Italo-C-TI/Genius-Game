package view;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import objects.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


public class PlayGenius extends JFrame {
	private static final long serialVersionUID = 1L;
	//private Boolean gameStarted;
    private Integer speedGame;;
    ArrayList<Integer> colorsList = new ArrayList<Integer>();
    private JTable table;
	public JLabel championshipLabel = new JLabel("Campeonato: ");
	
	@SuppressWarnings("serial")
	public DefaultTableModel model = new DefaultTableModel(){ public boolean isCellEditable(int rowIndex, int mColIndex){ return false; } };
    
    public PlayGenius() {
       // gameStarted = false;
        speedGame = 1;
        Championship championship = new Championship(null, null);
        ChampionshipRegistration championshipRegistration = new ChampionshipRegistration(championship); 


        setVisible(true);
        setTitle("Genius Game");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);
        
        JButton green = new JButton("Verde");
        green.setBounds(74, 231, 128, 95);
        green.setBackground(Color.green);
        getContentPane().add(green);
        
        JButton red = new JButton("Vermelho");
        red.setBackground(Color.red);
        red.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	}
        });
        red.setBounds(74, 76, 128, 95);
        getContentPane().add(red);
        
        
        JButton blue = new JButton("Azul");
        blue.setBackground(Color.blue);
        blue.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	}
        });
        blue.setBounds(337, 76, 128, 95);
        getContentPane().add(blue);
        
        JButton yellow = new JButton("Amarelo");
        yellow.setBackground(Color.yellow);
        yellow.setBounds(337, 231, 128, 95);
        getContentPane().add(yellow);
        
        JButton startMatch = new JButton("Iniciar Partida");
        startMatch.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	}
        });
        startMatch.setBounds(214, 220, 117, 29);
        getContentPane().add(startMatch);
        
        
        JLabel speedLabel = new JLabel("Velocidade: "  + speedGame);
        speedLabel.setBounds(231, 165, 86, 16);
        getContentPane().add(speedLabel);
        setBounds(300, 200 , 700, 500);
        
        JButton speedButton = new JButton("+");
        speedButton.setFont(new Font("Arial",Font.BOLD, 40));
        speedButton.setBounds(254, 189, 37, 29);
        getContentPane().add(speedButton);
        speedButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		if(speedGame >= 3) {
        			speedGame = 1;
        		}else {
        			speedGame++;
        		}
        		speedLabel.setText("Velocidade: "  + speedGame);
        	}
        });
        
        JButton starterChampionshipButton = new JButton("Iniciar campeonato");

        starterChampionshipButton.setBounds(192, 350, 170, 29);
        starterChampionshipButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		showRegisterChamphioship(championshipRegistration);
        	}
        });
        getContentPane().add(starterChampionshipButton);
        
        JButton shutChampionShipButton = new JButton("Encerrar campeonato");
        shutChampionShipButton.setBounds(192, 381, 170, 29);
        getContentPane().add(shutChampionShipButton);
        
        JLabel gameScoreLabel = new JLabel("Placar : \n");
        gameScoreLabel.setHorizontalAlignment(SwingConstants.LEFT);
        gameScoreLabel.setBounds(477, 43, 170, 34);
        getContentPane().add(gameScoreLabel);
        
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setEnabled(false);
        scrollPane.setBounds(477, 89, 205, 219);
        getContentPane().add(scrollPane);
        
        championshipLabel.setBounds(20, 23, 433, 16);
        getContentPane().add(championshipLabel);
        
        table = new JTable();
        scrollPane.setViewportView(table);
        
        Object[] columns = {"Id","Nome","Pontos"};
        
        model.setColumnIdentifiers(columns);
        table.setModel(model);
        table.setForeground(Color.black);
        table.setRowHeight(30);
        table.setEnabled(false);
        
    }

        
    public void showRegisterChamphioship(ChampionshipRegistration championshipRegistration) {
    	championshipRegistration.showScreenPlayGenius(this);	
    }
    

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PlayGenius frame = new PlayGenius();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}


