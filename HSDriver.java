public class HSDriver {
    public static void main(String[] args) {
        long start=System.nanoTime();
        int n=Integer.parseInt(args[1]);
        int trace=-1;
        if(args.length>=3)
        trace=Integer.parseInt(args[2]);
        int[] unSorted;

        if (args[0].equals("RandomGen")){
            if (args.length<=3) //that is there are only args[0] --- args[2] without args[3]
                unSorted=RandomGen.ran(n,-1);
            else
                unSorted=RandomGen.ran(n,Long.parseLong(args[3]));
        }
        else
            unSorted=FixedGen.ran(n);

        if (trace<0)
            HeapSort.sort(unSorted);
        else
            HeapSort.sort(unSorted,trace);
        long end=System.nanoTime();
        System.out.println("\ncompleted in "+(end-start)+"ns");
    }

}
