package com.epam.automation.parsing;

import com.epam.automation.model.User;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Parsing {
    public List<String> mails = new ArrayList<String>();
    List<User> users = new ArrayList<>();

    public void cSVParse(String usersCsv){
        users = CSVReader.readBooksFromCSV(usersCsv);
    }

    public void xMLParse(String usersXml) throws ParserConfigurationException, SAXException, IOException {
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document document = dBuilder.parse(usersXml);
        List<User> users = new DomParserUser().parse(document);
        users.forEach(user -> mails.add(user.getE_mail()));
    }
}
