package utils;

import java.util.*;

public class UtilFunctions {

    private static int count = 0;

    public static void main(String[] args) {
        UtilFunctions uf = new UtilFunctions();

        // 1. sort an array of numbers:
        ++count;
        int[] nums = {4, 3, 9, 10, 25, 19, 5, 7, 1, 12, 8};
        Arrays.sort(nums);
        System.out.println(cnt() + "Ascending order after sorting array: " + Arrays.toString(nums));

        // 2. sort an array of comparable:
        ++count;
        int[][] points = {{1, 2}, {3, 4}, {1, 1}, {4, 1}, {3, 3}, {-1, -2}, {-2, 2}};
        Arrays.sort(points, Comparator.comparingInt(x -> x[0] * x[0] + x[1] * x[1]));
        System.out.println(cnt() + "Sort array with Comparator: " + Arrays.deepToString(points));

        // 3. fill an array, or array of array:
        ++count;
        int[][] ones = new int[5][6];
        for (int i = 0; i < ones.length; ++i) Arrays.fill(ones[i], 1);
        System.out.println(cnt() + "Fill array: " + Arrays.deepToString(ones));

        // 4. Map putIfAbsent(), getOrDefault():
        ++count;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < 10; ++i) {
            map.putIfAbsent(i, i * 4);
        }
        for (int i = 0; i < 11; ++i) {
            map.put(i, map.getOrDefault(i, 111) + 1);
        }
        System.out.print(cnt());
        map.entrySet().forEach(e -> System.out.print(e + ", "));
        System.out.println();

        // 5. TreeSet, mapSet and mapList:
        ++count;
        Set<String> strSet = new TreeSet<>(Comparator.comparingInt(s -> s.length()));
        strSet.addAll(Arrays.asList("hi", "print", "system", "deep", "one"));
        System.out.println(cnt() + strSet);
        Set<Map.Entry<Integer, Integer>> mapSet = new TreeSet<>(
                Comparator.comparingInt(e -> -e.getValue()));
        mapSet.addAll(map.entrySet());
        System.out.println(mapSet); // no equal items in TreeSet
        List<Map.Entry<Integer, Integer>> mapLst = new ArrayList<>();
        mapLst.addAll(map.entrySet());
        Collections.sort(mapLst, Comparator.comparingInt(e -> e.getValue() % 5));
        System.out.println(mapLst);

        // 6. LinkedList implements Deque<E>:
        ++count;
        LinkedList<String> linkedList = new LinkedList<>(Arrays.asList("set", "hello", "brian", "fish"));
        System.out.println(cnt() + linkedList);
        linkedList.addLast("tel");
        System.out.println("After add last: " + linkedList.peekLast());
        System.out.println("Poll first: " + linkedList.pollFirst());
        System.out.println(linkedList);
        /**
         *  Queue api: add(e) =~ offer(e),
         *             remove() =~ poll() : retrieve and move head of queue,
         *             element() =~ peek(): retrieve head of queue
         *  Deque extends Queue api:
         *             addFirst(e) =~ offerFirst(e), addLast(e) =~ offerLast(e),
         *             removeFirst() =~ pollFirst(), removeLast() =~ pollLast(),
         *             getFirst() =~ peekFirst(), getLast() =~ peekLast(),
         *  LinkedList implements List, Deque
         *  PriorityQueue implements Queue
         */

        // 7. TreeSet api:
        ++count;
        TreeSet<Integer> ts = new TreeSet<>(Arrays.asList(4, 2, 5, 8, 16, 9, 3, 6, 20, 13));
        System.out.println(cnt() + ts);
        System.out.println("higher element of 6: " + ts.higher(6));
        System.out.println("ceiling element of 6: " + ts.ceiling(6));
        System.out.println("floor element of 6: " + ts.floor(6));
        System.out.println("lower element of 6: " + ts.lower(6));

        // 8. 1e5:
        ++count;
        System.out.println(cnt() + "1e4 = " + 1e4);
    }

    private static String cnt() {
        return "\n" + count + ": ";
    }
}













