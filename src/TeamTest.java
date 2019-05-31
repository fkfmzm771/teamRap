import java.util.*;

public class TeamTest {
    static int count = 0;
    static Map<String, Integer> score_list = new LinkedHashMap<>();

    public static void main(String[] args) {
        //중복순열 (순서있게 배열 + 자시자신도 포함)
        System.out.println("***중복순열(0,1,2)***");
        LinkedList<Integer> perArr = new LinkedList<Integer>();

        for (int i = 8; i >= 1; i--) {
            rePermutation( i, perArr);
        }

        int cc = 0;
        for (Map.Entry<String, Integer> entry : score_list.entrySet()) {
            String key = entry.getKey();
            int value  = entry.getValue();
            System.out.println("key = " + key + ", value = " + value);
        }

    }


    //중복순열 (순서있게 배열 + 자시자신도 포함)
    private static void rePermutation( int r, LinkedList<Integer> rePerArr) {
        if (rePerArr.size() == r) {
            StringBuffer sb = new StringBuffer();

            for (int i : rePerArr) {
                sb.append((char)i);
            }
            System.out.println(sb.toString());
            score_list.put(sb.toString(),0);
            count++;
            return;
        }

        for (int i = 65; i <= 68; i++) {
            rePerArr.add(i);
            rePermutation(r, rePerArr);
            rePerArr.removeLast();
        }
    }
}
