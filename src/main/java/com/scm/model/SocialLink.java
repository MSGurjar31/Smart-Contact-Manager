package com.scm.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class SocialLink {

    @Id
    private Long id;
    private String link;
    private String title;

    @ManyToOne
    private SCM_Contact contact;
}
