# RTcompile.mk

JAVAC = javac -d "$(OUTPUT_CLASS_DIR)"
JAVAC_WRAPPER = rtperl "$(ROSERT_HOME)/RTJava/scripts/rtcomp.pl" -spacify dq -target $@ --
JAVAC_PATHSEP = ;
JAVAC_CLASSPATH = -classpath ".$(JAVAC_PATHSEP)C:\Documents and Settings\!Fantazio!\My Documents\NetBeansProjects\ACCS\src\rs\etf\prv\accs$(JAVAC_PATHSEP)%CLASSPATH%"
JAVAC_USEROPTS =
JAVAC_HEAD = $(JAVAC) $(JAVAC_CLASSPATH) $(JAVAC_USEROPTS)

ALL_COMPILATION_TARGETS = \
	RTbuild/ACCSGUI/ACCSGUIPanel.ctg \
	RTbuild/ACCSGUI/ListenerA.ctg \
	RTbuild/ACCSGUI/ButtonEvent.ctg \
	RTbuild/ACCSGUI/ButtonValues.ctg \
	RTbuild/java/awt/event/MouseAdapter.ctg \
	RTbuild/ACCSSystem/FunctionParameters.ctg \
	RTbuild/ACCSSystem/ManualParameters.ctg \
	RTbuild/ACCSGUI/ListenerMP.ctg \
	RTbuild/ACCSGUI/ListenerFP.ctg

ALL_COMPILATION_SOURCES = \
	ACCSGUI/ACCSGUIPanel.java \
	ACCSGUI/ListenerA.java \
	ACCSGUI/ButtonEvent.java \
	ACCSGUI/ButtonValues.java \
	java/awt/event/MouseAdapter.java \
	ACCSSystem/FunctionParameters.java \
	ACCSSystem/ManualParameters.java \
	ACCSGUI/ListenerMP.java \
	ACCSGUI/ListenerFP.java

ALL_COMPILED_CLASSES = \
	"$(OUTPUT_CLASS_DIR)/ACCSGUI/ACCSGUIPanel.class" \
	"$(OUTPUT_CLASS_DIR)/ACCSGUI/ListenerA.class" \
	"$(OUTPUT_CLASS_DIR)/ACCSGUI/ButtonEvent.class" \
	"$(OUTPUT_CLASS_DIR)/ACCSGUI/ButtonValues.class" \
	"$(OUTPUT_CLASS_DIR)/java/awt/event/MouseAdapter.class" \
	"$(OUTPUT_CLASS_DIR)/ACCSSystem/FunctionParameters.class" \
	"$(OUTPUT_CLASS_DIR)/ACCSSystem/ManualParameters.class" \
	"$(OUTPUT_CLASS_DIR)/ACCSGUI/ListenerMP.class" \
	"$(OUTPUT_CLASS_DIR)/ACCSGUI/ListenerFP.class"

OUTPUT_CLASS_DIR = C:\CopyACCS/GUIComponent
BUILD_TARGET = $(COMPILE_TARGET)
COMPILE_TARGET = $(COMPILE_ONE_TARGET)
COMPILE_ONE_TARGET = RTbuild/RTcompileAll.ctg
COMPILE_EACH_TARGET = $(ALL_COMPILATION_TARGETS)
JAR_TARGET = C:\CopyACCS/GUIComponent.jar
JAR_DEPENDENCIES = $(COMPILE_TARGET)


RTcompile : $(BUILD_TARGET)

$(JAR_TARGET) : $(JAR_DEPENDENCIES) RTbuild/RTjar.mbs
	jar cvf "$(JAR_TARGET)" -C "$(OUTPUT_CLASS_DIR)" .

include RTbuild/ACCSGUI/ACCSGUIPanel.cmk
include RTbuild/ACCSGUI/ListenerA.cmk
include RTbuild/ACCSGUI/ButtonEvent.cmk
include RTbuild/ACCSGUI/ButtonValues.cmk
include RTbuild/java/awt/event/MouseAdapter.cmk
include RTbuild/ACCSSystem/FunctionParameters.cmk
include RTbuild/ACCSSystem/ManualParameters.cmk
include RTbuild/ACCSGUI/ListenerMP.cmk
include RTbuild/ACCSGUI/ListenerFP.cmk

include RTbuild/RTcompileAll.cmk

RTbuild/ACCSGUI/ACCSGUIPanel.ctg : $(ACCSGUI_ACCSGUIPanel_DEPS_J) RTbuild/RTcompile.mbs
	$(JAVAC_WRAPPER) $(JAVAC_HEAD) ACCSGUI/ACCSGUIPanel.java

RTbuild/ACCSGUI/ListenerA.ctg : $(ACCSGUI_ListenerA_DEPS_J) RTbuild/RTcompile.mbs
	$(JAVAC_WRAPPER) $(JAVAC_HEAD) ACCSGUI/ListenerA.java

RTbuild/ACCSGUI/ButtonEvent.ctg : $(ACCSGUI_ButtonEvent_DEPS_J) RTbuild/RTcompile.mbs
	$(JAVAC_WRAPPER) $(JAVAC_HEAD) ACCSGUI/ButtonEvent.java

RTbuild/ACCSGUI/ButtonValues.ctg : $(ACCSGUI_ButtonValues_DEPS_J) RTbuild/RTcompile.mbs
	$(JAVAC_WRAPPER) $(JAVAC_HEAD) ACCSGUI/ButtonValues.java

RTbuild/java/awt/event/MouseAdapter.ctg : $(java_awt_event_MouseAdapter_DEPS_J) RTbuild/RTcompile.mbs
	$(JAVAC_WRAPPER) $(JAVAC_HEAD) java/awt/event/MouseAdapter.java

RTbuild/ACCSSystem/FunctionParameters.ctg : $(ACCSSystem_FunctionParameters_DEPS_J) RTbuild/RTcompile.mbs
	$(JAVAC_WRAPPER) $(JAVAC_HEAD) ACCSSystem/FunctionParameters.java

RTbuild/ACCSSystem/ManualParameters.ctg : $(ACCSSystem_ManualParameters_DEPS_J) RTbuild/RTcompile.mbs
	$(JAVAC_WRAPPER) $(JAVAC_HEAD) ACCSSystem/ManualParameters.java

RTbuild/ACCSGUI/ListenerMP.ctg : $(ACCSGUI_ListenerMP_DEPS_J) RTbuild/RTcompile.mbs
	$(JAVAC_WRAPPER) $(JAVAC_HEAD) ACCSGUI/ListenerMP.java

RTbuild/ACCSGUI/ListenerFP.ctg : $(ACCSGUI_ListenerFP_DEPS_J) RTbuild/RTcompile.mbs
	$(JAVAC_WRAPPER) $(JAVAC_HEAD) ACCSGUI/ListenerFP.java

RTbuild/RTcompileAll.ctg : $(ALL_COMPILATION_SOURCES) RTbuild/RTcompile.mbs
	$(JAVAC_WRAPPER) rtperl RTbuild/RTcompile.pl $(JAVAC_HEAD)

RTforce :
	$(NOP)
