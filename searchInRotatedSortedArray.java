public int search(int[] nums, int target) {
        if (nums.length < 7) {
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == target) {
                    return i;
                }
            }
            return -1;
        }
        if (nums[0] == target) { return 0;}
        if (nums[nums.length - 1] == target) { return nums.length - 1;}
        if (nums[0] <= nums[nums.length - 1]) { return bs(nums, 0, nums.length - 1, target); }
        int left = 0, right = nums.length - 1, pivot = -1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (mid > 0 && nums[mid] < nums[mid - 1]) {
                pivot = mid;
            }
            if (nums[mid] > nums[right]) left = mid + 1; 
            else right = mid - 1; 
        }
        System.out.println(pivot);
        if (target == nums[pivot]) { return pivot; }
        //pivot found;
        if (target > nums[pivot] && target < nums[nums.length - 1]) { //right side of pivot
            left = pivot;
            right = nums.length - 1;
            return bs(nums, left, right, target);
        } else {
            left = 0;
            right = pivot - 1;
            return bs(nums, left, right, target);
        }
    }

    public int bs (int[] nums, int left, int right, int target) {
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (target > nums[mid]) {
                return bs(nums, mid + 1, right, target);
            } else {
                return bs(nums, left, mid - 1, target);
            }
        }
        return -1;
    }
