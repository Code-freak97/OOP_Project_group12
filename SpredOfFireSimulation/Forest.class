package spreadoffiresimulation;
/**
 *
 * @author CSC319 group#12
 */
public class Forest {
    private int[][] land; //forest
    private double[][] probLand; //random the prob for each tree
    private static final int TREE = 1;
    private static final int EMPTY = 0;
    
    /**
     * constructor
     * initialize the size of forest and create both forest and the probability one.
     * @param size 
     */
    public Forest(int size){
        land = new int[size][size];
        probLand = new double[size][size];
        createForest();
        randomProbLand();
        
        //initComponents();
    }
    
    /**
     * fill in the forest with trees
     */
    private void createForest(){
        for(int i=0; i < land.length;i++){
            for(int j=0; j < land.length;j++){
                if(i==0 || i == land.length-1 || j==0 || j == land.length-1){
                    land[i][j] = EMPTY;
                }else{ 
                    land[i][j] = TREE;
                }
            }
        }
    }
    
    /**
     * keep the random probability for each tree 
     */
    private void randomProbLand(){
        for(int i=0; i < probLand.length;i++){
            for(int j=0; j < probLand.length;j++){
                if(i==0 || i == probLand.length-1 || j==0 || j == probLand.length-1){
                    probLand[i][j] = EMPTY;
                }else{ 
                    probLand[i][j] = (int)(Math.random()*100)/100.0;
                }
            }
        }
    }
    
    
    public void print(int[][] land){
        for(int i = 0; i < land.length; i++){
            for(int j = 0; j < land.length; j++){
                System.out.print(land[i][j] + " ");
            }
             System.out.println(); // new line
        }
    }
    
    public void print(double[][] land){
        for(int i = 0; i < land.length; i++){
            for(int j = 0; j < land.length; j++){
                System.out.print(land[i][j] + " ");
            }
             System.out.println(); // new line
        }
    }
    
    /**
     * To get the forest array
     * @return land
     */
    public int[][] getForest(){
        return land;
    }
    
    /**
     * To get the probability for each tree array
     * @return probLand
     */
    public double[][] getProbLand(){
        return probLand;
    }
}
