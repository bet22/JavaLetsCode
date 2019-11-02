<#import "parts/common.ftl" as com>
<#import "parts/login.ftl" as log>

<@com.page>
${message?ifExists}
<@log.login "/login" false/>
</@com.page>