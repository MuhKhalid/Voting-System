import java.io.IOException;
import java.util.Scanner;

public class VotingTest {

    public static void main(String[] args) throws IOException {

        /*
         * i used the try and catch command for the people who enter a letter or a word
         * or a special charctar so it can catch it.
         * and do while loop for the poeple who put a wrong number3
         */

        int z = 0;
        do {
            Voting votes = new Voting();
            Scanner keyboard = new Scanner(System.in);
            // here i gave the loop a tile so i can break by the command break loop;
            loop: while (true) {
                try {
                    System.out.println("\nEnter the number infront of the name you want to vote for\n ------------");
                    System.out.println("Enter 1 for: ahmed\n -------------  ");
                    System.out.println("Enter 2 for: ali\n -------------   ");
                    System.out.println("Enter 3 if you want to add a new candidate\n -------------");
                    System.out.println("Enter 4 to show only the result");

                    z = keyboard.nextInt();
                    keyboard.nextLine();
                    // here i used switch command instead of if condtion becasue it's easier.

                    switch (z) {
                        case 1:
                            votes.castVote("ahmed");
                            votes.printResults();

                            break loop;
                        case 2:
                            votes.castVote("ali");
                            votes.printResults();
                            break loop;
                        case 3:
                            System.out.println("enter the name of the people you want to vote for");
                            String candidate = keyboard.nextLine().toLowerCase();
                            votes.addCandidate(candidate);
                            votes.castVote(candidate);
                            votes.printResults();

                            break loop;
                        case 4:
                            votes.printResults();
                            break loop;
                        default:
                            System.out.println("wrong number select from 1 to 4");

                    }
                } catch (Exception e) {
                    System.out.println("Enter intgers only, with no spaces or other characters\n");
                    break loop;
                }
            }

        }
        /*
         * i used do-while loop because somepeople enter other number so this while loop
         * can
         * catch it.
         */

        while (z < 1 || z > 4);
        System.out.println("\nValue correctly entered! Thank you.");

    }

}