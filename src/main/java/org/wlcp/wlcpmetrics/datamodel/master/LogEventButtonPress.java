package org.wlcp.wlcpmetrics.datamodel.master;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.wlcp.wlcpmetrics.datamodel.enums.LogEventType;

@Entity
@Table
@PrimaryKeyJoinColumn(referencedColumnName = "logEventId")
public class LogEventButtonPress extends LogEvent {
	
	public LogEventButtonPress() {
		super(LogEventType.BUTTON_PRESS);
	}

}
