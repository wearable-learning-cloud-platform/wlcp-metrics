package org.wlcp.wlcpmetrics.datamodel.master.player;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
@Table
public class LogEventGameInstance {
	
	@Id
	@Column(name="logEventGameInstanceId")
	@GeneratedValue(strategy = GenerationType.IDENTITY )
	private Integer id;
	
	@Column
	private String gameId;
	
	@Column
	private String usernameId;
	
	@Column
	@CreationTimestamp
	private Timestamp start;
	
	@Column
	private Timestamp end;
	
	@Column
	private Long duration;
	
	@Column
	private Boolean debugInstance;
	
	@Column
	private Boolean gameEnded;
	
	//Communication
	@JoinTable(joinColumns = @JoinColumn(name = "logEventGameInstanceId", referencedColumnName = "logEventGameInstanceId"), inverseJoinColumns = @JoinColumn(name = "logEventGamePlayerId", referencedColumnName = "logEventGamePlayerId"))
	@OneToMany(orphanRemoval = true, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@Fetch(FetchMode.SELECT)
	private List<LogEventGamePlayerCommunication> gamePlayerCommunicationEvents = new ArrayList<LogEventGamePlayerCommunication>();
	
	//Client Messages
	@JoinTable(joinColumns = @JoinColumn(name = "logEventGameInstanceId", referencedColumnName = "logEventGameInstanceId"), inverseJoinColumns = @JoinColumn(name = "logEventGamePlayerId", referencedColumnName = "logEventGamePlayerId"))
	@OneToMany(orphanRemoval = true, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@Fetch(FetchMode.SELECT)
	private List<LogEventGamePlayerClientMessage> clientMessages = new ArrayList<LogEventGamePlayerClientMessage>();
	
	//Server Messages
	@JoinTable(joinColumns = @JoinColumn(name = "logEventGameInstanceId", referencedColumnName = "logEventGameInstanceId"), inverseJoinColumns = @JoinColumn(name = "logEventGamePlayerId", referencedColumnName = "logEventGamePlayerId"))
	@OneToMany(orphanRemoval = true, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@Fetch(FetchMode.SELECT)
	private List<LogEventGamePlayerServerMessage> serverMessages = new ArrayList<LogEventGamePlayerServerMessage>();
	
	//Server Events
	@JoinTable(joinColumns = @JoinColumn(name = "logEventGameInstanceId", referencedColumnName = "logEventGameInstanceId"), inverseJoinColumns = @JoinColumn(name = "logEventGamePlayerId", referencedColumnName = "logEventGamePlayerId"))
	@OneToMany(orphanRemoval = true, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@Fetch(FetchMode.SELECT)
	private List<LogEventGamePlayerServerEvent> serverEvents = new ArrayList<LogEventGamePlayerServerEvent>();
	

	public LogEventGameInstance() {

	}
	
	public LogEventGameInstance(String gameId, String usernameId, Boolean debugInstance) {
		super();
		this.gameId = gameId;
		this.usernameId = usernameId;
		this.debugInstance = debugInstance;
	}

	public String getGameId() {
		return gameId;
	}

	public void setGameId(String gameId) {
		this.gameId = gameId;
	}

	public String getUsernameId() {
		return usernameId;
	}

	public void setUsernameId(String usernameId) {
		this.usernameId = usernameId;
	}

	public Timestamp getStart() {
		return start;
	}

	public void setStart(Timestamp start) {
		this.start = start;
	}

	public Timestamp getEnd() {
		return end;
	}

	public void setEnd(Timestamp end) {
		this.end = end;
	}

	public Long getDuration() {
		return duration;
	}

	public void setDuration(Long duration) {
		this.duration = duration;
	}

	public Boolean getDebugInstance() {
		return debugInstance;
	}

	public void setDebugInstance(Boolean debugInstance) {
		this.debugInstance = debugInstance;
	}

	public Boolean getGameEnded() {
		return gameEnded;
	}

	public void setGameEnded(Boolean gameEnded) {
		this.gameEnded = gameEnded;
	}

	public List<LogEventGamePlayerCommunication> getGamePlayerCommunicationEvents() {
		return gamePlayerCommunicationEvents;
	}

	public void setGamePlayerCommunicationEvents(List<LogEventGamePlayerCommunication> gamePlayerCommunicationEvents) {
		this.gamePlayerCommunicationEvents = gamePlayerCommunicationEvents;
	}

	public List<LogEventGamePlayerClientMessage> getClientMessages() {
		return clientMessages;
	}

	public void setClientMessages(List<LogEventGamePlayerClientMessage> clientMessages) {
		this.clientMessages = clientMessages;
	}

	public List<LogEventGamePlayerServerMessage> getServerMessages() {
		return serverMessages;
	}

	public void setServerMessages(List<LogEventGamePlayerServerMessage> serverMessages) {
		this.serverMessages = serverMessages;
	}

	public List<LogEventGamePlayerServerEvent> getServerEvents() {
		return serverEvents;
	}

	public void setServerEvents(List<LogEventGamePlayerServerEvent> serverEvents) {
		this.serverEvents = serverEvents;
	}

	public Integer getId() {
		return id;
	}

}
