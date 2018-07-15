# RTcodegen.mk

MODEL = C:\Documents and Settings\!Fantazio!\My Documents\ACCS\ACCS.rtmdl
COMPONENT = Component View::TopGearSensorComponent
RTJAVAGEN = rtjavagen
RTGEN_PROJ_FLAGS = -model "$(MODEL)" -component "$(COMPONENT)"
RTGEN_CMD = $(RTJAVAGEN) $(RTGEN_PROJ_FLAGS) $(RTGEN_USER_FLAGS)
PERL = rtperl
NOP = $(PERL) "$(ROSERT_HOME)/codegen/nop.pl"

ALL_GENERATION_TARGETS = \
	RTbuild/ACCSSystem/TopGearSensor.gtg \
	RTbuild/ACCSSystem/EnableTopGear.gtg \
	RTbuild/ACCSSystem/CommandLeverSensor.gtg \
	RTbuild/ACCSSystem/BrakeInterrupt.gtg \
	RTbuild/ACCSSystem/EnableEngine.gtg \
	RTbuild/ACCSSystem/LeverCommand.gtg \
	RTbuild/ACCSSystem/CurrentSpeed.gtg \
	RTbuild/ACCSSystem/WheelShaftSensor.gtg \
	RTbuild/ACCSSystem/Parameters.gtg \
	RTbuild/ACCSSystem/FunctionParameters.gtg \
	RTbuild/ACCSSystem/ManualParameters.gtg \
	RTbuild/ACCSSystem/ThrottleActuator.gtg \
	RTbuild/ACCSSystem/Voltage.gtg

RTGENERATE_TARGET = RTbuild/RTproject.gtg
RTGENERATE_EACH_TARGET = $(ALL_GENERATION_TARGETS)


RTgenerate : $(RTGENERATE_TARGET)

RTgenerateEach : $(RTGENERATE_EACH_TARGET)

include RTbuild/ACCSSystem/TopGearSensor.gmk
include RTbuild/ACCSSystem/EnableTopGear.gmk
include RTbuild/ACCSSystem/CommandLeverSensor.gmk
include RTbuild/ACCSSystem/BrakeInterrupt.gmk
include RTbuild/ACCSSystem/EnableEngine.gmk
include RTbuild/ACCSSystem/LeverCommand.gmk
include RTbuild/ACCSSystem/CurrentSpeed.gmk
include RTbuild/ACCSSystem/WheelShaftSensor.gmk
include RTbuild/ACCSSystem/Parameters.gmk
include RTbuild/ACCSSystem/FunctionParameters.gmk
include RTbuild/ACCSSystem/ManualParameters.gmk
include RTbuild/ACCSSystem/ThrottleActuator.gmk
include RTbuild/ACCSSystem/Voltage.gmk
include RTbuild/RTproject.gmk

RTbuild/RTproject.gtg : $(RTproject_DEPS)
	$(RTGEN_CMD)

RTbuild/ACCSSystem/TopGearSensor.gtg : $(ACCSSystem_TopGearSensor_DEPS)
	$(RTGEN_CMD) -class "Logical View::ACCSSystem::TopGearSensor"

RTbuild/ACCSSystem/EnableTopGear.gtg : $(ACCSSystem_EnableTopGear_DEPS)
	$(RTGEN_CMD) -class "Logical View::ACCSSystem::EnableTopGear"

RTbuild/ACCSSystem/CommandLeverSensor.gtg : $(ACCSSystem_CommandLeverSensor_DEPS)
	$(RTGEN_CMD) -class "Logical View::ACCSSystem::CommandLeverSensor"

RTbuild/ACCSSystem/BrakeInterrupt.gtg : $(ACCSSystem_BrakeInterrupt_DEPS)
	$(RTGEN_CMD) -class "Logical View::ACCSSystem::BrakeInterrupt"

RTbuild/ACCSSystem/EnableEngine.gtg : $(ACCSSystem_EnableEngine_DEPS)
	$(RTGEN_CMD) -class "Logical View::ACCSSystem::EnableEngine"

RTbuild/ACCSSystem/LeverCommand.gtg : $(ACCSSystem_LeverCommand_DEPS)
	$(RTGEN_CMD) -class "Logical View::ACCSSystem::LeverCommand"

RTbuild/ACCSSystem/CurrentSpeed.gtg : $(ACCSSystem_CurrentSpeed_DEPS)
	$(RTGEN_CMD) -class "Logical View::ACCSSystem::CurrentSpeed"

RTbuild/ACCSSystem/WheelShaftSensor.gtg : $(ACCSSystem_WheelShaftSensor_DEPS)
	$(RTGEN_CMD) -class "Logical View::ACCSSystem::WheelShaftSensor"

RTbuild/ACCSSystem/Parameters.gtg : $(ACCSSystem_Parameters_DEPS)
	$(RTGEN_CMD) -class "Logical View::ACCSSystem::Parameters"

RTbuild/ACCSSystem/FunctionParameters.gtg : $(ACCSSystem_FunctionParameters_DEPS)
	$(RTGEN_CMD) -class "Logical View::ACCSSystem::FunctionParameters"

RTbuild/ACCSSystem/ManualParameters.gtg : $(ACCSSystem_ManualParameters_DEPS)
	$(RTGEN_CMD) -class "Logical View::ACCSSystem::ManualParameters"

RTbuild/ACCSSystem/ThrottleActuator.gtg : $(ACCSSystem_ThrottleActuator_DEPS)
	$(RTGEN_CMD) -class "Logical View::ACCSSystem::ThrottleActuator"

RTbuild/ACCSSystem/Voltage.gtg : $(ACCSSystem_Voltage_DEPS)
	$(RTGEN_CMD) -class "Logical View::ACCSSystem::Voltage"

RTforce :
	$(NOP)
