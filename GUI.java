package pet_game;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Scanner;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

public class GUI implements gameObjects {

	private final JLabel lblDayNum = new JLabel("1");

	private final JLabel lblNewLabel_14 = new JLabel("  Food");
	private final JLabel lblNewLabel_15 = new JLabel("  Toys");
	private final JButton btnCake = new JButton("");
	private final JButton btnMelon = new JButton("");
	private final JButton btnHelicopter = new JButton("");
	private final JButton btnDoll = new JButton("");
	private final JButton btnBear = new JButton("");
	private final JButton btnBoat = new JButton("");
	private final JButton btnYoyo = new JButton("");
	private final JButton btnKite = new JButton("");
	private final JLabel lblPlayerContents = new JLabel("            Player contents");
	private final JLabel lblChocolate = new JLabel(
			"<html>Name: Chocolate\nPrice: 5<br>\nSize: small\nTastiness: 10\nNutrition: 40");
	private final JLabel lblCookies = new JLabel(
			"<html>Name: Cookies\nPrice: 5<br>\nSize: small\nTastiness:  5\nNutrition: 20");
	private final JLabel lblFish = new JLabel(
			"<html>Name: Fish<br>\nPrice: 10<br>\nSize: large\nTastiness: 20\nNutrition: 30");
	private final JLabel lblPizza = new JLabel(
			"<html>Name: Pizza\nPrice: 10<br>\nSize: large\nTastiness: 10\nNutrition: 40");
	private final JLabel lblCake = new JLabel(
			"<html>Name: Cake\nPrice: 10<br>\nSize: large\nTastiness: 10\nNutrition: 30");
	private final JLabel lblMelon = new JLabel(
			"<html>Name: Melon\nPrice: 5<br>\nSize: small\nTastiness: 15\nNutrition: 29");
	private final JLabel lblHelicopter = new JLabel(
			"<html>Name: Helicopter\nPrice: 20<br>\nDurability: 100\nEnjoyment: 50");
	private final JLabel lblBoat = new JLabel("<html>Name: Boat\nPrice: 15<br>\nDurability: 70\nEnjoyment: 50");
	private final JLabel lblYoyo = new JLabel("<html>Name: Yoyo<br>\nPrice: 5<br>\nDurability: 10\nEnjoyment: 20");
	private final JLabel lblBear = new JLabel("<html>Name: Bear<br>\nPrice: 5<br>\nDurability: 10\nEnjoyment: 10");
	private final JLabel lblDoll = new JLabel("<html>Name: Doll<br>\nPrice: 5<br>\nDurability: 50\nEnjoyment: 10");
	private final JLabel lblKite = new JLabel("<html>Name: Kite<br>\nPrice: 10<br>\nDurability: 50\nEnjoyment: 50");
	private final JLabel lblNewLabel_13 = new JLabel("24 Hour Pet Store");
	private final JLabel lblPetStoreImage = new JLabel("");

	int textCounter = 1;
	JFrame frame;
	//// Initializations
	private Species globalCurrentPet;
	private Player globalCurrentPlayer;
	private int numOfPlayers;
	private double gameDays;
	private double playerDaysTaken;
	private int globalCurrentDay;
	private List<String> existingPetNames = new ArrayList<String>();
	// private Map<Integer, Toy> toyChoices = new HashMap<Integer, Toy>();
	// private Map<Integer, Food> foodChoices = new HashMap<Integer, Food>();
	// private Map<Integer, Species> speciesChoices = new HashMap<Integer,
	// Species>();
	// private Map<Integer, Player> players = new HashMap<Integer, Player>();

	private JLabel lblWelcome = new JLabel("<html>Welcome to Pets <br> the virtual pet game!");
	private JButton btnStart = new JButton("Start");
	private JButton btnHelp = new JButton("Help");
	private final JPanel panelStart = new JPanel();
	private final JPanel panelHelp = new JPanel();
	private JLabel lblHelp = new JLabel("");
	private final JLabel lblContinue = new JLabel("Click to continue...\r\n");
	private final JLabel lblHelpcounter = new JLabel("");
	private final JPanel clickPanel = new JPanel();
	private JPanel panelInput = new JPanel();
	private final JLabel lblPlayerNum = new JLabel("How many players would like to play the game?");

	private ButtonGroup radioGroupPlayers = new ButtonGroup();
	private JRadioButton rdbtn1player = new JRadioButton("1 Player");
	private JRadioButton rdbtn3players = new JRadioButton("3 Players");
	private JRadioButton rdbtn2players = new JRadioButton("2 Players");

	private JButton btnPlayerContinue = new JButton("Continue\n");
	private final JButton btnPlayerContinue2 = new JButton("Continue\n");
	private JSpinner spinnerDayNum = new JSpinner();
	private final JPanel panelCreation = new JPanel();
	private final JLabel lblNamePrompt = new JLabel("");
	private final JTextField textFieldCreation = new JTextField();
	private final JButton btnCreationContinue = new JButton("Continue\n");
	private final JPanel panelPet = new JPanel();
	private final JLabel lblpetdetails = new JLabel("");
	private JButton btnPetCounter = new JButton("Continue\n");
	private JTextField txtPetName1;
	private JTextField txtPetName2;
	private JTextField txtPetName3;
	private JTextField txtPetName4;
	private JTextField txtPetName5;
	private JTextField txtPetName6;
	private final JLabel lblSelectUpTo = new JLabel("Select up to 3.");
	private JCheckBox chckbxPet1 = new JCheckBox("Select Cloud");
	private JCheckBox chckbxPet2 = new JCheckBox("Select Crab");
	private JCheckBox chckbxPet3 = new JCheckBox("Select Monster");
	private JCheckBox chckbxPet4 = new JCheckBox("Select Penquin");
	private JCheckBox chckbxPet5 = new JCheckBox("Select Robot");
	private JCheckBox chckbxPet6 = new JCheckBox("Select Snake");
	private JLabel lblNewLabel = new JLabel("Put pets + description here");
	private JLabel lblWelcome2 = new JLabel("<html>Welcome to Pets <br>the virtual pet game!");
	private JLabel lblNewLabel_2 = new JLabel("New label");
	private JLabel lblBeng = new JLabel("New label");
	private JLabel lblNewLabel_4 = new JLabel("New label");
	private JLabel lblNewLabel_5 = new JLabel("New label");
	private JLabel lblNewLabel6 = new JLabel("");
	private JLabel lblNewLabel_1 = new JLabel("New label");
	private final JLabel lblBackgroundIcon = new JLabel("New label");
	private final JLabel lblBackgroundstart = new JLabel("New label");
	private final JLabel lblNewLabel_6 = new JLabel(
			"<html>Cloud: seems to care only <br> about itself,but can bring great joy to others.\n");
	private final JLabel lblNewLabel_3 = new JLabel(
			"<html>Penguin: not much to be <br>said about this black and white companion.");
	private final JLabel lblNewLabel_7 = new JLabel("<html>Crab: loyal but simple.<br> Obsessed with toys.");
	private final JLabel lblNewLabel_8 = new JLabel(
			"<html>Robot: has great personality for<br> a machine. Spends most of his time recharging his batteries.");
	private final JLabel lblNewLabel_9 = new JLabel(
			"<html>Monster: while scary looking, <br>has a gentle heart beneath the rugged fur.");
	private final JLabel lblNewLabel_10 = new JLabel(
			"<html>Snake: is as slippery as he<br> is untrustworthy. Keep a close eye on this one.\\n");
	private final JLabel lblNewLabel_11 = new JLabel("New label");
	private final JLabel lblNewLabel_12 = new JLabel("New label");
	private final JPanel panelMainScreen = new JPanel();
	private final JPanel panelButtons = new JPanel();
	private final JButton btnPetSelect = new JButton("Select a pet");
	private final JButton btnVisitTheStore = new JButton("Visit the store");
	private final JButton btnFeedPet = new JButton("Feed pet");
	private JButton btnSleep = new JButton("Put pet to sleep");
	private final JButton btnUseToy = new JButton("Use toy");
	private final JButton btnUseToilet = new JButton("Use toilet");
	private final JButton btnPunishPet = new JButton("Punish pet");
	private final JButton btnVisitDoctor = new JButton("Visit doctor");
	private final JButton btnEndDay = new JButton("End day");
	private final JLabel lblCurrentSelectedPet = new JLabel("<html>Select a pet to <br>interact with it!");
	private final JLabel lblPetAttributes = new JLabel("<html>");
	private final JLabel lblCurrentPet = new JLabel("Current Pet: NONE");
	private final JLabel lblEventOutputs = new JLabel("");
	private final JLabel lblCurrentPlayer = new JLabel("Current player:");
	private final JLabel lblCurrentDay = new JLabel("");
	private final JPanel panelStore = new JPanel();
	private final JLabel lblDay = new JLabel("Day");
	private final JLabel lblDayTotals = new JLabel("/ --");
	private final JPanel panelPets = new JPanel();
	private final JLabel lblSelectAPet = new JLabel("Click on a pet to select it!");
	private JButton btnSelectPet1 = new JButton("");
	private JButton btnSelectPet2 = new JButton("");
	private JButton btnSelectPet3 = new JButton("");
	private final JLabel lblPetName1 = new JLabel("");
	private final JLabel lblPetName2 = new JLabel("");
	private final JLabel lblPetName3 = new JLabel("");
	private final JButton btnRevive = new JButton("Revive pet");

