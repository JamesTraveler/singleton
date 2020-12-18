/*
 * Copyright 2019-2020 VMware, Inc.
 * SPDX-License-Identifier: EPL-2.0
 */
package com.vmware.l10agent.schedule;

import com.vmware.l10agent.service.RecordService;

public class MutiThreadReqApiV1 implements Runnable{
	private RecordService rs;
	
   public MutiThreadReqApiV1(RecordService recordService) {
	  this.rs = recordService;
   }
	@Override
	public void run() {
		// TODO Auto-generated method stub
		rs.getRecordModelsByRemoteV1();
	}

}
