package game;


import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;

import javax.swing.*;
import javax.imageio.*;

import java.io.File;
import java.util.ArrayList;
import java.util.Map;

public class Layout {
	private static final String GAME_TITLE = "Murder at Gourd Mansion";

	private JFrame frame;
	private JPanel content;
	private JLabel image_pane;
	private BufferedImage image;
	private JTextArea text_pane;
	private JTextField input_pane;
	private JScrollPane scroll_pane;
    private JButton notepad;
    private JMenuBar menubar;
    private JMenu menu;
    JMenuItem menuItem;
    
    
   
	private Room current_room;
	private ArrayList<String> inventory;
    private ArrayList<String> notes;

	public static void main(String[] args) {
		Layout game = new Layout();
		game.startGame();
	}

	public Layout() {
		inventory = new ArrayList<String>();
       
		addRooms();
		makeFrame();
		setRoom();
	}

	private void addRooms() {
		Room lobby, diningRoom, kitchen, study, mansion  /*, bedRoom, courtYard, shed*/  ;

		lobby = 		new Room ("Lobby", "Lobby.jpg");
		diningRoom =	new Room ("Dining Room", "Dining Room.jpg");
		kitchen = 		new Room ("Kitchen", "Kitchen.jpg");
		study = 		new Room ("Study", "Study.jpg");
		mansion = 		new Room ("Mansion", "Mansion.jpg");
//		bedRoom =		new Room ("Bed Room", "Bed Room.jpg");
//		courtYard =		new Room ("Courtyard", "Courtyard.jpg");
//		shed = 			new Room ("Shed", "Shed.jpg");
		
		mansion.addExit("lobby", lobby);
		
		lobby.addExit("diningroom", diningRoom);
		lobby.addExit("kitchen", kitchen);
//		lobby.addExit("bedroom", bedRoom);
		lobby.addObject("guitar", "I wonder whose signature is that on the guitar. I'll have to ask Gourd at dinner.");
		lobby.addObject("statue", "It's a statue of a bluejay!");
		lobby.addObject("table", "It's covered in beer bottles with labels that have gourds face on it and Canadian magazines  all in French.");
		lobby.addObject("armor", "Holy crap, a Gourd manikin is in here!");
		
		diningRoom.addExit("lobby", lobby);
		diningRoom.addExit("study", study);
		diningRoom.addObject("rug", "It's old and needs to be vacuumed.");
		diningRoom.addObject("fireplace", "Gourd even programed his fireplace. It's a hologram!");
		diningRoom.addObject("portrait", "It's a portrait of Angus Young from ACDC. If he was a junior burger he'd still be called Angus Young.");

		kitchen.addExit("lobby", lobby);
		kitchen.addItem("medicine");
		kitchen.addObject("pot", "This jalapeno soup is gonna be delicious!");
		kitchen.addObject("refrigerator", "Hi there, I'm Gourds fridge. You seem trustworthy, unlike that other student.");

		study.addExit("diningroom", diningRoom);
		study.addExit("kitchen", kitchen);
		study.addObject("letter", "You’ll regret the day you gave me that F! it says. I wonder what that’s all about?");
		study.addObject("poster", "It's a poster of Gourd and says, Our Gourd and Savior.");
		study.addObject("computer", "Gourd’s super high tech computer! It has a password on it.");
/*		
		bedRoom.addExit("study", study);
		bedRoom.addExit("lobby", lobby);
		bedRoom.addObject("bed", "It is made of wicker and no one is sitting on it.");
		bedRoom.addObject("bookcase", "All these books are dusty and old.");
		bedRoom.addObject("lockbox", "What is Gourd hiding in there?");
		
		courtYard.addExit("lobby", lobby);
		courtYard.addExit("shed", shed);
		courtYard.addItem("syringe");
		courtYard.addObject("fountain", "There is something in the fountain. It looks like a syringe.");
		
		shed.addExit("courtyard", courtYard);
		shed.addItem("key");
		shed.addObject("key", "I wonder what this goes to?");
*/
		current_room = mansion;
	}

	private void setRoom() {
		setDescription("");
		
		try {
			if (current_room == null) {
				image = ImageIO.read(new File("C:/Users/Chris/Pictures/71616.jpg"));
			}
			else {
				image = ImageIO.read(new File(current_room.getImage()));
			}

			image_pane.setIcon(new ImageIcon(image));
			
		} catch (Exception e) {
		}

		frame.pack();
	}

