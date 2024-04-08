package n1exercise1;

import java.io.File;
import java.util.Arrays;

public class DirectoryLister {

	public static void main(String[] args) {
		
		if (args.length != 1) {
			System.out.println("Use: java com.example.DirectoryLister <diretório>");
			return;
		}

		String directoryPath = args[0];

		File directory = new File(directoryPath);

		if (!directory.exists() || !directory.isDirectory()) {
			System.out.println("The specified directory does not exist.");
			return;
		}

		String[] fileList = directory.list();

		Arrays.sort(fileList);

		System.out.println("Directory contents '" + directoryPath + "':");
		for (String file : fileList) {
			System.out.println(file);
		}
	}

}
