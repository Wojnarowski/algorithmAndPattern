package practise.geohash;

public class App {

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        System.out.println(new GeoHashHelper().around(44.9999, 116.3967));
        System.out.println(new GeoHashHelper().around(45.0001, 116.3967));
        System.out.println(DistanceHepler.distance(44.9999, 116.3967, 45.0001, 116.3967));
        System.out.println("waste time: " + (System.currentTimeMillis() - start));
        // long start = System.currentTimeMillis();
        // System.out.println(new GeoHashHelper().encode(44.9999, 116.3967));
        // System.out.println(new GeoHashHelper().encode(45.0001, 116.3967));
        // System.out.println("waste time: " + (System.currentTimeMillis() - start));
        /**
         * 数据库存储两个字段 geohash  geohash5 前五位
         * SELECT * FROM `stores` WHERE geohash5 IN (当前位置周围8区的前五位List集合)
         *
         * 反编译经纬度 进行举例计算
         * foreach ($stores as $key => $value) {
         * $geohash_arr=$geohash->decode($value->geohash);
         * $stores[$key]->latitude=$geohash_arr[0];//纬度
         * $stores[$key]->longitude=$geohash_arr[1];//经度
         * $distance=$this->getDistance($request['latitude'],$request['longitude'],$value->latitude,$value->longitude);
         * $stores[$key]->distance=$distance;
         * $sortdistance[$key] = $distance;
         */
    }

}
