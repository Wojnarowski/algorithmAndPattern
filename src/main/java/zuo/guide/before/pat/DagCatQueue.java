package zuo.guide.before.pat;

import java.util.LinkedList;
import java.util.Queue;

public class DagCatQueue {

    private Queue<PetEnterQueue> dagQueue;
    private Queue<PetEnterQueue> catQueue;
    private long count;

    public DagCatQueue() {
        this.dagQueue = new LinkedList<PetEnterQueue>();
        this.catQueue = new LinkedList<PetEnterQueue>();
        this.count = 0;
    }

    public void add(Pet pet){
        if(pet.getPetType().equals("dog")){
            this.dagQueue.add(new PetEnterQueue(pet,this.count++));
        }else if(pet.getPetType().equals("cat")){
            this.catQueue.add(new PetEnterQueue(pet,this.count++));
        }else{
            throw new RuntimeException("类型错误");
        }
    }




}
