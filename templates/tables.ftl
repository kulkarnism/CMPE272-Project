<#include "./header.ftl"> 
<#if container??>
  <div ="${container}">
<#else>
  <div ="default">
</#if>
<form>
<br/>
<#if careerDetails?has_content>
<h1><div align="center">Details of University</div></h1>
<div ="input page">
<div align="center">
 <table class="datatable" border="1" cellpadding="5">
 <#list careerDetails as careerDetails>
     <tr>
     <td id= "one">${careerDetails.getFirstName()}</td>
     <td  id = "two">${careerDetails.getLastName()}</td>
     <td>${careerDetails.getSchoolName()}</td>
     <td>${careerDetails.getOrgName()}</td>      
    </tr> 
  </#list>  
  <div id="piechart_3d" style="width: 900px; height: 500px;"></div>
  </table> 
</div>
<#else>
<h1><div align ="center"><font size=14>
<img src="http://i41.tinypic.com/v5dao7.png"/></div></h1></font>
<h3><div align ="center">Your one stop destination for university search</div></h3>
<h3><div align ="center">Enter the name or part of the name of the university you are looking for</div></h3>
<div align="center"><input type="text" name="searchText" /> <br/><br/>
<input type="submit" value="submit" name="submit" /></div>
</#if>
 <script type="text/javascript" src="https://www.google.com/jsapi"></script>
<script>
var a= document.getElementById("one").textContent;
var b= 5;
document.write(a);  
 google.load("visualization", "1", {packages:["corechart"]});
      google.setOnLoadCallback(drawChart);
      function drawChart() {
        var data = google.visualization.arrayToDataTable([
          ['san', 10],
          ['Work',  2],
          [a,    3],
          ['Commute', 4],
          ['Watch TV', b],
          ['Sleep',    6]
        ]);
         var options = {
          title: 'SJSU Career Prospect',
          is3D: true,
        };

        var chart = new google.visualization.PieChart(document.getElementById('piechart_3d'));
        chart.draw(data, options);
      }
</script>


</form>
<#include "./footer.ftl"> 