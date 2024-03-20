package org.wlcp.wlcpmetrics.service;

import org.wlcp.wlcpmetrics.datamodel.master.player.LogEventGameInstance;
import org.wlcp.wlcpmetrics.datamodel.master.player.LogEventGamePlayer;
import org.wlcp.wlcpmetrics.dto.StartLoggingGameInstanceDto;

public interface LogEventGameInstanceService {

	LogEventGameInstance getLogEventGameInstance(Integer logEventGameInstanceId);
	LogEventGameInstance startLoggingGameInstance(StartLoggingGameInstanceDto startLoggingGameInstanceDto);
	LogEventGameInstance stopLoggingGameInstance(StartLoggingGameInstanceDto startLoggingGameInstanceDto);
	LogEventGamePlayer logEventGamePlayer(LogEventGamePlayer logEventGamePlayer);
	
}
