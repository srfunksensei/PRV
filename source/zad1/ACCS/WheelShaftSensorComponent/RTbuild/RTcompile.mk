# RTcompile.mk

JAVAC = javac -d "$(OUTPUT_CLASS_DIR)"
JAVAC_WRAPPER = rtperl "$(ROSERT_HOME)/RTJava/scripts/rtcomp.pl" -spacify dq -target $@ --
JAVAC_PATHSEP = ;
JAVAC_CLASSPATH = -classpath ".$(JAVAC_PATHSEP)$(ROSERT_HOME)/RTJava/classes.jar$(JAVAC_PATHSEP)%CLASSPATH%"
JAVAC_USEROPTS =
JAVAC_HEAD = $(JAVAC) $(JAVAC_CLASSPATH) $(JAVAC_USEROPTS)

ALL_COMPILATION_TARGETS = \
	RTbuild/ACCSSystem/WheelShaftSensor.ctg \
	RTbuild/ACCSSystem/EnableEngine.ctg \
	RTbuild/ACCSSystem/CurrentSpeed.ctg \
	RTbuild/ACCSSystem/Parameters.ctg \
	RTbuild/ACCSSystem/FunctionParameters.ctg \
	RTbuild/ACCSSystem/ManualParameters.ctg \
	RTbuild/ACCSSystem/LeverCommand.ctg \
	RTbuild/ACCSSystem/CommandLeverSensor.ctg \
	RTbuild/ACCSSystem/BrakeInterrupt.ctg \
	RTbuild/ACCSSystem/EnableTopGear.ctg \
	RTbuild/ACCSSystem/ThrottleActuator.ctg \
	RTbuild/ACCSSystem/Voltage.ctg

ALL_COMPILATION_SOURCES = \
	ACCSSystem/WheelShaftSensor.java \
	ACCSSystem/EnableEngine.java \
	ACCSSystem/CurrentSpeed.java \
	ACCSSystem/Parameters.java \
	ACCSSystem/FunctionParameters.java \
	ACCSSystem/ManualParameters.java \
	ACCSSystem/LeverCommand.java \
	ACCSSystem/CommandLeverSensor.java \
	ACCSSystem/BrakeInterrupt.java \
	ACCSSystem/EnableTopGear.java \
	ACCSSystem/ThrottleActuator.java \
	ACCSSystem/Voltage.java

ALL_COMPILED_CLASSES = \
	"$(OUTPUT_CLASS_DIR)/ACCSSystem/WheelShaftSensor.class" \
	"$(OUTPUT_CLASS_DIR)/ACCSSystem/EnableEngine.class" \
	"$(OUTPUT_CLASS_DIR)/ACCSSystem/CurrentSpeed.class" \
	"$(OUTPUT_CLASS_DIR)/ACCSSystem/Parameters.class" \
	"$(OUTPUT_CLASS_DIR)/ACCSSystem/FunctionParameters.class" \
	"$(OUTPUT_CLASS_DIR)/ACCSSystem/ManualParameters.class" \
	"$(OUTPUT_CLASS_DIR)/ACCSSystem/LeverCommand.class" \
	"$(OUTPUT_CLASS_DIR)/ACCSSystem/CommandLeverSensor.class" \
	"$(OUTPUT_CLASS_DIR)/ACCSSystem/BrakeInterrupt.class" \
	"$(OUTPUT_CLASS_DIR)/ACCSSystem/EnableTopGear.class" \
	"$(OUTPUT_CLASS_DIR)/ACCSSystem/ThrottleActuator.class" \
	"$(OUTPUT_CLASS_DIR)/ACCSSystem/Voltage.class"

OUTPUT_CLASS_DIR = C:\Documents and Settings\!Fantazio!\My Documents\ACCS/WheelShaftSensorComponent
BUILD_TARGET = $(COMPILE_TARGET)
COMPILE_TARGET = $(COMPILE_ONE_TARGET)
COMPILE_ONE_TARGET = RTbuild/RTcompileAll.ctg
COMPILE_EACH_TARGET = $(ALL_COMPILATION_TARGETS)
JAR_TARGET = C:\Documents and Settings\!Fantazio!\My Documents\ACCS/WheelShaftSensorComponent.jar
JAR_DEPENDENCIES = $(COMPILE_TARGET)


RTcompile : $(BUILD_TARGET)

$(JAR_TARGET) : $(JAR_DEPENDENCIES) RTbuild/RTjar.mbs
	jar cvf "$(JAR_TARGET)" -C "$(OUTPUT_CLASS_DIR)" .

