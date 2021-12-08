package com.bilgeadam.boost.java.course01.lesson068.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "links")
public class LinkEntity {
  @Id
  private long movieid;
  private long imdbid;
  private long tmdbid;

  @OneToOne(fetch = FetchType.LAZY)
  @JoinTable(name = "movies")
  private MovieEntity movie;
}
