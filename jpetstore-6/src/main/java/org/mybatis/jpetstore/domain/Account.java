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
import net.sourceforge.stripes.validation.Validate;

/**
 * The Class Account.
 *
 * @author Eduardo Macarron
 */
public class Account implements Serializable {

    private static final long serialVersionUID = 8751282105532159742L;
    
    private static final IMonitoringController MONITORING_CONTROLLER = MonitoringController.getInstance();
    
    private String sessionId;
    private String username;
    private String password;
    private String email;
    private String firstName;
    private String lastName;
    private String status;
    private String address1;
    private String address2;
    private String city;
    private String state;
    private String zip;
    private String country;
    private String phone;
    private String favouriteCategoryId;
    private String languagePreference;
    private boolean listOption;
    private boolean bannerOption;
    private String bannerName;

    
    public String getSessionId() {
		return sessionId;
	}

	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}

	public String getUsername(){
    	log("public String" , "getUsername()");
        return username;
    }

    public void setUsername(final String username){
    	log(" public void" , "setUsername(String)");
        this.username = username;
    }

    public String getPassword(){
    	log("public String" , " getPassword() ");
        return password;
    }

    public void setPassword(final String password){
    	log("public void " , "setPassword( String ) ");
        this.password = password;
    }

    public String getEmail(){
    	log("public String" , " getEmail() ");
        return email;
    }

    public void setEmail(final String email){
    	log("public void " , "setEmail( String ) ");
        this.email = email;
    }

    public String getFirstName(){
    	log("public String" , " getFirstName() ");
        return firstName;
    }

    @Validate(required = true, on = { "newAccount", "editAccount" })
    public void setFirstName(final String firstName){
    	log("public void " , "setFirstName( String ) ");
        this.firstName = firstName;
    }

    public String getLastName(){
    	log(" public String" , " getLastName()");
        return lastName;
    }

    @Validate(required = true, on = { "newAccount", "editAccount" })
    public void setLastName(final String lastName){
    	log(" public void " , "setLastName( String ) ");
        this.lastName = lastName;
    }

    public String getStatus(){
    	log("public String" , " getStatus() ");
        return status;
    }

    public void setStatus(final String status){
    	log(" public void " , "setStatus( String ) ");
        this.status = status;
    }

    public String getAddress1(){
    	log(" public String" , " getAddress1() ");
        return address1;
    }

    public void setAddress1(final String address1){
    	log("public void " , "setAddress1( String ) ");
        this.address1 = address1;
    }

    public String getAddress2(){
    	log("public String " , "getAddress2() ");
        return address2;
    }

    public void setAddress2(final String address2){
    	log("public void" , " setAddress2( String ) ");
        this.address2 = address2;
    }

    public String getCity(){
    	log(" public String " , "getCity()");
        return city;
    }

    public void setCity(final String city){
    	log(" public void " , "setCity( String ) ");
        this.city = city;
    }

    public String getState(){
    	log("public String" , " getState() ");
        return state;
    }

    public void setState(final String state){
    	log("public void" , " setState( String ) ");
        this.state = state;
    }

    public String getZip(){
    	log("public String" , " getZip() ");
        return zip;
    }

    public void setZip(final String zip){
    	log(" public void" , " setZip( String )");
        this.zip = zip;
    }

    public String getCountry(){
    	log("public String" , " getCountry() ");
        return country;
    }

    public void setCountry(final String country){
    	log("public void" , " setCountry( String ) ");
        this.country = country;
    }

    public String getPhone(){
    	log("public String" , " getPhone() ");
        return phone;
    }

    public void setPhone(final String phone){
    	log(" public void " , "setPhone( String ) ");
        this.phone = phone;
    }

    public String getFavouriteCategoryId(){
    	log("public String" , " getFavouriteCategoryId() ");
        return favouriteCategoryId;
    }

    public void setFavouriteCategoryId(final String favouriteCategoryId){
    	log(" public void" , " setFavouriteCategoryId( String ) ");
        this.favouriteCategoryId = favouriteCategoryId;
    }

    public String getLanguagePreference(){
    	log(" public String" , " getLanguagePreference()");
        return languagePreference;
    }

    public void setLanguagePreference(final String languagePreference){
    	log("public void " , "setLanguagePreference( String ) ");
        this.languagePreference = languagePreference;
    }

    public boolean isListOption(){
    	log(" public boolean" , " isListOption()");
        return listOption;
    }

    public void setListOption(final boolean listOption){
    	log("public void" , " setListOption( boolean ) ");
        this.listOption = listOption;
    }

    public boolean isBannerOption(){
    	log("public boolean" , " isBannerOption() ");
        return bannerOption;
    }

    public void setBannerOption(final boolean bannerOption){
    	log("public void" , " setBannerOption( boolean ) ");
        this.bannerOption = bannerOption;
    }

    public String getBannerName(){
    	log(" public String" , " getBannerName() ");
        return bannerName;
    }

    public void setBannerName(final String bannerName){
    	log("public void " , "setBannerName( String bannerName) ");
        this.bannerName = bannerName;
    }
    
    public void log(String initializerWithReturnType,String method) {
    	final long tin = MONITORING_CONTROLLER.getTimeSource().getTime();
        final long tout = MONITORING_CONTROLLER.getTimeSource().getTime();
        final OperationExecutionRecord e = new OperationExecutionRecord(
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
