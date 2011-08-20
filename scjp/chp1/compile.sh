#/bin/bash

find . -name *.class -exec rm -f {} \;
javac `find . -name *.java`
