
package test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class TestTaoCpp {

	FileInputStream				fis;
	FileOutputStream			fos;

	byte[]						arr;
	private File				fileDest;
	private InputStreamReader	isr;
	private BufferedReader		bfr;
	private BufferedWriter		bfw;
	private OutputStreamWriter	osw;

	public boolean copyFile(String sourceFilePath, String destFilePath) {

		try {
			fis = new FileInputStream(sourceFilePath);
			fileDest = new File(destFilePath);
			if(!fileDest.exists()) {
				fileDest.createNewFile();
			}
			fos = new FileOutputStream(fileDest);

			arr = new byte[1024];
			while(fis.read(arr) != -1) {
				fos.write(arr);
				fos.flush();
			}

			fis.close();
			fos.close();
			return true;
		} catch(Exception e) {
			e.printStackTrace(System.out);
		}
		return false;
	}

	public boolean copyContent(String sourceFilePath, String destFilePath) {

		try {
			fis = new FileInputStream(sourceFilePath);
			isr = new InputStreamReader(fis);
			bfr = new BufferedReader(isr);
			fileDest = new File(destFilePath);
			if(!fileDest.exists()) {
				fileDest.createNewFile();
			}
			fos = new FileOutputStream(fileDest);
			osw = new OutputStreamWriter(fos, "UTF-8");
			bfw = new BufferedWriter(osw);

			String line = bfr.readLine();

			while(line != null) {
				bfw.write(line);
				bfw.newLine();
				line = bfr.readLine();
			}

			bfr.close();
			bfw.close();

			osw.close();
			isr.close();

			fis.close();
			fos.close();
			return true;
		} catch(Exception e) {
			e.printStackTrace(System.out);
		}
		return false;
	}

	public static void main(String[] args) {

		TestTaoCpp cpp = new TestTaoCpp();
		String sourceFilePath, destFilePath;
		for(int j = 51; j <= 600; j += 100)
			for(int i = 0; i < 50; i++) {
				sourceFilePath = "D:\\ListBaiTapCoBan_C++_+_DeBai\\_.cpp";
				destFilePath = "D:\\ListBaiTapCoBan_C++_+_DeBai\\" + (i + j) + "_.cpp";
				cpp.copyFile(sourceFilePath, destFilePath);
			}

		System.out.println("done!.");
	}

}
