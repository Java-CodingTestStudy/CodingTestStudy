package 문자열.예진;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());      
        for(int i=0; i<n; i++){
            StringBuilder sb = new StringBuilder();  
            String[] sarr = sc.nextLine().split(" ");
            int rep = Integer.parseInt(sarr[0]);
            String s = sarr[1];

            for(int j=0; j<s.length();j++){
                for(int k =0; k<rep; k++){
                    sb.append(s.charAt(j));
                }
            }
            System.out.println(sb);
        }
 
        
    }
}
