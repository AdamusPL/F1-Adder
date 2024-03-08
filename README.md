# F1-Adder - version with downloading bets from e-mail*
This app sums up points for betting F1 points in F1 (4fun) Betting League, it works on rules strictly defined by league

# How does it work?
1. Launch the application
2. Press the "OK" button to download pending mails with bets from specific mail account, load URL addresses from official F1 page which store scores, load scores from desired session and count points for every participant
3. Counted points will show up in "Points" column

# How are points counted?
- Precise bet: If participant guessed the exact position of driver, he/she receives 2 points
- Bet missed by one position: If participant's bet differentiate by 1 position, he/she receives 1 point 

Additional points for podium:
- First place: Additional 3 points for guessing exact driver on the first place
- Second place: Additional 2 points for guessing exact driver on the second place
- Third place: Additional 1 point for guessing exact driver on the third place

Participants have to guess the fastest lap additionally in race session. They can get 1 point for that. 

Points multiplier:
- 0.5x - Sprint Shootout
- 1x - Sprint/Qualifying
- 2x - Race
# Example of correct bets format for Sprint Shootout/Sprint/Qualifying:
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
# For Race, you have to bet fastest lap additionally, so under bets like above you have to write e.g.:
NO: Verstappen

# Topic of the mail
It has to include country and name of the session, e.g.: "united-states QUALIFYING"

It only reads mails from current participants of league

# Which libraries does it use?
- JSoup - to download scores from official F1 page and current betting ranking from strictly defined page
- JavaX Mail - to download mails with bets from specific e-mail account

In order to make it work, you have to turn on 2Step Verification on your Google account and generate password for the app.
Then, in code, you have to assign your email to user variable and generated password to password variable

*other versions of programme are available in different branches
