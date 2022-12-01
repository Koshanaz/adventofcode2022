package advent;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileNotFoundException; 
import java.io.IOException;
import java.util.ArrayList;


public class Advent1 {
	
	// Making an Elf for Object related fun!
	public class Elf {
		int elfCalories = 0;
		int elfID;
		public Elf(int elfID) {
			this.elfID = elfID;
		}
		public int Add(int elfAdd) {
			return this.elfCalories += elfAdd;
		}
		public int GetCalories() {
			return this.elfCalories;
		}
		public int GetID() {
			return this.elfID;
		}
	}
	
	// Gonna output an ArrayList of Integers for now
	// Now it's an int array
	public static int[] elfOutPut(String fileName) throws FileNotFoundException, IOException {
		// Declare the Stuff going in the BufferedReader!
		FileReader elfFileReader = new FileReader(fileName);
		BufferedReader elfBuffReader = new BufferedReader(elfFileReader);
		// Read that stuff!
		String elfLine = elfBuffReader.readLine();
		// Some declarations
		ArrayList<Elf> elfResult = new ArrayList<Elf>();
		int lineCount = 1;
		// First is calorie record, second is ID
		int elfRecord[] = {0,0};
		// While there's still a line available, output it!
		// After testing, we'll parse through for ints and new lines, adding them to an ArrayList!
		while(elfLine != null) {
			System.out.println("Line " + lineCount++ + ": " + elfLine);
			elfLine = elfBuffReader.readLine();
		}
		if(elfResult != null) {
			for(Elf elfie : elfResult) {
				// Check each Elf's calories, and if it beats record, record new record and ID
				if(elfie.GetCalories() > elfRecord[0]) {
					elfRecord[0] = elfie.GetCalories();
					elfRecord[1] = elfie.GetID();
				}
			}
		}
		return elfRecord;
	}

	public static void main(String[] args) throws FileNotFoundException, IOException {
		// TODO Auto-generated method stub
		int[] result = elfOutPut("./advent1input.txt");
	}

}
