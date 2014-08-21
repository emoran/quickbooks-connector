
package com.intuit.ipp.data.holders;

import java.util.Date;
import javax.annotation.Generated;
import com.intuit.ipp.data.JobStatusEnum;
import com.intuit.ipp.data.ReferenceType;

@Generated(value = "Mule DevKit Version 3.4.3", date = "2014-08-21T02:54:07-05:00", comments = "Build 3.4.3.1620.30ea288")
public class JobInfoExpressionHolder {

    protected Object status;
    protected JobStatusEnum _statusType;
    protected Object startDate;
    protected Date _startDateType;
    protected Object projectedEndDate;
    protected Date _projectedEndDateType;
    protected Object endDate;
    protected Date _endDateType;
    protected Object description;
    protected String _descriptionType;
    protected Object jobTypeRef;
    protected ReferenceType _jobTypeRefType;

    /**
     * Sets status
     * 
     * @param value Value to set
     */
    public void setStatus(Object value) {
        this.status = value;
    }

    /**
     * Retrieves status
     * 
     */
    public Object getStatus() {
        return this.status;
    }

    /**
     * Sets startDate
     * 
     * @param value Value to set
     */
    public void setStartDate(Object value) {
        this.startDate = value;
    }

    /**
     * Retrieves startDate
     * 
     */
    public Object getStartDate() {
        return this.startDate;
    }

    /**
     * Sets projectedEndDate
     * 
     * @param value Value to set
     */
    public void setProjectedEndDate(Object value) {
        this.projectedEndDate = value;
    }

    /**
     * Retrieves projectedEndDate
     * 
     */
    public Object getProjectedEndDate() {
        return this.projectedEndDate;
    }

    /**
     * Sets endDate
     * 
     * @param value Value to set
     */
    public void setEndDate(Object value) {
        this.endDate = value;
    }

    /**
     * Retrieves endDate
     * 
     */
    public Object getEndDate() {
        return this.endDate;
    }

    /**
     * Sets description
     * 
     * @param value Value to set
     */
    public void setDescription(Object value) {
        this.description = value;
    }

    /**
     * Retrieves description
     * 
     */
    public Object getDescription() {
        return this.description;
    }

    /**
     * Sets jobTypeRef
     * 
     * @param value Value to set
     */
    public void setJobTypeRef(Object value) {
        this.jobTypeRef = value;
    }

    /**
     * Retrieves jobTypeRef
     * 
     */
    public Object getJobTypeRef() {
        return this.jobTypeRef;
    }

}
