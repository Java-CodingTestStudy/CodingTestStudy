import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static class Student{
        String name;
        int kor;
        int eng;
        int math;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();


        List<Student> list = new ArrayList<>();


        for(int i=0;i<n;i++){
            String temp = sc.nextLine();
            Student st = new Student();
            String[] t = temp.split(" ");
            st.name = t[0];
            st.kor = Integer.parseInt(t[1]);
            st.eng = Integer.parseInt(t[2]);
            st.math = Integer.parseInt(t[3]);
            list.add(st);
        }

        list.sort(((o1, o2) -> {
            return o1.name.compareTo(o2.name);
        }));

        list.sort((o1, o2) -> {
            return o2.math - o1.math;
        });

        list.sort((o1, o2) -> {
            return o1.eng - o2.eng;
        });

        list.sort((o1, o2) -> {
            return o2.kor - o1.kor;
        });


        for (Student student : list) {
            System.out.println(student.name);
        }


    }
}