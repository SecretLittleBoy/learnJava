import java.net.*;
import java.io.*;

public class UrlSite {
	public static void main(String args[]) {
		if (args.length < 1) {
			System.out.println("请输入URL作为args[]");
			System.exit(1);
		} else {
			for (int i = 0; i < args.length; i++) {
				urlSite(args[i]);
			}
		}
	}

	public static void urlSite(String urlname) {
		String s;
		URL url = null;
		InputStream urlstream = null;
		try {
			url = new URL(urlname);
		} catch (Exception e) {
			System.out.println("new URL(urlname)出错");
		}
		try {
			urlstream = url.openStream();
		} catch (IOException e) {
			System.out.println("URL.openStream()出错");
		}
		try{
			BufferedReader dat = new BufferedReader( new InputStreamReader(urlstream));
			while ((s = dat.readLine()) != null) {
				System.out.println(s);
			}
		}catch(Exception e){
			System.out.println("BufferedReader dat = new BufferedReader( new InputStreamReader(urlstream))出错");
		}
	}
}
