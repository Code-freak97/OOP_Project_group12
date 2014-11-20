package spreadoffiresimulation_ver2;
import java.util.ArrayList;

/**
 *
 * @author OOP Group#12
 */
public class Fire extends Thread{
    private static final int BURNING = 2;
    private static double[][] probLand;
    private static double prob;
    private final ArrayList<Integer> indexI; // keep the index at i of 2
    private final ArrayList<Integer> indexJ; // keep the index at j of 2
    private boolean stop = false;
    private int count = 0;
    
    /**
     * constructor
     * 
     * @param forest 
     */
    public Fire(Forest forest){
        probLand = forest.getProbLand();
        indexI = new ArrayList<>();
        indexJ = new ArrayList<>();
        keepTwo();
    }
    
    public int getCount(){
        return count;
    }
    
    public double getProb(){
        return prob;
    }
    
    public boolean isStop(){
        return stop;
    }
    
    public void resetFire(){
        stop = false;
        count = 0;
    }

    
    public void probCatch(double probability){
        prob = probability;
        burn(indexI,indexJ);
        try{
            Thread.sleep(200);
        }catch(Exception e){
           //
        }
        print();
        count++;
        Forest.countTree();
        if(indexI.isEmpty() && indexJ.isEmpty()){
            stop = true;
        }else{
            probCatch(prob);
        }
    }
    
    public void stepBurn(double probability){
        prob = probability;
        burn(indexI,indexJ);
        print();
        count++;
        Forest.countTree();
        if(indexI.isEmpty() && indexJ.isEmpty()){
            stop = true;
        }
    }
    
    private void burn(ArrayList<Integer> i,ArrayList<Integer> j){
        for(int x = 0; x < i.size() ; x++){
                //NORTH
                if(probLand[i.get(x)-1][j.get(x)] <= prob && 
                        Forest.forest[i.get(x)-1][j.get(x)] != 0){
                    Forest.forest[i.get(x)-1][j.get(x)] = BURNING; 
                }
                //SOUTH
                if(probLand[i.get(x)+1][j.get(x)] <= prob&& 
                        Forest.forest[i.get(x)+1][j.get(x)] != 0){
                    Forest.forest[i.get(x)+1][j.get(x)] = BURNING; 
                }
                //WEST
                if(probLand[i.get(x)][j.get(x)-1] <= prob&& 
                        Forest.forest[i.get(x)][j.get(x)-1] != 0){
                    Forest.forest[i.get(x)][j.get(x)-1] = BURNING; 
                }
                //EAST
                if(probLand[i.get(x)][j.get(x)+1] <= prob&& 
                        Forest.forest[i.get(x)][j.get(x)+1] != 0){
                    Forest.forest[i.get(x)][j.get(x)+1] = BURNING; 
                }
            Forest.forest[i.get(x)][j.get(x)] = 0;
        }
        keepTwo();
    }
    
    /**
     * keep the burning point
     */
    private void keepTwo(){
        indexI.clear();
        indexJ.clear();
        for(int i=1;i<Forest.forest.length-1;i++){ //KEEP BURN POINT
            for(int j=1;j<Forest.forest.length-1;j++){
                if(Forest.forest[i][j]==2){
                indexI.add(i);
                indexJ.add(j);
                }                
            }
        }
         
    }
    
    public void print(){
        for (int[] forest1 : Forest.forest) {
            for (int j = 0; j < Forest.forest.length; j++) {
                System.out.print(forest1[j] + " ");
            }
            System.out.println(); // new line
        }
        System.out.println("-----------------------------");
    }
    
}

