public class QuickSort {
    public int[] solution(int[] nums) {
        partition(nums, 0, nums.length - 1);
        return nums;
    }
    public void partition(int[] nums, int start, int end) {
        if (start >= end)
            return;
        int left = start, right = end;
        int pivot  = nums[(left + right) / 2];
        while (left <= right) {
            while (left <= right && nums[left] < pivot) // 注意不能是 <=
                left++;
            while (left <= right && nums[right] > pivot)
                right--;
            if (left <= right) {
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                left++;
                right--;
            }
        }
        partition(nums, start, right);
        partition(nums, left, end);
    }
    

    public static void main(String[] args) {
        int[] nums = {10, 8, 9, 29, 34};
        QuickSort obk = new QuickSort();
        int[] res = obk.solution(nums);
        for (int i: res) {
            System.out.println(i);
        }
    }
}