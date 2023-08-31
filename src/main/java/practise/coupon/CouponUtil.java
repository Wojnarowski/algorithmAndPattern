package practise.coupon;

import java.util.List;

public class CouponUtil {
    public static double[] getBestCouponCombination(double total, List<Coupon> coupons) {
        int n = coupons.size();
        double[] dp = new double[(1 << n)];
        double[] best = new double[(1 << n)];
        int[] use = new int[(1 << n)];

        dp[0] = total;
        best[0] = 0;
        use[0] = -1;

        for (int i = 1; i < (1 << n); i++) {
            dp[i] = total;
            best[i] = 0;
            use[i] = -1;
            for (int j = 0; j < n; j++) {
                if ((i & (1 << j)) != 0) {
                    int pre = i ^ (1 << j);
                    if (dp[pre] >= coupons.get(j).condition && dp[pre] - coupons.get(j).discount < dp[i]) {
                        dp[i] = dp[pre] - coupons.get(j).discount;
                        best[i] = best[pre] + coupons.get(j).discount;
                        use[i] = j;
                    }
                }
            }
        }

        int idx = (1 << n) - 1;
        double maxDiscount = best[idx];
        double[] result = new double[n];
        while (idx > 0) {
            result[use[idx]]++;
            idx = idx ^ (1 << use[idx]);
        }

        return new double[]{maxDiscount};
    }
}
