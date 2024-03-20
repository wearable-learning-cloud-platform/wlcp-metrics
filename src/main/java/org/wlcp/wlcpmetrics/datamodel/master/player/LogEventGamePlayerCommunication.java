package org.wlcp.wlcpmetrics.datamodel.master.player;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Lob;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.wlcp.wlcpmetrics.datamodel.enums.player.LogEventGamePlayerType;

@Entity
@Table
@PrimaryKeyJoinColumn(referencedColumnName = "logEventGamePlayerId")
public class LogEventGamePlayerCommunication extends LogEventGamePlayer {
	
	public enum DataDirection {
		CLIENT_RECEIVE,
		CLIENT_SEND,
		SERVER_RECEIVE,
		SERVER_SEND
	}
	
	public enum Output {
		NONE,
		DISPLAY_TEXT,
		DISPLAY_PHOTO,
		PLAY_SOUND,
		PLAY_VIDEO
	}
	
	public enum Input {
		NONE,
		SINGLE_BUTTON_PRESS,
		SEQUENCE_BUTTON_PRESS,
	    KEYBOARD_INPUT,
	    TIMER,
	    RANDOM
	}
	
	@Enumerated(EnumType.STRING)
	@Column
	private DataDirection dataDirection;
	
	@Enumerated(EnumType.STRING)
	@Column
	private Output output;
	
	@Enumerated(EnumType.STRING)
	@Column
	private Input input;
	
	@Lob
	@Column(columnDefinition = "TEXT")
	private String data;
	
	public LogEventGamePlayerCommunication() {
		super(LogEventGamePlayerType.COMMUNICATION);
	}

	public DataDirection getDataDirection() {
		return dataDirection;
	}

	public void setDataDirection(DataDirection dataDirection) {
		this.dataDirection = dataDirection;
	}

	public Output getOutput() {
		return output;
	}

	public void setOutput(Output output) {
		this.output = output;
	}

	public Input getInput() {
		return input;
	}

	public void setInput(Input input) {
		this.input = input;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

}
