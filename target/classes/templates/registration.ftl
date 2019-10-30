<#import "parts/common.ftl" as com>
<#import "parts/login.ftl" as log>

<@com.page>
<div class="mb-1">Add new user</div>
    ${message!}
<@log.login "/registration" true/>
</@com.page>