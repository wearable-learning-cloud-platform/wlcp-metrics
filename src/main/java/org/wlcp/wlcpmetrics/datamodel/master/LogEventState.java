package org.wlcp.wlcpmetrics.datamodel.master;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Lob;

import org.wlcp.wlcpmetrics.datamodel.enums.LogEventType;

@Entity
@Table
@PrimaryKeyJoinColumn(referencedColumnName = "logEventId")
public class LogEventState extends LogEvent {
	
	@Column
	private String stateId;

	@Column
	@Lob
	private String componentProperties;
	
	@Column
	private String stateEvent;
	
	/*
	 @ElementCollection()
    @CollectionTable(name = "DISPLAY_TEXT_MAP")
    @MapKeyColumn(name = "SCOPE")
    @Column(name = "DISPLAY_TEXT", length = 2048)
	private Map<String, String> displayText = new HashMap<String, String>();
	 
	 */
	

	public LogEventState() {
		super(LogEventType.STATE);
	}

	public LogEventState(String stateId, String componentProperties, String stateEvent) {
		//this();
		super(LogEventType.STATE);
		this.stateId = stateId;
		this.componentProperties = componentProperties;
		this.stateEvent = stateEvent;
	}
	
	
	public String getStateId() {
		return stateId;
	}

	public void setStateId(String stateId) {
		this.stateId = stateId;
	}

	public String getComponentProperties() {
		return componentProperties;
	}

	public void setComponentProperties(String componentProperties) {
		this.componentProperties = componentProperties;
	}
	
	public String getStateEvent() {
		return stateEvent;
	}

	public void setStateEvent(String stateEvent) {
		this.stateEvent = stateEvent;
	}
	
}
