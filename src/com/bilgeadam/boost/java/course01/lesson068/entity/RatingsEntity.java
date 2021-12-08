package com.bilgeadam.boost.java.course01.lesson068.entity;

import java.sql.Date;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
  private MovieEntity movieid;

  @Override
  public String toString() {
    return "RatingsEntity [userid=" + userid + ", rating=" + rating + ", timestamp="
        + new Date(timestamp) + "]";
  }



}
