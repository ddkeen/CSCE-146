import java.util.*;
import java.awt.*;
import javax.swing.*;
public class SierpenskiCarpet extends Canvas {

	public static void main(String[] args) {
		JFrame frame = new JFrame("Sierpenski's Carpet");
		frame.setSize(8000,8000);
		SierpenskiCarpet sp = new SierpenskiCarpet();
		frame.add(sp);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		Polygon  tri = new Polygon();
		tri.addPoint(50, 50);
		tri.addPoint(100, 50);
		tri.addPoint(75,93 );
	}
	
	public void paint(Graphics g)
	{
		drawGasket(0,0,getSize().height,g);
	}
	public void drawGasket(int x, int y, int side, Graphics g)
	{
		int sub = side / 3;
		g.fillRect(x+sub, y+sub, sub, sub);
		if(sub >= 3)
		{
			//Top
			drawGasket(x,y,sub,g);//Left
			drawGasket(x+sub,y,sub,g);//Middle
			drawGasket(x+sub*2,y,sub,g);//Right
			//Middle
			drawGasket(x,y+sub,sub,g);//Left
			drawGasket(x+sub*2,y+sub,sub,g);//Right
			//Bottom
			drawGasket(x,y+sub*2,sub,g);//Left
			drawGasket(x+sub,+y+sub*2,sub,g);//Middle
			drawGasket(x+sub*2,y+sub*2,sub,g);//Right
			
			
		}
	}
	

}
