import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Voting extends helper {
    FileWriter fr = new FileWriter(file, true);

    Voting() throws IOException {

        /*
         * if you want not changeable candiate you use these tow commands.
         * (numberCandidate.add(0);)
         * (CandidateName.add("add name here");)
         */

        numberCandidate.add(0);
        numberCandidate.add(0);
        CandidateName.add("ahmed");
        CandidateName.add("ali");
    }
    /*
     * in this code you can decide if you want the user to enter more candidate or
     * not.
     * and i used the command bufferedReader to add the candidate to the text file
     * votes.txt
     */

    void addCandidate(String Name) throws IOException {
        numberCandidate.add(0);
        CandidateName.add(Name);
        BufferedReader file = new BufferedReader(new FileReader("votes.txt"));
        String line;
        while ((line = file.readLine()) != null) {
            String L[] = line.split(",");
            if (L[0].toLowerCase().equals(Name.toLowerCase())) {
                return;

            }

        }

        fr.write(Name + ", 0\n");
        fr.close();

    }

    // with this code the program see who the person vote for and give the cadidate
    // the number of vote

    public void castVote(String name) {
        if (CandidateName.contains(name.toLowerCase())) {
            int vote = numberCandidate.get(CandidateName.indexOf(name));
            vote += 1;
            numberCandidate.set(CandidateName.indexOf(name), vote);
            replaceLines(name);

        } else {
            System.out.println("enter correct name");
        }
    }
    /*
     * in this code you can print the result of the voting before and after the
     * voting.
     * and i used the line.spilt command to add more numbers in fornt of each
     * candidate .
     * and i swtich any name the result print to lower case so there will not be any
     * misunderstandings.
     */

    void printResults() throws NumberFormatException, IOException {
        BufferedReader file = new BufferedReader(new FileReader("votes.txt"));
        String line;
        while ((line = file.readLine()) != null) {
            String L[] = line.split(",");

            if (line.contains(L[0])) {
                int currentVote = Integer.parseInt(L[1].trim());

                System.out.println("the number of vote for " + L[0].toLowerCase() + ": " + currentVote);

            }
        }

    }

    // read file one line at a time
    // replace line as you read the file and store updated lines in StringBuffer
    // overwrite the file with the new lines
    public void replaceLines(String User) {
        try {
            // input the (modified) file content to the StringBuffer "input"
            BufferedReader file = new BufferedReader(new FileReader("votes.txt"));
            StringBuffer inputBuffer = new StringBuffer();
            String line;

            while ((line = file.readLine()) != null) {
                if (line.toLowerCase().contains(User.toLowerCase())) {
                    String[] splitedLine = line.split(",");
                    int currentVote = Integer.parseInt(splitedLine[1].trim());
                    currentVote += 1;
                    line = splitedLine[0];
                    inputBuffer.append(line + ", " + currentVote);
                    inputBuffer.append('\n');
                } else {

                    inputBuffer.append(line);
                    inputBuffer.append('\n');
                }
            }
            file.close();
            // write the new string with the replaced line OVER the same file
            FileOutputStream fileOut = new FileOutputStream("votes.txt");
            fileOut.write(inputBuffer.toString().getBytes());
            fileOut.close();

        } catch (Exception e) {
            System.out.println("Problem reading file." + e);
        }
    }

}
