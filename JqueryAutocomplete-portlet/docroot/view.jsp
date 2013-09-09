<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<link href="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8/themes/base/jquery-ui.css" rel="stylesheet" type="text/css" />
<portlet:defineObjects />

This is the <b>JqueryAutocomplete</b> portlet.

<portlet:resourceURL var="getAutoCompleteData" id="getAutoCompleteData" >
	<portlet:param name="action" value="autocompleteCall"/>
</portlet:resourceURL>

<portlet:actionURL name="submitCourse" var="courseUrl" />

<STYLE TYPE="text/css" media="all">
		.ui-autocomplete { 
			position: absolute; 
			cursor: default; 
			height: 100px; 
			overflow-y: scroll; 
			overflow-x: hidden;
			text-align:left;
		}
	</STYLE>
	
<script type="text/javascript">

function createAutoComplete(fieldName) {
	$('#' + fieldName).autocomplete({
		width: 300,
		max: 10,
		delay: 100,
		minLength: 1,
		minChars:2,
		autoFocus: true,
		cacheLength: 1,
		scroll: true,
		highlight: false,
		source: function(request, response) {
			$.ajax({
        		url: "<%= getAutoCompleteData %>" + "&fieldName=" + fieldName,
        		dataType: "json",
       			data: request,
        		success: function(data, textStatus, jqXHR) {
		    		var items = data;
            		response(items);
        		},
				error: function(jqXHR, textStatus, errorThrown) {
	 				//console.log( textStatus);
				}
    		});
		}
	});
}

$(document).ready(function() {
	createAutoComplete("course");
});

</script>

<form name="fm" method="post" action="<%=courseUrl%>">
	<input type="text" name="course" id="course" value=""/> <br/><br/>
	<input type="submit" />
</form>