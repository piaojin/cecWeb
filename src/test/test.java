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
import com.piaojin.common.CommonResource;
import com.piaojin.common.FileUtil;
import com.piaojin.common.Mysshtools;
import com.piaojin.dao.DepartmentDAO;
import com.piaojin.domain.Department;
import com.piaojin.domain.Employ;
import com.piaojin.domain.MyFile;
import com.piaojin.domain.Task;
import com.piaojin.service.EmployService;
import com.piaojin.service.MyFileService;
import com.piaojin.service.TaskService;

import junit.framework.TestCase;

public class test extends TestCase {

	public void test1() throws IOException{
		String testjson="{'content':'Fjyhkttfjiybkok','eid':1,'endtime':'2015年04月26日 20:56','starttime':'2015年04月26日 20:36','status':0,'time':'2015-04-28 20:53:18','title':'6','uid':1}";
		Task task=CommonResource.gson.fromJson(testjson, Task.class);
		TaskService taskService=(TaskService) Mysshtools.getAc().getBean("TaskService");
		EmployService employService=(EmployService)Mysshtools.getAc().getBean("EmployService");
		Employ u=employService.getById(task.getUid());
		Employ e=employService.getById(task.getEid());
		task.setEmployByEid(e);
		task.setEmployByUid(u);
		taskService.save(task);
		task=taskService.findTask(task.getTitle());
		task.setKid(task.getTid());
		taskService.update(task);
		System.out.println(CommonResource.gson.toJson(task));
		
	}
	
}
