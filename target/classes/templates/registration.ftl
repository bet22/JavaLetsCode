<#import "parts/common.ftl" as com>
<#import "parts/login.ftl" as log>

<@com.page>
    Add new user
    ${message!}
<@log.login "/registration" />
</@com.page>