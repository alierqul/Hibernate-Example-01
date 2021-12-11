package com.aliergul.app.entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "links")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class LinkEntity implements Serializable {

  private static final long serialVersionUID = 3099824304628229410L;
  @Id
  private long movieid;
  private long imdbid;
  private long tmdbid;

  @OneToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "movieid")
  @ToString.Exclude
  private MovieEntity movie;

}
