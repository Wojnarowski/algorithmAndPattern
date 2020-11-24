package zuo.vip.class10;

/**
 * 用数组实现并查集，元素内数字代表集合号
 */
public class UnnionFind2 {

    /**
     * 数组,标识并查集所有元素
     */
    private int[] id;

    /**
     * 并查集元素个数
     */
    private int size;


    public  UnnionFind2(int size){
        this.size=size;
        id =new int[size];
        for(int i=0;i<size;i++){
            id[i]=i;
        }
    }


    /**
     * 查看元素属于哪个集合
     * @param element  查看元素
     * @return  元素所在集合
     */
    public int find(int element){
        return id[element];
    }


    /**
     * 判断两个元素是否属于同一个集合
     * @param firstElement
     * @param secondElement
     * @return
     */
    public boolean isConnected(int firstElement,int secondElement){
        return find(firstElement)==find(secondElement);
    }


    /**
     * 合并两个元素所在和集合，也就是连接两个元素
     * @param firstElement 第一个
     * @param secondElement 第二个
     */
    public void unionElements(int firstElement ,int secondElement){

        //找出第一个元素所在的集合
        int first = find(firstElement);
        //找出第儿个元素所在的集合
        int second = find(secondElement);

        /**
         * 如果两个元素不是同一个集合就合并
         */
        if(first!=second){
            //遍历数组，使原来的firstUnion、secondUnion合并为secondUnion
            for(int i=0;i<size;i++){
                if(id[i]==first){
                    id[i]=second;
                }
            }
        }
    }

    /**
     * 本并查集使用数组实现，为了更直观地看清内部数据，采用打印数组
     */
    private void printArr() {
        for (int id : this.id) {
            System.out.print(id + "\t");
        }
        System.out.println();
    }








}
