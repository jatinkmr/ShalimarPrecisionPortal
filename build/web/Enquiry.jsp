<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Enquiry Management Portal</title>
        <link rel="stylesheet" type="text/css" href="remstyls.css">        
    </head>
    <body bgcolor="#c3cb95">
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
            <center><h2>Enquiry Management Portal</h2></center>
        </div>         
        <div id="imagesR">
            <img src="images/enquiry.jpg" height="400px" width="500px" border="3">
        </div>
        <br/>
        <div class="dtls">
            <center>               
                <form action="enqry" name="myfrm">
                    <font size="4px" face="Lucida Calligraphy" color="#894d10">Enquiry ID</font> <input type="text" name="eid" placeholder="Enter Enquiry ID" value='<%=request.getAttribute("enqid")%>' /><br/><br/>
                    <font size="4px" face="Lucida Calligraphy" color="#894d10">Enquiry Type</font> <input type="text" name="etyp" placeholder="Enter Enquiry Type" value='<%=request.getAttribute("enqtyp")%>'/><br/><br/>
                    <font size="4px" face="Lucida Calligraphy" color="#894d10">Enquiry Question</font> <input type="text" name="eques" placeholder="Enter Enquiry Question" value='<%=request.getAttribute("enques")%>'/><br/><br/>
                    <font size="4px" face="Lucida Calligraphy" color="#894d10">Enquiry Answer</font> <input type="text" name="eans" placeholder="Enter Enquiry Answer" value='<%=request.getAttribute("enans")%>'/><br/><br/> 
                    <input type="submit" name="enqrsb" value="Insert">
                    <input type="submit" name="enqrsb" value="Update">
                    <input type="submit" name="enqrsb" value="Delete">
                    <input type="submit" name="enqrsb" value="Search">
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
