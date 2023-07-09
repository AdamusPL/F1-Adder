# SumaTor
To aplikacja obliczająca sumę punktów za obstawienie wyników w lidze typowania wyników Formuły 1, działająca na zasadach ściśle określonych przez ligę

# Jak ona działa?
1. Na prawo wybieramy czy chcemy policzyć wyniki z "Rzutu sprinterskiego", "Sprintu", "Kwalifikacji" czy "Wyścigu"
2. Klikamy przycisk "Zaladuj", który załaduje do programu bazę adresów URL z wynikami ze strony F1
3. Na lewo wybieramy weekend wyścigowy (np. bahrain)
4. Po środku wybieramy uczestnika ligi, dla którego chcemy policzyć punkty
5. Wklejamy bety w pole tekstowe w odpowiednim formacie
6. Naciskamy "OK"
7. Obliczone punkty pojawią się w kolumnie "Liczba zdobytych punktów"

# Jakie biblioteki wykorzystuje?
- JSoup - do pobrania wyników z oficjalnej strony F1 oraz aktualnego rankingu typowania ze ściśle określonej strony
- JavaMail API - w celu pobrania wysłanych przez uczestników betów ze skrzynki pocztowej 
