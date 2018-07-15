# RTcodegen.mk

MODEL = C:\Copy of ACCS\ACCS.rtmdl
COMPONENT = Component View::ThrottleActuatorComponent
RTJAVAGEN = rtjavagen
RTGEN_PROJ_FLAGS = -model "$(MODEL)" -component "$(COMPONENT)"
RTGEN_CMD = $(RTJAVAGEN) $(RTGEN_PROJ_FLAGS) $(RTGEN_USER_FLAGS)
PERL = rtperl
NOP = $(PERL) "$(ROSERT_HOME)/codegen/nop.pl"

ALL_GENERATION_TARGETS = \
	RTbuild/ACCSSystem/ThrottleActuator.gtg \
	RTbuild/ACCSSystem/CurrentSpeed.gtg \
	RTbuild/ACCSSystem/LeverCommand.gtg \
	RTbuild/ACCSSystem/Voltage.gtg \
	RTbuild/ACCSSystem/WheelShaftSensor.gtg \
	RTbuild/ACCSSystem/EnableEngine.gtg \
	RTbuild/ACCSSystem/Parameters.gtg \
	RTbuild/ACCSSystem/FunctionParameters.gtg \
	RTbuild/ACCSSystem/ManualParameters.gtg \
	RTbuild/ACCSSystem/CommandLeverSensor.gtg \
	RTbuild/ACCSSystem/BrakeInterrupt.gtg \
	RTbuild/ACCSSystem/EnableTopGear.gtg \
	RTbuild/ACCSSystem/InjectEventEngine.gtg \
	RTbuild/ACCSSystem/InjectEventTopGear.gtg \
	RTbuild/ACCSSystem/InjectEventBrake.gtg \
	RTbuild/ACCSSystem/InjectEventCommand.gtg \
	RTbuild/ACCSSystem/InjectEventParams.gtg

RTGENERATE_TARGET = RTbuild/RTproject.gtg
RTGENERATE_EACH_TARGET = $(ALL_GENERATION_TARGETS)


RTgenerate : $(RTGENERATE_TARGET)

RTgenerateEach : $(RTGENERATE_EACH_TARGET)

include RTbuild/ACCSSystem/ThrottleActuator.gmk
include RTbuild/ACCSSystem/CurrentSpeed.gmk
include RTbuild/ACCSSystem/LeverCommand.gmk
include RTbuild/ACCSSystem/Voltage.gmk
include RTbuild/ACCSSystem/WheelShaftSensor.gmk
include RTbuild/ACCSSystem/EnableEngine.gmk
include RTbuild/ACCSSystem/Parameters.gmk
include RTbuild/ACCSSystem/FunctionParameters.gmk
include RTbuild/ACCSSystem/ManualParameters.gmk
include RTbuild/ACCSSystem/CommandLeverSensor.gmk
include RTbuild/ACCSSystem/BrakeInterrupt.gmk
include RTbuild/ACCSSystem/EnableTopGear.gmk
include RTbuild/ACCSSystem/InjectEventEngine.gmk
include RTbuild/ACCSSystem/InjectEventTopGear.gmk
include RTbuild/ACCSSystem/InjectEventBrake.gmk
include RTbuild/ACCSSystem/InjectEventCommand.gmk
include RTbuild/ACCSSystem/InjectEventParams.gmk
include RTbuild/RTproject.gmk

RTbuild/RTproject.gtg : $(RTproject_DEPS)
	$(RTGEN_CMD)

RTbuild/ACCSSystem/ThrottleActuator.gtg : $(ACCSSystem_ThrottleActuator_DEPS)
	$(RTGEN_CMD) -class "Logical View::ACCSSystem::ThrottleActuator"

RTbuild/ACCSSystem/CurrentSpeed.gtg : $(ACCSSystem_CurrentSpeed_DEPS)
	$(RTGEN_CMD) -class "Logical View::ACCSSystem::CurrentSpeed"

RTbuild/ACCSSystem/LeverCommand.gtg : $(ACCSSystem_LeverCommand_DEPS)
	$(RTGEN_CMD) -class "Logical View::ACCSSystem::LeverCommand"

RTbuild/ACCSSystem/Voltage.gtg : $(ACCSSystem_Voltage_DEPS)
	$(RTGEN_CMD) -class "Logical View::ACCSSystem::Voltage"

RTbuild/ACCSSystem/WheelShaftSensor.gtg : $(ACCSSystem_WheelShaftSensor_DEPS)
	$(RTGEN_CMD) -class "Logical View::ACCSSystem::WheelShaftSensor"

RTbuild/ACCSSystem/EnableEngine.gtg : $(ACCSSystem_EnableEngine_DEPS)
	$(RTGEN_CMD) -class "Logical View::ACCSSystem::EnableEngine"

RTbuild/ACCSSystem/Parameters.gtg : $(ACCSSystem_Parameters_DEPS)
	$(RTGEN_CMD) -class "Logical View::ACCSSystem::Parameters"

RTbuild/ACCSSystem/FunctionParameters.gtg : $(ACCSSystem_FunctionParameters_DEPS)
	$(RTGEN_CMD) -class "Logical View::ACCSSystem::FunctionParameters"

RTbuild/ACCSSystem/ManualParameters.gtg : $(ACCSSystem_ManualParameters_DEPS)
	$(RTGEN_CMD) -class "Logical View::ACCSSystem::ManualParameters"

RTbuild/ACCSSystem/CommandLeverSensor.gtg : $(ACCSSystem_CommandLeverSensor_DEPS)
	$(RTGEN_CMD) -class "Logical View::ACCSSystem::CommandLeverSensor"

RTbuild/ACCSSystem/BrakeInterrupt.gtg : $(ACCSSystem_BrakeInterrupt_DEPS)
	$(RTGEN_CMD) -class "Logical View::ACCSSystem::BrakeInterrupt"

RTbuild/ACCSSystem/EnableTopGear.gtg : $(ACCSSystem_EnableTopGear_DEPS)
	$(RTGEN_CMD) -class "Logical View::ACCSSystem::EnableTopGear"

RTbuild/ACCSSystem/InjectEventEngine.gtg : $(ACCSSystem_InjectEventEngine_DEPS)
	$(RTGEN_CMD) -class "Logical View::ACCSSystem::InjectEventEngine"

RTbuild/ACCSSystem/InjectEventTopGear.gtg : $(ACCSSystem_InjectEventTopGear_DEPS)
	$(RTGEN_CMD) -class "Logical View::ACCSSystem::InjectEventTopGear"

RTbuild/ACCSSystem/InjectEventBrake.gtg : $(ACCSSystem_InjectEventBrake_DEPS)
	$(RTGEN_CMD) -class "Logical View::ACCSSystem::InjectEventBrake"

RTbuild/ACCSSystem/InjectEventCommand.gtg : $(ACCSSystem_InjectEventCommand_DEPS)
	$(RTGEN_CMD) -class "Logical View::ACCSSystem::InjectEventCommand"

RTbuild/ACCSSystem/InjectEventParams.gtg : $(ACCSSystem_InjectEventParams_DEPS)
	$(RTGEN_CMD) -class "Logical View::ACCSSystem::InjectEventParams"

RTforce :
	$(NOP)
