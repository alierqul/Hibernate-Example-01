package com.aliergul.app.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@EqualsAndHashCode
@Table(name = "movies")
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class MovieEntity implements Serializable {
  private static final long serialVersionUID = -7770082978323250446L;

  private long movieid;
  private String title;
  private String genres;

  @ToString.Exclude
  private LinkEntity link;

  @ToString.Exclude
  private List<RatingsEntity> ratings = new ArrayList<RatingsEntity>();

  @ToString.Exclude
  private List<TagEntity> tags = new ArrayList<TagEntity>();


  public MovieEntity(long movieid, String title, String genres) {
    super();
    this.movieid = movieid;
    this.title = title;
    this.genres = genres;
  }


  @Id
  public long getMovieid() {
    return movieid;
  }


  public void setMovieid(long movieid) {
    this.movieid = movieid;
  }


  public String getTitle() {
    return title;
  }


  public void setTitle(String title) {
    this.title = title;
  }


  public String getGenres() {
    return genres;
  }


  public void setGenres(String genres) {
    this.genres = genres;
  }

  @OneToOne(cascade = CascadeType.PERSIST)
  @JoinColumn(name = "movieid")
  public LinkEntity getLink() {
    return link;
  }

  public void setLink(LinkEntity link) {
    this.link = link;
  }

  @OneToMany(mappedBy = "movie", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
  public List<RatingsEntity> getRatings() {
    return ratings;
  }


  public void setRatings(List<RatingsEntity> ratings) {
    this.ratings = ratings;
  }

  @OneToMany(mappedBy = "movie", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
  public List<TagEntity> getTags() {
    return tags;
  }



  public void setTags(List<TagEntity> tags) {
    this.tags = tags;
  }


}
