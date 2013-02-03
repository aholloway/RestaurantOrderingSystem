<%-- 
    Document   : index
    Created on : Feb 3, 2013, 11:52:06 AM
    Author     : Drew
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Restuarant Order Page</title>
    </head>
    <body>
        <h1>Restuarant Order Page</h1>
        <form>
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
                        <td>Qty</td>
                    </tr>
                    <tr>
                        <td>Steak</td>
                        <td><input type="text" name="steakQty" size="5"></td>
                    </tr>
                    <tr>
                        <td>Lobster</td>
                        <td><input type="text" name="lobsterQty" size="5"></td>
                    </tr>
                    <tr>
                        <td>Beer</td>
                        <td><input type="text" name="beerQty" size="5"></td>
                    </tr>
                    <tr>
                        <td>Salad</td>
                        <td><input type="text" name="saladQty" size="5"></td>
                    </tr>
                </table>


                <br />

                <input type="submit" value="Submit">
            </form>
    </body>
</html>
