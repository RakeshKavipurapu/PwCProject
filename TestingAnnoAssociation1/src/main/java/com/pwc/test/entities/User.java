package com.pwc.test.entities;

import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
//Data is used to generate setters,getters,toString method
@NoArgsConstructor
//generates a 0-param constructor
@AllArgsConstructor
@RequiredArgsConstructor
/*
 * generates a parameterized constructor with properties having
 * 
 * @NonNull annotation
 */
@Entity
//Entity specifies that this class should be mapped to the database table

@Table(name = "user")
/*
 * Table specifies the specific name that should be given to the table in
 * database that is dynamically generated by hibernate
 */
public class User {

	@Id
	// Id specifies the primary key column in the table
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	// this works like a sequence which automatically generates the randon number
	private int userid;

	@NonNull
	@Column(length = 45, nullable = false)
	//column annotation can be used to specify the properties,constraints on the database columns
	private String name;
	@NonNull
	@Column(length = 60, nullable = false)
	private String address;
	@NonNull
	@Column(length = 45, nullable = false, unique = true)
	private String email;
	@NonNull
	@Column(length = 45, nullable = false, unique = true)
	private String password;
	@NonNull
	@OneToMany(targetEntity = Order.class, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	/*
	 * 1.OnetoMany annoataion can be used to specify a one-to-many between two tables
	 * 2.targetEntity specifies the target table(i.e:target table) with which the
	 * relationship needs to be established
	 * 3.cascade defines the association says what actions should cascade for that association. Cascade = "all" means that if both tables always remain in relation
	 */
	@JoinColumn(name = "USER_ID", referencedColumnName = "USERID")
	//JoinColumn is used to specify the foreign key column,along with the referenced key column
	private List<Order> orders;
}
