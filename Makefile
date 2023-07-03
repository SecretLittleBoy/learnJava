JAVA_FILES := $(wildcard *.java)
CLASS_FILES := $(patsubst %.java, %.class, $(JAVA_FILES))

exe := HelloWorld

all: $(CLASS_FILES)
	java $(exe)

%.class: %.java
	javac $<

clean:
	find . -name "*.class" | xargs rm -f
	ls -alh
