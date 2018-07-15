# Makefile for building component

PERL = rtperl
IN = $(PERL) "$(ROSERT_HOME)/codegen/chdir_run.pl"
NOP = $(PERL) "$(ROSERT_HOME)/codegen/nop.pl"
RM = $(PERL) "$(ROSERT_HOME)/codegen/rm.pl"
OUTPUT_CLASS_DIR = C:\CopyACCS/ACCSComponent
OUTPUT_JAR_FILEPATH = C:\CopyACCS/ACCSComponent.jar
CLEAN_CMD = $(RM) -f -R RTbuild C:\CopyACCS/ACCSComponent.jar
CMAKE = $(MAKE)
GMK_OPTS = -nologo
CMK_OPTS = -nologo
DMK_OPTS = $(GMK_OPTS)
RTGEN = rtjavagen
MODEL = C:\CopyACCS\ACCS.rtmdl
COMPONENT = Component View::ACCSComponent


# Targets for this component and all dependent components:

RTcompile : RTgenerate
	$(IN) "C:\CopyACCS/GUIComponent" $(MAKE) $(DMK_OPTS) RTcompile
	$(CMAKE) $(CMK_OPTS) -f RTbuild/RTcompile.mk RTcompile

RTgenerate :
	$(MAKE) $(GMK_OPTS) -f RTbuild/RTcodegen.mk RTgenerate
	$(IN) "C:\CopyACCS/GUIComponent" $(MAKE) $(DMK_OPTS) RTgenerate

RTcompileEach : RTgenerateEach
	$(IN) "C:\CopyACCS/GUIComponent" $(MAKE) $(DMK_OPTS) RTcompileEach
	$(CMAKE) $(CMK_OPTS) -f RTbuild/RTcompile.mk RTcompileEach

RTgenerateEach :
	$(MAKE) $(GMK_OPTS) -f RTbuild/RTcodegen.mk RTgenerateEach
	$(IN) "C:\CopyACCS/GUIComponent" $(MAKE) $(DMK_OPTS) RTgenerateEach

RTcleanall : RTmyclean
	$(IN) "C:\CopyACCS/GUIComponent" $(MAKE) $(DMK_OPTS) RTcleanall

# Targets for this component only:

RTmycompile :
	$(CMAKE) $(CMK_OPTS) -f RTbuild/RTcompile.mk RTcompile

RTmygenerate :
	$(MAKE) $(GMK_OPTS) -f RTbuild/RTcodegen.mk RTgenerate

RTmycompileEach :
	$(CMAKE) $(CMK_OPTS) -f RTbuild/RTcompile.mk RTcompileEach

RTmygenerateEach :
	$(MAKE) $(GMK_OPTS) -f RTbuild/RTcodegen.mk RTgenerateEach

RTmyclean :
	$(CLEAN_CMD)

# Target for updating Makefile if necessary:

RTmakefiles :
	$(RTGEN) -model "$(MODEL)" -component "$(COMPONENT)" -makegen
