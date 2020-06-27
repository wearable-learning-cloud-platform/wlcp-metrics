package org.wlcp.wlcpmetrics.datamodel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Test {
	
	@Id
	@Column
	private String testId;

}
