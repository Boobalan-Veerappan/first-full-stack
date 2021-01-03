<html>
<head>
<title>
product

</title>
</head>
<body>

Dear <strong>${customer}</strong>

<p>Here product list</p>
<ul>

<#list products as product>
<li><a href=${product.url}> ${product.name}</a></li>
</#list>
</ul>
</body>
</html>
