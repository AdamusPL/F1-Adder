package all;

import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import all.algorithms.LinksHandler;
import all.algorithms.CountPointsAlgorithm;
import all.algorithms.Download;
import all.algorithms.QuoteAlgorithm;
import all.model.Driver;
import all.model.Link;
import all.model.Participant;
import all.model.Quote;

import javax.swing.JLabel;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.io.IOException;
import java.util.ArrayList;

import java.awt.Choice;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;

public class Frame extends JFrame {
    private JPanel contentPane;
    private QuoteAlgorithm quoteAlgorithm;
    private Quote randomQuote;
    private Download download;
    private LinksHandler linksHandler;
    private ArrayList<Driver> driversArrayList;
    private String fastestDriver;
    private ArrayList<Link> links;
    private ArrayList<Link> linksFL;

    /**
     * Create the frame.
     *
     * @throws IOException
     */
    public Frame() throws IOException {
        this.quoteAlgorithm = new QuoteAlgorithm();
        this.randomQuote = quoteAlgorithm.chooseRandomQuote();
        this.download = new Download();
        this.linksHandler = new LinksHandler();
        ArrayList<Participant> participantArrayList = download.downloadParticipants();

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		setExtendedState(JFrame.MAXIMIZED_BOTH);
        setBounds(0, 0, 800, 800);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        GridBagLayout gbl_contentPane = new GridBagLayout();
        gbl_contentPane.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        gbl_contentPane.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
        gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
        contentPane.setLayout(gbl_contentPane);

        JLabel welcome = new JLabel("Welcome in programme which calculates points from predicting driver standings in 2023 F1 season!");
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

        JLabel quote = new JLabel("Quote for today: " + randomQuote.getTextOfQuote());
        GridBagConstraints gbc_quote = new GridBagConstraints();
        gbc_quote.insets = new Insets(0, 0, 5, 5);
        gbc_quote.gridx = 12;
        gbc_quote.gridy = 2;
        contentPane.add(quote, gbc_quote);

        JLabel lblNewLabel = new JLabel("Name");
        GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
        gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
        gbc_lblNewLabel.gridx = 11;
        gbc_lblNewLabel.gridy = 3;
        contentPane.add(lblNewLabel, gbc_lblNewLabel);

        JLabel lblNewLabel_1 = new JLabel("Points");
        GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
        gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
        gbc_lblNewLabel_1.gridx = 12;
        gbc_lblNewLabel_1.gridy = 3;
        contentPane.add(lblNewLabel_1, gbc_lblNewLabel_1);

        JLabel lblNewLabel_2 = new JLabel("Jokers used");
        GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
        gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 0);
        gbc_lblNewLabel_2.gridx = 13;
        gbc_lblNewLabel_2.gridy = 3;
        contentPane.add(lblNewLabel_2, gbc_lblNewLabel_2);

        String nameString = "<html>";
        String pointsString = "<html>";
        String jokersString = "<html>";
        for (Participant participant : participantArrayList) {
            nameString += participant.getName() + "<br>";
            pointsString += participant.getPoints() + "<br>";
            jokersString += participant.getNumberOfUsedJokers() + "<br>";
        }
        nameString += "</html>";
        pointsString += "</html>";
        jokersString += "</html>";

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

        Choice participantC = new Choice();
        for (Participant participant : participantArrayList) {
            participantC.add(participant.getName());
        }

        JLabel lblNewLabel_4 = new JLabel("Count points for:");
        GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
        gbc_lblNewLabel_4.insets = new Insets(0, 0, 5, 5);
        gbc_lblNewLabel_4.gridx = 11;
        gbc_lblNewLabel_4.gridy = 6;
        contentPane.add(lblNewLabel_4, gbc_lblNewLabel_4);

        GridBagConstraints gbc_participantC = new GridBagConstraints();
        gbc_participantC.insets = new Insets(0, 0, 5, 5);
        gbc_participantC.gridx = 12;
        gbc_participantC.gridy = 6;
        contentPane.add(participantC, gbc_participantC);

        Choice sessionChoice = new Choice();
        sessionChoice.add("Sprint Shootout");
        sessionChoice.add("Sprint");
        sessionChoice.add("Qualifying");
        sessionChoice.add("Race");

        JScrollPane scrollPane = new JScrollPane();
        GridBagConstraints gbc_scrollPane = new GridBagConstraints();
        gbc_scrollPane.insets = new Insets(0, 0, 5, 5);
        gbc_scrollPane.fill = GridBagConstraints.BOTH;
        gbc_scrollPane.gridx = 12;
        gbc_scrollPane.gridy = 7;
        contentPane.add(scrollPane, gbc_scrollPane);

        JTextArea bets = new JTextArea();
        scrollPane.setViewportView(bets);
        GridBagConstraints gbc_qualiorrace = new GridBagConstraints();
        gbc_qualiorrace.insets = new Insets(0, 0, 5, 0);
        gbc_qualiorrace.gridx = 13;
        gbc_qualiorrace.gridy = 7;
        contentPane.add(sessionChoice, gbc_qualiorrace);

        Choice grandPrix = new Choice();

