package com.aliergul.app.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "movies")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class MovieEntity implements Serializable {
  private static final long serialVersionUID = -7770082978323250446L;
  @Id
  private long movieid;
  private String title;
  private String genres;
  @ToString.Exclude
  @OneToMany(mappedBy = "movieid", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
  private List<RatingsEntity> ratings = new ArrayList<RatingsEntity>();
  @ToString.Exclude
  @OneToMany(mappedBy = "movieid", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
  private List<TagEntity> tags = new ArrayList<TagEntity>();



  public MovieEntity(long movieid, String title, String genres) {
    super();
    this.movieid = movieid;
    this.title = title;
    this.genres = genres;
  }

  // @OneToOne(mappedBy = "movie", cascade = CascadeType.ALL)
  // @JoinTable(name = "links")
  // private LinkEntity links;
  // @OneToMany(fetch = FetchType.EAGER, mappedBy = "tagMovie")
  // private Set<TagEntity> tags = new HashSet<>(0);
  //

  // @ManyToMany(cascade = {CascadeType.ALL})
  // @JoinTable(name = "tags", joinColumns = {@JoinColumn(name = "movieid")},
  // inverseJoinColumns = {@JoinColumn(name = "movieid")})
  // private List<TagEntity> tags = new ArrayList<>();
  //
  // @ManyToMany(cascade = {CascadeType.ALL})
  // @JoinTable(name = "ratings", joinColumns = {@JoinColumn(name = "movieid")},
  // inverseJoinColumns = {@JoinColumn(name = "movieid")})
  // private List<RatingsEntity> ratings = new ArrayList<>();


}