	public GUI() {
		
		panelStore.add(lblNewLabel_14);
		lblNewLabel_15.setForeground(new Color(255, 215, 0));
		lblNewLabel_15.setFont(new Font("Dialog", Font.BOLD, 25));
		lblNewLabel_15.setBounds(807, 81, 114, 47);

		panelStore.add(lblNewLabel_15);

		JButton btnChocolate = new JButton("");
		btnChocolate.setIcon(new ImageIcon(GUI.class.getResource("/photo/Choclate.jpg")));
		btnChocolate.setBounds(37, 129, 117, 112);
		panelStore.add(btnChocolate);

		JButton btnCookies = new JButton("");
		btnCookies.setIcon(new ImageIcon(GUI.class.getResource("/photo/Cookies.jpg")));
		btnCookies.setBounds(175, 129, 117, 112);
		panelStore.add(btnCookies);

		JButton btnFish = new JButton("");
		btnFish.setIcon(new ImageIcon(GUI.class.getResource("/photo/Fish.jpg")));
		btnFish.setBounds(319, 129, 125, 112);
		panelStore.add(btnFish);

		JButton btnPizza = new JButton("");
		btnPizza.setIcon(new ImageIcon(GUI.class.getResource("/photo/Pizza.jpg")));
		btnPizza.setBounds(40, 322, 114, 123);
		panelStore.add(btnPizza);
		btnCake.setIcon(new ImageIcon(GUI.class.getResource("/photo/cake.jpg")));
		btnCake.setBounds(175, 322, 114, 123);

		panelStore.add(btnCake);
		btnMelon.setIcon(new ImageIcon(GUI.class.getResource("/photo/water_m.jpg")));
		btnMelon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnMelon.setBounds(319, 325, 125, 120);

		panelStore.add(btnMelon);
		btnHelicopter.setFont(new Font("Dialog", Font.PLAIN, 5));
		btnHelicopter.setIcon(new ImageIcon(GUI.class.getResource("/photo/plan.jpg")));
		btnHelicopter.setBounds(668, 129, 117, 112);

		panelStore.add(btnHelicopter);
		btnDoll.setIcon(new ImageIcon(GUI.class.getResource("/photo/Doll_Toy.jpg")));
		btnDoll.setBounds(817, 321, 105, 124);

		panelStore.add(btnDoll);
		btnBear.setFont(new Font("Dialog", Font.BOLD, 5));
		btnBear.setIcon(new ImageIcon(GUI.class.getResource("/photo/Bear_Toy.jpg")));
		btnBear.setBounds(668, 322, 105, 123);

		panelStore.add(btnBear);
		btnBoat.setIcon(new ImageIcon(GUI.class.getResource("/photo/Boat_Toy.jpg")));
		btnBoat.setBounds(817, 129, 132, 112);

		panelStore.add(btnBoat);
		btnYoyo.setIcon(new ImageIcon(GUI.class.getResource("/photo/yoy.jpg")));
		btnYoyo.setBounds(971, 129, 129, 112);

		panelStore.add(btnYoyo);
		btnKite.setIcon(new ImageIcon(GUI.class.getResource("/photo/KITE_TOY.png")));
		btnKite.setBounds(983, 322, 117, 132);

		panelStore.add(btnKite);
		lblPlayerContents.setForeground(Color.BLACK);
		lblPlayerContents.setBackground(Color.CYAN);
		lblPlayerContents.setBounds(37, 537, 424, 146);

		panelStore.add(lblPlayerContents);
		lblChocolate.setFont(new Font("Dialog", Font.BOLD, 11));
		lblChocolate.setBounds(37, 242, 117, 80);

		panelStore.add(lblChocolate);
		lblCookies.setFont(new Font("Dialog", Font.BOLD, 11));
		lblCookies.setBounds(175, 248, 117, 69);

		panelStore.add(lblCookies);
		lblFish.setFont(new Font("Dialog", Font.BOLD, 11));
		lblFish.setBounds(319, 246, 125, 71);

		panelStore.add(lblFish);
		lblPizza.setFont(new Font("Dialog", Font.BOLD, 11));
		lblPizza.setBounds(37, 450, 117, 75);

		panelStore.add(lblPizza);
		lblCake.setFont(new Font("Dialog", Font.BOLD, 11));
		lblCake.setBounds(185, 450, 107, 75);

		panelStore.add(lblCake);
		lblMelon.setFont(new Font("Dialog", Font.BOLD, 11));
		lblMelon.setBounds(319, 450, 125, 75);

		panelStore.add(lblMelon);
		lblHelicopter.setFont(new Font("Dialog", Font.BOLD, 11));
		lblHelicopter.setBounds(678, 236, 114, 79);

		panelStore.add(lblHelicopter);
		lblBoat.setFont(new Font("Dialog", Font.BOLD, 11));
		lblBoat.setBounds(826, 241, 105, 68);

		panelStore.add(lblBoat);
		lblYoyo.setFont(new Font("Dialog", Font.BOLD, 11));
		lblYoyo.setBounds(981, 243, 119, 64);

		panelStore.add(lblYoyo);
		lblBear.setFont(new Font("Dialog", Font.BOLD, 11));
		lblBear.setBounds(668, 446, 117, 68);

		panelStore.add(lblBear);
		lblDoll.setFont(new Font("Dialog", Font.BOLD, 11));
		lblDoll.setBounds(827, 446, 114, 68);

		panelStore.add(lblDoll);
		lblKite.setFont(new Font("Dialog", Font.BOLD, 11));
		lblKite.setBounds(993, 451, 114, 63);

		panelStore.add(lblKite);
		lblNewLabel_13.setFont(new Font("Dialog", Font.BOLD, 40));
		lblNewLabel_13.setBounds(371, 0, 414, 89);

		panelStore.add(lblNewLabel_13);
		lblPetStoreImage.setIcon(new ImageIcon(GUI.class.getResource("/photo/PetStoreDog.jpg")));
		lblPetStoreImage.setBounds(443, 537, 258, 182);

		panelStore.add(lblPetStoreImage);
		panelStart.setBackground(Color.BLUE);
		panelStart.setForeground(Color.RED);
		panelStart.setBounds(0, 0, 1213, 718);

		globalCurrentPet = null;

		toyChoices.put(1, bear);
		toyChoices.put(2, boat);
		toyChoices.put(3, doll);
		toyChoices.put(4, heli);
		toyChoices.put(5, kite);
		toyChoices.put(6, yoyo);

		foodChoices.put(1, cookie);
		foodChoices.put(2, fish);
		foodChoices.put(3, chocolate);
		foodChoices.put(4, cake);
		foodChoices.put(5, melon);
		foodChoices.put(6, pizza);

		speciesChoices.put(1, cloud);
		speciesChoices.put(2, crab);
		speciesChoices.put(3, monster);
		speciesChoices.put(4, penguin);
		speciesChoices.put(5, robot);
		speciesChoices.put(6, snake);
	}

