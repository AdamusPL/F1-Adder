package all;

import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import all.algorithms.*;
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

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

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
    public Frame() throws Exception {
        this.quoteAlgorithm = new QuoteAlgorithm();
        this.randomQuote = quoteAlgorithm.chooseRandomQuote();
        this.download = new Download();
        this.linksHandler = new LinksHandler();
        ArrayList<Participant> participantArrayList = download.downloadParticipants();

        ReceiveMail receiveMail = new ReceiveMail();

        ArrayList<String> score = receiveMail.getBetsFromMail(participantArrayList);

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

        JLabel welcome = new JLabel("Welcome to the program which sums up points from betting F1 results!");
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

        JLabel lblNewLabel_2 = new JLabel("Used jokers");
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

        JLabel lblNewLabel_5 = new JLabel("© DiXXo v.1.0 BETA, 2023");
        GridBagConstraints gbc_lblNewLabel_5 = new GridBagConstraints();
        gbc_lblNewLabel_5.insets = new Insets(0, 0, 0, 5);
        gbc_lblNewLabel_5.gridx = 12;
        gbc_lblNewLabel_5.gridy = 9;
        contentPane.add(lblNewLabel_5, gbc_lblNewLabel_5);

        JButton confirm = new JButton("Update scores");

        confirm.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == confirm) {
                    if (score.get(1).equals("QUALIFYING")) {
                        for (Participant p : participantArrayList) {
                            if (p.getQualiBets() != null) {
                                CountPointsAlgorithm countPointsAlgorithm = new CountPointsAlgorithm(p.getQualiBets(), driversArrayList, p);
                                links = linksHandler.add("2023_q.txt");
                                String save = null;

                                for (Link l : links) {
                                    if (l.getFullname().contains(score.get(0))) {
                                        save = l.getFullname();
                                        break;
                                    }
                                }

                                try {
                                    driversArrayList = download.downloadScoresFromQualiOrSS(save);
                                } catch (IOException ex) {
                                    throw new RuntimeException(ex);
                                }
                                countPointsAlgorithm.countPointsFromQualifying();
                            }
                        }
                    } else if (score.get(1).equals("SPRINT SHOOTOUT")) {
                        for (Participant p : participantArrayList) {
                            if (p.getSprintShootoutBets() != null) {
                                CountPointsAlgorithm countPointsAlgorithm = new CountPointsAlgorithm(p.getSprintShootoutBets(), driversArrayList, p);
                                links = linksHandler.add("2023_ss.txt");
                                String save = null;

                                for (Link l : links) {
                                    if (l.getFullname().contains(score.get(0))) {
                                        save = l.getFullname();
                                        break;
                                    }
                                }

                                try {
                                    driversArrayList = download.downloadScoresFromQualiOrSS(save);
                                } catch (IOException ex) {
                                    throw new RuntimeException(ex);
                                }
                                countPointsAlgorithm.countPointsFromSprintShootout();
                            }
                        }
                    } else if (score.get(1).equals("SPRINT")) {
                        for (Participant p : participantArrayList) {
                            if (p.getSprintBets() != null) {
                                CountPointsAlgorithm countPointsAlgorithm = new CountPointsAlgorithm(p.getSprintBets(), driversArrayList, p);
                                links = linksHandler.add("2023_s.txt");
                                String save = null;

                                for (Link l : links) {
                                    if (l.getFullname().contains(score.get(0))) {
                                        save = l.getFullname();
                                        break;
                                    }
                                }
                                try {
                                    driversArrayList = download.downloadScoresFromRaceOrSprint(save);
                                } catch (IOException ex) {
                                    throw new RuntimeException(ex);
                                }
                                countPointsAlgorithm.countPointsFromSprint();
                            }
                        }
                    } else if (score.get(1).equals("RACE")) {
                        for (Participant p : participantArrayList) {
                            if (p.getRaceBets() != null) {
                                CountPointsAlgorithm countPointsAlgorithm = new CountPointsAlgorithm(p.getRaceBets(), driversArrayList, p, fastestDriver);
                                links = linksHandler.add("2023_r.txt");
                                linksFL = linksHandler.add("2023_fl.txt");

                                String saveR = null;
                                String saveFL = null;

                                for (Link l : links) {
                                    if (l.getFullname().contains(score.get(0))) {
                                        saveR = l.getFullname();
                                        break;
                                    }
                                }

                                for (Link l : linksFL) {
                                    if (l.getFullname().contains(score.get(0))) {
                                        saveFL = l.getFullname();
                                        break;
                                    }
                                }

                                String fastestDriver = null;

                                try {
                                    fastestDriver = download.downloadFastestLap(saveFL);
                                } catch (IOException ex) {
                                    throw new RuntimeException(ex);
                                }

                                try {
                                    driversArrayList = download.downloadScoresFromRaceOrSprint(saveR);
                                } catch (IOException ex) {
                                    throw new RuntimeException(ex);
                                }

                                countPointsAlgorithm.countPointsFromRace();
                            }
                        }
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
