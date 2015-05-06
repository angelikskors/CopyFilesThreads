package ua.org.angelikskors;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MyThread implements Runnable {
	private String pathFrom;
	private String pathTo;
	private File from;

	public File getFrom() {
		return from;
	}

	public void setFrom(File from) {
		this.from = from;
	}

	public File getTo() {
		return to;
	}

	public void setTo(File to) {
		this.to = to;
	}

	private File to;

	public MyThread(String pathFrom, String pathTo) {

		setPathFrom(pathFrom);
		setPathTo(pathTo);
	}

	public MyThread(File from, File to) {

		setFrom(from);
		setTo(to);
	}

	public String getPathFrom() {
		return pathFrom;
	}

	public void setPathFrom(String pathFrom) {
		this.pathFrom = pathFrom;
	}

	public String getPathTo() {
		return pathTo;
	}

	public void setPathTo(String pathTo) {
		this.pathTo = pathTo;
	}

	@Override
	public void run() {

		try {
			copyFile(getPathFrom(), getPathTo());
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}
	}

	public static void copyFile(String path1, String path2)
			throws FileNotFoundException, IOException {
		try (FileInputStream file = new FileInputStream(path1);
				FileOutputStream fole = new FileOutputStream(path2)) {// copying
																		// file

			byte[] massive = new byte[1024];
			while (file.read(massive) != -1) {

				fole.write(massive);
				fole.flush();

			}

		}
	}
}
