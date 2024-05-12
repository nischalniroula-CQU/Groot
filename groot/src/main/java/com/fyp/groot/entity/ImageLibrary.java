package com.fyp.groot.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class ImageLibrary {

	@Id
	@Column(name = "image_id", nullable = false, updatable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long imageId;
	@Column(name = "type")
	private String type;
	@Column(name = "image_name")
	private String imageName;
	@Column(name = "post_id")
	private Long postId;
}
