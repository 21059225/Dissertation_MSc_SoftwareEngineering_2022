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
 * The Class Item.
 *
 * @author Eduardo Macarron
 */
public class Item implements Serializable {
	private static  IMonitoringController MONITORING_CONTROLLER = MonitoringController.getInstance();
    private static  long serialVersionUID = -2159121673445254631L;

    private String sessionId;
    private String itemId;
    private String productId;
    private BigDecimal listPrice;
    private BigDecimal unitCost;
    private int supplierId;
    private String status;
    private String attribute1;
    private String attribute2;
    private String attribute3;
    private String attribute4;
    private String attribute5;
    private Product product;
    private int quantity;

    
    public String getSessionId() {
		return sessionId;
	}

	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}

	public String getItemId(){log("String"," itemId");
        return itemId;
    }

    public void setItemId( String itemId){
    	log("String"," itemId");
        this.itemId = itemId.trim();
    }

    public int getQuantity(){log("String"," productId");
        return quantity;
    }

    public void setQuantity( int quantity){
    	log("String"," productId");
        this.quantity = quantity;
    }

    public Product getProduct(){log("Product","  product");
        return product;
    }

    public void setProduct( Product product){
    	log("Product","  product");
        this.product = product;
    }

    public String getProductId(){log("String"," productId");
        return productId;
    }

    public void setProductId( String productId){
    	log("String"," productId");
        this.productId = productId;
    }

    public int getSupplierId(){log(" int "," supplierId");
        return supplierId;
    }

    public void setSupplierId( int supplierId){
    	log(" int "," supplierId");
        this.supplierId = supplierId;
    }

    public BigDecimal getListPrice(){log("BigDecimal"," listPrice");
        return listPrice;
    }

    public void setListPrice( BigDecimal listPrice){
    	log("BigDecimal"," listPrice");
        this.listPrice = listPrice;
    }

    public BigDecimal getUnitCost(){log("BigDecimal"," unitCost");
        return unitCost;
    }

    public void setUnitCost( BigDecimal unitCost){
    	log("BigDecimal"," unitCost");
        this.unitCost = unitCost;
    }

    public String getStatus(){log("String"," status");
        return status;
    }

    public void setStatus( String status){
    	log("String"," status");
        this.status = status;
    }

    public String getAttribute1(){log("String"," attribute1");
        return attribute1;
    }

    public void setAttribute1( String attribute1){
    	log("String"," attribute1");
        this.attribute1 = attribute1;
    }

    public String getAttribute2(){log("String"," attribute2");
        return attribute2;
    }

    public void setAttribute2( String attribute2){
    	log("String"," attribute2");
        this.attribute2 = attribute2;
    }

    public String getAttribute3(){log("String"," attribute3");
        return attribute3;
    }

    public void setAttribute3( String attribute3){
    	log("String"," attribute3");
        this.attribute3 = attribute3;
    }

    public String getAttribute4(){log("String"," attribute4");
        return attribute4;
    }

    public void setAttribute4( String attribute4){
    	log("String"," attribute4");
        this.attribute4 = attribute4;
    }

    public String getAttribute5(){log("String"," attribute5");
        return attribute5;
    }

    public void setAttribute5( String attribute5){
    	log("String"," attribute5");
        this.attribute5 = attribute5;
    }

    @Override
    public String toString(){
        return "(" + getItemId() + "-" + getProductId() + ")";
    }
    public void log(String returnType,String method) {
    	 long tin = MONITORING_CONTROLLER.getTimeSource().getTime();
         long tout = MONITORING_CONTROLLER.getTimeSource().getTime();
         OperationExecutionRecord e = new OperationExecutionRecord(
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
