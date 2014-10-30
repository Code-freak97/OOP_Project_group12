package spreadoffiresimulation;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author OOP Gruop#12
 */
public class Simulator extends JPanel{
    
    private Fire fire;
    private int cell = 5;
    private int[][] forest;
    
    public Simulator(Fire fire){
        this.fire = fire;
        forest = fire.getNewForest();
        //cell = fire.getNewForest().length;
    }
    
    public void update(){
        //this.removeAll();
        //Simulator newsimu = new Simulator(fire);
        validate();
        repaint();
        
    }
    
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        
        
        int y = 1;
        for (int[] forest1 : forest) {
            int x = 1;
            for (int j = 0; j < forest.length; j++) {
                if (forest1[j] == 0) {
                    g.setColor(Color.yellow);
                }
                if (forest1[j] == 1) {
                    g.setColor(Color.green);
                }
                if (forest1[j] == 2) {
                    g.setColor(Color.red);
                }
                g.drawRect(x*cell, y*cell, cell, cell);
                g.fillRect(x*cell, y*cell, cell-1, cell-1);
                x++;
            }
            y++;
        }
        
        //validate();
        //repaint();
    }
}
