package view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import objects.Championship;
import objects.Player;
import utils.Utils;

import java.awt.Color;
import javax.swing.UIManager;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class ChampionshipRegistration extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	public ChampionshipRegistration(Championship championship) {
		List<Player> players = new ArrayList<Player>();

		setResizable(false);
		setTitle("Novo Campeonato");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 900, 350);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 51));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		this.setLocationRelativeTo(contentPane);

		JLabel lblNewLabel = new JLabel("Titulo do campeonato");
		lblNewLabel.setForeground(UIManager.getColor("Button.highlight"));
		lblNewLabel.setBounds(8, 11, 143, 25);
		contentPane.add(lblNewLabel);

		JTextField titleChampionshipText = new JTextField();
		titleChampionshipText.setBounds(163, 10, 130, 26);
		contentPane.add(titleChampionshipText);

		JLabel registerLabel = new JLabel("Cadastre os jogadores");
		registerLabel.setForeground(Color.WHITE);
		registerLabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 21));
		registerLabel.setBounds(10, 48, 204, 25);
		contentPane.add(registerLabel);

		JTextField nicknamePlayerText = new JTextField();
		JTextField namePlayerText = new JTextField();

		JButton backButton = new JButton("Voltar");
		backButton.setForeground(new Color(0, 0, 0));
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		backButton.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 16));
		backButton.setBounds(692, 279, 95, 23);
		contentPane.add(backButton);

		JTable table = new JTable();

		Object[] columns = { "Id", "Nome", "Apelido" };

		@SuppressWarnings("serial")
		DefaultTableModel model = new DefaultTableModel() {
			public boolean isCellEditable(int rowIndex, int mColIndex) {
				return false;
			}
		};

		model.setColumnIdentifiers(columns);
		table.setModel(model);

		table.setBackground(Color.LIGHT_GRAY);
		table.setForeground(Color.black);
		Font font = new Font("Times New Roman", Font.BOLD | Font.ITALIC, 16);
		table.setFont(font);
		table.setRowHeight(30);

		table.setCellSelectionEnabled(false);

		JButton btnAdd = new JButton("Adicionar");
		btnAdd.setForeground(new Color(0, 0, 0));
		JButton btnDelete = new JButton("Excluir");
		btnDelete.setForeground(new Color(0, 0, 0));
		JButton btnUpdate = new JButton("Atualizar");
		btnUpdate.setForeground(new Color(0, 0, 0));
		nicknamePlayerText.setBounds(75, 137, 128, 25);
		namePlayerText.setBounds(75, 95, 128, 25);

		btnAdd.setBounds(6, 208, 100, 25);
		btnUpdate.setBounds(125, 208, 100, 25);
		btnDelete.setBounds(241, 208, 100, 25);

		JScrollPane pane = new JScrollPane(table);
		pane.setBounds(353, 3, 541, 268);

		contentPane.setLayout(null);

		contentPane.add(pane);
		contentPane.add(nicknamePlayerText);
		contentPane.add(namePlayerText);

		contentPane.add(btnAdd);
		contentPane.add(btnDelete);
		contentPane.add(btnUpdate);

		JLabel NameLabel = new JLabel("Nome");
		NameLabel.setForeground(new Color(254, 255, 255));
		NameLabel.setBounds(8, 100, 61, 16);
		contentPane.add(NameLabel);

		JLabel nickNameLabel = new JLabel("Apelido");
		nickNameLabel.setForeground(new Color(254, 255, 255));
		nickNameLabel.setBounds(8, 142, 61, 16);
		contentPane.add(nickNameLabel);

		Object[] row = new Object[3];

		btnAdd.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				String idPlayer = Utils.generatePlayerID();
				String namePlayer = namePlayerText.getText();
				String nicknamePlayer = nicknamePlayerText.getText();

				if (namePlayer.isEmpty()) {
					JOptionPane.showMessageDialog(null, "É necessário por um nome para o jogador");
					return;
				}

				row[0] = idPlayer;
				row[1] = namePlayer;
				row[2] = nicknamePlayer;

				players.add(new Player(idPlayer, namePlayer, nicknamePlayer));

				model.addRow(row);
				namePlayerText.setText(null);
				nicknamePlayerText.setText(null);
			}
		});

		btnDelete.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				int i = table.getSelectedRow();
				if (i >= 0) {
					model.removeRow(i);
					players.remove(i);
				} else {
					System.out.println("Erro ao deletar jogador!");
				}
			}
		});

		btnUpdate.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				int i = table.getSelectedRow();

				if (i >= 0) {
					model.setValueAt(namePlayerText.getText(), i, 1);
					model.setValueAt(nicknamePlayerText.getText(), i, 2);
					players.get(i).setName(namePlayerText.getText());
					players.get(i).setNickname(nicknamePlayerText.getText());
					namePlayerText.setText(null);
					nicknamePlayerText.setText(null);
				} else {
					System.out.println("Erro ao atualizar jogador!");
				}
			}
		});

		JButton registerButton = new JButton("Cadastrar");
		registerButton.setForeground(new Color(0, 0, 0));
		registerButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				try {
					String titleChampionship = titleChampionshipText.getText().trim();
					if (titleChampionship.isEmpty()) {
						JOptionPane.showMessageDialog(null, "É necessário por um titulo para o campeonato");
						return;
					}

					if (players.size() < 2) {
						JOptionPane.showMessageDialog(null, "É necessário ter pelo menos 2 jogadores");
						return;
					}

					championship.setTitle(titleChampionshipText.getText().trim());
					championship.setPlayers(players);

					runOnPlayGeniusScreen(championship);
					JOptionPane.showMessageDialog(null, championship.toString());

					titleChampionshipText.setText(null);
					namePlayerText.setText(null);
					nicknamePlayerText.setText(null);
					starterChampionship();
					model.setRowCount(0);
					dispose();

				} catch (ArrayIndexOutOfBoundsException err) {
					System.err.println(err.getMessage());
				}

			}

		});

		registerButton.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 16));
		registerButton.setBounds(799, 279, 95, 23);
		contentPane.add(registerButton);
	}

	private PlayGenius playGenius;

	public void showScreenPlayGenius(PlayGenius playGeniusScreen) {
		this.playGenius = playGeniusScreen;
		setVisible(true);
	}

	public void runOnPlayGeniusScreen(Championship championship) {
		this.playGenius.championshipLabel.setText("Campeonato: " + championship.getTitle());
		List<Player> players = championship.getPlayers();

		for (int i = 0; i < players.size(); i++) {
			Object[] row = new Object[3];
			row[0] = players.get(i).getId();
			row[1] = players.get(i).getName();
			row[2] = players.get(i).getTotalPoints();

			this.playGenius.model.addRow(row);
		}

	}

	public void starterChampionship() {
		this.playGenius.setChampionshipStarted(true);
	}

	public static void main(String[] args, Championship championship) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChampionshipRegistration frame = new ChampionshipRegistration(championship);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
