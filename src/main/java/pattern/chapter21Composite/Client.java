package pattern.chapter21Composite;

/**
 * 组合模式(Composite Pattern)也叫合成模式，有时又叫做部分-整体模式（Part-Whole），
 * 主要是用来描述部分与整体的关系，其定义如下：
 */
public class Client {

    public static void main(String[] args) {
        //创建一个根节点
        Composite root = new Composite();
        root.doSomething();
        //创建一个树枝构件
        Composite branch = new Composite();
        //创建一个叶子节点
        Leaf leaf = new Leaf();
        //建立整体
        root.add(branch);
        branch.add(leaf);
    }

    //通过递归遍历树
    public static void display(Composite root){
        for(Component c:root.getChildren()){
            if(c instanceof Leaf){
                //叶子节点
                c.doSomething();
            }else{
                //树枝节点
                display((Composite)c);
            }
        }
    }

}

