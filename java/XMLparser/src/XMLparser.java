import java . io . File ;
import java . io . IOException ;
import javax . xml . parsers . DocumentBuilder ;
import javax . xml . parsers . DocumentBuilderFactory ;
import javax . xml . parsers . ParserConfigurationException ;
import org . w3c . dom . Document ;
import org . w3c . dom . NamedNodeMap ;
import org . w3c . dom . Node ;
import org . w3c . dom . NodeList ;
import org . xml . sax . SAXException ;
import org . xml . sax . SAXParseException ;

public class XMLparser {

	public static void main(String[] args) {
		Document doc = null ;
		DocumentBuilderFactory factory =
		DocumentBuilderFactory . newInstance () ;
		try {
		DocumentBuilder builder = factory . newDocumentBuilder () ;
		doc = builder . parse ( new File (args[0]));
		// ...
		} catch ( SAXParseException e) {
		e. printStackTrace () ;
		} catch ( SAXException e) {
		e. printStackTrace () ;
		} catch ( ParserConfigurationException e) {
		e. printStackTrace () ;
		} catch ( IOException e ) {
		e. printStackTrace () ;
		}
		String titlearr[] = new String [10];
		String authorarr[] = new String [10];
		String yeararr[] = new String [10];
		String pricearr[] = new String [10];
		String categoryarr[] = new String [10];
		String languagearr[] = new String [10];
		int counter=1;
		NodeList x = doc . getElementsByTagName ("title");
		NodeList x2 = doc . getElementsByTagName ("author");
		NodeList x3= doc . getElementsByTagName ("year");
		NodeList x4 = doc . getElementsByTagName ("price");
		
		for (int i =0; i < x. getLength () ; i ++) {
		Node title = x. item (i);
		Node author = x2.item(i);
		Node year = x3.item(i);
		Node price = x4.item(i);
	
		
		String contentT = title . getTextContent().trim();
		String contentA = author . getTextContent().trim();
		String contentY = year . getTextContent().trim();
		String contentP = price . getTextContent().trim();
		
		titlearr[i] = contentT;
		authorarr[i] = contentA;
		yeararr[i] = contentY;
		pricearr[i] = contentP;
		
		
		}
		NodeList book = doc . getElementsByTagName("book");
		NodeList title = doc . getElementsByTagName("title");
		for (int i=0;i<book.getLength();i++) {
			//System.out.println(titlearr[i]);
					if( book .item(i).getNodeType () == Node . ELEMENT_NODE ) {
					NamedNodeMap bookAttribute = book .item(i).getAttributes () ;
					Node bookAttribut =
					bookAttribute . getNamedItem ("category") ;
					String category =bookAttribut.getTextContent();
					categoryarr[i] = category;
					NamedNodeMap titleAttribute = title .item(i).getAttributes () ;
					Node titleAttribut =
					titleAttribute . getNamedItem ("lang") ;
					String language =titleAttribut.getTextContent();
					languagearr[i] = language;
		}
	}
		
		
		for (int i=0;i<titlearr.length;i++) {
			System.out.println("Book"+counter+"\n Title:"+titlearr[i]+"\n Author:"+authorarr[i]+"\n Year:"+yeararr[i]+"\n Price:"+pricearr[i]+" \n"
			+ " Language:"+languagearr[i]+"\n Category:"+categoryarr[i]+"\n");
			counter++;
		}
}
}
