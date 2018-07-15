# RTcodegen.mk

MODEL = C:\Documents and Settings\!Fantazio!\My Documents\ACCS\ACCS.rtmdl
COMPONENT = Component View::BrakeSensorComponent
RTJAVAGEN = rtjavagen
RTGEN_PROJ_FLAGS = -model "$(MODEL)" -component "$(COMPONENT)"
RTGEN_CMD = $(RTJAVAGEN) $(RTGEN_PROJ_FLAGS) $(RTGEN_USER_FLAGS)
PERL = rtperl
NOP = $(PERL) "$(ROSERT_HOME)/codegen/nop.pl"

ALL_GENERATION_TARGETS = \
	RTbuild/ACCSSystem/BrakeSensor.gtg \
	RTbuild/ACCSSystem/BrakeInterrupt.gtg

RTGENERATE_TARGET = RTbuild/RTproject.gtg
RTGENERATE_EACH_TARGET = $(ALL_GENERATION_TARGETS)


RTgenerate : $(RTGENERATE_TARGET)

RTgenerateEach : $(RTGENERATE_EACH_TARGET)

include RTbuild/ACCSSystem/BrakeSensor.gmk
include RTbuild/ACCSSystem/BrakeInterrupt.gmk
include RTbuild/RTproject.gmk

RTbuild/RTproject.gtg : $(RTproject_DEPS)
	$(RTGEN_CMD)

RTbuild/ACCSSystem/BrakeSensor.gtg : $(ACCSSystem_BrakeSensor_DEPS)
	$(RTGEN_CMD) -class "Logical View::ACCSSystem::BrakeSensor"

RTbuild/ACCSSystem/BrakeInterrupt.gtg : $(ACCSSystem_BrakeInterrupt_DEPS)
	$(RTGEN_CMD) -class "Logical View::ACCSSystem::BrakeInterrupt"

RTforce :
	$(NOP)
