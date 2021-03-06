package com.cognifide.zg.webapp.componentregistry.core.definition;

import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Reference;
import org.apache.sling.jcr.api.SlingRepository;

import javax.jcr.RepositoryException;
import javax.jcr.Session;

@Component(immediate = true)
public class SessionLogout {

	@Reference
	private SlingRepository repository;

	public void one() {
		Session session = null;
		try {
			session = createAdminSession();
		} finally {
			if (session != null && session.isLive()) {
				session.logout();
			}
		}
	}

	public void two() {
		Session session = null;
		try {
			session = repository.loginAdministrative(null);
		} catch (RepositoryException e) {
			e.printStackTrace();
		} finally {
			if (session != null && session.isLive()) {
				session.logout();
			}
		}
	}

	public void three() {
		Session session = null;
		try {
			session = repository.loginService(null, null);
		} catch (RepositoryException e) {
			e.printStackTrace();
		} finally {
			if (session != null && session.isLive()) {
				session.logout();
			}
		}
	}

	public void four() {
		Session session = null;
		session = createAdminSession();
	}

	public void five() {
		Session session = null;
		try {
			session = repository.loginAdministrative(null);
		} catch (RepositoryException e) {
			e.printStackTrace();
		} finally {
			if (session != null && session.isLive()) {
				//	session.logout();
			}
		}
	}

	public void six() {
		Session session = null;
		try {
			session = repository.loginService(null, null);
		} catch (RepositoryException e) {
			e.printStackTrace();
		} finally {
			if (session != null && session.isLive()) {
				//	session.logout();
			}
		}
	}

	public void seven() {
		Session session = null;
		session = jump();
	}

	private Session createAdminSession() {
		Session result = null;
		try {
			result = repository.loginAdministrative(null);
		} catch (RepositoryException e) {
			e.printStackTrace();
		}
		return result;
	}

	private Session jump() {
		Session result = null;
		result = createAdminSession();
		return result;
	}

	private Session eight() {
		Session max = createAdminSession();
		Session result = max;
		return result;
	}

}