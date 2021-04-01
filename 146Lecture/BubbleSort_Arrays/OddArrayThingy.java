import java.util.Random;
public class OddArrayThingy {

	public static final int R_RANGE = 100;
	public static void main(String[] args) {
		int[][] a= new int[5][5];
		Random r = new Random();
		for(int i = 0; i<a.length;i++)
			for(int j=0;j<a.length;j++)
				a[i][j] = r.nextInt(R_RANGE);
		
		for(int i = 0; i<a.length; i++)
			for(int j = 0; j<a[i].length; j++)
				if(a[i][j] % 2 == 1)
					System.out.println(a[i][j]);
				
				

	}

}
