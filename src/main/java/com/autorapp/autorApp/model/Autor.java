package com.autorapp.autorApp.model;

import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;


    @Entity
    @NoArgsConstructor
    public class Autor implements Serializable {

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        @Column(nullable = false, updatable = false)
        private Long idBroj;
        private String ime;
        private String prezime;
        private String nazivKnjige;

        public Autor(Long id, String ime, String prezime, String nazivKnjige) {
            this.idBroj = id;
            this.ime = ime;
            this.prezime = prezime;
            this.nazivKnjige = nazivKnjige;
        }

        public Long getId() {
            return idBroj;
        }

        public void setId(Long id) {
            this.idBroj = id;
        }

        public String getIme() {
            return ime;
        }

        public void setIme(String ime) {
            this.ime = ime;
        }

        public String getPrezime() {
            return prezime;
        }

        public void setPrezime(String prezime) {
            this.prezime = prezime;
        }

        public String getNazivKnjige() {
            return nazivKnjige;
        }

        public void setNazivKnjige(String nazivKnjige) {
            this.nazivKnjige = nazivKnjige;
        }

        @Override
        public String toString() {
            return "Autor{" +
                    "id=" + idBroj +
                    ", ime='" + ime + '\'' +
                    ", prezime='" + prezime + '\'' +
                    ", nazivKnjige='" + nazivKnjige + '\'' +
                    '}';
        }


    }