	public void guiConstructor() {

		frame = new JFrame();
		frame.setPreferredSize(new Dimension(500, 500));
		frame.setBounds(100, 100, 1215, 744);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		panelStore.setVisible(false);
		panelStore.setLayout(null);
		panelStore.setForeground(Color.WHITE);
		panelStore.setBackground(Color.PINK);
		panelStore.setBounds(0, 0, 1210, 717);

		frame.getContentPane().add(panelStore);
		panelCreation.setLayout(null);
		lblNewLabel.setBounds(450, 74, 192, 192);
		lblSelectUpTo.setForeground(Color.WHITE);
		lblSelectUpTo.setFont(new Font("Dialog", Font.BOLD, 25));
		lblSelectUpTo.setBounds(474, 26, 246, 37);

		panelCreation.add(lblSelectUpTo);
		lblBeng.setBounds(98, 310, 192, 192);

		lblBeng.setIcon(new ImageIcon(GUI.class.getResource("/photo/PENG_PET.png")));
		panelCreation.add(lblBeng);
		lblNewLabel_4.setBounds(450, 310, 192, 192);

		lblNewLabel_4.setIcon(new ImageIcon(GUI.class.getResource("/photo/ROBOT_PET.png")));
		panelCreation.add(lblNewLabel_4);
		lblNewLabel_2.setBounds(801, 74, 192, 192);

		lblNewLabel_2.setIcon(new ImageIcon(GUI.class.getResource("/photo/MONSTER_PET.png")));
		panelCreation.add(lblNewLabel_2);
		lblNewLabel_1.setBounds(98, 74, 192, 192);
		lblNewLabel_1.setIcon(new ImageIcon(GUI.class.getResource("/photo/CLOUD_PET.png")));
		panelCreation.add(lblNewLabel_1);
		lblNewLabel_5.setBounds(801, 310, 192, 192);

		lblNewLabel_5.setIcon(new ImageIcon(GUI.class.getResource("/photo/SNAKE_PET.png")));
		panelCreation.add(lblNewLabel_5);
		lblNewLabel.setIcon(new ImageIcon(GUI.class.getResource("/photo/CRAB_PET-1.png")));
		panelCreation.add(lblNewLabel);
		panelCreation.add(lblNewLabel);
		textFieldCreation.setBounds(274, 513, 698, 67);
		textFieldCreation.setColumns(10);
		panelCreation.setBackground(Color.GRAY);
		panelCreation.setVisible(false);
		panelCreation.setBounds(0, 0, 1213, 718);

		frame.getContentPane().add(panelCreation);
		lblNamePrompt.setForeground(Color.WHITE);
		lblNamePrompt.setBounds(274, 560, 698, 83);

		panelCreation.add(lblNamePrompt);

		panelCreation.add(textFieldCreation);
		btnCreationContinue.setBounds(510, 622, 193, 61);

		btnCreationContinue.setVerticalAlignment(SwingConstants.BOTTOM);

		panelCreation.add(btnCreationContinue);
		btnPetCounter.setBounds(510, 622, 193, 61);

		btnPetCounter.setVisible(false);
		btnPetCounter.setVerticalAlignment(SwingConstants.BOTTOM);
		panelCreation.add(btnPetCounter);

		txtPetName1 = new JTextField();
		txtPetName1.setBounds(294, 235, 130, 31);
		txtPetName1.setText("Enter a name...");
		panelCreation.add(txtPetName1);
		txtPetName1.setColumns(10);

		txtPetName2 = new JTextField();
		txtPetName2.setBounds(652, 235, 130, 31);
		txtPetName2.setText("Enter a name...");
		txtPetName2.setColumns(10);
		panelCreation.add(txtPetName2);

		txtPetName3 = new JTextField();
		txtPetName3.setBounds(1003, 235, 130, 31);
		txtPetName3.setText("Enter a name...");
		txtPetName3.setColumns(10);
		panelCreation.add(txtPetName3);

		txtPetName4 = new JTextField();
		txtPetName4.setBounds(294, 469, 130, 31);
		txtPetName4.setText("Enter a name...");
		txtPetName4.setColumns(10);
		panelCreation.add(txtPetName4);

		txtPetName5 = new JTextField();
		txtPetName5.setBounds(647, 471, 130, 31);
		txtPetName5.setText("Enter a name...");
		txtPetName5.setColumns(10);
		panelCreation.add(txtPetName5);

		txtPetName6 = new JTextField();
		txtPetName6.setBounds(1003, 471, 130, 31);
		txtPetName6.setText("Enter a name...");
		txtPetName6.setColumns(10);
		panelCreation.add(txtPetName6);
		chckbxPet1.setBounds(296, 205, 129, 23);
		panelCreation.add(chckbxPet1);
		chckbxPet2.setBounds(652, 205, 129, 23);
		panelCreation.add(chckbxPet2);
		chckbxPet3.setBounds(1004, 205, 129, 23);
		panelCreation.add(chckbxPet3);
		chckbxPet4.setBounds(296, 439, 129, 23);
		panelCreation.add(chckbxPet4);
		chckbxPet5.setBounds(648, 441, 129, 23);
		panelCreation.add(chckbxPet5);
		chckbxPet6.setBounds(1004, 441, 129, 23);
		panelCreation.add(chckbxPet6);
		lblNewLabel_6.setForeground(Color.WHITE);
		lblNewLabel_6.setBounds(294, 18, 130, 155);

		panelCreation.add(lblNewLabel_6);
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setBounds(294, 268, 135, 127);

		panelCreation.add(lblNewLabel_3);
		lblNewLabel_7.setForeground(Color.WHITE);
		lblNewLabel_7.setBounds(652, 26, 122, 125);

		panelCreation.add(lblNewLabel_7);
		lblNewLabel_8.setForeground(Color.WHITE);
		lblNewLabel_8.setBounds(652, 268, 151, 140);

		panelCreation.add(lblNewLabel_8);
		lblNewLabel_9.setForeground(Color.WHITE);
		lblNewLabel_9.setBounds(1003, 47, 111, 125);

		panelCreation.add(lblNewLabel_9);
		lblNewLabel_10.setForeground(Color.WHITE);
		lblNewLabel_10.setBounds(1006, 271, 119, 148);

		panelCreation.add(lblNewLabel_10);
		lblNewLabel_11.setIcon(new ImageIcon(GUI.class.getResource("/photo/Pets-Background.png")));
		lblNewLabel_11.setBounds(-58, -127, 1384, 869);

		panelCreation.add(lblNewLabel_11);
		panelMainScreen.setVisible(false);
		panelMainScreen.setBackground(Color.GRAY);
		panelMainScreen.setBounds(0, 0, 1213, 718);

		frame.getContentPane().add(panelMainScreen);
		panelMainScreen.setLayout(null);
		lblDayTotals.setFont(new Font("Dialog", Font.BOLD, 19));
		lblDayTotals.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDayTotals.setForeground(Color.WHITE);
		lblDayTotals.setBounds(910, 227, 81, 28);

		panelMainScreen.add(lblDayTotals);
		lblDay.setForeground(Color.WHITE);
		lblDay.setBounds(827, 76, 81, 23);
		panelButtons.add(btnFeedPet);
		panelMainScreen.add(lblDay);
		lblCurrentSelectedPet.setHorizontalAlignment(SwingConstants.CENTER);
		lblCurrentSelectedPet.setFont(new Font("Dialog", Font.BOLD, 14));
		lblCurrentSelectedPet.setOpaque(true);
		lblCurrentSelectedPet.setBounds(615, 69, 192, 192);

		panelMainScreen.add(lblCurrentSelectedPet);
		lblPetAttributes.setHorizontalAlignment(SwingConstants.CENTER);
		lblPetAttributes.setHorizontalTextPosition(SwingConstants.CENTER);
		lblPetAttributes.setOpaque(true);
		lblPetAttributes.setBackground(Color.DARK_GRAY);
		lblPetAttributes.setForeground(Color.WHITE);
		lblPetAttributes.setBounds(615, 267, 192, 214);

		panelMainScreen.add(lblPetAttributes);
		lblCurrentPet.setForeground(Color.WHITE);
		lblCurrentPet.setBackground(Color.DARK_GRAY);
		lblCurrentPet.setOpaque(true);
		lblCurrentPet.setBounds(615, 11, 192, 48);

		panelMainScreen.add(lblCurrentPet);
		lblEventOutputs.setBackground(Color.DARK_GRAY);
		lblEventOutputs.setForeground(Color.WHITE);
		lblEventOutputs.setOpaque(true);
		lblEventOutputs.setBounds(615, 486, 384, 220);

		panelMainScreen.add(lblEventOutputs);
		lblCurrentPlayer.setBackground(Color.DARK_GRAY);
		lblCurrentPlayer.setForeground(Color.WHITE);
		lblCurrentPlayer.setOpaque(true);
		lblCurrentPlayer.setBounds(817, 11, 384, 48);

		panelMainScreen.add(lblCurrentPlayer);
		lblCurrentDay.setFont(new Font("Dialog", Font.BOLD, 47));
		lblCurrentDay.setHorizontalTextPosition(SwingConstants.CENTER);
		lblCurrentDay.setHorizontalAlignment(SwingConstants.CENTER);
		lblCurrentDay.setBackground(Color.DARK_GRAY);
		lblCurrentDay.setForeground(Color.WHITE);
		lblCurrentDay.setOpaque(true);
		lblCurrentDay.setBounds(817, 71, 182, 192);

		panelMainScreen.add(lblCurrentDay);
		panelButtons.setBackground(Color.DARK_GRAY);
		panelButtons.setForeground(Color.WHITE);
		panelButtons.setBounds(12, 11, 593, 695);

		panelMainScreen.add(panelButtons);
		panelButtons.setLayout(null);

		btnPetSelect.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evt) {
				btnPetSelect.setBackground(Color.GREEN);
			}

