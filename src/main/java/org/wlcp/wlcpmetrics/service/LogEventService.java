package org.wlcp.wlcpmetrics.service;

import org.wlcp.wlcpmetrics.datamodel.master.LogEvent;

public interface LogEventService {
	
	void saveLogEvent(LogEvent logEvent);
	
}
