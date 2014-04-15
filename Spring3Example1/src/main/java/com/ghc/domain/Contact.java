/**
 * Contact.java
 *
 *	
 */
package com.ghc.domain;

import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

/**
 * 
 */
@Entity
@Table(name = "contact")
public class Contact {
	private Long mId;
	private int mVersion;
	private String mFirstName;
	private String mLastName;
	private Date mBirthDate;
	private String mDescription;
	private byte[] mPhoto;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	public Long getId() {
		return mId;
	}

	public void setId(Long id) {
		mId = id;
	}

	@Version
	@Column(name = "version")
	public int getVersion() {
		return mVersion;
	}

	public void setVersion(int version) {
		mVersion = version;
	}

	@Column(name = "first_name")
	public String getFirstName() {
		return mFirstName;
	}

	public void setFirstName(String firstName) {
		mFirstName = firstName;
	}

	@Column(name = "last_name")
	public String getLastName() {
		return mLastName;
	}

	public void setLastName(String lastName) {
		mLastName = lastName;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "birth_date")
	public Date getBirthDate() {
		return mBirthDate;
	}

	public void setBirthDate(Date birthDate) {
		mBirthDate = birthDate;
	}

	@Column(name = "description")
	public String getDescription() {
		return mDescription;
	}

	public void setDescription(String description) {
		mDescription = description;
	}

	@Basic(fetch = FetchType.LAZY)
	@Column(name = "photo")
	@Lob
	public byte[] getPhoto() {
		return mPhoto;
	}

	public void setPhoto(byte[] photo) {
		mPhoto = photo;
	}

	@javax.persistence.Transient
	public String getBirthDateString() {
		String birthDateString = "";
		if (mBirthDate != null)
			birthDateString = org.joda.time.format.DateTimeFormat.forPattern(
					"yyyy-MM-dd").print(mBirthDate);
		return birthDateString;
	}

	public String toString() {
		return "Contact - Id: " + mId + ", First name: " + mFirstName
				+ ", Last name: " + mLastName + ", Birthday: " + mBirthDate
				+ ", Description: " + mDescription;
	}

}
