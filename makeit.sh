#!/bin/sh

rm Project/*.class
javacc Project/ParserL0.jj
javac Project/*.java
