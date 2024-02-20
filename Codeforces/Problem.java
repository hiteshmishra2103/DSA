import java.util.*;

public class Problem {
    public void sasha() {
    
        Scanner inScanner = new Scanner(System.in);
        int n = inScanner.nextInt();
        ArrayList<Integer> arr = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int x = inScanner.nextInt();
            arr.set(i, x);
        }
        inScanner.close();
        Collections.sort(arr);
        int sum = arr.get(n - 1) - arr.get(0);
        System.out.println(sum);
    }
    public void main(String[] args) {
       sasha();
    }
}
// 5
// 3
// 2 1 3
// 3
// 69 69 69
// 5
// 100 54 80 43 90
// 4
// 3 4 3 3
// 2
// 2 1
