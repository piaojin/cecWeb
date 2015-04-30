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
		TaskService taskService=(TaskService) Mysshtools.getAc().getBean("TaskService");
		List<Task> list=taskService.getMyTask(1);
		for(Task task:list){
			System.out.println(task.getEmployByUid().getName());
		}
		
	}
	
}
