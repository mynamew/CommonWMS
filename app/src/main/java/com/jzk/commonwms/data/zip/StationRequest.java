package com.jzk.commonwms.data.zip;

/**
 * $dsc  工位的请求
 *
 * @author: timi
 * create at: 2018-07-19 17:03
 */
public class StationRequest {

    public StationRequest(String processCode, String eqpTypeCode, String employeeCode) {
        ProcessCode = processCode;
        EqpTypeCode = eqpTypeCode;
        EmployeeCode = employeeCode;
    }

    /**
     * ProcessCode : MD
     * EqpTypeCode : null
     * EmployeeCode : null
     */

    private String ProcessCode;
    private String EqpTypeCode;
    private String EmployeeCode;

    public String getProcessCode() {
        return ProcessCode;
    }

    public void setProcessCode(String ProcessCode) {
        this.ProcessCode = ProcessCode;
    }

    public String getEqpTypeCode() {
        return EqpTypeCode;
    }

    public void setEqpTypeCode(String EqpTypeCode) {
        this.EqpTypeCode = EqpTypeCode;
    }

    public String getEmployeeCode() {
        return EmployeeCode;
    }

    public void setEmployeeCode(String EmployeeCode) {
        this.EmployeeCode = EmployeeCode;
    }
}
