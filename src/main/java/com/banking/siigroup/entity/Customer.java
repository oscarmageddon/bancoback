package com.banking.siigroup.entity;

import javax.validation.constraints.NotBlank;

import org.springframework.data.annotation.Id;

/**
 * @author indir
 *
 */
public class Customer {

	@Id
	public String id;
	@NotBlank (message="Dede ingresar primer nombre")
	private String firstName;
	@NotBlank (message="Dede ingresar segundo nombre")
	private String secondName;
	@NotBlank (message="Dede ingresar primer apellido")
	private String firstSurName;
	@NotBlank (message="Dede ingresar segundo apellido")
	private String secondSurName;
	private String passport;
	@NotBlank (message="Dede ingresar numero de telefono")
	private String phoneOne;
	private String phoneTwo;
	@NotBlank (message="Dede ingresar direccion principal")
	private String mainAddressOne;
	private String optionalAddres;
	private String referencePhoneOne;
	private String referencePhoneTwo;
	@NotBlank (message="Dede ingresar estado civil")
	private String civilStatus;
	@NotBlank (message="Dede ingresar nombre de persona contacto")
	private String contactName;
	@NotBlank (message="Dede ingresar telefono de persona contacto")
	private String contactPhone;
	private String companyName;
	@NotBlank (message="Dede ingresar professión")
	private String profession;	
	private ECategory category;

	public ECategory getCategory() {
		return category;
	}

	public void setCategory(ECategory category) {
		this.category = category;
	}

	private boolean deleted = Boolean.FALSE;

	public String getId() {
		return id;
	}

	public boolean getDeleted() {
		return deleted;
	}

	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getSecondName() {
		return secondName;
	}

	public void setSecondName(String secondName) {
		this.secondName = secondName;
	}

	public String getFirstSurName() {
		return firstSurName;
	}

	public void setFirstSurName(String firstSurName) {
		this.firstSurName = firstSurName;
	}

	public String getSecondSurName() {
		return secondSurName;
	}

	public void setSecondSurName(String secondSurName) {
		this.secondSurName = secondSurName;
	}

	public String getPassport() {
		return passport;
	}

	public void setPassport(String passport) {
		this.passport = passport;
	}

	public String getPhoneOne() {
		return phoneOne;
	}

	public void setPhoneOne(String phoneOne) {
		this.phoneOne = phoneOne;
	}

	public String getPhoneTwo() {
		return phoneTwo;
	}

	public void setPhoneTwo(String phoneTwo) {
		this.phoneTwo = phoneTwo;
	}

	public String getMainAddressOne() {
		return mainAddressOne;
	}

	public void setMainAddressOne(String mainAddressOne) {
		this.mainAddressOne = mainAddressOne;
	}

	public String getOptionalAddres() {
		return optionalAddres;
	}

	public void setOptionalAddres(String optionalAddres) {
		this.optionalAddres = optionalAddres;
	}

	public String getReferencePhoneOne() {
		return referencePhoneOne;
	}

	public void setReferencePhoneOne(String referencePhoneOne) {
		this.referencePhoneOne = referencePhoneOne;
	}

	public String getReferencePhoneTwo() {
		return referencePhoneTwo;
	}

	public void setReferencePhoneTwo(String referencePhoneTwo) {
		this.referencePhoneTwo = referencePhoneTwo;
	}

	public String getCivilStatus() {
		return civilStatus;
	}

	public void setCivilStatus(String civilStatus) {
		this.civilStatus = civilStatus;
	}

	public String getContactName() {
		return contactName;
	}

	public void setContactName(String contactName) {
		this.contactName = contactName;
	}

	public String getContactPhone() {
		return contactPhone;
	}

	public void setContactPhone(String contactPhone) {
		this.contactPhone = contactPhone;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getProfession() {
		return profession;
	}

	public void setProfession(String profession) {
		this.profession = profession;
	}

}
