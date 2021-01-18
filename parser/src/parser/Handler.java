package parser;

import java.util.ArrayList;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class Handler extends DefaultHandler {
	
	private List<Student> stList = null;
	private Student student = null;
	
	public List<Student> getList(){
		return stList;
	}
	
	boolean isAge = false, isName = false, isAbout = false;

	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		if(qName.equalsIgnoreCase("Student")) {
			student = new Student(Integer.parseInt(attributes.getValue("id")));
			if(stList == null)
				stList = new ArrayList<>();
		} else if(qName.equalsIgnoreCase("Name")) {
			isName = true;
		} else if(qName.equalsIgnoreCase("Age")) {
			isAge = true;
		} else if(qName.equalsIgnoreCase("About")) {
			isAbout = true;
		}
		
	}

	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		if(qName.equalsIgnoreCase("Student")) {
			stList.add(student);
		}
	}

	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		if(isName) {
			student.setName(new String(ch, start, length));
			isName = false;
		} else if(isAge) {
			student.setAge(Integer.parseInt(new String(ch, start, length)));
			isAge = false;
		} else if(isAbout) {
			student.setAbout(new String(ch, start, length));
			isAbout = false;
		}
	}
	
}