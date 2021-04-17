package org.wlcp.wlcpmetrics.datamodel.master;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.wlcp.wlcpmetrics.datamodel.enums.LogEventType;

@Entity
@Table
@PrimaryKeyJoinColumn(referencedColumnName = "logEventId")
public class LogEventButtonPress extends LogEvent {
	
	@Column
	private String buttonPressed;
	
	public LogEventButtonPress() {
		super(LogEventType.BUTTON_PRESS);
	}
	
	
	public LogEventButtonPress(String buttonPressed) {
		super(LogEventType.BUTTON_PRESS);
		
		this.buttonPressed = buttonPressed;
	}
	
	
	public void setButtonPressed(String buttonPressed) {
		this.buttonPressed = buttonPressed;
	}
	
	public String getButtonPressed() {
		return buttonPressed;
	}
	
	
}
