import java.util.Random;

public class RandomGen {
    public static int[] ran(int n, long seed){
        int[] reRan=new int[n];
        Random ran;
        if (seed==-1)
            ran=new Random();
        else
            ran=new Random(seed);

        for (int i = 0; i < reRan.length; i++) {
            reRan[i]=ran.nextInt(50);
        }
        return reRan;
    }
}
