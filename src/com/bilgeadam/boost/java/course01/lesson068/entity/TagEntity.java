package com.bilgeadam.boost.java.course01.lesson068.entity;

import java.io.Serializable;
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
@ToString
@Entity
@Table(name = "tags")
public class TagEntity implements Serializable {

  private static final long serialVersionUID = 4055913823908486263L;
  @Id
  private long userid;
  // private long movieid;
  private String tag;
  private long timestamp;
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "movieid")
  @ToString.Exclude
  private MovieEntity movieid;
}
