package com.piaojin.action;

import java.lang.reflect.ParameterizedType;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.SessionAware;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.piaojin.common.Page;
import com.piaojin.domain.Employ;
import com.piaojin.service.EmployService;
import com.piaojin.service.MessageService;
import com.piaojin.service.MyFileService;
import com.piaojin.service.ScheduleService;
import com.piaojin.service.TaskService;

public abstract class BaseAction<T> extends ActionSupport implements ModelDriven<T>, SessionAware, ServletRequestAware {
	public T model;
	Class<T> clazz;
	public BaseAction(){
		ParameterizedType pt = (ParameterizedType)this.getClass().getGenericSuperclass();
		clazz = (Class<T>) pt.getActualTypeArguments()[0];
		try {
			model = clazz.newInstance();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
	}

	public T getModel() {
		return model;
	}
	
	
	/**
	 * 拿到已登陆用户对� 
	 */
	protected Employ getEmploy(){
		Employ employ = (Employ)session.get("employ");
		return employ;
	}
	
	//====================Service实例的声� ===================
	
	public EmployService employService;
	public MessageService messageService;
    public MyFileService fileService;
    public ScheduleService scheduleService;
    public TaskService taskService;
	

	public MessageService getMessageService() {
		return messageService;
	}

	public void setMessageService(MessageService messageService) {
		this.messageService = messageService;
	}

	public MyFileService getMyFileService() {
		return fileService;
	}

	public void setMyFileService(MyFileService fileService) {
		this.fileService = fileService;
	}

	public ScheduleService getScheduleService() {
		return scheduleService;
	}

	public void setScheduleService(ScheduleService scheduleService) {
		this.scheduleService = scheduleService;
	}

	public TaskService getTaskService() {
		return taskService;
	}

	public void setTaskService(TaskService taskService) {
		this.taskService = taskService;
	}

	public com.piaojin.service.EmployService getEmployService() {
		return employService;
	}

	public void setEmployService(com.piaojin.service.EmployService employService) {
		this.employService = employService;
	}


	//====================分页========================
	/**
	 * 分页相关参数
	 */
	private static final long serialVersionUID = 6230751116897773145L;
	public static final Log log = LogFactory.getLog(BaseAction.class);
	protected Map<String, Object> session;
	protected HttpServletRequest request=ServletActionContext.getRequest();
	protected HttpServletResponse response = ServletActionContext.getResponse();
    protected int pageNum = 1;
    protected int numPerPage = 4;
    protected int totalCount;
    protected int currentPage;
    protected int totalPage;
    protected Page pages;
    
    
    /**
     * 装载当前页数据� 
     * @param hql 查询语句
     * @return Page
     */
    protected <T> Page<T> createPage(Page page){
    	page.setNumPerPage(getNumPerPage());
        page.setPageNum(getPageNum());
        page.setTotalPage(gainTotalPage(page.getTotalCount(),getNumPerPage()));
        setPages(page);
    	return page;
    }
	
    public int gainTotalPage(int totalCount, int rowsperpage) {
		int pages = 0;
        if (totalCount == 0){
            pages = 0;
        }else {
            if (totalCount <= rowsperpage)
                pages = 1;
            if (totalCount > rowsperpage && totalCount % rowsperpage == 0)
                pages = totalCount / rowsperpage;
            if (totalCount > rowsperpage && totalCount % rowsperpage != 0)
                pages = totalCount / rowsperpage + 1;
        }
		return pages;
	}
	

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}

	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	public int getNumPerPage() {
		return numPerPage;
	}

	public void setNumPerPage(int numPerPage) {
		this.numPerPage = numPerPage;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public Page getPages() {
		return pages;
	}

	public void setPages(Page page) {
		this.pages = page;
	}

	public HttpServletRequest getRequest() {
		return request;
	}

	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}

	public Map<String, Object> getSession() {
		return session;
	}
	
	// 获取日期
	public Timestamp getTimestamp() {
	    SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 设置日期格式
		return Timestamp.valueOf(df.format(new Date()).toString());
	}
}
