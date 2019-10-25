<#import "parts/common.ftl" as com>
<#import "parts/login.ftl" as log>

<@com.page>
<div>
    <@log.logout />
</div>
<div>
    <form method="post">
        <input type="text" name="text" placeholder="Введите сообщение"/>
        <input type="text" name="tag" placeholder="Тэг"/>
        <input type="hidden" name="_csrf" value="${_csrf.token}">
        <button type="submit">Добавить</button>
    </form>
</div>
<div> Список сообщений</div>
<form method="get" action="/main">
    <input type="text" name="filter" value="${filter!}">
    <button type="submit">Найти</button>
</form>
<#list messages as mes>
<div>
    <b>${mes.id}</b>
    <i>${mes.text}</i>
    <span>${mes.tag}</span>
    <strong>${mes.authorName}</strong>
</div>
<#else>
No message
</#list>
</@com.page>