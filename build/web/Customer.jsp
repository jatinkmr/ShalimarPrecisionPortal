<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Customer Management Portal</title>
        <link rel="stylesheet" type="text/css" href="remstyls.css">
    </head>
    <body bgcolor="##0099ff" text="#12335b">
        <div class="navbar">
            <ul>
                <li><a href="Welcome.jsp">Home</a></li>
                <li><a href="Enquiry.jsp">Enquiry</></li>
                <li><a href="Customer.jsp">Customer</a></li>
                <li><a href="Employee.jsp">Employee</a></li>
                <li><a href="#">Transactions</a>
                    <ul>
                        <li><a href="Inventory.jsp">Inventory</a></li>
                        <li><a href="Sales.jsp">Sales</a></li>
                        <li><a href="Promotion.jsp">Promotion</a></li>
                        <li><a href="Payment.jsp">Payment</a></li>
                    </ul>
                </li>
                <li><a href="about.jsp">About Us</a></li>
                <li><a href="login.jsp">LogOut</a></li>
            </ul>
        </div>
        <div class="header">
            <center><h2>Shalimar Precision Online Enterprise Online Solution</h2></center>
        </div>
        <div style="background-color:#00cc66;clear:both;text-align:center">
            <marquee><b><font color="#12335b">Announcements   >> New Products Has Been
                    Added to Our Portal Regularly.Please Be Updated........</font></b></marquee>
        </div><br/>
        <div class="subhd">
            <center><h2>Customer Management Portal</h2></center>
        </div>
        <div id="images">
            <img src="images/customer_servic.jpg" height="400px" width="500px" border="3">
        </div>
        <br/> 
        <div class="dtls">
            <center>               
                <form action="cstmr" name="myfrm">
                    <font size="4px" face="Lucida Calligraphy" color="#894d10">Customer ID</font> <input type="text" name="cid" placeholder="Enter Customer ID" value='<%=request.getAttribute("csid")%>' /><br/><br/>
                    <font size="4px" face="Lucida Calligraphy" color="#894d10">Customer Name</font> <input type="text" name="cn" placeholder="Enter Customer Name" value='<%=request.getAttribute("cusnm")%>'/><br/><br/>
                    <font size="4px" face="Lucida Calligraphy" color="#894d10">Customer Contact</font> <input type="text" name="ccn" placeholder="Enter Customer Contact" value='<%=request.getAttribute("cuscon")%>'/><br/><br/>
                    <font size="4px" face="Lucida Calligraphy" color="#894d10">Customer Address</font> <input type="text" name="cdd" placeholder="Enter Your Address Here" value='<%=request.getAttribute("cusadd")%>'/><br/><br/>
                    <font size="4px" face="Lucida Calligraphy" color="#894d10">Customer Email</font> <input type="text" name="cml" placeholder="Enter Customer Email" value='<%=request.getAttribute("cuseml")%>'/><br/><br/>
                    <font size="4px" face="Lucida Calligraphy" color="#894d10">Customer City</font> <input type="text" name="cty" placeholder="Enter Customer City" value='<%=request.getAttribute("cuscty")%>'/><br/><br/>
                    <font size="4px" face="Lucida Calligraphy" color="#894d10">Customer State</font> <input type="text" name="ct" placeholder="Enter Customer State" value='<%=request.getAttribute("cusst")%>'/><br/><br/>			
                    <input type="submit" name="cstmrsb" value="Insert">
                    <input type="submit" name="cstmrsb" value="Update">
                    <input type="submit" name="cstmrsb" value="Delete">
                    <input type="submit" name="cstmrsb" value="Search">
                    <input type="reset" value="Clear">
                    <center><h3><%=request.getAttribute("errmsg") %></h3></center>
                </form>
            </center>
        </div>
        <br/>    
        <div class="foot">                      
            <h2>This Project Has Been Developed By Mr. Jatin Kumar "Kamboj" and Copyright © 2011 <a href="#">Shalimar Precision EnterPrise Online Solution</a></h2>
        </div>
    </body>
</html>
