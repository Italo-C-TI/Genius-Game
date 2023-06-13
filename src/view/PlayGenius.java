package view;

import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import enums.COLORS;
import objects.Championship;
import utils.Utils;

public class PlayGenius extends JFrame {
	private static final long serialVersionUID = 1L;
	private Boolean gameStarted = false;
	private Boolean championshipStarted = false;
	private Integer speedGame;
	private Integer dificultyGame;
	private Timer patternTimer;
	private int currentPlayerIndex = 0;
	private int totalPlayers = 0;
	private int patternIndex = 0;
	private int clickedIndex = 0;
	private Integer currentRound;
	private final Integer totalRounds = 3;
	private final Integer pointsColumn = 2;
	private ArrayList<Integer> pattern;
	private long playStartTime;
	Championship championship = new Championship(null, null);
	Utils utils = new Utils();

	private JButton redButton;
	private JButton blueButton;
	private JButton greenButton;
	private JButton yellowButton;
	private JTable table;
	private JLabel championshipLabel;
	private JLabel roundLabel;
	private JLabel dificultyLabel;
	private JLabel speedLabel;
	private DefaultTableCellRenderer cellRenderer;

	@SuppressWarnings("serial")
	public DefaultTableModel model = new DefaultTableModel() {
		public boolean isCellEditable(int rowIndex, int mColIndex) {
			return false;
		}
	};

	@SuppressWarnings("serial")
	public PlayGenius() {
		getContentPane().setBackground(Color.DARK_GRAY);
		speedGame = 1;
		dificultyGame = 1;
		ChampionshipRegistration championshipRegistration = new ChampionshipRegistration(championship);

		setVisible(true);
		setTitle("Genius Game");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);

		greenButton = new JButton("Verde");
		greenButton.setFont(new Font("Arial Black", Font.PLAIN, 13));
		greenButton.setContentAreaFilled(false);
		greenButton.setOpaque(true);
		greenButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				handleClickColor(COLORS.GREEN);
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
		redButton.setFont(new Font("Arial Black", Font.PLAIN, 13));
		redButton.setContentAreaFilled(false);
		redButton.setOpaque(true);
		redButton.addMouseListener(new MouseAdapter() {

			@Override
			public void mousePressed(MouseEvent e) {
				handleClickColor(COLORS.RED);
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
		blueButton.setFont(new Font("Arial Black", Font.PLAIN, 13));
		blueButton.setContentAreaFilled(false);
		blueButton.setOpaque(true);
		blueButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				handleClickColor(COLORS.BLUE);
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				blueButton.setBackground(Color.WHITE);
			}
		});
		blueButton.setForeground(Color.BLUE);
		blueButton.setBounds(279, 113, 128, 95);
		getContentPane().add(blueButton);

