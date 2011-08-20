#/bin/bash
# Simple script to fast test my current studies samples, just more changers :S

find . -name *.class -exec rm -f {} \;
javac `find . -name *.java`
