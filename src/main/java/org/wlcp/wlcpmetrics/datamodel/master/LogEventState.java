package org.wlcp.wlcpmetrics.datamodel.master;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.wlcp.wlcpmetrics.datamodel.enums.LogEventType;

@Entity
@Table
@PrimaryKeyJoinColumn(referencedColumnName = "logEventId")
public class LogEventState extends LogEvent {

	@Column
	private String componentProperties;
	
	@Column
	private String stateEvent;
	

	public LogEventState() {
		super(LogEventType.STATE);
	}

	public LogEventState(String componentProperties, String stateEvent) {
		//this();
		super(LogEventType.STATE);
		this.componentProperties = componentProperties;
		this.stateEvent = stateEvent;
	}
	

	public String getComponentProperties() {
		return componentProperties;
	}

	public void setComponentProperties(String componentProperties) {
		this.componentProperties = componentProperties;
	}
	
	public String getStateEvent() {
		return stateEvent;
	}

	public void setStateEvent(String stateEvent) {
		this.stateEvent = stateEvent;
	}
	
}
