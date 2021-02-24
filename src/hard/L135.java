package hard;

import org.junit.Test;

import java.util.ArrayList;

/**
 * Created by chenz on 2020/12/24 10:17
 */
//我太菜了
public class L135 {
    public int candy(int[] ratings) {
        if (ratings == null) {
            return 0;
        }
        if (ratings.length <= 1) {
            return ratings.length;
        }
        int[] nums = new int[ratings.length];
        int sum = 0;
        if (ratings[0] <= ratings[1]) {
            nums[0] = 1;
            sum++;
        }
        if (ratings[ratings.length - 1] <= ratings[ratings.length - 2]) {
            nums[ratings.length - 1] = 1;
            sum++;
        }
        for (int i = 1; i < ratings.length - 1; i++) {
            if (ratings[i] <= ratings[i - 1] && ratings[i] <= ratings[i + 1]) {
                nums[i] = 1;
                sum++;
            }
        }
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                if (arrayList.size() > 0) {
                    int asc = 0;
                    for (int j = 0; j < arrayList.size() - 1; j++) {
                        if (arrayList.get(j) < arrayList.get(j + 1)) {
                            asc++;
                        } else {
                            break;
                        }
                    }
                    int dsc = 0;
                    for (int j = arrayList.size() - 1; j > 0; j--) {
                        if (arrayList.get(j) < arrayList.get(j - 1)) {
                            dsc++;
                        } else {
                            break;
                        }
                    }
                    if (asc + dsc == arrayList.size() - 2) {
                        sum += (asc + 1) * asc / 2 + (dsc + 1) * dsc / 2 + arrayList.size() * 2;
                    } else {
                        sum += (asc + 1) * asc / 2 + (dsc + 1) * dsc / 2 + arrayList.size() * 2 - Math.min(asc, dsc);
                    }
                    arrayList.clear();
                }
            } else {
                arrayList.add(ratings[i]);
            }
        }
        if (arrayList.size() > 0) {
            int asc = 0;
            for (int j = 0; j < arrayList.size() - 1; j++) {
                if (arrayList.get(j) < arrayList.get(j + 1)) {
                    asc++;
                } else {
                    break;
                }
            }
            int dsc = 0;
            for (int j = arrayList.size() - 1; j > 0; j--) {
                if (arrayList.get(j) < arrayList.get(j - 1)) {
                    dsc++;
                } else {
                    break;
                }
            }
            if (asc + dsc == arrayList.size() - 2) {
                sum += (asc + 1) * asc / 2 + (dsc + 1) * dsc / 2 + arrayList.size() * 2;
            } else {
                sum += (asc + 1) * asc / 2 + (dsc + 1) * dsc / 2 + arrayList.size() * 2 - Math.min(asc, dsc);
            }
            arrayList.clear();
        }

        return sum;
    }

    @Test
    public void test() {
        int[] arr = {1, 2, 3, 3, 3, 2, 1};
        System.out.println(candy(arr));
    }

}
