"""
    Simple script to move files from origin to end.
    
    Usefull for netquest sm2 schemas movement after SchemaInterpreter refactor, 
    to keep tests working.
"""
import os
origin="/tmp/"  # insert the path to the directory of interest
end="/home/rramirez/p4/sm2/it/it40/NSM2.test/nsm2.jar-test-unit/nq/schema/generate/srf/mixedset/"


def writeFile(filename, content):
    f = open(filename, 'w')
    f.seek(0)
    f.write(content)
    f.close()

def readFile(filename):
    f = open(filename, 'r')
    text = f.read()
    f.close()
    return text

def replace(oldfile, newfile):
    content = readFile(oldfile)
    if (os.path.isfile(newfile)):
        writeFile(newfile, content)
        print "replaced %s with content of %s" % (newfile, oldfile)
    
dirList=os.listdir(origin)
for fname in dirList:
    if "mixedset-" in fname:
        oldfile = origin+fname
        newfile = end+fname.replace("generated-","").replace("-Schema.json","Schema.json")
        replace(oldfile,newfile)

