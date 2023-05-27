package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class PaymentDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long paymentId;
	private Long userId;
	private Long cardNo;
	private String fullName;
	private String month;
	private String year;
	private String cvc;
	private String selectCard;
	private String selectDuration;
	private String bankName;
	private String acountNo;
	private String ifscCode;
	private String holderName;
	private String date;
	private String firstName;
	private String lastName;
	private String address;
	private String pinCode;
	private String selectContry;
	private String state;
	private String selectCity;
	private String mobliNo;
	private String amount;

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public Long getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(Long paymentId) {
		this.paymentId = paymentId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getCardNo() {
		return cardNo;
	}

	public void setCardNo(Long cardNo) {
		this.cardNo = cardNo;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getCvc() {
		return cvc;
	}

	public void setCvc(String cvc) {
		this.cvc = cvc;
	}

	public String getSelectCard() {
		return selectCard;
	}

	public void setSelectCard(String selectCard) {
		this.selectCard = selectCard;
	}

	public String getSelectDuration() {
		return selectDuration;
	}

	public void setSelectDuration(String selectDuration) {
		this.selectDuration = selectDuration;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public String getAcountNo() {
		return acountNo;
	}

	public void setAcountNo(String acountNo) {
		this.acountNo = acountNo;
	}

	public String getIfscCode() {
		return ifscCode;
	}

	public void setIfscCode(String ifscCode) {
		this.ifscCode = ifscCode;
	}

	public String getHolderName() {
		return holderName;
	}

	public void setHolderName(String holderName) {
		this.holderName = holderName;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPinCode() {
		return pinCode;
	}

	public void setPinCode(String pinCode) {
		this.pinCode = pinCode;
	}

	public String getSelectContry() {
		return selectContry;
	}

	public void setSelectContry(String selectContry) {
		this.selectContry = selectContry;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getSelectCity() {
		return selectCity;
	}

	public void setSelectCity(String selectCity) {
		this.selectCity = selectCity;
	}

	public String getMobliNo() {
		return mobliNo;
	}

	public void setMobliNo(String mobliNo) {
		this.mobliNo = mobliNo;
	}

	@Override
	public String toString() {
		return "PaymentDetails [paymentId=" + paymentId + ", userId=" + userId + ", cardNo=" + cardNo + ", fullName="
				+ fullName + ", month=" + month + ", year=" + year + ", cvc=" + cvc + ", selectCard=" + selectCard
				+ ", selectDuration=" + selectDuration + ", bankName=" + bankName + ", acountNo=" + acountNo
				+ ", ifscCode=" + ifscCode + ", holderName=" + holderName + ", date=" + date + ", firstName="
				+ firstName + ", lastName=" + lastName + ", address=" + address + ", pinCode=" + pinCode
				+ ", selectContry=" + selectContry + ", state=" + state + ", selectCity=" + selectCity + ", mobliNo="
				+ mobliNo + ", amount=" + amount + "]";
	}

}
