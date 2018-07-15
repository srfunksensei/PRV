# Makefile for building component

PERL = rtperl
IN = $(PERL) "$(ROSERT_HOME)/codegen/chdir_run.pl"
NOP = $(PERL) "$(ROSERT_HOME)/codegen/nop.pl"
RM = $(PERL) "$(ROSERT_HOME)/codegen/rm.pl"
OUTPUT_CLASS_DIR = C:\Documents and Settings\!Fantazio!\My Documents\ACCS/BrakeSensorComponent
OUTPUT_JAR_FILEPATH = C:\Documents and Settings\!Fantazio!\My Documents\ACCS/BrakeSensorComponent.jar
CLEAN_CMD = $(RM) -f -R RTbuild C:\Documents and Settings\!Fantazio!\My Documents\ACCS/BrakeSensorComponent.jar
CMAKE = $(MAKE)
GMK_OPTS = -nologo
CMK_OPTS = -nologo
DMK_OPTS = $(GMK_OPTS)
RTGEN = rtjavagen
MODEL = C:\Documents and Settings\!Fantazio!\My Documents\ACCS\ACCS.rtmdl
COMPONENT = Component View::BrakeSensorComponent


# Targets for this component and all dependent components:

RTcompile : RTgenerate
	$(CMAKE) $(CMK_OPTS) -f RTbuild/RTcompile.mk RTcompile

RTgenerate :
	$(MAKE) $(GMK_OPTS) -f RTbuild/RTcodegen.mk RTgenerate

RTcompileEach : RTgenerateEach
	$(CMAKE) $(CMK_OPTS) -f RTbuild/RTcompile.mk RTcompileEach

RTgenerateEach :
	$(MAKE) $(GMK_OPTS) -f RTbuild/RTcodegen.mk RTgenerateEach

RTcleanall : RTmyclean

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
