package org.wlcp.wlcpmetrics.datamodel.master;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

import org.wlcp.wlcpmetrics.datamodel.enums.LogContext;
import org.wlcp.wlcpmetrics.datamodel.enums.LogEventType;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@Entity
@Table
@Inheritance(strategy = InheritanceType.JOINED)
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property="logEventType", defaultImpl=LogEvent.class)
@JsonSubTypes({@Type(value = LogEventState.class, name="STATE")})
public abstract class LogEvent {
	
	@Id()
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column
	private Integer logEventId;
	
	@Enumerated(EnumType.ORDINAL)
	@Column
	private LogEventType logEventType;
	
	@Enumerated(EnumType.ORDINAL)
	@Column
	private LogContext logContext;
	
	@Column
	private String usernameId;
	
	@Column
	private String gameId;
	
	@Column
	private String gameInstanceId;
	
	@Column
	private Timestamp timeStamp;
	
	public LogEvent(LogEventType logEventType) {
		this.logEventType = logEventType;
	}

	public LogEvent(LogEventType logEventType, LogContext logContext, String usernameId, String gameId,
			String gameInstanceId, Timestamp timeStamp) {
		super();
		this.logEventType = logEventType;
		this.logContext = logContext;
		this.usernameId = usernameId;
		this.gameId = gameId;
		this.gameInstanceId = gameInstanceId;
		this.timeStamp = timeStamp;
	}

	public LogEventType getLogEventType() {
		return logEventType;
	}

	public void setLogEventType(LogEventType logEventType) {
		this.logEventType = logEventType;
	}

	public LogContext getLogContext() {
		return logContext;
	}

	public void setLogContext(LogContext logContext) {
		this.logContext = logContext;
	}

	public String getUsernameId() {
		return usernameId;
	}

	public void setUsernameId(String usernameId) {
		this.usernameId = usernameId;
	}

	public String getGameId() {
		return gameId;
	}

	public void setGameId(String gameId) {
		this.gameId = gameId;
	}

	public String getGameInstanceId() {
		return gameInstanceId;
	}

	public void setGameInstanceId(String gameInstanceId) {
		this.gameInstanceId = gameInstanceId;
	}

	public Timestamp getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(Timestamp timeStamp) {
		this.timeStamp = timeStamp;
	}

	public Integer getLogEventId() {
		return logEventId;
	}

}
