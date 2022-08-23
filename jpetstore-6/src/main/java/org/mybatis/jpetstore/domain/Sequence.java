/**
 *    Copyright (C) 2010-2017 the original author or authors.
 *                  2018 iObserve Project (https://www.iobserve-devops.net)
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */
package org.mybatis.jpetstore.domain;

import java.io.Serializable;

import kieker.common.record.controlflow.OperationExecutionRecord;
import kieker.monitoring.core.controller.IMonitoringController;
import kieker.monitoring.core.controller.MonitoringController;

/**
 * The Class Sequence.
 *
 * @author Eduardo Macarron
 */
public class Sequence implements Serializable {
	private static final IMonitoringController MONITORING_CONTROLLER = MonitoringController.getInstance();
    private static final long serialVersionUID = 8278780133180137281L;

    private String sessionId;
    private String name;
    private int nextId;

    
    public String getSessionId() {
		return sessionId;
	}

	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}

	public Sequence(){
    }

    public Sequence(final String name, final int nextId){
        this.name = name;
        this.nextId = nextId;
    }

    public String getName(){log("String"," name");
        return name;
    }

    public void setName(final String name){log("String"," name");
        this.name = name;
    }

    public int getNextId(){log("int"," nextId");
        return nextId;
    }

    public void setNextId(final int nextId){log("int"," nextId");
        this.nextId = nextId;
    }
    public void log(String returnType,String method) {
    	final long tin = MONITORING_CONTROLLER.getTimeSource().getTime();
        final long tout = MONITORING_CONTROLLER.getTimeSource().getTime();
        final OperationExecutionRecord e = new OperationExecutionRecord(
        		"public"+ returnType + this.getClass().getName() +
               "get/set"+method,
                this.sessionId,
                OperationExecutionRecord.NO_TRACE_ID,
                tin, tout, "myHost",
                3,
                3);
        MONITORING_CONTROLLER.newMonitoringRecord(e);
    }
    
}
