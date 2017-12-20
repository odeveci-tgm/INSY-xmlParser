from xml.etree import ElementTree as et


class XMLParser():


    def __init__(self,filename):
        self.filename = filename

    def parse(self):
        doc = et.parse(self.filename)
        #print(et.tostring(doc.getroot()).decode('utf-8'))
        print("Weclome to the bookstore!")
        count=0
        #Alle <book> ... </book> Elemente, also jedes Buch-Element, werden durchiteriert
        for element in doc.findall("book"):
            #Alle Strings in Kindeselementen von <book> werden herausgehoben mit find().text  , mit strip() werden Whitespaces am Anfang und Ende des Strings entfernt.
            author = element.find("author").text.strip()
            title = element.find("title").text.strip()
            year = element.find("year").text.strip()
            price = element.find("price").text.strip()
            #Attribut in Kind-Element <title> wird geholt und zwar 'lang'
            language = element.find("title").attrib.get('lang')
            #find() für Attribut <book> nicht nötig, da dies schon in element enthalten ist
            category = element.attrib.get('category')
            #Gespeicherte Elemente werden formatiert ausgegeben
            print("Book %d \n Title: %s \n Author: %s \n Year: %s \n Price: %s \n Language: %s \n Category: %s \n " %
            (count,title,author,year,price,language,category))
            count+=1











