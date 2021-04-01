/*
 * David Keen
 * 4/2/20
 * CSCE 146H
 * HW 4
 */
//must import these classes for drawing graphics
import java.util.*;
import java.awt.*;
import javax.swing.*;
public class Triangle extends Canvas{
	//static instance variables for starting the triangle and for the height and starting sidelength
	public static final int NUMSIDES = 3;
	public static final int X1 = 0;
	public static final int X2 = 250;
	public static final int X3 = 500;
	public static final int Y1 = 500;
	public static final int Y2 = 67;
	public static final int Y3 = 500;
	public static final int HEIGHT = Y1-Y2;
	public static int SIDE  = 500;
	
	public static void main(String[] args) {
		//set up the frame and triangle
		JFrame frame = new JFrame("TRIAGNLEEEEEEEE");
		frame.setSize(500,500);
		Triangle tr = new Triangle();
		frame.add(tr);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	
	public void paint(Graphics g)
	{	
		//draw initial triangle yellow
		int x[] = {X1,X2,X3};
		int y[] = {Y1,Y2,Y3};
		g.setColor(Color.yellow);
		g.fillPolygon(x,y,NUMSIDES);
		//rest will be black
		g.setColor(Color.black);
		drawTri(x,y,SIDE,HEIGHT,g);
	}
	public void drawTri(int[] xArr, int[] yArr, int sideLength, int height, Graphics g)
	{
		//if we can divide it by 4
		if(sideLength>3)
		{
			//how much we will have to add to get the y coordinate of the lowest point
			int offset = yArr[1];
			//two new arrays for our new upside down triangle
			int[] arrX = new int[NUMSIDES];
			int[] arrY = new int[NUMSIDES];
			//get the x coordinates using the side length and starting position of the triangle
			for(int i = 0; i<NUMSIDES;i++)
			{
				arrX[i] = sideLength/4 + i*(sideLength/4) + xArr[0];
			}
			//get y coordinates using the height and starting position of the triangle
			for(int j = 0; j<NUMSIDES; j++)
			{
				if(j%2==1)
				{
					arrY[j] = height+ offset;
				}
				else
				{
					arrY[j] = height/2 + offset;
				}
			}
			//make our upside down triangle
			g.fillPolygon(arrX, arrY, NUMSIDES);
			//make 6 more arrays, one to recursively call the the top yellow triangle, left and right ones
			int[] leftX = new int[NUMSIDES];
			int[] leftY = new int [NUMSIDES];
			int[] rightX = new int[NUMSIDES];
			int[] rightY = new int [NUMSIDES];
			int[] topX = new int[NUMSIDES];
			int[] topY = new int [NUMSIDES];
			//the coordinates are taken from the same points as triangles we already have, 2 from the black and one from the yellow
			//we just need to change the order a bit so the triangles are drawn correctly
			
			leftX[0] = arrX[1];
			leftX[1] = arrX[2];
			leftX[2] = xArr[2];
			leftY[0] = arrY[1];
			leftY[1] = arrY[2];
			leftY[2] = yArr[2];
			
			rightX[0] = xArr[0];
			rightX[1] = arrX[0];
			rightX[2] = arrX[1];
			rightY[0] = yArr[0];
			rightY[1] = arrY[0];
			rightY[2] = arrY[1];
			
			topX[0] = arrX[0];
			topX[1] = arrX[1];
			topX[2] = arrX[2];
			topY[0] = arrY[0];
			//just need to flip the bottom of the black triangle to become the top of the new small yellow triangle
			topY[1] = arrY[1] - height;
			topY[2] = arrY[2];
			//recursively call using all three new yellow triangles using those points of the 6 arrays
			drawTri(topX,topY,sideLength/2,height/2,g);
			drawTri(rightX,rightY,sideLength/2,height/2,g);
			drawTri(leftX,leftY,sideLength/2,height/2,g);
			
			
			
			
			
		}
		
	}

}
