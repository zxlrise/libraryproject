package com.xiao.po;

import java.io.Serializable;
import java.util.Date;

public class ReaderCard implements Serializable {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column reader_card.id
     *
     * @mbggenerated Fri Jun 26 20:50:53 CST 2020
     */
    private Integer id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column reader_card.username
     *
     * @mbggenerated Fri Jun 26 20:50:53 CST 2020
     */
    private String username;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column reader_card.password
     *
     * @mbggenerated Fri Jun 26 20:50:53 CST 2020
     */
    private String password;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column reader_card.number
     *
     * @mbggenerated Fri Jun 26 20:50:53 CST 2020
     */
    private Integer number;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column reader_card.name
     *
     * @mbggenerated Fri Jun 26 20:50:53 CST 2020
     */
    private String name;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column reader_card.sex
     *
     * @mbggenerated Fri Jun 26 20:50:53 CST 2020
     */
    private String sex;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column reader_card.birthday
     *
     * @mbggenerated Fri Jun 26 20:50:53 CST 2020
     */
    private Date birthday;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column reader_card.address
     *
     * @mbggenerated Fri Jun 26 20:50:53 CST 2020
     */
    private String address;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column reader_card.tel
     *
     * @mbggenerated Fri Jun 26 20:50:53 CST 2020
     */
    private String tel;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column reader_card.email
     *
     * @mbggenerated Fri Jun 26 20:50:53 CST 2020
     */
    private String email;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column reader_card.creat_date
     *
     * @mbggenerated Fri Jun 26 20:50:53 CST 2020
     */
    private Date creatDate;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column reader_card.cjr
     *
     * @mbggenerated Fri Jun 26 20:50:53 CST 2020
     */
    private Integer cjr;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column reader_card.cardnumber
     *
     * @mbggenerated Fri Jun 26 20:50:53 CST 2020
     */
    private String cardnumber;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table reader_card
     *
     * @mbggenerated Fri Jun 26 20:50:53 CST 2020
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column reader_card.id
     *
     * @return the value of reader_card.id
     *
     * @mbggenerated Fri Jun 26 20:50:53 CST 2020
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column reader_card.id
     *
     * @param id the value for reader_card.id
     *
     * @mbggenerated Fri Jun 26 20:50:53 CST 2020
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column reader_card.username
     *
     * @return the value of reader_card.username
     *
     * @mbggenerated Fri Jun 26 20:50:53 CST 2020
     */
    public String getUsername() {
        return username;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column reader_card.username
     *
     * @param username the value for reader_card.username
     *
     * @mbggenerated Fri Jun 26 20:50:53 CST 2020
     */
    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column reader_card.password
     *
     * @return the value of reader_card.password
     *
     * @mbggenerated Fri Jun 26 20:50:53 CST 2020
     */
    public String getPassword() {
        return password;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column reader_card.password
     *
     * @param password the value for reader_card.password
     *
     * @mbggenerated Fri Jun 26 20:50:53 CST 2020
     */
    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column reader_card.number
     *
     * @return the value of reader_card.number
     *
     * @mbggenerated Fri Jun 26 20:50:53 CST 2020
     */
    public Integer getNumber() {
        return number;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column reader_card.number
     *
     * @param number the value for reader_card.number
     *
     * @mbggenerated Fri Jun 26 20:50:53 CST 2020
     */
    public void setNumber(Integer number) {
        this.number = number;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column reader_card.name
     *
     * @return the value of reader_card.name
     *
     * @mbggenerated Fri Jun 26 20:50:53 CST 2020
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column reader_card.name
     *
     * @param name the value for reader_card.name
     *
     * @mbggenerated Fri Jun 26 20:50:53 CST 2020
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column reader_card.sex
     *
     * @return the value of reader_card.sex
     *
     * @mbggenerated Fri Jun 26 20:50:53 CST 2020
     */
    public String getSex() {
        return sex;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column reader_card.sex
     *
     * @param sex the value for reader_card.sex
     *
     * @mbggenerated Fri Jun 26 20:50:53 CST 2020
     */
    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column reader_card.birthday
     *
     * @return the value of reader_card.birthday
     *
     * @mbggenerated Fri Jun 26 20:50:53 CST 2020
     */
    public Date getBirthday() {
        return birthday;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column reader_card.birthday
     *
     * @param birthday the value for reader_card.birthday
     *
     * @mbggenerated Fri Jun 26 20:50:53 CST 2020
     */
    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column reader_card.address
     *
     * @return the value of reader_card.address
     *
     * @mbggenerated Fri Jun 26 20:50:53 CST 2020
     */
    public String getAddress() {
        return address;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column reader_card.address
     *
     * @param address the value for reader_card.address
     *
     * @mbggenerated Fri Jun 26 20:50:53 CST 2020
     */
    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column reader_card.tel
     *
     * @return the value of reader_card.tel
     *
     * @mbggenerated Fri Jun 26 20:50:53 CST 2020
     */
    public String getTel() {
        return tel;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column reader_card.tel
     *
     * @param tel the value for reader_card.tel
     *
     * @mbggenerated Fri Jun 26 20:50:53 CST 2020
     */
    public void setTel(String tel) {
        this.tel = tel == null ? null : tel.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column reader_card.email
     *
     * @return the value of reader_card.email
     *
     * @mbggenerated Fri Jun 26 20:50:53 CST 2020
     */
    public String getEmail() {
        return email;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column reader_card.email
     *
     * @param email the value for reader_card.email
     *
     * @mbggenerated Fri Jun 26 20:50:53 CST 2020
     */
    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column reader_card.creat_date
     *
     * @return the value of reader_card.creat_date
     *
     * @mbggenerated Fri Jun 26 20:50:53 CST 2020
     */
    public Date getCreatDate() {
        return creatDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column reader_card.creat_date
     *
     * @param creatDate the value for reader_card.creat_date
     *
     * @mbggenerated Fri Jun 26 20:50:53 CST 2020
     */
    public void setCreatDate(Date creatDate) {
        this.creatDate = creatDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column reader_card.cjr
     *
     * @return the value of reader_card.cjr
     *
     * @mbggenerated Fri Jun 26 20:50:53 CST 2020
     */
    public Integer getCjr() {
        return cjr;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column reader_card.cjr
     *
     * @param cjr the value for reader_card.cjr
     *
     * @mbggenerated Fri Jun 26 20:50:53 CST 2020
     */
    public void setCjr(Integer cjr) {
        this.cjr = cjr;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column reader_card.cardnumber
     *
     * @return the value of reader_card.cardnumber
     *
     * @mbggenerated Fri Jun 26 20:50:53 CST 2020
     */
    public String getCardnumber() {
        return cardnumber;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column reader_card.cardnumber
     *
     * @param cardnumber the value for reader_card.cardnumber
     *
     * @mbggenerated Fri Jun 26 20:50:53 CST 2020
     */
    public void setCardnumber(String cardnumber) {
        this.cardnumber = cardnumber == null ? null : cardnumber.trim();
    }
}