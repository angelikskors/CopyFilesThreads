package ua.org.angelikskors;

import java.io.File;

public class Run {

	public static void main(String[] args) {
		System.out.println("The number of files "
				+ copyList("D:\\newFile\\", "D:\\newFile2\\"));

	}

	public static int copyList(String pathDir, String pathDir2) {
		int count = 0;
		File newFile = new File(pathDir);
		File newFile1 = new File(pathDir2);

		String[] lister = newFile.list();

		if (!newFile1.exists()) {
			newFile1.mkdir();
		}
		if (!newFile.exists()) {
			System.err.println("File not found");
		}

		for (int i = 0; i < lister.length; i++) {
			count++;
			String path1 = pathDir + lister[i];
			String path2 = pathDir2 + lister[i] + "\\";

			File file = new File(path1);
			System.out.println(file.getAbsolutePath());
			System.out.println("File exists: " + file.exists());

			if (file.isFile()) {
				new Thread(new MyThread(path1 + "\\", path2 + "\\")).start();
			}
			if (file.isDirectory()) {
				System.out.println("Directory! ");
				copyList(path1 + "\\", path2 + "\\");
			}

		}

		return count;

	}
}
