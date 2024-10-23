all:
	javac -cp src/ -d bin/ src/*.java

run:
	java -cp bin/ Main
