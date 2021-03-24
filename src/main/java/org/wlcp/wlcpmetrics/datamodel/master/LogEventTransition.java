package org.wlcp.wlcpmetrics.datamodel.master;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.wlcp.wlcpmetrics.datamodel.enums.LogEventType;

@Entity
@Table
@PrimaryKeyJoinColumn(referencedColumnName = "logEventId")
public class LogEventTransition extends LogEvent {
	
	
	// Columns
	
	@Column
	private String transitionId;

	@Column
	@Lob
	private String transitionProperties;

	@Column
	private String transitionEvent;
	
	
	// Constructors
	
	public LogEventTransition() {
		super(LogEventType.TRANSITION);
	}
	
	public LogEventTransition(String transitionId, String transitionProperties, String transitionEvent) {
		super(LogEventType.TRANSITION);
		
		this.transitionId = transitionId;
		this.transitionProperties = transitionProperties;
		this.transitionEvent = transitionEvent;
	}
	
	
	// Getters and Setters
	
	public String getTransitionId() {
		return transitionId;
	}

	public void setTransitionId(String transitionId) {
		this.transitionId = transitionId;
	}
	
	public String getTransitionProperties() {
		return transitionProperties;
	}

	public void setTransitionProperties(String transitionProperties) {
		this.transitionProperties = transitionProperties;
	}
	
	public String getTransitionEvent() {
		return transitionEvent;
	}

	public void setTransitionEvent(String transitionEvent) {
		this.transitionEvent = transitionEvent;
	}

}
