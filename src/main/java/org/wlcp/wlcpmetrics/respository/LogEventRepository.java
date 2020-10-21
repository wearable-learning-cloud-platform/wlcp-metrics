package org.wlcp.wlcpmetrics.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.wlcp.wlcpmetrics.datamodel.master.LogEvent;

public interface LogEventRepository extends JpaRepository<LogEvent, Integer> {

}
