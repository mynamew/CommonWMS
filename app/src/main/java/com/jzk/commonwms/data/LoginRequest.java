package com.jzk.commonwms.data;

/**
 * $dsc
 * author: timi
 * create at: 2018-03-28 14:10
 */

public class LoginRequest {

    /**
     * tenancyName : Default
     * usernameOrEmailAddress : mes
     * password : 123qwe
     * deviceType : 8
     * mac :  E8-2A-EA-D0-BB-D2
     */

    private String tenancyName;
    private String usernameOrEmailAddress;
    private String password;
    private int deviceType;
    private String mac;

    public String getTenancyName() {
        return tenancyName;
    }

    public void setTenancyName(String tenancyName) {
        this.tenancyName = tenancyName;
    }

    public String getUsernameOrEmailAddress() {
        return usernameOrEmailAddress;
    }

    public void setUsernameOrEmailAddress(String usernameOrEmailAddress) {
        this.usernameOrEmailAddress = usernameOrEmailAddress;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(int deviceType) {
        this.deviceType = deviceType;
    }

    public String getMac() {
        return mac;
    }

    public void setMac(String mac) {
        this.mac = mac;
    }

    @Override
    public String toString() {
        return "LoginRequest{" +
                "tenancyName='" + tenancyName + '\'' +
                ", usernameOrEmailAddress='" + usernameOrEmailAddress + '\'' +
                ", password='" + password + '\'' +
                ", deviceType=" + deviceType +
                ", mac='" + mac + '\'' +
                '}';
    }
}
