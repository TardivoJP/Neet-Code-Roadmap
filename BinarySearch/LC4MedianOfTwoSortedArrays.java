class MedianOfTwoSortedArrays {
    public static void main(String[] args) {
        int[] testcase1arrA = {1,3};
        int[] testcase1arrB = {2};

        int[] testcase2arrA = {1,2};
        int[] testcase2arrB = {3,4};

        int[] testcase3arrA = {1,3,3,6};
        int[] testcase3arrB = {7,8,9};

        System.out.println(findMedianSortedArrays(testcase1arrA, testcase1arrB));
        System.out.println(findMedianSortedArrays(testcase2arrA, testcase2arrB));
        System.out.println(findMedianSortedArrays(testcase3arrA, testcase3arrB));
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;

        if(n1 > n2){
            return findMedianSortedArrays(nums2, nums1);
        }

        int low = 0;
        int high = n1;

        int left = (n1 + n2 + 1) / 2;
        int n = n1+ n2;

        while(low <= high){
            int mid1 = (low + high) >>> 1;
            int mid2 = left - mid1;

            int l1 = Integer.MIN_VALUE;
            int l2 = Integer.MIN_VALUE;

            int r1 = Integer.MAX_VALUE;
            int r2 = Integer.MAX_VALUE;

            if(mid1 < n1){
                r1 = nums1[mid1];
            }

            if(mid2 < n2){
                r2 = nums2[mid2];
            }

            if(mid1 - 1 >= 0){
                l1 = nums1[mid1 - 1];
            }

            if(mid2 - 1 >= 0){
                l2 = nums2[mid2 - 1];
            }

            if(l1 <= r2 && l2 <= r1){
                if(n % 2 == 1){
                    return Math.max(l1, l2);
                }else{
                    return ((double) Math.max(l1, l2) + Math.min(r1, r2)) / 2;
                }
            }else if(l1 > r2){
                high = mid1 - 1;
            }else{
                low = mid1 + 1;
            }
        }

        return 0;
    }


    public static double findMedianSortedArraysMergeSort(int[] nums1, int[] nums2) {
        int[] mergedArray = new int[nums1.length + nums2.length];
        mergeSort(mergedArray, nums1, nums2);

        int middle = (mergedArray.length - 1) / 2;

        if(mergedArray.length % 2 == 0){
            return ((double) mergedArray[middle] + mergedArray[middle + 1]) / 2;
        }else{
            return mergedArray[middle];
        }
    }

    private static void mergeSort(int[] inputArray, int[] arrA, int[] arrB){
        mergeSort(arrA);
        mergeSort(arrB);
        merge(inputArray, arrA, arrB);
    }

    private static void mergeSort(int[] inputArray){
        int inputLength = inputArray.length;

        if(inputLength < 2){
            return;
        }

        int midIndex = inputLength / 2;
        int[] leftHalf = new int[midIndex];
        int[] rightHalf = new int[inputLength-midIndex];

        for(int i=0; i<midIndex; i++){
            leftHalf[i] = inputArray[i];
        }

        for(int i=midIndex; i<inputLength; i++){
            rightHalf[i-midIndex] = inputArray[i];
        }

        mergeSort(leftHalf);
        mergeSort(rightHalf);
        merge(inputArray, leftHalf, rightHalf);
    }

    private static void merge(int[] inputArray, int[] leftHalf, int[] rightHalf){
        int leftSize = leftHalf.length;
        int rightSize = rightHalf.length;

        int i = 0;
        int j = 0;
        int k = 0;

        while(i < leftSize && j < rightSize){
            if(leftHalf[i] <= rightHalf[j]){
                inputArray[k] = leftHalf[i];
                i++;
            }else{
                inputArray[k] = rightHalf[j];
                j++;
            }
            k++;
        }

        while(i < leftSize){
            inputArray[k] = leftHalf[i];
            i++;
            k++;
        }

        while(j < rightSize){
            inputArray[k] = rightHalf[j];
            j++;
            k++;
        }
    }
}