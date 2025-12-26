import java.util.*;

class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        int[]arr = new int[N];
        for(int i=0;i<N;i++){
            arr[i] = i+1;
        }
        List<List<Integer>> result = new ArrayList<>();
        comb(result,new ArrayList<>(),arr,0,K);


        for(List<Integer> l:result){
            int size = l.size();
            for(int i=0;i<size;i++){
                System.out.print(l.get(i)+" ");
            }
            System.out.println();
        }


    }
    static void comb(List<List<Integer>>result,List<Integer>current,int[] arr,int start,int K){
        if(K==0){
            result.add(new ArrayList<>(current));
            return;
        }
        for(int i=start;i<=arr.length - K; i++){
            current.add(arr[i]);
            comb(result,current,arr,i+1,K-1);
            current.remove(current.size()-1);
        }
    }
}