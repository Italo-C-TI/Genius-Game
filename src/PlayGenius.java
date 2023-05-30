import javax.swing.*;

import objects.Player;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;


public class PlayGenius implements ActionListener {
    private JFrame frame;
    private JButton startButton;
    private JButton endButton;
    private JButton playerTurnButton;
    private JLabel scoreLabel;
    private List<Player> players;
    private Player currentPlayer;
    private boolean gameStarted;

    public PlayGenius() {
        players = new ArrayList<>();
        currentPlayer = null;
        gameStarted = false;

        // Inicialização da interface gráfica
        frame = new JFrame("Genius Game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1200, 800);
       // frame.setLayout(new BorderLayout());

        JPanel buttonPanel = new JPanel();
        startButton = new JButton("Iniciar Campeonato");
        startButton.addActionListener(this);
        buttonPanel.add(startButton);

        endButton = new JButton("Encerrar Campeonato");
        endButton.addActionListener(this);
        buttonPanel.add(endButton);

        playerTurnButton = new JButton("Iniciar Vez do Jogador");
        playerTurnButton.addActionListener(this);
        buttonPanel.add(playerTurnButton);

        scoreLabel = new JLabel("Placar");
        buttonPanel.add(scoreLabel);

        frame.add(buttonPanel, BorderLayout.CENTER);
        frame.pack();
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == startButton) {
            if (!gameStarted) {
                // Lógica para iniciar o campeonato
                gameStarted = true;
                players.clear();
                // ...
            }
        } else if (e.getSource() == endButton) {
            if (gameStarted) {
                // Lógica para encerrar o campeonato e exibir o relatório
                gameStarted = false;
                // ...
            }
        } else if (e.getSource() == playerTurnButton) {
            if (gameStarted && currentPlayer != null) {
                // Lógica para iniciar a vez do jogador atual
                // ...
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new PlayGenius();
            }
        });
    }
}


