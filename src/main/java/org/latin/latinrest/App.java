package org.latin.latinrest;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;

import org.latin.noun.NounDeclinationResolver;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.xml.sax.SAXException;

@SpringBootApplication
public class App {

    public static void main(String[] args) throws InstantiationException, IllegalAccessException, ClassNotFoundException, ParserConfigurationException, SAXException, IOException {
    	
    	// TODO move 
    	NounDeclinationResolver.getInstance().loadClasses("../latin.config.xml");
    	
    	SpringApplication app = new SpringApplication(App.class);
    	
    	app.run(args);
    }
}
