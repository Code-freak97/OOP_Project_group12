/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package spreadoffiresimulation_ver2;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author OOP Gruop#12
 */
public class Simulator extends JPanel{
    
    private int cell = 5;
    
    public Simulator(int size){
        calCell(size);
        setSize(500,500);
        setBackground(Color.WHITE);
    }
    
    public void newSimu(int size){
        calCell(size);
        System.out.println(cell);
        validate();
        repaint();
    }
    
    private void calCell(int size){
        cell = 100/size*5;
    }
    
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        
        int y = 0;
        for (int[] forest1 : Forest.forest) {
            int x = 0; 
            for (int j = 0; j < Forest.forest.length; j++) {
                if (forest1[j] == 0) {
                    g.setColor(Color.yellow);
                }
                if (forest1[j] == 1) {
                    g.setColor(Color.green);
                }
                if (forest1[j] == 2) {
                    g.setColor(Color.red);
                }
                g.fillRect(x*cell, y*cell, cell-1, cell-1);
                x++;
                validate();
                repaint();
            }
            y++;
        }
    }
    
}

