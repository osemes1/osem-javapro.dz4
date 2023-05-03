package javapro.dz7;

public class Main {
    public static void main(String[] args) {
        System.out.println(StringLearning.findSymbolOccurance("Helllo",'l')); // expected 3
        System.out.println(StringLearning.findWordPosition("Apollo","pollo")); // expected 1
//        System.out.println(StringLearning.findWordPosition("hello","pollo")); // expected -1
        System.out.println(StringLearning.stringReverse("Hello"));
        System.out.println(StringLearning.isPalindrome("330033"));
        StringLearning.guessTheWord();
    }
}
