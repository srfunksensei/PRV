# RTcodegen.mk

MODEL = C:\CopyACCS\ACCS.rtmdl
COMPONENT = Component View::ACCSComponent
RTJAVAGEN = rtjavagen
RTGEN_PROJ_FLAGS = -model "$(MODEL)" -component "$(COMPONENT)"
RTGEN_CMD = $(RTJAVAGEN) $(RTGEN_PROJ_FLAGS) $(RTGEN_USER_FLAGS)
PERL = rtperl
NOP = $(PERL) "$(ROSERT_HOME)/codegen/nop.pl"

ALL_GENERATION_TARGETS = \
	RTbuild/ACCSSystem/ACCS.gtg \
	RTbuild/ACCSSystem/BrakeInterrupt.gtg \
	RTbuild/ACCSSystem/CommandLeverSensor.gtg \
	RTbuild/ACCSSystem/EnableTopGear.gtg \
	RTbuild/ACCSSystem/EnableEngine.gtg \
	RTbuild/ACCSSystem/ThrottleActuator.gtg \
	RTbuild/ACCSSystem/ThrottleSensor.gtg \
	RTbuild/ACCSSystem/WheelShaftSensor.gtg \
	RTbuild/ACCSSystem/LeverCommand.gtg \
	RTbuild/ACCSSystem/CurrentSpeed.gtg \
	RTbuild/ACCSSystem/Parameters.gtg \
	RTbuild/ACCSSystem/Voltage.gtg \
	RTbuild/ACCSSystem/InjectEventEngine.gtg \
	RTbuild/ACCSSystem/InjectEventTopGear.gtg \
	RTbuild/ACCSSystem/InjectEventBrake.gtg \
	RTbuild/ACCSSystem/InjectEventCommand.gtg \
	RTbuild/ACCSSystem/InjectEventFunctionParams.gtg \
	RTbuild/ACCSSystem/TmpBrake.gtg \
	RTbuild/ACCSSystem/TmpTopGear.gtg \
	RTbuild/ACCSSystem/TmpCommand.gtg \
	RTbuild/ACCSSystem/TmpManualParams.gtg \
	RTbuild/ACCSSystem/TmpFunctionParams.gtg \
	RTbuild/ACCSSystem/InjectEventManualParams.gtg

RTGENERATE_TARGET = RTbuild/RTproject.gtg
RTGENERATE_EACH_TARGET = $(ALL_GENERATION_TARGETS)


RTgenerate : $(RTGENERATE_TARGET)

RTgenerateEach : $(RTGENERATE_EACH_TARGET)

include RTbuild/ACCSSystem/ACCS.gmk
include RTbuild/ACCSSystem/BrakeInterrupt.gmk
include RTbuild/ACCSSystem/CommandLeverSensor.gmk
include RTbuild/ACCSSystem/EnableTopGear.gmk
include RTbuild/ACCSSystem/EnableEngine.gmk
include RTbuild/ACCSSystem/ThrottleActuator.gmk
include RTbuild/ACCSSystem/ThrottleSensor.gmk
include RTbuild/ACCSSystem/WheelShaftSensor.gmk
include RTbuild/ACCSSystem/LeverCommand.gmk
include RTbuild/ACCSSystem/CurrentSpeed.gmk
include RTbuild/ACCSSystem/Parameters.gmk
include RTbuild/ACCSSystem/Voltage.gmk
include RTbuild/ACCSSystem/InjectEventEngine.gmk
include RTbuild/ACCSSystem/InjectEventTopGear.gmk
include RTbuild/ACCSSystem/InjectEventBrake.gmk
include RTbuild/ACCSSystem/InjectEventCommand.gmk
include RTbuild/ACCSSystem/InjectEventFunctionParams.gmk
include RTbuild/ACCSSystem/TmpBrake.gmk
include RTbuild/ACCSSystem/TmpTopGear.gmk
include RTbuild/ACCSSystem/TmpCommand.gmk
include RTbuild/ACCSSystem/TmpManualParams.gmk
include RTbuild/ACCSSystem/TmpFunctionParams.gmk
include RTbuild/ACCSSystem/InjectEventManualParams.gmk
include RTbuild/RTproject.gmk

RTbuild/RTproject.gtg : $(RTproject_DEPS)
	$(RTGEN_CMD)

RTbuild/ACCSSystem/ACCS.gtg : $(ACCSSystem_ACCS_DEPS)
	$(RTGEN_CMD) -class "Logical View::ACCSSystem::ACCS"

RTbuild/ACCSSystem/BrakeInterrupt.gtg : $(ACCSSystem_BrakeInterrupt_DEPS)
	$(RTGEN_CMD) -class "Logical View::ACCSSystem::BrakeInterrupt"

