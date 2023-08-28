package org.wlcp.wlcpmetrics.datamodel.master.player;

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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.wlcp.wlcpmetrics.datamodel.enums.player.LogEventGamePlayerType;

import com.fasterxml.jackson.annotation.JsonIncludeProperties;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@Entity
@Table
@Inheritance(strategy = InheritanceType.JOINED)
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.EXISTING_PROPERTY, property="logEventGamePlayerType", defaultImpl=LogEventGamePlayer.class)
@JsonSubTypes({
	@Type(value = LogEventGamePlayerClientMessage.class, name="CLIENT_MESSAGE"), 
	@Type(value = LogEventGamePlayerServerMessage.class, name="SERVER_MESSAGE"),
	@Type(value = LogEventGamePlayerServerEvent.class, name="SERVER_EVENT"),
	@Type(value = LogEventGamePlayerCommunication.class, name="COMMUNICATION")
})
public abstract class LogEventGamePlayer {
	
	@Id
	@Column(name="logEventGamePlayerId")
	@GeneratedValue(strategy = GenerationType.IDENTITY )
	private Integer id;
	
	@Column
	@CreationTimestamp
	private Timestamp timestamp;
	
	@Enumerated(EnumType.STRING)
	@Column
	private LogEventGamePlayerType logEventGamePlayerType;
	
	@ManyToOne
	@JoinColumn(name = "logEventGameInstanceId")
	@JsonIncludeProperties(value = {"id"})
	private LogEventGameInstance logEventGameInstance;
	
	@Column
	private Integer team;
	
	@Column
	private Integer player;
	
	public LogEventGamePlayer(LogEventGamePlayerType logEventGamePlayerType) {
		this.logEventGamePlayerType = logEventGamePlayerType;
	}

	public Timestamp getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Timestamp timestamp) {
		this.timestamp = timestamp;
	}

	public LogEventGamePlayerType getLogEventGamePlayerType() {
		return logEventGamePlayerType;
	}

	public LogEventGameInstance getLogEventGameInstance() {
		return logEventGameInstance;
	}

	public void setLogEventGameInstance(LogEventGameInstance logEventGameInstance) {
		this.logEventGameInstance = logEventGameInstance;
	}

	public Integer getTeam() {
		return team;
	}

	public void setTeam(Integer team) {
		this.team = team;
	}

	public Integer getPlayer() {
		return player;
	}

	public void setPlayer(Integer player) {
		this.player = player;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setLogEventGamePlayerType(LogEventGamePlayerType logEventGamePlayerType) {
		this.logEventGamePlayerType = logEventGamePlayerType;
	}

	public Integer getId() {
		return id;
	}

}
