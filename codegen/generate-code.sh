#!/bin/bash
rm -rf ../src/main/java
java -cp "lib/*" org.jooq.util.GenerationTool jooq-config.xml
