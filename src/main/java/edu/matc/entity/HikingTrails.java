package edu.matc.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;


/**
 * The type Hiking trails.
 */
@Entity(name = "HikingTrails")
@Table(name = "Hiking_Trails")
public class HikingTrails {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private int id;

    @Column(name = "trail_head_name")
    private String trailHeadName;

    @Column(name = "trail_description")
    private String trailDescription;

    @Column(name = "trail_length")
    private int trailLength;

    @Column(name = "trail_difficulty")
    private int trailDifficulty;

    @Column(name = "trail_rating")
    private int trailRating;

    @Column(name = "trail_features")
    private String trailFreatures;

    @Column(name = "trail_details")
    private String trailDetails;

    @ManyToOne
    @JoinColumn(name = "hiker_account_id")
    private HikerAccount hikerAccount;


    /**
     * Instantiates a new Hiking trails.
     */
    public HikingTrails() {
    }

    /**
     * Instantiates a new Hiking trails.
     *
     * @param trailHeadName    the trail head name
     * @param trailDescription the trail description
     * @param trailLength      the trail length
     * @param trailDifficulty  the trail difficulty
     * @param trailRating      the trail rating
     * @param trailFeatures    the trail features
     * @param trailDetails     the trail details
     * @param hikerAccount     the hiker account
     */
    public HikingTrails(String trailHeadName, String trailDescription, int trailLength,
                        int trailDifficulty, int trailRating, String trailFeatures,
                        String trailDetails, HikerAccount hikerAccount) {
        this.trailHeadName = trailHeadName;
        this.trailDescription = trailDescription;
        this.trailLength = trailLength;
        this.trailDifficulty = trailDifficulty;
        this.trailRating = trailRating;
        this.trailFreatures = trailFeatures;
        this.trailDetails = trailDetails;
        this.hikerAccount = hikerAccount;
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
     * Gets trail head name.
     *
     * @return the trail head name
     */
    public String getTrailHeadName() {
        return trailHeadName;
    }

    /**
     * Sets trail head name.
     *
     * @param trailHeadName the trail head name
     */
    public void setTrailHeadName(String trailHeadName) {
        this.trailHeadName = trailHeadName;
    }

    /**
     * Gets trail description.
     *
     * @return the trail description
     */
    public String getTrailDescription() {
        return trailDescription;
    }

    /**
     * Sets trail description.
     *
     * @param trailDescription the trail description
     */
    public void setTrailDescription(String trailDescription) {
        this.trailDescription = trailDescription;
    }

    /**
     * Gets trail length.
     *
     * @return the trail length
     */
    public int getTrailLength() {
        return trailLength;
    }

    /**
     * Sets trail length.
     *
     * @param trailLength the trail length
     */
    public void setTrailLength(int trailLength) {
        this.trailLength = trailLength;
    }

    /**
     * Gets trail difficulty.
     *
     * @return the trail difficulty
     */
    public int getTrailDifficulty() {
        return trailDifficulty;
    }

    /**
     * Sets trail difficulty.
     *
     * @param trailDifficulty the trail difficulty
     */
    public void setTrailDifficulty(int trailDifficulty) {
        this.trailDifficulty = trailDifficulty;
    }

    /**
     * Gets trail rating.
     *
     * @return the trail rating
     */
    public int getTrailRating() {
        return trailRating;
    }

    /**
     * Sets trail rating.
     *
     * @param trailRating the trail rating
     */
    public void setTrailRating(int trailRating) {
        this.trailRating = trailRating;
    }

    /**
     * Gets trail freatures.
     *
     * @return the trail freatures
     */
    public String getTrailFreatures() {
        return trailFreatures;
    }

    /**
     * Sets trail freatures.
     *
     * @param trailFreatures the trail freatures
     */
    public void setTrailFreatures(String trailFreatures) {
        this.trailFreatures = trailFreatures;
    }

    /**
     * Gets trail details.
     *
     * @return the trail details
     */
    public String getTrailDetails() {
        return trailDetails;
    }

    /**
     * Sets trail details.
     *
     * @param trailDetails the trail details
     */
    public void setTrailDetails(String trailDetails) {
        this.trailDetails = trailDetails;
    }

    /**
     * Gets hiker account.
     *
     * @return the hiker account
     */
    public HikerAccount getHikerAccount() {
        return hikerAccount;
    }

    /**
     * Sets hiker account.
     *
     * @param hikerAccount the hiker account
     */
    public void setHikerAccount(HikerAccount hikerAccount) {
        this.hikerAccount = hikerAccount;
    }

    @Override
    public String toString() {
        return "HikingTrails{" +
                "id=" + id +
                ", trailHeadName='" + trailHeadName + '\'' +
                ", trailDescription='" + trailDescription + '\'' +
                ", trailLength=" + trailLength +
                ", trailDifficulty=" + trailDifficulty +
                ", trailRating=" + trailRating +
                ", trailFreatures='" + trailFreatures + '\'' +
                ", trailDetails='" + trailDetails + '\'' +
                ", hikerAccount=" + hikerAccount +
                '}';
    }
}
