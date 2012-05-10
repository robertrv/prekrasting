#/bin/bash
# Simple script to fast test my current studies samples

find . -name *.class -exec rm -f {} \;
find . -name *.java -exec javac {} \;
#javac `find . -name *.java`
