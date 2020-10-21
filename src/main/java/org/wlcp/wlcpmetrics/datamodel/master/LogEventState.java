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
	
	public LogEventState() {
		super(LogEventType.STATE);
	}

	public LogEventState(String componentProperties) {
		this();
		this.componentProperties = componentProperties;
	}

	public String getComponentProperties() {
		return componentProperties;
	}

	public void setComponentProperties(String componentProperties) {
		this.componentProperties = componentProperties;
	}
	
}
