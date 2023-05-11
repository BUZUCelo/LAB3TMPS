Cele trei modele de proiectare structurale din acest cod sunt: Adapter, Facade și Composite.

1. Modelul Adapter este folosit pentru a adapta un obiect existent la un alt tip de interfață astfel
încât să poată fi utilizat cu ușurință în alt context. În acest exemplu, avem o interfață MediaPlayer 
care poate reda fișiere audio în format MP3, și două clase care implementează interfața AdvancedMediaPlayer 
și pot reda fișiere audio în formatele VLC și MP4. Clasa MediaPlayerAdapter acționează ca un adaptor între
cele două interfețe și permite redarea fișierelor audio în formatul acceptat de AdvancedMediaPlayer prin intermediul 
obiectelor care implementează interfața MediaPlayer.

// Se crează obiecte de tip "ConcreteMediaPlayer" și "MediaPlayerAdapter"
MediaPlayer mediaPlayer = new ConcreteMediaPlayer();
MediaPlayer mediaPlayerAdapter = new MediaPlayerAdapter("vlc");

// Se apelează metoda "play" a ambelor obiecte pentru a reda fișiere audio de diferite tipuri
mediaPlayer.play("mp3", "melodie.mp3");
mediaPlayerAdapter.play("vlc", "film.vlc");


2.Modelul Facade este utilizat pentru a ascunde complexitatea unui sistem și pentru a oferi o interfață simplificată 
și unificată pentru a accesa diversele componente ale sistemului. În acest exemplu, clasa Facade este utilizată pentru
a ascunde cele trei sub-sisteme A, B și C și pentru a oferi două metode simple pentru utilizatorii sistemului.

// Se creează un obiect de tip "Facade"
Facade facade = new Facade();

// Se apelează metodele "methodOne" și "methodTwo" ale obiectului "Facade"
facade.methodOne();
facade.methodTwo();

3.Modelul Composite este utilizat pentru a compune obiecte în structuri de arbore pentru a reprezenta o ierarhie între obiecte. 
În acest exemplu, avem două clase, Leaf și Composite, care implementează interfața Component și reprezintă nodurile frunză și compozite 
ale arborelui. Clasa Composite poate conține alte componente ca sub-noduri, inclusiv alte obiecte Composite sau Leaf, formând astfel o ierarhie 
de structuri de tip arbore.

// Se crează obiecte de tip "Leaf" și "Composite"
Component motherboard = new Leaf("Placă de bază", 700);
Component cpu = new Leaf("Procesor", 1500);
Component gpu = new Leaf("Placă video", 2000);
Component ram = new Leaf("RAM", 500);
Composite computer = new Composite("Calculator");
Composite peripherals = new Composite("Periferice");
Composite components = new Composite("Componente");

// Se adaugă componente în obiectul "computer" de tip "Composite"
computer.addComponent(motherboard);
computer.addComponent(cpu);
computer.addComponent(gpu);
computer.addComponent(ram);

// Se adaugă componente în obiectul "peripherals" de tip "Composite"
Component keyboard = new Leaf("Tastatură", 100);
Component mouse = new Leaf("Mouse", 80);
peripherals.addComponent(keyboard);
peripherals.addComponent(mouse);

// Se adaugă componente în obiectul "components" de tip "Composite"
components.addComponent(computer);
components.addComponent(peripherals);

// Se afișează prețurile pentru toate componentele
components.showPrice();
let totalPrice = components.calculateTotalPrice();

Această linie de cod apelează metoda calculateTotalPrice() a obiectului components pentru a obține prețul total al comenzii.

Apoi, prețul total este afișat prin apelarea metodei showPrice():

components.showPrice(totalPrice);

Această metodă primește un argument - totalPrice - și afișează acest preț pe pagină pentru utilizator.
