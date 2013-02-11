<%-- 
    Document   : index
    Created on : Feb 3, 2013, 11:52:06 AM
    Author     : Drew
--%>

<%@page import="java.util.List"%>
<%@page import="service.MenuItem"%>
<%@page import="service.RestaurantService"%>
<%@page import="java.text.NumberFormat"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Bill Detail Page</title>
    </head>
    <body>
        <%
            NumberFormat nf = NumberFormat.getCurrencyInstance();
        %>
        <h1>Bill Detail Page</h1>

        <table border="0">
            <tr>
                <td>Item</td>
                <td>Quantity</td>
                <td>Price</td>
            </tr>
            <%
                Object objCurrentOrder = request.getAttribute("currentOrder");


                List<MenuItem> lstCurrentOrder = (List<MenuItem>) objCurrentOrder;
                for (MenuItem m : lstCurrentOrder) {

            %>
            <tr>
                <td><%= m.getItemName()%></td>
                <td><%= m.getItemQuantity()%></td>
                <td><%= nf.format(m.getItemPrice() * m.getItemQuantity())%></td>
            </tr>
            <%
                }
            %>
            <tr>
                <td></td>
                <td>Subtotal</td>
                <td><%=nf.format(request.getAttribute("subtotal"))%></td>
            </tr>
            <tr>
                <td></td>
                <td>Tax</td>
                <td><%=nf.format(request.getAttribute("tax"))%></td>
            </tr>
            <tr>
                <td></td>
                <td>Total</td>
                <td><%=nf.format(request.getAttribute("total"))%></td>
            </tr>
            <tr>
                <td></td>
                <td>Suggested Tip</td>
                <td><%=nf.format(request.getAttribute("suggestedTip"))%></td>
            </tr>
        </table>

    </body>
</html>
