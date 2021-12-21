package generator;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class Generator {
    public static void main(String args[]) {
        Random r = new Random();
        String res = "";
        int integer = 0;
        char character = '_';
        Set<Integer> keys = new HashSet<>();    // brain for sortable position values to prevent duplicates
        
        for(int i = 0; i < 100; i++) {
                integer = r.nextInt(151)-50;     // integer between -50 and 100
            do {
                character = (char) (r.nextInt(123-65)+65);   // integer between 65 and 90 or 97 and 122 (ASCII-letters)
            } while(character > 90 && character < 97 || keys.contains(integer + character));
            // TODO: this does not guarantee unique keys (due to operator precedence?)
            keys.add(integer + character);
            res += integer + "\t" + character + "\n";
        }

        System.out.println(res);
    }
}