			public void mouseExited(java.awt.event.MouseEvent evt) {
				btnPetSelect.setBackground(UIManager.getColor("control"));
			}
		});
		btnPetSelect.setBounds(10, 10, 571, 57);

		panelButtons.add(btnPetSelect);
		btnVisitTheStore.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evt) {
				btnVisitTheStore.setBackground(Color.GREEN);
			}

			public void mouseExited(java.awt.event.MouseEvent evt) {
				btnVisitTheStore.setBackground(UIManager.getColor("control"));
			}
		});
		btnVisitTheStore.setBounds(10, 79, 571, 57);

		panelButtons.add(btnVisitTheStore);
		btnFeedPet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});
		btnFeedPet.setBounds(10, 147, 571, 57);
		btnFeedPet.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evt) {
				btnFeedPet.setBackground(Color.GREEN);
			}

			public void mouseExited(java.awt.event.MouseEvent evt) {
				btnFeedPet.setBackground(UIManager.getColor("control"));
			}
		});

		btnSleep.setBounds(10, 215, 571, 57);
		btnSleep.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evt) {
				btnSleep.setBackground(Color.GREEN);
			}

			public void mouseExited(java.awt.event.MouseEvent evt) {
				btnSleep.setBackground(UIManager.getColor("control"));
			}
		});

		panelButtons.add(btnSleep);
		btnUseToy.setBounds(10, 283, 571, 57);

		panelButtons.add(btnUseToy);
		btnUseToy.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evt) {
				btnUseToy.setBackground(Color.GREEN);
			}

			public void mouseExited(java.awt.event.MouseEvent evt) {
				btnUseToy.setBackground(UIManager.getColor("control"));
			}
		});

		btnUseToilet.setBounds(10, 351, 571, 57);

		panelButtons.add(btnUseToilet);
		btnUseToilet.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evt) {
				btnUseToilet.setBackground(Color.GREEN);
			}

			public void mouseExited(java.awt.event.MouseEvent evt) {
				btnUseToilet.setBackground(UIManager.getColor("control"));
			}
		});

		btnPunishPet.setBounds(10, 419, 571, 57);

		panelButtons.add(btnPunishPet);
		btnPunishPet.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evt) {
				btnPunishPet.setBackground(Color.GREEN);
			}

			public void mouseExited(java.awt.event.MouseEvent evt) {
				btnPunishPet.setBackground(UIManager.getColor("control"));
			}
		});

		btnVisitDoctor.setBounds(10, 487, 571, 57);

		panelButtons.add(btnVisitDoctor);
		btnVisitDoctor.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evt) {
				btnVisitDoctor.setBackground(Color.GREEN);
			}

			public void mouseExited(java.awt.event.MouseEvent evt) {
				btnVisitDoctor.setBackground(UIManager.getColor("control"));
			}
		});
		btnEndDay.setBounds(10, 626, 571, 57);

		panelButtons.add(btnEndDay);

		btnRevive.setBounds(10, 556, 571, 57);

		panelButtons.add(btnRevive);
		panelPets.setVisible(false);
		panelPets.setBounds(0, 0, 593, 706);
		panelMainScreen.add(panelPets);
		panelPets.setBackground(Color.DARK_GRAY);
		panelPets.setLayout(null);
		btnSelectPet1.setHorizontalTextPosition(SwingConstants.CENTER);

		btnSelectPet1.setBackground(Color.GRAY);
		btnSelectPet1.setBounds(87, 64, 192, 192);
		panelPets.add(btnSelectPet1);
		lblSelectAPet.setHorizontalTextPosition(SwingConstants.CENTER);
		lblSelectAPet.setHorizontalAlignment(SwingConstants.CENTER);
		lblSelectAPet.setBackground(Color.GRAY);
		lblSelectAPet.setForeground(Color.WHITE);
		lblSelectAPet.setOpaque(true);
		lblSelectAPet.setBounds(162, 12, 277, 40);

		panelPets.add(lblSelectAPet);
		btnSelectPet2.setHorizontalTextPosition(SwingConstants.CENTER);

		btnSelectPet2.setBackground(Color.GRAY);
		btnSelectPet2.setBounds(346, 64, 192, 192);
		panelPets.add(btnSelectPet2);
		btnSelectPet3.setHorizontalTextPosition(SwingConstants.CENTER);

		btnSelectPet3.setBackground(Color.GRAY);
		btnSelectPet3.setBounds(220, 356, 192, 192);
		panelPets.add(btnSelectPet3);
		lblPetName1.setOpaque(true);
		lblPetName1.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		lblPetName1.setBounds(87, 259, 119, 33);

		panelPets.add(lblPetName1);
		lblPetName2.setOpaque(true);
		lblPetName2.setBounds(346, 259, 119, 33);

		panelPets.add(lblPetName2);
		lblPetName3.setOpaque(true);
		lblPetName3.setBounds(220, 550, 119, 33);

		panelPets.add(lblPetName3);

		panelHelp.setVisible(false);
		panelHelp.setBackground(Color.RED);
		panelHelp.setBounds(0, 0, 1199, 705);

		frame.getContentPane().add(panelHelp);
		panelHelp.setLayout(null);

		lblHelp.setVerticalTextPosition(SwingConstants.TOP);
		lblHelp.setVerticalAlignment(SwingConstants.TOP);

		lblHelp.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblHelp.setHorizontalTextPosition(SwingConstants.LEFT);
		lblHelp.setHorizontalAlignment(SwingConstants.LEFT);
		lblHelp.setOpaque(true);
		lblHelp.setBounds(132, 417, 935, 200);
		panelHelp.add(lblHelp);
		lblWelcome2.setForeground(Color.WHITE);
		lblWelcome2.setHorizontalTextPosition(SwingConstants.CENTER);
		lblWelcome2.setHorizontalAlignment(SwingConstants.CENTER);
		lblWelcome2.setFont(new Font("Dialog", Font.BOLD, 65));
		lblWelcome2.setBounds(245, 72, 704, 290);
		panelHelp.add(lblWelcome2);
		lblContinue.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblContinue.setOpaque(true);
		lblContinue.setBounds(132, 617, 215, 47);

		panelHelp.add(lblContinue);
		lblHelpcounter.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblHelpcounter.setOpaque(true);
		lblHelpcounter.setBounds(309, 617, 758, 47);

		panelHelp.add(lblHelpcounter);

		clickPanel.setOpaque(false);
		clickPanel.setBounds(-140, 178, 1131, 598);

		panelHelp.add(clickPanel);
		lblNewLabel_12.setIcon(new ImageIcon(GUI.class.getResource("/photo/Pets-Background.png")));
		lblNewLabel_12.setBounds(-31, -49, 1273, 850);

		panelHelp.add(lblNewLabel_12);
		panelPet.setBackground(Color.DARK_GRAY);
		panelPet.setVisible(false);
		panelPet.setBounds(0, 0, 1213, 718);
		
				frame.getContentPane().add(panelPet);
				panelPet.setLayout(null);
				lblpetdetails.setBackground(Color.LIGHT_GRAY);
				lblpetdetails.setOpaque(true);
				lblpetdetails.setBounds(12, 12, 607, 358);
				
						panelPet.add(lblpetdetails);
						
								btnPlayerContinue.addActionListener(new ActionListener() {
									public void actionPerformed(ActionEvent e) {
										if (rdbtn1player.isSelected() == true) {
											rdbtn1player.setSelected(false);
											inputDayNum();
											return;
										}
										if (rdbtn2players.isSelected() == true) {
											rdbtn2players.setSelected(false);
											inputDayNum();
											return;
										}
										if (rdbtn3players.isSelected() == true) {
											rdbtn3players.setSelected(false);
											inputDayNum();
											return;
										}
									}
								});
								rdbtn1player.setSelected(true);
								
										rdbtn1player.addActionListener(new ActionListener() {
											public void actionPerformed(ActionEvent e) {
												numOfPlayers = 1;
											}
										});
										
												rdbtn2players.addActionListener(new ActionListener() {
													public void actionPerformed(ActionEvent e) {
														numOfPlayers = 2;
													}
												});
												
														rdbtn3players.addActionListener(new ActionListener() {
															public void actionPerformed(ActionEvent e) {
																numOfPlayers = 3;
															}
														});
														panelInput.setBackground(Color.WHITE);
														panelInput.setVisible(false);
														
																panelInput.setBounds(0, 0, 1213, 718);
																frame.getContentPane().add(panelInput);
																panelInput.setLayout(null);
																rdbtn3players.setVerticalTextPosition(SwingConstants.BOTTOM);
																rdbtn3players.setHorizontalTextPosition(SwingConstants.CENTER);
																rdbtn3players.setHorizontalAlignment(SwingConstants.CENTER);
																rdbtn3players.setOpaque(false);
																
																		rdbtn3players.setBounds(629, 427, 232, 67);
																		panelInput.add(rdbtn3players);
																		rdbtn1player.setVerticalTextPosition(SwingConstants.BOTTOM);
																		rdbtn1player.setHorizontalTextPosition(SwingConstants.CENTER);
																		rdbtn1player.setHorizontalAlignment(SwingConstants.CENTER);
																		
																				rdbtn1player.setOpaque(false);
																				rdbtn1player.setSize(new Dimension(20, 20));
																				rdbtn1player.setBounds(243, 427, 232, 67);
																				panelInput.add(rdbtn1player);
																				rdbtn2players.setVerticalTextPosition(SwingConstants.BOTTOM);
																				rdbtn2players.setHorizontalTextPosition(SwingConstants.CENTER);
																				rdbtn2players.setHorizontalAlignment(SwingConstants.CENTER);
																				rdbtn2players.setOpaque(false);
																				rdbtn2players.setSize(new Dimension(20, 20));
																				rdbtn2players.setBounds(429, 427, 232, 67);
																				panelInput.add(rdbtn2players);
																				
																						radioGroupPlayers.add(rdbtn1player);
																						radioGroupPlayers.add(rdbtn2players);
																						radioGroupPlayers.add(rdbtn3players);
																						JLabel lblwelcomeToPets = new JLabel("<html>Welcome to Pets <br>the virtual pet  game!");
																						lblwelcomeToPets.setForeground(Color.WHITE);
																						lblwelcomeToPets.setHorizontalTextPosition(SwingConstants.CENTER);
																						lblwelcomeToPets.setHorizontalAlignment(SwingConstants.CENTER);
																						lblwelcomeToPets.setFont(new Font("Dialog", Font.BOLD, 65));
																						lblwelcomeToPets.setBackground(Color.WHITE);
																						lblwelcomeToPets.setBounds(210, 99, 879, 217);
																						panelInput.add(lblwelcomeToPets);
																						
																								panelInput.add(rdbtn2players);
																								lblPlayerNum.setForeground(Color.WHITE);
																								lblPlayerNum.setFont(new Font("Dialog", Font.BOLD, 22));
																								lblPlayerNum.setHorizontalTextPosition(SwingConstants.CENTER);
																								lblPlayerNum.setHorizontalAlignment(SwingConstants.CENTER);
																								lblPlayerNum.setBounds(253, 488, 702, 108);
																								
																										panelInput.add(lblPlayerNum);
																										
																												btnPlayerContinue.setVerticalAlignment(SwingConstants.BOTTOM);
																												btnPlayerContinue.setBounds(510, 605, 193, 78);
																												panelInput.add(btnPlayerContinue);
																												
																														btnPlayerContinue2.setVerticalAlignment(SwingConstants.BOTTOM);
																														btnPlayerContinue2.setBounds(510, 622, 193, 61);
																														
																																panelInput.add(btnPlayerContinue2);
																																
																																		spinnerDayNum.setVisible(false);
																																		spinnerDayNum.setModel(new SpinnerNumberModel(1.0, 1.0, 19.0, 1.0));
																																		spinnerDayNum.setBounds(584, 470, 57, 46);
																																		panelInput.add(spinnerDayNum);
																																		lblBackgroundIcon.setIcon(new ImageIcon(GUI.class.getResource("/photo/Pets-Background.png")));
																																		lblBackgroundIcon.setBounds(-19, -304, 1243, 1048);
																																		
																																				panelInput.add(lblBackgroundIcon);
																																				panelStart.setBackground(Color.BLUE);
																																				panelStart.setForeground(Color.RED);
																																				panelStart.setBounds(0, 0, 1213, 718);
																																				
																																						frame.getContentPane().add(panelStart);
																																						panelStart.setLayout(null);
																																						
																																								btnHelp.setBounds(550, 542, 179, 48);
																																								panelStart.add(btnHelp);
																																								
																																										btnStart.setBounds(550, 439, 179, 48);
																																										panelStart.add(btnStart);
																																										lblWelcome.setForeground(Color.WHITE);
																																										lblWelcome.setBackground(new Color(255, 255, 255));
																																										lblWelcome.setBounds(298, 99, 817, 225);
																																										panelStart.add(lblWelcome);
																																										lblWelcome.setFont(new Font("Dialog", Font.BOLD, 65));
																																										lblWelcome.setHorizontalTextPosition(SwingConstants.CENTER);
																																										lblWelcome.setHorizontalAlignment(SwingConstants.CENTER);
																																										lblBackgroundstart.setIcon(new ImageIcon(GUI.class.getResource("/photo/Pets-Background.png")));
																																										lblBackgroundstart.setBounds(-30, -231, 1365, 981);
																																										
																																												panelStart.add(lblBackgroundstart);

		btnPetSelect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelButtons.setVisible(false);
				panelPets.setVisible(true);
				selectPet();
			}
		});
		btnEndDay.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evt) {
				btnEndDay.setBackground(Color.GREEN);
			}

			public void mouseExited(java.awt.event.MouseEvent evt) {
				btnEndDay.setBackground(UIManager.getColor("control"));
			}
		});

	}

	public void guiMainButtons() {
		btnSleep.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (globalCurrentPet == null) {
					lblEventOutputs.setText("You need to select a pet first!");
				} else {
					if (globalCurrentPet.getActions() == 0) {

						lblEventOutputs.setText("Sorry! This pet has already taken 2 actions today.");
					} else {
						sleep();
						lblPetAttributes.setText(globalCurrentPet.toString());
					}
				}
			}
		});

		btnUseToilet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (globalCurrentPet == null) {
					lblEventOutputs.setText("You need to select a pet first!");
					;
				} else {
					if (globalCurrentPet.getActions() == 0) {
						lblEventOutputs.setText("Sorry! This pet has already taken 2 actions today.");
					} else {
						toilet();
						lblPetAttributes.setText(globalCurrentPet.toString());
					}
				}
			}
		});

		btnPunishPet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (globalCurrentPet == null) {
					lblEventOutputs.setText("You need to select a pet first!");
				} else {
					punish();
					lblPetAttributes.setText(globalCurrentPet.toString());
				}
			}
		});

		btnRevive.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				revive();
			}
		});

		btnVisitDoctor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				doctor();
			}
		});

	}

	public void mainScreenHelper() {
		Map<Player, Integer> playerScores = new HashMap<Player, Integer>();

		for (Map.Entry<Integer, Player> entry : players.entrySet()) {
			Player val = entry.getValue();
			globalCurrentPlayer = val;
			playerDaysTaken = 0;
			mainSelectScreen();
			System.out.format("Days for %s ended, you scored a total of %d points overall, well done!", val.getName(),
					score(val));
			playerScores.put(val, score(val));
			promptEnterKey();
		}
		System.out.println("Game Over...");
		System.out.println("Total scores for game:");

		for (Player key : playerScores.keySet()) {
			System.out.format("%s: %d\n", key.getName(), playerScores.get(key));
		}
	}

	public void mainScreenText() {

		// Properties prop = new Properties();
		// InputStream input = null;

		// try {
		//
		// input = new FileInputStream("config.properties");
		// // load a properties file
		// prop.load(input);
		// // get the property value and print it out
		// System.out.println((prop.getProperty("main")));
		// } catch (IOException ex) {
		// ex.printStackTrace();
		// } finally {
		// if (input != null) {
		// try {
		// input.close();
		// } catch (IOException e) {
		// e.printStackTrace();
		// }
		// }
		// }
	}

	public void selectPet() {
		panelPets.setVisible(true);
		panelButtons.setVisible(false);
		Species button1 = null;
		Species button2 = null;
		Species button3 = null;

		Species[] species = { button1, button2, button3 };
		JButton[] jButtons = { btnSelectPet1, btnSelectPet2, btnSelectPet3 };
		JLabel[] jLabels = { lblPetName1, lblPetName2, lblPetName3 };
		int i = 0;
		for (Map.Entry<String, Species> entry : globalCurrentPlayer.getPets().entrySet()) {
			jButtons[i].setVisible(true);
			species[i] = entry.getValue();
			if (entry.getValue().getSpecies() == penguin.getSpecies()) {
				jButtons[i].setIcon(new ImageIcon(GUI.class.getResource("/photo/PENG_PET.png")));
				jLabels[i].setText(entry.getValue().getName());
			} else if (entry.getValue().getSpecies() == crab.getSpecies()) {
				jButtons[i].setIcon(new ImageIcon(GUI.class.getResource("/photo/CRAB_PET-1.png")));
				jLabels[i].setText(entry.getValue().getName());
			} else if (entry.getValue().getSpecies() == robot.getSpecies()) {
				jButtons[i].setIcon(new ImageIcon(GUI.class.getResource("/photo/ROBOT_PET.png")));
				jLabels[i].setText(entry.getValue().getName());
			} else if (entry.getValue().getSpecies() == snake.getSpecies()) {
				jButtons[i].setIcon(new ImageIcon(GUI.class.getResource("/photo/SNAKE_PET.png")));
				jLabels[i].setText(entry.getValue().getName());
			} else if (entry.getValue().getSpecies() == cloud.getSpecies()) {
				jButtons[i].setIcon(new ImageIcon(GUI.class.getResource("/photo/CLOUD_PET.png")));
				jLabels[i].setText(entry.getValue().getName());
			} else if (entry.getValue().getSpecies() == monster.getSpecies()) {
				jButtons[i].setIcon(new ImageIcon(GUI.class.getResource("/photo/MONSTER_PET.png")));
				jLabels[i].setText(entry.getValue().getName());
			}
			i++;
		}
		btnSelectPet1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (btnSelectPet1.getIcon() != null) {
					globalCurrentPet = species[0];
					currentSelectedPet();
					panelButtons.setVisible(true);
					panelPets.setVisible(false);
					mainSelectScreen();
				}
			}
		});
		btnSelectPet2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (btnSelectPet2.getIcon() != null) {
					globalCurrentPet = species[1];
					currentSelectedPet();
					panelButtons.setVisible(true);
					panelPets.setVisible(false);
					mainSelectScreen();
				}
			}
		});
		btnSelectPet3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (btnSelectPet3.getIcon() != null) {
					globalCurrentPet = species[2];
					currentSelectedPet();
					panelButtons.setVisible(true);
					panelPets.setVisible(false);
					mainSelectScreen();
				}
			}
		});

	}

	public void currentSelectedPet() {
		lblCurrentPet.setText(globalCurrentPet.getName());
		lblPetAttributes.setText(globalCurrentPet.toString());
		if (globalCurrentPet.getSpecies() == penguin.getSpecies()) {
			lblCurrentSelectedPet.setIcon(new ImageIcon(GUI.class.getResource("/photo/PENG_PET.png")));
		} else if (globalCurrentPet.getSpecies() == crab.getSpecies()) {
			lblCurrentSelectedPet.setIcon(new ImageIcon(GUI.class.getResource("/photo/CRAB_PET-1.png")));

		} else if (globalCurrentPet.getSpecies() == robot.getSpecies()) {
			lblCurrentSelectedPet.setIcon(new ImageIcon(GUI.class.getResource("/photo/ROBOT_PET.png")));

		} else if (globalCurrentPet.getSpecies() == snake.getSpecies()) {
			lblCurrentSelectedPet.setIcon(new ImageIcon(GUI.class.getResource("/photo/SNAKE_PET.png")));

		} else if (globalCurrentPet.getSpecies() == cloud.getSpecies()) {
			lblCurrentSelectedPet.setIcon(new ImageIcon(GUI.class.getResource("/photo/CLOUD_PET.png")));

		} else if (globalCurrentPet.getSpecies() == monster.getSpecies()) {
			lblCurrentSelectedPet.setIcon(new ImageIcon(GUI.class.getResource("/photo/MONSTER_PET.png")));

		}

	}

	public void mainSelectScreen() {

		panelCreation.setVisible(false);
		panelMainScreen.setVisible(true);
		lblCurrentPlayer.setText(globalCurrentPlayer.getName());
		lblCurrentDay.setText(String.format("%d", globalCurrentDay));
		lblDayTotals.setText(String.format("/%1$,.0f", gameDays));

		// String input = null;
		// @SuppressWarnings("resource")
		// Scanner scan = new Scanner(System.in);
		//
		// do {
		// if (input != null) {
		// System.out
		// .println("\nYou have entered an invalid number," + "please enter a
		// number between 1 and 8.\n");
		// promptEnterKey();
		// }
		// System.out.format("Current Player: %s\n", globalCurrentPlayer);
		// System.out.format("Days remaining: %1$.0f\n", (gameDays -
		// playerDaysTaken));
		// System.out.format("Current balance: $%d\n",
		// globalCurrentPlayer.getBalance());
		// System.out.format("Owned pets (actions remanining):\n");
		// for (Species pet : globalCurrentPlayer.getPets().values()) {
		// System.out.format("%s (%d)\n", pet.getName(), pet.getActions());
		// }
		// if (globalCurrentPet == null) {
		// System.out.println("Current pet selected: NONE (select a pet to
		// interact with it).");
		// } else {
		// System.out.format("Current pet selected: %s \n\n",
		// globalCurrentPet.getName());
		// }
		// mainScreenText();
		// input = scan.nextLine();
		// }
		//
		// while (!input.matches("[1-9]" + "[0]*"));
		// int intInput = Integer.parseInt(input);
		//
		// switch (intInput) {
		// case 1:
		// globalCurrentPet = selectPet(globalCurrentPlayer);
		// mainSelectScreen();
		// break;
		// case 2:
		// if (globalCurrentPet == null) {
		// System.out.println("You need to select a pet first!");
		// promptEnterKey();
		// mainSelectScreen();
		// } else {
		// System.out.println(globalCurrentPet);
		// promptEnterKey();
		// mainSelectScreen();
		// }
		// break;
		// case 3:
		// store(globalCurrentPlayer);
		// mainSelectScreen();
		// break;
		// case 4:
		// if (globalCurrentPet == null) {
		// System.out.println("You need to select a pet first!");
		// promptEnterKey();
		// mainSelectScreen();
		// } else {
		// if (globalCurrentPet.getActions() == 0) {
		// System.out.println("Sorry! This pet has already taken 2 actions
		// today.");
		// promptEnterKey();
		// } else {
		// feedPet(globalCurrentPlayer);
		// }
		// promptEnterKey();
		// mainSelectScreen();
		// break;
		// }
		// case 5:
		//
		// break;
		// case 6:
		// if (globalCurrentPet == null) {
		// System.out.println("You need to select a pet first!");// error
		// // window
		// // in
		// // GUI
		// promptEnterKey();
		// mainSelectScreen();
		// } else {
		// if (globalCurrentPet.getActions() == 0) {
		// System.out.println("Sorry! This pet has already taken 2 actions
		// today.");
		// promptEnterKey();
		// } else {
		// play(globalCurrentPlayer);
		// }
		// promptEnterKey();
		// mainSelectScreen();
		// }
		// break;
		// case 7:
		// if (globalCurrentPet == null) {
		// System.out.println("You need to select a pet first!");// error
		// // window
		// // in
		// // GUI
		// promptEnterKey();
		// mainSelectScreen();
		// } else {
		// if (globalCurrentPet.getActions() == 0) {
		// System.out.println("Sorry! This pet has already taken 2 actions
		// today.");
		// } else {
		// toilet();
		// }
		// promptEnterKey();
		// mainSelectScreen();
		// }
		// break;
		// case 8:
		// if (globalCurrentPet == null) {
		// System.out.println("You need to select a pet first!");// error
		// // window
		// // in
		// // GUI
		// promptEnterKey();
		// mainSelectScreen();
		// } else {
		// if (globalCurrentPet.getActions() == 0) {
		// System.out.println("Sorry! This pet has already taken 2 actions
		// today.");
		// } else {
		// System.out.format("%s is upset, but is now under control",
		// globalCurrentPet);
		// punish();
		// }
		// promptEnterKey();
		// mainSelectScreen();
		// }
		// break;
		// case 9:
		// if (globalCurrentPet == null) {
		// System.out.println("You need to select a pet first!");// error
		// // window
		// // in
		// // GUI
		// promptEnterKey();
		// mainSelectScreen();
		// } else {
		// if (globalCurrentPet.getActions() == 0) {
		// System.out.println("Sorry! This pet has already taken 2 actions
		// today.");
		// } else {
		// doctor();
		// }
		// promptEnterKey();
		// mainSelectScreen();
		// }
		// break;
		// case 10:
		// endDay(globalCurrentPlayer);
		// playerDaysTaken++;
		// System.out.println(playerDaysTaken);
		// System.out.println(gameDays);
		// promptEnterKey();
		// if (playerDaysTaken < gameDays) {
		// mainSelectScreen();
		// break;
		// }
		//
		// }
	}

	public void punish() {
		if (globalCurrentPet.getMisbehaving() == true) {
			lblEventOutputs.setText(String.format("%s is upset, but can focus better (can have 2 actions again)",
					globalCurrentPet.getName()));
			globalCurrentPet.punish();
		} else {
			lblEventOutputs.setText(String.format("%s isn't misbehaving!", globalCurrentPet.getName()));

		}

	}

	public void revive() {
		if (globalCurrentPet == null) {
			lblEventOutputs.setText("You need to select a pet first!");
		} else if (globalCurrentPet.getAlive() == false && globalCurrentPet.getRevive() == true) {
			globalCurrentPet.setRevive(false);
			lblEventOutputs.setText("Your pet has revived!");
		} else if (globalCurrentPet.getAlive() == true) {
			lblEventOutputs.setText("Your pet is already alive!");
		} else {
			lblEventOutputs.setText("Sorry, your pet is only allowed to revive once! ");
		}
	}

	public void doctor() {

		if (globalCurrentPet == null) {
			lblEventOutputs.setText("You need to select a pet first!");
		} else {
			if (globalCurrentPet.getActions() == 0) {
				lblEventOutputs.setText("Sorry! This pet has already taken 2 actions today.");
			} else if (globalCurrentPet.getSick() == true) {
				globalCurrentPet.heal();
				lblEventOutputs.setText(String.format("%s isn't sick anymore!", globalCurrentPet.getName()));
				lblPetAttributes.setText(globalCurrentPet.toString());
			} else {
				globalCurrentPet.heal();
				lblPetAttributes.setText(globalCurrentPet.toString());
				lblEventOutputs.setText(String.format("%s is feeling healthier!", globalCurrentPet.getName()));
			}
		}
	}

	public void gameStart() {
		panelStart.setVisible(true);
		panelHelp.setVisible(false);
		btnHelp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textCounter = 1;
				panelStart.setVisible(false);
				panelHelp.setVisible(true);
				clickPanel.setVisible(true);
				lblHelp.setText("");

			}
		});

		clickPanel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				if (textCounter == 1) {
					lblHelp.setText(help1);
				}
				if (textCounter == 2) {
					lblHelp.setText(help2);
				}
				if (textCounter == 3) {
					lblHelp.setText(help3);
				}
				if (textCounter == 4) {
					lblHelp.setText(help4);
				}
				if (textCounter == 5) {
					lblHelp.setText(help5);
				}
				if (textCounter == 6) {
					panelStart.setVisible(true);
					panelHelp.setVisible(false);
					textCounter = 1;
				}
				textCounter++;
			}
		});

		btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				inputPlayerNum();
			}
		});
	}

	public void inputPlayerNum() {
		panelInput.setVisible(true);
		panelStart.setVisible(false);
		panelHelp.setVisible(false);

		// @SuppressWarnings("resource")
		// Scanner scan = new Scanner(System.in);
		// String strPlayerNum = null;
		//
		// do{
		// if (strPlayerNum != null){
		// System.out.println("You have entered an invalid number, please enter
		// a number between 1 and 3.\n");
		// }
		// System.out.println("How many players would like to play the game?
		// (max 3).");
		// strPlayerNum = scan.nextLine();
		// }
		// while(!strPlayerNum.matches("[1-3]"));
		//
		// System.out.format("You have selected %s player/s.%n", strPlayerNum);
		// numOfPlayers = Integer.parseInt(strPlayerNum);
	}

	public void inputDayNum() {
		gameDays = 0;

		spinnerDayNum.setVisible(true);
		lblPlayerNum.setText("How many days will the game run for?");
		rdbtn1player.setVisible(false);
		rdbtn2players.setVisible(false);
		rdbtn3players.setVisible(false);
		btnPlayerContinue.setVisible(false);
		btnPlayerContinue2.setVisible(true);

		btnPlayerContinue2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gameDays = (Double) spinnerDayNum.getValue();
				createPlayers();
			}
		});
	}

	public void createPlayers() {
		textCounter = 1;
		panelInput.setVisible(false);
		panelCreation.setVisible(true);
		String currentPlayer;
		lblNamePrompt.setText(
				String.format("Player %d, enter your name here and select up to 3 pets above before clicking continue.",
						textCounter));
		//
		// Player newPlayer = new Player(name);
		// addPlayer(newPlayer);

		btnCreationContinue.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textFieldCreation.grabFocus();
				if (textFieldCreation.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "You need to enter a name for your player!",
							"InfoBox: " + "Warning", JOptionPane.INFORMATION_MESSAGE);
				} else if (boxCounter() > 3 || boxCounter() == 0) {
					JOptionPane.showMessageDialog(null, "You need to select 1-3 Pets for you to own!",
							"InfoBox: " + "Warning", JOptionPane.INFORMATION_MESSAGE);
				} else if (petNameChecker() == false) {
					JOptionPane.showMessageDialog(null, "One or more of your selected pets does not have a name yet!",
							"InfoBox: " + "Warning", JOptionPane.INFORMATION_MESSAGE);
				} else if (existingNameChecker(textFieldCreation.getText()) == true) {
					JOptionPane.showMessageDialog(frame, "That name belongs to another player, please choose another.");

				} else if (textCounter >= numOfPlayers) {
					Player newPlayerFinal = new Player(textFieldCreation.getText());
					addPlayer(newPlayerFinal, textCounter);
					textFieldCreation.setText("");
					createPets(newPlayerFinal);
					clearBoxes();
					globalCurrentPlayer = players.get(1);
					globalCurrentDay = 1;
					mainSelectScreen();

				} else if (textCounter == 1) {
					Player newPlayer1 = new Player(textFieldCreation.getText());
					addPlayer(newPlayer1, 1);
					createPets(newPlayer1);
					textFieldCreation.setText("");
					lblNamePrompt.setText(String.format(
							"Player %d, enter your name here and select up to 3 pets above before clicking continue.",
							2));
					textCounter++;
					clearBoxes();

				} else if (textCounter == 2) {
					Player newPlayer2 = new Player(textFieldCreation.getText());
					addPlayer(newPlayer2, 2);
					createPets(newPlayer2);
					textFieldCreation.setText("");
					lblNamePrompt.setText(String.format(
							"Player %d, enter your name here and select up to 3 pets above before clicking continue.",
							3));
					textCounter++;
					clearBoxes();
				} else if (textCounter == 3) {
					Player newPlayer3 = new Player(textFieldCreation.getText());
					addPlayer(newPlayer3, 3);
					createPets(newPlayer3);
					textFieldCreation.setText("");
					lblNamePrompt.setText(String.format(
							"Player %d, enter your name here and select up to 3 pets above before clicking continue.",
							4));
					textCounter++;
					clearBoxes();
				} else if (textCounter == 4) {
					Player newPlayer4 = new Player(textFieldCreation.getText());
					addPlayer(newPlayer4, 4);
					createPets(newPlayer4);
					textFieldCreation.setText("");
					// promptPetCreation();
					textCounter = 1;
					clearBoxes();
				}

			}
		});
	}

	public void clearBoxes() {
		txtPetName1.setText("Enter a name...");
		txtPetName2.setText("Enter a name...");
		txtPetName3.setText("Enter a name...");
		txtPetName4.setText("Enter a name...");
		txtPetName5.setText("Enter a name...");
		txtPetName6.setText("Enter a name...");
		chckbxPet1.setSelected(false);
		chckbxPet2.setSelected(false);
		chckbxPet3.setSelected(false);
		chckbxPet4.setSelected(false);
		chckbxPet5.setSelected(false);
		chckbxPet6.setSelected(false);
	}

	public boolean existingNameChecker(String name) {
		return (players.keySet().contains(textFieldCreation.getText()));

	}

	public int boxCounter() {
		int counter = 0;
		if (chckbxPet1.isSelected()) {
			counter++;
		}
		if (chckbxPet2.isSelected()) {
			counter++;
		}
		if (chckbxPet3.isSelected()) {
			counter++;
		}
		if (chckbxPet4.isSelected()) {
			counter++;
		}
		if (chckbxPet5.isSelected()) {
			counter++;
		}
		if (chckbxPet6.isSelected()) {
			counter++;
		}
		return counter;
	}

	public void playerNameChecker() {
		if (textFieldCreation.equals("")) {

		}
	}

	public boolean petNameChecker() {
		if ((chckbxPet1.isSelected()) && (txtPetName1.getText().equals("Enter a name..."))) {
			return false;
		} else if ((chckbxPet2.isSelected()) && (txtPetName2.getText().equals("Enter a name..."))) {
			return false;
		} else if ((chckbxPet3.isSelected()) && (txtPetName3.getText().equals("Enter a name..."))) {
			return false;
		} else if ((chckbxPet4.isSelected()) && (txtPetName4.getText().equals("Enter a name..."))) {
			return false;
		} else if ((chckbxPet5.isSelected()) && (txtPetName5.getText().equals("Enter a name..."))) {
			return false;
		} else if ((chckbxPet6.isSelected()) && (txtPetName6.getText().equals("Enter a name..."))) {
			return false;
		} else {
			return true;
		}

	}

	public void promptPetCreation() {
		textCounter = 1;
		textFieldCreation.setEditable(false);
		lblNamePrompt
				.setText(String.format("%s, please select up to 3 Pets to own.", players.get(textCounter).getName()));
		List<Player> playerPets = new ArrayList<Player>();
		for (Map.Entry<Integer, Player> entry : players.entrySet()) {

		}
		btnPetCounter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (textCounter > numOfPlayers) {
					System.out.println("next thing");

				} else if (boxCounter() > 3 || boxCounter() == 0) {
					JOptionPane.showMessageDialog(null, "You need to select 1-3 Pets for you to own!",
							"InfoBox: " + "Warning", JOptionPane.INFORMATION_MESSAGE);
				} else if (textCounter == 1) {
					createPets(players.get(textCounter));
					textCounter++;

				} else if (textCounter == 2) {
					createPets(players.get(textCounter));
					textCounter++;

				} else if (textCounter == 3) {
					createPets(players.get(textCounter));
					textCounter++;

				} else if (textCounter == 4) {

				}
			}
		});
		lblSelectUpTo.setVisible(true);
		txtPetName1.setVisible(true);
		txtPetName2.setVisible(true);
		txtPetName3.setVisible(true);
		txtPetName4.setVisible(true);
		txtPetName5.setVisible(true);
		txtPetName6.setVisible(true);
		btnPetCounter.setVisible(true);
		btnCreationContinue.setVisible(false);
		lblNewLabel.setVisible(true);
		lblNewLabel_1.setVisible(true);
		lblNewLabel_2.setVisible(true);
		lblBeng.setVisible(true);
		lblNewLabel_4.setVisible(true);
		lblNewLabel_5.setVisible(true);
		lblNewLabel6.setVisible(true);
		lblNewLabel.setVisible(true);
		lblNewLabel.setVisible(true);
		lblNewLabel.setVisible(true);
		lblNewLabel.setVisible(true);
		chckbxPet1.setVisible(true);
		chckbxPet2.setVisible(true);
		chckbxPet3.setVisible(true);
		chckbxPet4.setVisible(true);
		chckbxPet5.setVisible(true);
		chckbxPet6.setVisible(true);
		// textFieldCreation.setVisible(false);
		// btnCreationContinue.setVisible(false);
		// btnPetCounter.setVisible(true);
		// int textCounter = 1;
		// spinnerPetNum.setVisible(true);
		// lblNamePrompt.setText(String.format("%s, please choose up to 3 pets
		// to own", players.get(textCounter).getName()));

		// for (Map.Entry<Integer, Player> entry : players.entrySet()){
		// Player player = entry.getValue();
		// String strPetNum = null;
		// do{
		// if (strPetNum != null){
		// System.out.println("\nYou have entered an invalid number,"
		// + "please enter a number between 1 and 3.\n");
		// }
		// System.out.format("How many pets would %s like to own? (max 3).",
		// player.name);
		// strPetNum = scan.nextLine();
		// }
		// while(!strPetNum.matches("[1-3]"));
		//
		// System.out.format("You have selected %s pet/s.\n\n", strPetNum);
		// int intPetNum = Integer.parseInt(strPetNum);
		// promptSpecies(player, intPetNum);
		// }
	}

	public void store(Player player) {
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		String itemSelect = null;
		storeHelper();
		System.out.println(player);
		System.out.println();

		do {
			if (itemSelect != null) {
				System.out.println("\nYou have entered an invalid number, please try again.\n");
			}
			System.out.format("%s, enter an item number to add it to your inventory.\n", player.getName());
			itemSelect = scan.nextLine();
		} while (!itemSelect.matches("[1-9]" + "[0-3]*"));
		int intItemSelect = Integer.parseInt(itemSelect);

		switch (intItemSelect) {
		case 1:
			if ((player.getBalance() - cookie.getPrice()) < 0) {
				System.out.println("You don't have enough money to make this purchase");
				promptEnterKey();

			} else {
				player.addFood(cookie);
				player.setBalance((player.getBalance() - cookie.getPrice()));
			}
			store(player);
			break;
		case 2:
			if ((player.getBalance() - melon.getPrice()) < 0) {
				System.out.println("You don't have enough money to make this purchase");
				promptEnterKey();
			} else {
				player.addFood(melon);
				player.setBalance((player.getBalance() - melon.getPrice()));
			}
			store(player);
			break;
		case 3:
			if ((player.getBalance() - fish.getPrice()) < 0) {
				System.out.println("You don't have enough money to make this purchase");
				promptEnterKey();
			} else {
				player.addFood(fish);
				player.setBalance((player.getBalance() - fish.getPrice()));
			}
			store(player);
			break;
		case 4:
			if ((player.getBalance() - chocolate.getPrice()) < 0) {
				System.out.println("You don't have enough money to make this purchase");
				promptEnterKey();
			} else {
				player.addFood(chocolate);
				player.setBalance((player.getBalance() - chocolate.getPrice()));
			}
			store(player);
			break;
		case 5:
			if ((player.getBalance() - cake.getPrice()) < 0) {
				System.out.println("You don't have enough money to make this purchase");
				promptEnterKey();
			} else {
				player.addFood(cake);
				player.setBalance((player.getBalance() - cake.getPrice()));
			}
			store(player);
			break;
		case 6:
			if ((player.getBalance() - pizza.getPrice()) < 0) {
				System.out.println("You don't have enough money to make this purchase");
				promptEnterKey();
			} else {
				player.addFood(pizza);
				player.setBalance((player.getBalance() - pizza.getPrice()));
			}
			store(player);
			break;
		case 7:
			if ((player.getBalance() - yoyo.getPrice()) < 0) {
				System.out.println("You don't have enough money to make this purchase");
				promptEnterKey();
			} else {
				// yoyo
				Toy newToy = new Toy(toyChoices.get(6));
				player.addToy(newToy);
				player.setBalance((player.getBalance() - yoyo.getPrice()));
			}
			store(player);
			break;
		case 8:
			// doll
			if ((player.getBalance() - doll.getPrice()) < 0) {
				System.out.println("You don't have enough money to make this purchase");
				promptEnterKey();
			} else {
				Toy newToy = new Toy(toyChoices.get(3));
				player.addToy(newToy);
				player.setBalance((player.getBalance() - doll.getPrice()));
			}
			store(player);
			break;
		case 9:
			// bear
			if ((player.getBalance() - bear.getPrice()) < 0) {
				System.out.println("You don't have enough money to make this purchase");
				promptEnterKey();
			} else {
				Toy newToy = new Toy(toyChoices.get(1));
				player.addToy(newToy);
				player.setBalance((player.getBalance() - bear.getPrice()));
			}
			store(player);
			break;
		case 10:
			// kite
			if ((player.getBalance() - kite.getPrice()) < 0) {
				System.out.println("You don't have enough money to make this purchase");
				promptEnterKey();
			} else {
				Toy newToy = new Toy(toyChoices.get(5));
				player.addToy(newToy);
				player.setBalance((player.getBalance() - kite.getPrice()));
			}
			store(player);
			break;
		case 11:
			// boat
			if ((player.getBalance() - boat.getPrice()) < 0) {
				System.out.println("You don't have enough money to make this purchase");
				promptEnterKey();
			} else {
				Toy newToy = new Toy(toyChoices.get(2));
				player.addToy(newToy);
				player.setBalance((player.getBalance() - boat.getPrice()));
			}
			store(player);
			break;
		case 12:
			// helicopter
			if ((player.getBalance() - heli.getPrice()) < 0) {
				System.out.println("You don't have enough money to make this purchase");
				promptEnterKey();
			} else {
				Toy newToy = new Toy(toyChoices.get(4));
				player.addToy(newToy);
				player.setBalance((player.getBalance() - heli.getPrice()));
			}
			store(player);
			break;
		case 13:
			mainSelectScreen();
			break;
		}
	}

	public void storeHelper() {
		Properties prop = new Properties();
		InputStream input = null;
		try {
			input = new FileInputStream("config.properties");
			// load a properties file
			prop.load(input);
			// get the property value and print it out
			System.out.println(prop.getProperty("store"));
		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public int score(Player player) {
		int score = 0;

		for (Map.Entry<String, Species> entry : player.getPets().entrySet()) {
			Species pet = entry.getValue();
			score += pet.getHealth();
		}
		return score;
	}

	public void endDay(Player player) {
		for (Map.Entry<String, Species> entry : player.getPets().entrySet()) {
			Species pet = entry.getValue();
			pet.endDay();
			// return ("Your pet died from a random illness!");
			// return("If the pet has not died before, he can be revived from
			// the doctor!");

			// "%s is sick! This causes your pet to waste 1 action per day.",
			// this.name +
			// "Your pet can be treated at the doctor's (this will use an
			// action).");

			// return String.format("%s is misbehaving! This causes your pet to
			// lose 1 action per day.", this.name +
			// " Your pet can be punished (this will use an action).");
		}
	}

	public void toilet() {
		globalCurrentPet.toilet();
		lblEventOutputs.setText(String.format("%s feels relieved.", globalCurrentPet.getName()));
	}

	public void sleep() {
		lblEventOutputs.setText(String.format("%s feels refreshed!", globalCurrentPet.getName()));
		globalCurrentPet.sleep();
	}

	public void play(Player player) {
		// return String.format("%s is feeling happier!\n", name);
		Map<Integer, Toy> currentToys = new HashMap<Integer, Toy>();
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		String toySelect = null;
		int i = 1;
		if (player.getToys().isEmpty()) {
			System.out.println("You don't have any toys! Visit the store to buy some.");
			promptEnterKey();
		} else {
			for (Map.Entry<Toy, Integer> entry : player.getToys().entrySet()) {
				Toy toy = entry.getKey();
				currentToys.put(i, toy);
				int val = entry.getValue();
				System.out.format("\n%d(durability). %s(%s)", i, toy.getName(), toy.getDurability());
				i++;
			}
			System.out.format("\n\n%d. quit.", 7);
			do {
				if (toySelect != null) {
					System.out.println("\nYou have entered an invalid number\n");
					promptEnterKey();
				}
				System.out.format("\nSelect a toy to give to %s.", globalCurrentPet.getName());
				toySelect = scan.nextLine();
			} while (!toySelect.matches("[1-" + (i - 1) + "]?|[7]?"));
			int inttoySelect = Integer.parseInt(toySelect);

			switch (inttoySelect) {
			case 1:
				globalCurrentPet.play(currentToys.get(1));
				if (currentToys.get(1).getDurability() < 0) {
					player.removeToy(currentToys.get(1));
					System.out.format("Your %s broke!", currentToys.get(1).getName());
				}
				break;
			case 2:
				globalCurrentPet.play(currentToys.get(2));
				if (currentToys.get(2).getDurability() < 0) {
					player.removeToy(currentToys.get(2));
					System.out.format("Your %s broke!", currentToys.get(2).getName());
				}
				break;
			case 3:
				globalCurrentPet.play(currentToys.get(3));
				if (currentToys.get(3).getDurability() < 0) {
					player.removeToy(currentToys.get(3));
					System.out.format("Your %s broke!", currentToys.get(3).getName());
				}
				break;
			case 4:
				globalCurrentPet.play(currentToys.get(4));
				if (currentToys.get(4).getDurability() < 0) {
					player.removeToy(currentToys.get(4));
					System.out.format("Your %s broke!", currentToys.get(3).getName());
				}
				break;
			case 5:
				globalCurrentPet.play(currentToys.get(5));
				if (currentToys.get(5).getDurability() < 0) {
					player.removeToy(currentToys.get(5));
					System.out.format("Your %s broke!", currentToys.get(3).getName());
					break;
				}
			case 6:
				globalCurrentPet.play(currentToys.get(6));
				if (currentToys.get(5).getDurability() < 0) {
					player.removeToy(currentToys.get(6));
					System.out.format("Your %s broke!", currentToys.get(3).getName());
					break;
				}
			case 7:
				mainSelectScreen();
				break;
			}

		}
	}

	public void feedPet(Player player) {
		// System.out.format("*chomp..chomp..chomp* %s enjoyed the %s!\n",
		// globalCurrentPet.getName(), currentFood.get(1).getName());
		Map<Integer, Food> currentFood = new HashMap<Integer, Food>();
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		String foodSelect = null;
		int i = 1;

		if (player.getFood().isEmpty()) {
			System.out.println("You don't have any food! Visit the store to buy some.");
			promptEnterKey();
		} else {
			for (Map.Entry<Food, Integer> entry : player.getFood().entrySet()) {
				Food food = entry.getKey();
				currentFood.put(i, food);
				int val = entry.getValue();
				System.out.format("\n%d. %s x%d", i, food.getName(), val);
				i++;
			}
			System.out.format("\n%d. quit.\n", i);

			do {
				if (foodSelect != null) {
					System.out.println("\nYou have entered an invalid number\n");
				}
				System.out.format("Select an item to feed to %s.\n", globalCurrentPet.getName());
				foodSelect = scan.nextLine();
			} while (!foodSelect.matches("[1-" + i + "]"));
			int intFoodSelect = Integer.parseInt(foodSelect);

			switch (intFoodSelect) {
			case 1:
				System.out.format("*chomp..chomp..chomp* %s enjoyed the %s!\n", globalCurrentPet.getName(),
						currentFood.get(1).getName());
				globalCurrentPet.feed(currentFood.get(1));
				player.removeFood(currentFood.get(1));
				break;
			case 2:
				System.out.format("*chomp..chomp..chomp* %s enjoyed the %s!\n", globalCurrentPet.getName(),
						currentFood.get(1).getName());
				globalCurrentPet.feed(currentFood.get(2));
				player.removeFood(currentFood.get(2));
				break;
			case 3:
				globalCurrentPet.feed(currentFood.get(3));
				player.removeFood(currentFood.get(3));
				break;
			case 4:
				globalCurrentPet.feed(currentFood.get(4));
				player.removeFood(currentFood.get(4));
				break;
			case 5:
				globalCurrentPet.feed(currentFood.get(5));
				player.removeFood(currentFood.get(5));
				break;
			case 6:
				globalCurrentPet.feed(currentFood.get(6));
				player.removeFood(currentFood.get(6));
				break;
			}
		}
	}

	public void feed(Player player, Food food) {

	}

	public Species selectPet(Player player) {
		String inputChoice = null;
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		Map<Integer, Species> petChoices = new HashMap<Integer, Species>();
		int i = 0;

		for (Species pet : player.getPets().values()) {
			i++;
			petChoices.put(i, pet);
		}
		do {
			i = 0;
			if (inputChoice != null) {
				System.out.println("\nYou have entered an invalid number\n");
				promptEnterKey();
			}
			for (Species pet : player.getPets().values()) {
				i++;
				System.out.format("%d: %s.\n", i, pet.getName());
				petChoices.put(i, pet);
			}
			System.out.println("\nSelect a pet to interact with.");
			inputChoice = scan.nextLine();
		} while (!inputChoice.matches("[1-" + i + "]"));

		int intInputChoice = Integer.parseInt(inputChoice);
		switch (intInputChoice) {
		case 1:
			return petChoices.get(1);
		case 2:
			return petChoices.get(2);
		case 3:
			return petChoices.get(3);
		}
		System.out.println("ERROR, CODE SHOULD NEVER BE REACHED");

		return crab;
	}

	public void promptStoreSection(Player player) {
		System.out.println("Welcome to the Pet Store!");
		System.out.println("Enter 1 to view the food items for sale");
		System.out.println("Enter 2 to view the food items for sale\n");
		System.out.println(player);
	}

	// public void promptSpecies(Player player, int petNum) {
	// for (int i = 1; i < (petNum + 1); i++) {
	// @SuppressWarnings("resource")
	// Scanner scan = new Scanner(System.in);
	// printSpeciesInfo();
	// String speciesNum = null;
	// do {
	// if (speciesNum != null) {
	// System.out.println(
	// "\nYou have entered an invalid number," + "please enter a number between
	// 1 and 6.\n");
	// }
	// System.out.println("To choose, enter a number from 1-6...");
	// System.out.format("%s, please choose a species for Pet no.%d\n",
	// player.name, i);
	// speciesNum = scan.nextLine();
	// } while (!speciesNum.matches("[1-6]"));
	//
	// int species = 0;
	// int intSpeciesNum = Integer.parseInt(speciesNum);
	// switch (intSpeciesNum) {
	// case 1:
	// species = 1;
	// break;
	// case 2:
	// species = 2;
	// break;
	// case 3:
	// species = 3;
	// break;
	// case 4:
	// species = 4;
	// break;
	// case 5:
	// species = 5;
	// break;
	// case 6:
	// species = 6;
	// break;
	// }
	// // createPet(player, species);
	// }
	// }

	public void createPets(Player player) {

		if (chckbxPet1.isSelected()) {
			existingPetNames.add(txtPetName1.getText());
			Species newPet = new Species(txtPetName1.getText(), speciesChoices.get(1));
			player.addPet(newPet);
		}
		if (chckbxPet2.isSelected()) {
			existingPetNames.add(txtPetName2.getText());
			Species newPet = new Species(txtPetName2.getText(), speciesChoices.get(2));
			player.addPet(newPet);
		}
		if (chckbxPet3.isSelected()) {
			existingPetNames.add(txtPetName3.getText());
			Species newPet = new Species(txtPetName3.getText(), speciesChoices.get(3));
			player.addPet(newPet);
		}
		if (chckbxPet4.isSelected()) {
			existingPetNames.add(txtPetName4.getText());
			Species newPet = new Species(txtPetName4.getText(), speciesChoices.get(4));
			player.addPet(newPet);
		}
		if (chckbxPet5.isSelected()) {
			existingPetNames.add(txtPetName5.getText());
			Species newPet = new Species(txtPetName5.getText(), speciesChoices.get(5));
			player.addPet(newPet);
		}
		if (chckbxPet6.isSelected()) {
			existingPetNames.add(txtPetName6.getText());
			Species newPet = new Species(txtPetName6.getText(), speciesChoices.get(6));
			player.addPet(newPet);
		}
	}

	// @SuppressWarnings("resource")
	// Scanner scan = new Scanner(System.in);
	// System.out.format("Enter a name for your new %s.\n",
	// speciesChoices.get(species).getSpecies());
	// String petName = scan.nextLine();
	// while (existingPetNames.contains(petName)) {
	// System.out.println("Input error. That name belongs to another pet,please
	// choose another.\n");
	// System.out
	// .println(String.format("Enter a name for your new %s.",
	// speciesChoices.get(species).getSpecies()));
	// petName = scan.next();
	// }
	// existingPetNames.add(petName);
	// Species newPet = new Species(petName, speciesChoices.get(species));
	// player.addPet(newPet);
	// }

	public void publicPetHelper(Player player) {

	}

	public void printSpeciesInfo() {
		Properties prop = new Properties();
		InputStream input = null;
		try {
			input = new FileInputStream("config.properties");
			// load a properties file
			prop.load(input);
			// get the property value and print it out
			System.out.println(prop.getProperty("species1"));
			System.out.println(prop.getProperty("species2"));
			System.out.println(prop.getProperty("species3"));
			System.out.println(prop.getProperty("species4"));
			System.out.println(prop.getProperty("species5"));
			System.out.println(prop.getProperty("species6"));

		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	private void promptEnterKey() {
		System.out.println("\nPress \"ENTER\" to continue...");
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		scanner.nextLine();
	}

	public void printPlayers() {
		for (Map.Entry<Integer, Player> entry : players.entrySet()) {
			Player val = entry.getValue();
			System.out.println("\n" + val);
		}
	}

	public void printFood() {
		for (Map.Entry<Integer, Food> entry : foodChoices.entrySet()) {
			Food val = entry.getValue();
			System.out.println("\n" + val);
		}
	}

	public void printToys() {
		for (Map.Entry<Integer, Toy> entry : toyChoices.entrySet()) {
			Toy val = entry.getValue();
			System.out.println("\n" + val);
		}
	}

	public void printPets() {
		for (Map.Entry<Integer, Species> entry : speciesChoices.entrySet()) {
			Pet val = entry.getValue();
			System.out.println("\n" + val);
		}
	}

	public void addToy(String player, String toyName) {
		Toy toy = toyChoices.get(toyName);
		Player val = players.get(player);
		val.addToy(toy);
	}

	public void addPlayer(Player player, int i) {
		players.put(i, player);
	}

	public void addFood(String player, String foodName) {
		Food food = foodChoices.get(foodName);
		Player val = players.get(player);
		val.addFood(food);
	}

	public static void main(String[] args) {

		GUI newGame = new GUI();

		newGame.guiConstructor();
		newGame.guiMainButtons();
		newGame.frame.setVisible(true);
		newGame.gameStart();
		// newGame.inputPlayerNum();
		// newGame.inputDayNum();
		// newGame.createPlayers();
		// newGame.promptPetCreation();
		// newGame.mainScreenHelper();

		// EventQueue.invokeLater(new Runnable() {
		// public void run() {
		// try {
		// GUI window = new GUI();
		// window.frame.setVisible(true);
		// } catch (Exception e) {
		// e.printStackTrace();
		// }
		// }
		// });

	}
}
