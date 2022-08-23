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
 * The Class LineItem.
 *
 * @author Eduardo Macarron
 */
public class LineItem implements Serializable {
	private static final IMonitoringController MONITORING_CONTROLLER = MonitoringController.getInstance();
    private static final long serialVersionUID = 6804536240033522156L;

    private String sessionId;
    private int orderId;
    private int lineNumber;
    private int quantity;
    private String itemId;
    private BigDecimal unitPrice;
    private Item item;
    private BigDecimal total;

    public LineItem(){
    }

    /**
     * Instantiates a new line item.
     *
     * @param lineNumber
     *            the line number
     * @param cartItem
     *            the cart item
     */
    public LineItem(final int lineNumber, final CartItem cartItem){
        this.lineNumber = lineNumber;
        quantity = cartItem.getQuantity();
        itemId = cartItem.getItem().getItemId();
        unitPrice = cartItem.getItem().getListPrice();
        item = cartItem.getItem();
    }

    
    public String getSessionId() {
		return sessionId;
	}

	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}

	public int getOrderId(){log("int"," orderId");
        return orderId;
    }

    public void setOrderId(final int orderId){
    	log("int"," orderId");
        this.orderId = orderId;
    }

    public int getLineNumber(){log("int ","lineNumber");
        return lineNumber;
    }

    public void setLineNumber(final int lineNumber){
    	log("int ","lineNumber");
        this.lineNumber = lineNumber;
    }

    public String getItemId(){log("String"," itemId");
        return itemId;
    }

    public void setItemId(final String itemId){
    	log("String"," itemId");
        this.itemId = itemId;
    }

    public BigDecimal getUnitPrice(){log("BigDecimal"," unitprice");
        return unitPrice;
    }

    public void setUnitPrice(final BigDecimal unitprice){
    	log("BigDecimal"," unitprice");
        unitPrice = unitprice;
    }

    public BigDecimal getTotal(){log("BigDecimal "," getTotal");
        return total;
    }

    public Item getItem(){log("Item"," item");
        return item;
    }

    public void setItem(final Item item){
    	log("Item"," item");
        this.item = item;
        calculateTotal();
    }

    public int getQuantity(){log("int"," quantity");
        return quantity;
    }

    public void setQuantity(final int quantity){
    	log("int"," quantity");
        this.quantity = quantity;
        calculateTotal();
    }

    private void calculateTotal(){
    	final long tin = MONITORING_CONTROLLER.getTimeSource().getTime();
        final long tout = MONITORING_CONTROLLER.getTimeSource().getTime();
        final OperationExecutionRecord e = new OperationExecutionRecord(
        		"private void" + this.getClass().getName() +
               "calculateTotal()",
                this.sessionId,
                OperationExecutionRecord.NO_TRACE_ID,
                tin, tout, "myHost",
                3,
                3);
        MONITORING_CONTROLLER.newMonitoringRecord(e);
        if (item != null && item.getListPrice() != null){
            total = item.getListPrice().multiply(new BigDecimal(quantity));
        } else {
            total = null;
        }
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
