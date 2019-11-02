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
        <td><a href="/user/${user.id}" class="btn btn-outline-secondary btn-sm ml-2">edit</a></td>
        <!-- 20191102 Пытался настроить кнопку удаления пользователе. Кнопка работает
        Удаляет поли в db user_role. Не то что нужно, поэтому закомментировал-->
        <!--<td>
            <form method="post">
                <input type="hidden" value="${user.username}" name="username">
                <input type="hidden" value="${user.id}" name="userId">
                <input type="hidden" value="${_csrf.token}" name="_csrf">
                <button type="submit" class="btn btn-outline-warning btn-sm ml-1">Delete</button>
            </form>
        </td>-->
    </tr>
    <#else>
    No user
    </#list>
    </tbody>
</table>

</@com.page>