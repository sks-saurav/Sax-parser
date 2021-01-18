package parser;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;

public class XmlParser {
	public static void main(String[] args) {
		SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
		try {
			SAXParser saxParser = saxParserFactory.newSAXParser();			
			Handler handler = new Handler();
			saxParser.parse(new File("data/database.xml"), handler);
			List<Student> list = handler.getList();
			for(Student st : list) {
				System.out.println(st.getId()+" "+st.getName());
				System.out.println(st.about);
				System.out.println("-------------------------");
			}
		} catch(ParserConfigurationException | SAXException | IOException e) {
			e.printStackTrace();
		}
	}
}
