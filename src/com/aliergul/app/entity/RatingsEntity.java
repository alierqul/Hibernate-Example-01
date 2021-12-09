package com.aliergul.app.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "ratings")
public class RatingsEntity {
  @Id
  private long userid;
  // private long r_movieid;
  private float rating;
  private long timestamp;
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "movieid")
  @ToString.Exclude
  private MovieEntity movieid;



}
