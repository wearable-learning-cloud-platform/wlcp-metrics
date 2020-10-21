package org.wlcp.wlcpmetrics.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.wlcp.wlcpmetrics.datamodel.master.LogEvent;
import org.wlcp.wlcpmetrics.respository.LogEventRepository;
import org.wlcp.wlcpmetrics.service.LogEventService;

@Service
public class LogEventServiceImpl implements LogEventService {
	
	@Autowired
	private LogEventRepository logEventRepository;

	@Override
	public void saveLogEvent(LogEvent logEvent) {
		logEventRepository.save(logEvent);
	}

}
