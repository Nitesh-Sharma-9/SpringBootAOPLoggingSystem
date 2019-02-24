package com.decimal.model;


import com.vladmihalcea.hibernate.type.json.JsonBinaryType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.TypeDef;

import javax.persistence.*;

@Setter
@Getter
@Entity
@Table(name="ACCOUNT")
@NoArgsConstructor
@TypeDef(name = "jsonb", typeClass = JsonBinaryType.class)
public class Account {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ACCOUNT_NUMBER")
	private long accountNumber;

	@Column(name="ACCOUNT_HOLDER_NAME")
	private String accountHolderName;

	@Column(name="ACCOUNT_DESCRIPTION")
	private String accountDescription;

	@Column(name="BALANCE")
	private double balance;

	public long getAccountNumber() {
		return accountNumber;
	}
	public String getAccountHolderName() {
		return accountHolderName;
	}
}
