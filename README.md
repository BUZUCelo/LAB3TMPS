Cele trei modele de proiectare structurale din acest cod sunt: Adapter, Facade și Composite.

1. Modelul Adapter este folosit pentru a adapta un obiect existent la un alt tip de interfață astfel
încât să poată fi utilizat cu ușurință în alt context. În acest exemplu, avem o interfață MediaPlayer 
care poate reda fișiere audio în format MP3, și două clase care implementează interfața AdvancedMediaPlayer 
și pot reda fișiere audio în formatele VLC și MP4. Clasa MediaPlayerAdapter acționează ca un adaptor între
cele două interfețe și permite redarea fișierelor audio în formatul acceptat de AdvancedMediaPlayer prin intermediul 
obiectelor care implementează interfața MediaPlayer.

2.Modelul Facade este utilizat pentru a ascunde complexitatea unui sistem și pentru a oferi o interfață simplificată 
și unificată pentru a accesa diversele componente ale sistemului. În acest exemplu, clasa Facade este utilizată pentru
a ascunde cele trei sub-sisteme A, B și C și pentru a oferi două metode simple pentru utilizatorii sistemului.

3.Modelul Composite este utilizat pentru a compune obiecte în structuri de arbore pentru a reprezenta o ierarhie între obiecte. 
În acest exemplu, avem două clase, Leaf și Composite, care implementează interfața Component și reprezintă nodurile frunză și compozite 
ale arborelui. Clasa Composite poate conține alte componente ca sub-noduri, inclusiv alte obiecte Composite sau Leaf, formând astfel o ierarhie 
de structuri de tip arbore.
