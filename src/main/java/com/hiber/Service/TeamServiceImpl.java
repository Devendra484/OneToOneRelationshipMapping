package com.hiber.Service;

import java.lang.reflect.Field;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hiber.Entity.Capitan;
import com.hiber.Entity.IplTeam;
import com.hiber.util.Hibernateutil;

public class TeamServiceImpl implements TeamDao {

	public IplTeam getTeamById(Long Id) {
		Transaction tx = null;
		Session session = null;
		IplTeam iplTeamData = null;

		try {
			session = Hibernateutil.getSessionFactory().openSession();
			tx = session.beginTransaction();

			iplTeamData = session.get(IplTeam.class, Id);
			tx.commit();

		} catch (Exception e) {
			if (tx == null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return iplTeamData;
	}

	public List<IplTeam> getTeams() {
		Transaction tx = null;
		Session session = null;
		List<IplTeam> allTeam = null;
		

		try {
			session = Hibernateutil.getSessionFactory().openSession();
			tx = session.beginTransaction();

			String hql = "from IplTeam";
			Query<IplTeam> allTeamData = session.createQuery(hql);
			tx.commit();
			allTeam = allTeamData.list();

		} catch (Exception e) {
			if (tx == null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return allTeam;
	}

	public void saveTeam(IplTeam team) {
		Transaction tx = null;
		Session session = null;

		try {

			session = Hibernateutil.getSessionFactory().openSession();
			tx = session.beginTransaction();
			session.save(team);

			tx.commit();
			session.close();

		} catch (Exception e) {
			if (tx == null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}

	}

	public void saveCapitan(Capitan cap) {
		Transaction tx = null;
		Session session = null;

		try {

			session = Hibernateutil.getSessionFactory().openSession();
			tx = session.beginTransaction();
			session.save(cap);

			tx.commit();
			session.close();

		} catch (Exception e) {
			if (tx == null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}

	}

	public void updateTeam(IplTeam ipl, Long Id) {
		Transaction tx = null;
		Session session = null;

		try {

			session = Hibernateutil.getSessionFactory().openSession();
			tx = session.beginTransaction();
			IplTeam iplTeam = session.get(IplTeam.class, Id);
			iplTeam.setCapitan(ipl.getCapitan());

			tx.commit();
			session.close();

		} catch (Exception e) {
			if (tx == null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	public void deleteById(long l) {
		Transaction tx = null;
		Session session = null;

		try {

			session = Hibernateutil.getSessionFactory().openSession();
			tx = session.beginTransaction();
			IplTeam iplTeam = session.get(IplTeam.class, l);
			session.delete(iplTeam);
			tx.commit();
			session.close();

		} catch (Exception e) {
			if (tx == null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	public void deleteCap(long l) {
		Transaction tx = null;
		Session session = null;
		try {

			session = Hibernateutil.getSessionFactory().openSession();
			tx = session.beginTransaction();
			Capitan capitan = session.get(Capitan.class, l);
			session.delete(capitan);
			tx.commit();
			session.close();

		} catch (Exception e) {
			if (tx == null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	public void deleteTeam(long l) {
		Transaction tx = null;
		Session session = null;
		try {

			session = Hibernateutil.getSessionFactory().openSession();
			tx = session.beginTransaction();
			IplTeam iplTeam = session.get(IplTeam.class, l);
			session.delete(iplTeam);
			tx.commit();
			session.close();

		} catch (Exception e) {
			if (tx == null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

}
