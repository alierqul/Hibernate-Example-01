package com.bilgeadam.boost.java.course01.lesson068.control;

import java.util.ArrayList;

import javax.persistence.TypedQuery;

import org.hibernate.Session;

import com.bilgeadam.boost.java.course01.lesson068.entity.MovieEntity;

public class MovieEntityController implements Controllable<MovieEntity>{
	@Override
	public void create(MovieEntity entity) {
		try {
			Session session = databaseConnectionHibernate();
			session.getTransaction().begin();
			System.out.println(session);
			session.persist(entity);
			session.getTransaction().commit();
			System.out.println("ekleme tamamdýr" + Controllable.class);
		} catch (Exception e) {
			System.out.println("ekleme anýnda hata meydana geldi !!!!! " + Controllable.class);
			e.printStackTrace();
		}
	}
	
	@Override
	public void delete(MovieEntity entity) {
		
		try {
			MovieEntity findEntity = find(entity.getId());
			if (findEntity != null) {
				Session session = databaseConnectionHibernate();
				session.getTransaction().begin();
				session.remove(findEntity);
				session.getTransaction().commit();
				System.out.println("Silme Baþarýlý " + MovieEntity.class);
			}
		} catch (Exception e) {
			System.out.println("silme anýnda hata meydana geldi !!!!! " + Controllable.class);
			e.printStackTrace();
		}
		
	}
	
	@Override
	public void update(MovieEntity entity) {
		try {
			MovieEntity findEntity = find(entity.getId());
			if (findEntity != null) {
				findEntity.setName(entity.getName());
				findEntity.setYear(entity.getYear());
				
				Session session = databaseConnectionHibernate();
				session.getTransaction().begin();
				session.merge(findEntity);
				session.getTransaction().commit();
				System.out.println("Güncelleme Baþarýlý " + MovieEntity.class);
			}
			
		} catch (Exception e) {
			System.out.println("güncelleme anýnda hata meydana geldi !!!!! " + Controllable.class);
			e.printStackTrace();
		}
	}
	
	@Override
	public ArrayList<MovieEntity> list() {
		Session session = databaseConnectionHibernate();
		
		String hql = "select str from MovieEntity as str where str.id>=:key";
		TypedQuery<MovieEntity> typedQuery = session.createQuery(hql, MovieEntity.class);
		
		long id = 1L;
		typedQuery.setParameter("key", id);
		
		ArrayList<MovieEntity> arrayList = (ArrayList<MovieEntity>) typedQuery.getResultList();
		System.out.println("listelendi " + MovieEntity.class);
		return arrayList;
	}
	
	@Override
	public MovieEntity find(long id) {
		Session session = databaseConnectionHibernate();
		MovieEntity entity;
		try {
			entity = session.find(MovieEntity.class, id);
			
			if (entity != null) {
				System.out.println("bulundu... " + entity);
				return entity;
			} else {
				System.out.println("Aradýðýnýz kriterde sonuçlar bulunamadý ...");
				return null;
			}
		} catch (Exception e) {
			System.out.println("find anýnda hata meydana geldi !!!!! " + Controllable.class);
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public MovieEntity singleResult(long id) {
		return Controllable.super.singleResult(id);
	}

}
