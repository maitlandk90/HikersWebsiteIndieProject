package edu.matc.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.Period;
import java.util.HashSet;
import java.util.Set;


/**
 * A class to represent a hiker account.
 *
 * @author dmiller
 */
@Entity(name = "HikerAccount")
@Table(name = "Hiker_Account")
public class HikerAccount {
    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "city")
    private String city;

    @Column(name = "state")
    private String state;

    @Column(name = "email_address")
    private String emailAddress;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private int id;

    @OneToMany(mappedBy = "hikerAccount", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private Set<HikingTrails> hikingTrails = new HashSet<>();

    /**
     * Instantiates a new Hiker Account.
     */
    public HikerAccount() {
    }

    /**
     * Instantiates a new Hiker Account.
     *
     * @param firstName    the first name
     * @param lastName     the last name
     * @param city         the city
     * @param state        the state
     * @param emailAddress the email address
     * @param id           the id
     */
    public HikerAccount(String firstName, String lastName, String city, String state, String emailAddress, int id) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.city = city;
        this.state = state;
        this.emailAddress = emailAddress;
        this.id = id;
    }


    /**
     * Gets first name.
     *
     * @return the first name
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets first name.
     *
     * @param firstName the first name
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Gets last name.
     *
     * @return the last name
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets last name.
     *
     * @param lastName the last name
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Gets city.
     *
     * @return the city
     */
    public String getCity() {
        return city;
    }

    /**
     * Sets city.
     *
     * @param city the city
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * Gets state.
     *
     * @return the state
     */
    public String getState() {
        return state;
    }

    /**
     * Sets state.
     *
     * @param state the state
     */
    public void setState(String state) {
        this.state = state;
    }

    /**
     * Gets email address.
     *
     * @return the email address
     */
    public String getEmailAddress() {
        return emailAddress;
    }

    /**
     * Sets email address.
     *
     * @param emailAddress the email address
     */
    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    /**
     * Gets id.
     *
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * Sets id.
     *
     * @param id the id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Gets hiking trails.
     *
     * @return the hiking trails
     */
    public Set<HikingTrails> getHikingTrails() {
        return hikingTrails;
    }

    /**
     * Sets hiking trails.
     *
     * @param hikingTrails the hiking trails
     */
    public void setHikingTrails(Set<HikingTrails> hikingTrails) {
        this.hikingTrails = hikingTrails;
    }

    /**
     * Add hiking trail.
     *
     * @param hikingTrail the hiking trail
     */
    public void addHikingTrail(HikingTrails hikingTrail) {
        hikingTrails.add(hikingTrail);
        hikingTrail.setHikerAccount(this);
    }

    /**
     * Remove hiking trail.
     *
     * @param hikingTrail the hiking trail
     */
    public void removeHikingTrail(HikingTrails hikingTrail) {
        hikingTrails.remove(hikingTrail);
        hikingTrail.setHikerAccount(null);
    }


    @Override
    public String toString() {
        return "HikerAccount{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", city='" + city + '\'' +
                ", state ='" + state + '\'' +
                ", emailAddress = '" + emailAddress + '\'' +
                ", id=" + id + '\'' +
                '}';
    }
}