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
		int elfCount = 1;
		// Replaced my int[] with an Elf for Holiday fun!
		Elf elfOnShelf = new Elf();
		Elf elfCurrent = new Elf(elfCount++);
		// While there's still a line available, output it!
		// After testing, we'll parse through for ints and new lines instead of just printing!
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
	
	// Advent 1 part 2! Same as the first, save for the while block for checking so removed comments
	public static int elfTop3OutPut(String fileName) throws FileNotFoundException, IOException {
		FileReader elfFileReader = new FileReader(fileName);
		BufferedReader elfBuffReader = new BufferedReader(elfFileReader);
		String elfLine = elfBuffReader.readLine();
		// Ended up needing the array back for part two let's goooo
		Elf[] elfResult = {new Elf(), new Elf(), new Elf()};
		int elfCount = 1;
		Elf elfCurrent = new Elf(elfCount++);
		// KeepGoing to make things easier
		boolean keepGoing = true;
		while(keepGoing) {
			// While instead of if block in case of multiple blanks in a row
			// Added null check first
			while(elfLine == null || elfLine.equals("")) {
				// When a new Elf is about to be created, check the elves!
				// Check first elf
				if(elfCurrent.GetCalories() > elfResult[0].GetCalories()) {
					System.out.println("Elf " + elfCurrent.GetID() + " replaces the first Elf " + elfResult[0].GetID()
					+ " with a difference of " + (elfCurrent.GetCalories() - elfResult[0].GetCalories()));
					// Swap with temp so I can check the loser to the ones below it
					// This caused my first failure
					Elf temp = elfResult[0];
					elfResult[0] = elfCurrent;
					elfCurrent = temp;
				// Check second
				} if (elfCurrent.GetCalories() > elfResult[1].GetCalories()) {
					System.out.println("Elf " + elfCurrent.GetID() + " replaces the first Elf " + elfResult[1].GetID()
					+ " with a difference of " + (elfCurrent.GetCalories() - elfResult[1].GetCalories()));
					Elf temp = elfResult[1];
					elfResult[1] = elfCurrent;
					elfCurrent = temp;
				// Check third
				} if (elfCurrent.GetCalories() > elfResult[2].GetCalories()) {
					System.out.println("Elf " + elfCurrent.GetID() + " replaces the first Elf " + elfResult[2].GetID()
					+ " with a difference of " + (elfCurrent.GetCalories() - elfResult[2].GetCalories()));
					Elf temp = elfResult[2];
					elfResult[2] = elfCurrent;
					elfCurrent = temp;
				}
				if(elfLine == null) {
					keepGoing = false;
					break;
				}
				// If it's an empty line, make a new elf
				elfCurrent = new Elf(elfCount++);
				// Go to next line
				elfLine = elfBuffReader.readLine();
			}
			if(!keepGoing) {
				break;
			}
			// Add value to currentElf
			elfCurrent.Add(Integer.valueOf(elfLine));
			System.out.println("Elf " + elfCurrent.elfID + " gained: " + Integer.valueOf(elfLine) + " (Total " + elfCurrent.GetCalories() + ")");
			elfLine = elfBuffReader.readLine();
		}
		int elfFinalTotal = 0;
		for(Elf elfie : elfResult) {
			elfFinalTotal += elfie.GetCalories();
		}
		// Print the final victors
		System.out.println("First Elf " + elfResult[0].GetID() + " has " + elfResult[0].GetCalories() + " calories!");
		System.out.println("Second Elf " + elfResult[1].GetID() + " has " + elfResult[1].GetCalories() + " calories!");
		System.out.println("Third Elf " + elfResult[2].GetID() + " has " + elfResult[2].GetCalories() + " calories!");
		System.out.println("The top 3 elves together carry " + elfFinalTotal  + " calories!");
		return elfFinalTotal;
	}

	public static void main(String[] args) throws FileNotFoundException, IOException {
		// TODO Auto-generated method stub
		System.out.print(elfTop3OutPut("./advent1input.txt"));
	}

}
