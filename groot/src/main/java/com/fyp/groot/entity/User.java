package com.fyp.groot.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;
import java.time.OffsetDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "user")
public class User {

	@Id
	@Column(name = "user_id", nullable = false, updatable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long userId;
	@Column
	private String username;
	@Column
	private String password;
	@Column
	private Date lastLogin;
	@Column
	private String firstName;
	@Column
	private String lastName;
	@Column
	private String emailId;
	@Column
	private String phoneNumber;
	@Column
	private String address;
	@Column
	private String city;
	@Column
	private String country;
	@Column(name = "user_since")
	private OffsetDateTime userSince;
	@Column
	private String status;
	@Column(name = "device_user")
	private String deviceUsed;
	@Column
	private String firebaseId;
	@Column
	private String isActive;
	@Column(name = "user_type")
	private String userType;
	@Column(name = "culture_id")
	private Long cultureId;
	@Column(name = "university_id")
	private Long universityId;
	@Column(name = "admin_type")
	private Long adminType;
	@Column(name = "plane_id")
	private Long planeId;
}
