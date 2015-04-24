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
import com.piaojin.domain.Employ;
import com.piaojin.service.EmployService;

import junit.framework.TestCase;

public class test extends TestCase {

	private EmployService employService;
	public void test1() throws IOException{
		/*JsonConfig jc=new JsonConfig();
		jc.setJsonPropertyFilter(new PropertyFilter() {
			
			public boolean apply(Object arg0, String arg1, Object arg2) {
				// TODO Auto-generated method stub
				return false;
			}
		});*/
		Gson gson = new GsonBuilder()  
        .excludeFieldsWithoutExposeAnnotation() //不导出实体中没有用@Expose注解的属性  
        .setPrettyPrinting().create(); //对json结果格式化.  
		employService = (EmployService) Mysshtools.getAc().getBean("EmployService");
		List<Employ> list = employService.getAllEmploy();
			System.out.println(gson.toJson(list));
		//String listjson=new Gson().toJson(list);
		//FileUtil.WriteFile("D:/tempfile/allemploy.txt",listjson);
	}
	
	class MyTypeAdapter<T> extends TypeAdapter<T> {
	    public T read(JsonReader reader) throws IOException {
	        return null;
	    }

	    public void write(JsonWriter writer, T obj) throws IOException {
	        if (obj == null) {
	            writer.nullValue();
	            return;
	        }
	        writer.value(obj.toString());
	    }
	}
}
