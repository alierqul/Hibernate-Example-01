package com.aliergul.app.entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long tag_id;
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "userid")
  @ToString.Exclude
  private UserEntity user;
  private String tag;
  private long timestamp;
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "movieid")
  @ToString.Exclude
  private MovieEntity movie;
}
