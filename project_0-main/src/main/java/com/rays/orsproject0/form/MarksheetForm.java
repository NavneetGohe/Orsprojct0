package com.rays.orsproject0.form;

import java.sql.Timestamp;
import java.util.Date;

import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotEmpty;

import com.rays.orsproject0.dto.BaseDTO;
import com.rays.orsproject0.dto.MarksheetDTO;;


/**
 * Contains Marksheet form elements and their declarative input validations.
 * 
 * @author Chain of Responsibility
 * @version 1.0
 * 
 */
public class MarksheetForm extends BaseForm{
	
	/**
	 * ROLLNO of Marksheet
	 *
	 */
	@NotEmpty
 @Pattern(regexp="([A-Z]{2}[0-9]{4})*$", message=("{error.roll}"))
	private String rollNo;
	/**
	 * studentId of Marksheet
	 *
	 */
	@Min(value=1,message=("Min.form.studentId"))
	private long studentId;
	/**
	 * studentName of Marksheet
	 *
	 */
	
	private String studentName;
	/**
	 * mathsMarks of Marksheet
	 *
	 */
	
	@NotEmpty
//	@Min(value = 0, message = "marks must be greater than 0")
	//@Max(value = 100, message = "marks must be less than 100")
	@Pattern(regexp ="([0-100])*$", message="Value must be from 0 to 100 only")
    private String maths;
	/**
	 * physicsMarks of Marksheet
	 *
	 */
    
	@NotEmpty
	//@Min(value = 0, message = "marks must be greater than 0")
	//@Max(value = 100)
	@Pattern(regexp ="([0-100])*$", message="Value must be from 0 to 100 only")
private String physics;
	/**
	 * chemistryMarks of Marksheet
	 *
	 */
    
	@NotEmpty
//	@Min(value = 0, message = "marks must be greater than 0")
	//@Max(value = 100, message = "marks must be less than 100")
	@Pattern(regexp ="([0-100])*$", message="Value must be from 0 to 100 only")

	private String chemistry;
	
	public String getRollNo() {
		return rollNo;
	}
	public void setRollNo(String rollNo) {
		this.rollNo = rollNo;
	}
	public long getStudentId() {
		return studentId;
	}
	public void setStudentId(long studentId) {
		this.studentId = studentId;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public String getMaths() {
		return maths;
	}
	public void setMaths(String maths) {
		this.maths = maths;
	}
	public String getPhysics() {
		return physics;
	}
	public void setPhysics(String physics) {
		this.physics = physics;
	}
	public String getChemistry() {
		return chemistry;
	}
	public void setChemistry(String chemistry) {
		this.chemistry = chemistry;
	}

	@Override
	public BaseDTO getDto() {
		MarksheetDTO dto=new MarksheetDTO();
		
		
	//	dto.setId(id);
		dto.setRollNo(rollNo);
		dto.setStudentId(studentId);
		dto.setName(studentName);
		dto.setMaths(maths);
		dto.setChemistry(chemistry);
		dto.setPhysics(physics);
		dto.setCreatedBy(createdBy);
	    dto.setModifiedBy(modifiedBy);
	    dto.setCreatedDatetime(new Timestamp(new Date().getTime()));
	    dto.setModifiedDatetime(new Timestamp(new Date().getTime()));
		return dto;
	}
	
	@Override
	public void populate(BaseDTO bDto) {
		MarksheetDTO dto=(MarksheetDTO) bDto;
		id=dto.getId();
		rollNo=dto.getRollNo();
		studentId=dto.getStudentId();
		studentName=dto.getName();
		maths=dto.getMaths();
		chemistry=dto.getChemistry();
		physics=dto.getPhysics();
		createdBy=dto.getCreatedBy();
	   	modifiedBy=dto.getModifiedBy();
		  if (dto.getCreatedDatetime() != null) {
	          createdDatetime =dto.getCreatedDatetime().getTime();
	      }
	      if (dto.getModifiedDatetime() != null) {
	          modifiedDatetime =dto.getModifiedDatetime().getTime();
	      }
	}
}
