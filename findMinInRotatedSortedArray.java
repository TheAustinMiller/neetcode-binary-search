public int findMin(int[] nums) {
        if (nums[0] <= nums[nums.length - 1]) { return nums[0]; }
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (mid > 0 && nums[mid] < nums[mid - 1]) return nums[mid]; 

            if (nums[mid] > nums[right]) left = mid + 1; 
            else right = mid - 1; 
        }
        return -1;
    }
