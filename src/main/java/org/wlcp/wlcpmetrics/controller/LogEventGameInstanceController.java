package org.wlcp.wlcpmetrics.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.wlcp.wlcpmetrics.datamodel.master.player.LogEventGameInstance;
import org.wlcp.wlcpmetrics.datamodel.master.player.LogEventGamePlayer;
import org.wlcp.wlcpmetrics.dto.StartLoggingGameInstanceDto;
import org.wlcp.wlcpmetrics.service.LogEventGameInstanceService;

@Controller
@RequestMapping("/logEventGameInstanceController")
public class LogEventGameInstanceController {
	
	@Autowired
	private LogEventGameInstanceService logEventGameInstanceService;
	
	@GetMapping("/get/{logEventGameInstanceId}")
	public ResponseEntity<LogEventGameInstance> getLogEventGameInstance(@PathVariable Integer logEventGameInstanceId) {
		return new ResponseEntity<LogEventGameInstance>(logEventGameInstanceService.getLogEventGameInstance(logEventGameInstanceId), HttpStatus.OK);
	}

	@PostMapping("/startLoggingGameInstance")
	public ResponseEntity<LogEventGameInstance> startLoggingGameInsance(@RequestBody StartLoggingGameInstanceDto startLoggingGameInstanceDto) {
		LogEventGameInstance logEventGameInstance = logEventGameInstanceService.startLoggingGameInstance(startLoggingGameInstanceDto);
		return new ResponseEntity<LogEventGameInstance>(logEventGameInstance, HttpStatus.OK);
	}
	
	@PostMapping("/stopLoggingGameInstance")
	public ResponseEntity<LogEventGameInstance> stopLoggingGameInsance(@RequestBody StartLoggingGameInstanceDto startLoggingGameInstanceDto) {
		LogEventGameInstance logEventGameInstance = logEventGameInstanceService.stopLoggingGameInstance(startLoggingGameInstanceDto);
		return new ResponseEntity<LogEventGameInstance>(logEventGameInstance, HttpStatus.OK);
	}
	
	@PostMapping("/logEventGamePlayer")
	public ResponseEntity<LogEventGamePlayer> logEventGamePlayer(@RequestBody LogEventGamePlayer logEventGamePlayerDto) {
		LogEventGamePlayer logEventGamePlayer = logEventGameInstanceService.logEventGamePlayer(logEventGamePlayerDto);
		return new ResponseEntity<LogEventGamePlayer>(logEventGamePlayer, HttpStatus.OK);
	}
	
}
