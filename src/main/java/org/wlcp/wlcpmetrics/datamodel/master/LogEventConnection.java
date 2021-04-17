package org.wlcp.wlcpmetrics.datamodel.master;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.wlcp.wlcpmetrics.datamodel.enums.LogEventType;

@Entity
@Table
@PrimaryKeyJoinColumn(referencedColumnName = "logEventId")
public class LogEventConnection extends LogEvent {
	
	// Columns
	
	@Column
	private String connectionId;

	@Column
	private String connectionFrom;
	
	@Column
	private String connectionTo;
	
	@Column
	private String connectionTransition;

	@Column
	private String connectionEvent;
	
	
	// Constructors
	
	public LogEventConnection() {
		super(LogEventType.CONNECTION);
	}

	public LogEventConnection(
			String connectionId, 
			String connectionFrom, 
			String connectionTo, 
			String connectionTransition, 
			String connectionEvent
		) {
		
		super(LogEventType.CONNECTION);
		
		this.connectionId = connectionId;
		this.connectionFrom = connectionFrom;
		this.connectionTo = connectionTo;
		this.connectionTransition = connectionTransition;
		this.connectionEvent = connectionEvent;
	}
	
	
	// Getters and Setters
	
	public String getConnectionId() {
		return connectionId;
	}
	
	public void setConnectionId(String connectionId) {
		this.connectionId = connectionId;
	}

	public String getConnectionFrom() {
		return connectionFrom;
	}

	public void setConnectionFrom(String connectionFrom) {
		this.connectionFrom = connectionFrom;
	}

	public String getConnectionTo() {
		return connectionTo;
	}

	public void setConnectionTo(String connectionTo) {
		this.connectionTo = connectionTo;
	}
	
	public String getConnectionTransition() {
		return connectionTransition;
	}

	public void setConnectionTransition(String connectionTransition) {
		this.connectionTransition = connectionTransition;
	}
	
	public String getConnectionEvent() {
		return connectionEvent;
	}

	public void setConnectionEvent(String connectionEvent) {
		this.connectionEvent = connectionEvent;
	}

}
