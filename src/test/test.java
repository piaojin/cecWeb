package test;

import java.io.File;
import java.io.IOException;
import java.util.List;

import net.sf.json.JsonConfig;
import net.sf.json.util.PropertyFilter;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import com.piaojin.common.FileUtil;
import com.piaojin.common.Mysshtools;
import com.piaojin.dao.DepartmentDAO;
import com.piaojin.domain.Department;
import com.piaojin.domain.Employ;
import com.piaojin.service.EmployService;

import junit.framework.TestCase;

public class test extends TestCase {

	public void test1() throws IOException{
		DepartmentDAO departmentDAO=(DepartmentDAO) Mysshtools.getAc().getBean("DepartmentDAO");
		List<Department> list=departmentDAO.getAllDepartment();
		for(Department department:list){
			System.out.println(department.getDname());
		}
	}
	
}
