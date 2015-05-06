package com.piaojin.common;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public interface CommonResource {

	public static Gson gson = new GsonBuilder()
			.excludeFieldsWithoutExposeAnnotation() // 不导出实体中没有用@Expose注解的属性
            .create(); // 对json结果格式化.
	public static final String VIDEOPATH = "D:\\Videofile\\";
	public static final String UPLOADPATH = "D:\\uploadFile\\";
	public static final String ALLEMPLOY = "allemploy.txt";
	public static final int SHARED = 0;// 共享
	public static final int PRIVATE = 1; // 私有
	public static final int STATUS_NOT_DOWN = 0;// 文件还未下载
	public static final int STATUS_DOWN = 1;// 文件已经下载
	public static final int STATUSSEND=0;//任务发布出去
	public static final int STATUSACCEPT=1;//接收任务
	public static final int STATUSFINISH=2;//完成任务
}
