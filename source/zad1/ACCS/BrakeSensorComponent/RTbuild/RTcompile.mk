# RTcompile.mk

JAVAC = javac -d "$(OUTPUT_CLASS_DIR)"
JAVAC_WRAPPER = rtperl "$(ROSERT_HOME)/RTJava/scripts/rtcomp.pl" -spacify dq -target $@ --
JAVAC_PATHSEP = ;
JAVAC_CLASSPATH = -classpath ".$(JAVAC_PATHSEP)$(ROSERT_HOME)/RTJava/classes.jar$(JAVAC_PATHSEP)%CLASSPATH%"
JAVAC_USEROPTS =
JAVAC_HEAD = $(JAVAC) $(JAVAC_CLASSPATH) $(JAVAC_USEROPTS)

ALL_COMPILATION_TARGETS = \
	RTbuild/ACCSSystem/BrakeSensor.ctg \
	RTbuild/ACCSSystem/BrakeInterrupt.ctg

ALL_COMPILATION_SOURCES = \
	ACCSSystem/BrakeSensor.java \
	ACCSSystem/BrakeInterrupt.java

ALL_COMPILED_CLASSES = \
	"$(OUTPUT_CLASS_DIR)/ACCSSystem/BrakeSensor.class" \
	"$(OUTPUT_CLASS_DIR)/ACCSSystem/BrakeInterrupt.class"

OUTPUT_CLASS_DIR = C:\Documents and Settings\!Fantazio!\My Documents\ACCS/BrakeSensorComponent
BUILD_TARGET = $(COMPILE_TARGET)
COMPILE_TARGET = $(COMPILE_ONE_TARGET)
COMPILE_ONE_TARGET = RTbuild/RTcompileAll.ctg
COMPILE_EACH_TARGET = $(ALL_COMPILATION_TARGETS)
JAR_TARGET = C:\Documents and Settings\!Fantazio!\My Documents\ACCS/BrakeSensorComponent.jar
JAR_DEPENDENCIES = $(COMPILE_TARGET)


RTcompile : $(BUILD_TARGET)

$(JAR_TARGET) : $(JAR_DEPENDENCIES) RTbuild/RTjar.mbs
	jar cvf "$(JAR_TARGET)" -C "$(OUTPUT_CLASS_DIR)" .

include RTbuild/ACCSSystem/BrakeSensor.cmk
include RTbuild/ACCSSystem/BrakeInterrupt.cmk

include RTbuild/RTcompileAll.cmk

RTbuild/ACCSSystem/BrakeSensor.ctg : $(ACCSSystem_BrakeSensor_DEPS_J) RTbuild/RTcompile.mbs
	$(JAVAC_WRAPPER) $(JAVAC_HEAD) ACCSSystem/BrakeSensor.java

RTbuild/ACCSSystem/BrakeInterrupt.ctg : $(ACCSSystem_BrakeInterrupt_DEPS_J) RTbuild/RTcompile.mbs
	$(JAVAC_WRAPPER) $(JAVAC_HEAD) ACCSSystem/BrakeInterrupt.java

RTbuild/RTcompileAll.ctg : $(ALL_COMPILATION_SOURCES) RTbuild/RTcompile.mbs
	$(JAVAC_WRAPPER) rtperl RTbuild/RTcompile.pl $(JAVAC_HEAD)

RTforce :
	$(NOP)
