package all;

import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import all.algorithms.CountPointsAlgorithm;
import all.algorithms.Download;
import all.algorithms.QuoteAlgorithm;
import all.model.Driver;
import all.model.Participant;
import all.model.Quote;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.GridBagLayout;
import java.awt.CardLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.SpringLayout;
import java.awt.Choice;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Frame extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Frame frame = new Frame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	QuoteAlgorithm quoteAlgorithm = new QuoteAlgorithm();
	Quote randomQuote = quoteAlgorithm.chooseRandomQuote();
	Download download = new Download();
	
	
	/**
	 * Create the frame.
	 * @throws IOException 
	 */
	public Frame() throws IOException {
		ArrayList<Driver> driversArrayList = download.downloadScores();
		ArrayList<Participant> participantArrayList = download.downloadParticipants();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0,0,800,800);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel welcome = new JLabel("Witamy w programie do sumowania punktow F1 w sezonie 2023!");
		GridBagConstraints gbc_welcome = new GridBagConstraints();
		gbc_welcome.insets = new Insets(0, 0, 5, 5);
		gbc_welcome.gridx = 12;
		gbc_welcome.gridy = 0;
		contentPane.add(welcome, gbc_welcome);
		
		JLabel imageLabel = new JLabel();
		imageLabel.setIcon(new ImageIcon("logo.png")); //Sets the image to be displayed as an icon
        Dimension size = imageLabel.getPreferredSize(); //Gets the size of the image
		GridBagConstraints gbc_imageLabel = new GridBagConstraints();
		gbc_imageLabel.insets = new Insets(0, 0, 5, 5);
		gbc_imageLabel.gridx = 12;
		gbc_imageLabel.gridy = 1;
		contentPane.add(imageLabel, gbc_imageLabel);
		
		JLabel quote = new JLabel("Quote na dzisiaj: "+randomQuote.textOfQuote);
		GridBagConstraints gbc_quote = new GridBagConstraints();
		gbc_quote.insets = new Insets(0, 0, 5, 5);
		gbc_quote.gridx = 12;
		gbc_quote.gridy = 2;
		contentPane.add(quote, gbc_quote);
		
		JLabel lblNewLabel = new JLabel("Imie");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 11;
		gbc_lblNewLabel.gridy = 3;
		contentPane.add(lblNewLabel, gbc_lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Liczba zdobytych punktow");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 12;
		gbc_lblNewLabel_1.gridy = 3;
		contentPane.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Liczba uzytych Jokerow");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_2.gridx = 13;
		gbc_lblNewLabel_2.gridy = 3;
		contentPane.add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		String nameString="<html>";
		String pointsString="<html>";
		String jokersString="<html>";
		for (Participant participant : participantArrayList) {
			nameString+=participant.getName()+"<br>";
			pointsString+=participant.getPoints()+"<br>";
			jokersString+=participant.getNumberOfUsedJokers()+"<br>";
		}
		nameString+="</html>";
		pointsString+="</html>";
		jokersString+="</html>";
		
		JLabel namesD = new JLabel(nameString);
		GridBagConstraints gbc_namesD = new GridBagConstraints();
		gbc_namesD.insets = new Insets(0, 0, 5, 5);
		gbc_namesD.gridx = 11;
		gbc_namesD.gridy = 4;
		contentPane.add(namesD, gbc_namesD);
		
		JLabel pointsD = new JLabel(pointsString);
		GridBagConstraints gbc_pointsD = new GridBagConstraints();
		gbc_pointsD.insets = new Insets(0, 0, 5, 5);
		gbc_pointsD.gridx = 12;
		gbc_pointsD.gridy = 4;
		contentPane.add(pointsD, gbc_pointsD);
		
		JLabel jokersD = new JLabel(jokersString);
		GridBagConstraints gbc_jokersD = new GridBagConstraints();
		gbc_jokersD.insets = new Insets(0, 0, 5, 0);
		gbc_jokersD.gridx = 13;
		gbc_jokersD.gridy = 4;
		contentPane.add(jokersD, gbc_jokersD);
		
		JLabel lblNewLabel_3 = new JLabel("");
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3.gridx = 12;
		gbc_lblNewLabel_3.gridy = 5;
		contentPane.add(lblNewLabel_3, gbc_lblNewLabel_3);
		
		Choice choice = new Choice();
		for (Participant participant : participantArrayList) {
			choice.add(participant.getName());
		}
		
		JLabel lblNewLabel_4 = new JLabel("Oblicz punkty dla:");
		GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
		gbc_lblNewLabel_4.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_4.gridx = 11;
		gbc_lblNewLabel_4.gridy = 6;
		contentPane.add(lblNewLabel_4, gbc_lblNewLabel_4);
		
		GridBagConstraints gbc_choice = new GridBagConstraints();
		gbc_choice.insets = new Insets(0, 0, 5, 5);
		gbc_choice.gridx = 12;
		gbc_choice.gridy = 6;
		contentPane.add(choice, gbc_choice);
		
		JTextArea bets = new JTextArea();
		GridBagConstraints gbc_bets = new GridBagConstraints();
		gbc_bets.insets = new Insets(0, 0, 0, 5);
		gbc_bets.fill = GridBagConstraints.BOTH;
		gbc_bets.gridx = 12;
		gbc_bets.gridy = 7;
		contentPane.add(bets, gbc_bets);
		
		JButton confirm = new JButton("OK");
		confirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()=="OK") {
					for (Participant participant : participantArrayList) {
						if(choice.equals(participant.getName())) {
							CountPointsAlgorithm countPointsAlgorithm = new CountPointsAlgorithm(bets);
							System.out.println(bets.getText());
						}
					}
				}
			}
		});
		GridBagConstraints gbc_confirm = new GridBagConstraints();
		gbc_confirm.insets = new Insets(0, 0, 5, 0);
		gbc_confirm.gridx = 13;
		gbc_confirm.gridy = 6;
		contentPane.add(confirm, gbc_confirm);
		
		
	}
}
