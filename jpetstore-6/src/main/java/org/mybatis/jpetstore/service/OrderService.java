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
package org.mybatis.jpetstore.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.jpetstore.domain.Item;
import org.mybatis.jpetstore.domain.LineItem;
import org.mybatis.jpetstore.domain.Order;
import org.mybatis.jpetstore.domain.Sequence;
import org.mybatis.jpetstore.mapper.IItemMapper;
import org.mybatis.jpetstore.mapper.ILineItemMapper;
import org.mybatis.jpetstore.mapper.IOrderMapper;
import org.mybatis.jpetstore.mapper.ISequenceMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kieker.common.record.controlflow.OperationExecutionRecord;
import kieker.monitoring.core.controller.IMonitoringController;
import kieker.monitoring.core.controller.MonitoringController;

/**
 * The Class OrderService.
 *
 * @author Eduardo Macarron
 */
@Service
public class OrderService {
	
	private static final IMonitoringController MONITORING_CONTROLLER = MonitoringController.getInstance();

    @Autowired
    private IItemMapper itemMapper;
    @Autowired
    private IOrderMapper orderMapper;
    @Autowired
    private ISequenceMapper sequenceMapper;
    @Autowired
    private ILineItemMapper lineItemMapper;

    /**
     * Insert order.
     *
     * @param order
     *            the order
     */
    @Transactional
    public void insertOrder(final Order order,String sessionId){
    	final long tin = MONITORING_CONTROLLER.getTimeSource().getTime();
        final long tout = MONITORING_CONTROLLER.getTimeSource().getTime();
        final OperationExecutionRecord e = new OperationExecutionRecord(
                "public void " + this.getClass().getName() +
                ".insertOrder(Order)",
                sessionId,
                OperationExecutionRecord.NO_TRACE_ID,
                tin, tout, "myHost",
                2,
                2);
        MONITORING_CONTROLLER.newMonitoringRecord(e);
        order.setSessionId(sessionId);
        order.setOrderId(getNextId("ordernum",sessionId));
        for (int i = 0; i < order.getLineItems().size(); i++){
            final LineItem lineItem = order.getLineItems().get(i);
            final String itemId = lineItem.getItemId();
            final Integer increment = new Integer(lineItem.getQuantity());
            final Map<String, Object> param = new HashMap<String, Object>(2);
            param.put("itemId", itemId);
            param.put("increment", increment);
            itemMapper.updateInventoryQuantity(param);
        }

        orderMapper.insertOrder(order);
        orderMapper.insertOrderStatus(order);
        for (int i = 0; i < order.getLineItems().size(); i++){
            final LineItem lineItem = order.getLineItems().get(i);
            lineItem.setOrderId(order.getOrderId());
            lineItemMapper.insertLineItem(lineItem);
        }
    }

    /**
     * Gets the order.
     *
     * @param orderId
     *            the order id
     * @return the order
     */
    @Transactional
    public Order getOrder(final int orderId,String sessionId){
    	final long tin = MONITORING_CONTROLLER.getTimeSource().getTime();
        final long tout = MONITORING_CONTROLLER.getTimeSource().getTime();
        final OperationExecutionRecord e = new OperationExecutionRecord(
                "public Order " + this.getClass().getName() +
                ".getOrder(int)",
                sessionId,
                OperationExecutionRecord.NO_TRACE_ID,
                tin, tout, "myHost",
                2,
                2);
        MONITORING_CONTROLLER.newMonitoringRecord(e);
        final Order order = orderMapper.getOrder(orderId);
        order.setLineItems(lineItemMapper.getLineItemsByOrderId(orderId));

        for (int i = 0; i < order.getLineItems().size(); i++){
            final LineItem lineItem = order.getLineItems().get(i);
            final Item item = itemMapper.getItem(lineItem.getItemId());
            item.setQuantity(itemMapper.getInventoryQuantity(lineItem.getItemId()));
            lineItem.setItem(item);
        }

        return order;
    }

    /**
     * Gets the orders by username.
     *
     * @param username
     *            the username
     * @return the orders by username
     */
    public List<Order> getOrdersByUsername(final String username,String sessionId){
    	final long tin = MONITORING_CONTROLLER.getTimeSource().getTime();
        final long tout = MONITORING_CONTROLLER.getTimeSource().getTime();
        final OperationExecutionRecord e = new OperationExecutionRecord(
                "public List<Order> " + this.getClass().getName() +
                ".getOrdersByUsername(String)",
                sessionId,
                OperationExecutionRecord.NO_TRACE_ID,
                tin, tout, "myHost",
                2,
                2);
        MONITORING_CONTROLLER.newMonitoringRecord(e);
        return orderMapper.getOrdersByUsername(username);
    }

    /**
     * Gets the next id.
     *
     * @param name
     *            the name
     * @return the next id
     */
    public int getNextId(final String name,String sessionId){
    	final long tin = MONITORING_CONTROLLER.getTimeSource().getTime();
        final long tout = MONITORING_CONTROLLER.getTimeSource().getTime();
        final OperationExecutionRecord e = new OperationExecutionRecord(
                "public int " + this.getClass().getName() +
                ".getNextId(String)",
                sessionId,
                OperationExecutionRecord.NO_TRACE_ID,
                tin, tout, "myHost",
                2,
                2);
        MONITORING_CONTROLLER.newMonitoringRecord(e);
        Sequence sequence = new Sequence(name, -1);
        sequence = sequenceMapper.getSequence(sequence);
        if (sequence == null){
            throw new RuntimeException("Error: A null sequence was returned from the database (could not get next "
                    + name + " sequence).");
        }
        final Sequence parameterObject = new Sequence(name, sequence.getNextId() + 1);
        sequenceMapper.updateSequence(parameterObject);
        return sequence.getNextId();
    }

}
