package com.mentorondemand.admin.service;

import java.util.List;

import com.mentorondemand.admin.dto.BatchDTO;

public interface BatchService {
	
	public BatchDTO getBatch(Integer batchId);
	public List<BatchDTO> getBatches();

}
