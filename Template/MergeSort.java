public class MergeSort {

    public int[] solution(int[] nums) {
        mergeSort(nums, 0, nums.length - 1, new int[nums.length]);
        return nums;
    }

    public void mergeSort(int[] nums, int start, int end, int[] temp) {
        if (start >= end) // 只有一个值，不用再分了
            return;
        int mid = (start + end) / 2;
        mergeSort(nums, start, mid, temp);
        mergeSort(nums, mid + 1, end, temp);
        merge(nums, start, mid, end, temp);
    }
    public void merge(int[] nums, int start, int mid, int end, int[] temp) {
        int left = start, right = mid + 1;
        int index = start;
        while (left <= mid && right <= end) {
            if (nums[left] <= nums[right]) {
                temp[index] = nums[left];
                left++;
                index++;
            }
            else {
                temp[index] = nums[right];
                right--;
                index++;
            }
            
        }
        while (left <= mid) {
            temp[index] = nums[left];
            index++;
            left++;
        }
        while (right <= end) {
            temp[index] = nums[right];
            index++;
            right++;
        }
        for (int i = start; i <= end; i++) {
            nums[i] = temp[i];
        }
    }
    public static void main(String[] args) {
        int[] nums = {10, 8, 9, 29, 34};
        MergeSort obk = new MergeSort();
        int[] res = obk.solution(nums);
        for (int i: res) {
            System.out.println(i);
        }
    }
}