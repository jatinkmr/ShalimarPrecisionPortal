<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Shalimar Precision Enterprise Online Solution</title>
        <link rel="stylesheet" type="text/css" href="lgnstyls.css">    
    </head>
    <body>
        <div class="header">
            <center><h1>Shalimar Precision Enterprise Online Solution</h1></center>
        </div>        
        <div class="bck">
            <marquee direction="right"><h3>We Deliver Most Appropriate Auto-Parts To Our Clients At Reasonable Prices SINCE 2011</h3></marquee>
        </div>
        <div class="box">
            <h2>Login</h2>
            <form name="myfrm" action="Wel" method="post">
                <div class="inputbox">
                    <input type="text" name="Usrnm" required>
                    <label>Username</label>
                </div>
                <div class="inputbox">
                    <input type="password" name="psswd" required>
                    <label>Password</label>
                </div>
                <center>
                    <input id="sbmt" type="Submit" name="Submit" value="LogIn" >
                    <a href="UserReg.jsp"><input id="sgn" type="button" name="signin" value="SignIn"></a>
                </center>                
            </form>
            <center><h3><%=request.getAttribute("errmsg") %></h3></center>
        </div>		
        <br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/>
        <div class="foot">        
            <h2>This Project Has Been Developed By Mr. Jatin Kumar "Kamboj" and Copyright © 2011 <a href="#">Shalimar Precision EnterPrise Online Solution</a></h2>
        </div>
    </body>
</html>
