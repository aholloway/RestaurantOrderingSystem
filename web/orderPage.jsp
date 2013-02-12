<%-- 
    Document   : index
    Created on : Feb 3, 2013, 11:52:06 AM
    Author     : Drew
--%>

<%@page import="dao.*"%>
<%@page import="java.util.*"%>
<%@page import="service.*"%>
<%@page import="java.text.NumberFormat"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    RestaurantService rs = new RestaurantService();
    List<ItemStrategy> menuChoices = rs.getCurrentMenuChoices();
    NumberFormat nf = NumberFormat.getCurrencyInstance();
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Restuarant Order Page</title>
    </head>
    <body>
        <h1>Restuarant Order Page</h1>

        <form name="RestaurantOrderForm" action="RestaurantOrderServlet" 
              method="POST">
            <%-- create a table with item on left and qty on right
                make item on left a drop down selection and qty a field
                that user can enter data into.
                steak, lobster, beer, salad, etc.
            --%>
            <table border="0">
                <tr>
                    <td>Item</td>
                    <td>Price</td>
                    <td>Description</td>
                    <td>Qty</td>
                </tr>
                <%
                    for (ItemStrategy item : menuChoices) {
                %>
                <tr>
                    <td><%= item.getItemName()%></td>
                    <td><%= nf.format(item.getItemPrice())%></td>
                    <td><%= item.getDescription()%></td>
                    <td><input type="text" name="<%= item.getItemName()%>" size="5"></td>
                </tr>
                <%
                    }
                %>


            </table>



            <br />

            <input type="submit" value="Submit">
        </form>
    </body>
</html>
