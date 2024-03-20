package org.wlcp.wlcpmetrics.datamodel.master.player;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Lob;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.wlcp.wlcpmetrics.datamodel.enums.player.LogEventGamePlayerClientType;
import org.wlcp.wlcpmetrics.datamodel.enums.player.LogEventGamePlayerType;

@Entity
@Table
@PrimaryKeyJoinColumn(referencedColumnName = "logEventGamePlayerId")
public class LogEventGamePlayerClientMessage extends LogEventGamePlayer {
	
	@Enumerated(EnumType.STRING)
	@Column
	private LogEventGamePlayerClientType logEventGamePlayerClientType;
	
	@Lob
	@Column(columnDefinition = "TEXT")
	private String message;
	
	public LogEventGamePlayerClientMessage() {
		super(LogEventGamePlayerType.CLIENT_MESSAGE);
	}
	
	public LogEventGamePlayerClientMessage(LogEventGamePlayerClientType logEventGamePlayerClientType) {
		super(LogEventGamePlayerType.CLIENT_MESSAGE);
		this.logEventGamePlayerClientType = logEventGamePlayerClientType;
	}

	public LogEventGamePlayerClientType getLogEventGamePlayerClientType() {
		return logEventGamePlayerClientType;
	}

	public void setLogEventGamePlayerClientType(LogEventGamePlayerClientType logEventGamePlayerClientType) {
		this.logEventGamePlayerClientType = logEventGamePlayerClientType;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
