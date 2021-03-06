import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

class ArrayListSynch {
	private int n;
	private int elements[];
	private int cursor;		
	private int errors = 0;

	public ArrayListSynch(int max) {
		n = max;
		elements = new int[n];
		for (int i = 0; i < n; i++) {
			elements[i] = 1000000000;
		}
	}
	
	private void add(int id, int e) {
		elements[id] = e;
	}
	
	private void check() {
		int a = 10;
	}
	
	public void add(int e) {
		check();
		
		try {
			int i = cursor;
			add(i, e);
            cursor = i + 1;
        } catch (IndexOutOfBoundsException ex) {
            throw ex;
        }		
	}

	public void sort() {
		Arrays.sort(elements);	
	}
	
	public void print() {
		for (int i = 0; i < cursor; i++) {
			System.out.println(elements[i]);
		}
	}

	public void printAndCheck() throws IOException {
		FileWriter fw = new FileWriter(this.getClass().getName() + ".txt");
 
		String line = "";
		for (int i = 0; i < cursor - 1; i++) {
			if (elements[i + 1] - elements[i] != 1) {
				errors++;
				line = "==========================================> " + i + ": " + elements[i];
			} else {
				line = i + ": " + elements[i];
			}
			fw.write(line + "\n");
		}
		fw.close();
		System.out.println("Number of errors: " + errors);
	}
}
