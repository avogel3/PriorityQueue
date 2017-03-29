/**
 * Created by avogel on 1/2/17.
 */

import java.io.*;
import java.util.Scanner;

public class Prog1 {

    //generate static method by typing psvm + tab
    public static void main(String[] args) throws FileNotFoundException {
        // read the file input and print to screen

        Scanner in = new Scanner(new File(args[0]));
        while(in.hasNextLine()) {
            System.out.println(in.nextLine());
        }
    }
}
