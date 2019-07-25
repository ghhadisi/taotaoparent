<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>用户列表</title>
</head>
<body>
<table align='center' border='1'>
    <caption>用户列表</caption>
    <tbody>
    <tr>
        <th>ID</th>
        <th>name</th>
        <th>age</th>
        <th>salary</th>
    </tr>
               <#-- <#list users as user>
                    <tr>
                        <td>${user.id}</td>
                        <td>${user.username}</td>
                        <td>${user.age}</td>
                        <td>${user.birthday?string("yyyy-MM-dd HH:mm:ss")}</td>
                    </tr>

                </#list>-->

    <#list  users as item>
<#--    <tr>
        <td>${item_index}</td>
        <td>${item.name}</td>
        <td>${user.age}</td>
        <td>${user.salary?c}</td>
    </tr>-->
    </#list>
    <tbody>

</table>

<#list ["winter", "spring"]+[ "summer", "autumn"] as x1>
    ${x1}
</#list>
<br/>

<#--hello ${x}   wolrd ${y}
name:${user.name}    age: ${user.age}   salary:${user.salary}   salary2:${user.salary?c}

<br/>
-----------------------map----------------------<br/>
<#list  map?keys as key >
    ${key}   = ${map[key]}<br/>
</#list>
${map.a}
<br/>
------------------null---------------------
<#if  x?exists >${x} </#if>
<#if  z?exists >
    ${z}
<#else >
    z 不存在
</#if>

<#if  x < 20 > x<20
<#else >
    x > 20
</#if>
${u!}
<br/>
日期:   ${date?date}     ${date?time}     ${date?datetime}       ${date?string("yyyy-MM-dd HH:mm:ss")}

<br/>
<#include  "head.ftl" />
<br/>
-------------macro-----------------<br/>
<#macro greet>
<font size="+2">Hello Joe!</font>
</#macro>
<@greet></@greet>

<#macro green x2>
<font size="+2">Hello Joe! ${x2}</font>
</#macro>
<@green x2=30></@green>

<#macro do_thrice>
    <#nested>
    <#nested>
    <#nested>
</#macro>
<@do_thrice>
Anything.
</@do_thrice>
<#macro repeat count>
    <#list 1..count as x>
        <#nested x, x/2, x==count>
    </#list>
</#macro>

<@repeat count=4 ; c, halfc, last>
    ${c}. ${halfc}<br/>
    <#if last> Last!</#if>
</@repeat>

<br/>
<#assign x = 1> &lt;#&ndash; 创建变量 x &ndash;&gt;
${x}
<#assign x = x + 3> &lt;#&ndash; 替换变量 x &ndash;&gt;
${x}-->
</body>
<#--
可以使用?c 去除千分位

-->
</html>