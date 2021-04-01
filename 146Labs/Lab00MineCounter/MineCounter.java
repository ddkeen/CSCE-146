/*
 * David Keen
 * CSCE146 H01
 * 1/17/20
 */
public class MineCounter {

	public static void main(String[] args) {
		System.out.println("Welcome to the Mine Counter!");
		System.out.println();
		System.out.println("Creating a new mine field and resetting its values...");
		MineArray mine = new MineArray();
		System.out.println();
		mine.reset();
		System.out.println("Empty Board:");;
		mine.print();
		mine.placeMines();
		System.out.println();
		System.out.println("Placing Mines:");
		mine.print();
		System.out.println();
		mine.mineCount();
		System.out.println("Preforming Mine Count:");
		mine.print();
	}

}
