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
 * The Class Product.
 *
 * @author Eduardo Macarron
 */
public class Product implements Serializable {
	private static final IMonitoringController MONITORING_CONTROLLER = MonitoringController.getInstance();
    private static final long serialVersionUID = -7492639752670189553L;

    private String sessionId;
    private String productId;
    private String categoryId;
    private String name;
    private String description;

    
    public String getSessionId() {
		return sessionId;
	}

	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}

	public String getProductId(){log("String "," productId");
        return productId;
    }

    public void setProductId(final String productId){log("String "," productId");
        this.productId = productId.trim();
    }

    public String getCategoryId(){log("String","  categoryId");
        return categoryId;
    }

    public void setCategoryId(final String categoryId){log("String","  categoryId");
        this.categoryId = categoryId;
    }

    public String getName(){log("String","  name");
        return name;
    }

    public void setName(final String name){log("String","  name");
        this.name = name;
    }

    public String getDescription(){log("String "," description");
        return description;
    }

    public void setDescription(final String description){log("String "," description");
        this.description = description;
    }

    @Override
    public String toString(){
        return getName();
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
