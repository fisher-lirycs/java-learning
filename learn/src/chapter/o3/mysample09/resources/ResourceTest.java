package chapter.o3.mysample09.resources;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.nio.charset.StandardCharsets;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class ResourceTest {

	public static void main(String[] args) throws UnsupportedEncodingException, IOException {
		Class cl = ResourceTest.class;
		URL aboutURL = cl.getResource("about.avif");
		var icon = new ImageIcon(aboutURL);
		
		InputStream stream = cl.getResourceAsStream("about.txt");
		var about =new String(stream.readAllBytes(), "UTF-8");
		
		InputStream stream2 = cl.getResourceAsStream("title.txt");
		var title =new String(stream2.readAllBytes(), StandardCharsets.UTF_8).strip();
		JOptionPane.showMessageDialog(null, about, title, JOptionPane.INFORMATION_MESSAGE, icon);


	}

}
