<%@ page import="java.util.List" %>
<%@ page import="com.model.ItemMaster" %>

<h1>Checkout Summary</h1>

<%
    List<ItemMaster> selectedItems = (List<ItemMaster>) request.getAttribute("selectedItems");
    Double totalPrice = (Double) request.getAttribute("totalPrice");
%>

<% if (selectedItems != null && !selectedItems.isEmpty()) { %>
    <table border="1" cellpadding="8" cellspacing="0">
        <thead>
            <tr>
                <th>Item Description</th>
                <th>Price (Rs)</th>
            </tr>
        </thead>
        <tbody>
        <% for (ItemMaster item : selectedItems) { %>
            <tr>
                <td><%= item.getItemdesc() %></td>
                <td><%= item.getItemprice() %></td>
            </tr>
        <% } %>
        </tbody>
        <tfoot>
            <tr>
                <th>Total</th>
                <th><%= totalPrice %></th>
            </tr>
        </tfoot>
    </table>

    <p><strong>Thank you for shopping with us!</strong></p>
<% } else { %>
    <p>No items in the cart.</p>
<% } %>
