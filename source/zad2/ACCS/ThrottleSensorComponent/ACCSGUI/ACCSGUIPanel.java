package ACCSGUI;
// {{{RME classifier 'Logical View::ACCSGUI::ACCSGUIPanel'
public class ACCSGUIPanel extends javax.swing.JPanel
{
	// {{{RME classAttribute 'frame'
	private javax.swing.JFrame frame;
	// }}}RME
	// {{{RME classAttribute 'toggleBtnTopGear'
	private javax.swing.JToggleButton toggleBtnTopGear;
	// }}}RME
	// {{{RME classAttribute 'toggleBtnEngine'
	private javax.swing.JToggleButton toggleBtnEngine;
	// }}}RME
	// {{{RME classAttribute 'toggleBtnBrake'
	private javax.swing.JToggleButton toggleBtnBrake;
	// }}}RME
	// {{{RME classAttribute 'textFieldThrottleA'
	private javax.swing.JTextField textFieldThrottleA;
	// }}}RME
	// {{{RME classAttribute 'textFieldThrottle'
	private javax.swing.JTextField textFieldThrottle;
	// }}}RME
	// {{{RME classAttribute 'textFieldThrootleW'
	private javax.swing.JTextField textFieldThrootleW;
	// }}}RME
	// {{{RME classAttribute 'textFieldSpeedW'
	private javax.swing.JTextField textFieldSpeedW;
	// }}}RME
	// {{{RME classAttribute 'textFieldSpeedA'
	private javax.swing.JTextField textFieldSpeedA;
	// }}}RME
	// {{{RME classAttribute 'textFieldSpeed'
	private javax.swing.JTextField textFieldSpeed;
	// }}}RME
	// {{{RME classAttribute 'lblLastSavedSpeed'
	private javax.swing.JLabel lblLastSavedSpeed;
	// }}}RME
	// {{{RME classAttribute 'lblError'
	private javax.swing.JLabel lblError;
	// }}}RME
	// {{{RME classAttribute 'lblCurrSpped'
	private javax.swing.JLabel lblCurrSpped;
	// }}}RME
	// {{{RME classAttribute 'lblActualVoltage'
	private javax.swing.JLabel lblActualVoltage;
	// }}}RME
	// {{{RME classAttribute 'lblACCSVoltage'
	private javax.swing.JLabel lblACCSVoltage;
	// }}}RME
	// {{{RME classAttribute 'labelError'
	private javax.swing.JLabel labelError;
	// }}}RME
	// {{{RME classAttribute 'jSeparator7'
	private javax.swing.JSeparator jSeparator7;
	// }}}RME
	// {{{RME classAttribute 'jSeparator6'
	private javax.swing.JSeparator jSeparator6;
	// }}}RME
	// {{{RME classAttribute 'jSeparator5'
	private javax.swing.JSeparator jSeparator5;
	// }}}RME
	// {{{RME classAttribute 'jSeparator4'
	private javax.swing.JSeparator jSeparator4;
	// }}}RME
	// {{{RME classAttribute 'jSeparator3'
	private javax.swing.JSeparator jSeparator3;
	// }}}RME
	// {{{RME classAttribute 'jSeparator2'
	private javax.swing.JSeparator jSeparator2;
	// }}}RME
	// {{{RME classAttribute 'jSeparator1'
	private javax.swing.JSeparator jSeparator1;
	// }}}RME
	// {{{RME classAttribute 'jLabel9'
	private javax.swing.JLabel jLabel9;
	// }}}RME
	// {{{RME classAttribute 'jLabel8'
	private javax.swing.JLabel jLabel8;
	// }}}RME
	// {{{RME classAttribute 'jLabel7'
	private javax.swing.JLabel jLabel7;
	// }}}RME
	// {{{RME classAttribute 'jLabel6'
	private javax.swing.JLabel jLabel6;
	// }}}RME
	// {{{RME classAttribute 'jLabel5'
	private javax.swing.JLabel jLabel5;
	// }}}RME
	// {{{RME classAttribute 'jLabel4'
	private javax.swing.JLabel jLabel4;
	// }}}RME
	// {{{RME classAttribute 'jLabel3'
	private javax.swing.JLabel jLabel3;
	// }}}RME
	// {{{RME classAttribute 'jLabel22'
	private javax.swing.JLabel jLabel22;
	// }}}RME
	// {{{RME classAttribute 'jLabel21'
	private javax.swing.JLabel jLabel21;
	// }}}RME
	// {{{RME classAttribute 'jLabel20'
	private javax.swing.JLabel jLabel20;
	// }}}RME
	// {{{RME classAttribute 'jLabel2'
	private javax.swing.JLabel jLabel2;
	// }}}RME
	// {{{RME classAttribute 'jLabel19'
	private javax.swing.JLabel jLabel19;
	// }}}RME
	// {{{RME classAttribute 'jLabel18'
	private javax.swing.JLabel jLabel18;
	// }}}RME
	// {{{RME classAttribute 'jLabel17'
	private javax.swing.JLabel jLabel17;
	// }}}RME
	// {{{RME classAttribute 'jLabel16'
	private javax.swing.JLabel jLabel16;
	// }}}RME
	// {{{RME classAttribute 'jLabel15'
	private javax.swing.JLabel jLabel15;
	// }}}RME
	// {{{RME classAttribute 'jLabel14'
	private javax.swing.JLabel jLabel14;
	// }}}RME
	// {{{RME classAttribute 'jLabel13'
	private javax.swing.JLabel jLabel13;
	// }}}RME
	// {{{RME classAttribute 'jLabel12'
	private javax.swing.JLabel jLabel12;
	// }}}RME
	// {{{RME classAttribute 'jLabel11'
	private javax.swing.JLabel jLabel11;
	// }}}RME
	// {{{RME classAttribute 'jLabel10'
	private javax.swing.JLabel jLabel10;
	// }}}RME
	// {{{RME classAttribute 'jLabel1'
	private javax.swing.JLabel jLabel1;
	// }}}RME
	// {{{RME classAttribute 'btnSetThrottle'
	private javax.swing.JButton btnSetThrottle;
	// }}}RME
	// {{{RME classAttribute 'btnSetSpeed'
	private javax.swing.JButton btnSetSpeed;
	// }}}RME
	// {{{RME classAttribute 'btnSetManualThrottle'
	private javax.swing.JButton btnSetManualThrottle;
	// }}}RME
	// {{{RME classAttribute 'btnSetManualSpeed'
	private javax.swing.JButton btnSetManualSpeed;
	// }}}RME
	// {{{RME classAttribute 'btnCommandLeverSensorStopAcceleration'
	private javax.swing.JButton btnCommandLeverSensorStopAcceleration;
	// }}}RME
	// {{{RME classAttribute 'btnCommandLeverSensorStartAcceleration'
	private javax.swing.JButton btnCommandLeverSensorStartAcceleration;
	// }}}RME
	// {{{RME classAttribute 'btnCommandLeverSensorResume'
	private javax.swing.JButton btnCommandLeverSensorResume;
	// }}}RME
	// {{{RME classAttribute 'btnCommandLeverSensorDeactivate'
	private javax.swing.JButton btnCommandLeverSensorDeactivate;
	// }}}RME
	// {{{RME classAttribute 'btnCommandLeverSensorActivate'
	private javax.swing.JButton btnCommandLeverSensorActivate;
	// }}}RME
	// {{{RME classAttribute 'brakeApplied'
	private boolean brakeApplied = false;
	// }}}RME
	// {{{RME classAttribute 'topGearEngaged'
	private boolean topGearEngaged = false;
	// }}}RME
	// {{{RME classAttribute 'engineOn'
	private boolean engineOn = false;
	// }}}RME
	// {{{RME classAttribute 'commandResume'
	private static final int commandResume = 4;
	// }}}RME
	// {{{RME classAttribute 'commandStopAcc'
	private static final int commandStopAcc = 3;
	// }}}RME
	// {{{RME classAttribute 'commandStartAcc'
	private static final int commandStartAcc = 2;
	// }}}RME
	// {{{RME classAttribute 'commandDeactivate'
	private static final int commandDeactivate = 1;
	// }}}RME
	// {{{RME classAttribute 'commandActivate'
	private static final int commandActivate = 0;
	// }}}RME
	// {{{RME classAttribute 'strTopGearDisengaged'
	private static final String strTopGearDisengaged = "Disengage Top Gear";
	// }}}RME
	// {{{RME classAttribute 'strTopGearEngaged'
	private static final String strTopGearEngaged = "Engage Top Gear";
	// }}}RME
	// {{{RME classAttribute 'strReleaseBrake'
	private static final String strReleaseBrake = "Release Brake";
	// }}}RME
	// {{{RME classAttribute 'strApplyBrake'
	private static final String strApplyBrake = "Apply Brake";
	// }}}RME
	// {{{RME classAttribute 'strStopEngine'
	private static final String strStopEngine = "Stop Engine";
	// }}}RME
	// {{{RME classAttribute 'strStartEngine'
	private static final String strStartEngine = "Start Engine";
	// }}}RME
	// {{{RME operation 'ACCSGUIPanel()'
	public ACCSGUIPanel()
	{
		initComponents();

		// Create a new frame to hold the demo
		frame = new javax.swing.JFrame( "ACCS" );

		frame.setSize(1081, 487);
		frame.setResizable(false);


		frame.getContentPane().setLayout( new java.awt.BorderLayout() );
		frame.getContentPane().add( this, java.awt.BorderLayout.CENTER );

		// Create a window listener to deal with important window events
		java.awt.event.WindowListener l = new java.awt.event.WindowAdapter() 
		{
			public void windowClosing( java.awt.event.WindowEvent e )
			{
				System.exit( 0 );
			}
		};

		frame.addWindowListener( l );

		//frame.setSize( 1030, 447 );

		frame.validate();
		frame.show();
	}
	// }}}RME
	// {{{RME operation 'setManualSpeed(int)'
	public void setManualSpeed( int speed )
	{

	}
	// }}}RME
	// {{{RME operation 'setManualThrottle(int)'
	public void setManualThrottle( int voltage )
	{

	}
	// }}}RME
	// {{{RME operation 'setCommand(int)'
	public void setCommand( int command )
	{
		// TODO
				switch (command) {
					case commandActivate:
						break;
					case commandDeactivate:
						break;
					case commandStartAcc:
						break;
					case commandStopAcc:
						break;
					case commandResume:
						break;
				}
	}
	// }}}RME
	// {{{RME operation 'setTopGearOff()'
	public void setTopGearOff()
	{

	}
	// }}}RME
	// {{{RME operation 'setTopGearOn()'
	public void setTopGearOn()
	{

	}
	// }}}RME
	// {{{RME operation 'setBrakeOff()'
	public void setBrakeOff()
	{

	}
	// }}}RME
	// {{{RME operation 'setBrakeOn()'
	public void setBrakeOn()
	{

	}
	// }}}RME
	// {{{RME operation 'setEgineOff()'
	public void setEgineOff()
	{

	}
	// }}}RME
	// {{{RME operation 'setEgineOn()'
	public void setEgineOn()
	{

	}
	// }}}RME
	// {{{RME operation 'clearErrorMsg()'
	public void clearErrorMsg()
	{
		lblError.setText("");
	}
	// }}}RME
	// {{{RME operation 'setErrorMsg(String)'
	public void setErrorMsg( String msg )
	{
		lblError.setText(msg);
	}
	// }}}RME
	// {{{RME operation 'setActualVoltage(int)'
	public void setActualVoltage( int voltage )
	{
		double v = (double) voltage / 10.0;
				lblActualVoltage.setText("" + v + " V");
	}
	// }}}RME
	// {{{RME operation 'setACCSVoltage(int)'
	public void setACCSVoltage( int voltage )
	{
		double v = (double) voltage / 10.0;
				lblACCSVoltage.setText("" + v + " V");
	}
	// }}}RME
	// {{{RME operation 'setSavedSpped(int)'
	public void setSavedSpped( int speed )
	{
		lblLastSavedSpeed.setText("" + speed + " km/h");
	}
	// }}}RME
	// {{{RME operation 'setCurrentSpped(int)'
	public void setCurrentSpped( int speed )
	{
		lblCurrSpped.setText("" + speed);
	}
	// }}}RME
	// {{{RME operation 'canEngageTopGear(int)'
	public boolean canEngageTopGear( int currSpeed )
	{
		return currSpeed >= 105 || currSpeed <= 130;
	}
	// }}}RME
	// {{{RME operation 'setCommandLeverButtons(boolean)'
	public void setCommandLeverButtons( boolean checked )
	{
		btnCommandLeverSensorDeactivate.setEnabled(checked);
				btnCommandLeverSensorStartAcceleration.setEnabled(checked);
				btnCommandLeverSensorStopAcceleration.setEnabled(checked);
				btnCommandLeverSensorResume.setEnabled(checked);
	}
	// }}}RME
	// {{{RME operation 'btnSetThrottleActionPerformed(java.awt.event.ActionEvent)'
	public void btnSetThrottleActionPerformed( java.awt.event.ActionEvent evt )
	{

	}
	// }}}RME
	// {{{RME operation 'btnSetSpeedActionPerformed(java.awt.event.ActionEvent)'
	public void btnSetSpeedActionPerformed( java.awt.event.ActionEvent evt )
	{

	}
	// }}}RME
	// {{{RME operation 'btnSetManualThrottleActionPerformed(java.awt.event.ActionEvent)'
	public void btnSetManualThrottleActionPerformed( java.awt.event.ActionEvent evt )
	{

	}
	// }}}RME
	// {{{RME operation 'btnSetManualSpeedActionPerformed(java.awt.event.ActionEvent)'
	public void btnSetManualSpeedActionPerformed( java.awt.event.ActionEvent evt )
	{

	}
	// }}}RME
	// {{{RME operation 'toggleBtnBrakeActionPerformed(java.awt.event.ActionEvent)'
	public void toggleBtnBrakeActionPerformed( java.awt.event.ActionEvent evt )
	{
		brakeApplied = toggleBtnBrake.isSelected();

				if (brakeApplied) {
					toggleBtnBrake.setText(strReleaseBrake);
				} else {
					toggleBtnBrake.setText(strApplyBrake);
				}

				if (engineOn && topGearEngaged) {
					btnCommandLeverSensorActivate.setEnabled(!brakeApplied);
					setCommandLeverButtons(false);
				}
	}
	// }}}RME
	// {{{RME operation 'btnCommandLeverSensorResumeActionPerformed(java.awt.event.ActionEvent)'
	public void btnCommandLeverSensorResumeActionPerformed( java.awt.event.ActionEvent evt )
	{
		if(!btnCommandLeverSensorStartAcceleration.isEnabled()){
					btnCommandLeverSensorStartAcceleration.setEnabled(true);
					btnCommandLeverSensorStopAcceleration.setEnabled(false);
				}
	}
	// }}}RME
	// {{{RME operation 'btnCommandLeverSensorStopAccelerationActionPerformed(java.awt.event.ActionEvent)'
	public void btnCommandLeverSensorStopAccelerationActionPerformed( java.awt.event.ActionEvent evt )
	{
		btnCommandLeverSensorStartAcceleration.setEnabled(true);
				btnCommandLeverSensorStopAcceleration.setEnabled(false);

				// TODO:
	}
	// }}}RME
	// {{{RME operation 'btnCommandLeverSensorStartAccelerationActionPerformed(java.awt.event.ActionEvent)'
	public void btnCommandLeverSensorStartAccelerationActionPerformed( java.awt.event.ActionEvent evt )
	{
		 btnCommandLeverSensorStartAcceleration.setEnabled(false);
				btnCommandLeverSensorStopAcceleration.setEnabled(true);

				// TODO:
	}
	// }}}RME
	// {{{RME operation 'btnCommandLeverSensorDeactivateActionPerformed(java.awt.event.ActionEvent)'
	public void btnCommandLeverSensorDeactivateActionPerformed( java.awt.event.ActionEvent evt )
	{
		btnCommandLeverSensorActivate.setEnabled(true);
				setCommandLeverButtons(false);
	}
	// }}}RME
	// {{{RME operation 'btnCommandLeverSensorActivateActionPerformed(java.awt.event.ActionEvent)'
	public void btnCommandLeverSensorActivateActionPerformed( java.awt.event.ActionEvent evt )
	{
		btnCommandLeverSensorActivate.setEnabled(false);
				btnCommandLeverSensorDeactivate.setEnabled(true);
				btnCommandLeverSensorStartAcceleration.setEnabled(true);
				btnCommandLeverSensorResume.setEnabled(true);
	}
	// }}}RME
	// {{{RME operation 'toggleBtnTopGearActionPerformed(java.awt.event.ActionEvent)'
	public void toggleBtnTopGearActionPerformed( java.awt.event.ActionEvent evt )
	{
		topGearEngaged = toggleBtnTopGear.isSelected();

				if (topGearEngaged) {
					toggleBtnTopGear.setText(strTopGearDisengaged);
				} else {
					toggleBtnTopGear.setText(strTopGearEngaged);
				}

				if (engineOn) {
					btnCommandLeverSensorActivate.setEnabled(topGearEngaged);
					setCommandLeverButtons(false);
				}
	}
	// }}}RME
	// {{{RME operation 'toggleBtnEngineActionPerformed(java.awt.event.ActionEvent)'
	public void toggleBtnEngineActionPerformed( java.awt.event.ActionEvent evt )
	{
		if (toggleBtnTopGear.isSelected() || toggleBtnBrake.isSelected()) {
					setErrorMsg("Release brake or Disengage top gear to get engine started!");
				} else {
					clearErrorMsg();

					if (!engineOn) {
						toggleBtnEngine.setText(strStopEngine);
					} else {
						toggleBtnEngine.setText(strStartEngine);

						toggleBtnTopGear.setText(strTopGearEngaged);
						toggleBtnTopGear.setSelected(false);

						toggleBtnBrake.setText(strApplyBrake);
						toggleBtnBrake.setSelected(false);

						btnCommandLeverSensorActivate.setEnabled(false);
						setCommandLeverButtons(false);
					}

					engineOn = !engineOn;
				}
	}
	// }}}RME
	// {{{RME operation 'initComponents()'
	public void initComponents()
	{
		jSeparator7 = new javax.swing.JSeparator();
				jLabel14 = new javax.swing.JLabel();
				jLabel12 = new javax.swing.JLabel();
				jLabel13 = new javax.swing.JLabel();
				jLabel17 = new javax.swing.JLabel();
				jLabel15 = new javax.swing.JLabel();
				jLabel16 = new javax.swing.JLabel();
				jLabel20 = new javax.swing.JLabel();
				jLabel19 = new javax.swing.JLabel();
				textFieldSpeedW = new javax.swing.JTextField();
				jLabel18 = new javax.swing.JLabel();
				jLabel7 = new javax.swing.JLabel();
				jLabel6 = new javax.swing.JLabel();
				jSeparator6 = new javax.swing.JSeparator();
				jLabel8 = new javax.swing.JLabel();
				textFieldSpeed = new javax.swing.JTextField();
				textFieldThrottle = new javax.swing.JTextField();
				jLabel9 = new javax.swing.JLabel();
				btnCommandLeverSensorActivate = new javax.swing.JButton();
				textFieldSpeedA = new javax.swing.JTextField();
				btnCommandLeverSensorResume = new javax.swing.JButton();
				btnCommandLeverSensorStopAcceleration = new javax.swing.JButton();
				jLabel11 = new javax.swing.JLabel();
				btnCommandLeverSensorStartAcceleration = new javax.swing.JButton();
				jLabel10 = new javax.swing.JLabel();
				btnCommandLeverSensorDeactivate = new javax.swing.JButton();
				jSeparator1 = new javax.swing.JSeparator();
				jLabel1 = new javax.swing.JLabel();
				jLabel5 = new javax.swing.JLabel();
				btnSetManualSpeed = new javax.swing.JButton();
				toggleBtnTopGear = new javax.swing.JToggleButton();
				jSeparator3 = new javax.swing.JSeparator();
				toggleBtnEngine = new javax.swing.JToggleButton();
				toggleBtnBrake = new javax.swing.JToggleButton();
				jLabel4 = new javax.swing.JLabel();
				jSeparator4 = new javax.swing.JSeparator();
				jSeparator2 = new javax.swing.JSeparator();
				jLabel3 = new javax.swing.JLabel();
				jSeparator5 = new javax.swing.JSeparator();
				lblCurrSpped = new javax.swing.JLabel();
				lblACCSVoltage = new javax.swing.JLabel();
				lblLastSavedSpeed = new javax.swing.JLabel();
				jLabel21 = new javax.swing.JLabel();
				textFieldThrottleA = new javax.swing.JTextField();
				jLabel22 = new javax.swing.JLabel();
				textFieldThrootleW = new javax.swing.JTextField();
				jLabel2 = new javax.swing.JLabel();
				btnSetSpeed = new javax.swing.JButton();
				btnSetThrottle = new javax.swing.JButton();
				btnSetManualThrottle = new javax.swing.JButton();
				lblActualVoltage = new javax.swing.JLabel();
				lblError = new javax.swing.JLabel();

				jLabel14.setText("Last saved speed:");

				jLabel12.setText("V");

				jLabel13.setFont(new java.awt.Font("Tahoma", 1, 14));
				jLabel13.setText("Values from ACCS");

				jLabel17.setText("Error message:");

				jLabel15.setText("ACCS voltage:");

				jLabel16.setText("Actual voltage:");

				jLabel20.setText("Throttle");

				jLabel19.setText("*t)");

				textFieldSpeedW.setHorizontalAlignment(javax.swing.JTextField.CENTER);
				textFieldSpeedW.setText("0.005");

				jLabel18.setText("*sin(");

				jLabel7.setFont(new java.awt.Font("Tahoma", 2, 48));
				jLabel7.setText("km/h");

				jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14));
				jLabel6.setText("Parameters");

				jLabel8.setText("Set Speed");

				textFieldSpeed.setHorizontalAlignment(javax.swing.JTextField.TRAILING);

				textFieldThrottle.setHorizontalAlignment(javax.swing.JTextField.TRAILING);

				jLabel9.setText("Set Throttle");

				btnCommandLeverSensorActivate.setText("Activate");
				btnCommandLeverSensorActivate.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
				btnCommandLeverSensorActivate.setEnabled(false);
				btnCommandLeverSensorActivate.setMaximumSize(new java.awt.Dimension(119, 23));
				btnCommandLeverSensorActivate.setMinimumSize(new java.awt.Dimension(119, 23));
				btnCommandLeverSensorActivate.setPreferredSize(new java.awt.Dimension(119, 23));
				btnCommandLeverSensorActivate.addActionListener(new java.awt.event.ActionListener() {
					public void actionPerformed(java.awt.event.ActionEvent evt) {
						btnCommandLeverSensorActivateActionPerformed(evt);
					}
				});

				textFieldSpeedA.setHorizontalAlignment(javax.swing.JTextField.CENTER);
				textFieldSpeedA.setText("200");
				textFieldSpeedA.setMaximumSize(new java.awt.Dimension(24, 20));
				textFieldSpeedA.setMinimumSize(new java.awt.Dimension(24, 20));

				btnCommandLeverSensorResume.setText("Resume");
				btnCommandLeverSensorResume.setEnabled(false);
				btnCommandLeverSensorResume.setMaximumSize(new java.awt.Dimension(119, 23));
				btnCommandLeverSensorResume.setMinimumSize(new java.awt.Dimension(119, 23));
				btnCommandLeverSensorResume.setPreferredSize(new java.awt.Dimension(119, 23));
				btnCommandLeverSensorResume.addActionListener(new java.awt.event.ActionListener() {
					public void actionPerformed(java.awt.event.ActionEvent evt) {
						btnCommandLeverSensorResumeActionPerformed(evt);
					}
				});

				btnCommandLeverSensorStopAcceleration.setText("Stop Acceleration");
				btnCommandLeverSensorStopAcceleration.setEnabled(false);
				btnCommandLeverSensorStopAcceleration.setMaximumSize(new java.awt.Dimension(119, 23));
				btnCommandLeverSensorStopAcceleration.setMinimumSize(new java.awt.Dimension(119, 23));
				btnCommandLeverSensorStopAcceleration.setPreferredSize(new java.awt.Dimension(119, 23));
				btnCommandLeverSensorStopAcceleration.addActionListener(new java.awt.event.ActionListener() {
					public void actionPerformed(java.awt.event.ActionEvent evt) {
						btnCommandLeverSensorStopAccelerationActionPerformed(evt);
					}
				});

				jLabel11.setText("km/h");

				btnCommandLeverSensorStartAcceleration.setText("Start Acceleration");
				btnCommandLeverSensorStartAcceleration.setEnabled(false);
				btnCommandLeverSensorStartAcceleration.addActionListener(new java.awt.event.ActionListener() {
					public void actionPerformed(java.awt.event.ActionEvent evt) {
						btnCommandLeverSensorStartAccelerationActionPerformed(evt);
					}
				});

				jLabel10.setText("Speed");

				btnCommandLeverSensorDeactivate.setText("Deactivate");
				btnCommandLeverSensorDeactivate.setEnabled(false);
				btnCommandLeverSensorDeactivate.setMaximumSize(new java.awt.Dimension(119, 23));
				btnCommandLeverSensorDeactivate.setMinimumSize(new java.awt.Dimension(119, 23));
				btnCommandLeverSensorDeactivate.setPreferredSize(new java.awt.Dimension(119, 23));
				btnCommandLeverSensorDeactivate.addActionListener(new java.awt.event.ActionListener() {
					public void actionPerformed(java.awt.event.ActionEvent evt) {
						btnCommandLeverSensorDeactivateActionPerformed(evt);
					}
				});

				jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14));
				jLabel1.setText("Command Lever Sensor");

				jLabel5.setFont(new java.awt.Font("Tahoma", 2, 48));
				jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
				jLabel5.setText("Current Speed");
				jLabel5.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
				jLabel5.setFocusable(false);
				jLabel5.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);

				btnSetManualSpeed.setText("Set");
				btnSetManualSpeed.addActionListener(new java.awt.event.ActionListener() {
					public void actionPerformed(java.awt.event.ActionEvent evt) {
						btnSetManualSpeedActionPerformed(evt);
					}
				});

				toggleBtnTopGear.setText("Engage Top Gear");
				toggleBtnTopGear.setMaximumSize(new java.awt.Dimension(119, 23));
				toggleBtnTopGear.setMinimumSize(new java.awt.Dimension(119, 23));
				toggleBtnTopGear.setPreferredSize(new java.awt.Dimension(119, 23));
				toggleBtnTopGear.addActionListener(new java.awt.event.ActionListener() {
					public void actionPerformed(java.awt.event.ActionEvent evt) {
						toggleBtnTopGearActionPerformed(evt);
					}
				});

				jSeparator3.setMaximumSize(new java.awt.Dimension(50, 10));

				toggleBtnEngine.setText("Start Engine");
				toggleBtnEngine.setMaximumSize(new java.awt.Dimension(119, 23));
				toggleBtnEngine.setMinimumSize(new java.awt.Dimension(119, 23));
				toggleBtnEngine.setPreferredSize(new java.awt.Dimension(119, 23));
				toggleBtnEngine.addActionListener(new java.awt.event.ActionListener() {
					public void actionPerformed(java.awt.event.ActionEvent evt) {
						toggleBtnEngineActionPerformed(evt);
					}
				});

				toggleBtnBrake.setText("Apply Brake");
				toggleBtnBrake.setMaximumSize(new java.awt.Dimension(119, 23));
				toggleBtnBrake.setMinimumSize(new java.awt.Dimension(119, 23));
				toggleBtnBrake.setOpaque(true);
				toggleBtnBrake.setPreferredSize(new java.awt.Dimension(119, 23));
				toggleBtnBrake.addActionListener(new java.awt.event.ActionListener() {
					public void actionPerformed(java.awt.event.ActionEvent evt) {
						toggleBtnBrakeActionPerformed(evt);
					}
				});

				jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14));
				jLabel4.setText("Top Gear");

				jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14));
				jLabel3.setText("Brake");

				lblCurrSpped.setFont(new java.awt.Font("Tahoma", 1, 48));
				lblCurrSpped.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
				lblCurrSpped.setText("0");

				lblACCSVoltage.setText("0 V");

				lblLastSavedSpeed.setText("140 km/h");

				jLabel21.setText("*cos(");

				textFieldThrottleA.setHorizontalAlignment(javax.swing.JTextField.CENTER);
				textFieldThrottleA.setText("80");
				textFieldThrottleA.setMaximumSize(new java.awt.Dimension(24, 20));
				textFieldThrottleA.setMinimumSize(new java.awt.Dimension(24, 20));
				textFieldThrottleA.setPreferredSize(new java.awt.Dimension(24, 20));

				jLabel22.setText("*t)");

				textFieldThrootleW.setHorizontalAlignment(javax.swing.JTextField.CENTER);
				textFieldThrootleW.setText("0.005");

				jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14));
				jLabel2.setText("Engine");

				btnSetSpeed.setText("Set");
				btnSetSpeed.addActionListener(new java.awt.event.ActionListener() {
					public void actionPerformed(java.awt.event.ActionEvent evt) {
						btnSetSpeedActionPerformed(evt);
					}
				});

				btnSetThrottle.setText("Set");
				btnSetThrottle.addActionListener(new java.awt.event.ActionListener() {
					public void actionPerformed(java.awt.event.ActionEvent evt) {
						btnSetThrottleActionPerformed(evt);
					}
				});

				btnSetManualThrottle.setText("Set");
				btnSetManualThrottle.addActionListener(new java.awt.event.ActionListener() {
					public void actionPerformed(java.awt.event.ActionEvent evt) {
						btnSetManualThrottleActionPerformed(evt);
					}
				});

				lblActualVoltage.setText("0 V");

				javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
				this.setLayout(layout);
				layout.setHorizontalGroup(
					layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
					.addGroup(layout.createSequentialGroup()
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
							.addGroup(layout.createSequentialGroup()
								.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
									.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
										.addGroup(layout.createSequentialGroup()
											.addGap(25, 25, 25)
											.addComponent(toggleBtnEngine, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
										.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
											.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
												.addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.LEADING)
												.addComponent(jSeparator4, javax.swing.GroupLayout.Alignment.LEADING)
												.addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 187, Short.MAX_VALUE)
												.addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
													.addGap(27, 27, 27)
													.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
														.addComponent(btnCommandLeverSensorDeactivate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
														.addComponent(btnCommandLeverSensorActivate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
														.addComponent(btnCommandLeverSensorStopAcceleration, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
														.addComponent(btnCommandLeverSensorResume, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
														.addComponent(btnCommandLeverSensorStartAcceleration))))
											.addGap(75, 75, 75)))
									.addGroup(layout.createSequentialGroup()
										.addContainerGap()
										.addComponent(jLabel1))
									.addGroup(layout.createSequentialGroup()
										.addContainerGap()
										.addComponent(jLabel4))
									.addGroup(layout.createSequentialGroup()
										.addGap(20, 20, 20)
										.addComponent(jLabel3))
									.addGroup(layout.createSequentialGroup()
										.addGap(22, 22, 22)
										.addComponent(toggleBtnTopGear, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
									.addGroup(layout.createSequentialGroup()
										.addContainerGap()
										.addComponent(jLabel2)))
								.addGap(31, 31, 31)
								.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
									.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
										.addGroup(layout.createSequentialGroup()
											.addComponent(lblCurrSpped, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
											.addGap(18, 18, 18)
											.addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
										.addComponent(jSeparator5, javax.swing.GroupLayout.DEFAULT_SIZE, 319, Short.MAX_VALUE)
										.addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 319, Short.MAX_VALUE)
										.addComponent(jSeparator7, javax.swing.GroupLayout.DEFAULT_SIZE, 319, Short.MAX_VALUE)
										.addGroup(layout.createSequentialGroup()
											.addGap(10, 10, 10)
											.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
												.addComponent(jLabel14)
												.addComponent(jLabel15)
												.addComponent(jLabel16)
												.addComponent(jLabel17))
											.addGap(18, 18, 18)
											.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
												.addComponent(lblError)
												.addComponent(lblActualVoltage)
												.addComponent(lblACCSVoltage)
												.addComponent(lblLastSavedSpeed))))
									.addGroup(layout.createSequentialGroup()
										.addGap(50, 50, 50)
										.addComponent(jLabel13)))
								.addGap(143, 143, 143)
								.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
									.addComponent(jLabel6)
									.addComponent(jSeparator6, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
									.addGroup(layout.createSequentialGroup()
										.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
											.addComponent(jLabel8)
											.addComponent(jLabel9)
											.addComponent(jLabel10)
											.addComponent(jLabel20))
										.addGap(18, 18, 18)
										.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
											.addComponent(textFieldSpeed)
											.addComponent(textFieldThrottle)
											.addComponent(textFieldThrottleA, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
											.addComponent(textFieldSpeedA, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
											.addComponent(jLabel11)
											.addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
											.addGroup(layout.createSequentialGroup()
												.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
													.addComponent(jLabel18)
													.addComponent(jLabel21))
												.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
												.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
													.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
														.addComponent(textFieldThrootleW)
														.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
														.addComponent(jLabel22))
													.addGroup(layout.createSequentialGroup()
														.addComponent(textFieldSpeedW, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
														.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
														.addComponent(jLabel19)))))
										.addGap(18, 18, 18)
										.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
											.addComponent(btnSetManualSpeed)
											.addComponent(btnSetManualThrottle)
											.addComponent(btnSetThrottle)
											.addComponent(btnSetSpeed)))))
							.addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
							.addGroup(layout.createSequentialGroup()
								.addGap(28, 28, 28)
								.addComponent(toggleBtnBrake, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)))
						.addContainerGap())
				);
				layout.setVerticalGroup(
					layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
					.addGroup(layout.createSequentialGroup()
						.addContainerGap()
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
							.addGroup(layout.createSequentialGroup()
								.addComponent(jLabel2)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(toggleBtnEngine, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addGap(18, 18, 18)
								.addComponent(jLabel4)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(toggleBtnTopGear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addGap(22, 22, 22)
								.addComponent(jLabel1)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(btnCommandLeverSensorActivate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(btnCommandLeverSensorDeactivate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(btnCommandLeverSensorStartAcceleration)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(btnCommandLeverSensorStopAcceleration, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(btnCommandLeverSensorResume, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addGap(18, 18, 18)
								.addComponent(jLabel3)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(toggleBtnBrake, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
							.addGroup(layout.createSequentialGroup()
								.addComponent(jLabel6)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
									.addGroup(layout.createSequentialGroup()
										.addComponent(jLabel5)
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
											.addComponent(lblCurrSpped, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
											.addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
										.addGap(18, 18, 18)
										.addComponent(jLabel13)
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(jSeparator7, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
											.addComponent(jLabel14)
											.addComponent(lblLastSavedSpeed))
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
										.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
											.addComponent(jLabel15)
											.addComponent(lblACCSVoltage))
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
										.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
											.addComponent(jLabel16)
											.addComponent(lblActualVoltage))
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
										.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
											.addComponent(jLabel17)
											.addComponent(lblError)))
									.addGroup(layout.createSequentialGroup()
										.addComponent(jSeparator6, javax.swing.GroupLayout.PREFERRED_SIZE, 5, javax.swing.GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
										.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
											.addComponent(jLabel8)
											.addComponent(textFieldSpeed, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
											.addComponent(jLabel11)
											.addComponent(btnSetManualSpeed))
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
											.addComponent(textFieldThrottle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
											.addComponent(jLabel9)
											.addComponent(jLabel12)
											.addComponent(btnSetManualThrottle))
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
											.addComponent(textFieldSpeedA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
											.addComponent(jLabel18)
											.addComponent(textFieldSpeedW, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
											.addComponent(jLabel19)
											.addComponent(jLabel10)
											.addComponent(btnSetSpeed))
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
											.addComponent(jLabel20)
											.addComponent(textFieldThrottleA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
											.addComponent(jLabel21)
											.addComponent(textFieldThrootleW, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
											.addComponent(jLabel22)
											.addComponent(btnSetThrottle))))))
						.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
				);
	}
	// }}}RME
}
// }}}RME
