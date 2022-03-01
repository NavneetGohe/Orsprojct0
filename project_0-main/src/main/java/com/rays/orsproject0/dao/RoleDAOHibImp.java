package com.rays.orsproject0.dao;

import java.sql.Timestamp;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.rays.orsproject0.dto.CourseDTO;
import com.rays.orsproject0.dto.RoleDTO;
import com.rays.orsproject0.dto.UserDTO;



/**
 * @author Navneet
 *
 */
@Repository("roleDAO")
public class RoleDAOHibImp implements RoleDAOInt {

	@Autowired
	SessionFactory sessionFactory;

	public long add(RoleDTO dto) {
		// TODO Auto-generated method stub
		Long pk = (Long) sessionFactory.getCurrentSession().save(dto);
		return pk;
	}

	public void update(RoleDTO dto) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().update(dto);

	}

	public void delete(long id) {
		// TODO Auto-generated method stub
		RoleDTO dto = findByPK(id);
		sessionFactory.getCurrentSession().delete(dto);
	}

	public RoleDTO findByName(String roleName) {
		// TODO Auto-generated method stub
		RoleDTO dto = null;
		List list = sessionFactory.getCurrentSession().createCriteria(RoleDTO.class)
				.add(Restrictions.eq("roleName", roleName)).list();
		if (list.size() == 1) {
			dto = (RoleDTO) list.get(0);
			System.out.println("DTO Not Null");
		}

		return null;
	}

	public RoleDTO findByPK(long pk) {
		RoleDTO dto = null;
		dto = (RoleDTO) sessionFactory.getCurrentSession().get(RoleDTO.class, pk);
		return dto;
	}

	public List search(RoleDTO dto, int pageNo, int PageSize) {
	
		Criteria  crt = sessionFactory.getCurrentSession().createCriteria(RoleDTO.class);
		List list ;
		if(dto != null) {
			 if (dto.getId() > 0) {
	            	System.out.println("reastirvcyion work ");
	            	crt.add(Restrictions.eq("id", dto.getId()));
	            }
	            if (dto.getRoleName() != null && dto.getRoleName().length() > 0) {
	            	crt.add(Restrictions.like("name", dto.getRoleName() + "%"));
	            }
	            if (dto.getRoleDescription() != null && dto.getRoleDescription().length() > 0) {
	            	crt.add(Restrictions.like("duration", dto.getRoleDescription() + "%"));
	            }
		}
		list = crt.list();
		System.out.println(list.size());
		return list;
		
	}
	
	public List sdearch(RoleDTO dto, int pageNo, int pageSize) {
	
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(RoleDTO.class);

		List list=null;

        if (dto != null) {
        	System.out.println("dto in role "+  dto.getId());
            if (dto.getId() > 0) {
            	System.out.println("reastirvcyion work ");
            	criteria.add(Restrictions.eq("id", dto.getId()));
            }
            if (dto.getRoleName() != null && dto.getRoleName().length() > 0) {
            	criteria.add(Restrictions.like("name", dto.getRoleName() + "%"));
            }
            if (dto.getRoleDescription() != null && dto.getRoleDescription().length() > 0) {
            	criteria.add(Restrictions.like("duration", dto.getRoleDescription() + "%"));
            }
        }
// if page size is greater than zero the apply pagination
		if (pageSize > 0) {
			criteria.setFirstResult((pageNo - 1) * pageSize);
			criteria.setMaxResults(pageSize);
		}

		 list = criteria.list();
System.out.println(list.size()+"   sixe chekx ");

Iterator it = list.iterator();
while(it.hasNext()) {
	RoleDTO ro = (RoleDTO) it.next();
	System.out.println(ro.getRoleName());
	
}
			return list;
	}

	public List search(RoleDTO dto) {
		return search(dto, 0, 0);
	}

}
