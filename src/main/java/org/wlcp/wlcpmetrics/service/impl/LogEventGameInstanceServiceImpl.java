package org.wlcp.wlcpmetrics.service.impl;

import java.sql.Timestamp;
import java.time.Instant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.wlcp.wlcpmetrics.datamodel.master.player.LogEventGameInstance;
import org.wlcp.wlcpmetrics.datamodel.master.player.LogEventGamePlayer;
import org.wlcp.wlcpmetrics.datamodel.master.player.LogEventGamePlayerClientMessage;
import org.wlcp.wlcpmetrics.datamodel.master.player.LogEventGamePlayerCommunication;
import org.wlcp.wlcpmetrics.datamodel.master.player.LogEventGamePlayerServerEvent;
import org.wlcp.wlcpmetrics.datamodel.master.player.LogEventGamePlayerServerMessage;
import org.wlcp.wlcpmetrics.dto.StartLoggingGameInstanceDto;
import org.wlcp.wlcpmetrics.respository.LogEventGameInstanceRepository;
import org.wlcp.wlcpmetrics.respository.LogEventGamePlayerRepository;
import org.wlcp.wlcpmetrics.service.LogEventGameInstanceService;

@Service
public class LogEventGameInstanceServiceImpl implements LogEventGameInstanceService {
	
	@Autowired
	private LogEventGameInstanceRepository logEventGameInstanceRepository;
	
	@Autowired
	private LogEventGamePlayerRepository logEventGamePlayerRepository;

	@Override
	public LogEventGameInstance startLoggingGameInstance(StartLoggingGameInstanceDto startLoggingGameInstanceDto) {
		LogEventGameInstance logEventGameInstance = new LogEventGameInstance(startLoggingGameInstanceDto.gameId, startLoggingGameInstanceDto.usernameId, startLoggingGameInstanceDto.debugInstance);
		return logEventGameInstanceRepository.save(logEventGameInstance);
	}

	@Override
	public LogEventGameInstance stopLoggingGameInstance(StartLoggingGameInstanceDto startLoggingGameInstanceDto) {
		LogEventGameInstance logEventGameInstance = logEventGameInstanceRepository.findById(Integer.valueOf(startLoggingGameInstanceDto.logEventGameInstanceId)).get();
		logEventGameInstance.setEnd(Timestamp.from(Instant.now()));
		logEventGameInstance.setDuration(logEventGameInstance.getEnd().getTime() - logEventGameInstance.getStart().getTime());
		logEventGameInstance.setGameEnded(true);
		return logEventGameInstanceRepository.save(logEventGameInstance);
	}

	@Override
	public LogEventGameInstance getLogEventGameInstance(Integer logEventGameInstanceId) {
		return logEventGameInstanceRepository.findById(logEventGameInstanceId).get();
	}

	@Override
	public LogEventGamePlayer logEventGamePlayer(LogEventGamePlayer logEventGamePlayer) {
		LogEventGamePlayer logEventGamePlayerSaved = logEventGamePlayerRepository.save(logEventGamePlayer);
		LogEventGameInstance logEventGameInstance = logEventGameInstanceRepository.findById(logEventGamePlayerSaved.getLogEventGameInstance().getId()).get();
		switch(logEventGamePlayer.getLogEventGamePlayerType()) {
		case CLIENT_MESSAGE:
			logEventGameInstance.getClientMessages().add((LogEventGamePlayerClientMessage) logEventGamePlayer);
			break;
		case SERVER_MESSAGE:
			logEventGameInstance.getServerMessages().add((LogEventGamePlayerServerMessage) logEventGamePlayer);
			break;
		case SERVER_EVENT:
			logEventGameInstance.getServerEvents().add((LogEventGamePlayerServerEvent) logEventGamePlayer);
			break;
		case COMMUNICATION:
			logEventGameInstance.getGamePlayerCommunicationEvents().add((LogEventGamePlayerCommunication) logEventGamePlayer);
		default:
			break;
		}
		logEventGameInstanceRepository.save(logEventGameInstance);
		return logEventGamePlayerSaved;
	}


}
