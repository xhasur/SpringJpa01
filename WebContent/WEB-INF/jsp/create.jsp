<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    </head>
    <body>
        <h1 align="center">Countries</h1>
        <form action="guardar.htm">
            <div align="center">
                <select name='country'>
                    <c:forEach items="${countries}" var="cou" varStatus="status">
                        <option value="${cou.regionId.regionId}" ${cou.countryName == selected ? 'selected' : ''}>${cou.countryName}</option>
                    </c:forEach>
                </select>
            </div>    
            <table align="center">
                <tr>
                    <td><label>Id</label></td>
                    <td><input id="id" name="id" type="text" /></td>
                </tr>
                <tr>

                    <td><label>NAME</label></td>
                    <td><input id="name" name="name" type="text" /></td>
                </tr>
            </table>
            <div align="center">
                <input type="submit" value="Guardar" align="center" />
            </div>    
            <p align="center">${msg}</p>
        </form>
    </body>
</html>
