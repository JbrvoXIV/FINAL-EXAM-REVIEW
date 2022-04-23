import java.util.LinkedList;
import java.util.Iterator;

public class HugeInt {
    
    public LinkedList<Integer> digits;

    public HugeInt() {

        digits = new LinkedList<Integer>();
    }

    public void printWithThousandsSeparator() {

        Iterator<Integer> it = digits.descendingIterator();
        StringBuilder out = new StringBuilder();
        while(it.hasNext()) {
            out.append(it.next());
            if(it.hasNext()) { out.append(it.next()); } else { break; }
            if(it.hasNext()) { out.append(it.next()); }
            if(it.hasNext()) { out.append(","); }
        }
        System.out.println(out.reverse());
    }
}
