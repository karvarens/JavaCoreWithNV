package chapter7.io.fileclass;

import com.sun.tools.doclets.formats.html.*;

import java.io.*;
import java.util.*;

/**
 * Created by karenvardanyan on 8/5/17.
 */
public class StreamDemo {

	public static void main(String[] args) {
		System.out.println("start");
		Console console = System.console();
		System.out.println(console);

		String arg1 = "sssd";
		String fmt = "Something formated %s";

		String line = console.readLine();
		System.out.println(line);

		
		File file = new File("file.txt");
		byte[] buff = readFile(file);
		String fileContent = new String (buff);
		System.out.println(fileContent);

		writeFile(fileContent, new File("file_copy.txt"));


	}

	static byte[] readFile (File file) {
		InputStream in = null;
		byte [] buff = null;
		try {
			in = new FileInputStream(file);
			buff = new byte[in.available()];
			in.read(buff);

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			close(in);
		}
		return buff;
	}

	static void writeFile(String content, File file) {
		OutputStream out = null;

		try {
			out = new FileOutputStream(file);

			out.write(content.getBytes());

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			close(out);
		}
	}

	static void close (Closeable closeable){
		if (closeable != null) {
			try {
				closeable.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}


}


class Temp {
	public static void main(String[] args) {
		char hex[] = {
			'0', '1', '2', '3', '4', '5', '6', '7',
			'8', '9', 'a', 'b', 'c', 'd', 'e', 'f'
		};
		byte b = (byte) 0xf1;
		System.out.println(b);
		byte c = (byte) (b >> 4);
		byte d = (byte) (b >>> 4);
		byte e = (byte) ((b & 0xff) >> 4);

		System.out.println("              b = 0x"
			+ hex[(b >> 4) & 0x0f] + hex[b & 0x0f]);
		System.out.println("         b >> 4 = 0x"
			+ hex[(c >> 4) & 0x0f] + hex[c & 0x0f]);
		System.out.println("        b >>> 4 = 0x"
			+ hex[(d >> 4) & 0x0f] + hex[d & 0x0f]);
		System.out.println("(b & 0xff) >> 4 = 0x"
			+ hex[(e >> 4) & 0x0f] + hex[e & 0x0f]);


	}
}



















