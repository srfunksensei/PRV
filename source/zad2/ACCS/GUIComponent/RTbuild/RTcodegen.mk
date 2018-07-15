# RTcodegen.mk

MODEL = C:\CopyACCS\ACCS.rtmdl
COMPONENT = Component View::GUIComponent
RTJAVAGEN = rtjavagen
RTGEN_PROJ_FLAGS = -model "$(MODEL)" -component "$(COMPONENT)"
RTGEN_CMD = $(RTJAVAGEN) $(RTGEN_PROJ_FLAGS) $(RTGEN_USER_FLAGS)
PERL = rtperl
NOP = $(PERL) "$(ROSERT_HOME)/codegen/nop.pl"

ALL_GENERATION_TARGETS = \
	RTbuild/ACCSGUI/ACCSGUIPanel.gtg \
	RTbuild/ACCSGUI/ListenerA.gtg \
	RTbuild/ACCSGUI/ButtonEvent.gtg \
	RTbuild/ACCSGUI/ButtonValues.gtg \
	RTbuild/java/awt/event/MouseAdapter.gtg \
	RTbuild/ACCSSystem/FunctionParameters.gtg \
	RTbuild/ACCSSystem/ManualParameters.gtg \
	RTbuild/ACCSGUI/ListenerMP.gtg \
	RTbuild/ACCSGUI/ListenerFP.gtg

RTGENERATE_TARGET = RTbuild/RTproject.gtg
RTGENERATE_EACH_TARGET = $(ALL_GENERATION_TARGETS)


RTgenerate : $(RTGENERATE_TARGET)

RTgenerateEach : $(RTGENERATE_EACH_TARGET)

include RTbuild/ACCSGUI/ACCSGUIPanel.gmk
include RTbuild/ACCSGUI/ListenerA.gmk
include RTbuild/ACCSGUI/ButtonEvent.gmk
include RTbuild/ACCSGUI/ButtonValues.gmk
include RTbuild/java/awt/event/MouseAdapter.gmk
include RTbuild/ACCSSystem/FunctionParameters.gmk
include RTbuild/ACCSSystem/ManualParameters.gmk
include RTbuild/ACCSGUI/ListenerMP.gmk
include RTbuild/ACCSGUI/ListenerFP.gmk
include RTbuild/RTproject.gmk

RTbuild/RTproject.gtg : $(RTproject_DEPS)
	$(RTGEN_CMD)

RTbuild/ACCSGUI/ACCSGUIPanel.gtg : $(ACCSGUI_ACCSGUIPanel_DEPS)
	$(RTGEN_CMD) -class "Logical View::ACCSGUI::ACCSGUIPanel"

RTbuild/ACCSGUI/ListenerA.gtg : $(ACCSGUI_ListenerA_DEPS)
	$(RTGEN_CMD) -class "Logical View::ACCSGUI::ListenerA"

RTbuild/ACCSGUI/ButtonEvent.gtg : $(ACCSGUI_ButtonEvent_DEPS)
	$(RTGEN_CMD) -class "Logical View::ACCSGUI::ButtonEvent"

RTbuild/ACCSGUI/ButtonValues.gtg : $(ACCSGUI_ButtonValues_DEPS)
	$(RTGEN_CMD) -class "Logical View::ACCSGUI::ButtonValues"

RTbuild/java/awt/event/MouseAdapter.gtg : $(java_awt_event_MouseAdapter_DEPS)
	$(RTGEN_CMD) -class "Logical View::externalJava::java::awt::event::MouseAdapter"

RTbuild/ACCSSystem/FunctionParameters.gtg : $(ACCSSystem_FunctionParameters_DEPS)
	$(RTGEN_CMD) -class "Logical View::ACCSSystem::FunctionParameters"

RTbuild/ACCSSystem/ManualParameters.gtg : $(ACCSSystem_ManualParameters_DEPS)
	$(RTGEN_CMD) -class "Logical View::ACCSSystem::ManualParameters"

RTbuild/ACCSGUI/ListenerMP.gtg : $(ACCSGUI_ListenerMP_DEPS)
	$(RTGEN_CMD) -class "Logical View::ACCSGUI::ListenerMP"

RTbuild/ACCSGUI/ListenerFP.gtg : $(ACCSGUI_ListenerFP_DEPS)
	$(RTGEN_CMD) -class "Logical View::ACCSGUI::ListenerFP"

RTforce :
	$(NOP)
