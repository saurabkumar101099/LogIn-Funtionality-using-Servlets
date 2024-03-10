<!-- 
<body>

<h3>Register Form </h3>
<form name="f1" action="/WebProject/RegisterServlet" method="post" onsubmit="return validate()">
NAME<input type="text" name="name"> <br>
USERNAME<input type="text" name="username"><br>
PASSWORD<input type="password" name ="password"><br>
RETYPE-PASSWORD<input type="password" name ="retype-password"><br>
<input type="submit" value="REGISTER"><br><br>
</form>
<script type="text/javascript">
function validate(){
	var name=document.f1.name.value;
	 if(name==null||name=""){
		 alert("you cannot leave your username as empty");
		 return false ;
	 }
	 var username=document.f1.username.value;
	 if(username==null||username=""){
		 alert("you cannot leave your username as empty");
		 return false ;
	 }
	 var pass=document.f1.password.value;
	if(pass==null||pass==""){
		 alert("you cannot leave your password as empty");
		 return false;
	}
	 var pass2=document.f1.retype-password.value;
		if(pass==null||pass==""){
			 alert("you cannot leave your retype-password as empty");
			 return false;
		}
		if(pass===pass2){
			alert("password MissMatch");
			return false;
		}
		return true;
	
}
</script>
</body>
-->


<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Register Form</title>
    <style>
        body {
            margin: 0;
            padding: 0;
            height: 100vh;
            display: flex;
            justify-content: center;
            align-items: center;
            font-family: Arial, sans-serif;
            background-color: #f0f0f0; /* Light background color */
        }

        form {
            background-color: #fff; /* White background color */
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            width: 300px;
            text-align: center;
        }

        h3 {
            color: #333;
            text-align: center;
        }

        label {
            display: block;
            margin-bottom: 5px;
            color: #333;
            font-weight: bold;
        }

        input[type="text"],
        input[type="password"] {
            width: 100%;
            padding: 10px;
            margin-bottom: 15px;
            box-sizing: border-box;
            border: 1px solid #ccc;
            border-radius: 4px;
            font-size: 16px;
        }

        input[type="submit"] {
            background-color: #4caf50; /* Green submit button color */
            color: #fff;
            padding: 10px 15px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            font-size: 16px;
        }

        input[type="submit"]:hover {
            background-color: #45a049; /* Darker green on hover */
        }
    </style>
</head>
<body>
    <h3>Register Form</h3>
    <form name="f1" action="/WebProject/RegisterServlet" method="post" onsubmit="return validate()">
        <label for="name">NAME</label>
        <input type="text" name="name" required><br>

        <label for="username">USERNAME</label>
        <input type="text" name="username" required><br>

        <label for="password">PASSWORD</label>
        <input type="password" name="password" required><br>

        <label for="retype-password">RETYPE-PASSWORD</label>
        <input type="password" name="retype-password" required><br>

        <input type="submit" value="REGISTER"><br><br>
    </form>

    <script type="text/javascript">
        function validate() {
            var name = document.f1.name.value;
            var username = document.f1.username.value;
            var pass = document.f1.password.value;
            var pass2 = document.f1['retype-password'].value;

            if (name === null || name === "") {
                alert("You cannot leave your name as empty");
                return false;
            }

            if (username === null || username === "") {
                alert("You cannot leave your username as empty");
                return false;
            }

            if (pass === null || pass === "") {
                alert("You cannot leave your password as empty");
                return false;
            }

            if (pass !== pass2) {
                alert("Password mismatch");
                return false;
            }

            return true;
        }
    </script>
</body>
</html>

