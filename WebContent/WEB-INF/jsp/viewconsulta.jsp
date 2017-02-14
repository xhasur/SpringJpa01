<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>IAS PRUEBA</title>
</head>
<body>
<h1 align="center">busqueda</h1>

<p>${msg}</p>
<form  action="consultar.htm">
Nombre
<INPUT TYPE="text" NAME="nombre">
Zona
<select name="zonas">
    <c:forEach items="${zonas}" var="zo">
        <option value="${zo.dsnombre}" ${zo.dsnombre == selected ? 'selected' : ''}>${zo.dsnombre}</option>
    </c:forEach>
</select>
<input type="submit" value="Consultar" align="center"/>



<table>
  <THEAD>
    <TR>
      <TH SCOPE=col ROWSPAN=2>Codigo Ave</TH>
      <TH SCOPE=col ROWSPAN=2>Codigo Pais</TH>
    </TR>
  </THEAD>
  <TBODY>
<c:forEach items="${listaDatos}" var="consulta" varStatus="status">
	
	<tr>
		<td>${consulta.cdave}</td>
		<td>${consulta.cdpais}</td>
	</tr>
</c:forEach>
  </TBODY>
</table>



</form>
</body>
</html>
