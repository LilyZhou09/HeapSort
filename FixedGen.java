public class FixedGen {
    public static int[] ran(int n){
        int[] reRan=new int[n];
        for (int i = 0; i < reRan.length; i++) {
            reRan[i]=n-i;
        }
        return reRan;
    }
}