        GridBagConstraints gbc_race = new GridBagConstraints();
        gbc_race.insets = new Insets(0, 0, 5, 5);
        gbc_race.gridx = 11;
        gbc_race.gridy = 7;

        contentPane.add(grandPrix, gbc_race);

        JButton load = new JButton("Load");
        load.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == load) { //Qualifying or Race
                    if (sessionChoice.getSelectedItem().equals("Qualifying") || sessionChoice.getSelectedItem().equals("Race")) {
                        links = linksHandler.add("2023_r.txt");
                    } else { //Sprint or Sprint Shootout
                        links = linksHandler.add("2023_s.txt");
                    }

                    for (Link link : links) {
                        grandPrix.add(link.getGpName());
                        contentPane.revalidate();
                    }
                }
            }
        });

        GridBagConstraints gbc_load = new GridBagConstraints();
        gbc_load.insets = new Insets(0, 0, 5, 0);
        gbc_load.gridx = 13;
        gbc_load.gridy = 8;
        contentPane.add(load, gbc_load);

        JLabel lblNewLabel_5 = new JLabel("© AdamusPL v.1.0, 2023");
        GridBagConstraints gbc_lblNewLabel_5 = new GridBagConstraints();
        gbc_lblNewLabel_5.insets = new Insets(0, 0, 0, 5);
        gbc_lblNewLabel_5.gridx = 12;
        gbc_lblNewLabel_5.gridy = 9;
        contentPane.add(lblNewLabel_5, gbc_lblNewLabel_5);


        JButton confirm = new JButton("OK");
        confirm.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == confirm) {

                    String url = "";
                    for (Link link : links) {
                        if (link.getUrl().contains(grandPrix.getSelectedItem())) {
                            url = link.getUrl();
                        }
                    }

                    if (sessionChoice.getSelectedItem().equals("Race")) {
                        try {
                            String fastestLapUrl = url + "/fastest-laps";
                            fastestDriver = download.downloadFastestLap(fastestLapUrl);
                        } catch (IOException e2) {
                            // TODO Auto-generated catch block
                            e2.printStackTrace();
                        }

                        try {
                            String raceUrl = url + "/race-result";
                            driversArrayList = download.downloadScoresFromF1Page(raceUrl);
                        } catch (IOException e1) {
                            // TODO Auto-generated catch block
                            e1.printStackTrace();
                        }

                        Participant chosen = null;
                        for (Participant participant : participantArrayList) {
                            if (participantC.getSelectedItem().equals(participant.getName())) {
                                chosen = participant;
                            }
                        }

                        CountPointsAlgorithm countPointsAlgorithm = new CountPointsAlgorithm(bets, driversArrayList, chosen, fastestDriver);
                        countPointsAlgorithm.countPointsFromRace();

                    } else if (sessionChoice.getSelectedItem().equals("Qualifying")) {
                        try {
                            String qualifyingUrl = url + "/qualifying";
                            driversArrayList = download.downloadScoresFromF1Page(qualifyingUrl);
                        } catch (IOException ex) {
                            throw new RuntimeException(ex);
                        }

                        Participant chosen = null;
                        for (Participant participant : participantArrayList) {
                            if (participantC.getSelectedItem().equals(participant.getName())) {
                                chosen = participant;
                            }
                        }

                        CountPointsAlgorithm countPointsAlgorithm = new CountPointsAlgorithm(bets, driversArrayList, chosen);
                        countPointsAlgorithm.countPointsFromQualifying();

                    } else if (sessionChoice.getSelectedItem().equals("Sprint")) { //Sprint
                        try {
                            String sprintUrl = url + "/sprint-results";
                            driversArrayList = download.downloadScoresFromF1Page(sprintUrl);
                        } catch (IOException e1) {
                            // TODO Auto-generated catch block
                            e1.printStackTrace();
                        }

                        Participant chosen = null;
                        for (Participant participant : participantArrayList) {
                            if (participantC.getSelectedItem().equals(participant.getName())) {
                                chosen = participant;
                            }
                        }

                        CountPointsAlgorithm countPointsAlgorithm = new CountPointsAlgorithm(bets, driversArrayList, chosen);
                        countPointsAlgorithm.countPointsFromSprint();
                    } else { //Sprint Shootout
                        try {
                            String sprintShootoutUrl = url + "/sprint-qualifying";
                            driversArrayList = download.downloadScoresFromF1Page(sprintShootoutUrl);
                        } catch (IOException ex) {
                            throw new RuntimeException(ex);
                        }

                        Participant chosen = null;
                        for (Participant participant : participantArrayList) {
                            if (participantC.getSelectedItem().equals(participant.getName())) {
                                chosen = participant;
                            }
                        }

                        CountPointsAlgorithm countPointsAlgorithm = new CountPointsAlgorithm(bets, driversArrayList, chosen);
                        countPointsAlgorithm.countPointsFromSprintShootout();
                    }

                    String pointsString = "<html>";
                    String jokersString = "<html>";
                    for (Participant participant : participantArrayList) {
                        pointsString += participant.getPoints() + "<br>";
                        jokersString += participant.getNumberOfUsedJokers() + "<br>";
                    }
                    pointsString += "</html>";
                    jokersString += "</html>";
                    pointsD.setText(pointsString);
                    jokersD.setText(jokersString);
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
