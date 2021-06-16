package Sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: zhouhanming
 * @Date:2021/6/8 9:23 上午
 * https://leetcode-cn.com/problems/merge-intervals
 *
 * 五毒神掌：
 * 第二遍，2021/6/14
 * 第三遍，2021/6/15
 *
 */
public class MergeIntervals {
    public int[][] merge(int[][] intervals) {
        List<int[]> inter = Arrays.asList(intervals);
        List<int[]> newInter = new ArrayList<>(inter);
        newInter.sort((o1, o2) -> o1[0] - o2[0]);

        List<int[]> res = new ArrayList<>();
        for (int i = 0; i < newInter.size();) {
            int t = newInter.get(i)[1];
            int j = i + 1;
            while (j < newInter.size() && newInter.get(j)[0] <= t) {
                t = Math.max(t, newInter.get(j)[1]);
                j++;
            }
            res.add(new int[]{newInter.get(i)[0], t});
            i = j;
        }

        int[][] ans = new int[res.size()][2];
        for (int i = 0; i < res.size(); i++) {
            ans[i][0] = res.get(i)[0];
            ans[i][1] = res.get(i)[1];
        }

        return ans;
    }
}