package zuo.vip.class13;

/**
 * 范围尝试模型
 * 给定一个整形数组 arr ，代表数值不同的纸牌排成一条线
 * 玩家A和玩家B依次拿走一张牌
 * 规定玩家A先拿走，玩家B后拿走
 * 但是每次玩家只能拿走最左或者最右的牌
 * 玩家A和玩家B都绝对聪明。
 * 请返回最后获胜者的分数。
 */
public class CardsInline {

    public static int f(int [] arr,int L,int R){
        //只剩一张牌
        if(L == R){
            return arr[L];
        }
        return Math.max(
               arr[L]+s(arr,L+1,R),
                arr[R]+s(arr,L,R-1)
        );


    }

    // L....R
    // F  S  L+1..R
    // L..R-1
    private static int s(int[] arr, int L, int R) {
        if(L == R){
            return 0;
        }
        return Math.min(
                f(arr,L+1,R)
                ,
                f(arr, L, R - 1)  // arr[j]
        );
    }

    public static void main(String[] args) {
        int arr[] ={1,9,2,3};
        System.out.println(f(arr,0,3));
        System.out.println(s(arr,0,3));
    }
}
