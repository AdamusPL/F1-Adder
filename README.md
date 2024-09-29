# F1-Adder - version with pasting driver standings manually*
This app aims to calculate points from predicting driver standings in a particular Formula 1 session (Sprint/Sprint Shootout/Qualifying/Race)

![image](https://github.com/user-attachments/assets/8bb734f5-953d-4557-87c2-cca2f9a5ef3d)

# How does it work?
1. On the right, choose from which session ("Sprint Shootout", "Sprint", "Quali" or "Race") programme should count points
2. Click "Load" button in order to load URL addresses of official F1 page which store scores from desired session for every race
3. On the left, choose the race weekend (e.g. bahrain)
4. In the middle, choose league participant, for whom count points
5. Paste driver standings in text area in correct format
6. Press the "OK" button
7. Counted points will show up in "Points" column

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

# Example of correct predictions format for Sprint Shootout/Sprint/Qualifying:
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

# Which libraries does it use?
- Selenium - to parse driver standings from official Formula 1 page
- JSoup - to parse current participant standings from the specific page

*other versions of programme are available in different branches
