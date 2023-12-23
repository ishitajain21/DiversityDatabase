Main_Class="Main"
Output_File="out"

javac *.java -target 8 -source 8
mkdir build
echo Main-Class: $Main_Class > build/MANIFEST.MF
jar -cvfm build/$Output_File.jar build/MANIFEST.MF *.class
rm build/MANIFEST.MF
echo java -jar $Output_File.jar > build/run.bat
cp *.txt build
cp *.dat build
zip -r output build