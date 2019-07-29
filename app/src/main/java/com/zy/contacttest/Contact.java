package com.zy.contacttest;

/**
 * /*@Description
 * /*created by wwq on 2019/7/29
 * /*@company zhongyiqiankun
 */
public class Contact {
    private String mFirstLetter;
    private String mName;
    private String mPhone;
    private String mPicUrl;

    public Contact(String firstLetter, String name, String phone, String picUrl) {
        mFirstLetter = firstLetter;
        mName = name;
        mPhone = phone;
        mPicUrl = picUrl;
    }

    public String getFirstLetter() {
        return mFirstLetter;
    }

    public void setFirstLetter(String firstLetter) {
        mFirstLetter = firstLetter;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public String getPhone() {
        return mPhone;
    }

    public void setPhone(String phone) {
        mPhone = phone;
    }

    public String getPicUrl() {
        return mPicUrl;
    }

    public void setPicUrl(String picUrl) {
        mPicUrl = picUrl;
    }

}
