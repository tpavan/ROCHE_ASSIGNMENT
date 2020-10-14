package domain;

import utils.PropertiesUtil;

import java.util.Objects;
import java.util.Properties;

public class Address {

    private static Address address;
    private String customerName;
    private String customerMobileNo;
    private String customerPin;
    private String customerAddress;
    private String customerLocacity;

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerMobileNo() {
        return customerMobileNo;
    }

    public void setCustomerMobileNo(String customerMobileNo) {
        this.customerMobileNo = customerMobileNo;
    }

    public String getCustomerPin() {
        return customerPin;
    }

    public void setCustomerPin(String customerPin) {
        this.customerPin = customerPin;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    public String getCustomerLocacity() {
        return customerLocacity;
    }

    public void setCustomerLocacity(String customerLocacity) {
        this.customerLocacity = customerLocacity;
    }

    public static Address setAddress() {
        Properties properties = PropertiesUtil.loadProperties("address.properties");

        if (Objects.isNull(address)) {
            address = new Address();
        }

        address.setCustomerName(properties.getProperty("customerName"));
        address.setCustomerAddress(properties.getProperty("customerAddress"));
        address.setCustomerMobileNo(properties.getProperty("customerMobileNo"));
        address.setCustomerPin(properties.getProperty("customerPin"));
        address.setCustomerLocacity(properties.getProperty("customerLocacity"));
        return address;
    }

    @Override
    public String toString() {
        return "Address{" +
                "customerName='" + customerName + '\'' +
                ", customerMobileNo='" + customerMobileNo + '\'' +
                ", customerPin='" + customerPin + '\'' +
                ", customerAddress='" + customerAddress + '\'' +
                ", customerLocacity='" + customerLocacity + '\'' +
                '}';
    }

}
