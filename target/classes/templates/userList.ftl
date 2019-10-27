<#import "parts/common.ftl" as com>

<@com.page>
<a href="/main">Main page</a>
<p>User list</p>

<table>
    <thead>
    <tr>
        <th>Name</th>
        <th>Role</th>
        <th></th>
    </tr>
    </thead>
    <tbody>
    <#list users as user>
    <tr>
        <td>${user.username}</td>
        <td><#list user.roles as role>${role}<#sep>, </#list></td>
        <td><a href="/user/${user.id}">Edit</a></td>
    </tr>
    <#else>
    No user
    </#list>
    </tbody>
</table>

</@com.page>