package com.elasticsearch.models;

import javax.persistence.*;


@Entity
@Table(name = "job_offer")  // Maps to the "job_offer" table in the database
public class JobOfferJPA {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)  // Auto-generates ID values
        private Long id;

        @Column(name = "title")  // Maps to the "title" column in the table
        private String title;

        @Column(name = "description")  // Maps to the "description" column in the table
        private String description;

        @Column(name = "city")  // Maps to the "city" column in the table
        private String city;

        @Column(name = "postal_code")  // Maps to the "postal_code" column in the table
        private String postalCode;

        @Column(name = "region")  // Maps to the "region" column in the table
        private String region;

        public Long getId() {
                return id;
        }

        public void setId(Long id) {
                this.id = id;
        }

        public String getTitle() {
                return title;
        }

        public void setTitle(String title) {
                this.title = title;
        }

        public String getDescription() {
                return description;
        }

        public void setDescription(String description) {
                this.description = description;
        }

        public String getCity() {
                return city;
        }

        public void setCity(String city) {
                this.city = city;
        }

        public String getPostalCode() {
                return postalCode;
        }

        public void setPostalCode(String postalCode) {
                this.postalCode = postalCode;
        }

        public String getRegion() {
                return region;
        }

        public void setRegion(String region) {
                this.region = region;
        }
}
