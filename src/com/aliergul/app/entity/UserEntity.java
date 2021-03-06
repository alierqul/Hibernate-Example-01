package com.aliergul.app.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


/**
 * SELECT "userUID", user_name, user_email, user_password FROM public.tbl_user; ALTER SEQUENCE
 * product_id_seq RESTART WITH 1453
 * 
 * @author alier
 *
 */
@Data
@NoArgsConstructor
@ToString
@Entity
@Table(name = "tbl_user")
public class UserEntity implements Serializable {
  private static final long serialVersionUID = -6654545850881028337L;
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private int userUID;
  @Column(name = "user_name")
  private String userName;
  @Column(name = "user_email")
  private String userEmail;
  @Column(name = "user_password")
  private String userPassword;

  @OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
  private List<TagEntity> tags = new ArrayList<TagEntity>();

  @OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
  private List<RatingsEntity> ratings = new ArrayList<RatingsEntity>();


  public UserEntity(String userEmail, String userPassword) {
    this.userEmail = userEmail;
    this.userPassword = userPassword;
  }

  public UserEntity(String userName, String userEmail, String userPassword) {
    this.userName = userName;
    this.userEmail = userEmail;
    this.userPassword = userPassword;
  }



}
