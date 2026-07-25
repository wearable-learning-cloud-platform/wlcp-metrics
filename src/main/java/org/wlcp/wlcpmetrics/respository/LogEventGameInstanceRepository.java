package org.wlcp.wlcpmetrics.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.wlcp.wlcpmetrics.datamodel.master.player.LogEventGameInstance;

public interface LogEventGameInstanceRepository extends JpaRepository<LogEventGameInstance, Integer> {

}