include RTbuild/ACCSSystem/WheelShaftSensor.cmk
include RTbuild/ACCSSystem/EnableEngine.cmk
include RTbuild/ACCSSystem/CurrentSpeed.cmk
include RTbuild/ACCSSystem/Parameters.cmk
include RTbuild/ACCSSystem/FunctionParameters.cmk
include RTbuild/ACCSSystem/ManualParameters.cmk
include RTbuild/ACCSSystem/LeverCommand.cmk
include RTbuild/ACCSSystem/CommandLeverSensor.cmk
include RTbuild/ACCSSystem/BrakeInterrupt.cmk
include RTbuild/ACCSSystem/EnableTopGear.cmk
include RTbuild/ACCSSystem/ThrottleActuator.cmk
include RTbuild/ACCSSystem/Voltage.cmk

include RTbuild/RTcompileAll.cmk

RTbuild/ACCSSystem/WheelShaftSensor.ctg : $(ACCSSystem_WheelShaftSensor_DEPS_J) RTbuild/RTcompile.mbs
	$(JAVAC_WRAPPER) $(JAVAC_HEAD) ACCSSystem/WheelShaftSensor.java

RTbuild/ACCSSystem/EnableEngine.ctg : $(ACCSSystem_EnableEngine_DEPS_J) RTbuild/RTcompile.mbs
	$(JAVAC_WRAPPER) $(JAVAC_HEAD) ACCSSystem/EnableEngine.java

RTbuild/ACCSSystem/CurrentSpeed.ctg : $(ACCSSystem_CurrentSpeed_DEPS_J) RTbuild/RTcompile.mbs
	$(JAVAC_WRAPPER) $(JAVAC_HEAD) ACCSSystem/CurrentSpeed.java

RTbuild/ACCSSystem/Parameters.ctg : $(ACCSSystem_Parameters_DEPS_J) RTbuild/RTcompile.mbs
	$(JAVAC_WRAPPER) $(JAVAC_HEAD) ACCSSystem/Parameters.java

RTbuild/ACCSSystem/FunctionParameters.ctg : $(ACCSSystem_FunctionParameters_DEPS_J) RTbuild/RTcompile.mbs
	$(JAVAC_WRAPPER) $(JAVAC_HEAD) ACCSSystem/FunctionParameters.java

RTbuild/ACCSSystem/ManualParameters.ctg : $(ACCSSystem_ManualParameters_DEPS_J) RTbuild/RTcompile.mbs
	$(JAVAC_WRAPPER) $(JAVAC_HEAD) ACCSSystem/ManualParameters.java

RTbuild/ACCSSystem/LeverCommand.ctg : $(ACCSSystem_LeverCommand_DEPS_J) RTbuild/RTcompile.mbs
	$(JAVAC_WRAPPER) $(JAVAC_HEAD) ACCSSystem/LeverCommand.java

RTbuild/ACCSSystem/CommandLeverSensor.ctg : $(ACCSSystem_CommandLeverSensor_DEPS_J) RTbuild/RTcompile.mbs
	$(JAVAC_WRAPPER) $(JAVAC_HEAD) ACCSSystem/CommandLeverSensor.java

RTbuild/ACCSSystem/BrakeInterrupt.ctg : $(ACCSSystem_BrakeInterrupt_DEPS_J) RTbuild/RTcompile.mbs
	$(JAVAC_WRAPPER) $(JAVAC_HEAD) ACCSSystem/BrakeInterrupt.java

RTbuild/ACCSSystem/EnableTopGear.ctg : $(ACCSSystem_EnableTopGear_DEPS_J) RTbuild/RTcompile.mbs
	$(JAVAC_WRAPPER) $(JAVAC_HEAD) ACCSSystem/EnableTopGear.java

RTbuild/ACCSSystem/ThrottleActuator.ctg : $(ACCSSystem_ThrottleActuator_DEPS_J) RTbuild/RTcompile.mbs
	$(JAVAC_WRAPPER) $(JAVAC_HEAD) ACCSSystem/ThrottleActuator.java

RTbuild/ACCSSystem/Voltage.ctg : $(ACCSSystem_Voltage_DEPS_J) RTbuild/RTcompile.mbs
	$(JAVAC_WRAPPER) $(JAVAC_HEAD) ACCSSystem/Voltage.java

RTbuild/RTcompileAll.ctg : $(ALL_COMPILATION_SOURCES) RTbuild/RTcompile.mbs
	$(JAVAC_WRAPPER) rtperl RTbuild/RTcompile.pl $(JAVAC_HEAD)

RTforce :
	$(NOP)
