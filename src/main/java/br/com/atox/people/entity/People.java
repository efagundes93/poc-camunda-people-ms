package br.com.atox.people.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "people")
@EntityListeners(AuditingEntityListener.class)
public class People implements Serializable {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7610781211345472934L;

	@Id
	@GeneratedValue
	private Long id;

	private String legalDocumentNumber;

	private String name;
	
	private LocalDate birthDate;

	private String email;

	private LocalDateTime updatedAt;
	
	public People() {
		
	}

	public People(Long id, String legalDocumentNumber, String name, LocalDate birthDate, String email,
			LocalDateTime updatedAt) {
		super();
		this.id = id;
		this.legalDocumentNumber = legalDocumentNumber;
		this.name = name;
		this.birthDate = birthDate;
		this.email = email;
		this.updatedAt = updatedAt;
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the legalDocumentNumber
	 */
	public String getLegalDocumentNumber() {
		return legalDocumentNumber;
	}

	/**
	 * @param legalDocumentNumber the legalDocumentNumber to set
	 */
	public void setLegalDocumentNumber(String legalDocumentNumber) {
		this.legalDocumentNumber = legalDocumentNumber;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the birthDate
	 */
	public LocalDate getBirthDate() {
		return birthDate;
	}

	/**
	 * @param birthDate the birthDate to set
	 */
	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the updatedAt
	 */
	public LocalDateTime getUpdatedAt() {
		return updatedAt;
	}

	/**
	 * @param updatedAt the updatedAt to set
	 */
	public void setUpdatedAt(LocalDateTime updatedAt) {
		this.updatedAt = updatedAt;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((birthDate == null) ? 0 : birthDate.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((legalDocumentNumber == null) ? 0 : legalDocumentNumber.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((updatedAt == null) ? 0 : updatedAt.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof People))
			return false;
		People other = (People) obj;
		if (birthDate == null) {
			if (other.birthDate != null)
				return false;
		} else if (!birthDate.equals(other.birthDate))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (legalDocumentNumber == null) {
			if (other.legalDocumentNumber != null)
				return false;
		} else if (!legalDocumentNumber.equals(other.legalDocumentNumber))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (updatedAt == null) {
			if (other.updatedAt != null)
				return false;
		} else if (!updatedAt.equals(other.updatedAt))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "People [id=" + id + ", legalDocumentNumber=" + legalDocumentNumber + ", name=" + name + ", birthDate="
				+ birthDate + ", email=" + email + ", updatedAt=" + updatedAt + "]";
	}

}
