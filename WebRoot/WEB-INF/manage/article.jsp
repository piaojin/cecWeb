<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@   taglib uri="http://ckfinder.com" prefix="ckfinder" %>
<%@   taglib uri="http://ckeditor.com" prefix="ckeditor" %>
<%@ taglib uri ="/struts-tags" prefix ="s" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <base href="<%=basePath%>">

    <title>添加新闻</title>

    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">

    <link rel="stylesheet" href="<%=basePath%>css/bootstrap.min.css"/>
    <script type="text/javascript" src="<%=basePath%>js/jquery-1.8.0.min.js"></script>
    <script type="text/javascript" src="<%=basePath%>js/bootstrap.min.js"></script>
    <script type="text/javascript" charset="utf-8" src="<%=basePath%>js/ueditor.config.js"></script>
    <script type="text/javascript" charset="utf-8" src="<%=basePath%>js/ueditor.all.min.js"></script>
    <script src="<%=basePath%>js/uploadPreview.js" type="text/javascript"></script>
    <link rel="stylesheet" href="<%=basePath%>css/article.css"/>

</head>

<body>
<div class="top">
    <ul>
        <li id="active">文章发表</li>
        <li>文章管理</li>
        <li>更多功能</li>
    </ul>
</div>
<div class="main display">
    <input type="hidden" id="result" value="<s:property value="#request.result"/>"/>
    <form action='artManage-addNews' method='post' enctype="multipart/form-data">
        <input type="hidden" id="isTop" name="isTop" value="false"/>
        <input type="hidden" id="isColmunTop" name="isColmunTop" value="false"/>
        <input type="hidden" id="isIndexTop" name="isIndexTop" value="false"/>
        <input type="hidden" id="isAddress" name="isAddress" value="false"/>

        <div class="type">
            <select name="colId">
                <option value="1">学院首页</option>
                <option value="5">学院概况</option>
                <option value="11">学生工作</option>
                <option value="12">实验室建设</option>
            </select>
            <button class="clean"><i class="icon-remove icon-white"></i> 放弃</button>
        </div>

        <div class="title">
            <span class="myspan">文章标题</span> <input type="text" name="title"/><br/>
            <span class="myspan">作者</span> <input type="text" name="author"/><br/>


            <span class="myspan">标题图片</span><br/>

            <div id="imgdiv" style="display:none;margin-left: 67px;"><img id="imgShow" width="500" height="500"/></div>
            <span class="myspan"><input type="file" id="up_img" name="artImage"/></span><br/>

            <span class="myspan">是否为外部链接<input type="checkbox" id="isAddress_check"
                                               style="width:50px;margin-bottom: 10px;"/></span><br/>
            <span class="myspan">外部链接地址<input type="text" id='outAddress' name='outAddress' disabled></span>


            <span class="myspan">  <input type="checkbox" id="isTop_check" style="width:50px;margin-bottom: 10px;"/>是否头条</span>

            <span class="myspan"> <input type="checkbox" id="isColmunTop_check"
                                         style="width:50px;margin-bottom: 10px;"/>是否在栏目置顶</span>

            <span class="myspan"> <input type="checkbox" id="isIndexTop_check" style="width:50px;margin-bottom: 10px;"/>是否首页置顶</span>
            <br/> <br/> <br/> <br/>

            <div id="contentDiv" style="margin-left: 0px;">
                <textarea cols="80" id="editor1" name="content" rows="10"></textarea>
            </div>
            <br/>
            <span class="myspan">新闻简介<textarea cols="40" name="summary" rows="5"></textarea></span> <br/><br/>

            <button id="addNew" class="submit" style="margin-left: 100px;margin-top: 0px;">发布文章</button>

        </div>
    </form>
