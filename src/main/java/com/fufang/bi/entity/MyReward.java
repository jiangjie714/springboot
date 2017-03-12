package com.fufang.bi.entity;

import java.math.BigDecimal;
import java.util.Date;

public class MyReward {
    private Integer id;

    private Integer pharmacyid;

    private Integer taskid;

    private Integer rewardid;

    private BigDecimal amount;

    private Date expiretime;

    private Date createdate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPharmacyid() {
        return pharmacyid;
    }

    public void setPharmacyid(Integer pharmacyid) {
        this.pharmacyid = pharmacyid;
    }

    public Integer getTaskid() {
        return taskid;
    }

    public void setTaskid(Integer taskid) {
        this.taskid = taskid;
    }

    public Integer getRewardid() {
        return rewardid;
    }

    public void setRewardid(Integer rewardid) {
        this.rewardid = rewardid;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Date getExpiretime() {
        return expiretime;
    }

    public void setExpiretime(Date expiretime) {
        this.expiretime = expiretime;
    }

    public Date getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }
}