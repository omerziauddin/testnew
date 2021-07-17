package com.aquicksoft.dto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class Order implements Serializable {
public String txId;
public String userId;
public String hbKey;

@JsonCreator
public Order(@JsonProperty("txnId") final String txId, @JsonProperty("userId") final String userId,
		@JsonProperty("hbkey") final String hbKey) {
	this.txId = txId;
	this.userId = userId;
	this.hbKey = hbKey;
}
}
