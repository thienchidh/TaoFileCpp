
package test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import javax.swing.JFileChooser;

public class GhiDeBai {

	FileInputStream				fis;
	StringBuilder				sb;
	private BufferedReader		bfr;
	private InputStreamReader	isr;
	private String				line;
	private String[]			s;
	private FileOutputStream	fos;
	private OutputStreamWriter	ows;
	private BufferedWriter		bfw;

	/**
	 * 
	 */
	public GhiDeBai() {

		super();
		sb = new StringBuilder();
	}

	boolean docFile(File f) {

		try {
			fis = new FileInputStream(f);
			isr = new InputStreamReader(fis);
			bfr = new BufferedReader(isr);

			line = bfr.readLine();
			while(line != null) {
				sb.append(line);
				line = bfr.readLine();
			}

			s = sb.toString().split("___");
			bfr.close();
			isr.close();
			fis.close();
			return true;
		} catch(Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return false;
	}

	public void ghiDeBai(String destFilePath, int i) throws IOException {

		fos = new FileOutputStream(destFilePath, true);
		ows = new OutputStreamWriter(fos, "UTF-8");
		bfw = new BufferedWriter(ows);

		bfw.write(s[i]);
		bfw.newLine();

		bfw.write("#include<bits/stdc++.h>");
		bfw.newLine();
		bfw.write("using namespace std;");
		bfw.newLine();
		bfw.newLine();
		bfw.write("int main() {");
		bfw.newLine();
		bfw.newLine();
		bfw.write("    return 0;");
		bfw.newLine();
		bfw.write("}");
		bfw.newLine();

		bfw.close();
		ows.close();
		fos.close();
	}

	public static void main(String[] args) throws IOException {

		GhiDeBai bai = new GhiDeBai();
		JFileChooser chooser = new JFileChooser("D:\\ListBaiTapCoBan_C++_+_DeBai\\");
		File f = null;
		if(chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
			f = chooser.getSelectedFile();
		}

		bai.docFile(f);
		String[] s = bai.s;

		for(int i = 0; i < s.length; i++) {
			System.out.println(i + " " + s[i]);
		}

		for(int j = 51; j <= 600; j += 100)
			for(int i = 0; i < 50; i++) {
				String destFilePath = "D:\\ListBaiTapCoBan_C++_+_DeBai\\" + (i + j) + "_.cpp";
				bai.ghiDeBai(destFilePath, i + j);
			}
		System.out.println("done!.");

	}
}
