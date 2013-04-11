package mycompany.client;

import javax.swing.*;
import java.awt.*;

public class SnakesAndLaddersGUI extends JPanel implements Runnable{
        private int[] players=new int[5];
        private final Color[] colour={Color.BLUE,Color.GREEN,Color.RED,Color.ORANGE,Color.YELLOW};
        private final double [] shiftx={.3, .3,-.3,-.3,0};
        private final double [] shifty={.3,-.3, .3,-.3,0};
        private Image i=null;
        private int noofplayers=0;


        public SnakesAndLaddersGUI(){
          ImageIcon icon=new ImageIcon("board.gif");
          i=icon.getImage();

        }
        public void setNumberOfPlayers(int _noofplayers){
                noofplayers=_noofplayers;
                syncRequestRepaint();
        }
        public void setPosition(int playerno,int position){
                if(playerno>=0 && playerno<=noofplayers){
                        players[playerno]=position;
                        syncRequestRepaint();

                }else{
                        System.out.println("Error: You are trying to access player number "+playerno+" which doesn't exist\n");
                }

        }
        public void paint(Graphics g){
                update(g);
        }
        public void update(Graphics g){
                //redraw here
          int xs=(int)getWidth();
          int ys=(int)getHeight();
          if(xs<1)xs=350;
          if(ys<1)ys=350;
          if(xs>2000)xs=350;
          if(ys>2000)ys=350;


          g.drawImage(i,0,0,xs,ys,null);
          double xscale=xs/10.0,yscale=ys/10.0;


          for(int i=0;i<noofplayers;i++){
	    int pi=players[i];//Copy locally to avoid thread problems
            if(pi>=1 && pi<=100){
            //find square index (0-9),(0-9)
              int x=(pi-1)%10;
              int y=(pi-1)/10;

              if((y/2)*2!=y)//odd
                x=9-x;

            //scale to co-ordinates
              x=(int)((x+.25)*xscale);
              y=ys-(int)((y+.75)*yscale);
            //render counter
              g.setColor(colour[i]);
              g.fillOval(x+(int)(shiftx[i]*xscale/2),y+(int)(shifty[i]*yscale/2),(int)(xscale/2.2+1),(int)(yscale/2.2+1));
              g.setColor(Color.BLACK);
              g.drawOval(x+(int)(shiftx[i]*xscale/2),y+(int)(shifty[i]*yscale/2),(int)(xscale/2.2+1),(int)(yscale/2.2+1));


            }
          }


        }

      public void run(){
              repaint();
      }
      private void syncRequestRepaint(){
          try{
            EventQueue.invokeAndWait(this);
          }catch(Exception e){}
      }
}
