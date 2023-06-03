package view;
import javax.swing.*;

import objects.Player;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


public class PlayGenius extends JFrame {
    private boolean gameStarted;
    private int speedGame;
    ArrayList<Integer> colorsList = new ArrayList<Integer>();
    ArrayList<Player> players = new ArrayList<Player>();
    
    public PlayGenius() {
        gameStarted = false;
        speedGame = 1;


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
				new PlayerRegistration().setVisible(true); 
        		
        	}
        });
        getContentPane().add(starterChampionshipButton);
        
        JButton shutChampionShipButton = new JButton("Encerrar campeonato");
        shutChampionShipButton.setBounds(192, 381, 170, 29);
        getContentPane().add(shutChampionShipButton);
        
        JLabel gameScoreLabel = new JLabel("Placar :");
        gameScoreLabel.setBounds(510, 43, 86, 16);
        getContentPane().add(gameScoreLabel);




    }

//    @Override
//    public void actionPerformed(ActionEvent e) {
//        if (e.getSource() == startButton) {
//            if (!gameStarted) {
//                // Lógica para iniciar o campeonato
//                gameStarted = true;
//                players.clear();
//                // ...
//            }
//        } else if (e.getSource() == endButton) {
//            if (gameStarted) {
//                // Lógica para encerrar o campeonato e exibir o relatório
//                gameStarted = false;
//                // ...
//            }
//        } else if (e.getSource() == playerTurnButton) {
//            if (gameStarted && currentPlayer != null) {
//                // Lógica para iniciar a vez do jogador atual
//                // ...
//            }
//        }
//    }

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


