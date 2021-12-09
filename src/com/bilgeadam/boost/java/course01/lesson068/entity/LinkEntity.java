package com.bilgeadam.boost.java.course01.lesson068.entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "links")
public class LinkEntity implements Serializable {

  private static final long serialVersionUID = 3099824304628229410L;
  @Id
  private long movieid;
  private long imdbid;
  private long tmdbid;

  @OneToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "movieid")
  @MapsId
  @ToString.Exclude
  private MovieEntity movie;

}
