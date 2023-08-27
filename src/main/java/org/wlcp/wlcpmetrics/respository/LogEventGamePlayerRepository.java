package org.wlcp.wlcpmetrics.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.wlcp.wlcpmetrics.datamodel.master.player.LogEventGamePlayer;

public interface LogEventGamePlayerRepository extends JpaRepository<LogEventGamePlayer, Integer> {

}
