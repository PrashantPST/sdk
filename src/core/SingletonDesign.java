package core;

class Singleton {
    private static Singleton single_instance = null;
    String str;
    private Singleton() {
        str = "Welcome to DataFlair";
    }
    static Singleton singleton() {
        if (single_instance == null) {
            single_instance = new Singleton();
        }
        return single_instance;
    }
}
public class SingletonDesign {
    public static void main(String[] args) {
        Singleton text1 = Singleton.singleton();
        Singleton text2 = Singleton.singleton();

        text1.str = (text1.str).toUpperCase();
        System.out.println("String in Upper Case " + text2.str);
        System.out.println("");

        text2.str = (text2.str).toLowerCase();
        System.out.println("String in Lower Case " + text1.str);
    }
}
