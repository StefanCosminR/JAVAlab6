package testexp4j;

import javax.swing.*;
import java.awt.*;
import java.util.Scanner;
import net.objecthunter.exp4j.*;

class TestExp4J extends JFrame
{
    TestExp4J()
    {
        super("Grapher");
        setSize(600,600);
        setResizable(true);
    }
   public static void main(String args[])
    {
       TestExp4J m=new TestExp4J();
       m.setVisible(true);
       m.setLocationRelativeTo(null);
    }

   public void paintallies(Graphics G1,double sf)
   {int i;
    Graphics2D g21=(Graphics2D) G1;
    g21.setColor(Color.GREEN);
       for(i=0;i<=600;i=(int) (i+sf))
       {
           g21.drawLine(i,0,i,600);
           g21.drawLine(0,i,600,i);

       }

   }
   public void paintaxes(Graphics G1)
   {
       Graphics2D g21=(Graphics2D) G1;
       g21.setColor(Color.BLACK);
       g21.drawLine(300,0,300,600);//y axis

       g21.drawLine(0,300,600,300); //x axis

   }


   @Override
   public void paint(Graphics G)
   {
       int i;
       double j,k;

       Scanner s=new Scanner(System.in);
       System.out.println("Enter input");
       String input=s.nextLine();
       System.out.println("Enter scale factor");
       double sf=s.nextDouble();
       double sff=300/sf;
       double kf=sff;
       double count=0;






       Graphics g2=(Graphics) G;
       paintallies(G,sf);
       paintaxes(G);

       g2.translate(300,300);
       do
       {
           kf=kf-(1/sf);
           count++;

       }while(kf>=0);
       double counts=2*count;


       Color c=Color.RED;
       g2.setColor(c.darker());

       double yarr[]=new double[(int)counts];
       double xarr[]=new double[(int)counts];



       Expression E=new ExpressionBuilder(input).variables("x").build();


        j=-sff; k=-sff;
       for(i=0;i<counts;i++)
       {

           xarr[i]=j;
           j=j+(1/sf);


           E.setVariable("x",k);
           yarr[i]=E.evaluate();
           k=k+(1/sf);

           xarr[i]=sf*xarr[i];
           yarr[i]=-sf*yarr[i];

       }

       for(i=0;i<counts;i++)
       {
           if(i==counts-1)
           {
               break;
           }
           else
           {
           g2.drawLine((int)xarr[i],(int)yarr[i],(int)xarr[i+1],(int)yarr[i+1]);

           }
       }

    }
}
