<%-- 
    Document   : index
    Created on : 17/04/2023, 11:50:08 AM
    Author     : Sergi
--%>



<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>   
        <style>
             form {
                font-family: "Times New Roman", Times, serif;
                font-size: 16px;
                line-height: 1.5;
                max-width: 400px;
                padding: 20px;
              }
  
              input[type="text"] {
                display: block;
                margin-bottom: 10px;
                padding: 10px;
                width: 100%;
              }

              input[type="submit"] {
                background-color: #4CAF50;
                border: none;
                color: white;
                cursor: pointer;
                padding: 10px 20px;
                transition: background-color 0.3s ease;
              }

              input[type="submit"]:hover {
                background-color: #3e8e41;
              }
        </style>
    </head>
    <body>
        
        <form name="Registro Entrada" action="./CalcularServlet">
            
            Ingrese su Nombre:<input type="text" name="nombre" value=""/>
            Ingrese su Apellido:<input type="text" name="apellido" value=""/>
            Ingrese su Año de nacimiento en el formato AAAA-MM-DD:<input type="text" name="nacimiento" value=""/>
            <input type="submit" value="ENVIAR" />
        </form>
    </body>
</html>

