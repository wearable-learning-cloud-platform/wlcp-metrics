package org.wlcp.wlcpmetrics.datamodel;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
public class Test {
	
	@Id
	@Column
	private String testId;

}
