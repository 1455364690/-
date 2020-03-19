package 美团;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author sunjh
 * @date 2020/3/19 19:31
 */
public class 最大任务得分 {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        int n = reader.nextInt();
        int k = reader.nextInt();
        int m = reader.nextInt();
        int p = reader.nextInt();
        int q = reader.nextInt();
        int[] taskTime = new int[k];
        for (int i = 0; i < k; i++) {
            taskTime[i] = reader.nextInt();
        }
        int timeGetByGreed = getByGreed(n, k, m, p, q, taskTime);
        int timeGetByLine = getByLine(n, k, m, p, q, taskTime);
        System.out.println(Math.max(timeGetByGreed, timeGetByLine));
        reader.close();
    }

    public static int getByGreed(int n, int k, int m, int p, int q, int[] taskTime) {
        int[] useTimes = new int[k];
        int res = 0;
        int leftTime = m;
        Arrays.sort(taskTime);
        int i = 0;
        while (leftTime > 0 && i < k) {
            if (leftTime < taskTime[i]) {
                break;
            } else if (leftTime >= n * taskTime[i]) {
                leftTime -= n * taskTime[i];
                res += n * p;
                useTimes[i] = n;
            } else {
                int times = leftTime / taskTime[i];
                leftTime -= times * taskTime[i];
                res += times * p;
                useTimes[i] = times;
            }
            i++;
        }
        int minTimes = useTimes[0];
        for (int j = 1; j < useTimes.length; j++) {
            if (useTimes[j] == 0) {
                minTimes = 0;
                break;
            } else {
                minTimes = Math.min(minTimes, useTimes[j]);
            }
        }
        res += q * minTimes;
        return res;
    }

    public static int getByLine(int n, int k, int m, int p, int q, int[] taskTime) {
        int totalTime = 0;
        int max = 0;
        Arrays.sort(taskTime);
        for (int i = 0; i < k; i++) {
            totalTime += taskTime[i];
        }
        int lines = m / totalTime;
        for (int time = 0; time <= lines; time++) {
            int res = 0;
            int leftTime = m;
            int[] useTimes = new int[k];
            res += time * (k * p + q);
            leftTime -= time * totalTime;
            int i = 0;
            int otherMax = n - time;
            while (leftTime > 0 && i < k) {
                if (leftTime < taskTime[i]) {
                    break;
                } else if (leftTime >=  otherMax* taskTime[i]) {
                    leftTime -= otherMax * taskTime[i];
                    res += otherMax * p;
                    useTimes[i] = otherMax;
                } else {
                    int times = leftTime / taskTime[i];
                    leftTime -= times * taskTime[i];
                    res += times * p;
                    useTimes[i] = times;
                }
                i++;
            }
            int minTimes = useTimes[0];
            for (int j = 1; j < useTimes.length; j++) {
                if (useTimes[j] == 0) {
                    minTimes = 0;
                    break;
                } else {
                    minTimes = Math.min(minTimes, useTimes[j]);
                }
            }
            res += q * minTimes;
            if (res > max) {
                max = res;
            }
        }
        return max;
    }
}
