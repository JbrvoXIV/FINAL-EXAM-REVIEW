import java.util.*;

public class ReviewOne {

    // Complete the implementation of the following method that removes every element of a 
    // given LinkedList<String> if it has an index divisible by 5.

    public static void specialRemove(LinkedList<String> list){
        ListIterator<String> it = list.listIterator();
        for(int i = 0; it.hasNext(); i++) {
            it.next();
            if(i % 5 == 0) {
                it.remove();
            }
        }
    }

    // Complete the implementation of the following method that gets a sorted list of 
    // type Comparable[] and a target value of type Comparable as input parameters 
    // and prints out the range of list indices in which the target value appears in the list. 
    // For example, given the list 3, 5, 5, 8, 8, 8, 8, 8, 9, 12, 123, 123, 166, 167 and the target value 8, the method should print "[3, 7]".
    // Hint: use binary search.

    public static void firstOccurence(int low, int high, Comparable[] list, Comparable target) {
        if(low > high) {
            System.out.printf("[ %d,", -1);
            return;
        }
        
        int mid = (int)(low / 2.0 + high / 2.0);
        int comp = target.compareTo(list[mid]);

        if(comp == 0) {
            if(mid == 0 || list[mid - 1].compareTo(target) != 0) {
                System.out.printf("[ %d,", mid);
            } else {
                firstOccurence(low, mid - 1, list, target);
            }
        } else if(comp == 1) {
            firstOccurence(mid + 1, high, list, target);
        } else {
            firstOccurence(low, mid - 1, list, target);
        }
    }

    public static void lastOccurence(int low, int high, Comparable[] list, Comparable target) {
        if(low > high) {
            System.out.printf(" %d ] (USING RECURSION)\n", -1);
            return;
        }
        
        int mid = (int)(low / 2.0 + high / 2.0);
        int comp = target.compareTo(list[mid]);

        if(comp == 0) {
            if(mid == list.length - 1 || list[mid + 1].compareTo(target) != 0) {
                System.out.printf(" %d ] (USING RECURSION)\n", mid);
            } else {
                lastOccurence(mid + 1, high, list, target);
            }            
        } else if(comp == 1) {
            lastOccurence(mid + 1, high, list, target);
        } else {
            lastOccurence(low, mid - 1, list, target);
        }
    }

    public static void findRange(Comparable[] list, Comparable target){
        firstOccurence(0, list.length - 1, list, target);
        lastOccurence(0, list.length - 1, list, target);

        // MUCH EASIER VERSION
        List<Comparable> newList = Arrays.asList(list);
        System.out.printf("[ %d, %d ] (USING ARRAY.ASLIST METHODS)\n", newList.indexOf(target), newList.lastIndexOf(target));
    }

    // Using recursion, complete the implementation of the following method that 
    // prints all permutations of a given word. For example, given the word "may", it prints the following words:
    // may, mya, amy, aym, yam, yma

    private static String[] helper(String word){
        if(word.length() == 1) {
            return new String[]{word};
        }

        int factorial = 1;
        for(int i = 2; i <= word.length(); factorial *= i++);
        String[] permutations = new String[factorial];
        int current = 0;

        for(int i = 0; i < word.length();i++) {
            String shorter = word.substring(0, i) + word.substring(i+1); //all but the ith character
            for(String shorterPermutation: helper(shorter))
                permutations[current++] = (word.charAt(i) + shorterPermutation);
        }
        return permutations;
    }

    public static void printAllPermutations(String vals){
        if(vals.isEmpty()) {
            return;
        }

        String[] out = helper(vals);
        List<String> result = new ArrayList<String>(new HashSet<String>(Arrays.asList(out)));
        Collections.sort(result);

        // NEW CODE WITH SET USAGE
        for(String str : result) {
            System.out.printf("%s\n", str);
        }

        // OLD CODE W/O SET USAGE
        // String prev = null;

        // for(String word: out) {
        //     if(prev == null || !word.equals(prev)) {
        //         System.out.println(prev = word);
        //     }
        // }

    }
    
    public static void f(int n){

        if(n == 0) {
            System.out.print("A ");
        }
        else {
            System.out.print("B ");
            f(n - 1);
            System.out.print("C ");
        }  
    }

    public static void g(int n, int b){

        if(n < b) {
            System.out.print(n);
        }
        else {
             System.out.print(n%b);
             g(n/b, b);
        }
   }

