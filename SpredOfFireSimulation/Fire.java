package spreadoffiresimulation;
import java.util.ArrayList;

/**
 *
 * @author OOP Group#12
 */
public class Fire extends Thread{
    private static final int BURNING = 2;
    //private Forest forest;
    private static int[][] forest;
    private static double[][] probLand;
    private static double prob;
    private static int beginI;
    private static int beginJ;
    private ArrayList<Integer> indexI = new ArrayList<>();
    private ArrayList<Integer> indexJ = new ArrayList<>();
    Simulator simu;
    
    public Fire(Forest forest){
        this.forest = forest.getForest();
        probLand = forest.getProbLand();
        //randomFire();
        //this.forest[beginI][beginJ] = BURNING;
        for(int i = 0; i < this.forest.length;i++){
            for(int j = 0; j <this.forest.length;j++){
                if(this.forest[i][j] == BURNING){
                    indexI.add(i);
                    indexJ.add(j);
                }
            }
        }
//        indexI.add(beginI);
//        indexJ.add(beginJ);
        simu = new Simulator(this);
    }
    
    /**
     * random the first point for fire
     */
    public static void randomFire(){
        do{
            beginI = (int)(Math.random()*forest.length-1);
            beginJ = (int)(Math.random()*forest.length-1);
        } while(beginI == 0 || 
                beginJ == 0 || 
                beginI == forest.length-1 || 
                beginJ == forest.length-1);
        
    }
    
    public void probCatch(double probability){
        prob = probability;
        burn(indexI,indexJ);
        try{
            Thread.sleep(100);
        }catch(Exception e){
           //
        }
        print();
        simu.update();
        SpreadOfFireSimulation.frame.setSize(1001,600); // fix-bug
        SpreadOfFireSimulation.frame.add(simu);
        if(indexI.isEmpty() && indexJ.isEmpty()){
            // stop doing
            simu.update();
        }else{
            SpreadOfFireSimulation.frame.setSize(1001,600); // fix-bug
            probCatch(probability);
        }
    }
    
    public void burn(ArrayList<Integer> i,ArrayList<Integer> j){
        for(int x = 0; x < i.size() ; x++){
                if(probLand[i.get(x)-1][j.get(x)] <= prob && 
                        forest[i.get(x)-1][j.get(x)] != 0){
                    forest[i.get(x)-1][j.get(x)] = BURNING; //NORTH
                }
                if(probLand[i.get(x)+1][j.get(x)] <= prob&& 
                        forest[i.get(x)+1][j.get(x)] != 0){
                    forest[i.get(x)+1][j.get(x)] = BURNING; //SOUTH
                }
                if(probLand[i.get(x)][j.get(x)-1] <= prob&& 
                        forest[i.get(x)][j.get(x)-1] != 0){
                    forest[i.get(x)][j.get(x)-1] = BURNING; //WEST
                }
                if(probLand[i.get(x)][j.get(x)+1] <= prob&& 
                        forest[i.get(x)][j.get(x)+1] != 0){
                    forest[i.get(x)][j.get(x)+1] = BURNING; //EAST
                }
            forest[i.get(x)][j.get(x)] = 0;
        }
        keepTwo();
    }
    
    public void keepTwo(){
        indexI.clear();
        indexJ.clear();
        for(int i=1;i<forest.length-1;i++){ //KEEP BURN POINT
            for(int j=1;j<forest.length-1;j++){
                if(forest[i][j]==2){
                indexI.add(i);
                indexJ.add(j);
                }                
            }
        }
         
    }
    
    
    public int[][] getNewForest(){
        return forest;
    }
    
    public Simulator getSimulator(){
        return simu;
    }
    
    public double getProb(){
        return prob;
    }
    
    public void print(){
        for (int[] forest1 : forest) {
            for (int j = 0; j < forest.length; j++) {
                System.out.print(forest1[j] + " ");
            }
            System.out.println(); // new line
        }
        System.out.println("-----------------------------");
    }
    
    /*public void update(){
        for(int i=0 ; i<forest.length; i++){
            for(int j=0; j<forest.length; j++){
                //
            }
        }
    }*/
    
    
}

