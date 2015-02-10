package other;

import java.io.FileWriter;
import java.io.IOException;

public class SaveFile {
	public static void saveStatistics(String text) {
		FileWriter outputStream = null;
		try {
			outputStream = new FileWriter("Save.txt");
			outputStream.write(text);
		} catch (IOException e) {
			e.printStackTrace();
		}
		finally{
			if (outputStream != null){
				try {
					outputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