RTbuild/ACCSSystem/CommandLeverSensor.gtg : $(ACCSSystem_CommandLeverSensor_DEPS)
	$(RTGEN_CMD) -class "Logical View::ACCSSystem::CommandLeverSensor"

RTbuild/ACCSSystem/EnableTopGear.gtg : $(ACCSSystem_EnableTopGear_DEPS)
	$(RTGEN_CMD) -class "Logical View::ACCSSystem::EnableTopGear"

RTbuild/ACCSSystem/EnableEngine.gtg : $(ACCSSystem_EnableEngine_DEPS)
	$(RTGEN_CMD) -class "Logical View::ACCSSystem::EnableEngine"

RTbuild/ACCSSystem/ThrottleActuator.gtg : $(ACCSSystem_ThrottleActuator_DEPS)
	$(RTGEN_CMD) -class "Logical View::ACCSSystem::ThrottleActuator"

RTbuild/ACCSSystem/ThrottleSensor.gtg : $(ACCSSystem_ThrottleSensor_DEPS)
	$(RTGEN_CMD) -class "Logical View::ACCSSystem::ThrottleSensor"

RTbuild/ACCSSystem/WheelShaftSensor.gtg : $(ACCSSystem_WheelShaftSensor_DEPS)
	$(RTGEN_CMD) -class "Logical View::ACCSSystem::WheelShaftSensor"

RTbuild/ACCSSystem/LeverCommand.gtg : $(ACCSSystem_LeverCommand_DEPS)
	$(RTGEN_CMD) -class "Logical View::ACCSSystem::LeverCommand"

RTbuild/ACCSSystem/CurrentSpeed.gtg : $(ACCSSystem_CurrentSpeed_DEPS)
	$(RTGEN_CMD) -class "Logical View::ACCSSystem::CurrentSpeed"

RTbuild/ACCSSystem/Parameters.gtg : $(ACCSSystem_Parameters_DEPS)
	$(RTGEN_CMD) -class "Logical View::ACCSSystem::Parameters"

RTbuild/ACCSSystem/Voltage.gtg : $(ACCSSystem_Voltage_DEPS)
	$(RTGEN_CMD) -class "Logical View::ACCSSystem::Voltage"

RTbuild/ACCSSystem/InjectEventEngine.gtg : $(ACCSSystem_InjectEventEngine_DEPS)
	$(RTGEN_CMD) -class "Logical View::ACCSSystem::InjectEventEngine"

RTbuild/ACCSSystem/InjectEventTopGear.gtg : $(ACCSSystem_InjectEventTopGear_DEPS)
	$(RTGEN_CMD) -class "Logical View::ACCSSystem::InjectEventTopGear"

RTbuild/ACCSSystem/InjectEventBrake.gtg : $(ACCSSystem_InjectEventBrake_DEPS)
	$(RTGEN_CMD) -class "Logical View::ACCSSystem::InjectEventBrake"

RTbuild/ACCSSystem/InjectEventCommand.gtg : $(ACCSSystem_InjectEventCommand_DEPS)
	$(RTGEN_CMD) -class "Logical View::ACCSSystem::InjectEventCommand"

RTbuild/ACCSSystem/InjectEventFunctionParams.gtg : $(ACCSSystem_InjectEventFunctionParams_DEPS)
	$(RTGEN_CMD) -class "Logical View::ACCSSystem::InjectEventFunctionParams"

RTbuild/ACCSSystem/TmpBrake.gtg : $(ACCSSystem_TmpBrake_DEPS)
	$(RTGEN_CMD) -class "Logical View::ACCSSystem::TmpBrake"

RTbuild/ACCSSystem/TmpTopGear.gtg : $(ACCSSystem_TmpTopGear_DEPS)
	$(RTGEN_CMD) -class "Logical View::ACCSSystem::TmpTopGear"

RTbuild/ACCSSystem/TmpCommand.gtg : $(ACCSSystem_TmpCommand_DEPS)
	$(RTGEN_CMD) -class "Logical View::ACCSSystem::TmpCommand"

RTbuild/ACCSSystem/TmpManualParams.gtg : $(ACCSSystem_TmpManualParams_DEPS)
	$(RTGEN_CMD) -class "Logical View::ACCSSystem::TmpManualParams"

RTbuild/ACCSSystem/TmpFunctionParams.gtg : $(ACCSSystem_TmpFunctionParams_DEPS)
	$(RTGEN_CMD) -class "Logical View::ACCSSystem::TmpFunctionParams"

RTbuild/ACCSSystem/InjectEventManualParams.gtg : $(ACCSSystem_InjectEventManualParams_DEPS)
	$(RTGEN_CMD) -class "Logical View::ACCSSystem::InjectEventManualParams"

RTforce :
	$(NOP)
