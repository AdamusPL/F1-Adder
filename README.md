# F1-Adder - version with pasting bets manually*
This app aims to calculate points from predicting standings from particular Formula 1 session (Sprint/Sprint Shootout/Qualifying/Race)

![image](https://github.com/user-attachments/assets/d34a5f8f-b113-4ba5-8b3c-c7e91553e638)

# How does it work?
1. On the right, choose from which session ("Sprint Shootout", "Sprint", "Quali" or "Race") programme should count points
2. Click "Load" button in order to load URL addresses of official F1 page which store scores from desired session for every race
3. On the left, choose the race weekend (e.g. bahrain)
4. In the middle, choose league participant, for whom count points
5. Paste bets in text area in correct format
6. Press the "OK" button
7. Counted points will show up in "Points" column

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

# Joker
Participant has also ability to use Joker in 3 non-Sprint racing weekends and 1 Sprint racing weekend over one season which doubles points received from every session in that weekend. In order to use it - participant has to write "(J)" under the bets like above

# Which libraries does it use?
- JSoup - to download scores from official F1 page and current betting ranking from the league page

*other versions of programme are available in different branches
