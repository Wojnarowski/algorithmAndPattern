package practise.coupon;

import java.util.ArrayList;
import java.util.List;

public class CounponTest {

    public static void main(String[] args) {

        double total = 300;
        List<Coupon> coupons = new ArrayList<>();
        coupons.add(new Coupon("满100减20", 100, 20));
        coupons.add(new Coupon("满200减50", 200, 50));
        coupons.add(new Coupon("满300减100", 300, 100));

        double[] result = CouponUtil.getBestCouponCombination(total, coupons);
        double maxDiscount = result[0];
        System.out.println(maxDiscount);
    }
}
