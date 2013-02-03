<%-- 
    Document   : index
    Created on : Feb 3, 2013, 11:52:06 AM
    Author     : Drew
--%>

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
                <td>Quantity   </td>
                <td>Price</td>
            </tr>
            <tr>
                <td>Steak</td>
                <td><%
                    out.print(request.getParameter("steakQty"));
                    %></td>
                <td><%
                    out.print(nf.format(request.getAttribute("steakPrice")));
                    %></td>
            </tr>
            <tr>
                <td>Lobster</td>
                <td>
                    <%
                        out.print(request.getParameter("lobsterQty"));
                    %></td>
                <td><%
                    out.print(nf.format(request.getAttribute("lobsterPrice")));
                    %></td>
            </tr>
            <tr>
                <td>Beer</td>
                <td><%
                    out.print(request.getParameter("beerQty"));
                    %></td>
                <td><%
                    out.print(nf.format(request.getAttribute("beerPrice")));
                    %></td>
            </tr>
            <tr>
                <td>Salad</td>
                <td><%
                    out.print(request.getParameter("saladQty"));
                    %></td>
                <td><%
                    out.print(nf.format(request.getAttribute("saladPrice")));
                    %></td>
            </tr>
            <tr>
                <td>Subtotal</td>
                <td></td>
                <td><%
                    out.print(nf.format(request.getAttribute("subtotal")));
                    %></td>
            </tr>
            <tr>
                <td>Tax</td>
                <td></td>
                <td><%
                    out.print(nf.format(request.getAttribute("tax")));
                    %></td>
            </tr>
            <tr>
                <td>Total</td>
                <td></td>
                <td><%
                    out.print(nf.format(request.getAttribute("total")));
                    %></td>
            </tr>
            <tr>
                <td>Suggested Tip</td>
                <td></td>
                <td><%
                    out.print(nf.format(request.getAttribute("suggestedTip")));
                    %></td>
            </tr>
        </table>

    </body>
</html>
