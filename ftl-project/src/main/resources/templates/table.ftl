
<html>
<head>
<style>
table,th,td{
border: 1px solid black;
}
table{
width:100%
}
h3{
color:bule;
text-align:center;
}
td{
text-align:center;
}
</style>
</head>
<body>
<h3>Result Report</h3>
<table>
<thead>
<th>Name
</th>
<th>
USN
</th>
<th>
Email
</th>
<#assign my_sum = 0 />
<#list table.subject as sub>
<th>
${sub.sub}
</th>
</#list>
<th>
Total
</th>
<th>
Result
</th>

</thead>
<tbody>
<td>${table.name}</td>
<td>${table.usn}</td>
<td>${table.email}</td>
<#list table.subject as mark>
<#assign my_sum = my_sum+mark.mark />
<td>
${mark.mark}
</td>
</#list>
<td>
${my_sum}
</td>
<#if (my_sum >= 250)>
<td style="color:green">
Pass
</td>
<#else>
<td style="color:red">
Fail
</td>
</#if>

</td>
</tbody>
</table>
</body>
</html>