		yellowButton = new JButton("Amarelo");
		yellowButton.setFont(new Font("Arial Black", Font.PLAIN, 13));
		yellowButton.setContentAreaFilled(false);
		yellowButton.setOpaque(true);
		yellowButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				handleClickColor(COLORS.YELLOW);
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
		startMatch.setFont(new Font("Arial Black", Font.PLAIN, 13));
		startMatch.setForeground(Color.BLACK);
		startMatch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(gameStarted) {
					JOptionPane.showMessageDialog(null, "Uma jogada está em andamento, termine para iniciar a proxima");
					return;
				}
				startPattern();
			}
		});
		startMatch.setBounds(10, 265, 117, 29);
		getContentPane().add(startMatch);

		speedLabel = new JLabel("Velocidade: " + speedGame);
		speedLabel.setFont(new Font("Arial Black", Font.PLAIN, 13));
		speedLabel.setForeground(Color.WHITE);
		speedLabel.setBounds(16, 97, 98, 16);
		getContentPane().add(speedLabel);
		setBounds(300, 200, 700, 500);

		JButton speedButton = new JButton("+");
		speedButton.setFont(new Font("Arial", Font.BOLD, 40));
		speedButton.setBounds(41, 121, 37, 29);
		getContentPane().add(speedButton);
		speedButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				handleSpeed();
			}
		});

		JButton starterChampionshipButton = new JButton("Novo campeonato");
		starterChampionshipButton.setFont(new Font("Arial Black", Font.PLAIN, 13));
		starterChampionshipButton.setForeground(Color.BLACK);

		starterChampionshipButton.setBounds(192, 350, 189, 29);
		starterChampionshipButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (championshipStarted) {
					JOptionPane.showMessageDialog(null,
							"É necessário encerrar o campeonato atual antes de iniciar outro!");
					return;
				}
				showRegisterChamphioship(championshipRegistration);
			}
		});
		getContentPane().add(starterChampionshipButton);

		JButton shutChampionShipButton = new JButton("Encerrar campeonato");
		shutChampionShipButton.setFont(new Font("Arial Black", Font.PLAIN, 13));
		shutChampionShipButton.setBackground(Color.WHITE);
		shutChampionShipButton.setForeground(Color.BLACK);

		shutChampionShipButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				shutChampionship();
			}
		});
		shutChampionShipButton.setBounds(192, 381, 189, 29);
		getContentPane().add(shutChampionShipButton);

		dificultyLabel = new JLabel("Dificuldade: " + dificultyGame);
		dificultyLabel.setFont(new Font("Arial Black", Font.PLAIN, 13));
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

		JLabel gameScoreLabel = new JLabel("Placar : \n");
		gameScoreLabel.setFont(new Font("Arial Black", Font.PLAIN, 13));
		gameScoreLabel.setForeground(Color.WHITE);
		gameScoreLabel.setHorizontalAlignment(SwingConstants.LEFT);
		gameScoreLabel.setBounds(440, 69, 86, 34);
		getContentPane().add(gameScoreLabel);

		championshipLabel = new JLabel("Campeonato: ");
		championshipLabel.setFont(new Font("Arial Black", Font.BOLD, 20));
		championshipLabel.setForeground(Color.WHITE);
		championshipLabel.setBounds(20, 23, 653, 47);
		getContentPane().add(championshipLabel);

		table = new JTable();
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBackground(Color.GRAY);
		scrollPane.setEnabled(false);
		scrollPane.setBounds(440, 113, 233, 297);
		getContentPane().add(scrollPane);
		scrollPane.setViewportView(table);

		Object[] columns = { "Id", "Nome", "Pontos" };

		model.setColumnIdentifiers(columns);
		table.setModel(model);
		table.setForeground(Color.black);
		table.setRowHeight(30);
		table.setEnabled(false);

		roundLabel = new JLabel("Round: ");
		roundLabel.setFont(new Font("Arial Black", Font.PLAIN, 16));
		roundLabel.setForeground(Color.WHITE);
		roundLabel.setBounds(16, 351, 164, 47);
		getContentPane().add(roundLabel);

		cellRenderer = new DefaultTableCellRenderer() {
			@Override
			public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
					boolean hasFocus, int row, int column) {
				Component component = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row,
						column);

				if (row == currentPlayerIndex) {
					component.setBackground(Color.RED);
				} else {
					component.setBackground(table.getBackground());
				}

				return component;
			}
		};

		for (int i = 0; i < table.getColumnCount(); i++) {
			table.getColumnModel().getColumn(i).setCellRenderer(cellRenderer);
		}

	}

	private void startPattern() {
		if (!championshipStarted) {
			JOptionPane.showMessageDialog(null, "É preciso iniciar um campeonato para jogar!");
			return;
		}
		clickedIndex = 0;
		gameStarted = true;
		pattern = utils.generateRandomPattern(currentRound, dificultyGame);
		System.out.println(pattern);
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
						utils.soundButton("red");
						break;
					case 1:
						blueButton.setBackground(Color.BLUE);
						utils.soundButton("blue");
						break;
					case 2:
						greenButton.setBackground(Color.GREEN);
						utils.soundButton("green");
						break;
					case 3:
						yellowButton.setBackground(Color.YELLOW);
						utils.soundButton("yellow");
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
						playStartTime = System.currentTimeMillis();
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

	private void verifyNextPlayer(Boolean isSuccess) {
		gameStarted = false;
		clearPattern();
		long endTime =  System.currentTimeMillis();
		Integer elapsedTime = (int) ((endTime - playStartTime) / 1000);
		championship.getPlayers().get(currentPlayerIndex).setAddTime(elapsedTime);
		championship.getPlayers().get(currentPlayerIndex).setFastestPlayTime(elapsedTime);
		currentPlayerIndex++;

		if (currentPlayerIndex >= totalPlayers) {
			currentPlayerIndex = 0;
			if (currentRound >= totalRounds) {
				shutChampionship();
				return;
			}
			currentRound++;
			setCurrentRoundLabelText(currentRound);
		}

		if (!isSuccess) {
			JOptionPane.showMessageDialog(null, "Você errou, agora é a vez do jogador "
					+ championship.getPlayers().get(currentPlayerIndex).getName());
		} else {
			JOptionPane.showMessageDialog(null, "Você acertou, agora é a vez do jogador "
					+ championship.getPlayers().get(currentPlayerIndex).getName());
		}

		for (int i = 0; i < table.getColumnCount(); i++) {
			table.getColumnModel().getColumn(i).setCellRenderer(cellRenderer);
		}

	}

	public void handleDificulty() {
		if (dificultyGame >= 3) {
			dificultyGame = 1;
		} else {
			dificultyGame++;
		}
		dificultyLabel.setText("Dificuldade: " + dificultyGame);
	}

	public void handleSpeed() {
		if (speedGame >= 3) {
			speedGame = 1;
		} else {
			speedGame++;
		}
		speedLabel.setText("Velocidade: " + speedGame);
	}

	public void shutChampionship() {
		if (championshipStarted) {
			this.championshipStarted = false;
			this.totalPlayers = 0;
			this.currentRound = 1;
			this.championshipLabel.setText("Campeonato: ");
			this.roundLabel.setText("Round: ");
			this.model.setRowCount(0);
			JOptionPane.showMessageDialog(null, this.championship.details());
			championship.cleanChampionship();
			JOptionPane.showMessageDialog(null, "Campeonato Encerrado com sucesso!");
			return;
		}

		JOptionPane.showMessageDialog(null, "Não há campeonato iniciado para se encerrar!");

	}

	public void handleClickColor(COLORS typeColor) {
		utils.soundButton(typeColor.getColorName());

		if (typeColor.getColorName() == "red") {
			redButton.setBackground(Color.RED);
		}
		if (typeColor.getColorName() == "blue") {
			blueButton.setBackground(Color.BLUE);
		}
		if (typeColor.getColorName() == "green") {
			greenButton.setBackground(Color.GREEN);
		}
		if (typeColor.getColorName() == "yellow") {
			yellowButton.setBackground(Color.YELLOW);
		}

		if (gameStarted) {
			boolean isCorrectColor = utils.checkClickedColor(typeColor.getIndexColor(), pattern, clickedIndex);
			if (isCorrectColor) {
				championship.getPlayers().get(currentPlayerIndex).addPoints(1);
				if (clickedIndex + 1 >= pattern.size()) {
					verifyNextPlayer(true);
				}

				model.setValueAt(championship.getPlayers().get(currentPlayerIndex).getTotalPoints(), currentPlayerIndex,
						pointsColumn);
				System.out.println("acertou");
			} else {
				System.out.println("errou");
				verifyNextPlayer(false);
			}
			clickedIndex++;
		}
	}

	public void showRegisterChamphioship(ChampionshipRegistration championshipRegistration) {
		championshipRegistration.showScreenPlayGenius(this);
	}

	public Boolean getChampionshipStarted() {
		return championshipStarted;
	}

	public void setChampionshipStarted(Boolean championshipStarted) {
		this.championshipStarted = championshipStarted;
	}

	public void setTotalPlayers(int totalPlayers) {
		this.totalPlayers = totalPlayers;
	}

	public void setCurrentRound(Integer round) {
		this.currentRound = round;
	}

	public void setChampionshipLabelText(String text) {
		this.championshipLabel.setText(text);
	}

	public void setCurrentRoundLabelText(Integer currentRound) {
		this.roundLabel.setText("Round: " + currentRound + " / " + getTotalRounds());
	}

	public Integer getTotalRounds() {
		return this.totalRounds;
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
