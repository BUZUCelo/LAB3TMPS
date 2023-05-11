    // Interfață pentru obiectele "Target" (țintă) în modelul "Adapter"
    import java.util.List;
    import java.util.ArrayList;

    interface MediaPlayer {
        void play(String audioType, String fileName);
    }

    // Clasa "ConcreteMediaPlayer" (media player concret) în modelul "Adapter"
    class ConcreteMediaPlayer implements MediaPlayer {
        @Override
        public void play(String audioType, String fileName) {
            if (audioType.equalsIgnoreCase("mp3")) {
                System.out.println("Redare MP3 " + fileName);
            } else {
                System.out.println("Tip de fișier neacceptat");
            }
        }
    }

    // Interfață pentru obiectele "Adaptee" (adaptați) în modelul "Adapter"
    interface AdvancedMediaPlayer {
        void playVlc(String fileName);
        void playMp4(String fileName);
    }

    // Clasa "VlcPlayer" (player VLC) în modelul "Adapter"
    class VlcPlayer implements AdvancedMediaPlayer {
        @Override
        public void playVlc(String fileName) {
            System.out.println("Redare VLC " + fileName);
        }

        @Override
        public void playMp4(String fileName) {
            // nu face nimic
        }
    }

    // Clasa "Mp4Player" (player MP4) în modelul "Adapter"
    class Mp4Player implements AdvancedMediaPlayer {
        @Override
        public void playVlc(String fileName) {
            // nu face nimic
        }

        @Override
        public void playMp4(String fileName) {
            System.out.println("Redare MP4 " + fileName);
        }
    }

    // Clasa "MediaPlayerAdapter" (adaptor media player) în modelul "Adapter"
    class MediaPlayerAdapter implements MediaPlayer {
        private AdvancedMediaPlayer advancedMediaPlayer;

        public MediaPlayerAdapter(String audioType) {
            if (audioType.equalsIgnoreCase("vlc")) {
                advancedMediaPlayer = new VlcPlayer();
            } else if (audioType.equalsIgnoreCase("mp4")) {
                advancedMediaPlayer = new Mp4Player();
            }
        }

        @Override
        public void play(String audioType, String fileName) {
            if (audioType.equalsIgnoreCase("vlc")) {
                advancedMediaPlayer.playVlc(fileName);
            } else if (audioType.equalsIgnoreCase("mp4")) {
                advancedMediaPlayer.playMp4(fileName);
            } else {
                System.out.println("Tip de fișier neacceptat");
            }
        }
    }

    // Clasa "SubSystemA" (sub-sistem A) în modelul "Facade"
    class SubSystemA {
        public void methodA() {
            System.out.println("Metodă din SubSistemul A");
        }
    }

    // Clasa "SubSystemB" (sub-sistem B) în modelul "Facade"
    class SubSystemB {
        public void methodB() {
            System.out.println("Metodă din SubSistemul B");
        }
    }

    // Clasa "SubSystemC" (sub-sistem C) în modelul "Facade"
    class SubSystemC {
        public void methodC() {
            System.out.println("Metodă din SubSistemul C");
        }
    }

    // Clasa "Facade" în modelul "Facade"
    class Facade {
        private SubSystemA subSystemA;
        private SubSystemB subSystemB;
        private SubSystemC subSystemC;

        public Facade() {
            subSystemA = new SubSystemA();
            subSystemB = new SubSystemB();
            subSystemC = new SubSystemC();
        }
        public void methodOne() {
            System.out.println("Metodă de tipul 1");
            subSystemA.methodA();
            subSystemB.methodB();
        }

        public void methodTwo() {
            System.out.println("Metodă de tipul 2");
            subSystemB.methodB();
            subSystemC.methodC();
        }
    }

    // Interfață pentru nodurile din arborele compozit în modelul "Composite"
    interface Component {
        void showPrice();
    }

    // Clasa "Leaf" (frunză) în modelul "Composite"
    class Leaf implements Component {
        private String name;
        private int price;
        public Leaf(String name, int price) {
            this.name = name;
            this.price = price;
        }

        @Override
        public void showPrice() {
            System.out.println(name + ": " + price + " RON");
        }
    }

    // Clasa "Composite" în modelul "Composite"
    class Composite implements Component {
        private String name;
        private List<Component> components = new ArrayList<>();
        public Composite(String name) {
            this.name = name;
        }

        public void addComponent(Component component) {
            components.add(component);
        }

        public void removeComponent(Component component) {
            components.remove(component);
        }

        @Override
        public void showPrice() {
            System.out.println(name);
            for (Component component : components) {
                component.showPrice();
            }
        }
    }

    // Clasa "StructuralDesignPatternsExample" (exemplu de modele de proiectare structurale)
    public class StructuralDesignPatternsExample {
        public static void main(String[] args) {
    // Model "Adapter"
            MediaPlayer mediaPlayer = new ConcreteMediaPlayer();
            mediaPlayer.play("mp3", "melodie.mp3");
            MediaPlayer mediaPlayerAdapter = new MediaPlayerAdapter("vlc");
            mediaPlayerAdapter.play("vlc", "film.vlc");

            // Model "Facade"
            Facade facade = new Facade();
            facade.methodOne();
            facade.methodTwo();

            // Model "Composite"
            Composite computer = new Composite("Calculator");
            Leaf mouse = new Leaf("Mouse", 100);
            Leaf keyboard = new Leaf("Tastatură", 200);
            Leaf monitor = new Leaf("Monitor", 500);
            Composite peripherals = new Composite("Periferice");
            peripherals.addComponent(mouse);
            peripherals.addComponent(keyboard);
            Composite mainComponents = new Composite("Componente principale");
            mainComponents.addComponent(peripherals);
            mainComponents.addComponent(monitor);
            computer.addComponent(mainComponents);
            computer.showPrice();
        }
    }