   public static String f(String str){
        int len = str.length();
        if(len < 2) {
            return str;
        }
        return f(str.substring(3*len/4)) 
                + f(str.substring(len/2, 3*len/4)) 
                + f(str.substring(len/4, len/2)) 
                + f(str.substring(0, len/4));
    }

    public static void binarySearch(int low, int high, Comparable[] array, Comparable target){
        if(low > high) {
            System.out.printf("INDEX NOT FOUND FOR TARGET");
        }

        int mid = (int)(low / 2.0 + high / 2.0);
        int comp = target.compareTo(array[mid]);

        if(comp == 0) {
            if(mid == 0 || array[mid - 1].compareTo(target) != 0) {
                System.out.printf("FIRST INDEX OF TARGET: [ %d ]\n", mid);
            } else {
                binarySearch(low, mid - 1, array, target);
            }
        } else if(comp == 1) {
            binarySearch(mid + 1, high, array, target);
        } else {
            binarySearch(low, mid + 1, array, target);
        }
    }

    

    public static void main(String[] args) {
        // (1) specialRemove
        System.out.println("\nREMOVE INDEXES OF FACTOR 5 FROM LINKED LIST QUIZ ANSWER:");
        LinkedList<String> list = new LinkedList<String>();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        list.add("5");
        list.add("6");
        list.add("7");
        list.add("8");
        list.add("9");
        for(String str : list)
            System.out.printf("%s\t", str);
        System.out.println();
        specialRemove(list);

        for(String str : list)
            System.out.printf("%s\t", str);
        System.out.println();

        // (2) findRange
        System.out.println("\nFIND RANGE OF INDEX OF ELEMENT IN ARRAY USING BINARY SEARCH QUIZ ANSWER:");
        Comparable[] sorted = new Comparable[]{1,2,5,5,5,5,5,5,8,9,9,9,9,10,11,12};
        findRange(sorted, 4);

        // (3) printAllPermutation
        System.out.println("\nRECURSIVELY PRINT PERMUTATIONS QUIZ ANSWER:");
        printAllPermutations("abc");

        // (4)  Recursion QUIZ XVII
        
        System.out.println("\nRECURSIVE QUIZ XVII ANSWER:");
        f(3);
        g(85649, 10);
        System.out.println();
        System.out.println(f("what does the recursive method f do in this program?!!!"));
        Comparable[] array = new Comparable[]{1, 2, 3, 3, 3, 5, 5, 5, 6, 6, 7, 7, 7, 7, 7, 8, 8, 9, 10, 10, 10, 10};
        binarySearch(0, array.length - 1, array, 7);

        // (5) printWithThousandsSeparator

        System.out.println("\nREVERSE LINKED LIST ITERATING QUIZ ANSWER:");
        HugeInt intList = new HugeInt();
        intList.digits.addAll(Arrays.asList(5, 4, 3, 8, 5, 6, 8, 7, 3, 1));
        intList.printWithThousandsSeparator();

        // (6) LinkedList

        System.out.println("\nLINKEDLIST QUIZ ANSWER:");
        LinkedList<Integer> numbers = new LinkedList<Integer>();
        for(int i = 0; i < 5;i++) { // add numbers 0 - 4 to end of list 0 -> 1 -> 2 -> 3 -> 4
            numbers.addLast(i); 
        }

        ListIterator<Integer> it = numbers.listIterator();
        while(it.hasNext()) {
            System.out.print(it.next() + (it.hasNext()?" -> ": "\n"));
        }
        while(it.hasPrevious()) {
            it.previous();
            if(it.hasPrevious()) {
                it.previous();
                it.remove();
            }
        }
        int count = 1;
        for(int number: numbers)
            System.out.print(count + " : " + number + (count++ < numbers.size()? " -> ": ""));

        // (7) Stack

        System.out.println("\n\nSTACK QUIZ ANSWER:");
        Stack<Integer> s = new Stack <Integer>();
        int[] data = new int[]{ 5, 4, 6, 3, 2, 9, 13 };
        for (int i = 0; i < data.length; i++) {
            s.push(data[i++]);
            if (i < data.length) {
                s.push(data[i]);
            } // [ 5, 4, 6, 3, 2, 9, 13 ]
            System.out.print(s.pop() + ","); // "4,3,9,13,"
        } // [ 5, 6, 2 ]
        while(!s.empty()) {
            System.out.print(s.pop()+"."); // "4,3,9,13,2.6.5."
        }
    }    
}