package com.garden.entities;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter

@NoArgsConstructor
public class Role {
    @Id
    @Column(nullable = false)
	private Long roleId;
    
    @Column(nullable = false)
	private String roleName;
    
	@ManyToMany(mappedBy = "role")
	Set<User> user=new HashSet<>();

	

	
	
	
}
