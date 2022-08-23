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

import org.mybatis.jpetstore.domain.Account;
import org.mybatis.jpetstore.mapper.IAccountMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kieker.common.record.controlflow.OperationExecutionRecord;
import kieker.monitoring.core.controller.IMonitoringController;
import kieker.monitoring.core.controller.MonitoringController;

/**
 * The Class AccountService.
 *
 * @author Eduardo Macarron
 */
@Service
public class AccountService {
	private static final IMonitoringController MONITORING_CONTROLLER = MonitoringController.getInstance();

    @Autowired
    private IAccountMapper accountMapper;

    public Account getAccount(final String username,String sessionId){
    	final long tin = MONITORING_CONTROLLER.getTimeSource().getTime();
        final long tout = MONITORING_CONTROLLER.getTimeSource().getTime();
        final OperationExecutionRecord e = new OperationExecutionRecord(
                "public Account " + this.getClass().getName() +
                ".getAccount(String)",
                sessionId,
                OperationExecutionRecord.NO_TRACE_ID,
                tin, tout, "myHost",
                2,
                2);
        MONITORING_CONTROLLER.newMonitoringRecord(e);
        return accountMapper.getAccountByUsername(username);
    }

    public Account getAccount(final String username, final String password,String sessionId){
    	final long tin = MONITORING_CONTROLLER.getTimeSource().getTime();
        final long tout = MONITORING_CONTROLLER.getTimeSource().getTime();
        final OperationExecutionRecord e = new OperationExecutionRecord(
                "public Account " + this.getClass().getName() +
                ".getAccount(String,String)",
                sessionId,
                OperationExecutionRecord.NO_TRACE_ID,
                tin, tout, "myHost",
                2,
                2);
        MONITORING_CONTROLLER.newMonitoringRecord(e);
        return accountMapper.getAccountByUsernameAndPassword(username, password);
    }

    /**
     * Insert account.
     *
     * @param account
     *            the account
     */
    @Transactional
    public void insertAccount(final Account account){
    	final long tin = MONITORING_CONTROLLER.getTimeSource().getTime();
        final long tout = MONITORING_CONTROLLER.getTimeSource().getTime();
        final OperationExecutionRecord e = new OperationExecutionRecord(
                "public void " + this.getClass().getName() +
                ".insertAccount(Account)",
                account.getSessionId(),
                OperationExecutionRecord.NO_TRACE_ID,
                tin, tout, "myHost",
                2,
                2);
        MONITORING_CONTROLLER.newMonitoringRecord(e);
        accountMapper.insertAccount(account);
        accountMapper.insertProfile(account);
        accountMapper.insertSignon(account);
    }

    /**
     * Update account.
     *
     * @param account
     *            the account
     */
    @Transactional
    public void updateAccount(final Account account){
    	final long tin = MONITORING_CONTROLLER.getTimeSource().getTime();
        final long tout = MONITORING_CONTROLLER.getTimeSource().getTime();
        final OperationExecutionRecord e = new OperationExecutionRecord(
                "public void " + this.getClass().getName() +
                ".updateAccount(Account)",
                account.getSessionId(),
                OperationExecutionRecord.NO_TRACE_ID,
                tin, tout, "myHost",
                2,
                2);
        MONITORING_CONTROLLER.newMonitoringRecord(e);
        accountMapper.updateAccount(account);
        accountMapper.updateProfile(account);

        if (account.getPassword() != null && account.getPassword().length() > 0){
            accountMapper.updateSignon(account);
        }
    }

}
