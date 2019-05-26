package exbooks.api.entities;

import java.time.LocalDate;


public class Details {
    private Integer idBook;
    private String nameBook;
    private String genreBook;
    private String descriptionBook;
    private String authorBook;
    private LocalDate yearBook;

    private Long idUser;
    private String emailUser;
    private String phoneUser;
    private String firstNameUser;
    private String surnameUser;
    public Details() {
    }

    public Details(Integer idBook, String nameBook, String genreBook, String descriptionBook, String authorBook, LocalDate yearBook, Long idUser, String emailUser, String phoneUser, String passwordUser, String firstNameUser, String surnameUser, Boolean isActiveUser) {
        this.idBook = idBook;
        this.nameBook = nameBook;
        this.genreBook = genreBook;
        this.descriptionBook = descriptionBook;
        this.authorBook = authorBook;
        this.yearBook = yearBook;
        this.idUser = idUser;
        this.emailUser = emailUser;
        this.phoneUser = phoneUser;
        this.firstNameUser = firstNameUser;
        this.surnameUser = surnameUser;

    }

    public Integer getIdBook() {
        return idBook;
    }

    public void setIdBook(Integer idBook) {
        this.idBook = idBook;
    }

    public String getNameBook() {
        return nameBook;
    }

    public void setNameBook(String nameBook) {
        this.nameBook = nameBook;
    }

    public String getGenreBook() {
        return genreBook;
    }

    public void setGenreBook(String genreBook) {
        this.genreBook = genreBook;
    }

    public String getDescriptionBook() {
        return descriptionBook;
    }

    public void setDescriptionBook(String descriptionBook) {
        this.descriptionBook = descriptionBook;
    }

    public String getAuthorBook() {
        return authorBook;
    }

    public void setAuthorBook(String authorBook) {
        this.authorBook = authorBook;
    }

    public LocalDate getYearBook() {
        return yearBook;
    }

    public void setYearBook(LocalDate yearBook) {
        this.yearBook = yearBook;
    }

    public Long getIdUser() {
        return idUser;
    }

    public void setIdUser(Long idUser) {
        this.idUser = idUser;
    }

    public String getEmailUser() {
        return emailUser;
    }

    public void setEmailUser(String emailUser) {
        this.emailUser = emailUser;
    }

    public String getPhoneUser() {
        return phoneUser;
    }

    public void setPhoneUser(String phoneUser) {
        this.phoneUser = phoneUser;
    }


    public String getFirstNameUser() {
        return firstNameUser;
    }

    public void setFirstNameUser(String firstNameUser) {
        this.firstNameUser = firstNameUser;
    }

    public String getSurnameUser() {
        return surnameUser;
    }

    public void setSurnameUser(String surnameUser) {
        this.surnameUser = surnameUser;
    }



    @Override
    public String toString() {
        return "Details{" +
                "idBook=" + idBook +
                ", nameBook='" + nameBook + '\'' +
                ", genreBook='" + genreBook + '\'' +
                ", descriptionBook='" + descriptionBook + '\'' +
                ", authorBook='" + authorBook + '\'' +
                ", yearBook=" + yearBook +
                ", idUser=" + idUser +
                ", emailUser='" + emailUser + '\'' +
                ", phoneUser='" + phoneUser + '\'' +
                ", firstNameUser='" + firstNameUser + '\'' +
                ", surnameUser='" + surnameUser + '\'' +
                '}';
    }
}
