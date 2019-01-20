package com.sane.partake.entity.user;

import java.io.Serializable;
import java.util.Date;

public class User implements Serializable {
    private String userName;
    private String userNo;
    private Date birthDate;
    private String spellCode;
    private String wbzxCode;
    private Date createdTime;
    private Date modifiedTime;
    private String validFlag;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserNo() {
        return userNo;
    }

    public void setUserNo(String userNo) {
        this.userNo = userNo;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getSpellCode() {
        return spellCode;
    }

    public void setSpellCode(String spellCode) {
        this.spellCode = spellCode;
    }

    public String getWbzxCode() {
        return wbzxCode;
    }

    public void setWbzxCode(String wbzxCode) {
        this.wbzxCode = wbzxCode;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public Date getModifiedTime() {
        return modifiedTime;
    }

    public void setModifiedTime(Date modifiedTime) {
        this.modifiedTime = modifiedTime;
    }

    public String getValidFlag() {
        return validFlag;
    }

    public void setValidFlag(String validFlag) {
        this.validFlag = validFlag;
    }
}
