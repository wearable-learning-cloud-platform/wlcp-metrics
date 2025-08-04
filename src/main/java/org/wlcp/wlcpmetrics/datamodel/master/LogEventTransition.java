package org.wlcp.wlcpmetrics.datamodel.master;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Lob;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;

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
	private String transitionConnection;

	@Column
	private String transitionEvent;
	
	
	// Constructors
	
	public LogEventTransition() {
		super(LogEventType.TRANSITION);
	}
	
	public LogEventTransition(
			String transitionId, 
			String transitionProperties, 
			String transitionConnection, 
			String transitionEvent
		) {
		
		super(LogEventType.TRANSITION);
		
		this.transitionId = transitionId;
		this.transitionProperties = transitionProperties;
		this.transitionConnection = transitionConnection;
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
	
	public String getTransitionConnection() {
		return transitionConnection;
	}

	public void setTransitionConnection(String transitionConnection) {
		this.transitionConnection = transitionConnection;
	}
	
	public String getTransitionEvent() {
		return transitionEvent;
	}

	public void setTransitionEvent(String transitionEvent) {
		this.transitionEvent = transitionEvent;
	}

}
