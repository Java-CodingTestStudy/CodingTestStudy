
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        String[] arr;
        Set<String> set = new HashSet<String>();
        for (int i = 0; i < n; i++) {
            String temp = sc.next();
            set.add(temp);
        }

        arr = set.toArray(new String[set.size()]);





        Arrays.sort(arr,((o1, o2) -> {
            if(o1.length() == o2.length()){
                return o1.compareTo(o2);
            }


            return o1.length() - o2.length();
        }));

        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }

    }
}
