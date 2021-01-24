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
	
	@Column
	private String connectionEvent;
	
	public LogEventConnection() {
		super(LogEventType.CONNECTION);
	}

	public LogEventConnection(String connectionEvent) {
		super(LogEventType.CONNECTION);
		
		this.connectionEvent = connectionEvent;
	}
	
	public String getConnectionEvent() {
		return connectionEvent;
	}

	public void setConnectionEvent(String connectionEvent) {
		this.connectionEvent = connectionEvent;
	}

}
