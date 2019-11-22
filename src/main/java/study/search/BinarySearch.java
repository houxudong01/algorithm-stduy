package study.search;

/**
 * 二分法查找
 *
 * @author:hxd
 * @date:2019/11/5
 */
public class BinarySearch {

    /**
     * 在有序数组中查找等于 key 的元素下标
     *
     * @param nums
     * @param key
     * @return
     */
    public static int search(int[] nums, int key) {
        int i = 0;
        int j = nums.length - 1;

        while (i <= j) {
            int m = i + ((j - i) >> 1);
            if (key == nums[m]) {
                return m;
            } else if (key > nums[m]) {
                i = m + 1;
            } else {
                j = m - 1;
            }
        }
        return -1;
    }

    /**
     * 查找等于给定值的第一个元素
     *
     * @param nums
     * @param key
     * @return
     */
    public static int searchFirstEqualOne(int[] nums, int key) {
        int i = 0;
        int j = nums.length - 1;
        while (i <= j) {
            int m = i + ((j - i) >> 1);
            if (nums[m] == key) {
                if (m - 1 >= 0 && nums[m - 1] == key) {
                    j = m - 1;
                } else {
                    return m;
                }
            } else if (nums[m] > key) {
                j = m - 1;
            } else {
                i = m + 1;
            }
        }
        return -1;
    }

    /**
     * 查找等于给定值的最后一个元素
     *
     * @param nums
     * @param key
     * @return
     */
    public static int searchLastEqualOne(int[] nums, int key) {
        int i = 0;
        int j = nums.length - 1;
        while (i <= j) {
            int m = i + ((j - i) >> 1);
            if (nums[m] == key) {
                if ((m + 1 <= nums.length - 1) && nums[m + 1] == key) {
                    i = m + 1;
                } else {
                    return m;
                }
            } else if (nums[m] > key) {
                j = m - 1;
            } else {
                i = m + 1;
            }
        }
        return -1;
    }

    /**
     * 查找大于等于给定值的第一个元素
     *
     * @param nums
     * @param key
     * @return
     */
    public static int searchEqualOrGreaterFirstOne(int[] nums, int key) {
        int i = 0;
        int j = nums.length - 1;
        while (i <= j) {
            int m = i + ((j - i) >> 1);
            if (nums[m] < key) {
                i = m + 1;
            } else {
                if (m - 1 >= 0 && nums[m - 1] >= key) {
                    j = m - 1;
                } else {
                    return m;
                }
            }
        }
        return -1;
    }

    /**
     * 查找小于等于给定值的最后一个元素
     *
     * @param nums
     * @param key
     * @return
     */
    public static int searchEqualOrLesserLastOne(int[] nums, int key) {
        int i = 0;
        int j = nums.length - 1;
        while (i <= j) {
            int m = i + ((j - i) >> 1);
            if (nums[m] > key) {
                j = m - 1;
            } else {
                if ((m + 1 <= nums.length - 1) && nums[m + 1] <= key) {
                    i = m + 1;
                } else {
                    return m;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        // 不包含重复数据
        int[] nums = new int[]{1, 3, 5, 7, 9, 11, 13, 15};
        System.out.println(search(nums, 11));

        // 包含重复数据
        int[] nums2 = new int[]{1, 3, 5, 5, 6, 7, 8, 8, 9, 9};
        System.out.println("等于给定值的第一个元素下标：" + searchFirstEqualOne(nums2, 5));
        System.out.println("等于给定值的最后一个元素下标：" + searchLastEqualOne(nums2, 5));
        System.out.println("大于等于给定值的第一个元素下标：" + searchEqualOrGreaterFirstOne(nums2, 9));
        System.out.println("小于等于给定值的最后一个元素下标：" + searchEqualOrLesserLastOne(nums2, 5));
    }
}
