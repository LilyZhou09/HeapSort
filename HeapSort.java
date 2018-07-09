public class HeapSort {
    public static void sort(int[] input){
        System.out.print("sorting: ");
        print(input);
        for (int i = input.length/2-1; i >= 0; i--) {
            sortSubtree(input,input.length,i);
        }
        for (int i = input.length-1; i >= 0; i--) {
            int temp=input[0];
            ButtomUp(input,i,i);
            input[i]=temp;
        }
        System.out.println("\nresult: ");
        print(input);
    }

    public static void sort(int[] input, int traceStep){
        System.out.print("sorting: ");
        print(input);
        for (int i = input.length/2-1; i >= 0; i--) {
            sortSubtree(input,input.length,i);
        }
        if (traceStep==0){
            System.out.println("trace at step 0: ");
            print(input);
        }
        int round=0;
        for (int i = input.length-1; i >= 0; i--) {
            int temp=input[0];
            ButtomUp(input,i,i);
            input[i]=temp;
            round++;
            if (round==traceStep){
                System.out.print("\ntrace at step "+traceStep+": ");
                print(input);
            }
        }
        System.out.print("\nresult: ");
        print(input);
    }

    public static void ButtomUp(int[] input, int i, int end){
        int prime=primePath(input,end);
        while (input[i]>input[prime]){
            if (prime%2==0)
                prime=(prime-2)/2;
            else
                prime=(prime-1)/2;
        }
        int temp=input[prime];
        input[prime]=input[i];
        while (prime>0){
            if (prime%2==0)
                prime=(prime-2)/2;
            else
                prime=(prime-1)/2;
            int temp2=temp;
            temp=input[prime];
            input[prime]=temp2;
        }
    }

    public static int primePath(int[] input, int end){
        int prime=0;
        while ((prime*2+1)<=end){
            if ((prime*2+2)<=end&&input[prime*2+2]>=input[prime*2+1])
                prime=prime*2+2;
            else
                prime=prime*2+1;
        }
        return prime;
    }

    public static void sortSubtree(int sub[], int unSortedNum, int parent){
        int greatest=parent;
        int leftChild=2*parent+1;
        int rightChild=2*parent+2;
        if (leftChild<unSortedNum&&sub[leftChild]>sub[greatest]){
            greatest=leftChild;
        }
        if (rightChild<unSortedNum&&sub[rightChild]>sub[greatest]){
            greatest=rightChild;
        }
        if (greatest!=parent){
            swap(sub,greatest,parent);
            sortSubtree(sub,unSortedNum,greatest);
        }
    }

    public static void swap(int useArr[], int i, int j){
        int temp=useArr[i];
        useArr[i]=useArr[j];
        useArr[j]=temp;
    }

    public static void print(int arr[]){
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
    }
}
