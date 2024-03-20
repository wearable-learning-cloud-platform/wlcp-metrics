package org.wlcp.wlcpmetrics.datamodel.master.player;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.wlcp.wlcpmetrics.datamodel.enums.player.LogEventGamePlayerType;

@Entity
@Table
@PrimaryKeyJoinColumn(referencedColumnName = "logEventGamePlayerId")
public class LogEventGamePlayerServerEvent extends LogEventGamePlayer {
	
	public enum Type {
		STATE,
		TRANSITION
	}
	
	public enum Event {
		ENTER,
		EXIT
	}
	
	@Enumerated(EnumType.STRING)
	@Column
	private Type type;
	
	@Enumerated(EnumType.STRING)
	@Column
	private Event event;
	
	@Column
	private Integer state;
	
	@Column
	private Integer oldState;
	
	@Column
	private Boolean running;
	
	@Column
	private String stateName;
	
	public LogEventGamePlayerServerEvent() {
		super(LogEventGamePlayerType.SERVER_EVENT);
	}
	
	public LogEventGamePlayerServerEvent(LogEventGamePlayerType logEventGamePlayerType, Type type, Event event,
			Integer state, Integer oldState, Boolean running, String stateName) {
		super(LogEventGamePlayerType.SERVER_EVENT);
		this.type = type;
		this.event = event;
		this.state = state;
		this.oldState = oldState;
		this.running = running;
		this.stateName = stateName;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public Event getEvent() {
		return event;
	}

	public void setEvent(Event event) {
		this.event = event;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public Integer getOldState() {
		return oldState;
	}

	public void setOldState(Integer oldState) {
		this.oldState = oldState;
	}

	public Boolean getRunning() {
		return running;
	}

	public void setRunning(Boolean running) {
		this.running = running;
	}

	public String getStateName() {
		return stateName;
	}

	public void setStateName(String stateName) {
		this.stateName = stateName;
	}

}
