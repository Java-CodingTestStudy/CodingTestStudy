import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        // 학생 수
        int N = Integer.parseInt(st.nextToken());
        
        // 학생 입력받기
        List<Student> list = new ArrayList<>();
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            
            String name = st.nextToken();
            int kor = Integer.parseInt(st.nextToken());
            int eng = Integer.parseInt(st.nextToken());
            int mat = Integer.parseInt(st.nextToken());
            Student stu = new Student(name, kor, eng, mat);
            
            list.add(stu);
        }
        
        // 정렬
        // 국어 기준 내림차순, 영어 기준 오름차순, 수학 기준 내림차순, 이름 오름차순
        list.sort(new Comparator<Student>() {
            @Override
            public int compare(Student s1, Student s2) {
                if(s1.kor != s2.kor) return s2.kor - s1.kor;
                if(s1.eng != s2.eng) return s1.eng - s2.eng; 
                if(s1.mat != s2.mat) return s2.mat - s1.mat;
                return s1.name.compareTo(s2.name);   
                //    return compareString(s1.name, s2.name);
               
            }
        });
        
        // 이름 출력
        for(Student stu : list) {
            System.out.println(stu.name);
        }
    }
    
    private static int compareString(String s1, String s2) {
        int len = s1.length() > s2.length() ? s2.length() : s1.length();
        
        for(int i = 0; i < len; i++) {
            if(s1.charAt(i) != s2.charAt(i)) {
                return s1.charAt(i) - s2.charAt(i);    
            }
        }
        
        return s1.length() - s2.length();
    }
}

class Student {
    String name;
    int kor;
    int eng;
    int mat;
    
    Student(String name, int kor, int eng, int mat) {
        this.name = name;
        this.kor = kor;
        this.eng = eng;
        this.mat = mat;
    }
}