<#import "parts/common.ftl" as com>

<@com.page>
<#if isCurrentUser>
    <#include "parts/messageEdit.ftl" />
</#if>

<#include "parts/messageList.ftl" />
</@com.page>