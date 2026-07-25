package org.wlcp.wlcpmetrics.datamodel.master.player;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Lob;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;

import org.wlcp.wlcpmetrics.datamodel.enums.player.LogEventGamePlayerServerType;
import org.wlcp.wlcpmetrics.datamodel.enums.player.LogEventGamePlayerType;

@Entity
@Table
@PrimaryKeyJoinColumn(referencedColumnName = "logEventGamePlayerId")
public class LogEventGamePlayerServerMessage extends LogEventGamePlayer {
	
	@Enumerated(EnumType.STRING)
	@Column
	private LogEventGamePlayerServerType logEventGamePlayerServerType;
	
	@Lob
	@Column(columnDefinition = "TEXT")
	private String message;
	
	public LogEventGamePlayerServerMessage() {
		super(LogEventGamePlayerType.SERVER_MESSAGE);
	}
	
	public LogEventGamePlayerServerMessage(LogEventGamePlayerServerType logEventGamePlayerServerType) {
		super(LogEventGamePlayerType.SERVER_MESSAGE);
		this.logEventGamePlayerServerType = logEventGamePlayerServerType;
	}
	
	public LogEventGamePlayerServerType getLogEventGamePlayerServerType() {
		return logEventGamePlayerServerType;
	}

	public void setLogEventGamePlayerServerType(LogEventGamePlayerServerType logEventGamePlayerServerType) {
		this.logEventGamePlayerServerType = logEventGamePlayerServerType;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}	

}
