package org.wlcp.wlcpmetrics.datamodel.master;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.wlcp.wlcpmetrics.datamodel.enums.LogEventType;

@Entity
@Table
@PrimaryKeyJoinColumn(referencedColumnName = "logEventId")
public class LogEventTransition extends LogEvent {
	
	@Column
	private String transitionEvent;
	
	public LogEventTransition() {
		super(LogEventType.TRANSITION);
	}
	
	public LogEventTransition(String transitionEvent) {
		super(LogEventType.TRANSITION);
		
		this.transitionEvent = transitionEvent;
	}
	
	public String getTransitionEvent() {
		return transitionEvent;
	}

	public void setTransitionEvent(String transitionEvent) {
		this.transitionEvent = transitionEvent;
	}

}
