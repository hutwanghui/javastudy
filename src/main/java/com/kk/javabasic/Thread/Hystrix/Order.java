package com.kk.javabasic.Thread.Hystrix;

import java.util.Date;

/**
 * Created by hutwanghui on 2018/7/31.
 * email:zjjhwanhui@163.com
 * qq:472860892
 */
public class Order {
    private int id;
    private String orderName;
    private Date createTime;
    private Double pay;

    public Order(int id, String orderName, Date createTime, Double pay) {
        this.id = id;
        this.orderName = orderName;
        this.createTime = createTime;
        this.pay = pay;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOrderName() {
        return orderName;
    }

    public void setOrderName(String orderName) {
        this.orderName = orderName;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Double getPay() {
        return pay;
    }

    public void setPay(Double pay) {
        this.pay = pay;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", orderName='" + orderName + '\'' +
                ", createTime=" + createTime +
                ", pay=" + pay +
                '}';
    }
}
