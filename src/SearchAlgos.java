public class SearchAlgos {

    public static void main(String[] args) {
        int[] arr = {2,4,6,8,8,8,8,10,12,14};
        int[] arr2={1,3,5,6};
        int key=0;
        //int index = linearSearch(arr, key);
//        int index = binarySearch(arr2, key);
//        System.out.println("Value found at index "+index);
        //reverseArray(arr);
//        for (int i=0;i<arr.length;i++) {
//            System.out.print(arr[i]+" ");
//        }
        //pairsInArray(arr);
        //printSubArrays(arr);
        //printMaxAndMinSumInSubArrays(arr);
        //printMaxAndMinUsingPrefixSum(arr);
//        int[] nums={1,1,1,2};
//        int k =removeDuplicates(nums);
//        System.out.println("k:"+k);
        //leftRotatedArray(arr);
        //leftRotatedArrayBySDigits(arr,3);
//        int maxSum = kadaneAlgorithm(arr);
//        System.out.println("maxSum using kadane:"+maxSum);
        //printMaxSubArrayForGivenKValue(arr2, 1);
//        int value = searchInsertPosition(arr2, 0);
//        System.out.println("insert index position "+value);
//        int value = lastOccurrence(arr, 8);
//        System.out.println("last occurrence position "+value);
        int value = firstOccurrence(                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                            arr, 8);
        System.out.println("first occurrence position "+value);
    }

    static int searchInsertPosition(int[] arr, int k){
        int start=0;
        int end=arr.length-1;
        int result= arr.length;
        while(start<=end){
            int mid=(start+end)/2;
            if(arr[mid]>=k){
                result= mid;
                end=mid-1;
            } else {
                start=mid+1;
            }
        }
        return result;
    }

    static int lastOccurrence(int[] arr, int k){
        int start=0;
        int end=arr.length-1;
        int result= -1;
        while(start<=end){
            int mid=start+(end-start)/2;
            if(arr[mid]==k){
                result=mid;
                start=mid+1;
            }
            else if(arr[mid]>k){
                end=mid-1;
            } else {
                start=mid+1;
            }
        }
        return result;
    }

    static int firstOccurrence(int[] arr, int k){
        int start=0;
        int end=arr.length-1;
        int result= -1;
        while(start<=end){
            int mid=start+(end-start)/2;
            if(arr[mid]==k){
                result=mid;
                end=mid-1;
            }
            else if(arr[mid]>k){
                end=mid-1;
            } else {
                start=mid+1;
            }
        }
        return result;
    }


    static int linearSearch(int[] arr, int k) {
        for(int i=0;i<arr.length;i++) {
            if(arr[i]==k){
                return i;
            }
        }
        return -1;
    }

    static int binarySearch(int[] arr, int k) {
        //note: for binary search array must be sorted array
        int start = 0;
        int end=arr.length-1;

        while(start<=end) {
            int mid=(start+end)/2;
            if(arr[mid]==k) {
                return mid;
            } else if(arr[mid]>k) {
                end=mid-1;
            } else {
                start=mid+1;
            }
        }

        return -1;
    }

    static void reverseArray(int[] arr) {
        int start=0;
        int end=arr.length-1;
        int temp;
        while(start<end) {
            temp=arr[start];
            arr[start]=arr[end];
            arr[end]=temp;
            start++;
            end--;
        }
    }
    static void pairsInArray(int[] arr) {
        int start;
        for(int i=0;i<arr.length;i++) {
            start=i;
            for(int j=i+1;j<arr.length;j++) {
                System.out.print("("+arr[i]+","+arr[j]+")");
            }
            System.out.println();
        }
    }

    static void printSubArrays(int[] arr) {
        for(int i=0;i<arr.length;i++) {
            for(int j=i;j<arr.length;j++) {
                for(int k=i;k<=j;k++) {
                    System.out.print(arr[k]+" ");
                }
                System.out.println();
            }
            System.out.println();
        }
    }

    static void printMaxAndMinSumInSubArrays(int[] arr) {
        int sumOfNnumbers= (arr.length*(arr.length+1))/2;
        int[] sumArray = new int[sumOfNnumbers];
        int si=0;
        for(int i=0;i<arr.length;i++) {
            for(int j=i;j<arr.length;j++) {
                int sum=0;
                for(int k=i;k<=j;k++) {
                    sum=sum+arr[k];
                }
                sumArray[si]=sum;
                si++;
            }
        }
        int maxSum=sumArray[0];
        int minSum=sumArray[0];
        for (int i=0;i<sumArray.length;i++) {
            if(sumArray[i]>maxSum) {
                maxSum=sumArray[i];
            }
            if(sumArray[i]<minSum) {
                minSum=sumArray[i];
            }
            System.out.print(sumArray[i]+" ");
        }
        System.out.println();
        System.out.println("maxSum:"+maxSum);
        System.out.println("minSum:"+minSum);
    }

    static void printMaxAndMinUsingPrefixSum(int[] arr) {
        int[] sumArray = new int[arr.length];
        sumArray[0]=arr[0];
        for(int i=1;i<arr.length;i++) {
            sumArray[i]=sumArray[i-1]+arr[i];
        }
        int sum=0;
        int maxSum=Integer.MIN_VALUE;
        int minSum=arr[0];
        for(int i=0;i<arr.length;i++) {
            int start=i;
            for(int j=i;j<arr.length;j++) {
                int end=j;
                sum = start==0?sumArray[end]:sumArray[end]-sumArray[start-1];
                if(sum>maxSum) {
                    maxSum=sum;
                }
                if(sum<minSum) {
                    minSum=sum;
                }
            }
        }

        System.out.println("min:"+minSum);
        System.out.println("max:"+maxSum);
    }

    static int removeDuplicates(int[] nums) {
        int c=0;
        for(int i=1;i<nums.length;i++) {
            if(nums[i]!=nums[c]) {
                c++;
                nums[c]=nums[i];
            }
        }
        for(int i=0;i<c+1;i++){
            System.out.print(nums[i]+" ");
        }
        return c+1;
    }

    static void leftRotatedArray(int[] arr) {
        int c=arr[0];
        for(int i=0;i<arr.length-1;i++){
            arr[i]=arr[i+1];
        }
        arr[arr.length-1]=c;
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+ " ");
        }
    }

    static void leftRotatedArrayBySDigits(int[] arr, int s) {
        int[] temp=new int[s];
        int c=0;
        for(int i=0;i<s;i++) {
            temp[i]=arr[i];
        }
        for(int i=0;i<arr.length-s;i++){
            arr[i]=arr[i+1];
        }
        for(int j=arr.length-s;j<arr.length;j++) {
            arr[j]=temp[c];
            c++;
        }
        //arr[arr.length-1]=c;
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+ " ");
        }
    }

    static int kadaneAlgorithm(int[] arr) {
        int currSum=0;
        int maxSum = Integer.MIN_VALUE;
        for(int i=0;i<arr.length;i++) {
            currSum = currSum+arr[i];
            if(currSum<0){
                currSum=0;
            }
            maxSum = Math.max(currSum,maxSum);
        }
        return maxSum;
    }

    static void printMaxSubArrayForGivenKValue(int[] arr, int k) {
        int sum=0;
        int count=0;
        for(int i=0;i<arr.length;i++) {
            int j=i;
            while(j<arr.length){
                sum=sum+arr[j];
                if(sum==k){
                    count=Math.max(count, j-i+1);
                }
                j++;
            }
        }
        System.out.println("longest subarray with sum k is "+count);
    }
}
