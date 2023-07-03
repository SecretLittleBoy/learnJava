import java.net.*;
import java.io.*;

public class Connect {

	public static void main(String args[]) {
		String urlname = "file:///c:/jdk/Test.java";
		String s, x;
		URL url = null;
		URLConnection conn = null;
		OutputStream out = null;
		InputStream in = null;
		try {
			url = new URL(urlname);
			conn = url.openConnection();
			conn.setDoOutput(true);
		} catch (Exception e) {
			System.out.println("URL���ִ���");
		}
		try {
			in = conn.getInputStream();
			x = (String) conn.getContent();
			DataInputStream dat = new DataInputStream(in);
			while ((s = dat.readLine()) != null) {
				System.out.println(s);
			}
			dat.close();
		} catch (Exception e) {
			System.out.println("URL�ļ��򿪴���");
		}
	}
}
