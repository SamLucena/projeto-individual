package app.vercel.samlucena.game.dto;

import app.vercel.samlucena.game.entities.GameReview;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.time.Instant;

public class GameReviewDTO {

    private Long id;

    @NotBlank(message = "Campo obrigatório")
    private String title;
    private UserDTO author;

    @Max(value = 10, message = "Valor acima de 10")
    @Min(value = 0, message = "Valor abaixo de 1")
    private Integer score;
    private String comment;
    private Instant moment;

    private PlatformDTO platform;

    public GameReviewDTO(){}

    public GameReviewDTO(GameReview entity){
        this.platform = new PlatformDTO(entity.getPlatform());
        this.id = entity.getId();
        this.title = entity.getTitle();
        this.author = new UserDTO(entity.getAuthor());
        this.comment = entity.getComment();
        this.moment = entity.getMoment();
        this.score = entity.getScore();
    }

    public GameReviewDTO(Long id, String title, UserDTO author, Integer score, String comment, Instant moment, PlatformDTO platform) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.score = score;
        this.comment = comment;
        this.moment = moment;
        this.platform = platform;
    }

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

    public UserDTO getAuthor() {
        return author;
    }

    public void setAuthor(UserDTO author) {
        this.author = author;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Instant getMoment() {
        return moment;
    }

    public void setMoment(Instant moment) {
        this.moment = moment;
    }

    public PlatformDTO getPlatform() {
        return platform;
    }

    public void setPlatform(PlatformDTO platform) {
        this.platform = platform;
    }
}

