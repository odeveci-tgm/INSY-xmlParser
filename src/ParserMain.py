from xmlparser import XMLParser
import sys


def main():
    parser = XMLParser(sys.argv[1])
    parser.parse()

if __name__ == "__main__":
    main()
