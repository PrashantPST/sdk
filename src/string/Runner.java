package string;

public class Runner {
    public static void main(String[] args) {
        String input = "bB";
        if (StringADT.uniqueCharacters(input))
            System.out.print("Yes");
        else
            System.out.print("No");

        String a = "ACAB";
        String b = "XCXY";
        System.out.println(StringADT.isIsomorphic(a, b));
    }
}