</div>
<div class="main">
    <div class="seach">

        <select name="type">
            <option value="">选择一个分类</option>
            <option value="one">分类一</option>
            <option value="two">分类二</option>
            <option value="three">分类三</option>
            <option value="four">分类四</option>
            <option value="five">分类五</option>
        </select>
        <button class="btn-seach"><i class="icon-search icon-white"></i> 搜索</button>
        <input type="text" class="inup-search"/>
    </div>
    <div class="list">
        <table class="table table-striped">
            <thead>
            <tr>
                <th></th>
                <th>新闻标题</th>
                <th>发布人</th>
                <th>发布日期</th>
                <th>操作</th>
            </tr>
            </thead>
            <tbody>
            <tr>
                <td>
                    <div class="check"><img src="img/check2.png" alt=""/></div>
                </td>
                <td>新闻标题新闻标题新闻标题新闻标题新闻标题新闻标题新闻标题</td>
                <td>管理员</td>
                <td>2015/1/28</td>
                <td>
                    <button class="opera"><i class="icon-eye-open icon-white"></i> 查看</button>
                    &nbsp;&nbsp;&nbsp;
                    <button class="opera"><i class="icon-edit icon-white"></i> 编辑</button>
                    &nbsp;&nbsp;&nbsp;
                    <button class="opera"><i class="icon-remove icon-white"></i> 删除</button>
                </td>
            </tr>
            <tr>
                <td>
                    <div class="check"><img src="img/check2.png" alt=""/></div>
                </td>
                <td>新闻标题新闻标题新闻标题新闻标题新闻标题新闻标题新闻标题</td>
                <td>管理员</td>
                <td>2015/1/28</td>
                <td>
                    <button class="opera"><i class="icon-eye-open icon-white"></i> 查看</button>
                    &nbsp;&nbsp;&nbsp;
                    <button class="opera"><i class="icon-edit icon-white"></i> 编辑</button>
                    &nbsp;&nbsp;&nbsp;
                    <button class="opera"><i class="icon-remove icon-white"></i> 删除</button>
                </td>
            </tr>
            <tr>
                <td>
                    <div class="check"><img src="img/check2.png" alt=""/></div>
                </td>
                <td>新闻标题新闻标题新闻标题新闻标题新闻标题新闻标题新闻标题</td>
                <td>管理员</td>
                <td>2015/1/28</td>
                <td>
                    <button class="opera"><i class="icon-eye-open icon-white"></i> 查看</button>
                    &nbsp;&nbsp;&nbsp;
                    <button class="opera"><i class="icon-edit icon-white"></i> 编辑</button>
                    &nbsp;&nbsp;&nbsp;
                    <button class="opera"><i class="icon-remove icon-white"></i> 删除</button>
                </td>
            </tr>
            <tr>
                <td>
                    <div class="check"><img src="img/check2.png" alt=""/></div>
                </td>
                <td>新闻标题新闻标题新闻标题新闻标题新闻标题新闻标题新闻标题</td>
                <td>管理员</td>
                <td>2015/1/28</td>
                <td>
                    <button class="opera"><i class="icon-eye-open icon-white"></i> 查看</button>
                    &nbsp;&nbsp;&nbsp;
                    <button class="opera"><i class="icon-edit icon-white"></i> 编辑</button>
                    &nbsp;&nbsp;&nbsp;
                    <button class="opera"><i class="icon-remove icon-white"></i> 删除</button>
                </td>
            </tr>
            </tbody>
        </table>
        <div id="pagination" class="pagination">
            <ul>
                <li><a href="#"><i class="icon-chevron-left"></i></a></li>
                <li><a href="#">1</a></li>
                <li><a href="#">2</a></li>
                <li><a href="#">3</a></li>
                <li><a href="#">4</a></li>
                <li><a href="#">5</a></li>
                <li><a href="#"><i class="icon-chevron-right"></i></a></li>
            </ul>
        </div>
    </div>
</div>
<ckfinder:setupCKEditor basePath="/cecWeb/ckfinder/" editor="editor1"/>
<ckeditor:replace replace="editor1" basePath="/cecWeb/ckeditor/"/>
<script src="js/article.js" type="text/javascript"></script>
</body>
<script type="text/javascript">
    $(document).ready(function () {
        var result = $('#result').val();
        if(result=='addSuc'){
             alert("成功发布新闻");
        }
        //实现图片的上传浏览功能
        new uploadPreview({ UpBtn: "up_img", DivShow: "imgdiv", ImgShow: "imgShow" });
        $('#isTop_check').click(function () {
            $('#isTop').val(this.checked);
        });
        $('#isColmunTop_check').click(function () {
            $('#isColmunTop').val(this.checked);
        });
        $('#isIndexTop_check').click(function () {
            $('#isIndexTop').val(this.checked);
        });

        $('#isAddress_check').click(function () {
            $('#isAddress').val(this.checked);
            var flag = this.checked;
            if (flag) {
                $('#outAddress').removeAttr('disabled');
                $('#contentDiv').css('display', 'none');
            } else {
                $('#outAddress').attr('disabled', 'disabled');
                $('#contentDiv').css('display', '');
            }
        });

        $('#up_img').change(function () {
            var val = this.value;
            if (val != '') {
                $('#imgdiv').css('display', '');
            } else {
                $('#imgdiv').css('display', 'none');
            }
        });

        $('#addNew').click(function () {
            var res = verify();
            switch (res) {
                case 'title':
                    alert('新闻标题不能为空');
                    return false;
                    break;
                case 'outAddress':
                    alert('请输入外部链接');
                    return false;
                    break;
                case 'content':
                    alert('请输入新闻正文');
                    return false;
                    break;
                case 'summary':
                    alert('请输入简介');
                    return false;
                    break;
                case 'author':
                    alert('请输入发布人名字');
                    return false;
                    break;
                default:
                    return true;

            }
        });

        function verify() {
            var title = $('input[name="title"]').val();
            if (isBlank(title)) {
                return 'title';
            }
            var isAddress = $('#isAddress_check').attr('checked');

            if (isAddress == 'checked') {
                var outAddress = $('input[name="outAddress"]').val();
                if (isBlank(outAddress)) {
                    return 'outAddress';
                }
            } else {
                var content = $('#cke_editor1').val();
                content = 'ss';
                if (isBlank(content)) {
                    return 'content';
                }
            }

            var summary = $('textarea[name="summary"]').val();
            if (isBlank(summary)) {
                return 'summary';
            }

            var author = $('input[name="author"]').val();
            if (isBlank(author)) {
                return 'author';
            }

            return 'suc';
        }

        function isBlank(param) {
            if (param == undefined || param == null || param == '') {
                return true;
            }
            return false;
        }
    });
</script>
</html>
