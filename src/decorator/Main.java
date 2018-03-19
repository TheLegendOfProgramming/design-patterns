package decorator;


import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        CountingComparator<Integer> comparator = new NumberComparator();
        Integer[] list = new Integer[]{2, 3, 6, 1, 8, 5, 4, 12, 7, 8 ,23};
        Arrays.sort(list, comparator);
        System.out.println("Sorted list of length of "+list.length);
        for (Integer integer : list) {
            System.out.print(integer+" ");
        }
        System.out.println("\nNumber of comparisons: "+comparator.getCount());

    }
}
