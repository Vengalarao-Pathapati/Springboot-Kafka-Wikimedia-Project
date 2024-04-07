package com.springboot.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="wikimedia_recentchange")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class WikimediaData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//   in order to store large amount of data in an object we need to use @Lob
//    @Column(length = 100000)
    @Lob
//    @Column(columnDefinition = "longtext")
    private String wikiEventData;


}
