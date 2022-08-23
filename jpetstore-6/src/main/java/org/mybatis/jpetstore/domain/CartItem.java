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
import java.math.BigDecimal;

import kieker.common.record.controlflow.OperationExecutionRecord;
import kieker.monitoring.core.controller.IMonitoringController;
import kieker.monitoring.core.controller.MonitoringController;

/**
 * The Class CartItem.
 *
 * @author Eduardo Macarron
 */
public class CartItem implements Serializable {
	private static  IMonitoringController MONITORING_CONTROLLER = MonitoringController.getInstance();
    private static  long serialVersionUID = 6620528781626504362L;

    private String sessionId;
    private Item item;
    private int quantity;
    private boolean inStock;
    private BigDecimal total;

    
    public String getSessionId() {
		return sessionId;
	}

	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}

	public boolean isInStock()
    {log("public boolean "," isInStock()");
        return inStock;
    }

    public void setInStock( boolean inStock){
    	log("    public void "," setInStock( boolean )");
        this.inStock = inStock;
    }

    public BigDecimal getTotal(){log("public BigDecimal "," getTotal()");
        return total;
    }

    public Item getItem(){log("public Item "," getItem()");
        return item;
    }

    public void setItem( Item item){
    	log("public void "," setItem( Item )");
        this.item = item;
        calculateTotal();
    }

    public int getQuantity(){log("public int "," getQuantity()");
        return quantity;
    }

    public void setQuantity( int quantity){
log(" public void  ","setQuantity( int )");
        this.quantity = quantity;
        calculateTotal();
    }

    public void incrementQuantity(){log(" public void  ","incrementQuantity()");
        quantity++;
        calculateTotal();
    }

    private void calculateTotal(){log("private void "," calculateTotal()");
        if (item != null && item.getListPrice() != null){
            total = item.getListPrice().multiply(new BigDecimal(quantity));
        } else {
            total = null;
        }
    }

    public void log(String initializerWithReturnType,String method) {
    	 long tin = MONITORING_CONTROLLER.getTimeSource().getTime();
         long tout = MONITORING_CONTROLLER.getTimeSource().getTime();
         OperationExecutionRecord e = new OperationExecutionRecord(
        		initializerWithReturnType + this.getClass().getName() +
               method,
                this.sessionId,
                OperationExecutionRecord.NO_TRACE_ID,
                tin, tout, "myHost",
                3,
                3);
        MONITORING_CONTROLLER.newMonitoringRecord(e);
    }
}
