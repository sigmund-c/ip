import java.util.Scanner;

public class Duke {
    public static void main(String[] args) {
        System.out.println("Famed, of course, for my unique red skin and unparalleled skills as a general of the House of War, I, the Red Prince, was raised within the vast palaces of the fabled Forbidden City. I was destined to become the next emperor, but my ambitions suffered a bit of a setback when I fell from grace for cavorting with demons. Now I'm exiled and hunted by assassins, but I assure you: I remain undaunted - and as determined as ever to claim my rightful throne!");

        Scanner sc = new Scanner(System.in);

        String input = sc.nextLine();
        while (!input.equals("bye")) {
            System.out.println(input);
            input = sc.nextLine();
        }

        System.out.println("*You take your leave.*");
    }
}
