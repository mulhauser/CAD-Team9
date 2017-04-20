package bataillenavale.view;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import java.awt.*;


/**
 * Created by wolkowicz on 20/04/2017.
 */
public class viewGrilleMe extends JPanel {

    public viewGrilleMe(){


        int width = 10;
        int length = 10;
        this.setSize(500, 500);
        this.setLayout(new GridLayout(width,length));
        JButton[][] grid = new JButton[width][length];
        for(int i = 0; i < width; i++){
            for(int j = 0; j < length; j++){
                grid[i][j]=new JButton(" MOI" + i + " - " + j);
                add(grid[i][j]);
            }
        }
        this.setBorder(BorderFactory.createLineBorder(Color.black));
    }
}
