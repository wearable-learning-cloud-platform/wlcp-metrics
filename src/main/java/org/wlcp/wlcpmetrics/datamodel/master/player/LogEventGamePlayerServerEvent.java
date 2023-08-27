package org.wlcp.wlcpmetrics.datamodel.master.player;

import javax.persistence.Column;
import javax.persistence.Entity;
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
	
	@Column
	private Integer state;
	
	@Column
	private Integer oldState;
	
	@Column
	private Boolean running;
	
	public LogEventGamePlayerServerEvent() {
		super(LogEventGamePlayerType.SERVER_EVENT);
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

}
