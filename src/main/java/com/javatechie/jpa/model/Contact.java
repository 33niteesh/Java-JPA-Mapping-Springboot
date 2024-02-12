package com.javatechie.jpa.model;

import javax.persistence.*;

import lombok.*;

@Entity
@Table(name = "contact")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Contact {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
    private String city;
    private String number;

    @OneToOne(mappedBy = "contact")
    private Employee employee;

	@Override
	public String toString() {
		return "Contact [id=" + id + ", city=" + city + ", number=" + number + ", employee=" + employee
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public Contact( String city, String number, Employee employee) {
		super();
		this.city = city;
		this.number = number;
		this.employee = employee;
	}

	public Contact() {
		super();
		// TODO Auto-generated constructor stub
	}
    
    
}

