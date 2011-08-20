#/bin/bash
# Simple script to fast test my current studies samples

find . -name *.class -exec rm -f {} \;
javac `find . -name *.java`
