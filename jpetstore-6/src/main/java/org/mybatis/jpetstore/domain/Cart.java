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
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import kieker.common.record.controlflow.OperationExecutionRecord;
import kieker.monitoring.core.controller.IMonitoringController;
import kieker.monitoring.core.controller.MonitoringController;

/**
 * The Class Cart.
 *
 * @author Eduardo Macarron
 */
public class Cart implements Serializable {
	private static  IMonitoringController MONITORING_CONTROLLER = MonitoringController.getInstance();
    private static  long serialVersionUID = 8329559983943337176L;

    private String sessionId;
    private  Map<String, CartItem> itemMap = Collections.synchronizedMap(new HashMap<String, CartItem>());
    private  List<CartItem> itemList = new ArrayList<CartItem>();

    
    public String getSessionId() {
		return sessionId;
	}

	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}

	public Iterator<CartItem> getCartItems(){log("public Iterator<CartItem> ","getCartItems()");
    	return itemList.iterator();
    }

    public List<CartItem> getCartItemList(){log("public List<CartItem>"," getCartItemList()");
        return itemList;
    }

    public int getNumberOfItems(){log("public int ","getNumberOfItems()");
        return itemList.size();
    }

    public Iterator<CartItem> getAllCartItems(){log(" public Iterator<CartItem> ","getAllCartItems()");
        return itemList.iterator();
    }

    public boolean containsItemId( String itemId){
    	log("public boolean"," containsItemId( String )");
        return itemMap.containsKey(itemId);
    }

    /**
     * Adds the item.
     *
     * @param item
     *            the item
     * @param isInStock
     *            the is in stock
     */
    public void addItem( Item item,  boolean isInStock, String sessionId){
    	logNormal("public void ","addItem( Item ,  boolean )",sessionId);
        CartItem cartItem = itemMap.get(item.getItemId());
        if (cartItem == null){
            cartItem = new CartItem();
            cartItem.setItem(item);
            cartItem.setQuantity(0);
            cartItem.setInStock(isInStock);
            itemMap.put(item.getItemId(), cartItem);
            itemList.add(cartItem);
        }
        cartItem.incrementQuantity();
    }

    /**
     * Removes the item by id.
     *
     * @param itemId
     *            the item id
     * @return the item
     */
    public Item removeItemById( String itemId){
    	log(" public Item ","removeItemById( String )");
         CartItem cartItem = itemMap.remove(itemId);
        if (cartItem == null){
            return null;
        } else {
            itemList.remove(cartItem);
            return cartItem.getItem();
        }
    }

    /**
     * Increment quantity by item id.
     *
     * @param itemId
     *            the item id
     */
    public void incrementQuantityByItemId( String itemId, String sessionId){
    	logNormal("public void ","incrementQuantityByItemId( String )", sessionId);
         CartItem cartItem = itemMap.get(itemId);
        cartItem.incrementQuantity();
    }

    public void setQuantityByItemId( String itemId,  int quantity,String sessionId){
    	logNormal("public void"," setQuantityByItemId( String ,  int )",sessionId);
         CartItem cartItem = itemMap.get(itemId);
        cartItem.setQuantity(quantity);
    }

    /**
     * Gets the sub total.
     *
     * @return the sub total
     */
    public BigDecimal getSubTotal(){
    	log(" public BigDecimal"," getSubTotal()");
        BigDecimal subTotal = new BigDecimal("0");
         Iterator<CartItem> items = getAllCartItems();
        while (items.hasNext()){
             CartItem cartItem = items.next();
             Item item = cartItem.getItem();
             BigDecimal listPrice = item.getListPrice();
             BigDecimal quantity = new BigDecimal(String.valueOf(cartItem.getQuantity()));
            subTotal = subTotal.add(listPrice.multiply(quantity));
        }
        return subTotal;
    }
    
    public void logNormal(String initializerWithReturnType,String method,String sessionId) {
    	
    	final long tin = MONITORING_CONTROLLER.getTimeSource().getTime();
        final long tout = MONITORING_CONTROLLER.getTimeSource().getTime();
         OperationExecutionRecord e = new OperationExecutionRecord(
        		initializerWithReturnType + this.getClass().getName() +
               method,
               sessionId,
                OperationExecutionRecord.NO_TRACE_ID,
                tin, tout, "myHost",
                3,
                3);
        MONITORING_CONTROLLER.newMonitoringRecord(e);
    }

    public void log(String initializerWithReturnType,String method) {
    	
    	final long tin = MONITORING_CONTROLLER.getTimeSource().getTime();
        final long tout = MONITORING_CONTROLLER.getTimeSource().getTime();
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
