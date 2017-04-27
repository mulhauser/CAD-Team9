package bataillenavale.view;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import java.awt.*;
import java.util.Observable;
import java.util.Observer;


/**
 * Created by wolkowicz on 20/04/2017.
 */
public class ViewGrilleMe extends JPanel implements Observer{

    public ViewGrilleMe(){

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

    @Override
    public void update(Observable o, Object arg) {

    }
}
