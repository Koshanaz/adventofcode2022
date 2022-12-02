package advent;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileNotFoundException; 
import java.io.IOException;
import java.util.ArrayList;


public class Advent1 {
	// Making an Elf for Object related fun!
	// Really an int[2] would work haha
	// Doesn't need to be public since everything's happening in this class,
	// but who knows!
	public static class Elf {
		int elfCalories = 0;
		int elfID;
		public Elf() {
			// Empty
		}
		public Elf(int elfID) {
			// Initialize with ID
			this.elfID = elfID;
		}
		public Elf(int elfID, int elfCalories) {
			// Initialize with Both
			this.elfID = elfID;
			this.elfCalories = elfCalories;
		}
		public int Add(int elfAdd) {
			return this.elfCalories += elfAdd;
		}
		public void SetCalories(int elfNew) {
			this.elfCalories = elfNew;
		}
		public int GetCalories() {
			return this.elfCalories;
		}
		public void SetID(int elfID) {
			this.elfID = elfID;
		}
		public int GetID() {
			return this.elfID;
		}
	}
	
	// Gonna output an ArrayList of Integers for now
	// Now it's an int array
	// Now it's just an int as it only asks for the total amount carried, but I will print his ID (he deserves it)
	public static int elfOutPut(String fileName) throws FileNotFoundException, IOException {
		// Declare the Stuff going in the BufferedReader!
		FileReader elfFileReader = new FileReader(fileName);
		BufferedReader elfBuffReader = new BufferedReader(elfFileReader);
		// Read that stuff!
		String elfLine = elfBuffReader.readLine();
		// Some declarations
		// Realized I only need one elf
		ArrayList<Elf> elfResult = new ArrayList<Elf>();
		int elfCount = 1;
		// Replaced my int[] with an Elf for Holiday fun!
		Elf elfOnShelf = new Elf();
		Elf elfCurrent = new Elf(elfCount++);
		// While there's still a line available, output it!
		// After testing, we'll parse through for ints and new lines, adding them to an ArrayList!
		while(elfLine != null) {
			// While instead of if block in case of multiple blanks in a row
			while(elfLine.equals("")) {
				// When a new Elf is about to be created, check the elves!
				if(elfCurrent.GetCalories() > elfOnShelf.GetCalories()) {
					// Announce the victor and replace the loser
					System.out.println("Elf " + elfCurrent.GetID() + " replaces Elf " + elfOnShelf.GetID()
					+ " with a difference of " + (elfCurrent.GetCalories() - elfOnShelf.GetCalories()));
					elfOnShelf = elfCurrent;
				}
				// If it's an empty line, make a new elf
				elfCurrent = new Elf(elfCount++);
				// Go to next line
				elfLine = elfBuffReader.readLine();
			}
			// Add value to currentElf
			elfCurrent.Add(Integer.valueOf(elfLine));
			System.out.println("Elf " + elfCurrent.elfID + " gained: " + Integer.valueOf(elfLine) + " (Total " + elfCurrent.GetCalories() + ")");
			elfLine = elfBuffReader.readLine();
		}
		// Print the final victor
		System.out.println("Elf " + elfOnShelf.GetID() + " wins with " + elfOnShelf.GetCalories() + " calories!");
		return elfOnShelf.GetCalories();
	}

	public static void main(String[] args) throws FileNotFoundException, IOException {
		// TODO Auto-generated method stub
		System.out.print(elfOutPut("./advent1test.txt"));
	}

}
