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
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import kieker.common.record.controlflow.OperationExecutionRecord;
import kieker.monitoring.core.controller.IMonitoringController;
import kieker.monitoring.core.controller.MonitoringController;

/**
 * The Class Order.
 *
 * @author Eduardo Macarron
 */
public class Order implements Serializable {
	private static final IMonitoringController MONITORING_CONTROLLER = MonitoringController.getInstance();
    private static final long serialVersionUID = 6321792448424424931L;

    private String sessionId;
    
    private int orderId;
    private String username;
    private Date orderDate;
    private String shipAddress1;
    private String shipAddress2;
    private String shipCity;
    private String shipState;
    private String shipZip;
    private String shipCountry;
    private String billAddress1;
    private String billAddress2;
    private String billCity;
    private String billState;
    private String billZip;
    private String billCountry;
    private String courier;
    private BigDecimal totalPrice;
    private String billToFirstName;
    private String billToLastName;
    private String shipToFirstName;
    private String shipToLastName;
    private String creditCard;
    private String expiryDate;
    private String cardType;
    private String locale;
    private String status;
    private List<LineItem> lineItems = new ArrayList<LineItem>();

    
    public String getSessionId() {
		return sessionId;
	}

	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}

	public int getOrderId(){log("int "," orderId");
        return orderId;
    }

    public void setOrderId(final int orderId){
    	log("int "," orderId");
        this.orderId = orderId;
    }

    public String getUsername(){log("String"," username");
        return username;
    }

    public void setUsername(final String username){
    	log("String"," username");
        this.username = username;
    }

    public Date getOrderDate(){log("Date"," orderDate");
        return orderDate;
    }

    public void setOrderDate(final Date orderDate){
    	log("Date"," orderDate");
        this.orderDate = orderDate;
    }

    public String getShipAddress1(){log(" String"," shipAddress1");
        return shipAddress1;
    }

    public void setShipAddress1(final String shipAddress1){
    	log(" String"," shipAddress1");
        this.shipAddress1 = shipAddress1;
    }

    public String getShipAddress2(){log("String ","shipAddress2");
        return shipAddress2;
    }

    public void setShipAddress2(final String shipAddress2){
    	log("String ","shipAddress2");
        this.shipAddress2 = shipAddress2;
    }

    public String getShipCity(){log("String ","shipCity");
        return shipCity;
    }

    public void setShipCity(final String shipCity){
    	log("String ","shipCity");
        this.shipCity = shipCity;
    }

    public String getShipState(){log("String ","shipState");
        return shipState;
    }

    public void setShipState(final String shipState){
    	log("String ","shipState");
        this.shipState = shipState;
    }

    public String getShipZip(){log("String"," shipZip");
        return shipZip;
    }

    public void setShipZip(final String shipZip){
    	log("String"," shipZip");
        this.shipZip = shipZip;
    }

    public String getShipCountry(){log("String"," shipCountry");
        return shipCountry;
    }

    public void setShipCountry(final String shipCountry){
    	log("String"," shipCountry");
        this.shipCountry = shipCountry;
    }

    public String getBillAddress1(){log("String"," billAddress1");
        return billAddress1;
    }

    public void setBillAddress1(final String billAddress1){
    	log("String"," billAddress1");
        this.billAddress1 = billAddress1;
    }

    public String getBillAddress2(){log("String"," billAddress2");
        return billAddress2;
    }

    public void setBillAddress2(final String billAddress2){
    	log("String"," billAddress2");
        this.billAddress2 = billAddress2;
    }

    public String getBillCity(){log("String"," billCity");
        return billCity;
    }

    public void setBillCity(final String billCity){
    	log("String"," billCity");
        this.billCity = billCity;
    }

    public String getBillState(){log("String"," billState");
        return billState;
    }

    public void setBillState(final String billState){
    	log("String"," billState");
        this.billState = billState;
    }

    public String getBillZip(){log("String"," billZip");
        return billZip;
    }

    public void setBillZip(final String billZip){
    	log("String"," billZip");
        this.billZip = billZip;
    }

    public String getBillCountry(){log("String"," billCountry");
    log("String"," billCountry");
        return billCountry;
    }

    public void setBillCountry(final String billCountry){
    	log("String"," billCountry");
        this.billCountry = billCountry;
    }

    public String getCourier(){log("String"," courier");
        return courier;
    }

    public void setCourier(final String courier){
    	log("String"," courier");
        this.courier = courier;
    }

    public BigDecimal getTotalPrice(){log("BigDecimal ","totalPrice");
        return totalPrice;
    }

    public void setTotalPrice(final BigDecimal totalPrice){
    	log("BigDecimal ","totalPrice");
        this.totalPrice = totalPrice;
    }

    public String getBillToFirstName(){log("String"," billToFirstName");
        return billToFirstName;
    }

    public void setBillToFirstName(final String billToFirstName){
    	log("String"," billToFirstName");
        this.billToFirstName = billToFirstName;
    }

    public String getBillToLastName(){log("String"," billToLastName");
        return billToLastName;
    }

    public void setBillToLastName(final String billToLastName){
    	log("String"," billToLastName");
        this.billToLastName = billToLastName;
    }

    public String getShipToFirstName(){log("String"," shipFoFirstName");
        return shipToFirstName;
    }

    public void setShipToFirstName(final String shipFoFirstName){
    	log("String"," shipFoFirstName");
        shipToFirstName = shipFoFirstName;
    }

    public String getShipToLastName(){log("String"," shipToLastName");
        return shipToLastName;
    }

    public void setShipToLastName(final String shipToLastName){
    	log("String"," shipToLastName");
        this.shipToLastName = shipToLastName;
    }

    public String getCreditCard(){log("String"," creditCard");
        return creditCard;
    }

    public void setCreditCard(final String creditCard){
    	log("String"," creditCard");
        this.creditCard = creditCard;
    }

    public String getExpiryDate(){log("String"," expiryDate");
        return expiryDate;
    }

    public void setExpiryDate(final String expiryDate){
    	log("String"," expiryDate");
        this.expiryDate = expiryDate;
    }

    public String getCardType(){log("String ","cardType");
        return cardType;
    }

    public void setCardType(final String cardType){
    	log("String ","cardType");
        this.cardType = cardType;
    }

    public String getLocale(){log("String"," cardType");
        return locale;
    }

    public void setLocale(final String locale){
    	log("String"," cardType");
        this.locale = locale;
    }

    public String getStatus(){log("String"," locale");
        return status;
    }

    public void setStatus(final String status){
    	log("String"," locale");
        this.status = status;
    }

    public void setLineItems(final List<LineItem> lineItems){
    	log("List<LineItem>"," lineItems");
        this.lineItems = lineItems;
    }

    public List<LineItem> getLineItems(){log("List<LineItem>"," lineItems");
        return lineItems;
    }

    /**
     * Inits the order.
     *
     * @param account
     *            the account
     * @param cart
     *            the cart
     */
    public void initOrder(final Account account, final Cart cart){
    	final long tin = MONITORING_CONTROLLER.getTimeSource().getTime();
        final long tout = MONITORING_CONTROLLER.getTimeSource().getTime();
        final OperationExecutionRecord e = new OperationExecutionRecord(
        		"public void" + this.getClass().getName() +
               "initOrder( Account account,  Cart cart)",
                this.sessionId,
                OperationExecutionRecord.NO_TRACE_ID,
                tin, tout, "myHost",
                3,
                3);
        MONITORING_CONTROLLER.newMonitoringRecord(e);

        username = account.getUsername();
        orderDate = new Date();

        shipToFirstName = account.getFirstName();
        shipToLastName = account.getLastName();
        shipAddress1 = account.getAddress1();
        shipAddress2 = account.getAddress2();
        shipCity = account.getCity();
        shipState = account.getState();
        shipZip = account.getZip();
        shipCountry = account.getCountry();

        billToFirstName = account.getFirstName();
        billToLastName = account.getLastName();
        billAddress1 = account.getAddress1();
        billAddress2 = account.getAddress2();
        billCity = account.getCity();
        billState = account.getState();
        billZip = account.getZip();
        billCountry = account.getCountry();

        totalPrice = cart.getSubTotal();

        creditCard = "999 9999 9999 9999";
        expiryDate = "12/03";
        cardType = "Visa";
        courier = "UPS";
        locale = "CA";
        status = "P";

        final Iterator<CartItem> i = cart.getAllCartItems();
        while (i.hasNext()){
            final CartItem cartItem = i.next();
            addLineItem(cartItem);
        }

    }

    public void addLineItem(final CartItem cartItem){
    	final long tin = MONITORING_CONTROLLER.getTimeSource().getTime();
        final long tout = MONITORING_CONTROLLER.getTimeSource().getTime();
        final OperationExecutionRecord e = new OperationExecutionRecord(
        		" public void" + this.getClass().getName() +
               "addLineItem(final CartItem )",
                this.sessionId,
                OperationExecutionRecord.NO_TRACE_ID,
                tin, tout, "myHost",
                3,
                3);
        MONITORING_CONTROLLER.newMonitoringRecord(e);
        final LineItem lineItem = new LineItem(lineItems.size() + 1, cartItem);
        addLineItem(lineItem);
    }

    public void addLineItem(final LineItem lineItem){
    	final long tin = MONITORING_CONTROLLER.getTimeSource().getTime();
        final long tout = MONITORING_CONTROLLER.getTimeSource().getTime();
        final OperationExecutionRecord e = new OperationExecutionRecord(
        		"public void" + this.getClass().getName() +
               "addLineItem(final LineItem )",
                this.sessionId,
                OperationExecutionRecord.NO_TRACE_ID,
                tin, tout, "myHost",
                3,
                3);
        MONITORING_CONTROLLER.newMonitoringRecord(e);
        lineItems.add(lineItem);
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
