package view;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.Random;

import objects.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PlayGenius extends JFrame {
	private static final long serialVersionUID = 1L;
	//private Boolean gameStarted;
	private Boolean championshipStarted = false;
    private Integer speedGame;
    private Integer dificultyGame;
    private Timer patternTimer;
    private int patternIndex;
    private ArrayList<Integer> pattern;
    private JButton redButton ;
	private JButton blueButton;
    private JButton greenButton;
    private JButton yellowButton;
    private JTable table;
	public JLabel championshipLabel = new JLabel("Campeonato: ");
	private JLabel dificultyLabel;
	private JLabel speedLabel;
	
	
	
	@SuppressWarnings("serial")
	public DefaultTableModel model = new DefaultTableModel(){ public boolean isCellEditable(int rowIndex, int mColIndex){ return false; } };
    
    public PlayGenius() {
    	getContentPane().setBackground(Color.DARK_GRAY);
       // gameStarted = false;
        speedGame = 1;
        dificultyGame = 1;
        Championship championship = new Championship(null, null);
        ChampionshipRegistration championshipRegistration = new ChampionshipRegistration(championship); 


        setVisible(true);
        setTitle("Genius Game");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);
        
        greenButton = new JButton("Verde");
        greenButton.setContentAreaFilled(false);
        greenButton.setOpaque(true);
        greenButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
            	greenButton.setBackground(Color.GREEN);
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            	greenButton.setBackground(Color.WHITE);
            }
        });
        greenButton.setForeground(Color.GREEN);
        greenButton.setBounds(139, 213, 128, 95);
        getContentPane().add(greenButton);
        
        redButton = new JButton("Vermelho");   
        redButton.setContentAreaFilled(false);
        redButton.setOpaque(true);
        redButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
            	redButton.setBackground(Color.RED);
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            	redButton.setBackground(Color.WHITE);
            }
        });
        redButton.setForeground(Color.RED);
        redButton.setBounds(139, 113, 128, 95);
        getContentPane().add(redButton);
        
        
        blueButton = new JButton("Azul");
        blueButton.setContentAreaFilled(false);
        blueButton.setOpaque(true);
        blueButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
            	blueButton.setBackground(Color.BLUE);
            	
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            	blueButton.setBackground(Color.WHITE);
            }
        });
        blueButton.setBorder(UIManager.getBorder("EditorPane.border"));
        blueButton.setForeground(Color.BLUE);
        blueButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	}
        });
        blueButton.setBounds(279, 113, 128, 95);
        getContentPane().add(blueButton);
        
        yellowButton = new JButton("Amarelo");
        yellowButton.setContentAreaFilled(false);
        yellowButton.setOpaque(true);
        yellowButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
            	yellowButton.setBackground(Color.YELLOW);
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            	yellowButton.setBackground(Color.WHITE);
            }
        });
        yellowButton.setForeground(new Color(255, 153, 51));
        yellowButton.setBounds(279, 213, 128, 95);
        getContentPane().add(yellowButton);
        
        JButton startMatch = new JButton("Iniciar");
        startMatch.setForeground(Color.BLACK);
        startMatch.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		startPattern();
        	}
        });
        startMatch.setBounds(10, 265, 117, 29);
        getContentPane().add(startMatch);
        
        
        speedLabel = new JLabel("Velocidade: "  + speedGame);
        speedLabel.setForeground(Color.WHITE);
        speedLabel.setBounds(16, 97, 86, 16);
        getContentPane().add(speedLabel);
        setBounds(300, 200 , 700, 500);
        
        JButton speedButton = new JButton("+");
        speedButton.setFont(new Font("Arial",Font.BOLD, 40));
        speedButton.setBounds(41, 121, 37, 29);
        getContentPane().add(speedButton);
        speedButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		handleSpeed();
        	}
        });
        
        JButton starterChampionshipButton = new JButton("Novo campeonato");
        starterChampionshipButton.setForeground(Color.BLACK);

        starterChampionshipButton.setBounds(192, 350, 189, 29);
        starterChampionshipButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		if(championshipStarted) {
	        		JOptionPane.showMessageDialog(null, "É necessário encerrar o campeonato atual antes de iniciar outro!");
	        		return;
        		}
        		showRegisterChamphioship(championshipRegistration);
        	}
        });
        getContentPane().add(starterChampionshipButton);
        
        JButton shutChampionShipButton = new JButton("Encerrar campeonato");
        shutChampionShipButton.setBackground(Color.WHITE);
        shutChampionShipButton.setForeground(Color.BLACK);
        
        shutChampionShipButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		setChampionshipStarted(false);
        	}
        });
        shutChampionShipButton.setBounds(192, 381, 189, 29);
        getContentPane().add(shutChampionShipButton);
        
        dificultyLabel = new JLabel("Dificuldade: "+ dificultyGame);
        dificultyLabel.setForeground(Color.WHITE);
        dificultyLabel.setBounds(16, 179, 111, 16);
        getContentPane().add(dificultyLabel);
        
        JButton dificultyButton = new JButton("+");
        dificultyButton.setFont(new Font("Arial", Font.BOLD, 40));
        dificultyButton.setBounds(41, 208, 37, 29);
        dificultyButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		handleDificulty();
        	}
        });
        getContentPane().add(dificultyButton);
        
        JLabel lblVezDoJogador = new JLabel("Vez do jogador: ");
        lblVezDoJogador.setForeground(Color.WHITE);
        lblVezDoJogador.setBounds(20, 52, 433, 24);
        getContentPane().add(lblVezDoJogador);
        
        JLabel gameScoreLabel = new JLabel("Placar : \n");
        gameScoreLabel.setForeground(Color.WHITE);
        gameScoreLabel.setHorizontalAlignment(SwingConstants.LEFT);
        gameScoreLabel.setBounds(477, 43, 170, 34);
        getContentPane().add(gameScoreLabel);
        
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBackground(Color.GRAY);
        scrollPane.setEnabled(false);
        scrollPane.setBounds(477, 89, 205, 219);
        getContentPane().add(scrollPane);
        championshipLabel.setForeground(Color.WHITE);
        
        championshipLabel.setBounds(20, 23, 433, 24);
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

    
    private void startPattern() {
	    pattern = generateRandomPattern();
	    System.err.println(pattern);
	    patternIndex = 0;
	    final Timer[] clearTimer = new Timer[1];

	    patternTimer = new Timer(2000 / speedGame, new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	            if (patternIndex < pattern.size()) {
	                int colorIndex = pattern.get(patternIndex);

	                switch (colorIndex) {
	                    case 0:
	                        redButton.setBackground(Color.RED);
	                        break;
	                    case 1:
	                        blueButton.setBackground(Color.BLUE);
	                        break;
	                    case 2:
	                        greenButton.setBackground(Color.GREEN);
	                        break;
	                    case 3:
	                        yellowButton.setBackground(Color.YELLOW);
	                        break;
	                    default:
	                        throw new IllegalArgumentException("Unexpected value: " + colorIndex);
	                }

	                patternIndex++;

	                clearTimer[0] = new Timer(1000 / speedGame, new ActionListener() {
	                    @Override
	                    public void actionPerformed(ActionEvent e) {
	                        clearPattern();
	                        clearTimer[0].stop(); 
	                    }
	                });
	                
                    if (patternIndex >= pattern.size()) {
                    	patternTimer.stop();
                    }
	                

	                clearTimer[0].setRepeats(false);
	                clearTimer[0].start();
	            }
	        }
	    });
	    
	    patternTimer.start();
	}
    
    private void clearPattern() {
    	greenButton.setBackground(Color.white);
    	redButton.setBackground(Color.white);
    	yellowButton.setBackground(Color.white);
    	blueButton.setBackground(Color.white);
    }

    private ArrayList<Integer> generateRandomPattern() {
    	ArrayList<Integer> pattern = new ArrayList<>();
        Random random = new Random();

        for (int i = 0; i < 4 + dificultyGame; i++) {
            pattern.add(random.nextInt(3));
        }


        return pattern;
    }
	
    public void handleDificulty() {
    	if(dificultyGame >= 3) {
			dificultyGame = 1;
		}else {
			dificultyGame++;
		}
		dificultyLabel.setText("Dificuldade: "  + dificultyGame);	
    }
    
    public void handleSpeed() {
    	if(speedGame >= 3) {
    		speedGame = 1;
    	}else {
    		speedGame++;
    	}
    	speedLabel.setText("Velocidade: "  + speedGame);	
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


	public Boolean getChampionshipStarted() {
		return championshipStarted;
	}


	public void setChampionshipStarted(Boolean championshipStarted) {
		this.championshipStarted = championshipStarted;
	}
	
	public void shutChampionship() {
		if(championshipStarted) {
			this.championshipStarted = false;
    		JOptionPane.showMessageDialog(null, "Campeonato Encerrado com sucesso!");
    		return;
		}

		
	}
}


