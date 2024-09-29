# F1-Adder - version with downloading driver standings from an e-mail*
*other versions of programme are available in different branches

This app aims to calculate points from predicting driver standings from particular Formula 1 session (Sprint/Sprint Shootout/Qualifying/Race)

![image](https://github.com/user-attachments/assets/68008281-7d30-4edd-a47e-b5da438cc128)

# How does it work?
1. Launch the application
2. Press the "Update scores" button to download pending mails with predictions from specific mail accounts, load URL addresses from official F1 page which store scores, load scores from desired session and count points for every participant
3. Counted points will show up in "Points" column

# How are points counted?
- Precise prediction: If participant guessed the exact position of driver, he/she receives 2 points
- Prediction missed by one position: If participant's prediction differentiate by 1 position, he/she receives 1 point 

Additional points for podium:
- First place: Additional 3 points for guessing exact driver on the first place
- Second place: Additional 2 points for guessing exact driver on the second place
- Third place: Additional 1 point for guessing exact driver on the third place

Participants have to guess the fastest lap additionally in race session. They can get 1 point for that. 

Points multiplier:
- 0.5x - Sprint Shootout
- 1x - Sprint/Qualifying
- 2x - Race
# Example of correct driver standings prediction format for Sprint Shootout/Sprint/Qualifying:
1. Verstappen
2. Hamilton
3. Leclerc
4. Perez
5. Sainz
6. Russell
7. Alonso
8. Gasly
9. Piastri
10. Norris
11. Stroll
12. Albon
13. Ocon
14. Bottas
15. Ricciardo
16. Tsunoda
17. Zhou
18. Sargeant
19. Hulkenberg
20. Magnussen
# For Race, you have to predict fastest lap additionally, so under predictions like above you have to write e.g.:
NO: Verstappen

# Joker
Participant has also ability to use Joker in 3 non-Sprint racing weekends and 1 Sprint racing weekend over one season which doubles points received from every session in that weekend. In order to use it - participant has to write "(J)" under the predictions like above

# Topic of the mail
It has to include country and name of the session, e.g.: "united-states QUALIFYING"

It only reads mails from current participants of league

# Which libraries does it use?
- Selenium - to parse driver standings from official Formula 1 page
- JSoup - to parse current participant standings from strictly defined page
- JavaX Mail - to download mails with predictions from specific e-mail accounts

In order to make it work, you have to turn on 2Step Verification on your Google account and generate password for the app.
Then, in code, you have to assign your email to user variable and generated password to password variable
