<#import "parts/common.ftl" as com>
<#import "parts/login.ftl" as log>

<@com.page>
    Login page
    <@log.login "/login" />
    <a href="/registration">Create new user</a>
</@com.page>