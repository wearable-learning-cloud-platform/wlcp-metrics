package org.wlcp.wlcpmetrics.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.wlcp.wlcpmetrics.datamodel.master.LogEvent;
import org.wlcp.wlcpmetrics.service.LogEventService;

@Controller
@RequestMapping("/logEventController")
public class LogEventController {
	
	@Autowired
	private LogEventService logEventService;
	
	@PostMapping("/saveLogEvent")
	public ResponseEntity<String> saveLogEvent(@RequestBody LogEvent logEvent) {
		logEventService.saveLogEvent(logEvent);
		return new ResponseEntity<String>("", HttpStatus.OK);
	}

}
