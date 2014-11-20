package spreadoffiresimulation_ver2;
/**
 *
 * @author CSC319 group#12
 */
public class Forest {
    static int[][] forest; //forest
    private double[][] probLand; //random the prob for each tree
    private static final int TREE = 1;
    private static final int EMPTY = 0;
    private static final int BURNING = 2;
    private double probTree;
    private double probBurning;
    private int[][] treeAge;
    private static int tree;
    
    /**
     * constructor
     * initialize the size of forest and create both forest and the probability one.
     * @param size
     * @param density
     * @param probBurning 
     */
    public Forest(int size, double density, double probBurning){
        probTree = density;
        this.probBurning = probBurning;
        forest = new int[size][size];
        probLand = new double[size][size];
        treeAge = new int[size][size];
        randomProbLand();
        createForest();
        countTree();
    }
    
    /**
     *  default constructor for forest
     * @param size 
     */
    public Forest(int size){
        probTree = 1;
        probBurning = 0;
        forest = new int[size][size];
        probLand = new double[size][size];
        createForest();
        randomProbLand();
        countTree();
    }
   
    
    public int[][] getTreeAge(){
        return treeAge;
    }
        
    public int getSize(){
        return forest.length;
    }
    
    public int getTree(){
        return tree;
    }
    
    
    
    public static void countTree(){
        tree = 0;
        for(int i = 0; i < forest.length ; i++){
            for(int j = 0; j < forest.length; j++){
                if(forest[i][j] == 1){
                    tree++;
                }
            }
        }
    }
    
    public void randomAge(){
        for(int i=1; i < treeAge.length;i++){
            for(int j=1; j < treeAge.length;j++){
                if(i == treeAge.length-1 || j == treeAge.length-1){
                    treeAge[i][j] = EMPTY;
                }else{ 
                    treeAge[i][j] = (int)(Math.random()*4 + 1);
                }
            }
        }
    }
    
    /**
     * fill in the forest with trees
     */
    private void createForest(){
        for(int i=0; i < forest.length;i++){
            for(int j=0; j < forest.length;j++){
                if(i==0 || i == forest.length-1 || j==0 || j == forest.length-1){
                    forest[i][j] = EMPTY;
                }else if(Math.random() < probTree){
                    if(Math.random() < probBurning/10){
                        forest[i][j] = BURNING;
                    }else {
                        forest[i][j] = TREE;
                    }
                } 
                else {
                    forest[i][j] = EMPTY;
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
                    probLand[i][j] = Math.random();
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
     * To get the probability for each tree array
     * @return probLand
     */
    public double[][] getProbLand(){
        return probLand;
    }
}

