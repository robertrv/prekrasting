"""
    Simple script to move files from origin to end.
    
    Usefull for netquest sm2 schemas movement after SchemaInterpreter refactor, 
    to keep tests working.
    
    NOTE: There are problems with multiple files with the same name, take care!
"""
import os
origin="/tmp/"  # insert the path to the directory of interest
end="/home/rramirez/p4/sm2/it/it40/NSM2.test/nsm2.jar-test-unit/nq/schema/generate/"


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

def OpenFileForEdit(file, changelist = ""):
    "Open a file for edit, if a changelist is passed in then open it in that list"
    cmd = "p4 edit "
    if changelist:
        cmd += " -c " + changelist + " "
    ret = os.popen(cmd + file).readline().strip()
    if not ret.endswith("opened for edit"):
        print "Couldn't open", file, "for edit:"
        print ret
        

def replace(oldfile, newfile):
    if os.path.isfile(oldfile) and os.path.isfile(newfile):
        content = readFile(oldfile)
        OpenFileForEdit(newfile)
        writeFile(newfile, content)
        print "replaced %s with content of %s" % (newfile, oldfile)

def processRecursively(rootdir):
    for root, subFolders, files in os.walk(rootdir):
        for filename in files:
            if "Schema.json" in filename:
                filePath = os.path.join(root, filename)
                oldfile = "generated-%s"%(filename.replace("Schema.json","-Schema.json"))
                oldPath = os.path.join(origin, oldfile)
                replace(oldPath, filePath)

    
processRecursively(end)
