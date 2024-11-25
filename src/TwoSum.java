public class TwoSum {
    public static void main(String[] args){
        int[] arr={2,6,5,8,11};
        int k=14;
        //findPairWitSumK(arr, k);
        int[] arr2={2,0,2,1,1,0};
        sortAnArrayWith012(arr2);
        for(int i=0;i<arr2.length;i++){
            System.out.print(arr2[i]+" ");
        }
    }

    static void findPairWitSumK(int[] arr, int k){
        for(int i=0;i<arr.length;i++){
            for(int j=i+1;j<arr.length;j++){
                if(arr[i]+arr[j]==k){
                    System.out.print(i+" "+j);
                }
            }
        }
    }

    static void sortAnArrayWith012(int[] arr) {
        int low=0,mid=0,high=arr.length-1;
        while(mid<=high){
            if(arr[mid]==0){
                int temp=arr[low];
                arr[low]=arr[mid];
                arr[mid]=temp;
                low++;
                mid++;
            } else if(arr[mid]==1){
                mid++;
            } else{
                int temp=arr[high];
                arr[high]=arr[mid];
                arr[mid]=temp;
                high--;
            }
        }
    }


}