	public void setDescription(String s) {
		if (current_room == null) {
			text_pane.setText("You are dead.");
		} else {
			text_pane.setText(current_room + "\nYou are carrying: " + inventory	+ "\n\n" + s);
		}
	}

	private void startGame() {
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();

		frame.setLocation(d.width / 2 - frame.getWidth() / 2, d.height / 2 - frame.getHeight() / 2);
		frame.setVisible(true);
		input_pane.requestFocus();
	}

	private void makeFrame() {
		frame = new JFrame(GAME_TITLE);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setPreferredSize(new Dimension(900, 700));
		content = (JPanel) frame.getContentPane();

		image_pane = new JLabel();
		image_pane.setHorizontalAlignment(JLabel.CENTER);
		image_pane.setVerticalAlignment(JLabel.CENTER);
		image_pane.setPreferredSize(new Dimension(800, 400));
		image_pane.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));
		content.add(image_pane, BorderLayout.PAGE_START);

		text_pane = new JTextArea(20, 19);
		text_pane.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));
		text_pane.setEditable(false);
		text_pane.setLineWrap(true);
		text_pane.setFont(new Font("Comic Sans MS", 1, 20));
		content.add(text_pane, BorderLayout.CENTER);
		
		scroll_pane = new JScrollPane(text_pane);
		scroll_pane.setPreferredSize(new Dimension(450, 110));
		scroll_pane.setViewportView(text_pane);
		content.add(scroll_pane, BorderLayout.CENTER);

		input_pane = new JTextField();
		input_pane.setFont(new Font("Courier new", 1, 20));
		input_pane.setColumns(35);
		input_pane.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));
		content.add(input_pane, BorderLayout.PAGE_END);
	
		 // the notepad button
		menubar = new JMenuBar();

		//menuItem = new JMenuItem("Notes");
		
		
		

		// create the File menu
		JMenu notesMenu = new JMenu("Notes");
		menubar.add(notesMenu);
		JMenuItem notesItem = new JMenuItem("Notes");
		notesMenu.add(notesItem);
		JMenu helpMenu = new JMenu("Help");
		menubar.add(helpMenu);
		JMenu quitMenu = new JMenu("Quit");
		menubar.add(quitMenu);
		JMenuItem quitItem = new JMenuItem("Quit");
		quitMenu.add(quitItem);
		frame.setJMenuBar(menubar);
		


		input_pane.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				process(input_pane.getText());
				input_pane.setText("");
			}
		});
		
		// add a listener to the button so that actions can occur when the user clicks button
        notesItem.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                // notes to appear in text pane
                setDescription("What you have " + notes);
            }
        });
        
        quitItem.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                // closes game
                System.exit(0);
            }
        });
	}

	private void process(String s) {
		String sl = s.toLowerCase().trim(); 
											
		String[] words; 
		String verb; 
		String noun; 
		String response = "I don't understand.  Try:\n<verb> <noun>\nValid <verb>: go look take";

		if (sl.equals("quit") || sl.equals("exit") || sl.equals("bye")) {
			System.exit(0);
		}

		if (current_room == null) {
			return;
		}

		words = sl.split(" ");

		if (words.length == 2) {
			verb = words[0];
			noun = words[1];

			if (verb.equals("go")) {
				response = "Invalid exit.";

				for (Map.Entry<String, Room> entry : current_room.getExits()
						.entrySet()) {
					String exit = entry.getKey();

					if (noun.equals(exit)) {
						current_room = entry.getValue();
						setRoom();
						response = "";

						break;
					}
				}
			} else if (verb.equals("look")) {
				response = "I don't see that item.";

				for (Map.Entry<String, String> entry : current_room.getObjects().entrySet()) {
					String object = entry.getKey();

					if (noun.equals(object)) {
						response = entry.getValue();

						break;
					}
				}
			} else if (verb.equals("take")) {
				response = "I don't see that item.";

				for (String item : current_room.getItems()) {
					if (noun.equals(item)) {
						inventory.add(item);
						notes.add(item);
						current_room.removeItem(item);
						response = "Item grabbed.";

						break;
					}
				}
			}
		}

		setDescription(response);
	}
}