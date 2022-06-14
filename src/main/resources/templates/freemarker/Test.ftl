<#assign keys = testMap?keys>
<#list keys as key>
${key}
${testMap[key]}
</#list>
