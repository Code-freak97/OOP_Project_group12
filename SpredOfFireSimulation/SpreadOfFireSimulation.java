package spreadoffiresimulation;
import javax.swing.JFrame;



/**
 *
 * @author OOP Group#12
 */
public class SpreadOfFireSimulation{
    static Fire fire;
    static GUI frame; 
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Forest forest = new Forest(100,0.8,0.1);
        fire = new Fire(forest);
        fire.getNewForest();
        frame = new GUI();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000, 600);
        frame.add(fire.simu);
        //fire.probCatch(1.0);
        frame.setVisible(true);
        try{
             
             Thread.sleep(1000);
        } catch(Exception e){
            
        }
        fire.probCatch(0.5);
        //fire.print();
        
    }
