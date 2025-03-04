public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] arr = appendArrays(nums1, nums2);
        Arrays.sort(arr);
        int len = arr.length;
        if (len % 2 == 1) {
            return arr[(len - 1)/2];
        } else {
            int mid = (len - 1) /2;
            double ans = 0;
            return (arr[mid] + arr[mid + 1]) / 2.0;
        }

    }

    public static int[] appendArrays(int[] arr1, int[] arr2) {
        int[] result = Arrays.copyOf(arr1, arr1.length + arr2.length);
        System.arraycopy(arr2, 0, result, arr1.length, arr2.length);
        return result;
    }
