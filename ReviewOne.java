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

    public static void printAllPermutation(String word){
    
    }

    public static void main(String[] args) {
        // (1) specialRemove 
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
        Comparable[] sorted = new Comparable[]{1,2,5,5,5,5,5,5,8,9,9,9,9,10,11,12};
        findRange(sorted, 9);

        // (3) printAllPermutation
    }    
}