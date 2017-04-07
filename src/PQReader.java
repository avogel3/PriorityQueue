import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by avogel on 4/4/17.
 */
public class PQReader {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(new File(args[0]));
        PriorityQueue queue = new PriorityQueue();

        System.out.println("Parsing Input...");
        while(in.hasNextLine()) {
            String cmd = in.next();
            if("insert".equals(cmd)) {
                String name = in.next();
                int priority = Integer.parseInt(in.next());
                queue.insert(name, priority);
            } else {
                System.out.println(queue.remove());
            }
        }
        System.out.println("------Finished------");
    }
}
