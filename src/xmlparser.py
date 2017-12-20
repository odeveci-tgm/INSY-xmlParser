from xml.etree import ElementTree as et
import sys

class XMLParser():


    def __init__(self,filename):
        self.filename = filename

    def parse(self):
        doc = et.parse(self.filename)
        print(et.tostring(doc.getroot()).decode('utf-8'))






