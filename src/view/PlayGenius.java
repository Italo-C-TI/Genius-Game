package view;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.Random;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

import objects.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


public class PlayGenius extends JFrame {
	private static final long serialVersionUID = 1L;
	//private Boolean gameStarted;
	private Boolean championshipStarted = false;
    private Integer speedGame;;
    private Timer patternTimer;
    private int patternIndex;
    private ArrayList<Integer> pattern;
    public JButton redButton ;
	private JButton blueButton;
    private JButton greenButton;
    private JButton yellowButton;
    private JTable table;
	public JLabel championshipLabel = new JLabel("Campeonato: ");
	
	

	
    private void startPattern() {
    	pattern = generateRandomPattern();
    	patternIndex = 0;


    	for (int colorIndex : pattern) {
    	    switch (colorIndex) {
    	        case 0:
    	            changeColorWithDelay(redButton, Color.RED, 1000);
    	            break;
    	        case 1:
    	            changeColorWithDelay(blueButton, Color.BLUE, 1000);
    	            break;
    	        case 2:
    	            changeColorWithDelay(greenButton, Color.GREEN, 1000);
    	            break;
    	        case 3:
    	            changeColorWithDelay(yellowButton, Color.YELLOW, 1000);
    	            break;
    	        default:
    	            throw new IllegalArgumentException("Unexpected value: " + colorIndex);
    	    }
    	    System.err.println(colorIndex);

    	    try {
    	        TimeUnit.MILLISECONDS.sleep(1000); // Espera por 1 segundo
    	    } catch (InterruptedException e) {
    	        e.printStackTrace();
    	    }

    	    switch (colorIndex) {
    	        case 0:
    	            redButton.setBackground(null);
    	            break;
    	        case 1:
    	            blueButton.setBackground(null);
    	            break;
    	        case 2:
    	            greenButton.setBackground(null);
    	            break;
    	        case 3:
    	            yellowButton.setBackground(null);
    	            break;
    	        default:
    	            throw new IllegalArgumentException("Unexpected value: " + colorIndex);
    	    }

    	    patternIndex++;
    	}

    	// Limpar o padrão no final do loop
    	clearPattern();
   
    	
    	
//        pattern = generateRandomPattern();
//        patternIndex = 0;
//                
//        for (int colorIndex : pattern) {
//	        try {
//	        	switch (colorIndex) {
//	        	case 0 :
//			        redButton.setBackground(Color.RED);		
//					break;
//				case 1: 
//					blueButton.setBackground(Color.BLUE);
//				break;
//				case 2:
//					greenButton.setBackground(Color.GREEN);
//					break;
//				case 3:
//					yellowButton.setBackground(Color.YELLOW);
//					break;
//				default:
//					throw new IllegalArgumentException("Unexpected value: " + colorIndex);
//				}
//	        	System.err.println(colorIndex);
//	        	TimeUnit.SECONDS.sleep(patternIndex + 1);	
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
//	        patternIndex++;
//
//        }
        

//        patternTimer = new Timer(1500, new ActionListener() {
//			@Override
//            public void actionPerformed(ActionEvent e) {
//                if (patternIndex < pattern.size()) {
//                	switch (patternIndex) {
//					case 0 :
//						redButton.setBackground(Color.RED);	
//						break;
//					case 1: 
//						blueButton.setBackground(Color.BLUE);
//					break;
//					case 2:
//						greenButton.setBackground(Color.GREEN);
//						break;
//					case 3:
//						yellowButton.setBackground(Color.YELLOW);
//						break;
//					default:
//						throw new IllegalArgumentException("Unexpected value: " + patternIndex);
//					}
//                	System.err.println(patternIndex);
//                    patternIndex++;
//                    
//                     clearTimer[0] = new Timer(1000, new ActionListener() {
//                        @Override
//                        public void actionPerformed(ActionEvent e) {
//                        	clearPattern();
//
//                            if (patternIndex >= pattern.size()) {
//                                clearTimer[0].stop();
//                                clearPattern();
//                            }
//                        }
//                    });
//
//                    clearTimer[0].setRepeats(false); // Executa apenas uma vez
//                    clearTimer[0].start();
//                } 
//                
//            }
//        });
//
//        patternTimer.start();
 }
    
    private void changeColorWithDelay(final JButton button, final Color color, final int delay) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                button.setBackground(color);
            }
        });

        try {
            TimeUnit.MILLISECONDS.sleep(delay);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void clearPattern() {
    	greenButton.setBackground(null);
    	redButton.setBackground(null);
    	yellowButton.setBackground(null);
    	blueButton.setBackground(null);
    }

    private ArrayList<Integer> generateRandomPattern() {
    	ArrayList<Integer> pattern = new ArrayList<>();
        Random random = new Random();

        for (int i = 0; i < 4; i++) {
            pattern.add(random.nextInt(3));
        }


        return pattern;
    }
	
	@SuppressWarnings("serial")
	public DefaultTableModel model = new DefaultTableModel(){ public boolean isCellEditable(int rowIndex, int mColIndex){ return false; } };
    
    public PlayGenius() {
    	getContentPane().setBackground(Color.DARK_GRAY);
       // gameStarted = false;
        speedGame = 1;
        Championship championship = new Championship(null, null);
        ChampionshipRegistration championshipRegistration = new ChampionshipRegistration(championship); 


        setVisible(true);
        setTitle("Genius Game");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);
        
        greenButton = new JButton("Verde");
        greenButton.setContentAreaFilled(false);
        greenButton.setOpaque(true);
        greenButton.setForeground(Color.GREEN);
        greenButton.setBounds(139, 213, 128, 95);
        getContentPane().add(greenButton);
        
        redButton = new JButton("Vermelho");
        redButton.setContentAreaFilled(false);
        redButton.setOpaque(true);
        redButton.setForeground(Color.RED);
        redButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
				redButtonThink();
        	}
        });
        redButton.setBounds(139, 113, 128, 95);
        getContentPane().add(redButton);
        
        
        blueButton = new JButton("Azul");
        blueButton.setContentAreaFilled(false);
        blueButton.setOpaque(true);
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
        yellowButton.setForeground(Color.YELLOW);
        yellowButton.setBounds(279, 213, 128, 95);
        getContentPane().add(yellowButton);
        
        JButton startMatch = new JButton("Iniciar Partida");
        startMatch.setForeground(Color.BLACK);
        startMatch.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		startPattern();
        	}
        });
        startMatch.setBounds(10, 265, 117, 29);
        getContentPane().add(startMatch);
        
        
        JLabel speedLabel = new JLabel("Velocidade: "  + speedGame);
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
        		if(speedGame >= 3) {
        			speedGame = 1;
        		}else {
        			speedGame++;
        		}
        		speedLabel.setText("Velocidade: "  + speedGame);
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

	
	public void  redButtonThink() {
		this.redButton.setBackground(Color.red);
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


