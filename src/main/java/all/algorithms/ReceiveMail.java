package all.algorithms;

import all.model.Participant;
import org.jsoup.Jsoup;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMultipart;

public class ReceiveMail {
    public ArrayList<String> getBetsFromMail(ArrayList<Participant> participants) throws Exception {
        ArrayList<String> score = new ArrayList<>();

        String host = "pop.gmail.com";
        String user = "xxxxxxxxxxx"; //here give passes for your mailbox
        String password = "yyyyyyyy";

        Properties properties = new Properties();
        properties.put("mail.pop3.host", host);
        properties.put("mail.pop3.port", "995"); //POP3=995
        properties.put("mail.pop3.starttls.enable", "true");

        Session session = Session.getDefaultInstance(properties);

        Store store = session.getStore("pop3s");

        store.connect(host, user, password);

        Folder inbox = store.getFolder("INBOX");
        inbox.open(Folder.READ_ONLY);

        Message messages[] = inbox.getMessages();

        String race = null;
        String sessionF1 = null;

        for (Message m : messages) {

            Address[] dataOfSender = m.getFrom();
            String email = dataOfSender == null ? null : ((InternetAddress) dataOfSender[0]).getAddress();
            String subject = m.getSubject();
            String bets = getTextFromMessage(m);
            String[] parts = subject.split(" - ");
            race = parts[0];
            sessionF1 = parts[1];

            whichParticipant(email, subject, bets, participants);

        }


        inbox.close();
        store.close();

        score.add(race);
        score.add(sessionF1);

        return score;

    }

    private void whichParticipant(String email, String subject, String bets, ArrayList<Participant> participants) {
        for (Participant p :
                participants) {
            if (p.getName().contains("Maciej") && email.contains("adam")) {
                if (subject.contains("RACE")) {
                    p.setRaceBets(bets);
                    return;
                } else if (subject.contains("QUALIFYING")) {
                    p.setQualiBets(bets);
                    return;
                } else if (subject.contains("SPRINT SHOOTOUT")) {
                    p.setSprintShootoutBets(bets);
                    return;
                } else if (subject.contains("SPRINT")) {
                    p.setSprintBets(bets);
                    return;
                }
            } else if (p.getName().contains("Andrzej") && email.contains("michal")) {
                if (subject.contains("RACE")) {
                    p.setRaceBets(bets);
                    return;
                } else if (subject.contains("QUALIFYING")) {
                    p.setQualiBets(bets);
                    return;
                } else if (subject.contains("SPRINT SHOOTOUT")) {
                    p.setSprintShootoutBets(bets);
                    return;
                } else if (subject.contains("SPRINT")) {
                    p.setSprintBets(bets);
                    return;
                }
            } else if (p.getName().contains("Cezary") && email.contains("piotr")) {
                if (subject.contains("RACE")) {
                    p.setRaceBets(bets);
                    return;
                } else if (subject.contains("QUALIFYING")) {
                    p.setQualiBets(bets);
                    return;
                } else if (subject.contains("SPRINT SHOOTOUT")) {
                    p.setSprintShootoutBets(bets);
                    return;
                } else if (subject.contains("SPRINT")) {
                    p.setSprintBets(bets);
                    return;
                }
            } else if (p.getName().contains("Mikolaj") && email.contains("jakub")) {
                if (subject.contains("RACE")) {
                    p.setRaceBets(bets);
                    return;
                } else if (subject.contains("QUALIFYING")) {
                    p.setQualiBets(bets);
                    return;
                } else if (subject.contains("SPRINT SHOOTOUT")) {
                    p.setSprintShootoutBets(bets);
                    return;
                } else if (subject.contains("SPRINT")) {
                    p.setSprintBets(bets);
                    return;
                }
            }

        }
    }

    private String getTextFromMessage(Message message) throws Exception {
        if (message.isMimeType("text/plain")) {
            return message.getContent().toString();
        } else if (message.isMimeType("multipart/*")) {
            String result = "";
            MimeMultipart mimeMultipart = (MimeMultipart) message.getContent();
            int count = mimeMultipart.getCount();
            for (int i = 0; i < count; i++) {
                BodyPart bodyPart = mimeMultipart.getBodyPart(i);
                if (bodyPart.isMimeType("text/plain")) {
                    result = result + "\n" + bodyPart.getContent();
                    break;  //without break same text appears twice in my tests
                } else if (bodyPart.isMimeType("text/html")) {
                    String html = (String) bodyPart.getContent();
                    result = result + "\n" + Jsoup.parse(html).text();

                }
            }
            return result;
        }
        return "";
    }
}
