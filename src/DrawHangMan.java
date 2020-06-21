import javax.swing.*;
import java.awt.*;
/**
 * This class DraHangMan Drawes hangman body part
 * 
 * all functions level 1-7 are(according to this order):
 * level1=base part (default)
 *  level2=head part (default)
 * level3=body part (default)
 * level4=hand part (default)
 * level5=2'd hand part (default)
 * level6=leg part (default)
 * level7=2'd leg part (default)
 */
public class DrawHangMan extends JPanel{
        
  public int guesses;

        public DrawHangMan(){
        	
        }
        public void paintComponent(Graphics g){
        	 
        	super.paintComponent(g);
            g.setColor(Color.blue);
             level1(g);
        	for(int i=1;i<guesses+1;i++)
            {
        		switch(i) {
              
                case 1:  level2(g); break;
                case 2:  level3(g);break;
                case 3:  level4(g);break;
                case 4:  level5(g);break;
                case 5:  level6(g);break;
                case 6:  level7(g);break;
                }       
            }
        }
        private void level1(Graphics g) {  //default start
        	repaint();
        	g.drawLine(10, 10, 150, 10);
            g.drawLine(85, 50, 85, 10);
            g.drawLine(0, 300, 60, 300);
            g.drawLine(20, 10, 20, 300);

        }   
        private void level2(Graphics g) { //head+default start
        	repaint();
        	g.drawLine(10, 10, 150, 10);
            g.drawLine(85, 50, 85, 10);
            g.drawLine(0, 300, 60, 300);
            g.drawLine(20, 10, 20, 300);
        	g.drawOval(50, 50, 70,70); 
        	g.setColor(Color.blue);
        }
        private void  level3(Graphics g) { //bodyline
            repaint();
        	g.drawLine(10, 10, 150, 10);
            g.drawLine(85, 50, 85, 10);
            g.drawLine(0, 300, 60, 300);
            g.drawLine(20, 10, 20, 300);
        	g.drawOval(50, 50, 70,70);  //head
        	g.setColor(Color.blue);
        	g.drawLine(85, 120, 85, 250);  
        }
        private void level4(Graphics g) {
        	repaint();
        	g.drawLine(85,120,40,160);  //hand
        	g.drawLine(10, 10, 150, 10);
            g.drawLine(85, 50, 85, 10);
            g.drawLine(0, 300, 60, 300);
            g.drawLine(20, 10, 20, 300);
        	g.drawOval(50, 50, 70,70);  //head
        	g.setColor(Color.blue);
        	g.drawLine(85, 120, 85, 250);  //bodyline
        }
        private void level5(Graphics g) {
        	repaint();
        	g.drawLine(85,120,40,160);  //hand
        	g.drawLine(10, 10, 150, 10);
            g.drawLine(85, 50, 85, 10);
            g.drawLine(0, 300, 60, 300);
            g.drawLine(20, 10, 20, 300);
        	g.drawOval(50, 50, 70,70);  //head
        	g.setColor(Color.blue);
        	g.drawLine(85, 120, 85, 250);  //bodyline
        	g.drawLine(85, 120, 125, 160); //hand
        }
        private void level6(Graphics g) {
        	 g.drawLine(85,250,40,290);
         	repaint();
         	g.drawLine(85,120,40,160);  //hand
         	g.drawLine(10, 10, 150, 10);
             g.drawLine(85, 50, 85, 10);
             g.drawLine(0, 300, 60, 300);
             g.drawLine(20, 10, 20, 300);
         	g.drawOval(50, 50, 70,70);  //head
         	g.setColor(Color.blue);
         	g.drawLine(85, 120, 85, 250);  //bodyline
         	g.drawLine(85, 120, 125, 160); //hand
        }
        private void level7(Graphics g) {
        	  g.drawLine(85, 250, 125, 290);
        	  g.drawLine(85,250,40,290);
        	  g.drawLine(85, 120, 125, 160);
        	  g.drawLine(85,120,40,160);
          	g.drawLine(10, 10, 150, 10);
            g.drawLine(85, 50, 85, 10);
            g.drawLine(0, 300, 60, 300);
            g.drawLine(20, 10, 20, 300);
        	g.setColor(Color.blue);
        	g.drawLine(85, 120, 85, 250);  //body
        	g.drawOval(50, 50, 70,70); 
        }
}