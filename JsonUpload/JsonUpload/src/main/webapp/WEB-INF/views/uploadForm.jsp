<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<script type="text/javascript" src="resources/js/jquery.min.js"></script>
<title>Spring Java</title>
</head>
<body>
 <center>
  <h2 style="color:blue">Please select a file to upload !</h2>
  <br />
  <form:form method="post" enctype="multipart/form-data"
   modelAttribute="uploadedFile" action="fileUpload.htm">
   <table>
    <tr>
     <td>Upload File: </td>
     <td><input type="file" name="file" />
     </td>
     <td style="color: red; font-style: italic;"><form:errors
       path="file" />
     </td>
    </tr>
    <tr>
     <td> </td>
     <td><input type="submit" value="Upload" />
     </td>
     <td> </td>
    </tr>
   </table>
  </form:form>
 </center>
</body>
</html>