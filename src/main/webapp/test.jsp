<%--
  Created by IntelliJ IDEA.
  User: 瑾瑜
  Date: 2020/6/6
  Time: 15:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="updateStudent2" method="post">
    id:<input type="text" name="id"/><br>
    name:<input type="text" name="name"/><br>
    age:<input type="text" name="age"/><br>
    sex:<input type="text" name="sex"/><br>
    <input type="submit" value="更新">
</form>

<br/>
<form method="post" action="deleteStudentByIds">
    学生一:<input type="checkbox" name="ids" value="1"><br>
    学生二:<input type="checkbox" name="ids" value="2"><br>
    学生三:<input type="checkbox" name="ids" value="3"><br>
    学生四:<input type="checkbox" name="ids" value="4"><br>
    <input type="submit" value="删除">
</form>

<%--
    删除对象数组时
    1.需要有类包裹一个对象的集合 StudentList
    2.在表单中name 的值为包裹类内部集合的变量名[].属性值 studentList[0].name
--%>
<form method="post" action="deleteStudentByIds2">
    学生一:<br>
        id:<input type="text" name="studentList[0].id"><br>
        name:<input type="text" name="studentList[0].name"><br>
    学生二:<br>
        id:<input type="text" name="studentList[1].id"><br>
        name:<input type="text" name="studentList[1].name"><br>
    <input type="submit" value="删除">
</form>
</body>
</html>
